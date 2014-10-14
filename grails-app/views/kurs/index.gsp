
<%@ page import="woingenau.Kurs" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kurs.label', default: 'Kurs')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kurs" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-kurs" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'kurs.name.label', default: 'Name')}" />
						<g:sortableColumn property="info" title="${message(code: 'kurs.info.label', default: 'Info')}" />
						<g:sortableColumn property="owner" title="${message(code: 'kurs.owner.label', default: 'Owner')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${kursInstanceList}" status="i" var="kursInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kursInstance.id}">${fieldValue(bean: kursInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: kursInstance, field: "owner")}</td>
					
						<td>${fieldValue(bean: kursInstance, field: "info")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${kursInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
