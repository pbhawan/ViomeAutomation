package com.viome.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.viome.enums.CustactUsEnum;


public class ContactUsPage extends PageBase {
	public ContactUsPage(WebDriver driver)

	{
		super(driver);
	}
	public void FillContactUsForm() throws InterruptedException
	{
	
		GetPageSectionWebElement(CustactUsEnum.name).webElement.sendKeys("abc");
		GetPageSectionWebElement(CustactUsEnum.emailid).webElement.sendKeys("pratibha.bhawan@metacube.com");
		GetPageSectionWebElement(CustactUsEnum.telephone).webElement.sendKeys("123456789");
		GetPageSectionWebElement(CustactUsEnum.country).webElement.sendKeys("India");
		GetPageSectionWebElement(CustactUsEnum.company).webElement.sendKeys("Metacube");
		GetPageSectionWebElement(CustactUsEnum.message).webElement.sendKeys("This is for demo");
		GetPageSectionWebElement(CustactUsEnum.submit).webElement.click();

	}
	

	public PageAreaProperties GetPageSectionWebElement(CustactUsEnum areaOnPage) {
		
		PageAreaProperties _pageProperty = new PageAreaProperties();

		switch (areaOnPage) {
		case name:
			_pageProperty.webElement = driver.findElement(By.xpath("//input[@name='name']"));
			_pageProperty.Comment = "account_email";
			break;
		case emailid:
			_pageProperty.webElement = driver.findElement(By.xpath("//span[@class='form-mail']/input[@name='email']"));
			_pageProperty.Comment = "Password";
			break;
		case telephone:
			_pageProperty.webElement = driver.findElement(By.xpath("//input[@name='telephone']"));
			_pageProperty.Comment = "NextButton";
			break;
		case country:
			_pageProperty.webElement = driver.findElement(By.xpath("//input[@name='country']"));
			_pageProperty.Comment = "NextButton";
			break;
		case company:
			_pageProperty.webElement = driver.findElement(By.xpath("//input[@name='company']"));
			_pageProperty.Comment = "btnLoginAs";
			break;
		case message:
			_pageProperty.webElement = driver.findElement(By.xpath("//textarea[@name='message']"));
			_pageProperty.Comment = "btnLoginAs";
			break;
		case submit:
			_pageProperty.webElement = driver.findElement(By.xpath("//a[contains(@class,'btn-submit')]"));
			_pageProperty.Comment = "btnLoginAs";
			break;

		}
		return _pageProperty;
	}
}
