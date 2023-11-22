<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import BoardListItem from "@/components/Board/item/BoardListItem.vue";
import FollowerListItem from "../follow/item/FollowerListItem.vue";

const router = useRouter();
const followers = ref([]);
const user = JSON.parse(sessionStorage.getItem("user"));

const url = import.meta.env.VITE_FOLLOW_FOLOWER_API_URL;

onMounted(() => {
  getFollowers();
});

const getFollowers = () => {
  axios
    .get(url, {
      params: {
        followId: user,
      },
    })
    .then(({ data }) => {
      console.log("followerlist");
      // console.log(data);
      // console.log(user);
      followers.value = data.resdata;
      console.log(followers.value);
      // console.log(url);
      // console.log(user);
    })
    .catch((error) => {
      console.log(error);
    });
};

// const param = ref({
//   //   pgno: currentPage.value,
//   spp: import.meta.env.VITE_ARTICLE_LIST_SIZE,
//   key: "",
//   word: "",
// });

// const currentPage = ref(7);
// const totalPage = ref(35);
// const getArticleList = () => {
//   console.log("서버에서 글목록 얻어오자!!!", param.value);
// };
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">{{ followers.length }}명의 팔로워</mark>
        </h2>
      </div>
      <!-- <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <button type="button" class="btn btn-outline-primary btn-sm" @click="moveWrite">
              글쓰기
            </button>
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm">
                <input
                  type="text"
                  class="form-control"
                  v-model="param.word"
                  placeholder="검색어..."
                />
                <button class="btn btn-dark" type="button" @click="getArticleList">검색</button>
              </div>
            </form>
          </div>
        </div> -->
      <table class="table table-hover">
        <thead>
          <tr class="text-center">
            <th scope="col">팔로워 아이디</th>
            <br />
            <!-- <th scope="col">아이디</th>
            <th scope="col">닉네임</th> -->
          </tr>
        </thead>
        <tbody>
          <br />
          <template v-for="follower in followers">
            <FollowerListItem :follower="follower"> </FollowerListItem>
          </template>
        </tbody>
      </table>
    </div>
    <!-- <PageNavigation
        :current-page="currentPage"
        :total-page="totalPage"
        @pageChange="onPageChange"
      ></PageNavigation> -->
  </div>

  <!-- </div> -->
</template>

<style scoped></style>
