<template>
    <div id="app">
        <el-container style="height: 100%;">
            <el-aside width="200px">
                <el-menu :default-openeds="['1', '1']" router>
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-user"></i>用户列表</template>
                        <el-menu-item-group>
                            <template slot="title">管理员</template>
                            <el-menu-item index="/adminUser"> 查看管理员</el-menu-item>
                            <el-menu-item index="/addAdmin">新增管理员</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group>
                            <template slot="title">普通用户</template>
                            <el-menu-item index="/ordinaryUser">查看普通用户</el-menu-item>
                            <el-menu-item index="/addordinary">新增普通用户</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>

                </el-menu>
            </el-aside>
            <el-container>
                <el-header style="text-align: right;">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px;cursor: pointer;"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>修改密码</el-dropdown-item>
                            <el-dropdown-item>修改手机号</el-dropdown-item>
                            <el-dropdown-item>修改信息</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span style="font-size: 14px;">Andy·Wilson</span>
                </el-header>
                <transition name="fade" mode="out-in">
                    <router-view></router-view>
                </transition>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {};
</script>

<style>
    .fade-enter-active, .fade-leave-active {
        transition: opacity .3s;
    }
    .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
        opacity: 0;
    }
</style>
