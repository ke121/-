<template>
  <div style="display: flex;justify-content:center;margin-top: 200px">
    <el-card style="width: 400px;">
      <div align="left">
        <span>登陆</span>
      </div>
      <div style="margin-top: 20px">
        <table width="100%">
            <tr>
              <td>
                    <el-input v-model="username" placeholder="请输入用户名" />
              </td>
            </tr>
          <tr>
            <td>
              <el-input v-model="password" type="password" placeholder="请输入密码"></el-input>
            </td>
          </tr>
          <tr>
            <td>
              <div align="left">
                <el-button type="primary" align="left" style="width: 270px" @click="login">登陆</el-button>
              </div>

            </td>
          </tr>
        </table>
      </div>
    </el-card>
  </div>

</template>

<script>
    export default {
        name: "Login",
        data() {
          return {
            username: 'tom',
            password: '123'
          }
        },
      methods:{
          login(){
              this.postRequest("/login",{username:this.username,password:this.password}).then(resp=>{
                if(resp.data.status == 200){
                  console.log(resp) ;
                  window.localStorage.setItem("user",JSON.stringify(resp.data.obj)) ;
                  var hh = this.$route.query.hh
                  if(hh){
                    this.$router.replace(hh) ;
                  }else{
                    this.$router.replace('/home') ;
                  }
                }
              })
          }
      }
    }
</script>

<style scoped>

</style>
