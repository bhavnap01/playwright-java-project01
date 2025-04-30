package com.nielseniq.playwright_project01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameTest {
	public static void main(String[] args) {
		Browser brower = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

		Page page = brower.newPage();
		page.navigate("https://demoselsite.azurewebsites.net/webform5.aspx");

		// Locate the Iframe using it CSS selector
		FrameLocator frame = page.frameLocator("#form1 > div:nth-child(3) > iframe");

		// Interact with an elements inside the iframe
		frame.locator("#txtName").fill("NIQ");
		frame.locator("#btnSubmit").click();
		System.out.println(frame.locator("#lblMessage").textContent());

		page.close();
		brower.close();
	}
}

//page.context()  -- can be used for switching between tabs or windows
// handling multiple windows