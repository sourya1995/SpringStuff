<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Tennis Player DB</title>
</head>
<body>
    <h2>Welcome to the Tennis Player DATABASE!</h2>
    <h3>Player name: <i>${name}</i></h3>
    <form action="/player.do" method="POST">
       <b>Player name</b> <input type="text" name="name"/>
                          <input type="submit" value="Enter"/>
    </form>
</body>
</html>