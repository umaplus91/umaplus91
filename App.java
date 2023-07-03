package PriceL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class App extends Core {
	String url = "https://www.walmart.com/cp/smart-home/1229875";
	String web = "https://www.google.com/";
	String DollarTree = "https://www.dollartree.com/";

	// @AfterMethod
	public void closepage() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}

	// @Test
	public void walmartiframe() throws InterruptedException {
		Actions actions = new Actions(driver);
		driver.get(url);
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//iframe[@title='Roku']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//iframe[@title='Roku']")).sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[link-identifier='walmartLogoDesktop']")).click();
		Thread.sleep(2000);
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(5000);
		driver.close();
	}

	// @Test
	public void googleAssert() throws InterruptedException {
		driver.get(web);
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//img[@alt='Google']")).getText();
		System.out.println(title);

		// Equality check
		Assert.assertEquals(title, "gogle", "Page title is incorrect");

	}

	@Test
	public void dollartreeActions() throws InterruptedException {
		driver.get(DollarTree);
		Thread.sleep(4000);

		WebElement search = driver.findElement(By.xpath("(//span[@class='dropdown-toggle'])[5]"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(search).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"health-personal-care\"]/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='modal-close email-signup-modal-close']")).click();
		Thread.sleep(1000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		je.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(500);
		WebElement sear = driver.findElement(By.id("regular-search-input-desktop"));
		sear.sendKeys("Bounty");
		Thread.sleep(2000);
		sear.clear();
		Thread.sleep(2000);
		sear.sendKeys("Tide");
		sear.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("button[class='btn btn-default']")).click();
		je.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='image-badges-container image-badges-container-right'])[1]")).click();
		Thread.sleep(2000);
		je.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		//Select more = new Select(driver.findElement(By.cssSelector("div[class='quantity-value']")));
		//more.selectByValue("store-home-24");
		driver.findElement(By.id("cc-prodDetailsAddToCart")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn cc-button-primary continue-shopping-link']")).click();	
		Thread.sleep(2000);
		je.executeScript("window.scrollBy(0,-500)");
		WebElement drinks = driver.findElement(By.xpath("(//span[@class='dropdown-toggle'])[6]"));
		actions.moveToElement(drinks).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href='/food-candy-drinks/drinks'])[3]")).click(); 
		Thread.sleep(3000);
		je.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("(//p[@class='bi'])[8]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[href='/arizona-iced-tea-with-lemon-338oz-cans/850739']")).click();
		Thread.sleep(2000);
		je.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='quantity-value']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='store-home-24']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cc-prodDetailsAddToCart")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn cc-button-primary continue-shopping-link']")).click();	
		Thread.sleep(2000);
		je.executeScript("window.scrollBy(0,900)");
		Thread.sleep(2000);
		//review (shadow root)
		//driver.findElement(By.xpath("/html/body/div[4]/main/div[1]/div[3]/div/div/div[5]/div[1]//div/div/div[2]/div[1]/div[3]/div/div[1]/div/div[4]")).click();
		driver.findElement(By.cssSelector("a[class='links-section-item cart']")).click();
		
		
   
   
		
	}
}
