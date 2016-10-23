<%@include file="header.jsp" %>

<h1>Add order page</h1><br>

<form action="/AddNewOrderServlet" method="get">
    <input type="hidden" name="id" value="${order.id}" />

    Uid:<br>
    <input type="text" name="uid" value="${order.uid}"/><br>

    Status:<br>
    <input type="text" name="status" value="${order.status}"/><br>

    CurrentTruck:<br>
    <select name="currentTruck">
        <option disabled selected value> -- select an option -- </option>
        <c:forEach var="item" items="${truckAll}">
            <option value="${item.id}"
                    <%--<c:if test="${item.regNumber==order.currentTruck.regNumber}">--%>
                        <%--<c:out value="selected"/>--%>
                    <%--</c:if>--%>
                    >
                <c:out value="${item.regNumber}"/>
            </option>
        </c:forEach>
    </select><br>

    DriverList:<br>
        <c:forEach var="item" items="${driverAll}">
            <input type="checkbox" name="driver${item.id}" value="${item.id}">
                <c:out value="${item.firstName}"/><br>
        </c:forEach>
    </select><br><br>


    <input type="submit" name="update" value="submit"/>
    <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllOrdersServlet'"/>
</form>

<%@include file="footer.jsp" %>