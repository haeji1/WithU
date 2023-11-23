<script setup>
import { onMounted } from "vue";
// import BoardDetail from "../BoardDetail.vue";
const props = defineProps({ following: Object });
onMounted(() => {
  console.log("----");
  console.log("item: " + props.following.followId);
  // console.log(props.article.userId);
});
</script>

<template>
  <div class="mb-3 d-flex justify-content-center">
    <div class="card w-50">
      <div class="card-body" style="text-align: center">
        <img
          src="@/assets/profile.png"
          alt="로고"
          width="150"
          height="150"
          class="d-inline-block align-top"
          style="border-radius: 50%"
        />
        <h5 class="card-title">{{ props.following.followId }}</h5>
        <p class="card-text"></p>
        <router-link
          :to="{ name: 'follow-detail', params: { followId: props.following.followId } }"
          class="btn btn-pink"
        >
          <!-- {{ props.following.followId }} -->
          게시글보기
        </router-link>
        <!-- <button class="btn btn-pink" @click="onFollowUser">게시글보기</button> -->
        <!-- <a href="#" class="btn btn-primary">Button</a> -->
      </div>
    </div>
  </div>
  <!-- <tr class="text-center">
    <th scope="row">{{ props.following.followId }}</th>
    <th scope="row">
      <router-link :to="{ name: 'follow-detail', params: { followId: props.following.followId } }">
        {{ props.following.followId }}
      </router-link>
    </th>
    <td class="text-center"></td>
  </tr> -->
</template>

<style scoped>
a {
  text-decoration: none;
}

.card {
  width: 300px;
  margin: 0 auto;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s; /* 마우스 호버 시 부드러운 효과를 위한 CSS 속성 추가 */
}

.card:hover {
  transform: scale(1.05); /* 마우스 호버 시 크기를 약간 확대하는 효과 */
}

.card-body {
  text-align: center;
}

.card img {
  border-radius: 50%;
  margin-bottom: 10px;
}

.card-title {
  font-size: 1.5em;
  margin-bottom: 10px;
}

.btn-pink {
  background-color: #ff69b4;
  color: #fff;
  border: none;
  transition: background-color 0.3s; /* 마우스 호버 시 부드러운 색상 전환을 위한 효과 */
}

.btn-pink:hover {
  background-color: #ff4f9e;
}
.btn-pink {
  background-color: #ff69b4; /* 핑크색 */
  color: #fff;
  border: none;
}

.btn-pink:hover {
  background-color: #ff4f9e; /* 핑크색 (hover 시) */
}
</style>
