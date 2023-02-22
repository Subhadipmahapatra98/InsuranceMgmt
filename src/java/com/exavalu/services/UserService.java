/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class UserService {
    
    public static UserService userService = null;
    
    private UserService(){}
    
    public static UserService getInstance()
    {
        if(userService==null)
        {
            return new UserService();
        }
        else
        {
            return userService;
        }
    }
    
    public  User getUser(String email) {

        User user = new User();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from user where email=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();
             System.out.println("preparedstatement :" +preparedStatement);
            

            while (rs.next()) {

                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setVehicleNumber(rs.getString("vehicleNumber"));
                user.setPolicyNumber(rs.getString("policyNumber"));
                //user.setPremiumAmount(rs.getString("premiumAmount"));
               // user.setCoverageValue(rs.getString("coverageValue"));
            
                

            }

        } catch (SQLException ex) {
             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }
        return user;
}
      public  boolean submitFNOL(User user) {

        boolean result = false;
        try {
                         System.out.println("method running");

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancedb.user SET driverName = ? ,status = ?, driverLiscenceNo = ? , accidentDetails = ? WHERE policyNumber = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getDriverName());
            preparedStatement.setString(2,"pending");
            preparedStatement.setString(3, user.getDriverLiscenceNo());
            preparedStatement.setString(4, user.getAccidentDetails());
            preparedStatement.setString(5, user.getPolicyNumber());
            
            
            int row = preparedStatement.executeUpdate();
             System.out.println("preparedstatement :" +preparedStatement);

            if(row==1)
            {
                result = true;
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return result;
    }
      
      public  User track(String vehicleNumber) {

        User user = new User();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from user where vehicleNumber= ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, vehicleNumber);
            //preparedStatement.setString(2, policyNumber);

            ResultSet rs = preparedStatement.executeQuery();
             System.out.println("preparedstatement :" +preparedStatement);
            

            while (rs.next()) {

                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setVehicleNumber(rs.getString("vehicleNumber"));
                user.setPolicyNumber(rs.getString("policyNumber"));
                user.setStatus(rs.getString("status"));
                //user.setPremiumAmount(rs.getString("premiumAmount"));
               // user.setCoverageValue(rs.getString("coverageValue"));
            
                

            }
            System.out.println(user);

        } catch (SQLException ex) {
             Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
        }
        return user;
}

}
    
    