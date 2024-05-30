<script setup></script>

<template>
  <section>
    <div id="top" class="container-fluid">
      <div
        id="carouselExampleCaptions"
        class="carousel slide"
        data-bs-ride="carousel"
      >
        <div class="carousel-indicators">
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="0"
            class="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>

        <div class="carousel-inner">
          <div class="photetop carousel-item active">
            <img src="../../img/city/berlin.jpg" class="phote d-block w-100" />
            <div class="carousel-caption d-none d-md-block">
              <h5>Trip with me, Trip with us</h5>
              <strong>
                모두 다함께 여행을 떠나보아요
              </strong>
            </div>
          </div>
          <div class="photetop carousel-item">
            <img
              src="../../img/city/paris2.jpg"
              class="phote d-block w-100"
              alt="..."
            />
            <div class="carousel-caption d-none d-md-block">
              <h5>고민은 다함께</h5>
              <p>
                Q&A 게시판을 활용하여 고민을 나누어 보아요.
              </p>
            </div>
          </div>
          <div class="photetop carousel-item">
            <img
              src="../../img/city/london.jpg"
              class="phote d-block w-100"
              alt="..."
            />
            <div class="carousel-caption d-none d-md-block">
              <h5>나만 알기 싫은 여행 정보는..?!</h5>
              <p>
                여행계획 게시판을 활용해서 정보를 나누어 보아요!
              </p>
            </div>
          </div>
        </div>
        <button
          class="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button
          class="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleCaptions"
          data-bs-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </section>
</template>

<style scoped>
.photetop {
  background-size: cover;
  height: 80vh !important;
  /* width: 80% !important; */
}
</style>
