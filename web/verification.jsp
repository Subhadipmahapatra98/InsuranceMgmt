<%-- 
    Document   : landingPage
    Created on : 22-Dec-2022, 12:00:33 PM
    Author     : Avijit Chattopadhyay
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link href="css/header.css" rel="stylesheet">-->
        <!--        <link rel="stylesheet" href="css/all.min.css">
                <link rel="stylesheet" href="css/reset-min.css">
                <link rel="stylesheet" href="css/algolia-min.css">
                <link rel="stylesheet" href="css/header.css">
                <link rel="stylesheet" href="css/docs.min.css">
                <link rel="stylesheet" href="css/index.css">-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--        <link href="css/menu_css.css" rel="stylesheet">-->
        <!-- Custom styles for this template -->
        <!--        <link href="css/product.css" rel="stylesheet">-->
        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <title>Employee Management</title>
    </head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <!<!-- I want to check my session before showing any content to the user -->
    <jsp:include page="menu_1.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script>

            function fetchContent(targetId, target) {
                $.ajax({
                    url: target,

                    success: function (responseText) {
                        console.log(responseText);
                        $("#" + targetId).html(responseText);
                    }
                });
            }




        </script>

        <style>
            body {
                height: 1000px; /* Set a height to the body */
                overflow: auto; /* Add scrollbars when content overflows */
            }
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
                border-bottom: 1px solid #ddd;
            }

            .scrollable-table {
                height: 200px;
                overflow: auto;
            }
        </style>




        <div id="example">
            <script>
                init({
                    title: 'Large data',
                    //desc: 'Use `virtualScroll` to enable the virtual scroll to play with large data sets (10000 rows).',
                    links: ['bootstrap-table.min.css'],
                    scripts: ['bootstrap-table.min.js']
                })
            </script>



            <div class="bootstrap-table bootstrap5">
             <div class="columns columns-right btn-group float-right"><div class="keep-open btn-group" title="Columns">
                            <div class="dropdown-menu dropdown-menu-right" style=""><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="id" value="0" checked="checked"> <span>ID</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="name" value="1" checked="checked"> <span>Item Name</span></label><label class="dropdown-item dropdown-item-marker"><input type="checkbox" data-field="price" value="2" checked="checked"> <span>Item Price</span></label></div></div></div></div>

                <!--                <div class="table-responsive" style="height: 542px; padding-bottom: 50.5px;">-->

                <div class="table-responsive">
                    <table id="table"  class="table table-bordered table-hover" style="margin-top: -9.5px;">
                        <thead>
                        <c:choose>
                            <c:when test = "${requestScope.noData != null}">
                                <tr>
                                    <td colspan="5">
                                        <h2 style="border:2px solid rgb(255, 99, 71); background-color:rgba(255, 99, 71, 0.5); font-size:15px;">
                                            <c:out value="${requestScope.noData}"> </c:out>
                                            </h2>
                                        </td>
                                    </tr>
                            </c:when>
                        </c:choose>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Vehicle Number</th>
                            <th>Policy Number</th>
                            <th>Email Id</th>
                            <th>Drive Name</th>
                            <th>Driver Liscence Number</th>
                            <th>Accident Details</th>
                            <th>Status</th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "user" items = "${FNOLList}">
                            <tr>
                                <td>
                                    ${user.getFirstName()}
                                </td>
                                <td>
                                    ${user.getLastName()}
                                </td>
                                <td>
                                    ${user.getVehicleNumber()}
                                </td>
                                <td>
                                    <a href="#" onclick= "fetchContent('data', 'policyApi')">
                                        ${user.getPolicyNumber()}
                                    </a>

                                </td>
                                <td>
                                    ${user.getEmail()}
                                </td>
                                <td>
                                    ${user.getDriverName()}
                                </td>
                                <td>
                                    <a href="driverApi">
                                        ${user.getDriverLiscenceNo()}
                                    </a>
                                </td>
                                <td>
                                    ${user.getAccidentDetails()}
                                </td>
                                <td>

                                    ${user.getStatus() }


                                </td>

                                <td> 
                                    <a href="#" onclick= "fetchContent('verify', 'Verify')">
                                        verify
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div id="verify">

</div>

</html>