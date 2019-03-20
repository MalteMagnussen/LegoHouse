<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
    <h1> All invoices </h1>
    <div class="row" style="margin: auto;">
        <div class="col-sm-6">

            <ul>
            <c:forEach var="user" items="${users}">
                <br>
                <li> <h5> Orders for: ${user.name}</h5>
                    <ul>
                        <c:forEach var="order" items="${user.orders}">
                            <li>

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


        <c:if test="${not empty BOM}">
            <c:if test="${not order.sent}">

                <form method="post" action="FrontController">
                    <input type="hidden" name="command" value="Product">
                    <input type="hidden" name="origin" value="sendOrder">
                    <input type="hidden" name="id" value="${order.id}">
                    <input type="submit" value="Send order"/>
                </form>

            </c:if>


            <!--  Below is the Table for an Invoice  -->
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
                        <td>door.getFours()</td>
                        <td>wide1.getFours()</td>
                        <td>window.getFours()</td>
                        <td>wide2.getFours()</td>
                        <td>bom.getTotalFours()</td>
                    </tr>

                    <tr>
                        <td> 2x2 </td>
                        <td>door.getTwos()</td>
                        <td>wide1.getTwos()</td>
                        <td>window.getTwos()</td>
                        <td>wide2.getTwos()</td>
                        <td>bom.getTotalTwos()</td>
                    </tr>

                    <tr>
                        <td> 1x2 </td>
                        <td>door.getOnes()</td>
                        <td>wide1.getOnes()</td>
                        <td>window.getOnes()</td>
                        <td>wide2.getOnes()</td>
                        <td>bom.getTotalOnes()</td>
                    </tr>


                </tbody>
            </table>
        </c:if>
    </div>
</div>       
<jsp:include page='/footer.jsp'></jsp:include>
