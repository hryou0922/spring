<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		The firstName and lastName values are retrieved from the command object placed 
		in the PageContext by the page controller。
		The preceding JSP assumes that the variable name of the form backing object is 'command'. 
		If you have put the form backing object into the model under another name (definitely a best practice), 
		then you can bind the form to the named variable
	 -->
	<form:form commandName="user">
		<table>
			<!-- ===== The input tag begin =====  -->
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<!-- ===== The input tag end =====  -->
			
			<!-- =====The checkbox tag begin =====  -->
			<tr>
				<td>Subscribe to newsletter?:</td>
				<%-- Approach 1: Property is of type java.lang.Boolean --%>
				<td><form:checkbox path="preferences.receiveNewsletter" /></td>
			</tr>
			
			<tr>
				<td>Interests:</td>
				<%-- Approach 2: Property is of an array or of type java.util.Collection --%>
				<td>
					Quidditch: <form:checkbox path="preferences.interests" value="Quidditch" /> 
					Herbology: <form:checkbox path="preferences.interests" value="Herbology" /> 
					Defence Against the Dark Arts: <form:checkbox path="preferences.interests" value="Defence Against the Dark Arts" />
				</td>
			</tr>

			<tr>
				<td>Favourite Word:</td>
				<%-- Approach 3: Property is of type java.lang.Object --%>
				<td>Magic: <form:checkbox path="preferences.favouriteWord" value="Magic" />
				</td>
			</tr>
			<!-- ===== The checkbox tag end ===== -->

			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>