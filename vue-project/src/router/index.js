import { createRouter, createWebHistory } from "vue-router";
import IndexView from "../views/IndexView.vue";
import RegisterView from "../views/RegisterView.vue";
import LocalMapView from "../views/LocalMapView.vue";
import LoginView from "../views/LoginView.vue";
import MypageForm from "../components/Member/MypageForm.vue";
import TheNoticeView from "../views/TheNoticeView.vue";
import FollowerList from "../components/follow/FollowerList.vue";
import FollowingList from "../components/follow/FollowingList.vue";
import FollowDetail from "../components/follow/FollowDetail.vue";

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
          path: "article-list",
          name: "article-list",
          component: () => import("@/components/Board/BoardList.vue"),
        },
        {
          path: "article-view/:articleno",
          name: "article-view",
          component: () => import("@/components/board/BoardDetail.vue"),
        },
        {
          path: "article-write",
          name: "article-write",
          component: () => import("@/components/Board/BoardWrite.vue"),
        },
        {
          path: "article-modify/:articleno",
          name: "article-modify",
          component: () => import("@/components/board/BoardModify.vue"),
        },
        {
          path: "article-modify/:articleno",
          name: "article-modify",
          component: () => import("@/components/board/BoardModify.vue"),
        },
      ],
    },
    {
      path: "/notice",
      name: "notice",
      // component: TheBoardView,
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/TheNoticeView.vue"),
      redirect: { name: "notice-list" },
      children: [
        {
          path: "notice-list",
          name: "notice-list",
          component: () => import("@/components/notice/NoticeList.vue"),
        },
        {
          path: "notice-view/:noticeno",
          name: "notice-view",
          component: () => import("@/components/board/BoardDetail.vue"),
        },
        {
          path: "notice-write",
          name: "notice-write",
          component: () => import("@/components/notice/NoticeWrite.vue"),
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
          component: LoginView,
        },
        {
          path: "/member/register",
          name: "register",
          component: RegisterView,
        },
        {
          path: "/member/mypage",
          name: "mypage",
          component: MypageForm,
        },
       
      ],
    },
    {
      path: "/map",
      name: "map",
      component: LocalMapView,
    },
    {
      path: "/plan",
      name: "plan",
      component: () => import("../views/PlanView.vue"),
      redirect: { name: "plan-list" },
      children: [
        {
          path: "plan-list",
          name: "plan-list",
          component: () => import("@/components/plan/PlanList.vue"),
        },
        {
          path: "plan-view/:articleno",
          name: "plan-view",
          component: () => import("@/components/plan/PlanDetail.vue"),
        },
        {
          path: "plan-write",
          name: "plan-write",
          component: () => import("@/components/plan/PlanWrite.vue"),
        },
        {
          path: "plan-modify/:articleno",
          name: "plan-modify",
          component: () => import("@/components/plan/PlanModify.vue"),
        },
      ],
    },
    {
      path: "/follower",
      name: "follower",
      component: FollowerList,
    },
    {
      path: "/follwing",
      name: "following",
      component: FollowingList,
    },
    {
      path: "/followdetail/:followId",
      name: "follow-detail",
      component: FollowDetail,
    },
 
  ],
});
export default router;