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
<tr><th>UName</th><th>FN</th><th>LN</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   
   <td>${emp.username}</td>  
   <td>${emp.firstname}</td>  
   <td>${emp.lastname}</td>  
   </tr>  
   </c:forEach>  
   </table>  


</body>
</html>