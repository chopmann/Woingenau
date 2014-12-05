<%@ page import="woingenau.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="course.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${courseInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'creator', 'error')} required">
	<label for="creator">
		<g:message code="course.creator.username" default="Creator" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="creator" name="creator.id" from="${woingenau.User.list()}" optionKey="id" required="" optionValue="${{it.username}}" value="${courseInstance?.creator?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="course.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${woingenau.User.list()}" optionKey="id" optionValue="${{it.username}}" required="" value="${courseInstance?.owner?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'appointments', 'error')} ">
	<label for="appointments">
		<g:message code="course.appointments.label" default="Appointments" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${courseInstance?.appointments?}" var="a">
    <li><g:link controller="appointment" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="appointment" action="create" params="['course.id': courseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'appointment.label', default: 'Appointment')])}</g:link>
</li>
</ul>


</div>

