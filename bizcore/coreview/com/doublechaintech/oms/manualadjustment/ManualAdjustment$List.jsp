<%@ page import='java.util.*,com.doublechaintech.oms.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty manualAdjustmentList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['manual_adjustment']}! 
		 <a href="./${ownerBeanName}Manager/addManualAdjustment/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty manualAdjustmentList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("manualAdjustmentList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['manual_adjustment']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addManualAdjustment/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'manualAdjustmentList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${manualAdjustmentListName};${manualAdjustmentListName}CurrentPage=${page.pageNumber};${manualAdjustmentListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='manualAdjustmentListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['manual_adjustment.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['manual_adjustment.name']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['manual_adjustment.amount']}</th>
</c:if>
<c:if test="${param.referName ne 'threadHold'}">
	<th>${userContext.localeMap['manual_adjustment.thread_hold']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['manual_adjustment.type']}</th>
</c:if>
<c:if test="${param.referName ne 'userOrder'}">
	<th>${userContext.localeMap['manual_adjustment.user_order']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${manualAdjustmentList}">
				<tr currentVersion='${item.version}' id="manualAdjustment-${item.id}" ><td><a class="link-action-removed" href="./manualAdjustmentManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateManualAdjustment/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateManualAdjustment/${result.id}/${item.id}/'>${item.amount}</td>
</c:if><c:if test="${param.referName ne 'threadHold'}">	<td contenteditable='true' class='edit-value'  propertyToChange='threadHold' storedCellValue='${item.threadHold}' prefix='${ownerBeanName}Manager/updateManualAdjustment/${result.id}/${item.id}/'>${item.threadHold}</td>
</c:if><c:if test="${param.referName ne 'type'}">	<td contenteditable='true' class='edit-value'  propertyToChange='type' storedCellValue='${item.type}' prefix='${ownerBeanName}Manager/updateManualAdjustment/${result.id}/${item.id}/'>${item.type}</td>
</c:if><c:if test="${param.referName ne 'userOrder'}">
	<td class="select_candidate_td"
			data-candidate-method="./manualAdjustmentManager/requestCandidateUserOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./manualAdjustmentManager/transferToAnotherUserOrder/${item.id}/"
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

				<a href='#${ownerBeanName}Manager/removeManualAdjustment/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyManualAdjustmentFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


