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
                <input type="text" name="name" value="${userData.name}"></p>
            <p>
                <label>Address :</label>
                <input type="text" name="address" value="${userData.address}">
            </p>
            <input type="submit" name="confirmButton" value="Confirm">
        </form>
        <p>Name entered : ${userData.name}</p>
        <p>Address entered : ${userData.address}</p>
    </body>
</html>