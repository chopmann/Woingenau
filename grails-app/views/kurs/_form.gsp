<%@ page import="woingenau.Kurs" %>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="kurs.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${kursInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="kurs.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="owner" required="" value="${kursInstance?.owner}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'info', 'error')} required">
	<label for="info">
		<g:message code="kurs.info.label" default="Info" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="info" required="" value="${kursInstance?.info}"/>

</div>
<div class="fieldcontain ${hasErrors(bean: kursInstance, field: 'termine', 'error')} ">
	<label for="termine">
		<g:message code="kurs.termine.label" default="Termine" />
		
	</label>
	<g:select name="termine" from="${woingenau.Termin.list()}" multiple="multiple" optionKey="id" size="5" value="${kursInstance?.termine*.id}" class="many-to-many"/>

</div>

