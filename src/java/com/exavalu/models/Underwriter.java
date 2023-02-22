package com.exavalu.models;


import com.exavalu.services.LoginService;
import com.exavalu.services.UnderwriterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Underwriter extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    
    private String underwriterId,password,remark,status,adminId,adminPassword;
    private String vehicleNumber;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    /**
     * @param stateName the stateName to set
     *
     *
     * /
     **
     * @param districtName the districtName to set
     *
     * /
     **
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    /**
     * @return the firstName
     */
   
    /**
     * @return the employeeId
     */
    

    /**
     * @return the driverName
     */
    
   

    /**
     * @return the underwriterId
     */
    public String getUnderwriterId() {
        return underwriterId;
    }

    /**
     * @param underwriterId the underwriterId to set
     */
    public void setUnderwriterId(String underwriterId) {
        this.underwriterId = underwriterId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    /**
     * @return the status
     */
    public String updateStatus() throws Exception {
        String result = "FAILURE";

        boolean success = UnderwriterService.getInstance().update(this);
        

        if (success) {
            System.out.println("returning Success from updateemployee method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from updateemployee method");
        }

        return result;
    }
    
    
    public String doLoginUnderWriter() throws Exception {
        String result = "FAILURE";

        boolean success = UnderwriterService.getInstance().doLoginUnderwriter(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            getSessionMap().put("Loggedin",this);
            ArrayList fnollist=UnderwriterService.getInstance().getAllFNOL();
             System.out.print("fnollist");
            getSessionMap().put("FNOLList", fnollist);
            
                    
                    result = "SUCCESS";
        } else {
            String errorMsg ="Either Email Address or Password is Wrong";
            getSessionMap().put("ErrorMsg", errorMsg);
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(errorMsg);
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    /**
     * @return the adminId
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * @return the adminPassword
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * @param adminPassword the adminPassword to set
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    public String doLoginAdmin() throws Exception {
        String result = "FAILURE";

        boolean success = UnderwriterService.getInstance().doLoginAdmin(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            getSessionMap().put("Loggedin",this);
            ArrayList fnollist=UnderwriterService.getInstance().adminFNOL();
             System.out.print("fnollist");
            getSessionMap().put("FNOLList", fnollist);
            
                    
                    result = "SUCCESS";
        } else {
            String errorMsg ="Either Email Address or Password is Wrong";
            getSessionMap().put("ErrorMsg", errorMsg);
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(errorMsg);
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }
    
    public String updateAdminStatus() throws Exception {
        String result = "FAILURE";

        boolean success = UnderwriterService.getInstance().updateAdmin(this);
        

        if (success) {
            System.out.println("returning Success from updateemployee method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from updateemployee method");
        }

        return result;
    }

}