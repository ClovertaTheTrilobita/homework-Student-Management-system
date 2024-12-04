<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="课程ID" prop="courseId">
        <el-input
          v-model="queryParams.courseId"
          placeholder="请输入课程ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学生ID" prop="studentId">
        <el-input
          v-model="queryParams.studentId"
          placeholder="请输入学生ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="分数" prop="score">
        <el-input v-model="queryParams.score" placeholder="请输入分数" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="是否及格 " prop="isPass">
        <el-select v-model="queryParams.isPass" placeholder="请选择是否及格" clearable>
          <el-option v-for="dict in dict.type.stu_transcript_is_pass" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="课程名称" prop="courseName">
        <el-input
          v-model="queryParams.courseName"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="选课课程" prop="course">
        <el-select v-model="queryParams.course" placeholder="请选择课程" clearable>
          <el-option v-for="course in courseList" :key="course.id" :label="course.name" :value="course.id" />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="学生名称" prop="studentName">
        <el-input
          v-model="queryParams.studentName"
          placeholder="请输入学生名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="选课学生" prop="studentId">
        <el-select v-model="queryParams.studentId" placeholder="请选择学生" clearable>
          <el-option v-for="student in studentList" :key="student.id" :label="student.name" :value="student.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option v-for="dict in dict.type.stu_class_status" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="逻辑删除" prop="isDel">
        <el-select v-model="queryParams.isDel" placeholder="请选择逻辑删除" clearable>
          <el-option v-for="dict in dict.type.sys_yes_no" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['system:transcript:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['system:transcript:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['system:transcript:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['system:transcript:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="transcriptList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="成绩ID" align="center" prop="id" />
      <el-table-column label="课程ID" align="center" prop="courseId" /> -->
      <el-table-column label="学生ID" align="center" prop="studentId" />
      <el-table-column label="分数" align="center" prop="score" />
      <el-table-column label="是否及格" align="center" prop="isPass">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.stu_transcript_is_pass" :value="scope.row.isPass" />
        </template>
      </el-table-column>
      <el-table-column label="课程名称" align="center" prop="courseName" />
      <el-table-column label="学生名称" align="center" prop="studentName" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.stu_class_status" :value="scope.row.status" />
        </template>
      </el-table-column>
      <el-table-column label="逻辑删除" align="center" prop="isDel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_yes_no" :value="scope.row.isDel" />
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['system:transcript:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['system:transcript:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改成绩对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="课程ID" prop="courseId">
          <el-input v-model="form.courseId" placeholder="请输入课程ID" />
        </el-form-item> -->
        <!-- <el-form-item label="学生ID" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生ID" />
        </el-form-item> -->
        <el-form-item label="分数" prop="score">
          <el-input v-model="form.score" placeholder="请输入分数" />
        </el-form-item>
        <el-form-item label="是否及格 " prop="isPass">
          <el-select v-model="form.isPass" placeholder="请选择是否及格 ">
            <el-option v-for="dict in dict.type.stu_transcript_is_pass" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="课程名称" prop="courseName">
          <el-input v-model="form.courseName" placeholder="请输入课程名称" />
        </el-form-item> -->
        <el-form-item label="课程" prop="courseId">
          <el-select v-model="form.courseId" placeholder="请选择第几节">
            <el-option v-for="course in courseList" :key="course.id" :label="course.name"
              :value="parseInt(course.id)"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="学生名称" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入学生名称" />
        </el-form-item> -->
        <el-form-item label="学生姓名" prop="studentId">
          <el-select v-model="form.studentId" placeholder="请选择第几节">
            <el-option v-for="student in studentList" :key="student.id" :label="student.name"
              :value="parseInt(student.id)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option v-for="dict in dict.type.stu_class_status" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="逻辑删除" prop="isDel">
          <el-select v-model="form.isDel" placeholder="请选择逻辑删除">
            <el-option v-for="dict in dict.type.sys_yes_no" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTranscript, getTranscript, delTranscript, addTranscript, updateTranscript } from "@/api/system/transcript";
import { listStudent } from "@/api/system/student";
import { listCourse } from "@/api/system/course";

export default {
  name: "Transcript",
  dicts: ['stu_transcript_is_pass', 'sys_yes_no', 'stu_class_status'],
  data() {
    return {
      studentList: [],
      courseList: [],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 成绩表格数据
      transcriptList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseId: null,
        studentId: null,
        score: null,
        isPass: null,
        courseName: null,
        studentName: null,
        status: null,
        isDel: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getCourseList();
    this.getStudentList();
  },
  methods: {
    getCourseList() {
      this.loading = true;
      listCourse().then(response => {
        this.courseList = response.rows;
        this.loading = false;
      });
    },
    getStudentList() {
      this.loading = true;
      listStudent().then(response => {
        this.studentList = response.rows;
        this.loading = false;
      });
    },
    /** 查询成绩列表 */
    getList() {
      this.loading = true;
      listTranscript(this.queryParams).then(response => {
        this.transcriptList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        courseId: null,
        studentId: null,
        score: null,
        isPass: null,
        courseName: null,
        studentName: null,
        status: null,
        createTime: null,
        updateTime: null,
        isDel: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加成绩";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTranscript(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改成绩";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTranscript(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTranscript(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除成绩编号为"' + ids + '"的数据项？').then(function () {
        return delTranscript(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/transcript/export', {
        ...this.queryParams
      }, `transcript_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
