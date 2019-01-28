
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty orderPromotion}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A OrderPromotion" style="color: green">${userContext.localeMap['order_promotion']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['order_promotion.id']}</span> ${orderPromotion.id}</li>
<li><span>${userContext.localeMap['order_promotion.name']}</span> ${orderPromotion.name}</li>
<li><span>${userContext.localeMap['order_promotion.amount']}</span> ${orderPromotion.amount}</li>
<li><span>${userContext.localeMap['order_promotion.thread_hold']}</span> ${orderPromotion.threadHold}</li>
<li><span>${userContext.localeMap['order_promotion.type']}</span> ${orderPromotion.type}</li>

	
	</ul>
</div>



</c:if>


