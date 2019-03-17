<%@page import="malte.entities.User"%>
<jsp:include page='/header.jsp'></jsp:include>
    <!-- Author: Malte -->
    <h1 style="margin: 15px; float: top; display: flex; flex-direction: column; justify-content: center; text-align: center;">
        Logged in as: <%=request.getParameter("email")%> </h1>

<% User user = (User) session.getAttribute("user"); 
    int id = user.getId();%>

<div class="row">
    <div class="col-sm-6">
        <!-- Form start -->
        <form action="FrontController" method="post" id="sitemenus" style="margin: auto; display: table; width: 90%">
            <!-- Hidden input: &command=Product -->
            <input type="hidden" name="command" value="Product">
            <!-- Hidden input: &origin=addProduct -->
            <input type="hidden" name="origin" value="addProduct">
            <!-- Hidden input: &id=User.getID() -->
            <input type="hidden" name="id" value="<% out.print(id); %>">
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
                        <td><input type="submit" name="submit" value="Add to cart"></td>
                    </tr>
                    <!-- Table Body end -->
                </tbody>
                <!-- Table end -->    
            </table>
            <!-- Form end -->
        </form>

    </div><div class="col-sm-6">

        
        
    </div>
</div>

<jsp:include page='/footer.jsp'></jsp:include>
