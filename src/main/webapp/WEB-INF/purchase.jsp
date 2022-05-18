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
        ${sessionScope.carport.length}m
        ${sessionScope.carport.width}m
        <br>
        Dimensions of the toolshed:
        ${sessionScope.toolshed.length}m
        ${sessionScope.toolshed.width}m


    </jsp:body>
</t:pagetemplate>