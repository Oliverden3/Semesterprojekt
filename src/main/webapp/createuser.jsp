<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen til Fog's carporte!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen til Fog's carporte!
    </jsp:attribute>

    <jsp:body>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p> Login her eller lav en bruger:  <br> <br>
                <a href="login.jsp">Login</a></p>
            <a href="createuser.jsp">Create User</a>
        </c:if>



    </jsp:body>

</t:pagetemplate>