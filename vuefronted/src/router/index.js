import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/manager/HomeView.vue'

Vue.use(VueRouter)



const routes = [
    {
        path: '/manager', name: 'manager', component: () => import('@/views/ManagerLayout.vue'),
        children: [
            {path: 'home', component: () => import('../views/manager/HomeView.vue'),},
            {path: 'admin', component: () => import('../views/manager/Admin.vue')},
            {path: 'user', component: () => import('../views/manager/User.vue'),},
        ]
    },
    {
        path: '/register', name: 'register', component: () => import('@/views/Register.vue'),
    },
    {
        path: '/login', name: 'login', component: () => import('@/views/Login.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

// 路由守卫
router.beforeEach((to ,from, next) => {
    if (to.path === '/') {
        return next("/login");
    }
    let user = localStorage.getItem("user");
    if (!user && to.path !== '/login' && to.path !== '/register' && to.path !== '/front/index') {
        return next("/login");
    }
    next();
})

export default router
