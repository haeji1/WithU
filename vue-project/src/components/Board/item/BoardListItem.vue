<script setup>
import { onMounted } from "vue";
// import BoardDetail from "../BoardDetail.vue";
const props = defineProps({ article: Object });
onMounted(() => {
  console.log("item: " + props.article.content);
});
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ props.article.articleNo }}</th>
    <td class="text-start">
      <router-link
        :to="{
          name: 'article-view',
          params: { articleno: props.article.articleNo },
        }"
        class="article-title link-dark"
      >
        {{ props.article.subject }}
      </router-link>
    </td>
    <td>{{ props.article.userId }}</td>
    <td>{{ props.article.hit }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
