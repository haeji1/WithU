<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
// import PlanListItem from "../plan/item/PlanListItem.vue";

const router = useRouter();
const articles = ref([]);
const user = JSON.parse(sessionStorage.getItem("user"));

const url = import.meta.env.VITE_PLAN_API_URL;

onMounted(() => {
    articles.value.userId = user;
    getArticles();
});

const getArticles = () => {
    axios
        .get(url)
        .then(({ data }) => {
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
    router.push({ name: "plan-write" });
};

// console.log(articles.value);
</script>

<template>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <h2 class="my-3 py-3 shadow-sm bg-light text-center">
                    <mark class="sky">글목록</mark>
                </h2>
        </div>
        <div class="col-lg-10">
            <div class="row align-self-center mb-2">
                <div class="col-md-2 text-start">
                        <button type="button" class="btn btn-outline-primary btn-sm" @click="moveWrite">
                            글쓰기
                        </button>
                    </div>
                    <div class="col-md-5 offset-5">
                        <form class="d-flex">
                            <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
                            <div class="input-group input-group-sm">
                                <input type="text" class="form-control" v-model="param.word" placeholder="검색어..." />
                                <button class="btn btn-dark" type="button" @click="getArticleList">검색</button>
                            </div>
                        </form>
                    </div>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr class="text-center">
                            <th scope="col">글번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                            <th scope="col">여행일</th>
                            <th scope="col">작성일</th>
                            <!-- <th scope="col">조회수</th> -->
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="text-center" v-for="article in articles">
                            <th scope="row">{{ article.planNo }}</th>
                            <td class="text-center">
                                <router-link :to="{
                                    name: 'plan-view',
                                    params: { articleno: article.planNo },
                                }" class="article-title link-dark">
                                    {{ article.subject }}
                                </router-link>
                            </td>
                            <td>{{ article.userId }}</td>
                            <td>{{ article.startDate }} ~ {{ article.endDate }}</td>
                            <td>{{ article.registerTime }}</td>
                        </tr>
                        <!-- <PlanListItem :article="article"> </PlanListItem> -->
                    </tbody>
                </table>
            </div>
            <!-- <PageNavigation
                                                                                                                                                                                                                                                                                        :current-page="currentPage"
                                                                                                                                                                                                                                                                                        :total-page="totalPage"
                                                                                                                                                                                                                                                                                        @pageChange="onPageChange"
                                                                                                                                                                                                                                                                                        ></PageNavigation> -->
        </div>
    </div>
</template>

<style scoped></style>
