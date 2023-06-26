package PriceL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class App extends Core {
	String url = "https://www.walmart.com/cp/smart-home/1229875";
	String web = "https://www.google.com/";
	String www = "https://www.dollartree.com/";
	

	@AfterMethod
	public void closepage() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}

	@Test
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

	//@Test
	public void googleAssert() throws InterruptedException {
		driver.get(web);
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//img[@alt='Google']")).getText();
		System.out.println(title);
		
		//Equality check 
		Assert.assertEquals(title, "gogle", "Page title is incorrect");
		

	}

	//@Test
	public void dollartreeActions() throws InterruptedException {
		driver.get(www);
		Thread.sleep(3000);

		WebElement search = driver.findElement(By.xpath("(//span[@class='dropdown-toggle'])[5]"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveToElement(search).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"health-personal-care\"]/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.close();

	}
}
