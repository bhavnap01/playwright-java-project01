package com.nielseniq.playwright_project01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class WaitsPlaywright {
	public static void main(String[] args) {

		Browser brower = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

		Page page = brower.newPage();

		// apply waits to the navigate url
		page.navigate("https://www.google.com", new Page.NavigateOptions().setTimeout(60000));
		// page.setDefaultNavigationTimeout(60000);

		// waits to the locator
		page.setDefaultTimeout(50000);   //by default it waits for 30secs lets set default time to 50secs
		
		Locator input = page.locator("#APjFqb");
		input.fill("NIQ");
		input.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));

		
		System.out.println("is visible? " + input.isVisible());

		System.out.println(page.title());
		page.close();
		brower.close();
	}
}
