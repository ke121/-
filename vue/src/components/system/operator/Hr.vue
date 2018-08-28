<template>
    <div>
      <div style="padding-left: 300px;padding-top: 20px">
        <el-input size="mini" style="width: 400px" placeholder="请输入用户名" v-model="keywords" >
        </el-input>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="searchHr">搜索</el-button>
      </div>
      <div style="display: flex;flex-wrap: wrap ; justify-content: center">
        <el-card class="box-card" v-for="(hr,index) in hrs" style="margin: 10px ; width: 350px" :key="index+''">
          <div slot="header" class="clearfix">
            <span>{{hr.name}}</span>
            <el-button style="float: right; padding: 3px 0;color: red" type="text" icon="el-icon-delete"></el-button>
          </div>
          <div>
            <div style="display: flex;justify-content: center">
              <img :src="hr.userface" alt="用户头像" style="width: 80px;height:80px ; border-radius:80px">
            </div>
            <div>
              用户名：<span>{{hr.name}}</span>
            </div>
            <div>
              手机号码：<span>{{hr.phone}} </span>
            </div>
            <div>
              电话号码：<span>{{hr.telephone}} </span>
            </div>
            <div>
              地址： <span>{{hr.address}}</span>
            </div>
            <div>
              用户状态：<el-switch
              v-model="hr.enabled"
              @change="enabledChange(hr.id,hr.enabled)"
              active-text="可用"
              inactive-text="禁用">
            </el-switch>
            </div>
            <div>
              用户角色：<el-tag type="success" v-for="(role,indexj) in hr.roles" :key="indexj" size="mini">{{role.nameZh}}</el-tag>
              <el-popover
                placement="right"
                title="角色列表"
                width="300"
                @show="showPopper(hr.roles)"
                @hide="hidePopper(hr.id)"
                trigger="click">
                <el-select   v-model="roleSelect" multiple placeholder="请选择角色">
                  <el-option
                    v-for="item in roles"
                    :key="item.id"
                    :label="item.nameZh"
                    :value="item.id">
                  </el-option>
                </el-select>
                <el-button icon="el-icon-more" slot="reference" size="mini" type="text"></el-button>
              </el-popover>
            </div>
            <div>
              备注：{{hr.remark}}
            </div>
          </div>
        </el-card>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Hr",
      data(){
        return {
          keywords:'',
          hrs:[],
          roleSelect:[],
          roles:[] ,
          rolesId: '',
        }
      },
      methods:{
        enabledChange(id,enabled){
          this.putRequest("/system/hr/?enabled=" + enabled + "&id=" + id)
        },
        initRoles(){
          this.getRequest("/system/hr/roles").then(resp=>{
            if(resp && resp.status == 200){
              this.roles = resp.data ;
            }
          })
        },
        showPopper(roles){
          this.initRoles() ;
          this.roleSelect = [];
          for(var i = 0 ; i < roles.length ; i++){
            this.roleSelect[i] = roles[i].id ;
          }
        },
        hidePopper(id){
          if(this.roleSelect.length==0){
            this.$message({
              message: '至少要有一个角色',
              type: 'warning'
            });
          }else {
            for(var i = 0 ; i < this.roleSelect.length ; i++){
              this.rolesId += this.roleSelect[i]+',' ;
            }
            this.putRequest("/system/hr/roles?rolesId=" + this.rolesId + "&id=" + id).then(resp=>{
              if(resp && resp.status== 200){
                this.roleSelect = [] ;
                this.roles = [] ;
                this.rolesId = '' ;
                this.initHrs();
              }
            })
          }
        },
        initHrs(){
          this.getRequest("/system/hr/").then(resp=>{
            if(resp && resp.status == 200){
              this.hrs = resp.data;
            }
          })
        }
      },
      mounted(){
        this.initHrs() ;
      }
    }
</script>

<style scoped>

</style>
