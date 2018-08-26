<template>
      <div>
        <div>
          <el-input v-model="jname" placeholder="请输入内容" size="mini" style="width: 280px;"></el-input>
          <el-select v-model="titleLevel" placeholder="请选择父菜单" size="mini" style="width: 180px" >
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          <el-button type="primary" size="mini" @click="addJl">添加职称</el-button>
        </div>
        <div>
          <el-table
            :data="jls"
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
              prop="titlelevel"
              label="级别">
            </el-table-column>
            <el-table-column
              label="创建日期"
              width="240">
              <template slot-scope="scope">
                {{scope.row.createdate | formatDate}}
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
        name: "JobLevelMana" ,
      data(){
        return{
          jls:[] ,
          jname:'' ,
          titleLevel:'' ,
          options: [{
            value: '初级',
            label: '初级'
          }, {
            value: '中级',
            label: '中级'
          }, {
            value: '副高级',
            label: '副高级'
          }, {
            value: '正高级',
            label: '正高级'
          }],
          value: ''
        }
      },
        mounted(){
          this.initJobLevel();
        },
      methods:{
        addJl(){
          this.postBodyRequest("/system/basic/jobLevel/",{name:this.jname,titlelevel:this.titleLevel}).then(resp=>{
              if(resp && resp.status == 200){
                this.initJobLevel() ;
              }
          })
        },
        initJobLevel(){
          this.getRequest("/system/basic/jobLevel/").then(resp=>{
            if(resp && resp.status==200){
              this.jls = resp.data ;
            }
          })
        },
      }

    }
</script>

<style scoped>

</style>
