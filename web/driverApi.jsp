<%-- 
    Document   : landingPage
    Created on : 22-Dec-2022, 12:00:33 PM
    Author     : Avijit Chattopadhyay
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <title>Employee Management</title>
    </head>

    <body>




        <br>
        <div class="table-body ms-auto" style="width:60%;"  >
            <table id="table-id" class="table table-bordered table-hover" style="margin-left:  -50%;">
                <thead style="background-color:yellowgreen;color:white;">
                    <tr>
                        <th scope = "col">
                            Liscence  Number
                        </th>
                        <th scope = "col">
                            Driver Name
                        </th>
                        <th scope = "col">
                            Driver History 
                        </th>
                        <th scope = "col">
                            Liscence Validity
                        </th>



                    </tr>
                </thead>
                <tbody style="background-color:buttonshadow;">

                    <c:set var = "APIUser"  value="${APIUsers}"/>
                    <tr>
                        <td>
                            ${APIUser.getDriverLiscenceNo()}
                        </td>
                        <td>
                            ${APIUser.getDriverName()}
                        </td>
                        <td>
                            ${APIUser.getDrivingHistory()}
                        </td>
                        <td>
                            ${APIUser.getLiscenceValidity()}
                        </td>


                    </tr>


                </tbody>
            </table>
        </div>

    </body>
</html>