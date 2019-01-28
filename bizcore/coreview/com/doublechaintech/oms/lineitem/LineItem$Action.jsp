
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty lineItem}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A LineItem" style="color: green">${userContext.localeMap['line_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['line_item.id']}</span> ${lineItem.id}</li>
<li><span>${userContext.localeMap['line_item.name']}</span> ${lineItem.name}</li>
<li><span>${userContext.localeMap['line_item.quantity']}</span> ${lineItem.quantity}</li>
<li><span>${userContext.localeMap['line_item.price']}</span> <fmt:formatNumber type="currency"  value="${lineItem.price}" /></li>
<li><span>${userContext.localeMap['line_item.discount_price']}</span> <fmt:formatNumber type="currency"  value="${lineItem.discountPrice}" /></li>

	
	</ul>
</div>



</c:if>


