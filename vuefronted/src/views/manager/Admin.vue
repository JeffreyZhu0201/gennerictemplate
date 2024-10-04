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
      <el-button type="success" size="small" style="border-radius: 1px;width: 100px;text-align: center" @click="add">新增</el-button>

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

    <el-dialog title="请填写信息" :visible.sync="dialogVisible" width="40%">
      <el-form :model="form" label-position="right" label-width="100px" style="padding-right: 40px">
        <el-form-item label="用户名">
          <el-input size="small" v-model="form.userName" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group size="small" v-model="form.gender">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input size="small" v-model="form.age" placeholder="请输入手机号"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input size="small" v-model="form.phone" placeholder="请输入手机号"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="dialogVisible = false">取 消</el-button>
        <el-button size="small" type="primary" @click="save">保 存</el-button>
      </div>
    </el-dialog>


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
    load() {
      request.get("/admin/alldata").then((res) => {
        if (res.code === '400') {
          this.tableData = res.data;
        } else {
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
      tableData: [],
      form: {},
      dialogVisible: false,
    }
  }
}
</script>
