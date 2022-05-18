<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
             Køb
    </jsp:attribute>


    <jsp:body>
<%--        <form action="ChoiceServlet" method="post">--%>
<%--            <label> Choose length: </label>--%>
<%--            <select>--%>
<%--                <c:forEach items="${sessionScope.listCarport}" var="CarportsL">--%>
<%----%>
<%--                    <option value="listLength" name="listLength">--%>
<%--                        <column>${CarportsL.length}</column>--%>
<%--                        <column>m</column>--%>
<%--                    </option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            <br>--%>
<%--            <label>Choose width:</label>--%>
<%--            <select>--%>
<%--                <c:forEach items="${sessionScope.listCarport}" var="CarportsW">--%>
<%--                    <option value="listWidth" name="listWidth">--%>
<%--                        <column id>${CarportsW.width}</column>--%>
<%--                        <column>m</column>--%>
<%--                    </option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
        </form>
        <br>
        <br>

        <form action="ChoiceServlet" method="post">
            <label> Select length in metres </label>
            <select name="LengthValue">
                <option>
                    <column>1 </column>
                </option>
                <option>
                    <column>2</column>
                </option>
                <option>
                    <column>3</column>
                </option>
                <option>
                    <column>4</column>
                </option>
            </select>

            <br>
            <br>
            <label> Select width in metres </label>
            <select name="WidthValue">
                <option>
                    <column>1</column>
                </option>
                <option>
                    <column>2</column>
                </option>
                <option>
                    <column>3</column>
                </option>
                <option>
                    <column>4</column>
                </option>
            </select>
            <br>
            <h6>Want toolshed included?</h6>
            <input type="checkbox" id="skur" name="TSChoice">
            <label for="skur"> yes</label>
            <br>
            <h6>Go to payment</h6>
            <input type="submit" value="x">
        </form>


        </select>
        <br>

        </form>

    </jsp:body>
</t:pagetemplate>