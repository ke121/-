// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store  from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import {postRequest} from './utils/api';
import {putRequest} from './utils/api';
import {deleteRequest} from './utils/api';
import {getRequest} from './utils/api';
import {uploadFileRequest} from './utils/api';
import {initMenu} from "./utils/utils";

Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.prototype.postRequest=postRequest
Vue.prototype.putRequest=putRequest
Vue.prototype.deleteRequest=deleteRequest
Vue.prototype.getRequest=getRequest
Vue.prototype.uploadFileRequest=uploadFileRequest

router.beforeEach((to, from, next) => {
  if(to.path == '/'){
    next();
  }else {
    initMenu(router,store) ;
    next() ;
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
