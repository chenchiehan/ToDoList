<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>待辦事項</title>

<!-- bootstrap cdn -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- bootstrap icon cdn -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>	

</head>

<style>
#mainDiv{
	width: 600px;
	margin: auto;
	margin-top: 100px;
	border: 0.5px solid lightgray;
	border-radius: 8px;
	height: auto;
	padding: 15px;

}

.todoList{
	margin-top: 10px;
	margin-bottom: 10px;
	font-weight: bold;
}
.bi-asterisk{
	color: red;
	font-size: 10%;
	margin-top: 10px;
	margin-right: 10px;
}

#subBtn{
	margin-left: 10px;
	background-color:	#bebebe;
	border: none;
}

#unfinishedList{
	margin-top: 130px;
}

.choose{
	margin: auto;
	width: 500px;
	
}
#navDiv{
	margin-top: 50px;
}

.delBtn{
	float: right;
	background-color:	#bebebe;
	border: none;
}

.finBtn{
	float: right;
	margin-right: 10px;
	background-color:	#bebebe;
	border: none;
}



</style>

<body>



		<!-- 	為了讓body內也能使用contextRoot的值 -->
		<input type="hidden" id="contextRoot"
		value="${pageContext.request.contextPath}">


		

			<div id="mainDiv">
				<h2 class="todoList">待辦事項</h2>
				<span><i class="bi bi-asterisk"></i>項目</span>

		<form id="todoListForm"  method="get" action="${contextRoot}/insertToDoList.controller">

				<div class="input-group flex-nowrap">

					<input name="listDiscription" id="discription" type="text"  value="" class="form-control" placeholder="請輸入待辦事項"  aria-describedby="addon-wrapping">
					<!-- <input type="text" id="unfinished" name="unfinished" value="未完成" hidden> -->
					<!-- <input hidden id="createdAt" name="createdAt"  type="text" value=""> -->
					<button id="subBtn" onclick="addToDoList()"  type="button" class="btn btn-secondary">送出</button>

				</div>
		</form>



		<div id="navDiv">
			<nav class="nav nav-pills flex-column flex-sm-row choose">
				<a id="unfinish" class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">未完成</a>
				<a id="finish" class="flex-sm-fill text-sm-center nav-link " aria-current="page" href="#">已完成</a>
			</nav>
		</div>

		<div>
			<ul class="list-group list-group-flush" id="unfinishedList">


			
				

			</ul>

			<ul class="list-group list-group-flush" id="finishedList">





			</ul>
		</div>


	</div>



	

	<script>
		
		function addToDoList(){
			var Discription = $("#discription").text();
			

			$.ajax({
				url:$("#contextRoot").val() + "/insertToDoList.controller",
				type:"get",
				contentType : "text/html;charset=utf-8",
				data: $("#todoListForm").serialize(),

				success:function(result){
					if(result=="insertSuccess"){
						$("#discription").val("");
					}
				}
			})
		}

		function addFinishedList(){

			$.ajax({
				url:$("#contextRoot").val() + "/insertFinishedList.controller",
				type:"get",
				contentType:"text/html;charset=utf-8",
				data: $("#finishedListForm").serialize(),
				success:function(result){
					if(result=="insertSuccess"){

					}
				}
			})
		}



		function queryAllList(){
			$.ajax({
				url:$("#contextRoot").val() + "/queryAllList",
				type:"get",
				success:function(lists){
					$.each(lists, function(index, list){				
	      	  	
						$("#unfinishedList").append(unfinishList)
					})
				}
			})
		}


		$("#unfinish").click(function(){
			$.ajax({
				url:$("#contextRoot").val() + "/queryAllList",
				type:"get",
				success:function(lists){
					
					$.each(lists, function(index, list){
						var btn = $("<a data-id='${Ids[status.index]}' class='delBtn' href=''><button class='btn btn-secondary btn-sm delBtn'>移除</button></a>  <button onclick='addFinishedList()' class='btn btn-secondary btn-sm finBtn'>完成</button>")
						var newList = $("<li class='list-group-item'></li><br>").text(list.listDiscription).append(btn)
						var newInput = $("<form id='finishedListForm' method='get' action='${contextRoot}/insertFinishedList.controller'><input hidden name='finishedDiscription' type='text' value='" + list.listDiscription +"'></form>")
						
						$("#unfinishedList").append(newList)
						$("#unfinishedList").append(newInput)
					})

				
					$("#finishedList").hide();
					$("#unfinishedList").show();
					$("#finishedList").text("");
					
				}
			})

			var element = document.getElementById("unfinish");
 				 element.classList.add("active");
			var newelement = document.getElementById("finish");
 				 newelement.classList.remove("active");

		})



		$("#finish").click(function(){
			$.ajax({
				url:$("#contextRoot").val() + "/queryAllfinishedList",
				type:"get",
				success:function(lists){
					$.each(lists, function(index, list){
						var newList = $("<li class='list-group-item'></li><br>").text(list.finishedDiscription)
						
						$("#finishedList").append(newList)
					})
						$("#unfinishedList").hide();
						$("#finishedList").show();
						$("#unfinishedList").text("");
				}
			})



			var element = document.getElementById("finish");
 				 element.classList.add("active");
		    var element = document.getElementById("unfinish");
 				 element.classList.remove("active");

		})

		$(".delBtn").click(function(){
			var delBtn = $(this);
			$.ajax({
				url:$("#contextRoot").val() + "/deleteList",
				type:"get",
				data:{
					Id: $(this).data("id")
				},
				success:function(){
					$(".delBtn").closest("li").remove();
				}
			});
		})




	</script>










</body>
</html>