<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="Header.jsp"/>


<form action="@/{FormResponse}" th:th:action="@{/FormResponse}" th:object="${account}" method="post">
    <p>Id: <input type="text" th:field="*{id}" /></p>
    <p>FirstName: <input type="text" th:field="*{firstName}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>


<jsp:include page="Footer.jsp"/>