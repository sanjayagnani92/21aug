<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Students DATA</h1>  
    <table border="2" width="70%" cellpadding="2">  
<tr><th>Username</th><th>Maths</th><th>Marks</th><th>SS</th><th>Marks</th></tr>  
   <c:forEach var="emp" items="${list1}">   
   <tr>  
   <td>${emp.username}</td>  
   
   <td>${emp.sub_maths}</td>  
   <td>${emp.sub_maths_marks}</td>  
   <td>${emp.sub_ss}</td>  
   <td>${emp.sub_ss_marks}</td>  
      					 
      					 <form:form modelAttribute="students" action="editsave" method="post">
            <td>
                            <form:input path="sub_maths" value ="${emp.sub_maths}"></form:input>
                        </td>
                     <td>
                            <form:input path="sub_maths_marks" value ="${emp.sub_maths_marks}"></form:input>
                        </td>
                     <td>
                            <form:input path="sub_ss" value ="${emp.sub_ss}"></form:input>
                        </td>
                     <td>
                            <form:input path="sub_ss_marks" value ="${emp.sub_ss_marks}"></form:input>
                        </td>
                    </form:form>
   
   <td><a href="#">SAVE</a></td>  
  
   </tr>  
   </c:forEach>  
   </table>  
    
 <a href="logout">Logout</a>