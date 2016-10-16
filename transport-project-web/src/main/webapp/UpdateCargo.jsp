<%@include file="header.jsp" %>

<form action="/UpdateCargoServletConfirmed" method="get">
    <input type="hidden" name="id" value="${cargo.id}" />
    name:<br>
    <input type="text" name="name" value="${cargo.name}"/><br>
    weight:<br>
    <input type="text" name="weight" value="${cargo.weight}"/><br>
    status:<br>
    <input type="text" name="status" value="${cargo.status}"/><br><br>

    <input type="submit" name="update" value="submit"/>
    <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllCargoServlet'"/>
</form>

<%@include file="footer.jsp" %>
