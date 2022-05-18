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
                    <column>150</column>
                </option>
                <option>
                    <column>180</column>
                </option>
                <option>
                    <column>210</column>
                </option>
                <option>
                    <column>240</column>
                </option>
                <option>
                    <column>270</column>
                </option>
                <option>
                    <column>330</column>
                </option>
                <option>
                    <column>360</column>
                </option>
                <option>
                    <column>390</column>
                </option>
                <option>
                    <column>420</column>
                </option>
                <option>
                    <column>450</column>
                </option>
                <option>
                    <column>480</column>
                </option>
                <option>
                    <column>510</column>
                </option>
                <option>
                    <column>540</column>
                </option>
                <option>
                    <column>570</column>
                </option>
                <option>
                    <column>600</column>
                </option>
                <option>
                    <column>630</column>
                </option>
                <option>
                    <column>660</column>
                </option>
                <option>
                    <column>690</column>
                </option>
            </select>

            <br>
            <br>
            <label> Select width in metres </label>
            <select name="WidthValueTS">
                <option>
                    <column>210</column>
                </option>
                <option>
                    <column>240</column>
                </option>
                <option>
                    <column>270</column>
                </option>
                <option>
                    <column>330</column>
                </option>
                <option>
                    <column>360</column>
                </option>
                <option>
                    <column>390</column>
                </option>
                <option>
                    <column>420</column>
                </option>
                <option>
                    <column>450</column>
                </option>
                <option>
                    <column>480</column>
                </option>
                <option>
                    <column>510</column>
                </option>
                <option>
                    <column>540</column>
                </option>
                <option>
                    <column>570</column>
                </option>
                <option>
                    <column>600</column>
                </option>
                <option>
                    <column>630</column>
                </option>
                <option>
                    <column>660</column>
                </option>
                <option>
                    <column>690</column>
                </option>
                <option>
                    <column>720</column>
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