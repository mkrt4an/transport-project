<%@include file="header.jsp" %>

<form action="/AddNewCargoServlet" method="get">

    name:<br>
    <input type="text" name="name" required placeholder="enter name" pattern="^^[а-яА-ЯёЁa-zA-Z]+$" maxlength="10"/><br><br>

    weight, kg:<br>
    <input type="number" name="weight" required placeholder="enter weight, kg" min="1" max="100000" maxlength="10"/><br><br>

    status:<br>
    <%--<input type="text" name="status" required placeholder="select status"/><br><br>--%>
    <select name="status" required >
        <option disabled selected value> -- select a status -- </option>
        <option value="1">ready</option>
        <option value="2">shipped</option>
        <option value="3">delivered</option>
    </select><br><br>

    <input type="submit" name="update" value="Submit"/>
        <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllCargoServlet'"/>
</form>


<%@include file="footer.jsp" %>