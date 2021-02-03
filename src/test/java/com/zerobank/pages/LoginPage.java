package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submit;

    public void login(String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }


}
