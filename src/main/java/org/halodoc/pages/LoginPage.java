package org.halodoc.pages;

import org.halodoc.framework.BaseLib;
import java.util.Properties;

public class LoginPage extends BaseLib {
    protected Properties properties;

    public LoginPage(){
        properties=loadPropFile("LoginPage.properties");
    }

    public void login(){
        //System.out.println("Email Input xpath : "+properties.getProperty("emailInput"));
        setText(properties.getProperty("emailInput"),username);
        clickItem(properties.getProperty("continueButton"));
        //super.waitForElement(properties.getProperty("passwordInput"));
        waitForServer();
        setText(properties.getProperty("passwordInput"),password);
        clickItem(properties.getProperty("loginButton"));
    }
}
