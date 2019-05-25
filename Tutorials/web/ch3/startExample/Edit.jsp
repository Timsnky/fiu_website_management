<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h3>Edit</h3>
        <form action="Controller">
            <p>Please use this form to provide your details</p>
            <p>
                <label>Name :</label>
                <input type="text" name="name" value="${param.name}"></p>
            <p>
                <label>Address :</label>
                <input type="text" name="address" value="${param.address}">
            </p>
            <input type="submit" name="confirmButton" value="Confirm">
        </form>
        <p>Name entered : ${param.name}</p>
        <p>Address entered : ${param.address}</p>
    </body>
</html>