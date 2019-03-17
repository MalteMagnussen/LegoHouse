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

            if (users != null && !users.isEmpty()) {
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
                                + "            <input type=\"hidden\" name=\"id\" value=\"" + id + "\">\n"
                                + "            <input type=\"submit\" value=\"Id of order: " + id + "\"/>\n"
                                + "        </form>");
                    }
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
