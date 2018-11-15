<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form method="post" action="/battleship/registration">
    <label for="nickname">Enter your nickname:</label>
    <input id="nickname" type="text" name="nickname">
    ${errorHolder.message}
    <br>
    <button type="submit">Start!</button>
</form>

</body>
</html>
