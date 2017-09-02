<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${message}

User: ${firstname}


 
  
  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Username</th><th>Maths</th><th>Marks</th><th>SS</th><th>Marks</th></tr>  
   <c:forEach var="emp" items="${list1}">   
   <tr>  
   <td>${emp.username}</td>  
   
   <td>${emp.sub_maths}</td>  
   <td>${emp.sub_maths_marks}</td>  
   <td>${emp.sub_ss}</td>  
   <td>${emp.sub_ss_marks}</td>  
   
 
   
   </tr>  
   </c:forEach>  
  
   </table>  
<br>
  Result
 <a href="logout">Logout</a>

</body>
</html>