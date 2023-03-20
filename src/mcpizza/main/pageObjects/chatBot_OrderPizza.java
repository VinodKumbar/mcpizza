package mcpizza.main.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class chatBot_OrderPizza {
	
	
	
		WebDriver driver;
		
		public chatBot_OrderPizza(WebDriver driver) {
			this.driver = driver;
		}


		By SelectVeg = By.cssSelector("[title='veg']");
		By SelectCheese = By.cssSelector("[value='cheese_id']");
		By SelectTomoto = By.cssSelector("[value='tomato_id']");
		By Submit = By.cssSelector(".default_card_submit");
		By Right_Nav = By.xpath("//button[@class='navigator right']");
		By ThickCrust = By.xpath("(//*[contains(text(),'Thick Crust')])[3]");
		By Large = By.cssSelector("[title='Large']");
		By Order_Preview = By.xpath("//*[contains(text(),'Will Look')]");
		By Yes = By.cssSelector("[title='Yes']");
		By Order_Placed_Msg = By.xpath("(//*[contains(text(),'PLACED .')])[2]");
		By Thumbs_Up = By.cssSelector(".thumbs-up");
		
		public void SelectVeg () {
			driver.findElement(SelectVeg).click();			
		}
		
		public void SelectCheese () {
			driver.findElement(SelectCheese).click();			
		}
		
		public void SelectTomoto () {
			driver.findElement(SelectTomoto).click();			
		}
		public void Submit () {
			driver.findElement(Submit).click();			
		}
		public void Right_Nav () {
			driver.findElement(Right_Nav).click();			
		}
		public void ThickCrust () {
			driver.findElement(ThickCrust).click();			
		}
		
		public void Large() {
			driver.findElement(Large).click();
		}
		
		public void Order_Preview() {
			String previewOrder = driver.findElement(Order_Preview).getText();
			System.out.println(previewOrder);
		}
		
		public void Yes() {
			driver.findElement(Yes).click();
		}
		
		public void verifyOrderPlacedMsg() {
			String msg = driver.findElement(Order_Placed_Msg).getText();
			System.out.println(msg);
			
		}
		
		public void Thumbs_Up() {
			driver.findElement(Thumbs_Up).click();
		}
		
		public void provideFeedback() {
			WebElement dropdown = driver.findElement(By.xpath("(//*[@role='combobox'])[2]"));
			dropdown.click();
			dropdown.findElement(By.xpath("//*[contains(text(),'Excellent')]")).click();
			driver.findElement(By.xpath("(//*[contains(text(),'Submit')])[3]")).click();
			String thankyou = driver.findElement(By.xpath("(//*[contains(text(),'Support')])[2]")).getText();
			System.out.println(thankyou);
		}


}
