<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->

    <!-- Form start -->
    <form action="FrontController" method="post">
        <!-- Hidden input: &command=Product -->
        <input type="hidden" name="command" value="Product">
        <!-- Hidden input: &origin=addProduct -->
        <input type="hidden" name="origin" value="addProduct">
        <!-- Hidden input: &id=User.getID() -->
        <input type="hidden" name="id" value="${user.id}">
    <!-- Length -->
    <div class="form-group">
        <label for="lengthinput">Length - Minimum 8</label>
        <input type="number" class="form-control" id="lengthinput" name="length" placeholder="Length" id="qtyInput">
    </div>
    <!-- Width -->
    <div class="form-group">
        <label for="widthinput">Width - minimum 5</label>
        <input type="number" class="form-control" id="widthinput" name="width" placeholder="Width" id="qtyInput">
    </div>
    <!-- Height -->
    <div class="form-group">
        <label for="heightinput">Height - minimum 4</label>
        <input type="number" class="form-control" id="heightinput" name="height" placeholder="Height" id="qtyInput">
    </div>
    <!-- Add to cart button -->
    <button type="submit" name="submit" class="btn btn-primary">Order</button>
    <!-- Form end -->
</form>
<br>
<div class="row" style="margin: auto;">
    <div class="col-sm-6">
        <h5> Orders for: ${user.email}</h5>
        <ul class="list-group">
            <c:forEach var="order" items="${user.orders}">
                <li class="list-group-item">

                    <form method="post" action="FrontController">
                        <input type="hidden" name="command" value="Product">
                        <input type="hidden" name="origin" value="order">
                        <input type="hidden" name="id" value="${order.id}">
                        <button type="submit" class="list-group-item list-group-item-action active">
                            Id of order: ${order.id} - Sent: ${order.sent}
                        </button>
                    </form>

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
            <!--  Below is the Table for an Invoice  -->
            <table border="3" width="2" cellspacing="2" cellpadding="2" id="order" class="display">
                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Side m. dør.</th>
                        <th>Bredside</th>
                        <th>Side m. vindue</th>
                        <th>Bredside</th>
                        <th>ialt</th>
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
