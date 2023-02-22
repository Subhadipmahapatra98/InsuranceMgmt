<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Claim Page</title>      
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <link href="css/signin.css" rel="stylesheet">  
        <!-- Custom styles for this template -->
    </head>
    <body>

        <main class="form-signin w-100 m-auto">

            <c:set var = "user"  value="${User}"/>
             

            <form action="SaveFNOL" method="Post">

              
                <h1 class="h3 mb-3 fw-normal">First Notice of Loss </h1>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=${user.getFirstName()} readonly>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${user.getLastName()} readonly>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="vehicle number" name="vehicleNumber" value=${user.getVehicleNumber()} readonly>
                    <label for="floatingInput">Vehicle Number</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="policy number" name="policyNumber" value=${user.getPolicyNumber()} readonly>
                    <label for="floatingInput">Policy Number</label>
                </div>
                  <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="driver name" name="driverName"  required value=${user.getDriverName()} >
                    <label for="floatingInput">Driver Name</label>
                </div>   
                     <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="liscenceNumber" name="driverLiscenceNo"  required value=${user.getDriverLiscenceNo()} >
                    <label for="floatingInput">liscence Number</label>
                </div>
            </div>   
                     <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="accidentDetails" name="accidentDetails" required value=${user.getAccidentDetails()} >  
                    <label for="floatingInput">Accident Reason</label>
                </div>
                                     
                <button class="w-100 btn btn-lg btn-primary" type="submit">Claim Insurance</button>

            </form>
        </main>
    </body>
</html>