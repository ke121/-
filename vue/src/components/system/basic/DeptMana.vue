<template>
      <div>
        <el-input
          placeholder="输入关键字进行过滤"
          v-model="filterText"
          size="mini"
        style="width: 300px">
        </el-input>
        <el-tree
          :data="deps"
          show-checkbox
          node-key="id"
          default-expand-all
          ref="tree2"
          :filter-node-method="filterNode"
          :props="defaultProps"
          :expand-on-click-node="true"
          :render-content="renderContent"
       >
        </el-tree>
        <el-dialog
          title="添加部门"
          :visible.sync="dialogVisible"
          width="30%"
        >
          <div>
            <table>
              <tr>
                <td>父菜单 &nbsp;</td>
                <td>
                  <el-select v-model="depId" placeholder="请选择父菜单">
                  <el-option
                    v-for="item in depNoTrees"
                    :key="item.id"
                    :label="item.name"
                    :value="item.id">
                  </el-option>
                </el-select>
                </td>
              </tr>
              <tr>
                <td>部门名字</td>
                <td><el-input v-model="depName" placeholder="请添加部门名"></el-input></td>
              </tr>
            </table>

          </div>
          <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false" >取 消</el-button>
    <el-button type="primary" @click="doAddDep">确 定</el-button>
  </span>
        </el-dialog>
      </div>
</template>

<script>
    export default {
        name: "DeptMana",
      data() {
        return {
          depName:'',
          filterText:'',
          depNoTrees:[],
          depId:'',
          dialogVisible:false ,
            deps:[],
          defaultProps: {
              id:'id' ,
            children: 'children',
            label: 'name'
          }
        }
      },mounted(){
        this.initDps() ;
      },
      watch: {
        filterText(val) {
          this.$refs.tree2.filter(val);
        }
      },
      methods: {

          doAddDep(){
              this.postRequest("/system/basic/dep/",{parentid:this.depId,name:this.depName}).then(resp=>{
                if(resp && resp.status == 200){
                  this.initDps() ;
                  this.dialogVisible=false ;
                }
              })

          },
        filterNode(value, data) {
          if (!value) return true;
          return data.name.indexOf(value) !== -1;
        },
        deleDep(data){
          event.stopPropagation() ;
          console.log(data) ;
          if(data.isparent){
            this.$message({
              type: 'warning',
              message: '该部门下有子部门，请先删除子部门',
            });
          }else {
            this.deleteRequest("/system/basic/dep/?id=" + data.id).then(resp=>{
              if(resp && resp.status == 200){
                this.initDps() ;
                this.dialogVisible=false ;
              }
            })
          }

        },
          showAddTree(data,event){
            this.dialogVisible= true ;
            event.stopPropagation() ;
            this.depId = data.id ;
            this.initDepNoTree() ;
          },
          initDepNoTree(){
            this.getRequest("/system/basic/dep/getAllDeps").then(resp=>{
                if(resp && resp.status == 200){
                  this.depNoTrees = resp.data ;
                }
            })
          },
          initDps(){
              this.getRequest("/system/basic/dep/").then(resp=>{
                  if(resp && resp.status==200){
                    console.log(resp.data) ;
                    this.deps = resp.data ;
                  }
              })
          },
        append(data) {
          const newChild = { id: id++, label: 'testtest', children: [] };
          if (!data.children) {
            this.$set(data, 'children', []);
          }
          data.children.push(newChild);
        },

        remove(node, data) {
          const parent = node.parent;
          const children = parent.data.children || parent.data;
          const index = children.findIndex(d => d.id === data.id);
          children.splice(index, 1);
        },
        renderContent(h, { node, data, store }) {
          return (
            <span class="custom-tree-node" style="flex: 1; display: flex; align-items: center;justify-content: space-between; font-size: 14px;  padding-right: 900px;">
            <span>{node.label}</span>
          <span>
          <el-button size="mini"  style="margin: 0px;padding:2px" type="primary" on-click={ () => this.showAddTree(data,event) }>添加部门</el-button>
          <el-button size="mini" style="margin: 0px;padding:2px" type="danger" on-click={ () => this.deleDep(data, event) }>删除部门</el-button>
          </span>
          </span>);
        }
      }
    };
</script>

<style scoped>

</style>
