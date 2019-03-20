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
