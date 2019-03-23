<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
    <h1> All invoices </h1>

    <div class="row" style="margin: auto;">
        <div class="col-sm-5">

            <ul class="list-group">
            <c:forEach var="user" items="${users}">
                <br>
                <li class="list-group-item"> <h5> Orders for: ${user.email}</h5>
                    <ul class="list-group">
                        <c:forEach var="looporder" items="${user.orders}">
                            <li class="list-group-item">
                                <!--  Button to show an order with.  -->
                                <form method="post" action="FrontController">
                                    <input type="hidden" name="command" value="Product">
                                    <input type="hidden" name="origin" value="employeeorders">
                                    <input type="hidden" name="id" value="${looporder.id}">
                                    <button type="submit" class="btn btn-dark">
                                        Id of order: ${looporder.id} - Sent: ${looporder.sent}
                                    </button>
                                </form>

                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>

    </div>
    <div class="col-sm-7">



        <c:if test="${not empty BOM}">
            <jsp:include page='/bomtable.jsp'></jsp:include>

            <!--  Button to send an order with  -->
            <c:if test="${not order.sent}">

                <form method="post" action="FrontController">
                    <input type="hidden" name="command" value="Product">
                    <input type="hidden" name="origin" value="sendOrder">
                    <input type="hidden" name="id" value="${order.id}">
                    <button type="submit" class="btn btn-success">Send the Order to the customer</button>
                </form>

            </c:if>

        </c:if>

    </div>
</div>       
<jsp:include page='/footer.jsp'></jsp:include>
