package com.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrder {
	 WebDriver driver;
		
	@Given("^user visit the First Cry website$")
	public void user_visit_the_First_Cry_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://firstcry.com/");

	}
	
	@And("^user click on Login button$")
	public void user_click_on_login_button() {
		
		driver.findElement(By.xpath("//span[@class='anch poplogin_main poplogin R12_61']")).click();
	}

	@When("^user enter Username as (.+) and otp into the fields$")
	public void user_enter_username_and_otp_into_the_fields(String username) throws InterruptedException  {
	    driver.findElement(By.xpath("//input[@class='input-box R14_42']")).sendKeys(username);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@class='B14_white comm-btn btn-login-continue btn-login-cont-otp']")).click();
	    Thread.sleep(20000);
	}
	    
	@And("^user click on submit button$")
	public void user_click_on_submit_button() {
		driver.findElement(By.xpath("//div[@id='verfiedbtn']")).click();
	}

	@Then("user should get logged in")
	public void user_should_get_logged_in() {
		System.out.println("user is logged in");
	}
	
	@When("user is on homepage")
	public void user_is_on_homepage() {
		System.out.println("User is on homepage");
	}
	
	@And("user click on a catagory")
	public void user_click_on_a_catagory() {
		driver.findElement(By.xpath("(//a[contains(text(),'Toys')])[1]")).click();
	}
	
	@And("user select few product")
	public void user_select_few_product() throws InterruptedException {
		WebElement a = driver.findElement(By.xpath("//div[@id='12101426']"));
		WebElement b = driver.findElement(By.xpath("//div[@id='10127430']"));
		WebElement c = driver.findElement(By.xpath("//div[@id='9382582']"));
	      JavascriptExecutor jse = (JavascriptExecutor) driver;
	      jse.executeScript("arguments[0].click();", a);
	      jse.executeScript("arguments[0].click();", b);
	      jse.executeScript("arguments[0].click();", c);
	}

	@When("user clicks on cart button")
	public void user_clicks_on_cart_button() {
		driver.findElement(By.xpath("//span[@id='cart_TotalCount']")).click();
	}
	
	@Then("user should be able to see products in the cart")
	public void user_should_be_able_to_see_products_in_the_cart(){
		System.out.println("Produect are added to Cart");
	}

	@When("user click on Add Delivery Address")
	public void user_click_on_add_delivery_address() {
		driver.findElement(By.xpath("//div[@class='M14_white add_deliveryaddr']")).click();
	}

	@When("user gives  contact details")
	public void user_gives_contact_details() {
		driver.findElement(By.xpath("//input[@id='ShipFirstName']")).sendKeys("Hamza Ansari");
		driver.findElement(By.xpath("//input[@id='ShipPinCode']")).sendKeys("224001");
		driver.findElement(By.xpath("//input[@id='ShipMobileNo']")).sendKeys("7784922079");
		driver.findElement(By.xpath("//input[@id='AddressLine1']")).sendKeys("N-Block 102");
		driver.findElement(By.xpath("//input[@id='AddressLine2']")).sendKeys("Wazirganj");
	}

	
	@When("user clicks on save address and then on place order")
	public void user_clicks_on_save_address_and_then_on_place_order() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='M14_white cancelsvbtn saveaddrbtn btn svbtn']")).click();
		Thread.sleep(2000);
  		driver.findElement(By.xpath("//div[@id='placeorder_btn']")).click();
	}
		
	@When("select COD as mode of payment")
	public void select_cod_as_mode_of_payment() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='codrow']")).click();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//div[@class='M15_orange paynow_btn cod_pay transparnt-bg PAY_COD_Btn']")).click();
		}
		catch (Exception e) {
		WebElement cod = driver.findElement(By.xpath("//div[@class='M15_orange paynow_btn cod_pay transparnt-bg PAY_COD_Btn']"));
	      JavascriptExecutor jse = (JavascriptExecutor) driver;
	      jse.executeScript("arguments[0].click();", cod);
		}
	}
	
	
	@Then("Order should get placed")
	public void order_should_get_placed() {
		System.out.println("Order got Placed");
		
		driver.quit();
	}

}
