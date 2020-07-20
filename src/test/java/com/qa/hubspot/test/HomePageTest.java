package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {

	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

	// TestNG -- unit testing framework
	// PreConditions ---> Test Cases(steps) (Act vs Exp) -- Assertions ---> Tear
	// Down
	// @BeforeTest ---> @Test --Assertions --> @AfterTest
	// launchBrowser, url --- > title test --> close the browser

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
	}

//	@Test(priority=1)
//	public void getHomePageTitleTest() {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String title = homePage.getHomePageTitle();
//		System.out.println(title + " is");
//		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE );
	//}
	
	@Test(priority=2)
	public void verifyHomePageHeader() {
		String titlehome = homePage.getHomePageHeader();
		System.out.println(titlehome + " is");
		Assert.assertEquals(titlehome, Constants.HOME_PAGE_HEADER );
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		Assert.assertEquals(homePage.isContactsLinkExist(), true);
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
