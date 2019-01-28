
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty manualAdjustment}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ManualAdjustment" style="color: green">${userContext.localeMap['manual_adjustment']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['manual_adjustment.id']}</span> ${manualAdjustment.id}</li>
<li><span>${userContext.localeMap['manual_adjustment.name']}</span> ${manualAdjustment.name}</li>
<li><span>${userContext.localeMap['manual_adjustment.amount']}</span> ${manualAdjustment.amount}</li>
<li><span>${userContext.localeMap['manual_adjustment.thread_hold']}</span> ${manualAdjustment.threadHold}</li>
<li><span>${userContext.localeMap['manual_adjustment.type']}</span> ${manualAdjustment.type}</li>

	
	</ul>
</div>



</c:if>


