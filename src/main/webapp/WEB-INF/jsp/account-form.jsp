<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add account</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">

        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Account</div>
            </div>
            <div class="panel-body">
                <form:form action="saveAccount" cssClass="form-horizontal"
                           method="post" modelAttribute="account">

                    <!-- need to associate this data with customer id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="accountNumber" class="col-md-3 control-label">accountNumber</label>
                        <div class="col-md-9">
                            <form:input path="accountNumber" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bank" class="col-md-3 control-label">bank</label>
                        <div class="col-md-9">
                            <form:input path="bank" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="amount" class="col-md-3 control-label">amount</label>
                        <div class="col-md-9">
                            <form:input path="amount" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="user" class="col-md-3 control-label">user</label>
                        <div class="col-md-9">
                            <form:input path="user" cssClass="form-control" />
                        </div>
                    </div>

                   <%-- <div class="form-group">
                        <label for="email" class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <form:input path="email" cssClass="form-control" />
                        </div>
                    </div>--%>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>