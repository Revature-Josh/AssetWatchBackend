package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class TestDriver {

	
private static WebDriver driver;

private static LoginPage loginpage;
private static DashBoardPage landingpage;

 @BeforeAll
 static void setup() {
	 WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://localhost:4200/login"); 
	    loginpage = new LoginPage(driver);
	    landingpage = new DashBoardPage(driver);
	 
 }
 
 @Test
 @Order(1)
 void TestingLogin()
 {
	 
	 loginpage.Sendusername("wiz");
	 loginpage.Sendpassword("12345");
	 loginpage.clickLogin();
	 assertEquals("User's Dashboard".trim(), landingpage.getDashBoardLoginText().trim());
	 
	 
 }
 
 
}
