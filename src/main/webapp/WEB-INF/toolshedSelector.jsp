<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>


    <jsp:body>

        <h1>Choose toolshed here</h1>

        <form action="ToolShedLoaderServlet" method="post">
            <label> Select length in metres </label>
            <select name="LengthValueTS">
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
            <br>
            <label> Select width in metres </label>
            <select name="WidthValueTS">
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

            <h6>Confirm choice</h6>
            <h6>Go to payment</h6>
            <input type="submit" value="x">
        </form>


        </select>
        <br>

        </form>

    </jsp:body>
</t:pagetemplate>