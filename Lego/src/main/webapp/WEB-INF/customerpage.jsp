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
        <input type="number" class="form-control" id="lengthinput" name="length" placeholder="Length" id="qtyInput" required min="8">
    </div>
    <!-- Width -->
    <div class="form-group">
        <label for="widthinput">Width - minimum 5</label>
        <input type="number" class="form-control" id="widthinput" name="width" placeholder="Width" id="qtyInput" required min="5">
    </div>
    <!-- Height -->
    <div class="form-group">
        <label for="heightinput">Height - minimum 4</label>
        <input type="number" class="form-control" id="heightinput" name="height" placeholder="Height" id="qtyInput" required min="4">
    </div>
    <!-- Add to cart button -->
    <button type="submit" name="submit" class="btn btn-dark">Order</button>
    <!-- Form end -->
</form>
<br>
<!-- Shows all the Users Orders as a List with pressable buttons.
        If you press a button, it will load the BOM for that Order. -->
<div class="row" style="margin: auto;">
    <div class="col-sm-5">
        <h5> Orders for: ${user.email}</h5>
        <ul class="list-group">
            <c:forEach var="order" items="${user.orders}">
                <li class="list-group-item">
                    <form method="post" action="FrontController">
                        <input type="hidden" name="command" value="Product">
                        <input type="hidden" name="origin" value="order">
                        <input type="hidden" name="id" value="${order.id}">
                        <button type="submit" class="btn-dark">
                            Id of order: ${order.id} - Sent: ${order.sent}
                        </button>
                    </form>
                </li>
            </c:forEach>
        </ul>
    </div>
        <!-- Show the BOM table if one has been selected. -->
    <div class="col-sm-7">
        <c:if test="${not empty BOM}">
            <jsp:include page='/bomtable.jsp'></jsp:include>
        </c:if>
    </div>
</div>

<jsp:include page='/footer.jsp'></jsp:include>
