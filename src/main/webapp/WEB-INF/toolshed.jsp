<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
             ToolShed
    </jsp:attribute>

    <jsp:body>
    <c: forEach items ="${sessionScope.toolShedList}" var = "TSlist">
        <option value="TSWidth">
            <column>${TSlist.width}</column>
        </option>
    </c:>
        <c: forEach items ="${sessionScope.toolShedList}" var = "TSlist">
            <option value="TSLength">
                <column>${TSlist.length}</column>
            </option>
        </c:>
    </jsp:body>
</t:pagetemplate>