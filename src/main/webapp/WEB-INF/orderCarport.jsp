<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
             Køb
    </jsp:attribute>


    <jsp:body><form action="PurchaseServlet">
    <label> Choose length: </label>
    <select>
        <c:forEach items="${sessionScope.listCarport}" var="CarportsL">

            <option value="listLength">
                <column>${CarportsL.length}</column>
                <column>m</column>
            </option>
        </c:forEach>
    </select>
    <br>
    <br>
    <label>Choose width:</label>
    <select>
        <c:forEach items="${sessionScope.listCarport}" var="CarportsW">
            <option value="listWidth">
                <column>${CarportsW.width}</column>
                <column>m</column>
            </option>
        </c:forEach>

    </select>
    <br>
    <h6>Submit order</h6>
    <input type="submit" value="Click here">
</form>

    </jsp:body>
</t:pagetemplate>