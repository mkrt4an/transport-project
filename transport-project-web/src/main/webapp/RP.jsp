<%@include file="header.jsp" %>

<h1>RoutePoint</h1>


<div id="city">
    <form name="NewCity" action="/new-city">
    City:
    <select id="cityListMain" name="cityId" required>
        <option disabled selected value> -- select a city -- </option>
        <c:forEach var="item" items="${cityAll}">
            <option value="${item.id}"
                    <c:if test="${item.id==routePoint.city.id}">
                        <c:out value="selected"/>
                    </c:if>>
                <c:out value="${item.name}"/>
            </option>
        </c:forEach>
    </select>
        <input id="citySubmit" type="submit" value="ADD" name=""/>

        <input hidden name="routePointId" value="${routePointId}"/>
        <input hidden name="orderId" value="${orderId}"/>
    </form>
</div>

<hr>

<div id="main">
    <div id="load">
        <form name="NewLoad" action="/new-cargo">
            New load<br><br>

            name: <input id="input" type="text" required name="cargoName"/><br/><br>
            weight: <input id="number" type="number" required name="cargoWeight" value=""/><br/><br>

            <input hidden name="routePointId" value="${routePointId}"/>
            <input hidden name="cityId" value="${cityId}"/>
            <input hidden name="orderId" value="${orderId}"/>

            <input id="cargoSubmit" type="submit" value="ADD" name=""/>
        </form>
    </div>


    <div id="added">
        added<br><br>
        <table border="1px">
            <tr>
                <th>name</th>
                <th>weight</th>
            </tr>
            <c:forEach var="item" items="${cargoToLoadList}">
                <tr>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.weight}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<hr>

<div id="delivery">
    delivery <br>
    <table border=1px>
        <tr>
            <th>Check</th>
            <th>name</th>
            <th>weight</th>
        </tr>
        <c:forEach var="item" items="${cargoToLoadList}">
            <tr>
                <td><input type="checkbox"></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.weight}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

<hr>

<div>
    <form name="NewRoutePoint" action="/route-point">
        <input hidden name="routePointId" value="${routePointId}"/>
        <input hidden name="cityId" value="${cityId}"/>
        <input hidden name="orderId" value="${orderId}"/>
        <input id="routePointSubmit" type="submit" value="ADD RP" name="ADD RP"/>
    </form>

    <form name="ready" action="/ready">
        <input hidden name="routePointId" value="${routePointId}"/>
        <input hidden name="cityId" value="${cityId}"/>
        <input hidden name="orderId" value="${orderId}"/>
        <input id="ready" type="submit" value="READY" name="READY"/>
    </form>
</div>



<%@include file="footer.jsp" %>