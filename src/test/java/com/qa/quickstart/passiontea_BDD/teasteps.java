package com.qa.quickstart.passiontea_BDD;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class teasteps {
	
	//String user;
	//String pass;
	WebDriver driver;
	private static ExtentReports report = new ExtentReports(Constants.path_teaReport, true);
	public ExtentTest test;
	
	@Before
	public void setup() {
		System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		
	@After
	public void teardown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}	
	
	/*@AfterClass (this is not being called so need to figure out why)
	public static void teardownclass() {
		System.out.println("Here");
	report.flush();
	}*/
		
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		//user = "Lauren"
		//pass = "password"	
		driver.get(Constants.path_teawebsite);
		test = report.startTest("PassionTea Website Test");
		
		test.log(LogStatus.INFO, "Browser started");
              
        if(driver.getCurrentUrl().equals(Constants.path_teawebsite)) {
			test.log(LogStatus.PASS, "correct webpage accessed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
        Assert.assertEquals(driver.getCurrentUrl(), Constants.path_teawebsite);
		
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page()  {
//		WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
//		menu.click();	
		
		menupage menu = PageFactory.initElements(driver, menupage.class);
		menu.menuclick();
		 		 
		 Assert.assertEquals(driver.getCurrentUrl(), "http://www.practiceselenium.com/menu.html");
		 test.log(LogStatus.INFO, "menu page started");
		 test.log(LogStatus.PASS,"correct navigation to main menu");
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
				
		test.log(LogStatus.PASS,"user able to browser products");

		Assert.assertEquals("Green Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")).getText());
		Assert.assertEquals("Red Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong")).getText());
		Assert.assertEquals("Oolong Tea", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong")).getText());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
//		WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
//		menu.click();	
//		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span"));													
//		checkout.click();	
		
		menupage menu = PageFactory.initElements(driver, menupage.class);
		menu.menuclick();
		
		checkoutPage checkout = PageFactory.initElements(driver, checkoutPage.class);
		checkout.checkoutclick();
		
		test.log(LogStatus.PASS,"correct navigation to checkout page");
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.practiceselenium.com/check-out.html");
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		
		if(driver.getCurrentUrl().equals("http://www.practiceselenium.com/check-out.html")) {
			test.log(LogStatus.PASS, "Test Successfully Passed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.practiceselenium.com/check-out.html");
		
	}

}

