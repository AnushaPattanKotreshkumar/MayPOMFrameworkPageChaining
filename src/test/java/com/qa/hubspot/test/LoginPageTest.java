package com.qa.hubspot.test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BaseTest;
import com.qa.hubspot.util.Constants;

public class LoginPageTest extends BaseTest{

	

	// TestNG -- unit testing framework
	// PreConditions ---> Test Cases(steps) (Act vs Exp) -- Assertions ---> Tear
	// Down
	// @BeforeTest ---> @Test --Assertions --> @AfterTest
	// launchBrowser, url --- > title test --> close the browser

	

	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertEquals(loginPage.isSignUpLinkExist(), true);
	}

	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
