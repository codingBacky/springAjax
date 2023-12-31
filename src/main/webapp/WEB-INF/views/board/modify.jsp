<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>


	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</div>
			<div class="panel-body">
				<form action="/board/modify" method="post" role="form">
				
					<input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}">
					<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
					
					<div class="form-group">
						<label>Bno</label> 
						<input class="form-control" name='bno'
							value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> 
						<input class="form-control" name='title'
							value='<c:out value="${board.title}"/>'>
					</div>
					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='content'><c:out
								value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name='writer'
							value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>
					
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
	
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
	
	$(document).ready(function(){
		var formObj = $("form");
		
		$("button").click(function(e){
			e.preventDefault();//이동 중지
			
			var operation = $(this).data("oper");
			console.log(operation);
			
			if(operation === "remove"){
				formObj.attr("action","/board/remove")
			}else if(operation === "list"){
				//self.location = "/board/list";//get방식으로 날라간다~~
				formObj.attr("action","/board/list").attr("method","get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			formObj.submit();
		});
		
		
	});
	
	
</script>
<%@ include file="../includes/footer.jsp"%>