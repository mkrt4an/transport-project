
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
            <c:out value="name"/>
        </th>
        <th>
            <c:out value="weight"/>
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
            <c:out value="${item.name}"/>
        </td>
        <td>
            <c:out value="${item.weight}"/>
        </td>
        <td>
            <c:out value="${item.status}"/>
        </td>
        <td>
            <a href=/UpdateCargoServlet?id=${item.id}>update</a>
        </td>
        <td>
            <a href=/DeleteCargoServlet?id=${item.id} onclick="return confirm('Are you sure?')">delete</a>
        </td>

        </c:forEach>

    </tbody>
</table>

<%@include file="footer.jsp" %>

