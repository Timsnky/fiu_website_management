<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <h3>Servlet Controller Confirm</h3>
        <p>Please confirm the data entered before submitting</p>
        <p><b>Address : </b> ${param.address}</p>
        
        <form action="Controller">
            <input type="hidden" name="address" value="${param.address}">
            <input type="submit" name="editButton" value="Edit">
            <input type="submit" name="processButton" value="Process">
        </form>
    </body>
</html>
