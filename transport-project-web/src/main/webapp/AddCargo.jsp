<%@include file="header.jsp" %>

<form action="/AddNewCargoServlet" method="get">

    name:<br>
    <input type="text" name="name"/><br><br>

    weight:<br>
    <input type="text" name="weight"/><br><br>

    status:<br>
    <input type="text" name="status"/><br><br>

    <input type="submit" name="update" value="Submit"/>
        <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllCargoServlet'"/>
</form>


<%@include file="footer.jsp" %>