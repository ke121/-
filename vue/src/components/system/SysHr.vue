<template>
  <div>
    <el-tabs tab-position="right" style="height: 100%;">
      <el-tab-pane label="用户管理">
        <Hr/>
      </el-tab-pane>
      <el-tab-pane label="邮件管理"><Eamil/></el-tab-pane>
    </el-tabs>
  </div>

</template>

<script>
  import Hr from './operator/Hr'
  import Eamil from './operator/Eamil'
  export default {
    name: "SysHr",
    components:{
      Hr,
      Eamil
    }
  }
</script>

<style scoped>

</style>
