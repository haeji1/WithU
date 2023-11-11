import { createRouter, createWebHistory } from "vue-router";
import IndexView from "../views/IndexView.vue";
import RegisterForm from "../components/Member/RegisterForm.vue";
import LocalMapView from "../views/LocalMapView.vue";
import LoginForm from "../components/Member/LoginForm.vue";
import TheNoticeView from "../views/TheNoticeView.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "index",
      component: IndexView,
    },
    {
      path: "/notice",
      name: "notice",
      component: TheNoticeView,
    },
    {
      path: "/board",
      name: "board",
      // component: TheBoardView,
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/TheBoardView.vue"),
      redirect: { name: "article-list" },
      children: [
        {
          path: "list",
          name: "article-list",
          component: () => import("@/components/Board/BoardList.vue"),
        },
        // {
        //   path: "view/:articleno",
        //   name: "article-view",
        //   component: () => import("@/components/board/BoardDetail.vue"),
        // },
        {
          path: "write",
          name: "article-write",
          component: () => import("@/components/Board/BoardWrite.vue"),
        },
        // {
        //   path: "modify/:articleno",
        //   name: "article-modify",
        //   component: () => import("@/components/board/BoardModify.vue"),
        // },
      ],
    },
    {
      path: "/member",
      name: "member",
      children: [
        {
          path: "/member/login",
          name: "login",
          component: LoginForm,
        },
        {
          path: "/member/register",
          name: "register",
          component: RegisterForm,
        },
      ],
    },
    {
      path: "/map",
      name: "map",
      component: LocalMapView,
    },
  ],
});

export default router;
