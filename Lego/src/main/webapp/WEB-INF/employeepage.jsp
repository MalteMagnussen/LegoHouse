<%@page import="malte.entities.Side"%>
<%@page import="malte.entities.BOM"%>
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

            if (users != null && !users.isEmpty())
            {
                /* For all users in the system print every order */
                for (User user : users)
                {
                    String username = user.getEmail();
                    out.println("<br>");
                    out.println("<h5> Invoices for: " + username + "</h5>");
                    List<Order> orders = user.getOrders();
                    for (Order order : orders)
                    {
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
            BOM bom = (BOM) session.getAttribute("BOM");
            Order order = (Order) session.getAttribute("order");
            if (bom != null)
            {
                if (order.isSent() == false)
                {
                    out.println("<form method=\"post\" action=\"FrontController\">\n"
                            + "            <input type=\"hidden\" name=\"command\" value=\"Product\">\n"
                            + "            <input type=\"hidden\" name=\"origin\" value=\"sendOrder\">\n"
                            + "            <input type=\"hidden\" name=\"id\" value=\"" + order.getId() + "\">\n"
                            + "            <input type=\"submit\" value=\"Send order\"/>\n"
                            + "        </form>");
                }
            List<Side> sides = bom.getSides();
            Side door = null;
            Side window = null;
            Side wide1 = null;
            Side wide2 = null;
            for (Side side: sides){
                if (side.hasDoor()){
                    door = side;
                }
                if (side.hasWindow()) {
                    window = side;
                }
                if (!side.hasDoor() && !side.hasWindow()){
                    wide1 = side;
                    wide2 = side;
                }
            }
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
                    <th>Type</th>
                    <th>Side m. dør.</th>
                    <th>Bredside</th>
                    <th>Side m. vindue</th>
                    <th>Bredside</th>
                    <th>ialt<th>
                </tr>
            </thead>
            <tbody>
                <%
                    out.println("<tr>");
                    out.println("<td> 2x4 </td>");
                    out.println("<td>"+door.getFours()+"</td>");
                    out.println("<td>"+wide1.getFours()+"</td>");
                    out.println("<td>"+window.getFours()+"</td>");
                    out.println("<td>"+wide2.getFours()+"</td>");
                    out.println("<td>"+bom.getTotalFours()+"</td>");
                    out.println("</tr>");
                    
                    out.println("<tr>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td>"+door.getTwos()+"</td>");
                    out.println("<td>"+wide1.getTwos()+"</td>");
                    out.println("<td>"+window.getOnes()+"</td>");
                    out.println("<td>"+wide2.getOnes()+"</td>");
                    out.println("<td>"+bom.getTotalOnes()+"</td>");
                    out.println("</tr>");
                    
                    out.println("<tr>");
                    out.println("<td> 1x2 </td>");
                    out.println("<td>"+door.getOnes()+"</td>");
                    out.println("<td>"+wide1.getOnes()+"</td>");
                    out.println("<td>"+window.getTwos()+"</td>");
                    out.println("<td>"+wide2.getTwos()+"</td>");
                    out.println("<td>"+bom.getTotalTwos()+"</td>");
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
