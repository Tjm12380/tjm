import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import gongyingshang from '@/views/modules/gongyingshang/list'
    import shangpinxinxi from '@/views/modules/shangpinxinxi/list'
    import kehuxinxi from '@/views/modules/kehuxinxi/list'
    import lirunpaixingbang from '@/views/modules/lirunpaixingbang/list'
    import menu from '@/views/modules/menu/list'
    import xiaoshouxinxi from '@/views/modules/xiaoshouxinxi/list'
    import cangguan from '@/views/modules/cangguan/list'
    import xiaoshouyuan from '@/views/modules/xiaoshouyuan/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import tuihuoxinxi from '@/views/modules/tuihuoxinxi/list'
    import kehutuihuo from '@/views/modules/kehutuihuo/list'
    import jinhuoxinxi from '@/views/modules/jinhuoxinxi/list'
    import xiaoliangpaixingbang from '@/views/modules/xiaoliangpaixingbang/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/gongyingshang',
        name: '供应商',
        component: gongyingshang
      }
      ,{
	path: '/shangpinxinxi',
        name: '商品信息',
        component: shangpinxinxi
      }
      ,{
	path: '/kehuxinxi',
        name: '客户信息',
        component: kehuxinxi
      }
      ,{
	path: '/lirunpaixingbang',
        name: '利润排行榜',
        component: lirunpaixingbang
      }
      ,{
	path: '/menu',
        name: '菜单列表',
        component: menu
      }
      ,{
	path: '/xiaoshouxinxi',
        name: '销售信息',
        component: xiaoshouxinxi
      }
      ,{
	path: '/cangguan',
        name: '仓管',
        component: cangguan
      }
      ,{
	path: '/xiaoshouyuan',
        name: '销售员',
        component: xiaoshouyuan
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/tuihuoxinxi',
        name: '退货信息',
        component: tuihuoxinxi
      }
      ,{
	path: '/kehutuihuo',
        name: '客户退货',
        component: kehutuihuo
      }
      ,{
	path: '/jinhuoxinxi',
        name: '进货信息',
        component: jinhuoxinxi
      }
      ,{
	path: '/xiaoliangpaixingbang',
        name: '销量排行榜',
        component: xiaoliangpaixingbang
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
