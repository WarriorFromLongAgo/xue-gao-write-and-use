import App from './App'

// 如果不等于 vue3
// #ifndef VUE3
import Vue from 'vue'
import './uni.promisify.adaptor'

Vue.config.productionTip = false

// 定义全局方法
Vue.prototype.globalMethod_doSomeThing = function () {
    // 全局方法的逻辑
    let str = "mainJs globalMethod_doSomeThing"
    console.log(str)
    return str
}

App.mpType = 'app'
const app = new Vue({
    ...App
})
app.$mount()
// #endif
