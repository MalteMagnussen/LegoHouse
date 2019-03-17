<%@page import="malte.entities.Order"%>
<%@page import="java.util.List"%>
<%@page import="malte.entities.User"%>
<jsp:include page='/header.jsp'></jsp:include>
<!-- Author: Malte -->
    <h1> All invoices </h1>
    <div class="row">
        <div class="col-sm-6">

        <%
            // List of All invoices in the system.
            
            List<User> users = (List<User>) session.getAttribute("users");
            /* For all users in the system print every order */
            for (User user : users) {
                String username = user.getEmail();
                out.println("<br>");
                out.println("<h5> Invoices for: " + username + "</h5>");
                List<Order> orders = user.getOrders();
                for (Order order : orders) {
                    int id = order.getId();
                    out.println("<form method=\"post\" action=\"FrontController\">\n"
                            + "            <input type=\"hidden\" name=\"command\" value=\"Product\">\n"
                            + "            <input type=\"hidden\" name=\"origin\" value=\"employeeorders\">\n"
                            + "            <input type=\"hidden\" name=\"orderid\" value=\"" + id + "\">\n"
                            + "            <input type=\"hidden\" name=\"user\" value=\"" + username + "\">\n"
                            + "            <input type=\"submit\" value=\"Id of order: " + id + "\"/>\n"
                            + "        </form>");
                }
            }
        %>

    </div>
    <div class="col-sm-6">

        <%
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            if (cart != null && !cart.isEmpty()) {
        %>
        <!--  Below is the Script for Sorting.   -->
        <script>
            $(document).ready(function () {
                $('#invoice').DataTable();
            });
        </script>

        <!--  Below is the Table for an Invoice  -->
        <table border="3" width="2" cellspacing="2" cellpadding="2" id="invoice" class="display">
            <thead>
                <tr>
                    <th>Bottom</th>
                    <th>Topping</th>
                    <th>Price_for_one</th>
                    <th>Quantity</th>
                    <th>Total_Price</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (LineItem item : cart.getLineItems()) {
                        out.println("<tr>");

                        out.println("<td>" + item.getBottom() + "</td>");
                        out.println("<td>" + item.getTop() + "</td>");
                        out.println("<td>" + item.getPriceForOne() + "$</td>");
                        out.println("<td>" + item.getQuantity() + "</td>");
                        out.println("<td>" + item.getTotalPrice() + "$</td>");

                        out.println("</tr>");
                    }
                %>
            </tbody>
        </table>


        <%
            }
        %>
    </div>
</div>       
<jsp:include page='/footer.jsp'></jsp:include>
