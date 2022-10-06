<%@page import="com.valtech.dao.Employee"%>
<%@page import="com.valtech.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
</head>
<body>
    <%
        Employee e = (Employee) request.getAttribute("e");
    %>
    <form action="empctrl" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input name="id" type="text"  value="<%=e.getId()%>"readonly/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input name="name" type="text" /></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input name="age" type="text" /></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input name="gender" type="text" /></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input name="salary" type="text" /></td>
            </tr>
            <tr>
                <!--  <td><a href="empCtlr?submit=updateEmp&empId=<%= e.getId()%>"><button  >Update</button></a><td>-->
                <td><input type="submit" name="submit" value="updateEmp">
                <td><input type="submit" name="submit" value="cancel">
            </tr>





       </table>
    </form>



</body>
</html>