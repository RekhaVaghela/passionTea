package com.qa.quickstart.passiontea_BDD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class menupage {
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menu;
	
	public void menuclick()
	{
		menu.click();
	}

}
