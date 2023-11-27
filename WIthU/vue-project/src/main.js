import './assets/main.css'

import { createApp } from 'vue'
// import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'


import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'



// JS SDK init
// const KAKAKO_API_KEY = '768f3c11c8418faef2861489f9b4b0eb';
// window.Kakao.init(KAKAKO_API_KEY);
const app = createApp(App)


// app.use(createPinia())
app.use(router)
app.mount('#app')