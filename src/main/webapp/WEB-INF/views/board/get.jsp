<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>


	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title'
						value='<c:out value="${board.title}"/>' readonly="readonly">
				</div>
				<div class="form-group">
					<label>Text area</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${board.content}"/></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label>
					<input class="form-control" name='writer'
						value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>
				
				<button data-oper='modify' class="btn btn-default" type="submit">Modify</button>
				<button data-oper='list' class="btn btn-info" type="submit">List</button>
				
				<form action="/board/modity" method="get" id="operForm">
					<input type="hidden" id="bno" name="bno" value="${board.bno}">
					<input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}">
					<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
				</form>
				
		
</div>
<!-- /.panel-body -->
</div>
<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
	console.log("------------------------------");
	console.log("JS TEST");
	
	var bnoValue = '${board.bno}';//2228237
	
	console.log("bnoValue" + bnoValue);
	
	 replyService.get(22, 
			function(data){
				console.log(data)
			},
			function(error){
				console.log(error)
			}
	);
	 
	 /* replyService.update(
		{rno : 21, reply : "modify"},
		function(data){
			alert("수정완료 > " + data);
		},
		function(er) {
			alert("실패 > " + er);
		}
	); 
	 */
	/* replyService.remove(22, function(data){
		console.log(data);
		if(data === "success"){
			alert("removed sussess");
		}
	},function(err){
			alert("error");
	}); */
	
	/* replyService.getList({bno:bnoValue, page:1}, function(list){
		for(var i = 0, len = list.length || 0 ; i < len ; i++){
			console.log(list[i]);
		}
	}) */
	
	/* var addValue = {
			reply:"JS TEST",
			replyer: "tester",
			bno:bnoValue
	};
	
	replyService.add(addValue, function(result){
		alert("result : " + result);
	}); */
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").click(function(e){
			operForm.attr("action","/board/modify").submit();
		});
		
		$("button[data-oper='list']").click(function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
			
		});
		
	});
</script>
<%@ include file="../includes/footer.jsp"%>