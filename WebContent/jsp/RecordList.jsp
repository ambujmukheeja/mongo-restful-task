<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang = "en">
<%@ include file = "../jsp/head.jsp" %>
<body>
    <!-- Always shows a header, even in smaller screens. -->
    <div class = "mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <%@ include file = "../jsp/menu.jsp" %>

        <main class = "mdl-layout__content">
        <div class = "page-content">
            <div class = "mdl-grid center-items">
                <div class = "mdl-cell mdl-cell--4-col">
                    <div>
                        <table class = "mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                            <thread>
                                <tr>
                                    <th class = "mdl-data-table__cell--non-numeric"></th>
                                    <th>Name</th>
                                    <th>Address</th>
                                    <th>Contact</th>
                                    <th>Organisation</th>
                                    <th>Action</th>
                            </thread>
                            <tbody>
                                <c:set var = "count" value = "0" scope = "page">
                                <c:forEach var = "record" items = "${listRecord}">
                                    <c:set var = "count" value = "${count + 1}" scope = "page"/>
                                    <tr>
                                        <td class = "mdl-data-table__cell--non-numeric"><c:out value = "${count}" /></td>
                                        <td><c:out value = "${record.name}"/></td>
                                        <td><c:out value = "${record.address}"/></td>
                                        <td><c:out value = "${record.contact}"/></td>
                                        <td><c:out value = "${record.organisation}"/></td>
                                        <td><a href = "/MRT/edit?id = <c:out value = '${record.id}' />">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href = "MRT/delete?id = <c:out value = '${record.id}' />">Delete</a></td>
                                    </tr>
                                </c:forEach> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </main>
    </div>
</body>
</html>