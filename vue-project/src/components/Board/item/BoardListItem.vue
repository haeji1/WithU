<script setup>
import { onMounted } from "vue";

const props = defineProps({ article: Object });
onMounted(() => {
  console.log(props.article.subject);
});
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ props.article.articleNo }}</th>
    <td class="text-start">
      <!-- <router-link
        :to="{ name: 'article-view', params: { articleno: props.article.articleNo } }"
        class="article-title link-dark"
      >
        {{ article.subject }}
      </router-link> -->
    </td>
    <td>{{ props.article.userId }}</td>
    <td>{{ props.article.hit }}</td>
    <!-- <td>{{ article.registerDate }}</td> -->
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
