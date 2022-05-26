<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="form-group">
			<select name="category" required="required">
				<option value="notice" id="category">공지게시판</option>
				<option value="qna" id="category">질문게시판</option>
				<option value="data" id="category">자료실게시판</option>
				<option value="pictureList" id="category">앨범게시판(리스트형)</option>
				<option value="pictureThum" id="category">앨범게시판(썸네일형)</option>
				<option value="video" id="category">동영상게시판</option>
				<option value="videoList" id="category">동영상게시판(리스트형)</option>
			</select>
			← 게시판 선택을 꼭 해주세요
			<input type="text" class="form-control" placeholder="Enter title" id="title">
		</div>

		<div class="form-group">
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글쓰기완료</button>
</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>