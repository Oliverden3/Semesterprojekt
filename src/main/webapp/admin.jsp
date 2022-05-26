<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

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
                <tr><th>ID</th><th>Date</th><th>Længde:</th><th>Bredde:</th><th>Se stykliste</th><th>Bekræft ordre</th></tr>
            </thead>
        <c:forEach items="${requestScope.orderList}" var="order">
            <tr><td>${order.idOrders}</td><td>${order.date}</td><td>${order.length}</td><td>${order.width}</td><td><button name="idOrders" value="${order.idOrders}" formaction="PartslistServlet">Stykliste</button></td>
                <td><button align="right" style="text-align:center; font-size:150%; font-weight:bold; color:green;" name="confirm" value="${order.idOrders}" formaction="ConfirmOrderServlet">&#10004;</button></td> <td><button align="center" style="text-align:center; font-size:150%; font-weight:bold; color:red;" name="decline" value="${order.idOrders}" formaction="DeclineOrderServlet">&#10006;</button></td></tr>
        </c:forEach>

        </table>
        </form>
    </jsp:body>
</t:pagetemplate>