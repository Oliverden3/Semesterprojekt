<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<t:pagetemplate>
    <jsp:attribute name="header">
    Betaling
    </jsp:attribute>

    <jsp:body>
        Yoyo tjek den ud
        ${sessionScope.carport.length}


    </jsp:body>
</t:pagetemplate>