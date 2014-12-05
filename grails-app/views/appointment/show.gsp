
<%@ page import="woingenau.Appointment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'appointment.label', default: 'Appointment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-appointment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-appointment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list appointment">
			
				<g:if test="${appointmentInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="appointment.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${appointmentInstance?.course?.id}">${appointmentInstance?.course?.title}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${appointmentInstance?.end}">
				<li class="fieldcontain">
					<span id="end-label" class="property-label"><g:message code="appointment.end.label" default="End" /></span>
					
						<span class="property-value" aria-labelledby="end-label"><g:formatDate date="${appointmentInstance?.end}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${appointmentInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="property-label"><g:message code="appointment.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${appointmentInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${appointmentInstance?.start}">
				<li class="fieldcontain">
					<span id="start-label" class="property-label"><g:message code="appointment.start.label" default="Start" /></span>
					
						<span class="property-value" aria-labelledby="start-label"><g:formatDate date="${appointmentInstance?.start}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:appointmentInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${appointmentInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
