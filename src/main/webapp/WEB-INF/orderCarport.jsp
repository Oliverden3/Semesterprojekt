<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<t:pagetemplate>
    <jsp:attribute name="header">
             Køb
    </jsp:attribute>


    <jsp:body>
        </form>
        <br>
        <br>

        <form action="ChoiceServlet" method="post">
            <label> Select length in centimeters </label>
            <select name="LengthValue">
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
            </select>

            <br>
            <br>
            <label> Select width in metres </label>
            <select name="WidthValue">
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
                <option>
                    <column>750</column>
                </option>
                <option>
                    <column>780</column>
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