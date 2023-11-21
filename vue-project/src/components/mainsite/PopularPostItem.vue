<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import BoardListItem from "@/components/Board/item/BoardListItem.vue";
import BoardListItemIndex from "../Board/item/BoardListItemIndex.vue";

const router = useRouter();
const articles = ref([]);
const user = JSON.parse(sessionStorage.getItem("user"));

const url = import.meta.env.VITE_BOARD_POP_API_URL;

onMounted(() => {
  articles.value.userId = user;
  // console.log(articles.value.userId);
  getArticles();
});

const getArticles = () => {
  axios
    .get(url)
    .then(({ data }) => {
      // console.log(data.resdata);
      // console.log(data);
      articles.value = data.resdata;
      console.log(articles.value);
    })
    .catch((error) => {
      console.log(error);
    });
};

const param = ref({
  //   pgno: currentPage.value,
  spp: import.meta.env.VITE_ARTICLE_LIST_SIZE,
  key: "",
  word: "",
});

// const currentPage = ref(7);
// const totalPage = ref(35);
const getArticleList = () => {
  console.log("서버에서 글목록 얻어오자!!!", param.value);
};

const moveWrite = () => {
  router.push({ name: "article-write" });
};

console.log(articles.value);

</script>

<template>
  <div v-for="article in articles.slice(-3)">
    <BoardListItemIndex :article="article"> </BoardListItemIndex>
    <br>
    <!-- <div class="card mb-3">
                            <img v-bind:src="board.image" class="card-img-top" alt="Image 1" />
                            <div class="card-body">
                              <h5 class="card-title">{{ board.name }}</h5>
                              <p class="card-text" style="font-size: 15px;">{{ board.regiterday }}</p>
                              <p class="card-text">{{ board.content }}</p>
                            </div>
                          </div> -->
    <br>
  </div>
</template>

<style scoped>
.card-text {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  /* 두 줄만 표시하도록 설정 */
  -webkit-box-orient: vertical;
}
</style>
