
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userOrder}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A UserOrder" style="color: green">${userContext.localeMap['user_order']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['user_order.id']}</span> ${userOrder.id}</li>
<li><span>${userContext.localeMap['user_order.title']}</span> ${userOrder.title}</li>
<li><span>${userContext.localeMap['user_order.total_adjustment']}</span> <fmt:formatNumber type="currency"  value="${userOrder.totalAdjustment}" /></li>
<li><span>${userContext.localeMap['user_order.total_amount']}</span> <fmt:formatNumber type="currency"  value="${userOrder.totalAmount}" /></li>
<li><span>${userContext.localeMap['user_order.last_update_time']}</span> ${userOrder.lastUpdateTime}</li>

	
	</ul>
</div>



</c:if>


