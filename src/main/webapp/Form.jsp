<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <form action="regform" method="post">
        Name :  <input type="text" name="name1" placeholder="Enter your name"/>  <br><br>
        Email : <input type="email" name="email1" placeholder="xyz@gmail.com"/>  <br><br>
        Password : <input type="password" name="pass1"/>  <br><br>
        Gender : <input type="radio" name="gender1"  value="male"/> Male<input type="radio" name="gender1" value="female" /> Female<br><br>
        City :
          <select name="city1">
             <option> Select City</option>
             <option>Delhi</option>
             <option>Noida</option>
             <option>Gurgaon</option>
             <option>Ghaziabad</option>
           </select> <br> <br>
         <input type="submit" value="Register"/> &nbsp;
          <a href="login.jsp"><button type="button">Login</button> </a>
      </form>
    
</body>
</html>