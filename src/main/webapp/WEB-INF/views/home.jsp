<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="header.jspf"%>
<!-- PAGE TITLE SECTION -->
<div class="container">

	<!-- SIDEBAR SECTION -->
	<%@ include file="siderbar.jspf"%>
	<!-- SIDEBAR SECTION -->

	<!-- MAIN CONTENT SECTION -->
	<div class="contentarea floatleft">

		<c:forEach items="${posts}" var="post">
			<!-- BLOG ITEM -->
			<div class="blog_item_wrap">

				<div class="tagsandcomments">

					<!-- TAGS -->
					<span class="tagimage"> <c:forEach items="${post.tags}"
							var="tag">
							<a href="#" title="${tag}">${tag}</a>,                           
                     </c:forEach>

					</span>
					<!-- TAGS -->

					|
					<!-- COMMENTS -->
					<span class="commentsimage"><a href="single-blog.html"
						title="${post.forwardCount} 转发">${post.forwardCount} 转发</a></span>
					<!-- COMMENTS -->

				</div>
				<div class="titleanddate">
					<!-- BLOG DATE -->
					<div class="blogdate">
						2日<br>
						<span class="datelarge">12月</span>
					</div>
					<!-- BLOG DATE -->
					<!-- BLOG TITLE -->
					<div class="blogtitle">
						<h2>
							<a href="${post.url}" title="${post.title}">${post.title}</a>
						</h2>
					</div>
					<!-- BLOG TITLE -->
				</div>
				<!-- BLOG IMAGE -->
				<div class="blogitem_home_image">
					<a href="${post.url}" title="${post.title}"><img
						src="${post.image}" alt="${post.title}"></a>
				</div>
				<!-- BLOG IMAGE -->

				<!-- BLOG DESCRIPTION -->
				<div class="blogdescription">
					<p>${post.description}</p>
				</div>
				<!-- BLOG DESCRIPTION -->

			</div>
			<!-- BLOG ITEM -->
		</c:forEach>

		<!-- PAGINATION AREA -->
		<div id="pageLinks">
			

		</div>
		<!-- PAGINATION AREA -->
	
	</div>
	<!-- MAIN CONTENT SECTION -->
</div>

</section>
<div class="clear"></div>
<!-- MAIN SECTION -->
<script language="javascript">
$(function() {
    $('#pageLinks').pagination({
        items: ${postCounts},
        itemsOnPage: 10,
        displayedPages: 10,
        edges: 1,
        currentPage: ${currentPage},
        hrefTextPrefix:"${pageContext.request.contextPath}/home/",
        prevText:'上一页',
        nextText:'下一页',        
        cssStyle: 'light-theme'
    });
});
</script>
</div>
<!-- CONTAINER -->

</div>
<!-- HEADER AND MAIN SECTION -->
<%@ include file="footer.jspf"%>
