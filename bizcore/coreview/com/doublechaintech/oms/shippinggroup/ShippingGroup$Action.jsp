
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty shippingGroup}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ShippingGroup" style="color: green">${userContext.localeMap['shipping_group']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['shipping_group.id']}</span> ${shippingGroup.id}</li>
<li><span>${userContext.localeMap['shipping_group.name']}</span> ${shippingGroup.name}</li>
<li><span>${userContext.localeMap['shipping_group.line1']}</span> ${shippingGroup.line1}</li>
<li><span>${userContext.localeMap['shipping_group.line2']}</span> ${shippingGroup.line2}</li>
<li><span>${userContext.localeMap['shipping_group.city']}</span> ${shippingGroup.city}</li>
<li><span>${userContext.localeMap['shipping_group.state']}</span> ${shippingGroup.state}</li>
<li><span>${userContext.localeMap['shipping_group.zip_code']}</span> ${shippingGroup.zipCode}</li>
<li><span>${userContext.localeMap['shipping_group.country']}</span> ${shippingGroup.country}</li>

	
	</ul>
</div>



</c:if>


