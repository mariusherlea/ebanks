
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Header.jsp"/>

<%--<input type="button" value="Add Accounts" onclick="window.location.href='/account/save'; return false;"/>--%>

<table>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.id}</td>
            <td><c:out value="${account.bank}" /></td>
            <td><c:out value="${account.amount}" /></td>
            <td><c:out value="${account.user}" /></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="Footer.jsp"/>