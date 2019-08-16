import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import './plugins/element.js'
import _ from "lodash/lodash";

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
