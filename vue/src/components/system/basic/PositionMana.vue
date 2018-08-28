<template>
  <div>
    <el-dialog
      title="添加职位"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <div>
        职位名称  <el-input v-model="name" placeholder="请输入内容" size="mini" style="width: 180px"></el-input>
      </div>
      <div>
        <el-switch
          v-model="enabled"
          active-text="可用"
          @change="enabledchanged"
          inactive-text="不可用" style="margin-top: 30px">
        </el-switch>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="addP">确 定</el-button>
  </span>
    </el-dialog>
    <div>
      <el-input v-model="pname" placeholder="输入职位名称" size="mini" style="width: 280px;">
        <el-button slot="append" icon="el-icon-search" @click="searchPosition"></el-button>
      </el-input>
      <el-button type="primary" size="mini" @click="showAddP">添加职位</el-button>
    </div>
    <div>
      <el-table
        :data="positions"
        border
        stripe
        style="width: 60%">
        <el-table-column
          prop="id"
          label="编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="名称"
          width="180">
        </el-table-column>
        <el-table-column
          label="创建日期"
          width="240">
          <template slot-scope="scope">
            {{scope.row.createdate | formatDate}}
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div>

    </div>
  </div>
</template>

<script>
    export default {
      name: "PositionMana",
      data(){
        return{
          positions:[] ,
          pname:'' ,
          dialogVisible: false,
          enabled:true,
          name:'' ,
        }
      },
      mounted(){
        this.initPosition();
      },
      methods:{
        searchPosition(){
            this.getRequest("/system/basic/position/?keywords="+ this.pname).then(resp=>{
              if(resp && resp.status ==200){
                this.positions = resp.data ;
              }
            });
        },
        enabledchanged(status){
          this.enabled = status ;
        },
        addP(){
          if(this.name.length == 0){
            this.$message({
              type:'warning',
              message:'名称不能为空'
            })
          }else {
            this.postRequest("/system/basic/position/",{name:this.name,enabled:this.enabled}).then(resp=>{
              if(resp && resp.status == 200){
                this.initPosition() ;
                this.dialogVisible = false ;
              }
            })
          }

        },
        showAddP(){
          this.dialogVisible=true ;
        },
        handleEdit(index, row) {
          console.log(index, row);
        },
        handleDelete(index, row) {
          console.log(index, row);
        },
        initPosition(){
          this.getRequest("/system/basic/position/").then(resp=>{
            if(resp && resp.status==200){
              this.positions = resp.data ;
            }
          })
        },
      }

    }
</script>

<style scoped>

</style>

