/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Underwriter;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class UnderwriterService {
    
    public static UnderwriterService userService = null;
    
    private UnderwriterService(){}
    
    public static UnderwriterService getInstance()
    {
        if(userService==null)
        {
            return new UnderwriterService();
        }
        else
        {
            return userService;
        }
    }
    
    public ArrayList getAllFNOL() {

        ArrayList FNOLList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from user where status ='pending' ";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setVehicleNumber(rs.getString("vehicleNumber"));
                user.setPolicyNumber(rs.getString("policyNumber"));
                user.setEmail(rs.getString("email"));
                user.setDriverName(rs.getString("driverName"));
                user.setDriverLiscenceNo(rs.getString("driverLiscenceNo"));
                user.setAccidentDetails(rs.getString("accidentDetails"));
                user.setStatus(rs.getString("status"));
                
                
                FNOLList.add(user);
                
            }
            System.out.println("Size" +FNOLList.size());

        } catch (SQLException ex) {
          Logger log = Logger.getLogger(UnderwriterService.class.getName());
            log.error("Error Message:" +ex.getMessage());
            System.out.println(ex.getMessage());
        }

        return FNOLList;
    
    }
    
    public  boolean update(Underwriter user) {
       
        boolean result = false;
        try {
                         System.err.println(user.getRemark());

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancedb.user SET status = ?, remark = ? WHERE vehicleNumber = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getStatus());
            preparedStatement.setString(2, user.getRemark());
            preparedStatement.setString(3, user.getVehicleNumber());

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
    
     public boolean doLoginUnderwriter(Underwriter use)
    {
        boolean success = false;
        
        
        String sql = "Select * from underwriter where underwriterId=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, use.getUnderwriterId());
            ps.setString(2, use.getPassword());
            
            System.out.println("LoginService Underwriter :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
            System.out.println(ex.getMessage());
            
        }
        
        
        return success;
    }
     public boolean doLoginAdmin(Underwriter user)
    {
        boolean success = false;
        
        
        String sql = "Select * from admin where adminId=? and adminpassword=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getAdminId());
            ps.setString(2, user.getAdminPassword());
            
            System.out.println("LoginService admin :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
            System.out.println(ex.getMessage());
            
        }
        
        
        return success;
    }
      public ArrayList adminFNOL() {

        ArrayList FNOLList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from user where status ='Forwarded' ";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setVehicleNumber(rs.getString("vehicleNumber"));
                user.setPolicyNumber(rs.getString("policyNumber"));
                user.setEmail(rs.getString("email"));
                user.setDriverName(rs.getString("driverName"));
                user.setDriverLiscenceNo(rs.getString("driverLiscenceNo"));
                user.setAccidentDetails(rs.getString("accidentDetails"));
                user.setStatus(rs.getString("status"));
                
                
                FNOLList.add(user);
                
            }
            System.out.println("Size" +FNOLList.size());

        } catch (SQLException ex) {
           Logger log = Logger.getLogger(LoginService.class.getName());
            log.error("Error Message:" +ex.getMessage());
            System.out.println(ex.getMessage());
        }

        return FNOLList;
      }
         public  boolean updateAdmin(Underwriter user) {

        boolean result = false;
        try {
                         System.err.println("MEEE" + user.getStatus());

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE insurancedb.user SET status = ?  WHERE vehicleNumber = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getStatus());
            //preparedStatement.setString(2, user.getRemark());
            preparedStatement.setString(2, user.getVehicleNumber());
           
            
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
   

}
    
    