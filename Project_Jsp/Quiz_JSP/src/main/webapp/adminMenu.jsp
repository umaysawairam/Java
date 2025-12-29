<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello from AdminMenu</h3>
<div>
    <h2>MAIN MENU</h2>

    <form action="AdminController" method="post">
        <button type="submit" name="choice" value="1">Add Quiz</button><br/><br/>
        <button type="submit" name="choice" value="2">Update Quiz</button><br/><br/>
        <button type="submit" name="choice" value="3">Delete Quiz</button><br/><br/>
        <button type="submit" name="choice" value="4">List Quiz</button><br/><br/>
        <button type="submit" name="choice" value="5">View Scores</button><br/><br/>
        <button type="submit" name="choice" value="6">Logout</button><br/><br/>
    </form>
</div>
</body>
</html>