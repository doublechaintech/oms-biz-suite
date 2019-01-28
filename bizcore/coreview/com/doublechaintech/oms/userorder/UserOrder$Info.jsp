
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userOrder}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A UserOrder">${userContext.localeMap['user_order']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./userOrderManager/view/${userOrder.id}/"> ${userOrder.id}</a></li>
<li><span>${userContext.localeMap['user_order.title']}</span> ${userOrder.title}</li>
<li><span>${userContext.localeMap['user_order.total_adjustment']}</span> <fmt:formatNumber type="currency"  value="${userOrder.totalAdjustment}" /></li>
<li><span>${userContext.localeMap['user_order.total_amount']}</span> <fmt:formatNumber type="currency"  value="${userOrder.totalAmount}" /></li>
<li><span>${userContext.localeMap['user_order.last_update_time']}</span> ${userOrder.lastUpdateTime}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




