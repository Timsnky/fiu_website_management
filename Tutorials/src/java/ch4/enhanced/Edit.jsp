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
                <input type="text" name="name" value="${helper.data.name}"></p>
            <p>
                <label>Address :</label>
                <input type="text" name="address" value="${helper.data.address}">
            </p>
            <input type="submit" name="confirmButton" value="Confirm">
        </form>
        <p>Name entered : ${helper.data.name}</p>
        <p>Address entered : ${helper.data.address}</p>
    </body>
</html>