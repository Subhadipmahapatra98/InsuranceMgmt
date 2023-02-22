package com.exavalu.models;


import com.exavalu.services.APIService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class APIUser extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    
    private int coverageValue,premiumAmount;
    private String premiumExpiry,drivingHistory,policyNumber;
    private String driverLiscenceNo,driverName,liscenceValidity;

    public int getCoverageValue() {
        return coverageValue;
    }

    public void setCoverageValue(int coverageValue) {
        this.coverageValue = coverageValue;
    }

    public int getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(int premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getPremiumExpiry() {
        return premiumExpiry;
    }

    public void setPremiumExpiry(String premiumExpiry) {
        this.premiumExpiry = premiumExpiry;
    }

    public String getDrivingHistory() {
        return drivingHistory;
    }

    public void setDrivingHistory(String drivingHistory) {
        this.drivingHistory = drivingHistory;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getDriverLiscenceNo() {
        return driverLiscenceNo;
    }

    public void setDriverLiscenceNo(String driverLiscenceNo) {
        this.driverLiscenceNo = driverLiscenceNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLiscenceValidity() {
        return liscenceValidity;
    }

    public void setLiscenceValidity(String liscenceValidity) {
        this.liscenceValidity = liscenceValidity;
    }

   

   

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
     * @return the driverLiscenceNo
     */
    
    /**
     * @return the status
     */
//    public String getAddEmpPage() throws Exception {
//       
//        return "SUCCESS";
//        
//    }

  public String getPolicyDataFromAPI() throws ParseException, freemarker.core.ParseException{
        String result = "FAILURE";
        APIUser apiUsers = APIService.consumePolicyDataFromAPI();
        //APIUser apiUser = new APIUser();
        //boolean res = APIService.insertDataInDB(apiUsers);
        //if(!apiUsers.isEmpty()){
            
            //String successMsg = "Entered API Data into Database!";
            getSessionMap().put("APIUsers", apiUsers);
            result = "SUCCESS";
           // getSessionMap().put("APIUser", apiUser);
         
        
        return result;
    }
   public String getDriversDataFromAPI() throws ParseException, freemarker.core.ParseException{
        String result = "FAILURE";
        APIUser apiUsers = APIService.consumeDriverDataFromAPI();
        //APIUser apiUser = new APIUser();
        //boolean res = APIService.insertDataInDB(apiUsers);
        //if(!apiUsers.isEmpty()){
            
            //String successMsg = "Entered API Data into Database!";
            getSessionMap().put("APIUsers", apiUsers);
            result = "SUCCESS";
           // getSessionMap().put("APIUser", apiUser);
         
        
        return result;
    }

    
    


}