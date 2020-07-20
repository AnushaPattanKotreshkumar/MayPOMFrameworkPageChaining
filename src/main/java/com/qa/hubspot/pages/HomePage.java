package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basepage.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;
	
	By contactsLink = By.xpath("//a[@id='nav-primary-contacts-branch']");
	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.HOME_PAGE_TITLE);
	}

	public String getHomePageHeader() {
		if(elementUtil.doIsDisplayed(header))
			return elementUtil.doGetText(header);
		return null;
}

	public boolean isContactsLinkExist() {
		return driver.findElement(contactsLink).isDisplayed();
	}
}


