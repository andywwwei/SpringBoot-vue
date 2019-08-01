<template>
    <div>
        <el-main>
            <el-table :data="tableData">
                <el-table-column label="序号">
                    <template slot-scope="scope">
                        {{ scope.$index+1 }}
                    </template>
                </el-table-column>
                <el-table-column prop="userName" label="姓名">
                </el-table-column>
                <el-table-column prop="userBirthDay" label="出生日期">
                </el-table-column>
                <el-table-column prop="userAddress" label="出生地">
                </el-table-column>
                <el-table-column prop="userPhone" label="手机号码"></el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button type="primary" size="mini" plain @click="editUser(scope.row.id)">修改</el-button>
                        &nbsp;
                        <el-dialog title="修改信息" :visible.sync="dialogFormVisible">
                            <el-form :model="user" :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
                                <el-form-item label="姓名" prop="userName">
                                    <el-col :span="12">
                                        <el-input v-model="user.userName"></el-input>
                                    </el-col>
                                </el-form-item>
                                <el-form-item label="出生日期" required>
                                    <el-col :span="12">
                                        <el-form-item prop="userBirthDay">
                                            <el-date-picker type="date" placeholder="选择日期" v-model="user.userBirthDay"
                                                            style="width: 100%;"
                                                            value-format="yyyy-MM-dd"></el-date-picker>
                                        </el-form-item>
                                    </el-col>
                                    <el-col class="line" :span="2"></el-col>
                                </el-form-item>
                                <el-form-item label="出生地" prop="userAddress">
                                    <el-col :span="12">
                                        <el-input v-model="user.userAddress"></el-input>
                                    </el-col>
                                </el-form-item>
                                <el-form-item label="手机号码" prop="userPhone">
                                    <el-col :span="12">
                                        <el-input v-model="user.userPhone"></el-input>
                                    </el-col>
                                </el-form-item>
                            </el-form>
                            <div slot="footer" class="dialog-footer">
                                <el-button @click="dialogFormVisible = false">取 消</el-button>
                                <el-button type="primary" @click="submitForm('user')">确 定</el-button>
                            </div>
                        </el-dialog>
                        <el-button type="danger" size="mini" plain
                                   @click="deleteById(scope.row.id)">删除
                        </el-button>
                    </template>

                </el-table-column>
            </el-table>
        </el-main>
    </div>
</template>

<script>
    import pathPrefix from '../pathPrefix.js'
    import axios from 'axios'

    export default {
        data() {
            return {
                tableData: [],
                dialogFormVisible: false,
                user: {
                    id: '',
                    userName: '',
                    userAddress: '',
                    userBirthDay: null,
                    userPhone: '',
                    userRole: 2
                }, rules: {
                    userName: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 4, message: '长度在 2 到 4 个字符', trigger: 'blur'}
                    ],
                    userPhone: [
                        {required: true, message: '请输入手机号码', trigger: 'change'}
                    ],
                    userBirthDay: [
                        {required: true, message: '请选择出生日期', trigger: 'change'}
                    ],
                    userAddress: [
                        {required: true, message: '请输入出生地', trigger: 'blur'}
                    ]
                }
            }
        }, created() {
            this.init()
        }, methods: {
            init: function () {
                axios.get(pathPrefix + 'user/findByRole', {
                    params: {
                        role: 2
                    }
                }).then(response => {
                    this.tableData = response.data
                })
            },
            deleteById: function (id) {
                this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.get(pathPrefix + 'user/deleteById', {
                        params: {
                            id
                        }
                    }).then(response => {
                        if (response.data.code == 200) {
                            this.init()
                            this.$message({
                                type: 'success',
                                message: response.data.message
                            });

                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            editUser(id) {
                axios.get(pathPrefix + 'user/findById', {
                    params: {id}
                }).then(response => {
                    if (response != null || response != 'null') {
                        this.dialogFormVisible = true
                        this.user = response.data
                    }
                })
            },
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.dialogFormVisible = false
                        axios.post(pathPrefix + 'user/save', this.user).then(response => {
                                if (response.data.code == 200) {
                                    this.$message({
                                        message: response.data.message,
                                        type: 'success'
                                    });
                                    this.init()
                                } else {
                                    this.$message.error(response.data.message)
                                }
                            }
                        )
                    } else {
                        return false;
                    }
                });
            }
        }

    }
</script>

<style scoped>

</style>