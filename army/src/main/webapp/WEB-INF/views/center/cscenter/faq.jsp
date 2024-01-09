<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<h1>자주묻는 질문</h1>
	<div id="page-wrapper">
		<div id="firstFAQ">
			<div id="catebtn">
				<button>계정/보안</button>
				<button>홈페이지</button>
				<input type="hidden" name="category" value="">
			</div>
			<div id="faqboard">
				<ul id="faqul">
					<li id="faqli">
						<div id="faqtitle">제목1</div>
						<div id="faqcontentbox">
							<div id="faqcontent">내용1</div>
						</div>
					</li>
					
				</ul>
			</div>
		</div>

	</div>
	<script type="text/javascript">
	$(document).ready(function() {
	    $("#catebtn button").click(function() {
	        var selectedCategory = $(this).text(); 
	        $("input[name='category']").val(selectedCategory); 
	        
	        loadTableData(selectedCategory);
	    });

	    function loadTableData(category) {
	        $.ajax({
	            url: "/center/cscenter/faqList",
	            type: "POST",
	            dataType: "json",
	            data: {
	                category: category
	            },
	            success: function(data) {
	                let faqul = $("#faqul"); 
	                faqul.empty();

	                $.each(data, function(index, faq) {
	                    let row = $("<li>");
	                    let title = $("<div>").text(faq.title);
	                    let contentbox = $("<div>");
	                    contentbox.append($("<div>").text(faq.content));
	                    row.append(title);
	                    row.append(contentbox);
	                    faqul.append(row); 
	                });
	            },
	            error: function(e) {
	                console.log(e);
	            }
	        });
	    }
	}); // $(document).ready 함수 선언 종료

	</script>
</body>

</html>