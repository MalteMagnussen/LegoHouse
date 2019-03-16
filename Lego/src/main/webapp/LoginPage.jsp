<jsp:include page='header.jsp'></jsp:include>
<!-- Author: Malte -->

<!--  Below is the form for logging in. -->
<form class="form-signin" action="FrontController?command=Login" method="post" id="sitemenus" style="margin: auto; display: table; width: 20%" >
    <!-- Hidden parameter so Login knows what method to use -->
    <input type="hidden" name="origin" value="login">
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
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    <p class="mt-5 mb-3 text-muted text-center"> Malte </p>
</form>

<jsp:include page='/jsp/footer.jsp'></jsp:include>
