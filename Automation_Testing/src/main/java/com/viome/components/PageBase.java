package com.viome.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageBase {
	public static WebDriver driver = null;

	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
	}

	public PageBase() {

	}

}
