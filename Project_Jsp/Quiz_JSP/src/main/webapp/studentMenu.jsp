<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello from StudentMenu</h3>
<div>
    <h2>MAIN MENU</h2>

   <form action="StudentController" method="post">
        <button type="submit" name="choice" value="1">View Quizzes</button><br/><br/>
        <button type="submit" name="choice" value="2">Take Quiz</button><br/><br/>
        <button type="submit" name="choice" value="3">View Scores</button><br/><br/>
        <button type="submit" name="choice" value="4">Logout</button><br/><br/>
    </form>
</div>
</body>
</html>