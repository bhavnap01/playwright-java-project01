package com.nielseniq.playwright_project01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertHandlingTest {
	public static void main(String[] args) {
		Browser brower = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));

		Page page = brower.newPage();

		page.onDialog(dialog -> {
			String msg = dialog.message();
			System.out.println("Alert Message: " + msg);

			dialog.accept(); // dialog.dismiss()
		});

		page.evaluate("alert('Hello World!')");

		brower.close();

	}
}
