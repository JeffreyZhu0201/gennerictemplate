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
            {path:'user',component: () => import('../views/manager/User.vue'),},
        ]
    },
    {
        path:'/register',name: 'register',component:()=>import('@/views/Register.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
