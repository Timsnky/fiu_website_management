<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Simple Form</title>
    </head>
    <body>
        <h3>First Form</h3>
        <form action="">
            <p>Please use this form to enter the data relating to your home address</p>
            <input type="text" name="address">
            <input type="submit" value="Submit">
        </form>
        <p>Address entered : ${param.address}</p>
    </body>
</html>