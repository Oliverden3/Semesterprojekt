<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 12-05-2022
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Quickbyg
    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <p> Det er Quickbyg siden </p>

        <form action="/startcode_war_expoded/" method="post" id="form2">
            <button type="back" form="form2" value="Back">Back</button>
        </form>



    </jsp:body>

</t:pagetemplate>
