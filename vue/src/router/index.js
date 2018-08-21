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
      hidden:true
    },{
      path: '/home',
      name: 'Home',
      component: Home,
      hidden:true
    } ]
})
