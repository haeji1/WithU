<script setup>
import { onMounted } from "vue";
// import BoardDetail from "../BoardDetail.vue";
const props = defineProps({ follower: Object });
onMounted(() => {
  console.log("----");
  console.log("item: " + props.follower.userId);
  // console.log(props.article.userId);
});
</script>

<template>
  <!-- <tr class="text-center">
    <th scope="row">{{ props.follower.userId }}</th>
    <td class="text-center">
      </td>
      </tr> -->
  <!-- <router-link
          :to="{
            name: 'article-view',
            params: { articleno: props.article.articleNo },
          }"
          class="article-title link-dark"
        >
          {{ props.article.subject }}
        </router-link> -->

  <!-- <td>{{ props.article.userId }}</td>
      <td>{{ props.article.registerTime }}</td> -->

  <!-- <div class="card w-50">
    <div class="card-body">
      <h5 class="card-title">{{ props.follower.userId }}</h5>
      <p class="card-text"></p>
      <a href="#" class="btn btn-primary">Button</a>
    </div>
  </div> -->
  <div class="mb-3 d-flex justify-content-center">
    <div class="card w-50">
      <div class="card-body">
        <h5 class="card-title">{{ props.follower.userId }}</h5>
        <p class="card-text"></p>
        <!-- <a href="#" class="btn btn-primary">Button</a> -->
      </div>
    </div>
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
