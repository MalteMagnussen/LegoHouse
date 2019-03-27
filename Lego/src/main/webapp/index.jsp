<jsp:include page='header.jsp'></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Author: Malte -->

<div class="row">
    <div class="col-sm-6">
        <!--  Below is the form for logging in. -->
        <form class="form-signin" action="FrontController" name="login" method="post" id="sitemenus" style="margin: auto; display: table; width: 60%" >
            <!-- Hidden parameter so Login knows what method to use -->
            <input type="hidden" name="origin" value="login">
            <input type="hidden" name="command" value="Login">
            <div class="text-center mb-4">
                <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
                <!-- Headline: Log in -->
                <h1 class="h3 mb-3 font-weight-normal">Log in</h1>
            </div>

            <!-- EMAIL -->
            <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" required autofocus>
                <label for="inputEmail">Email</label>
            </div>

            <!-- PASSWORD -->
            <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
                <label for="inputPassword">Password</label>
            </div>

            <!-- BUTTON TO LOGIN -->
            <button class="btn btn-lg btn-dark btn-block" type="submit">Login</button>
        </form>

    </div><div class="col-sm-6">

        <!--  Below is the form for Registering a user in the SQL database.  -->
        <form class="form-signin" action="FrontController" name="register" method="post" id="sitemenus" style="margin: auto; display: table; width: 60%" >
            <!-- Hidden parameter so LoginCommand knows what method to use -->
            <input type="hidden" name="origin" value="registration">
            <input type="hidden" name="command" value="Login">
            <div class="text-center mb-4">
                <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
                <!-- Headline: Create User -->
                <h1 class="h3 mb-3 font-weight-normal">Create User</h1>
            </div>

            <!-- EMAIL -->
            <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email" name="email" required autofocus>
                <label for="inputEmail">Email</label>
            </div>

            <!-- PASSWORD1 -->
            <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password1" required>
                <label for="inputPassword">Password</label>
            </div>

            <!-- PASSWORD2 -->
            <div class="form-label-group">
                <input type="password" id="inputEmail" class="form-control" placeholder="Password" name="password2" required>
                <label for="inputPassword">Retype Password</label>
            </div>

            <!-- Button to register the user into the SQL Database. -->
            <button class="btn btn-lg btn-dark btn-block" type="submit">Register</button>
        </form>


    </div>
</div>

<jsp:include page='footer.jsp'></jsp:include>
