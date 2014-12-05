
<%@ page import="woingenau.Course" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-course" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-course" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list course">
			
				<g:if test="${courseInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="course.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${courseInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.creator}">
				<li class="fieldcontain">
					<span id="creator-label" class="property-label"><g:message code="course.creator.label" default="Creator" /></span>
					
						<span class="property-value" aria-labelledby="creator-label"><g:link controller="user" action="show" id="${courseInstance?.creator?.id}">${courseInstance?.creator?.username}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="course.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:link controller="user" action="show" id="${courseInstance?.owner?.id}">${courseInstance?.owner?.username}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.appointments}">
				<li class="fieldcontain">
					<span id="appointments-label" class="property-label"><g:message code="course.appointments.label" default="Appointments" /></span>
					
						<g:each in="${courseInstance.appointments}" var="a">
						<span class="property-value" aria-labelledby="appointments-label"><g:link controller="appointment" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:courseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${courseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
