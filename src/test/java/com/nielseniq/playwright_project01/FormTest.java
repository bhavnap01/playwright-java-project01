package com.nielseniq.playwright_project01;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FormTest {
	Browser browser;
	Page page;
	Playwright playwright;

	@BeforeMethod
	public void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}

	@Test(priority = 2)
	public void run() {
		page.navigate("https://testng.org/annotations.html");
	//	System.out.println(page.title());
	}
	
	@Test(priority = 1 )
	public void verifyTitle() {
		assertEquals(page.title(),"Annotations" );
	}

	
	@AfterMethod
	public void tearDown() {
		page.close();
		browser.close();
		playwright.close();
	}
}
