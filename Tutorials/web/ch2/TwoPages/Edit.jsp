<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h3>Two Directions Edit</h3>
        <form action="Confirm.jsp">
            <p>Please use this form to enter the data relating to your home address</p>
            <input type="text" name="address" value="${param.address}">
            <input type="submit" value="Confirm">
        </form>
        <p>Address entered : ${param.address}</p>
    </body>
</html>