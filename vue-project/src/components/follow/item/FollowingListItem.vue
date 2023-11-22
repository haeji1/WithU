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
  <tr class="text-center">
    <!-- <th scope="row">{{ props.following.followId }}</th> -->
    <th scope="row">
      <router-link :to="{ name: 'follow-detail', params: { followId: props.following.followId } }">
        {{ props.following.followId }}
      </router-link>
    </th>
    <td class="text-center">
      <!-- <router-link
          :to="{
            name: 'article-view',
            params: { articleno: props.article.articleNo },
          }"
          class="article-title link-dark"
        >
          {{ props.article.subject }}
        </router-link> -->
    </td>
    <!-- <td>{{ props.article.userId }}</td>
      <td>{{ props.article.registerTime }}</td> -->
  </tr>

  <!-- <div class="card w-50">
    <div class="card-body">
      <h5 class="card-title">{{ props.following.followId }}</h5>
      <p class="card-text"></p>
      <a href="#" class="btn btn-primary">Button</a>
    </div>
  </div> -->
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
