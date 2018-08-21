import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //routes用来存放格式化之后的路由数据
    routes: []
  },
  mutations: {
    initMenu(state, menus){
      state.routes = menus;
    }
  },
});
