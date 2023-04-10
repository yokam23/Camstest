package com.concerto.common.listeners;

import java.util.LinkedHashMap;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.concerto.common.contsants.Config;
import com.concerto.common.utilities.AllureManager;

public class SuiteListeners implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
    }
    
    @Override
    public void onFinish(ISuite suite) {
    	suite.getResults();
    	LinkedHashMap<String, String> environmentProps = new LinkedHashMap<String, String>();
    	environmentProps.put("Browser", Config.BROWSER);
    	environmentProps.put("Platform", Config.PLATFORM);
    	AllureManager.createAllurePropertyFile("environment.properties", environmentProps);
    }

}
