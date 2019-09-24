package com.viome.components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.google.errorprone.annotations.Var;
import com.viome.enums.Browsers;

public class BaseTestCase {
	protected WebDriver driver = null;
	PageFactory PF;

	protected Browsers GetBrowserType(PageFactory PF) throws IOException {
		//PF = new PageFactory(this.driver);
		String _browser = PF.getURLPropertiesValue().getProperty("driver");
		Browsers brType;
		switch (_browser) {
		case "IE":
			brType = Browsers.InternetExplorer;
			break;
		case "Chrome":
			brType = Browsers.Chrome;
			break;
		case "Firefox":
			brType = Browsers.Firefox;
			break;

		case "RemoteFirefox":
			brType = Browsers.RemoteFireFox;
			break;

		case "RemoteChrome":
			brType = Browsers.RemoteChrome;
			break;

		default:
			brType = Browsers.Chrome;
			break;
		}

		return brType;

	}

	protected void LaunchTestCase(String URL) {

		this.driver.navigate().to(URL);
		// IsApplicationLaunched();
		// testCaseName = NUnit.Framework.TestContext.CurrentContext.Test.Name;
	}

}
