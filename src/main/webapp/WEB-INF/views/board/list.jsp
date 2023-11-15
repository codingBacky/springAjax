<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List</h1>

		
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			
			<div class="panel-heading">
			Board List Page
			<button id="regBtn" type="button" class="btn btn-xs btn-primary pull-right">Register
			New Board</button></div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<!--             <table width="100%"
               class="table table-striped table-bordered table-hover"
               id="dataTables-example"> -->
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>

					</thead>
					<c:forEach items="${list}" var="board">
						<tr class="odd gradeX">
							<td>${board.bno}</td>
							
							<td>
								<a class="move" href="${board.bno}">${board.title}</a>
							</td>
							
							<td>${board.content}</td>
							<td>${board.writer}</td>
							<td><fmt:formatDate value="${board.regdate}"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${board.updateDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</table>

				<!-- 검색 조건처리 -->

				<div class="row">
					<div class="col-lo-12">
						<form action="/board/list" id="searchForm" method="get">
							<select name="type" id="selectType">
								<option value="">---</option>
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="W">작성자</option>
								<option value="TC">제목 or 내용</option>
								<option value="TW">제목 or 작성자</option>
								<option value="CW">내용 or 작성자</option>
								<option value="TWC">제목 or 작성자 or 내용</option>
								<%-- <option value="" ${pageMaker.cri.type == null?'selected':'' }>
								---</option> --%>
								<%-- <option value="" 
									<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>
								>---</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>
								제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>
								내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>
								작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>
								제목 or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>
								제목 or 작성자</option>
								<option value="CW"
									<c:out value="${pageMaker.cri.type eq 'CW'?'selected':'' }"/>>
								내용 or 작성자</option>
								<option value="TWC"
									<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':'' }"/>>
								제목 or 작성자 or 내용</option> --%>
							</select>
							<input type="text" name="keyword" value="${pageMaker.cri.keyword}"/>
							<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>
							<input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>
							<button class="btn btn-default">Search</button>
						</form>
					</div>
				</div>

				<!-- 페이징 처리 -->
				<div class="pull-right">
					<ul class="pagination">

						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a class="page-link"
								href="${pageMaker.startPage - 1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li
								class="page-item ${pageMaker.cri.pageNum == num ? "active" : "" }">
								<a class="page-link" href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="page-item"><a class="page-link"
								href="${pageMaker.endPage + 1}">Next</a></li>
						</c:if>
					</ul>
				</div>

				<!-- 페이징 처리 -->

				<form action="/board/list" id="actionForm" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
					<input type="hidden" name="type" value="${pageMaker.cri.type}">
				</form>



				<!--모달창 추가-->
				<div class="modal fade" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title" id="myModalLable">Modal Heading</h4>
							</div>

							<!-- Modal body -->
							<div class="modal-body">complete..</div>

							<!-- Modal footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
							</div>

						</div>
					</div>
				</div>
				<!--모달창 추가-->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>'
		
		checkModal(result);
		
		history.replaceState({},null,null);
		
		/* 모달창 */
		function checkModal(result) {
			if (result === ""|| history.state) {
				return;
			}
			if (parseInt(result) > 0) {
				$('.modal-body').html("게시글" + parseInt(result) + "번이 등록됨");
			}
			$("#myModal").modal("show");
		}
		/* register 호출 */
		$("#regBtn").click(function(){
			self.location = "/board/register";
		})
		
		//페이지 버튼 클릭 이동
		var actionForm = $("#actionForm");
		$(".page-item a").click(function(e){
			e.preventDefault();
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		})
		
		//조회하고 리스트 화면으로 이동할 때 기본 pageNum 유지
		$(".move").on('click' ,function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='" + $(this).attr('href') + "' />");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});

		//검색버튼 이벤트 처리
		var searchForm = $("#searchForm");
		$("#searchForm button").click(function(){
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1");
			e.preventdefault();
			
			searchForm.submit();
		})
		var select = "${pageMaker.cri.type}";

	    if(select != ""){
	         $('#selectType option[value= '+ select +']').prop("selected", true);
	    };
	});
</script>
<%@ include file="../includes/footer.jsp"%>