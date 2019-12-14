<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Page</title>
    </head>
    <body>
        <h3>Process</h3>
        <p>Please confirm the data entered before submitting</p>
        <p><b>Name : </b> ${helper.data.name}</p>
        <p><b>Address : </b> ${helper.data.address}</p>
        <p><b>Days Per Week : </b> ${helper.data.daysPerWeek}</p>

        <form action="Controller" method="POST">
            <input type="submit" name="editButton" value="Edit">
        </form>
        <form action="Controller" method="GET">
            <input type="submit" name="editButton" value="New">
        </form>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
        <core:forEach var="row" items="${database}">
            ${row.id}, 
            ${row.name}, 
            ${row.address},
            ${row.daysPerWeek}<br>
        </core:forEach>
    </body>
</html>