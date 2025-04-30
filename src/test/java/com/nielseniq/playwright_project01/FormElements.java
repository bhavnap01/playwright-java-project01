package com.nielseniq.playwright_project01;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FormElements {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

		// Maximize the window -- window.maximise()
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1664, 1110));

		Page page = browserContext.newPage();
		page.navigate("https://demoselsite.azurewebsites.net/webform2.aspx");

		// take a full page screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("webform2.png")).setFullPage(true));

		Locator num1 = page.locator("#txtno1");
		num1.fill("100");

		// take an eleemnt screenshot
		num1.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("element_screenshot.png")));

		Locator num2 = page.locator("#txtno2");
		num2.fill("20");

		Locator oper = page.locator("#rdmul");
		oper.click();

		Locator calc = page.locator("#btnsrcvcalc");
		calc.click();

		String result = page.locator("#lblres").textContent();
		System.out.println("Output of this calculation is " + result);

		page.close();
		browser.close();
	}
}
