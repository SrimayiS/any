package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.FileManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Login_Page;



	
    public class steps {
    	FileManager fm=new FileManager();
    	WebDriver driver;
    	Login_Page lp;
    	
    	@Before
    	public void preCondition() {
    		WebDriverManager.chromedriver().setup();
    		
    	    driver=new ChromeDriver();
    	 driver.get(fm.getProductionUrl());
    	  String urrr = fm.getProductionUrl();
    	  System.out.println("url is "+urrr);
    	    
    	    driver.manage().timeouts().implicitlyWait(fm.getImplicitlyWait(), TimeUnit.SECONDS);
    	    lp=new Login_Page(driver);
    	}
    	
    	@After
    	public void postCondition() {
    		
    	}
    	
    	
    	
    	@Given("user is in Login page")
    	public void user_is_in_login_page() {
    	    System.out.println("user is in login page");
    	 
    	}


    	

    	@When("user enters valid username {string} and password {string}")
    	public void user_enters_valid_username_and_password(String un, String pwd) {
    	   lp.setUsername("admin");
    	   lp.setPassword("manager");
    	   System.out.println("entered");
    	   
    	}
    	
    	
    	@When("clicks on Login button")
    	public void clicks_on_login_button() {
    		lp.clickLogin();
    	}
    	
    	
    	@Then("Home page should be displayed {string}")
    	public void home_page_should_be_displayed(String etitle) throws InterruptedException {
    	    Thread.sleep(5000);
    	    lp.verifyTitle("actiTIME - Enter Time-Track", 10);
    	    String atitle = driver.getTitle();
    	    Assert.assertEquals(etitle, atitle);
    	    System.out.println(atitle);
    	}

    	@When("user selects the {string} of transaction")
    	public void user_selects_the_of_transaction(String string) {
    	    
    	}


    	

    	@Then("order should be placed succesfully")
    	public void order_should_be_placed_succesfully(io.cucumber.datatable.DataTable dataTable) {
    		List<Map<String, String>> value = dataTable.asMaps(String.class, String.class);
    		
    		for (int i = 0; i < value.size(); i++) {
				
    			String mode_of_transfer = value.get(i).get("mode");
        		
        		String dis = value.get(i).get("discount");
        		System.out.println(dis+"  "+mode_of_transfer);
			}
    		
    		
    	}
}
