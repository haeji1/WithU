<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<c:if test="${article eq null}">
	<script>
		alert("글이 삭제되었거나 부적절한 URL 접근입니다.");
		location.href = "${root}/article?action=list";
	</script>
</c:if>
<%@ include file="/common/confirm.jsp"%>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">글보기</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<div class="row my-2">
			<h2 class="text-secondary px-5">${article.articleNo}.
				${article.subject}</h2>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="clearfix align-content-center">
					<img class="avatar me-2 float-md-start bg-light p-2"
						src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
					<p>
						<span class="fw-bold">${article.userId}</span> <br /> <span
							class="text-secondary fw-light"> ${article.registerTime}
							조회 : ${article.hit + 1} </span>
					</p>
				</div>
			</div>
			<div class="col-md-4 align-self-center text-end">댓글 :
				${comment.size()}</div>
			<div class="divider mb-3"></div>
			<div class="text-secondary">${article.content}</div>
			<div class="divider mt-3 mb-3"></div>
			<div class="d-flex justify-content-end">
				<button type="button" id="btn-list"
					class="btn btn-outline-primary mb-3">글목록</button>
				<c:if test="${userinfo.userId eq article.userId}">
					<button type="button" id="btn-mv-modify"
						class="btn btn-outline-success mb-3 ms-1">글수정</button>
					<button type="button" id="btn-delete"
						class="btn btn-outline-danger mb-3 ms-1">글삭제</button>
				</c:if>
			</div>
		</div>




		<div id="comment-area">
			<div class="card my-4">
				<h5 class="card-header">Leave a Comment:</h5>
				<div class="card-body">
					<form method="POST" action="${root }/board/incom">
						<div class="form-group">
							<input type="hidden" name="articleNo"
								value="${article.articleNo }">
								<input type="hidden" name="userId"
								value="${userinfo.userId }">
							<textarea class="form-control" rows=3 name="comment"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>

			<c:forEach items="${comment }" var="item">
				<div class="media mb-4" id="" style="display: flex">
					<form method="POST" action="${root }/board/deletecomment">
						<input type="hidden" name="articleno" value="${item.articleNo}">
						<input type="hidden" name="commentno" value="${item.commentNo}">
						<div class="media-body">
							<h5 class="mt-0">${item.userId }</h5>
							${item.content }
							<c:if test="${userinfo.userId eq item.userId}">
								<!-- <button type="button" id="btn-comment-delete2"
									class="btn btn-outline-success mb-3 ms-1">삭제</button>

								<button type="submit" class="btn-comment-delete"
									class="btn btn-outline-success mb-3 ms-1">삭제</button> -->
									<button type="submit" style="color: red; background-color: white; border: none">X</button>
							</c:if>
						</div>
					</form>
				</div>
			</c:forEach>

		</div>



	</div>
</div>
<script>
	document.querySelector("#btn-list").addEventListener("click", function() {
		location.href = "${root}/board/list";
	});
	document
			.querySelector("#btn-mv-modify")
			.addEventListener(
					"click",
					function() {
						alert("글수정하자!!!");
						location.href = "${root}/article?action=mvmodify&articleno=${article.articleNo}";
					});
	document
			.querySelector("#btn-delete")
			.addEventListener(
					"click",
					function() {
						alert("글삭제하자!!!");
						location.href = "${root}/article?action=delete&articleno=${article.articleNo}";
					});

	document.querySelector("#btn-comment-delete2").addEventListener("click",
			function() {
				alert("삭제 아니지롱!!!");
			});
</script>
<%@ include file="/common/footer.jsp"%>