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
      <table class="table table-hover">
        <thead>
          <!-- <tr class="text-center"> -->
          <th scope="col">{{ followers.length }}명의 팔로워</th>
          <br />
          <!-- <th scope="col">아이디</th>
            <th scope="col">닉네임</th> -->
          <!-- </tr> -->
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

<style scoped>
.center-image {
  text-align: center;
}

.container {
  max-width: 800px;
  margin: 0 auto;
}

.page-header {
  background-color: #f8f9fa;
  padding: 15px;
  border-radius: 5px;
  text-align: center;
}

.page-header mark {
  background-color: #87ceeb; /* 또는 원하는 색상으로 변경 가능 */
  padding: 3px;
}

.action-buttons {
  margin-top: 15px;
}

.action-buttons button {
  margin-right: 10px;
}

.table {
  margin-top: 20px;
}

.table thead th {
  text-align: center;
}

.table tbody tr:hover {
  background-color: #f8f9fa;
}
</style>
