<template>
  <div style="width: 100%;height:1000px;padding:40px 40px; background-color: white;border-radius: 4px">
    <div class="moudle_name">管理员管理</div>
    <el-table :data="tableData" border fit stripe style="width: 100%" :cell-style="{ textAlign: 'center' }"
              :header-cell-style="{ textAlign: 'center' }">
<!--      <el-table-column prop="date" label="日期"></el-table-column>-->
      <el-table-column prop="id" label="id"></el-table-column>
      <el-table-column prop="userName" label="姓名"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column prop="password" label="密码"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="gender" label="性别"></el-table-column>
      <el-table-column fixed="right" label="操作">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="block" style="text-align: right;margin-top: 20px">
      <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage1"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="1"
          layout="prev, pager, next"
          :total="1000">
      </el-pagination>
    </div>

  </div>

</template>

<script>
import request from "@/utils/request"
export default {
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
      request.get("/admin/alldata").then((res) => {
        if(res.code === '400'){
          this.tableData = res.data;
        }
        else{
          this.$notify.error(res.msg);
        }
      })
    }

  },
  created() {
    this.load();
  },


  data() {
    return {
      input: "",
      currentPage1: 1,
      tableData: []
    }
  }
}
</script>
