<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="/addMailBox" modelAttribute="mailBox">
    <table>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td><form:select path="languages" items="${typeLanguages}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${typePageSize}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamFillter">Spams filter: </form:label></td>
            <td><form:checkbox path="spamFillter"/><span>Enable spams filter</span></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
    </table>
    <button type="submit">Save</button>
</form:form>

</body>
</html>
