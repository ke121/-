<template>
      <div>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="部门管理" name="first">
            <DeptMana></DeptMana>
          </el-tab-pane>
          <el-tab-pane label="职称管理" name="second">
            <PositionMana></PositionMana>
          </el-tab-pane>
          <el-tab-pane label="职位管理" name="third">
            <JobLevelMana></JobLevelMana>
          </el-tab-pane>
          <el-tab-pane label="奖惩规则" name="fourth">
            <ec></ec>
          </el-tab-pane>
          <el-tab-pane label="权限组" name="five">
            <PermissMana></PermissMana>
          </el-tab-pane>
        </el-tabs>
      </div>
</template>
<script>
  import DeptMana from './basic/DeptMana'
  import EcMana from './basic/EcMana'
  import JobLevelMana from './basic/JobLevelMana'
  import PermissMana from './basic/PermissMana'
  import PositionMana from './basic/PositionMana'
  export default {
    components:{
      DeptMana,
      PositionMana,
      'ec':EcMana,
      JobLevelMana,
      PermissMana
    },
    data() {
      return {
        activeName: 'second'
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>
