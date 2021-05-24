package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
class TestDriverAssetWatch {

	
private static WebDriver driver;
private static WebDriver driver2;
private static LoginPage loginpage;
private static DashBoardPage landingpage;
private static  WebDriverWait wdw ;



 @BeforeAll
 static void setup() {

	 WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://assetwatch.s3-website-us-east-1.amazonaws.com/login"); 
	    loginpage = new LoginPage(driver);
	    landingpage = new DashBoardPage(driver);
	    
	 
	 wdw = new WebDriverWait(driver, 30);
 }
 
 @Test
 @Order(1)
 void TestingLogin()
 {
	 wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	 loginpage.Sendusername("wiz");
	 loginpage.Sendpassword("12345");
	 loginpage.clickLogin();
	 wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardtitle")));
	 assertEquals("wiz's Dashboard".trim(), landingpage.getDashBoardLoginText().trim());
	 //System.out.println("title " + driver.getTitle());
	
	 
	 
	 
 }
 

 @Test
 @Order(2)
 void TestingLoginError()
 {
	 /*
	loginpage.Sendusername("wiz");
	 loginpage.Sendpassword("12345");
	 loginpage.clickLogin();
	 wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboardtitle")));*/
	 
	 wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchstock")));
	landingpage.SearchstockSymbol("aapl");
	landingpage.ClickAssetSubmitButton();
	
	 wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id("symbol")));
	assertEquals("AAPL".trim(), landingpage.GetSymbolName().trim());
	
	
	 
	 
 }
 
 
 
	/*@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}*/

}
