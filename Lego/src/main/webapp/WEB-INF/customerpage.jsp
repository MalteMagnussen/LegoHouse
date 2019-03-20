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
                            + "            <input type=\"submit\" value=\"Lego Order: " + id + " Sent: "+order.isSent()+"\"/>\n"
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
            BOM bom = (BOM) session.getAttribute("BOM");
            if (bom != null)
            {
                List<Side> sides = bom.getSides();
                Side door = null;
                Side window = null;
                Side wide1 = null;
                Side wide2 = null;
                for (Side side : sides)
                {
                    if (side.hasDoor())
                    {
                        door = side;
                    }
                    if (side.hasWindow())
                    {
                        window = side;
                    }
                    if (!side.hasDoor() && !side.hasWindow())
                    {
                        wide1 = side;
                        wide2 = side;
                    }
                }
        %>
        
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
                    out.println("<td>" + door.getFours() + "</td>");
                    out.println("<td>" + wide1.getFours() + "</td>");
                    out.println("<td>" + window.getFours() + "</td>");
                    out.println("<td>" + wide2.getFours() + "</td>");
                    out.println("<td>" + bom.getTotalFours() + "</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td> 2x2 </td>");
                    out.println("<td>" + door.getTwos() + "</td>");
                    out.println("<td>" + wide1.getTwos() + "</td>");
                    out.println("<td>" + window.getTwos() + "</td>");
                    out.println("<td>" + wide2.getTwos() + "</td>");
                    out.println("<td>" + bom.getTotalTwos() + "</td>");
                    out.println("</tr>");

                    out.println("<tr>");
                    out.println("<td> 1x2 </td>");
                    out.println("<td>" + door.getOnes() + "</td>");
                    out.println("<td>" + wide1.getOnes() + "</td>");
                    out.println("<td>" + window.getOnes() + "</td>");
                    out.println("<td>" + wide2.getOnes() + "</td>");
                    out.println("<td>" + bom.getTotalOnes() + "</td>");
                    out.println("</tr>");

                %>
            </tbody>
        </table>

        <%            }
        %>
    </div>
</div>

<jsp:include page='/footer.jsp'></jsp:include>
