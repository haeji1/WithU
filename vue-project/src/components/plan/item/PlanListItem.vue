<!-- <script setup>
import { onMounted } from "vue";
// import BoardDetail from "../BoardDetail.vue";
const props = defineProps({ article: Object });
onMounted(() => {
    // console.log("item: " + props.article.content);
    // console.log(props.article.userId);
    console.log(props.article.hit);

});
</script>

<template>
    <tr class="text-center">
        <th scope="row">{{ props.article.planNo }}</th>
        <td class="text-center">
            <router-link :to="{
                name: 'article-view',
                params: { articleno: props.article.articleNo },
            }" class="article-title link-dark">
                {{ props.article.subject }}
            </router-link>
        </td>
        <td>{{ props.article.userId }}</td>
        <td>{{ props.article.hit }}</td>
        <td>{{ props.article.registerTime }}</td>
    </tr>
</template>

<style scoped>
a {
    text-decoration: none;
}
</style> -->
