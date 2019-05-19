<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h3>Servlet Controller Edit</h3>
        <form action="Controller">
            <p>Please use this form to enter the data relating to your home address</p>
            <input type="text" name="address" value="${param.address}">
            <input type="submit" name="confirmButton" value="Confirm">
        </form>
        <p>Address entered : ${param.address}</p>
    </body>
</html>