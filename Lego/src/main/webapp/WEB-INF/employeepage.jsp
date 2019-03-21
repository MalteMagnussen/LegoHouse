<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
    <h1> All invoices </h1>
    <div class="row" style="margin: auto;">
        <div class="col-sm-6">

            <ul>
            <c:forEach var="user" items="${users}">
                <br>
                <li> <h5> Orders for: ${user.email}</h5>
                    <ul>
                        <c:forEach var="order" items="${user.orders}">
                            <li>
                                <!--  Button to show an order with.  -->
                                <form method="post" action="FrontController">
                                    <input type="hidden" name="command" value="Product">
                                    <input type="hidden" name="origin" value="employeeorders">
                                    <input type="hidden" name="id" value="${order.id}">
                                    <input type="submit" value="Id of order: ${order.id} - Sent: ${order.sent}">
                                </form>

                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>

    </div>
    <div class="col-sm-6">

        <script>
            $(document).ready(function () {
                $('#order').DataTable();
            });
        </script>

        <c:if test="${not empty BOM}">

            <!--  Button to send an order with  -->
            <c:if test="${not order.sent}">

                <form method="post" action="FrontController">
                    <input type="hidden" name="command" value="Product">
                    <input type="hidden" name="origin" value="sendOrder">
                    <input type="hidden" name="id" value="${order.id}">
                    <input type="submit" value="Send order"/>
                </form>

            </c:if>

            <!--  Below is the Table for a Bill of Materials  -->
            <table border="3" width="2" cellspacing="2" cellpadding="2" id="order" class="display">

                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Side m. dør.</th>
                        <th>Bredside</th>
                        <th>Side m. vindue</th>
                        <th>Bredside</th>
                        <th>ialt<th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td> 2x4 </td>
                        <td>${BOM.door.fours}</td>
                        <td>${BOM.wide.fours}</td>
                        <td>${BOM.window.fours}</td>
                        <td>${BOM.wide.fours}</td>
                        <td>${BOM.totalfours}</td>
                    </tr>

                    <tr>
                        <td> 2x2 </td>
                        <td>${BOM.door.twos}</td>
                        <td>${BOM.wide.twos}</td>
                        <td>${BOM.window.twos}</td>
                        <td>${BOM.wide.twos}</td>
                        <td>${BOM.totaltwos}</td>
                    </tr>

                    <tr>
                        <td> 1x2 </td>
                        <td>${BOM.door.ones}</td>
                        <td>${BOM.wide.ones}</td>
                        <td>${BOM.window.ones}</td>
                        <td>${BOM.wide.ones}</td>
                        <td>${BOM.totalones}</td>
                    </tr>

                </tbody>

            </table>

        </c:if>

    </div>
</div>       
<jsp:include page='/footer.jsp'></jsp:include>
