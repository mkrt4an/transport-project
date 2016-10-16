<%@include file="header.jsp" %>

<form action="/UpdateTruckServletConfirmed" method="get">
    <input type="hidden" name="id" value="${truck.id}" />
    dutySize:<br>
    <input type="text" name="dutySize" value="${truck.dutySize}"/><br>
    capasity:<br>
    <input type="text" name="capasity" value="${truck.capasity}"/><br>
    regNumber:<br>
    <input type="text" name="regNumber" value="${truck.regNumber}"/><br>
    status:<br>
    <input type="text" name="status" value="${truck.status}"/><br>

    currentCity:<br>
    <select name="city">
        <c:forEach var="item" items="${cityAll}">
            <option value="${item.id}"
                    <c:if test="${item.name==truck.currentCity.name}">
                        <c:out value="selected"/>
                    </c:if>>
                <c:out value="${item.name}"/>
            </option>
        </c:forEach>
    </select><br><br>

    <input type="submit" name="update" value="submit"/>
    <input type="button" name="Cancel" value="Back" onclick="location.href='/GetAllTrucksServlet'"/>
</form>

<%@include file="footer.jsp" %>
