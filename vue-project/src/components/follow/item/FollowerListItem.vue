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
  <tr class="text-center">
    <th scope="row">{{ props.follower.userId }}</th>
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
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
