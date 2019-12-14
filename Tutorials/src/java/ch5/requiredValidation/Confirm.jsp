<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <h3>Confirm</h3>
        <p>Please confirm the data entered before submitting</p>
        <p><b>Name : </b> ${helper.data.name}</p>
        <p><b>Address : </b> ${helper.data.address}</p>
        <p><b>Days Per Week : </b> ${helper.data.daysPerWeek}</p>
        
        <form action="Controller">
            <input type="submit" name="editButton" value="Edit">
            <input type="submit" name="processButton" value="Process">
        </form>
    </body>
</html>
