<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Test2.jsp</h1>
    
    <table border="1" width ="800" height="1000">
    
      <tr>
        <td colspan="2" height="200">
           <!-- <h1> TOP </h1> -->
           <jsp:include page="top.jsp"/>
        </td>
      </tr>
      <tr>
        <td width="200">
           <!-- <h1>LEFT</h1> -->
           <jsp:include page="left.jsp"></jsp:include>
        </td>
        <td>
           <h1>MAIN</h1>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="200">
           <!-- <h1>Bottom</h1> -->
           <jsp:include page="bottom.jsp"></jsp:include>
        </td>
      </tr>
     
    
    </table>
    
    
    
    
</body>
</html>