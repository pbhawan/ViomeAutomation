package testCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.viome.components.BaseTestCase;
import com.viome.components.ContactUsPage;
import com.viome.components.LoginPage;
import com.viome.components.PageFactory;
import com.viome.enums.CustactUsEnum;
import com.viome.enums.LoginEnum;
import com.viome.utilites.BrowserFactory;

public class Location extends BaseTestCase {

	LoginPage LP;
	ContactUsPage CU;
	PageFactory PF;
	String loginid;
	String pwd;

	@BeforeTest
	public void Setup() throws IOException {
		PF = new PageFactory(this.driver);
		CU=new ContactUsPage(this.driver);
		driver = BrowserFactory.LaunchBrowser(GetBrowserType(PF));
		LP = new LoginPage(this.driver);		
		loginid = PF.getURLPropertiesValue().getProperty("shopify_user");
		pwd = PF.getURLPropertiesValue().getProperty("shopify_password");

	}

	@AfterTest
	public void Teardown() {
		/*System.out.println("End Browser");
		driver.close();
		BrowserFactory.TerminateBrowser();*/
	}

	@Test
	public void VerifyInputLocationtoDB() throws IOException, InterruptedException {
		LaunchTestCase(PF.getURLPropertiesValue().getProperty("shopifySite"));		
		LP.LoginShopifyAsShopper(loginid, pwd);
		// CU.FillContactUsForm();
//     Home.IsAt();
//     Home.GetPageSectionWebElement(HomePage.Setting).webelement.safeclick();
//     Setting.IsAt();
//     Setting.GetPageSectionWebElement(SettingPage.Location).webelement.safeclick();
//     LocationPropertiesFromFrontEnd = FillLocationInfo();
//     LocationPropertiesFromBackEnd = GetValueFromDB();
//     Assert();   
		// string pageHeader =
		// Login.GetPageSectionWebElement(CommonPageArea.PageHeadingH1).Text;
		// assert.AreEqual("Edit Your Profile", pageHeader,"Edit Profile Page Not
		// Launched");

	}
}
