
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Header.jsp"/>

<%--<input type="button" value="Add Accounts" onclick="window.location.href='/account/save'; return false;"/>--%>

<table>
    <c:forEach items="${accounts}" var="account">


        <c:url var="updateLink" value="/account/updateForm">
            <c:param name="customerId" value="${account.id}" />
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/account/delete">
            <c:param name="customerId" value="${account.id}" />
        </c:url>

        <tr>
            <td>${account.id}</td>
            <td><c:out value="${account.bank}" /></td>
            <td><c:out value="${account.amount}" /></td>
            <td><c:out value="${account.user}" /></td>

            <td>
                <!-- display the update link --> <a href="${updateLink}">Update</a>
                | <a href="${deleteLink}"
                     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="Footer.jsp"/>