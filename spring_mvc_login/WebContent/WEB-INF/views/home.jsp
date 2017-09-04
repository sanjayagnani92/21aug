<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {
    margin:200px 0px; 
    padding:0;
    text-align:center;
}
</style>
</head>
<% response.setHeader("Cache-Control","no-cache");    %>
<%response.setHeader("Pragma","no-cache"); %>
 <body>
 Home Page
 <br>
 ${message}
  <% java.util.Date d = new java.util.Date();
                out.println(d.toString()); %>

 
        <table align="center">
            <tr>
                <td><a href="login">Login</a>
                </td>
                <td><a href="register">Register</a>
                </td>
            </tr>
        </table>
    </body>

</html>