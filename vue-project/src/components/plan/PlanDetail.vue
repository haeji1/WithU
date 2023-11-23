<script setup>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
import CommentWrite from "../comment/CommentWrite.vue";
// import BoardFormItem from "./item/BoardFormItem.vue";

const route = useRoute();
const router = useRouter();

const url = import.meta.env.VITE_PLAN_VIEW_API_URL;
const followurl = import.meta.env.VITE_FOLLOW_FOLLOW_API_URL;
const user = JSON.parse(sessionStorage.getItem("user"));
// const durl = import.meta.env.VITE_BOARD_DELETE_API_URL;

// const comment = ref({});

// follow 유저 아이디 세팅
const follow = ref({
    userId: "",
    followId: "",
});

const articles = ref({});
const trips = ref([]);
// const comment = ref({});

onMounted(() => {
    getArticles();
    console.log(articles.value.articleno);
});

const getArticles = () => {
    axios
        .get(url, {
            params: {
                planNo: route.params.articleno,
            },
        })
        .then(({ data }) => {
            console.log(data.resdata);
            articles.value = data.resdata;
            trips.value = data.restravel;
            console.log(trips.value);
            // comment.value.articleNo = route.params.articleno;
            // comment.value.userId = user;
        })
        .catch((error) => {
            console.log(error);
        });
};

function moveList() {
    router.push({ name: "plan-list" });
}

// function moveModify() {
//     router.push({
//         name: "article-modify",
//     });
// }

function onFollowUser() {
    alert(`${articles.value.userId} 님을 팔로우합니다.`);
    follow.value.userId = user;
    follow.value.followId = articles.value.userId;
    axios
        .post(followurl, follow.value)
        .then((response) => {
            console.log(response);
            router.push({ name: "following" });
        })
        .catch((error) => {
            console.log(error);
        });
}

// function onDeleteArticle() {
//     console.log(route.params.articleno + "번글 삭제하러 가자!!!");
//     axios
//         .delete(`http://localhost:8080/spring/resboard/delete/${route.params.articleno}`)
//         .then((response) => {
//             console.log(`Deleted post with ID ${route.params.articleno}`);
//             alert("삭제되었습니다");
//             router.push({ name: "article-list" });
//         })
//         .catch((error) => {
//             console.error(error);
//         });
// }


</script>

<template>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="border rounded p-4">
                    <h2>{{ articles.subject }}</h2>
                    <div class="d-flex justify-content-between">
                        <p>
                            <strong>작성자:</strong>
                            <span class="text-end">{{ articles.userId }}</span>
                        </p>
                        <p>
                            <strong>작성일:</strong>
                            <span class="text-end">{{ articles.registerTime }}</span>
                        </p>
                    </div>
                    <p>{{ articles.content }}</p>
                    <div class="mt-3 d-flex justify-content-end">
                        <button type="button" class="btn btn-outline-primary me-2" @click="moveList">글 목록</button>
                        <!-- <button type="button" class="btn btn-outline-danger me-2" @click="onDeleteArticle">글 삭제</button> -->
                        <button type="button" class="btn btn-outline-danger" @click="onFollowUser">팔로우하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
