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
                    <th>Side m. d�r.</th>
                    <th>Bredside</th>
                    <th>Side m. vindue</th>
                    <th>ialt<th>
                    <th>ialt x h�jde<th>
                </tr>
            </thead>
            <tbody>
                <%
                    /* TYPE */
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* Side m. d�r */
                    out.println("<tr>");

                    out.println("<td>"+door.toString()+"</td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* bredside */
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* Side m. vindue */
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* bredside */
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* i alt */ 
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

                    out.println("</tr>");
                    
                    /* i alt x h�jde */ 
                    out.println("<tr>");

                    out.println("<td> 2x4 </td>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td> 1x2 </td>");

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
