<template>
   <div>
     <el-input v-model="keywords" placeholder="请输入内容" style="margin-top: 10px ; width: 300px" size="mini"></el-input>
     <el-button type="primary" icon="el-icon-search" size="mini">搜索</el-button>
     <div style="margin-top: 10px">
       <el-table
         :data="tableData"
         border
         style="width: 100%"
         @selection-change="handleSelectionChange">
         <el-table-column
           type="selection"
           width="55">
         </el-table-column>
         <el-table-column
           prop="date"
           label="日期"
           width="180">
         </el-table-column>
         <el-table-column
           prop="name"
           label="姓名"
           width="180">
         </el-table-column>
         <el-table-column
           prop="address"
           label="地址">
         </el-table-column>
       </el-table>
     </div>
     <div style="margin-top: 10px">
       <el-button type="danger" :disabled="multipleSelection==0"> 批量删除 </el-button>
     </div>
   </div>
</template>

<script>
    export default {
        name: "EmpBasic",

        data() {
        return {
          keywords: '',
          multipleSelection:[],
          tableData: [{
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
          }, {
            date: '2016-05-04',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1517 弄'
          }, {
            date: '2016-05-01',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1519 弄'
          }, {
            date: '2016-05-03',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1516 弄'
          }]
        }
      },methods:{
        handleSelectionChange(val){
          this.multipleSelection=val ;
        }
      }
    }
</script>

<style scoped>

</style>
