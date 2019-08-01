// 导入VUE
import Vue from 'vue'
//导入路由
import VueRouter from 'vue-router'
import router from './router/router.js'
// 导入APP组件
import App from './App.vue'
// 导入ElementUI
import ElementUI from 'element-ui'
// 导入ElementUI样式
import 'element-ui/lib/theme-chalk/index.css';
//安装ElementUI
Vue.use(ElementUI);
Vue.use(VueRouter);


Vue.config.productionTip = false

new Vue({
    render: h => h(App),router
}).$mount('#app')