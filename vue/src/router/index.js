import Vue from 'vue'
import Router from 'vue-router'
import Login from  '@/components/Login'
import Hello from  '@/components/Hello'
import  BasicInfo from   '@/components/BasicInfo'
import  RoleInfo from   '@/components/RoleInfo'
import  SalaryInfo from   '@/components/SalaryInfo'
import  UserInfo from   '@/components/UserInfo'
import  Home from   '@/components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden:true
    },{
      path: '/hello',
      name: 'Hello',
      component: Hello,
    },{
      path: '/home',
      name: 'Home',
      component: Home
    }, {
      path: '/home',
      name: '员工管理',
      component: Home,
      children:[
        {
          path: '/basic',
          name: '基本信息',
          component: BasicInfo
        },{
          path: '/salary',
          name: '员工工资',
          component: SalaryInfo
        }
      ]
    },{
      path: '/home',
      name: '员工管理',
      component: Home,
      children:[
        {
          path: '/role',
          name: '角色管理',
          component: RoleInfo
        },{
          path: '/user',
          name: '用户管理',
          component: UserInfo
        }
      ]
    }
  ]
})
