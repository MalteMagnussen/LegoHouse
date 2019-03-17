<%@page import="java.util.List"%>
<%@page import="malte.entities.Order"%>
<%@page import="malte.entities.User"%>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
    <% User user = (User) session.getAttribute("user"); 
        int userid = user.getId();  %>
    <h1 style="margin: 15px; float: top; display: flex; flex-direction: column; justify-content: center; text-align: center;">
        Logged in as: <%= user.getEmail() %> </h1>

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
                <th>Length</th>
                <th>Width</th>
                <th>Height</th>
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
    
<div class="row">
    <div class="col-sm-6">
        <%
            /**
             * List of all orders from a user.
             * Puts selected order in session as "order".
             */
            List<Order> orders = user.getOrders();
            if (orders != null && !orders.isEmpty()) {
                for (Order order : orders) {
                    int id = order.getId();
                    out.println("<form method=\"post\" action=\"FrontController\">\n"
                                                                    /* Where to in the Command map */ 
                            + "            <input type=\"hidden\" name=\"command\" value=\"Product\">\n"
                                                                    /* Where to in the Product switch */
                            + "            <input type=\"hidden\" name=\"origin\" value=\"order\">\n"
                            + "            <input type=\"hidden\" name=\"id\" value=\"" + id + "\">\n"
                            + "            <input type=\"submit\" value=\"Lego: " + id + "\"/>\n"
                            + "        </form>");
                }
            }
        %>
    </div>
    <div class="col-sm-6">

        <%
            /**
             * Shows selected Order.
             */
            Order order = (Order) session.getAttribute("order");
            if (order != null) {
        %>
        <!--  Below is the Script for Sorting.   -->
        <script>
            $(document).ready(function () {
                $('#order').DataTable();
            });
        </script>

        <!--  Below is the Table for an Invoice  -->
        <table border="3" width="2" cellspacing="2" cellpadding="2" id="order" class="display">
            <thead>
                <tr>
                    <th>Sent</th>
                    <th>length</th>
                    <th>width</th>
                    <th>height</th>
                    <th>id/<th>
                </tr>
            </thead>
            <tbody>
                <%
                        out.println("<tr>");

                        out.println("<td>" + order.isSent() + "</td>");
                        out.println("<td>" + order.getLength() + "</td>");
                        out.println("<td>" + order.getWidth() + "$</td>");
                        out.println("<td>" + order.getHeight() + "</td>");
                        out.println("<td>" + order.getId() + "</td>");

                        out.println("</tr>");
                %>
            </tbody>
        </table>

        <%
            }
        %>
    </div>
</div>

<jsp:include page='/footer.jsp'></jsp:include>
