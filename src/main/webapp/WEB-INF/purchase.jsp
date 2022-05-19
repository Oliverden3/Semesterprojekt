<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
    Betaling
    </jsp:attribute>

    <jsp:body>
        Yoyo tjek den ud
        <br>
        <br>
        Dimensions of the carport:
        L: ${sessionScope.order.length}cm
        W: ${sessionScope.order.width}cm
        <br>
        Dimensions of the toolshed:
        L:${sessionScope.toolshed.length}cm
        W: ${sessionScope.toolshed.width}cm


    </jsp:body>
</t:pagetemplate>