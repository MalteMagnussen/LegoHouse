<%@page import="malte.entities.Side"%>
<%@page import="malte.entities.BOM"%>
<%@page import="java.util.List"%>
<%@page import="malte.entities.Order"%>
<%@page import="malte.entities.User"%>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
<% User user = (User) session.getAttribute("user");
    int userid = user.getId();%>
<h1 style="margin: 15px; float: top; display: flex; flex-direction: column; justify-content: center; text-align: center;">
    Logged in as: <%= user.getEmail()%> </h1>

<!-- Form start -->
<form action="FrontController" method="post" id="sitemenus" style="margin: auto; display: table; width: 90%">
    <!-- Hidden input: &command=Product -->
    <input type="hidden" name="command" value="Product">
    <!-- Hidden input: &origin=addProduct -->
    <input type="hidden" name="origin" value="addProduct">
    <!-- Hidden input: &id=User.getID() -->
    <input type="hidden" name="id" value="<% out.print(userid); %>">
    <!-- Table start. Table makes sure it's all organized neatly -->
    <table class="table table-striped">

        <!-- Headers of the table -->
        <thead>
            <tr>
                <th>Length - minimum 8</th>
                <th>Width - minimum 5</th>
                <th>Height - minimum 4</th>
                <th></th>
            </tr>
        </thead>

        <!-- Table body start -->
        <tbody>
            <tr>
                <!-- Length -->
                <td><input type="number" name="length" placeholder="Length" id="qtyInput"></td>
                <!-- Width -->
                <td><input type="number" name="width" placeholder="Width" id="qtyInput"></td>
                <!-- Height -->
                <td><input type="number" name="height" placeholder="Height" id="qtyInput"></td>
                <!-- Add to cart button -->
                <td><input type="submit" name="submit" value="Order"></td>
            </tr>
            <!-- Table Body end -->
        </tbody>
        <!-- Table end -->    
    </table>
    <!-- Form end -->
</form>

<div class="row" style="margin: auto;">
    <div class="col-sm-6">
        <%
            /**
             * List of all orders from a user. Puts selected order in session as
             * "order".
             */
            List<Order> orders = user.getOrders();
            if (orders != null && !orders.isEmpty())
            {
                for (Order order : orders)
                {
                    int id = order.getId();
                    out.println("<form method=\"post\" action=\"FrontController\">\n"
                            /* Where to in the Command map */
                            + "            <input type=\"hidden\" name=\"command\" value=\"Product\">\n"
                            /* Where to in the Product switch */
                            + "            <input type=\"hidden\" name=\"origin\" value=\"order\">\n"
                            + "            <input type=\"hidden\" name=\"id\" value=\"" + id + "\">\n"
                            + "            <input type=\"submit\" value=\"Lego Order: " + id + " Sent: " + order.isSent() + "\"/>\n"
                            + "        </form>");
                }
            }
        %>
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
                        <th>Side m. d�r.</th>
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
