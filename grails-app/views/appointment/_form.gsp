<%@ page import="woingenau.Appointment" %>



<div class="fieldcontain ${hasErrors(bean: appointmentInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="appointment.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${woingenau.Course.list()}" optionKey="id" optionValue="${{it.title}}" required="" value="${appointmentInstance?.course?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: appointmentInstance, field: 'end', 'error')} required">
	<label for="end">
		<g:message code="appointment.end.label" default="End" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="end" precision="day"  value="${appointmentInstance?.end}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: appointmentInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="appointment.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" required="" value="${appointmentInstance?.place}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: appointmentInstance, field: 'start', 'error')} required">
	<label for="start">
		<g:message code="appointment.start.label" default="Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="start" precision="day"  value="${appointmentInstance?.start}"  />

</div>

