<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <h3>Three Pages Confirm</h3>
        <p>Please confirm the data entered before submitting</p>
        <p><b>Address : </b> ${param.address}</p>
        
        <form action="Edit.jsp">
            <input type="hidden" name="address" value="${param.address}">
            <input type="submit" value="Edit">
        </form>
        <form action="Process.jsp">
            <input type="hidden" name="address" value="${param.address}">
            <input type="submit" value="Process">
        </form>
    </body>
</html>
