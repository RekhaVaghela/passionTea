package com.qa.quickstart.passiontea_BDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutPage {
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span")
	private WebElement checkout;
	
	public void checkoutclick(){
		checkout.click();
	}
}
