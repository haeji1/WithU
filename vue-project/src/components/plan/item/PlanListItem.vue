<!-- <script setup>
import { onMounted } from "vue";
const props = defineProps({ plan: Object });
onMounted(() => {
});
</script>

<template>
    <tr class="text-center">
        <th scope="row">{{ props.plan.articleNo }}</th>
        <td class="text-center">
            <router-link :to="{
                name: 'plan-view',
                params: { articleno: props.plan.articleNo },
            }" class="article-title link-dark">
                {{ props.plan.subject }}
            </router-link>
        </td>
        <td>{{ props.plan.userId }}</td>
    </tr>
</template>

<style scoped>
a {
    text-decoration: none;
}
</style> -->
