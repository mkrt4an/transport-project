<%@include file="header.jsp" %>

<form action="/AddNewDriverServlet" method="get">
    <input type="hidden" name="id" value="${driver.id}" />

    First name:<br>
    <input type="text" name="firstName" value="${driver.firstName}"/><br><br>

    Last name:<br>
    <input type="text" name="lastName" value="${driver.lastName}"/><br><br>

    worked hours:<br>
    <input type="text" name="workedHours" value="${driver.workedHours}"/><br><br>

    status:<br>
    <input type="text" name="status" value="${driver.status}"/><br><br>

    currentCity:<br>
    <select name="city">
        <option disabled selected value> -- select a city-- </option>
        <c:forEach var="item" items="${cityAll}">
            <option value="${item.id}"
                    <%--<c:if test="${item.name==driver.currentCity.name}">--%>
                        <%--<c:out value="selected"/>--%>
                    <%--</c:if>--%>
                    >
                <c:out value="${item.name}"/>
            </option>
        </c:forEach>
    </select><br><br>

    currentTruck:<br>
    <select name="currentTruck">
        <option disabled selected value> -- select a truck -- </option>
        <c:forEach var="item" items="${truckAll}">
            <option value="${item.id}"
                <%--<c:if test="${item.regNumber==order.currentTruck.regNumber}">--%>
                <%--<c:out value="selected"/>--%>
                <%--</c:if>--%>
            >
                <c:out value="${item.regNumber}"/>
            </option>
        </c:forEach>
    </select><br><br>

    <input type="submit" name="update" value="submit"/>
    <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllDriversServlet'"/>
</form>

<%@include file="footer.jsp" %>
