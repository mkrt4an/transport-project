
<%@include file="header.jsp" %>

<table border=1 width=1 cellspacing=2 cellpadding=2>
<thead>
</thead>
<tbody>
    <tr>
        <th>
            <c:out value="id"/>
        </th>
        <th>
            <c:out value="firstName"/>
        </th>
        <th>
            <c:out value="lastName"/>
        </th>
        <th>
            <c:out value="workedHours"/>
        </th>
        <th>
            <c:out value="currentCity"/>
        </th>
        <th>
            <c:out value="currentTruck"/>
        </th>
        <th>
            <c:out value="status"/>
        </th>
        <th>
            <c:out value="update"/>
        </th>
        <th>
            <c:out value="delete"/>
        </th>
    </tr>

    <c:forEach var="item" items="${list}">
        <tr>
            <td>
                <c:out value="${item.id}"/>
            </td>
            <td>
                <c:out value="${item.firstName}"/>
            </td>
            <td>
                <c:out value="${item.lastName}"/>
            </td>
            <td>
                <c:out value="${item.workedHours}"/>
            </td>
            <td>
                <c:out value="${item.currentCity.name}"/>
            </td>
            <td>
                <c:out value="${item.currentTruck.regNumber}"/>
            </td>
            <td>
                <c:out value="${item.status}"/>
            </td>
            <td>
                <a href=/UpdateDriverServlet?id=${item.id}>update</a>
            </td>
            <td>
                <a href=/DeleteDriverServlet?id=${item.id} onclick="return confirm('Are you sure?')">delete</a>
            </td>

    </c:forEach>

</tbody>
</table>

<%@include file="footer.jsp" %>

