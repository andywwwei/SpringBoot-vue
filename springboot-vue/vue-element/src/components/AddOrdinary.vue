<template>
    <div>
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
                                        style="width: 100%;"></el-date-picker>
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
            <el-form-item>
                <el-button type="primary" @click="submitForm('user')">新增</el-button>
                <el-button @click="resetForm('user')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import pathPrefix from '../pathPrefix.js'
    import axios from 'axios'

    export default {
        data() {
            return {
                user: {
                    userName: '',
                    userAddress: '',
                    userBirthDay: '',
                    userPhone: '',
                    userRole: 2
                },
                rules: {
                    userName: [
                        {required: true, message: '请输入姓名', trigger: 'blur'},
                        {min: 2, max: 4, message: '长度在 2 到 4 个字符', trigger: 'blur'}
                    ],
                    userPhone: [
                        {required: true, message: '请输入手机号码', trigger: 'change'}
                    ],
                    userBirthDay: [
                        {type: 'date', required: true, message: '请选择出生日期', trigger: 'change'}
                    ],
                    userAddress: [
                        {required: true, message: '请输入出生地', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post(pathPrefix + 'user/save', this.user).then(response => {
                                if (response.data.code == 200) {
                                    this.$message({
                                        message: response.data.message,
                                        type: 'success'
                                    });
                                    setTimeout(function () {
                                        window.location.href = '/#/ordinaryUser'
                                    }, 3000)
                                } else {
                                    this.$message.error(response.data.message);
                                }
                            }
                        )
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>