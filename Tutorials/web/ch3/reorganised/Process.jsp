<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Page</title>
    </head>
    <body>
        <h3>Process</h3>
        <p>Please confirm the data entered before submitting</p>
        <p><b>Address : </b> ${helper.data.name}</p>
        <p><b>Address : </b> ${helper.data.address}</p>
        
        <form action="Controller">
            <input type="hidden" name="name" value="${helper.data.name}">
            <input type="hidden" name="address" value="${helper.data.address}">
            <input type="submit" name="editButton" value="Edit">
        </form>
    </body>
</html>
