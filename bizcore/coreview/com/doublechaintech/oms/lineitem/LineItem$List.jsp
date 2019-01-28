<%@ page import='java.util.*,com.doublechaintech.oms.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty lineItemList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['line_item']}! 
		 <a href="./${ownerBeanName}Manager/addLineItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty lineItemList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("lineItemList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['line_item']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addLineItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'lineItemList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${lineItemListName};${lineItemListName}CurrentPage=${page.pageNumber};${lineItemListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='lineItemListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['line_item.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['line_item.name']}</th>
</c:if>
<c:if test="${param.referName ne 'quantity'}">
	<th>${userContext.localeMap['line_item.quantity']}</th>
</c:if>
<c:if test="${param.referName ne 'price'}">
	<th>${userContext.localeMap['line_item.price']}</th>
</c:if>
<c:if test="${param.referName ne 'discountPrice'}">
	<th>${userContext.localeMap['line_item.discount_price']}</th>
</c:if>
<c:if test="${param.referName ne 'userOrder'}">
	<th>${userContext.localeMap['line_item.user_order']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${lineItemList}">
				<tr currentVersion='${item.version}' id="lineItem-${item.id}" ><td><a class="link-action-removed" href="./lineItemManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateLineItem/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'quantity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='quantity' storedCellValue='${item.quantity}' prefix='${ownerBeanName}Manager/updateLineItem/${result.id}/${item.id}/'>${item.quantity}</td>
</c:if><c:if test="${param.referName ne 'price'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='price' storedCellValue='${item.price}' prefix='${ownerBeanName}Manager/updateLineItem/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.price}" /></td>
</c:if><c:if test="${param.referName ne 'discountPrice'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='discountPrice' storedCellValue='${item.discountPrice}' prefix='${ownerBeanName}Manager/updateLineItem/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.discountPrice}" /></td>
</c:if><c:if test="${param.referName ne 'userOrder'}">
	<td class="select_candidate_td"
			data-candidate-method="./lineItemManager/requestCandidateUserOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./lineItemManager/transferToAnotherUserOrder/${item.id}/"
			data-link-template="./userOrderManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.userOrder}">
			<a href='./userOrderManager/view/${item.userOrder.id}/'>${item.userOrder.displayName}</a>
			</c:if>
			<c:if test="${empty  item.userOrder}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeLineItem/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyLineItemFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


