
<!doctype html>
<html lang="en">
    <head>
        <title>Sign in - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        
    </head>
<%@taglib prefix="s" uri="/struts-tags"%> 
    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="admin" method="post">
                <img class="mb-4" src="images/admin.jpeg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Admin Login</h1>
                
<!--                <h3 class="alert-danger">
                    
                </h3>-->

                <div class="form-floating">
                    <input name="adminId" type="text" class="form-control" id="floatingInput" placeholder="adminId">
                    <label for="floatingInput">Admin Id</label>
                </div>
                <div class="form-floating">
                    <input name="adminPassword" type="password" class="form-control" id="floatingPassword" placeholder="adminPassword">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>
