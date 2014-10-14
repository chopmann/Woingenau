
<%@ page import="woingenau.Kurs"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'kurs.label', default: 'Kurs')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-kurs" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="index">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="show-kurs" class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list kurs">

			<g:if test="${kursInstance?.name}">
				<li class="fieldcontain"><span id="name-label"
					class="property-label"><g:message code="kurs.name.label"
							default="Name" /></span> <span class="property-value"
					aria-labelledby="name-label"><g:fieldValue
							bean="${kursInstance}" field="name" /></span></li>
			</g:if>

			<g:if test="${kursInstance?.owner}">
				<li class="fieldcontain"><span id="owner-label"
					class="property-label"><g:message code="kurs.owner.label"
							default="Owner" /></span> <span class="property-value"
					aria-labelledby="owner-label"><g:fieldValue
							bean="${kursInstance}" field="owner" /></span></li>
			</g:if>
			<g:if test="${kursInstance?.info}">
				<li class="fieldcontain"><span id="info-label"
					class="property-label"><g:message code="kurs.info.label"
							default="Info" /></span> <span class="property-value"
					aria-labelledby="info-label"><g:fieldValue
							bean="${kursInstance}" field="info" /></span></li>
			</g:if>

			<g:if test="${kursInstance?.termine}">
				<li class="fieldcontain"><span id="termine-label"
					class="property-label"><g:message code="kurs.termine.label"
							default="Termine" /></span> <g:each in="${kursInstance.termine}"
						var="t">
						<span class="property-value" aria-labelledby="termine-label"><g:link
								controller="termin" action="show" id="${t.id}">
								${t?.encodeAsHTML()}
							</g:link></span>
					</g:each></li>
			</g:if>

		</ol>
		<g:form url="[resource:kursInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons">
				<g:link class="edit" action="edit" resource="${kursInstance}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
