<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Header.jsp"/>



<table>
    <c:forEach items="${account1}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${product.bank}" /></td>
            <td><c:out value="${product.amount}" /></td>
            <td><c:out value="${product.user}" /></td>
        </tr>
    </c:forEach>
</table>



<jsp:include page="Footer.jsp"/>
