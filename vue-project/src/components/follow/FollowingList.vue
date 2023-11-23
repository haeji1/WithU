<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import BoardListItem from "@/components/Board/item/BoardListItem.vue";
import FollowingListItem from "../follow/item/FollowingListItem.vue";

const router = useRouter();
const followings = ref([]);
const user = JSON.parse(sessionStorage.getItem("user"));

const url = import.meta.env.VITE_FOLLOW_FOLLOWING_API_URL;

onMounted(() => {
  getFollowings();
});

const getFollowings = () => {
  axios
    .get(url, {
      params: {
        userId: user,
      },
    })
    .then(({ data }) => {
      console.log("followinglist");
      // console.log(data);
      // console.log(user);
      followings.value = data.resdata;
      console.log(followings.value);
      // console.log(url);
      // console.log(user);
    })
    .catch((error) => {
      console.log(error);
    });
};
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <table class="table table-hover">
        <thead>
          <th scope="col">{{ followings.length }}명 팔로우</th>
          <br />
        </thead>
        <tbody>
          <br />
          <template v-for="following in followings">
            <FollowingListItem :following="following"> </FollowingListItem>
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
