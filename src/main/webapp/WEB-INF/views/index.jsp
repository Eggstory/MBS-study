<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 경로앞에 /없이 쓰면 상대경로 (즉, 이 파일 위치하는곳을 기준으로 잡는거 -->
<%@ include file="layout/header.jsp"%>

<div class="p-5 bg-primary text-white text-center">
	<h1>대충 메인 사진 나오는 곳</h1>
	<p>급하게 만들어봤어요~~</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="container-fluid">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link active" href="/board/notice">공지</a></li>
			<li class="nav-item"><a class="nav-link active" href="/board/qna">질문게시판</a></li>
			<li class="nav-item"><a class="nav-link active" href="/board/data">자료실</a></li>
			<li class="btn-group">
				<button type="button" class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown">앨범</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="/board/pictureList">리스트형</a></li>
					<li><a class="dropdown-item" href="/board/pictureThum">썸네일형</a></li>
				</ul>
			</li>
			<li class="btn-group">
				<button type="button" class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown">동영상</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="/board/video">일반형</a></li>
					<li><a class="dropdown-item" href="/board/videoList">리스트형</a></li>
				</ul>
			</li>
		</ul>
	</div>
</nav>

<div class="container mt-5">
	<div class="row">
		<div class="col-sm-4">
			<h2>About Me</h2>
			<h5>Photo of me:</h5>
			<div class="fakeimg">Fake Image</div>
			<p>Some text about me in culpa qui officia deserunt mollit anim..</p>
			<h3 class="mt-4">Some Links</h3>
			<p>Lorem ipsum dolor sit ame.</p>
			<ul class="nav nav-pills flex-column">
				<li class="nav-item"><a class="nav-link active" href="#">Active</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a></li>
			</ul>
			<hr class="d-sm-none">
		</div>
		<div class="col-sm-8">
			<h2>TITLE HEADING</h2>
			<h5>Title description, Dec 7, 2020</h5>
			<div class="fakeimg">Fake Image</div>
			<p>Some text..</p>
			<p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
				nostrud exercitation ullamco.</p>

			<h2 class="mt-5">TITLE HEADING</h2>
			<h5>Title description, Sep 2, 2020</h5>
			<div class="fakeimg">Fake Image</div>
			<p>Some text..</p>
			<p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
				nostrud exercitation ullamco.</p>
		</div>
	</div>
</div>


<%@ include file="layout/footer.jsp"%>

