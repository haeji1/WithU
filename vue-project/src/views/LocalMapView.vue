<script setup>
import localsitemapVue from "../components/localsite/localsitemap.vue";
import LocalsitePage from "../components/localsite/LocalsitePage.vue";
</script>
<template>
    <div class="container-fluid">
        <div id="map" class="d-flex justify-content-center align-items-center">
            <localsitemapVue></localsitemapVue>
        </div>
        <LocalsitePage></LocalsitePage>
    </div>
</template>

<style scoped>
#map {
    margin-top: 0;
}
</style>
