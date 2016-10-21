<%@include file="header.jsp" %>

<h1>RoutePoint</h1>
<div id="city">
    City

<input list="browsers" name="browser">
<datalist id="browsers">
    <c:forEach var="item" items="${allCity}">
    <option value="${item.id}">
        </c:forEach>
</datalist>




</div>

<hr>

<div id="main">
    <div id="load">
        <form  label="asdasd" title="dsfsdf" name="" action="" >
            New load<br><br>
            name <input type="text" required name="" value=""/><br/><br>
            weight<input type="number" required name="" value=""/><br/><br>
            <input type="submit" value="ADD" name="" />
        </form>
    </div>
    <div id="added" >
        added<br><br>
        <table border="1px">
            <tr>
                <th>name</th>
                <th>weight</th>
            </tr>
            <tr>
                <td>asdasd</td>
                <td>asdasd</td>
            </tr>
            <tr>
                <td>tyty</td>
                <td>tytyt</td>
            </tr>

        </table>
    </div>
</div>

<hr>
<div id="delivery">
    delivery <br>
    <table border=1px>
        <tr>
            <td><input type="checkbox"></td>
            <td>sdfsdfsdf</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>sdfsdfsdf</td>
        </tr>
        <tr>
            <td><input type="checkbox"></td>
            <td>sdfsdfsdf</td>
        </tr>
    </table>
</div>
<hr>
<div>
    <input type="submit" value="ADD RP" name="ADD RP"/>
    <input type="button" value="READY" name="READY"/>
</div>



<%@include file="footer.jsp" %>