<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>TransportProject</title>
    <link rel="stylesheet" href="styles.css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>



<header class="mainH">
    <hgroup>
        <h1>TransportProject Application</h1>
    </hgroup>
</header>

<nav>
    <ul class="main-menu">
        <li><a href="/AddDriver">Add New Driver</a></li>
        <li><a href="/AddTruck">Add New Truck</a></li>
        <li><a href="/AddCargo">Add New Cargo</a></li>
        <li><a href="/AddOrder">Add New Order</a></li>
        <li><a href="/GetAllDriversServlet">Get all Drivers</a></li>
        <li><a href="/GetAllTrucksServlet">Get all Trucks</a></li>
        <li><a href="/GetAllCargoServlet">Get all Cargoes</a></li>
        <li><a href="/GetAllOrdersServlet">Get all Orders</a></li>
    </ul>
</nav>