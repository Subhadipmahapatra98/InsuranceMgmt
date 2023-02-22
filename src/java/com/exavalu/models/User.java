package com.exavalu.models;


import com.exavalu.services.LoginService;
import com.exavalu.services.UnderwriterService;
import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
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
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    private int userId;
    private String firstName;
    private String lastName;
    private String email,status,remark;
    private String password, address, policyNumber,vehicleNumber,premiumAmount,coverageValue,driverName,driverLiscenceNo,accidentDetails;

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
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the phoneNumber
     */


    /**
     * @return the addressLine
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param addressLine the addressLine to set
     */
    public void setAddressLine(String addressLine) {
        this.setAddress(addressLine);
    }

    /**
     * @return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @param policyNumber the policyNumber to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * @return the engineNumber
     */


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
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the premiumAmount
     */
    public String getPremiumAmount() {
        return premiumAmount;
    }

    /**
     * @param premiumAmount the premiumAmount to set
     */
    public void setPremiumAmount(String premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    /**
     * @return the coverageValue
     */
    public String getCoverageValue() {
        return coverageValue;
    }

    /**
     * @param coverageValue the coverageValue to set
     */
    public void setCoverageValue(String coverageValue) {
        this.coverageValue = coverageValue;
    }

    /**
     * @return the employeeId
     */
    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            getSessionMap().put("Loggedin",this);
            User user = UserService.getInstance().getUser(this.getEmail());
             getSessionMap().put("User",user );
                    
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
    public String verifyUser(){
        
        String result="SUCCESS";
        
        return result;
    }

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName the driverName to set
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return the driverLiscenceNo
     */
    public String getDriverLiscenceNo() {
        return driverLiscenceNo;
    }

    /**
     * @param driverLiscenceNo the driverLiscenceNo to set
     */
    public void setDriverLiscenceNo(String driverLiscenceNo) {
        this.driverLiscenceNo = driverLiscenceNo;
    }

    /**
     * @return the accidentDetails
     */
    public String getAccidentDetails() {
        return accidentDetails;
    }

    /**
     * @param accidentDetails the accidentDetails to set
     */
    public void setAccidentDetails(String accidentDetails) {
        this.accidentDetails = accidentDetails;
    }
    public String SubmitFNOL() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.getInstance().submitFNOL(this);
        

        if (success) {
            System.out.println("returning Success from updateemployee method");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from updateemployee method");
        }

        return result;
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
    
    public String trackApplication() throws Exception {
        String result = "FAILURE";

       User user = UserService.getInstance().track(this.getVehicleNumber());
             getSessionMap().put("User",user );
                    
                    result = "SUCCESS";

        return result;
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
   public String doLogout(){
        
        String result="SUCCESS";
        sessionMap.clear();
        return result;
    }

}