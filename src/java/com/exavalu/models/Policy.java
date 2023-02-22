/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.models;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author itssh
 */
public class Policy extends ActionSupport implements ApplicationAware, SessionAware, Serializable{

 
    private String policyNumber,premiumAmount,coverageValue,insuranceExpiry;
    
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
     * @return the insuranceExpiry
     */
    public String getInsuranceExpiry() {
        return insuranceExpiry;
    }

    /**
     * @param insuranceExpiry the insuranceExpiry to set
     */
    public void setInsuranceExpiry(String insuranceExpiry) {
        this.insuranceExpiry = insuranceExpiry;
    }    
}