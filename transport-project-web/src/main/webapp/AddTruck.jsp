<%@include file="header.jsp" %>

<h1>Add truck page</h1><br>

<form action="/AddNewTruckServlet" method="get">
    <input type="hidden" name="id" value="${truck.id}"/>

    RegNumber:<br>
    <input type="text" name="regNumber" required placeholder="enter reg number" value="${truck.regNumber}"/><br><br>

    DutySize:<br>
    <input type="number" name="dutySize" required placeholder="enter duty size" value="${truck.dutySize}"/><br><br>

    Capasity:<br>
    <input type="number" name="capasity" required placeholder="enter capasity" value="${truck.capasity}"/><br><br>

    Status:<br>
    <%--<input type="text" name="status" required placeholder="enter status" value="${truck.status}"/><br><br>--%>
    <select name="status" required>
        <option disabled selected value> -- select a status -- </option>
        <option value="0" <c:if test="${truck.status == 0}"><c:out value="selected"/></c:if>> defective </option>
        <option value="1" <c:if test="${truck.status == 1}"><c:out value="selected"/></c:if>> ok </option>
    </select><br><br>


    CurrentCity:<br>
    <select name="city" required>
        <option disabled selected value> -- select a city--</option>
        <c:forEach var="item" items="${cityAll}">
            <option value="${item.id}"
                <%--<c:if test="${item.name==truck.currentCity.name}">--%>
                <%--<c:out value="selected"/>--%>
                <%--</c:if>--%>
            >
                <c:out value="${item.name}"/>
            </option>
        </c:forEach>
    </select><br><br>

    <input type="submit" name="update" value="submit"/>
    <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllTrucksServlet'"/>
</form>

<%@include file="footer.jsp" %>
