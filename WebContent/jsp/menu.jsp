<%@ page import = "java.util.Calender" %>
<%@ taglib prefix = "tag" uri="http://www.adehrmawan.com/dateFormatter" %>

<header class = "mdl-layout__header">
    <div class = "mdl-layout__header-row">
        <!-- Title -->>
        <span class = "mdl-layout-title">Mongo Restful Task</span>
        <!-- Add spacer, to alighn navigation to the right -->
        <div class = "mdl-layout-spacer"></div>
        <!-- Navigation. We hide it in small screens. -->
        <tag:formatDate date = "<% Calender.getInstance().getTime() %>" format = "dd-MM-YYYY hh:mm"></tag:formatDate>
        <nav class = "mdl-navigation mdl-layout--large-screen-only">
            <a class = "mdl-navigation__link" href="/MRT/new">Add New Record</a>
            <a class = "mdl-navigation__link" href="/MRT/list">List All Records</a>
        </nav>
    </div>
</header>
<div class = "mdl-layout__drawer">
    <span class = "mdl-layout-title">MRT</span>
    <nav class = "mdl-navigation">
            <a class = "mdl-navigation__link" href="/MRT/new">Add New Record</a>
            <a class = "mdl-navigation__link" href="/MRT/list">List All Records</a>
    </nav>
</div>