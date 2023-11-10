<script setup>
</script>

<template>
    <div class="container-fluid">
        <h2 class="text-center">지역별 여행지</h2>
        <!-- 지역 선택 -->
        <div class="row mb-3">
            <div class="col-3 offset-3"><select class="custom-select" id="sidoselect">
                    <option disabled="disabled" selected value="">시도선택</option>
                    <option value="1">서울</option>
                    <option value="2">인천</option>
                    <option value="3">대전</option>
                    <option value="4">대구</option>
                    <option value="5">광주</option>
                    <option value="6">부산</option>
                    <option value="7">울산</option>
                    <option value="8">세종특별자치시</option>
                    <option value="31">경기도</option>
                    <option value="32">강원도</option>
                    <option value="33">충청북도</option>
                    <option value="34">충청남도</option>
                    <option value="35">경상북도</option>
                    <option value="36">경상남도</option>
                    <option value="37">전라북도</option>
                    <option value="38">전라남도</option>
                    <option value="39">제주도</option>
                </select></div>
            <div class="col-3"><select class="custom-select" id="optionselect">
                    <option disabled="disabled" selected value="">선택</option>
                    <option value="1">모두</option>
                    <option value="2">관광지</option>
                    <option value="3">문화시설</option>
                    <option value="4">행사/공연/축제</option>
                    <option value="5">여행코스</option>
                    <option value="6">레포츠</option>
                    <option value="7">숙박</option>
                    <option value="8">쇼핑</option>
                    <option value="9">음식점</option>
                </select></div>
        </div>
        <!-- 카테고리 선택 -->

    </div>
</template>

<style scoped>
select {
    transition: background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
    word-wrap: normal;
    text-transform: none;
}

.custom-select {
    display: inline-block;
    width: 100%;
    height: calc(1.5em + 0.75rem + 2px);
    padding: 0.375rem 1.75rem 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    vertical-align: middle;
    background: #fff url("data:image/svg+xml;charset=utf-8,%3Csvg xmlns='http://www.w3.org/2000/svg' width='4' height='5'%3E%3Cpath fill='%23343a40' d='M2 0 0 2h4zm0 5L0 3h4z'/%3E%3C/svg%3E") right 0.75rem center/8px 10px no-repeat;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}

select {
    word-wrap: normal;
}

select:not(:-internal-list-box) {
    overflow: visible !important;
}
</style>