
<%@include file="header.jsp" %>

<h1>All trucks page</h1><br>

<table border=1 width=1 cellspacing=2 cellpadding=2 align="">
    <thead>
    </thead>
    <tbody>

    <tr>
        <th>
            <c:out value="id"/>
        </th>
        <th>
            <c:out value="reg Number"/>
        </th>
        <th>
            <c:out value="duty size"/>
        </th>
        <th>
            <c:out value="capasity, tons"/>
        </th>
        <th>
            <c:out value="current city"/>
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
            <c:out value="${item.regNumber}"/>
        </td>
        <td>
            <c:out value="${item.dutySize}"/>
        </td>
        <td>
            <c:out value="${item.capasity}"/>
        </td>
        <td>
            <c:out value="${item.currentCity.name}"/>
        </td>
        <td>
                <%--<c:out value="${item.status}"/>--%>
            <c:if test="${item.status == 0}"><c:out value="defective"/></c:if>
            <c:if test="${item.status == 1}"><c:out value="ok"/></c:if>
        </td>
        <td>
            <a href=/UpdateTruckServlet?id=${item.id}>update</a>
        </td>
        <td>
            <a href=/DeleteTruckServlet?id=${item.id} onclick="return confirm('Are you sure?')">delete</a>
        </td>

        </c:forEach>

    </tbody>
</table>

<%@include file="footer.jsp" %>
