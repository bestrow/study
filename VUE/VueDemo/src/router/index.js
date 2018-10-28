/*
路由器模块
 */
import Vue from 'vue'
import VueRouter from 'vue-router'
import About from '../views/About'
import Home from '../views/Home'
import News from '../views/News'
import Message from '../views/Messsge'
import MessageDetail from '../views/MessageDetail'

Vue.use(VueRouter)

export default new VueRouter({
  // n个路由
  routes: [
    {
      path: '/about',
      component: About
    },
    {
      path: '/home',
      component: Home,
      children: [
        {
          path: '/home/news',
          component: News
        },
        {
          path: 'message',
          component: Message,
          children: [
            {
              path: 'detail/:id',
              component: MessageDetail
            }
          ]
        },
        {
          path: '',
          redirect: 'news'
        }
      ]
    },
    {
      path: '/',
      redirect: '/about'
    }
  ]
})
