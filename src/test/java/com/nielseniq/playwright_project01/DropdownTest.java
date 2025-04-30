package com.nielseniq.playwright_project01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class DropdownTest {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

		// Maximize the window -- window.maximise()
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1664, 1110));

		Page page = browserContext.newPage();
		page.navigate("https://demoselsite.azurewebsites.net/webform1.aspx");

		// it will open the playwright inspector UI
		page.pause();  //set env variable as PWDEBUG=1
		
		Locator num1 = page.locator("#txtno1");
		num1.fill("100");

		Locator num2 = page.locator("#txtno2");
		num2.fill("20");

		//using dropdown
		Locator oper = page.locator("#cmbop");
		oper.selectOption("Add"); // selecy by value
		oper.selectOption("Multiply"); // select by label
		oper.selectOption(new SelectOption().setIndex(2)); // seelct by index

		Locator calc = page.locator("#btnsrcvcalc");
	//	Locator calc = page.locator("text=Calculate");
		calc.click();

		String result = page.locator("#lblres").textContent();
		System.out.println("Output of this calculation is " + result);

		page.close();
		browser.close();
	}
}

//page.locator("#CheckBox1").check();
