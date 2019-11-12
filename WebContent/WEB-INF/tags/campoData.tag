<%@ attribute name="id" required="true" %>

<html>
	<input id="${id}" name="${id}" type="text">
	<script>
		$("#${id}").datepicker();
	</script>
</html>