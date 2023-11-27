<script setup>
import { onMounted } from "vue";
// import BoardDetail from "../BoardDetail.vue";
const props = defineProps({ article: Object });
onMounted(() => {
    // console.log("item: " + props.article.content);
    // console.log(props.article.userId);
});
</script>

<template>
    <div class="row">
        <div class="col-md-3">
            <router-link :to="{
                name: 'article-view',
                params: { articleno: props.article.articleNo },
            }" class="article-title link-dark">
                {{ props.article.subject }}
            </router-link>
        </div>
        <div class="col-md-3">
            <router-link :to="{
                name: 'article-view',
                params: { articleno: props.article.articleNo },
            }" class="article-title link-dark">
                {{ props.article.hit }}
            </router-link>
        </div>
        <div class="col-md-3">
            <router-link :to="{
                name: 'article-view',
                params: { articleno: props.article.articleNo },
            }" class="article-title link-dark">
                {{ props.article.userId }}
            </router-link>
        </div>
        <div class="col-md-3">
        <router-link :to="{
            name: 'article-view',
            params: { articleno: props.article.articleNo },
        }" class="article-title link-dark">
            {{ props.article.registerTime }}
        </router-link>
    </div>
</div>

<!-- <tr class="text-center">
                    <td class="text-center">
                                                        <router-link :to="{
                                                            name: 'article-view',
                                                            params: { articleno: props.article.articleNo },
                                                        }" class="article-title link-dark">
                                                            {{ props.article.subject }}
                                                        </router-link>
                                                    </td>
                                                    <td>{{ props.article.userId }}</td>
                                                    <td>{{ props.article.registerTime }}</td>
                                    </tr> -->
</template>

<style scoped>
a {
    text-decoration: none;
}
</style>
