package com.viome.utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.errorprone.annotations.Var;
import com.viome.components.PageFactory;
import com.viome.enums.Browsers;

public class BrowserFactory {

	private static WebDriver driver;

	private static String BrowserPath = "D:\\\\Vyom - Automation\\\\Automation_Testing\\\\src\\\\test\\\\resources\\\\enviorments\\\\ApplicationDriver.properties";

	public static WebDriver LaunchBrowser(Browsers browserType) {
		if (driver == null)
			InitBrowser(browserType);
		return driver;
	}

	public static void TerminateBrowser() {
		driver = null;
	}

	public static WebDriver InitBrowser(Browsers selectedBrowser) {

		if (driver == null) {
			switch (selectedBrowser) {
//                  case Firefox:
//                      browser = StartFirefox();
//                      break;
//
//                  case RemoteFireFox:
//                      browser = StartRemoteFirefox();
//                      break;
//
//                  case RemoteChrome:
//                      browser = StartRemoteChrome();
//                      break;
//
//                  case InternetExplorer:
//                      browser = StartInternetExplorer();
//                      break;

			case Chrome:
				driver = StartChrome();
				break;
			case Firefox:
				 System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				break;

			}
		}
		return driver;
	}

	private static ChromeDriver StartChrome() {
		System.setProperty("webdriver.chrome.driver",
				"./Drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--disable-web-security");
		chromeOptions.addArguments("--no-proxy-server");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", "--start-maximized");
		capabilities.setCapability("chrome.switches", "--disable-extensions");
		return new ChromeDriver(chromeOptions);
	}

//	private static FirefoxDriver StartFirefox() {
//		System.setProperty("webdriver.gecko.driver",
//				"D:\\Vyom - Automation\\Automation_Testing\\Drivers\\geckodriver.exe");
//		 FirefoxProfile profile = CreateFirefoxProfile();
//         DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//         //capabilities.SetCapability(FirefoxDriver.ProfileCapabilityName, profile);
//         //caps.SetCapability("browser", "Firefox");
//         //caps.SetCapability("browser_version", "44.0");
//         //caps.SetCapability("os", "Windows");
//         //caps.SetCapability("os_version", "7");
//         //caps.SetCapability("resolution", "1024x768");
//         //caps.SetCapability("browserstack.user", USERNAME);
//         //caps.SetCapability("browserstack.key", AUTOMATE_KEY);
//         RemoteWebDriver driver = new RemoteWebDriver(capabilities);
//         return (FirefoxDriver) driver;
//	}
//	   private static FirefoxProfile CreateFirefoxProfile()
//       {
//           FirefoxProfile profile = new FirefoxProfile();
//           profile.addExtension(null, "Tools/modify_headers-0.7.1.1-fx.xpi");
//           profile.setPreference("general.useragent.override", "UA-STRING");
//           profile.setPreference("extensions.modify_headers.currentVersion", "0.7.1.1-signed");
//           profile.setPreference("modifyheaders.headers.count", 1);
//           profile.setPreference("modifyheaders.headers.action0", "Add");
//           profile.setPreference("modifyheaders.headers.name0", "SampleHeader");
//           profile.setPreference("modifyheaders.headers.value0", "test1234");
//           profile.setPreference("modifyheaders.headers.enabled0", true);
//           profile.setPreference("modifyheaders.config.active", true);
//           profile.setPreference("modifyheaders.config.alwaysOn", true);
//           profile.setPreference("modifyheaders.config.start", true);
//
//           return profile;
//       }
}
