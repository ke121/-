<template>
  <el-container>
    <el-header style="background-color: #24d3ff;display: flex;justify-content: space-between;align-content: center;height: 80px">
      <div style="font-size: 25px;font-family: 华文行楷	;display: flex;align-items: center">
        欢迎来到百威尚美食管理系统
      </div>
      <div style="display: flex;align-items: center;margin-right: 40px">

        <el-dropdown @command="handleCommand">
  <span class="el-dropdown-link" style="display: flex;align-items: center;justify-content: center; cursor:pointer">
    {{user.name}} <i><img :src="user.userface" alt="userface" width="40px" height="40px" style="border-radius: 40px"></i>
  </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="usercenter">个人中心</el-dropdown-item>
              <el-dropdown-item command="setting">设置</el-dropdown-item>
              <el-dropdown-item  command="logout" divided>退出</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>

      </div>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu
          @select="handleSelect"
          class="el-menu-vertical-demo">
          <el-submenu :index="index.toString()" v-for="(route,index) in this.routes" :key="index"  v-if="route.hidden!=true">
            <template slot="title">
              <i :class=route.iconCls></i>
              <span>{{route.name}}</span>
            </template>
            <el-menu-item :index="child.path" v-for="(child,index2) in  route.children" :key="index2">{{child.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <el-breadcrumb separator-class="el-icon-arrow-right" v-if="this.$router.currentRoute.name!='Home'">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
        </el-breadcrumb>
        <div v-if="this.$router.currentRoute.path == '/home'" style="display: flex;justify-content: center;margin-top: 150px;font-size: 40px;font-family: '微软雅黑 Light'">
          欢迎来到百威美食尚餐饮管理系统
        </div>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
    export default {
        name: "Home",
      data() {
        return {
          user:JSON.parse(window.localStorage.getItem("user"))
        }
      },
      computed:{
        routes(){
          return this.$store.state.routes ;
        }
      }
      ,methods: {
        handleCommand(command) {
          if(command == 'logout'){
            this.$confirm('此操作将注销用户, 是否继续?', '注销', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              this.$message({
                type: 'success',
                message: '注销成功!'
              }
            ),this.getRequest("/logout") ;
                window.localStorage.removeItem("user") ;
                this.$router.replace("/")
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消注销'
              });
            });
          }
        },
        handleSelect(index,indexPath){

            this.$router.push(index) ;
        }
      }
    }
</script>

<style scoped>

</style>
