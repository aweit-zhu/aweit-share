import Home from './pages/HomePage.vue';
import About from './pages/AboutPage.vue';
import MgtByDoor from './pages/MgtByDoor.vue';
import MgtByEmploye from './pages/MgtByEmploye.vue';
import * as VueRouter from 'vue-router';

const routes = [
    { path: '/', component: Home },
    { path: '/about', component: About },
    { path: '/home', component: Home },
    { path: '/mgtByEmploye', component: MgtByEmploye },
    { path: '/mgtByDoor', component: MgtByDoor },
]

const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes, 
})

export default router;