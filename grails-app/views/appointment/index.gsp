
<%@ page import="woingenau.Appointment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'appointment.label', default: 'Appointment')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-appointment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-appointment" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="appointment.course.label" default="Course" /></th>
					
						<g:sortableColumn property="end" title="${message(code: 'appointment.end.label', default: 'End')}" />
					
						<g:sortableColumn property="place" title="${message(code: 'appointment.place.label', default: 'Place')}" />
					
						<g:sortableColumn property="start" title="${message(code: 'appointment.start.label', default: 'Start')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${appointmentInstanceList}" status="i" var="appointmentInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${appointmentInstance.id}">${fieldValue(bean: appointmentInstance, field: "course")}</g:link></td>
					
						<td><g:formatDate date="${appointmentInstance.end}" /></td>
					
						<td>${fieldValue(bean: appointmentInstance, field: "place")}</td>
					
						<td><g:formatDate date="${appointmentInstance.start}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${appointmentInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
