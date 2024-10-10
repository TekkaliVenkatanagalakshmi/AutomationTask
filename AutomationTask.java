package Section2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutomationTask {

	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Accessing Amazon India
		driver.get("https://www.amazon.in/");
		
		//searching product Wrist Watches
		WebElement ele1=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		ele1.sendKeys("Wrist Watches");
		WebElement ele2=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		ele2.submit();
		
		//Filtering the result by selecting "Leather"		
		WebElement Category=driver.findElement(By.xpath("//span[text()='Leather']"));
		Actions act=new Actions(driver);
		act.doubleClick(Category).perform();
		
		//again Filtering the result by selecting "Fastrack" brand
		WebElement BrandCategory=driver.findElement(By.xpath("(//span[text()='Fastrack'])[5]"));
	    act.doubleClick(BrandCategory).perform();
	    
		WebElement List=driver.findElement(By.xpath("//span[@class='s-pagination-strip']"));
		act.scrollToElement(List).perform();
		
		//Navigate to 2nd page of search result
		driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
		driver.findElement(By.xpath("(//img[@data-image-source-density='1'])[1]")).click();
		
		//Handling driver control current window to next Window
		String CurrentId=driver.getWindowHandle();
		Set<String> AllWindowId=driver.getWindowHandles();
		for(String Id:AllWindowId)
		{
			if(!CurrentId.equals(Id))
			{
				driver.switchTo().window(Id);
			}
		}
		
		// selected item adding to Add to cart
		WebElement Cart=driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		act.doubleClick(Cart).perform();
	}

}
