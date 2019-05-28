<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang = "en">
<%@ include file = "../jsp/head.jsp" %>
<body>
    <div class = "mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <%@ include file = "../jsp/menu.jsp" %>
        <main class = "mdl-layout__content">
            <div class = "page-content">
                <div class = "mdl-grid center-items">
                    <div class = "mdl-cell mid-cell--4-col">
                        <div class = "mdl-card mdl-shadow--6dp">
                            <div class = "mdl-card__title mdl-color--primary mdl-color-text--white">
                                <h2 class = "mdl-card__title mdl-color--primary mdl-color-text--white">
                                    <c:if test = "${stuff != null}">Edit Record</c:if>
                                    <c:if test = "${stuff == null}">Add New Records</c:if>>
                                </h2>
                            </div>
                            <div class = "mdl-card__supporting-text">
                                <c:if test = "${record != null}">
                                    <form name="mrtForm" action="update" method="post" onsubmit="return validateForm()">
                                </c:if>
                                <c:if test = "${record != null}">
                                    <form name="mrtForm" action="insert" method="post" onsubmit="return validateForm()">
                                </c:if>
                                <c:if test = "${record != null}">
                                    <input type="hidden" name="id" value = "<c:out value = "${record.id}">" />
                                </c:if>

                                <div class = "mdl-textfield mdl-js-textfield">
                                    <input class = "mdl-textfield__input" type = "text" name = "name" value = "<c:out value = '${record.name}' />" id = "name" /> <label class = "mdl-textfield__label" for = "name">Name</label>
                                </div>
                                <div class = "mdl-textfield mdl-js-textfield">
                                        <input class = "mdl-textfield__input" type = "text" name = "address" value = "<c:out value = '${record.address}' />" id = "address" /> <label class = "mdl-textfield__label" for = "address">Address</label>
                                </div>
                                <div class = "mdl-textfield mdl-js-textfield">
                                        <input class = "mdl-textfield__input" type = "text" name = "contact" value = "<c:out value = '${record.contact}' />" id = "address" /> <label class = "mdl-textfield__label" for = "contact">Contact</label>
                                </div>
                                <div class = "mdl-textfield mdl-js-textfield">
                                        <input class = "mdl-textfield__input" type = "text" name = "organisation" value = "<c:out value = '${record.organisation}' />" id = "address" /> <label class = "mdl-textfield__label" for = "organisation">Organisation</label>
                                </div>

                                <input type = "submit" class = "mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">

                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>