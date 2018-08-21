import {getRequest} from './api'

/**
 * 用来初始化菜单数据
 *
 * routes是定义在store中的路由数据，如果它的长度大于0，表示store中有菜单数据，否则下载菜单json
 * @param router
 * @param store
 */
export const initMenu = (router, store) => {
  if (store.state.routes.length > 0) {
    return;
  }
  getRequest("/config/menus").then(resp => {
    if (resp && resp.status == 200) {
      var fmtRoutes = formatRoutes(resp.data);
      console.log(fmtRoutes) ;
      router.addRoutes(fmtRoutes);
      //更新store中的菜单数据
      store.commit('initMenu', fmtRoutes);
    }
  })
}
/**
 * 对返回的json进行处理，转成路由格式
 * @param routes  下载到的json字符串
 * @returns {Array}
 */
export const formatRoutes = (routes) => {
  let fmRoutes = [];
  routes.forEach(router => {
    let {
      path,
      component,
      name,
      meta,
      iconCls,
      children
    } = router;
    if (children && children instanceof Array) {
      children = formatRoutes(children);
    }
    let fmRouter = {
      path: path,
      component(resolve) {
        if (component.startsWith("Home")) {
          require(['../components/' + component + '.vue'], resolve)
        } else if (component.startsWith("Emp")) {
          require(['../components/emp/' + component + '.vue'], resolve)
        } else if (component.startsWith("Per")) {
          require(['../components/personnel/' + component + '.vue'], resolve)
        } else if (component.startsWith("Sal")) {
          require(['../components/salary/' + component + '.vue'], resolve)
        } else if (component.startsWith("Sta")) {
          require(['../components/statistics/' + component + '.vue'], resolve)
        } else if (component.startsWith("Sys")) {
          require(['../components/system/' + component + '.vue'], resolve)
        }
      },
      name: name,
      iconCls: iconCls,
      meta: meta,
      children: children
    };
    fmRoutes.push(fmRouter);
  })
  return fmRoutes;
}
