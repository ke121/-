<template>
   <div>
     <el-input v-model="keywords" placeholder="请输入内容" style="margin-top: 10px ; width: 300px" size="mini" @keydown.enter.native="search"></el-input>
     <el-button type="primary" icon="el-icon-search" size="mini" @click="search" >搜索</el-button>
     <el-button type="primary" icon="el-icon-download" size="mini" @click="exportExcel">export员工基本资料</el-button>
     <div style="margin-top: 10px">
       <el-table
         :data="empData"
         border
         style="width: 100%"
         @selection-change="handleSelectionChange">
         <el-table-column
           type="selection"
           width="55">
         </el-table-column>
         <el-table-column
           prop="id"
           label="编号"
           width="55">
         </el-table-column>
         <el-table-column
           prop="name"
           label="姓名"
           width="150">
         </el-table-column>
         <el-table-column
           prop="gender"
           label="性别"
         width="55">
         </el-table-column>
         <el-table-column
           label="出生日期"
         width="240">
           <template slot-scope="scope">
             {{scope.row.birthday | formatDate}}
           </template>
         </el-table-column>
         <el-table-column
           prop="idcard"
           label="身份证号码"
         width="175">
         </el-table-column>
         <el-table-column
           prop="wedlock"
           label="婚姻状况"
         width="78">
         </el-table-column>
         <el-table-column
           prop="nation.name"
           label="民族"
         width="55">
         </el-table-column>
         <el-table-column
           prop="nativeplace"
           label="籍贯"
         width="55">
         </el-table-column>
         <el-table-column
           prop="email"
           label="电子邮件"
         width="180">
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
     <div style="margin-top: 10px;display: flex;justify-content: space-between">
       <el-button type="danger" :disabled="multipleSelection==0" @click="deletemany"> 批量删除 </el-button>
       <el-pagination
         background
         @current-change="pagechange"
         @size-change="pagesizechange"
         layout="sizes,prev, pager, next,jumper"
         :total="1000">
       </el-pagination>
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
          empData: [],
          currentPage:1,
          pageSize:10,
        }
      },
      mounted(){
        this.initEmp() ;
      },
      methods:{
        exportExcel(){
          window.open("/employee/basic/export","_parent") ;
        },
        deletemany(){
          this.$confirm('此操作将删除' + this.multipleSelection.length + '条记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            var ids = '' ;
            for(var i = 0 ; i < this.multipleSelection.length ; i ++){
              ids += this.multipleSelection[i].id+',' ;
            }
            this.dodelete(ids) ;
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })})
        },
        dodelete(ids){
          this.deleteRequest("/employee/basic/emp/"+ ids).then(resp=>{
            if(resp&& resp.status==200){
              this.initEmp() ;
            }
          }) ;
        },
        search(){
          this.initEmp() ;
        },
        pagesizechange(pagesize){
          this.pageSize = pagesize;
          this.initEmp()
        },
        pagechange(page){
          this.currentPage = page ;
          this.initEmp() ;
        },
        handleSelectionChange(val){
          this.multipleSelection=val ;
        },
        handleEdit(index, row) {
          console.log(index, row);
        },
        handleDelete(index, row) {
          this.$confirm('此操作将删除该员工, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.dodelete(row.id);
          }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消删除'
              })})
            },
        initEmp(){
          this.getRequest("/employee/basic/emp?currentPage="+this.currentPage + "&pageSize="+this.pageSize+"&keywords="+this.keywords).then(resp=>{
              if(resp && resp.status==200){
                this.empData = resp.data ;
              }
          })
        }
      }
    }
</script>

<style scoped>

</style>
