<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="Header.jsp"/>

<form method="post" action="/addEmployee" modelAttribute="employee">


        Amount: <input type = "text" name = "amount">
        <br />
        Bank: <input type = "text" name = "bank" />
        <input type = "submit" value = "Submit" />
    </form>

    </form>

<jsp:include page="Footer.jsp"/>