<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  
    <head>        
        <title>Employee Management Web Application</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
    </head>
    <body>
<jsp:include page="menu_1.jsp"></jsp:include>

        
                &nbsp;




            <form action="track" method="post">
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" placeholder="vehicleNumber" name="vehicleNumber">
                    </div>
                    

                <div class="col">
                    <button type="submit" class="btn btn-primary" >Track Application</button>
                </div>

        </form>
                
                
         &nbsp;
        <%if (session.getAttribute("User") != null) {%>

        <table class="table table-bordered table-hover">
            <tr>
                <td>
                    First Name
                </td>
                <td>
                    Last Name
                </td>
                <td>
                    Vehicle Number
                </td>
                <td>
                    Policy Number
                </td>
                <td>
                    Application Status
                </td>
                

           <c:set var = "user"  value="${User}"/>
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
                                    ${user.getPolicyNumber()}                                                          
                                </td>
                                <td>
                                    ${user.getStatus()}
                                </td>
                    
                </tr>


            


        </table>
        <%}%>


    </div>

</body>
</html>