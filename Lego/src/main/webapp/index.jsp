<jsp:include page='header.jsp'></jsp:include>

    <a href="LoginPage.jsp">LoginPage</a><br>
    <a href="registration.jsp">RegisterPage</a>

<% String error = (String) request.getAttribute("error");
    if (error != null) {
        out.println("<H2>Error!!</h2>");
        out.println(error);
    }
%>

<jsp:include page='footer.jsp'></jsp:include>
