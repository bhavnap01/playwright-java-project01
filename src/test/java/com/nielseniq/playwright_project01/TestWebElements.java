package com.nielseniq.playwright_project01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestWebElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
		
		//Maximize the window
		BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setViewportSize(1664,1110));

		Page page = browserContext.newPage();
		page.navigate("https://the-internet.herokuapp.com/jqueryui/menu");

		Locator disabledMenu = page.locator("#ui-id-1");
		assertThat(disabledMenu).isDisabled();

		Locator enabledMenu = page.locator("#ui-id-3");
		assertThat(enabledMenu).isEnabled();

		System.out.println("Disabled Menu" + disabledMenu.isDisabled());
		System.out.println("Enabled Menu" + enabledMenu.isEnabled());
		
		browser.close();

	}

}
