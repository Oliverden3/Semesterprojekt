<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <h1>Admin test</h1>

        <form method="post">
        <table class="table table-striped">
            <thead>
                <tr><th>ID</th><th>Date</th><th>Action</th></tr>
            </thead>
        <c:forEach items="${requestScope.partsItemList}" var="partitem">
            <tr><td>${partitem.idPartslist}</td><td>${partitem.partDescription}</td><td></td></tr>
        </c:forEach>

        </table>
        </form>
    </jsp:body>
</t:pagetemplate>