package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	
	private WebDriver driver;
	private By DashboardElement= By.id("dashboardtitle");
	

	private By AssetSearchInput= By.id("searchstock");
	private By AssetSubmitButton = By.id("searchstockbutton");
	
	
	
	//#search-table tr:first-child
	//symbol
	//private By AssetSymbolReturn = By.cssSelector("#search-table tr:nth-child(2)");
	private By AssetSymbolReturn = By.id("symbol");
	
	//private by
	
public DashBoardPage(WebDriver driver)
{
	this.driver= driver;
}

public String getDashBoardLoginText() {
	
	return driver.findElement(DashboardElement).getText();
}

public void SearchstockSymbol(String symbol) {
	driver.findElement(AssetSearchInput).sendKeys(symbol);
}
	

public void ClickAssetSubmitButton() {
	driver.findElement(AssetSubmitButton).click();
}

public String GetSymbolName()
{
	return driver.findElement(AssetSymbolReturn).getText();
}

}
