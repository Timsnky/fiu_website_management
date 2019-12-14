<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h3>Edit</h3>
        <form action="Controller" method="POST">
            <p>Please use this form to provide your details</p>
            <p>
                <label>Name :</label>
                <input type="text" name="name" value="${helper.data.name}">
                <small>${helper.errors.name}</small>
            </p>
            <p>
                <label>Address :</label>
                <input type="text" name="address" value="${helper.data.address}">
                <small>${helper.errors.address}</small>
            </p>
            <p>
                <label>Days Per Week :</label>
                <input type="text" name="daysPerWeek" value="${helper.data.daysPerWeek}">
                <small>${helper.errors.daysPerWeek}</small>
            </p>
            <input type="submit" name="confirmButton" value="Confirm">
        </form>
        <p>Name entered : ${helper.data.name}</p>
        <p>Address entered : ${helper.data.address}</p>
        <p>Days Per Week entered : ${helper.data.daysPerWeek}</p>
    </body>
</html>