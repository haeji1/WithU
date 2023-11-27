<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

const selectOption = ref([
  { text: "검색조건", value: "" },
  { text: "글번호", value: "notice_no" },
  { text: "제목", value: "subject" },
  { text: "작성자아이디", value: "user_id" },
]);

const noticeList = [
  {
    noticeNo: 100,
    subject: "안녕하세요1",
    userId: "ssafy",
    userName: "김싸피",
    hit: 123,
    registerDate: "25.12.25",
  },
  {
    noticeNo: 99,
    subject: "안녕하세요2",
    userId: "admin",
    userName: "관리자",
    hit: 100,
    registerDate: "25.12.24",
  },
  {
    noticeNo: 98,
    subject: "안녕하세요3",
    userId: "parkssafy",
    userName: "박싸피",
    hit: 78,
    registerDate: "24.12.31",
  },
  {
    noticeNo: 97,
    subject: "안녕하세요4",
    userId: "ssafy",
    userName: "김싸피",
    hit: 33,
    registerDate: "24.12.20",
  },
  {
    noticeNo: 96,
    subject: "내 생일이에요!!!",
    userId: "ssafy",
    userName: "김싸피",
    hit: 1004,
    registerDate: "23.12.20",
  },
];
const param = ref({
  //   pgno: currentPage.value,
  spp: import.meta.env.VITE_ARTICLE_LIST_SIZE,
  key: "",
  word: "",
});
const notices = ref(noticeList);
// const currentPage = ref(7);
// const totalPage = ref(35);
const getNoticeList = () => {
  console.log("서버에서 글목록 얻어오자!!!", param.value);
};

const moveWrite = () => {
  router.push({ name: "notice-write" });
};
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
            <button
              type="button"
              class="btn btn-outline-primary btn-sm"
              @click="moveWrite"
            >
              글쓰기
            </button>
          </div>
          <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm">
                <input
                  type="text"
                  class="form-control"
                  v-model="param.word"
                  placeholder="검색어..."
                />
                <button
                  class="btn btn-dark"
                  type="button"
                  @click="getNoticeList"
                >
                  검색
                </button>
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
              <th scope="col">조회수</th>
              <th scope="col">작성일</th>
            </tr>
          </thead>
          <tbody>
            <NoticeListItem
              v-for="notice in notices"
              :key="notice.noticeNo"
              :notice="notice"
            ></NoticeListItem>
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
