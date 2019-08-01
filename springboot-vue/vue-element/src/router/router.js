//导入路由
import VueRouter from 'vue-router'

import ordinaryUser from '../components/OrdinaryUser.vue'
import adminUser from '../components/AdminUser.vue'
import addAdmin from '../components/AddAdmin.vue'
import Addordinary from '../components/AddOrdinary.vue'

var router = new VueRouter({
    routes: [
        {path: '/', redirect: '/ordinaryUser'},
        {path: '/Addordinary', component: Addordinary},
        {path: '/addAdmin', component: addAdmin},
        {path: '/ordinaryUser', component: ordinaryUser},
        {path: '/adminUser', component: adminUser}
    ]
})

export default router