<script setup>
defineProps({ notice: Object });
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ notice.noticeNo }}</th>
    <td class="text-start">
      <router-link
        :to="{ name: 'notice-view', params: { noticeno: notice.noticeNo } }"
        class="notice-title link-dark"
      >
        {{ notice.subject }}
      </router-link>
    </td>
    <td>{{ notice.userName }}</td>
    <td>{{ notice.hit }}</td>
    <td>{{ notice.registerDate }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
