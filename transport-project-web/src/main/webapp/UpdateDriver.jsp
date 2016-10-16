<%@include file="header.jsp" %>

    <form action="/UpdateDriverServletConfirmed" method="get">
            <input type="hidden" name="id" value="${driver.id}" />
        First name:<br>
            <input type="text" name="firstName" value="${driver.firstName}"/><br>
        Last name:<br>
            <input type="text" name="lastName" value="${driver.lastName}"/><br>
        worked hours:<br>
            <input type="text" name="workedHours" value="${driver.workedHours}"/><br>
        status:<br>
            <input type="text" name="status" value="${driver.status}"/><br>

        currentCity:<br>
        <select name="city">
            <c:forEach var="item" items="${cityAll}">
                <option value="${item.id}"
                        <c:if test="${item.name==driver.currentCity.name}">
                            <c:out value="selected"/>
                        </c:if>>
                    <c:out value="${item.name}"/>
                </option>
            </c:forEach>
        </select><br>

        currentTruck:<br>
        <select name="currentTruck">
            <%--<option disabled selected value> -- select an option -- </option>--%>
            <c:forEach var="item" items="${truckAll}">
                <option value="${item.id}"
                        <c:if test="${item.regNumber==driver.currentTruck.regNumber}">
                            <c:out value="selected"/>
                        </c:if>>
                    <c:out value="${item.regNumber}"/>
                </option>
            </c:forEach>
        </select><br><br>

        <input type="submit" name="update" value="submit"/>
        <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllDriversServlet'"/>
    </form>

<%@include file="footer.jsp" %>
