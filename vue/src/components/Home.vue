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
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>员工管理</span>
            </template>
            <el-menu-item index="/basic">员工基本信息</el-menu-item>
            <el-menu-item index="/salary">员工工资</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>系统管理</span>
            </template>
            <el-menu-item index="/role">角色管理</el-menu-item>
            <el-menu-item index="/user">用户管理</el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>
      <el-main>
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
      },methods: {
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
