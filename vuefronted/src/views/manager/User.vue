<template>
  <div class="tabble_ground" style="height: auto">
    <div class="moudle_name">用户管理</div>
    <div class="input_button">
      <div class="input_box">
        <el-input placeholder="请输入查询内容" size="small"  v-model="input" class="input_left"><i slot="suffix" class="el-input__icon el-icon-search"></i></el-input>
      </div>
      <div class="button_box">
        <el-button type="success" size="small" class="button_right">新增</el-button>
      </div>
    </div>
    <el-table :data="tableData" border style="width: 100%" :fit="true" stripe :cell-style="{ textAlign: 'center' }" :header-cell-style="{ textAlign: 'center' }">
      <el-table-column prop="userName" label="姓名"></el-table-column>
      <el-table-column prop="phone" label="手机号"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="gender" label="性别"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block" style="text-align: right;margin-top: 50px">
      <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="prev, pager, next"
          :total="1000">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import request from "@/utils/request";
export default {
  created() {
    this.load();
  },
  // 方法
  methods: {
    handleClick(row) {
      console.log(row);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
    load(){
      request.get("/user/alldata").then(res =>{
        if (res.code === '400'){
          this.tableData = res.data;
        } else {
          this.$notify.error(res.msg)
        }
      })
    }
  },

  data() {
    return {
      input:'',
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4,
      tableData: []
    }
  }
}
</script>