package com.nielseniq.playwright_project01;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
	public static void main(String[] args) {
		// Playwright runs the browser in headless mode
		Playwright playwright = Playwright.create();

		// launching the Chrome browser
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

		// creating a page in browser
		Page page = browser.newPage();

		// load the playwright web page
		page.navigate("https://playwright.dev/");

		assertThat(page).hasTitle(Pattern.compile("Playwright"));

		browser.close();

	}
}

//sleep(sec) -- setSlowMo
//to run in headed mode -- setHeadless as false
//assertions in playwright