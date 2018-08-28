<template>
  <div>
    <div>
      <el-input size="mini" style="width: 270px" placeholder="请输入角色英文名" v-model="rolename" >
        <template slot="prepend">ROLE_</template>
      </el-input>
      <el-input size="mini" style="width: 180px" placeholder="请输入角色中文名" v-model="rolenameZh" >
      </el-input>
      <el-button type="primary" icon="el-icon-plus" size="mini" @click="addRole">添加</el-button>
    </div>
    <div>
      <el-collapse v-model="activeName" accordion @change="collapseChange" style="width: 480px">
        <el-collapse-item :title="role.nameZh " :name="role.id" v-for="(role,index) in roles" :key="index+''">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>可访问的资源</span>
              <el-button type="danger" icon="el-icon-delete" circle style="float: right" size="mini"></el-button>
            </div>
            <div>
              <el-tree
                :data="menus"
                show-checkbox
                node-key="id"
                :default-checked-keys="menuChecked"
                :props="defaultProps">
              </el-tree>
            </div>
          </el-card>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
    export default {
      name: "PermissMana",
      data(){
        return {
          rolename:'',
          rolenameZh:'',
          menus:[],
          menuChecked:[],
          activeName: '1',
          roles:[],
          defaultProps: {
            children: 'children',
            label: 'name'
          }
        }
      },
      mounted(){
        this.initPermission() ;
      },
      methods:{
        addRole(){
          if(this.rolename.length == 0 || this.rolenameZh.length == 0){
            this.$message({
              type: 'error',
              message: "角色不能为空"
            })
          }else {
            if(this.rolename)
            this.postRequest("/system/basic/permission/addRole",{name:this.rolename,nameZh:this.rolenameZh}).then(resp=>{
              if(resp && resp.status ==200){
                this.initPermission() ;
                this.rolename = '' ;
                this.rolenameZh = '' ;
              }
            })
          }
        },
        collapseChange(id){
          this.initMenus() ;
          this.getMenuIdByRid(id) ;
        },
        getMenuIdByRid(id){
          this.getRequest("/system/basic/permission/menusChecked?rid=" + id).then(resp=>{
            if(resp && resp.status == 200){
              this.menuChecked= resp.data ;
            }
          })
        },
        initMenus(){
          this.getRequest("/system/basic/permission/menus").then(resp=>{
            if(resp && resp.status == 200){
              this.menus = resp.data ;
            }
          })
        },
        initPermission(){
          this.getRequest("/system/basic/permission/").then(resp=>{
              if(resp && resp.status == 200){
                    this.roles = resp.data ;
              }
          })
        }
      }
    }
</script>

<style scoped>

</style>
