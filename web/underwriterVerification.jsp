<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<html>

    <head>
        <title>Thank You for Your Application</title>
        <style>
            form {
                max-width: 400px;

                padding: 20px;
                background-color: #f5f5f5;
                border: 1px solid #ddd;
                border-radius: 5px;
            }

            label {
                display: block;
                font-weight: bold;
                margin-bottom: 10px;
            }

            input {
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            button {
                display: block;
                margin: 0 auto;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .check-insurance {
                background-color: #008CBA;


            }

            .approve {
                background-color: #4CAF50;

            }

            .reject {
                background-color: #ccc;
                color: #333;
                margin-right: 10px;
            }

            button:hover {
                opacity: 0.8;
            }

        </style>
    </head>

    <body>

        <div class="row container">
            <div class="col-6">
                <form action="updateStatus" method="Post">
                    <c:set var = "user"  value="${User}"/>
                    <label for="floatingInput">Vehicle Number</label>
                    <input type="text" class="form-control" id="floatingInput" placeholder="vehicle number" name="vehicleNumber" value=${user.getVehicleNumber()} readonly>


                    <label for="floatingInput">Policy Number</label>
                    <input type="text" class="form-control" id="floatingInput" placeholder="policy number" name="policyNumber" value=${user.getPolicyNumber()} readonly>



                    <label for="floatingInput">Remark</label>
                    <input type="text" class="form-control" id="floatingInput" placeholder="remark" name="remark"  >
                    <br>

                    <label for="floatingInput">Status</label>
                    <select name="status" class="form-control" id="status">
                        <option value="" selected="selected">Status</option>
                        <option value="Forwarded">Forwarded</option>
                        <option value="Rejected">Rejected</option>

                    </select>   
                    <br>
                    <div style="width:100%">
                    <button style="width:50%" type="button" onclick= "fetchContent('data', 'policyApi')" class="check-insurance">Check Insurance</button>
                    <br>
                    <button style="width:50%" type="button" onclick= "fetchContent('dmv', 'driverApi')" class="check-dmv">Check DMV</button>
                    <br>
                    </div>
                    <button type="submit" >Submit</button>
                    <br>

                </form>
            </div>
            <div class="col-6">
                <div class="row">
                    <div id="data" class="col">

                    </div>
                    <div id="dmv" class="col">

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>