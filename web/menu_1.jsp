
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Employee Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <img src="images/logo.png" width="120" height="84"></img>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="index_start_1.jsp" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="claimInsurance.jsp" class="nav-link px-2 text-white">Claim</a></li>
                    <li><a href="trackApplication.jsp" class="nav-link px-2 text-white">Track Application</a></li>
                     <li><a href="login.jsp" class="nav-link px-2 text-white">User</a></li>
                    <li><a href="adminlogin.jsp" class="nav-link px-2 text-white">Admin</a></li>
                    <li><a href="underwriterLogin.jsp" class="nav-link px-2 text-white">Underwriter</a></li>
                    
<!--                    <li><a href="Location" class="nav-link px-2 text-white">Location</a></li>-->

                </ul>

 
                <div class="text-end">
                    <c:choose>
                        <c:when test ='${Loggedin==null}'>

                            <a href="login.jsp">
                                <button type="button" class="btn btn-outline-light me-2" >Login</button>
                            </a>
                            <a href="preSignUp">
                                <button type="button" class="btn btn-warning" style="background-color: blue; border: none; color: white">Sign-up</button>
                            </a>
                        </c:when>
                        <c:otherwise>

                            <a href="Logout">
                                <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                            </a>
                        </c:otherwise>
                    </c:choose>


                </div>
            </div>
        </div>
    </header>