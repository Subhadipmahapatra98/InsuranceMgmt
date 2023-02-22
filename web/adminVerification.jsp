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
             

            <form action="adminverify" method="Post">

              
                <h1 class="h3 mb-3 fw-normal">First Notice of Loss </h1>

                
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="vehicle number" name="vehicleNumber" value=${user.getVehicleNumber()} readonly>
                    <label for="floatingInput">Vehicle Number</label>
                </div>
                     <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="policy number" name="policyNumber" value=${user.getPolicyNumber()} readonly>
                    <label for="floatingInput">Policy Number</label>
                </div>
                    <div class="form-floating">
                   <select name="status" class="form-select" id="status">
                       <option value="" selected="selected"> Admin Verification Status</option>
                   <option value="Approved">Approved</option>
                   <option value="Rejected">Rejected</option>
                  
                   </select>                         
                
               
                  
                 
                <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>

            </form>
        </main>
    </body>
</html>