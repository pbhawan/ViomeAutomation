package com.viome.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.viome.enums.LoginEnum;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver)

	{
		super(driver);
	}

	public void LoginShopifyAsShopper(String Loginid, String Pwd) throws InterruptedException
	{
	
		GetPageSectionWebElement(LoginEnum.txtLoginid).webElement.sendKeys(Loginid);
		Thread.sleep(500);
		GetPageSectionWebElement(LoginEnum.btnNext).webElement.click();
		GetPageSectionWebElement(LoginEnum.txtPassword).webElement.sendKeys(Pwd);
		Thread.sleep(800);
		GetPageSectionWebElement(LoginEnum.btnLoginAs).webElement.click();

	}

	public PageAreaProperties GetPageSectionWebElement(LoginEnum areaOnPage) {
		
		PageAreaProperties _pageProperty = new PageAreaProperties();

		switch (areaOnPage) {
		case txtLoginid:
			_pageProperty.webElement = driver.findElement(By.id("account_email"));
			_pageProperty.Comment = "account_email";
			break;
		case txtPassword:
			_pageProperty.webElement = driver.findElement(By.id("account_password"));
			_pageProperty.Comment = "Password";
			break;
		case btnNext:
			_pageProperty.webElement = driver.findElement(By.xpath("//button[text()='Next']"));
			_pageProperty.Comment = "NextButton";
			break;
		case btnLoginAs:
			_pageProperty.webElement = driver.findElement(By.xpath("//button[text()='Log in']"));
			_pageProperty.Comment = "btnLoginAs";
			break;

		}
		return _pageProperty;
	}
}
