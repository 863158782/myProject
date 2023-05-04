
import VueRouter from 'vue-router'
import homeView from '../view/homeView'
import userList from '../components/UserList'
const router=new VueRouter({
    routes:[
        {
            path:'/Home',
            component:homeView
        },
        {
            path:'/userList',
            component:userList
        }
    ]
})

export default router