package SWag_test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SWAG {
public WebDriver driver;
@BeforeTest
public void test_swag() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	 driver =new ChromeDriver();
	 driver.get("https://www.saucedemo.com");
	 driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	 driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
	 driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
}
@Test(priority =2)
public void arrange_low_high() {
List<WebElement> arrang = driver.findElements(By.className("inventory_item_price"));
List<Double> NoOfElements= new ArrayList<>(); // create an array to add elements inner them.
for(int i =0 ; i<arrang.size();i++) {
	String price = arrang.get(i).getText();
	//System.out.println(price);   
	//to compare in the right way we have to remove any sign or any space
	 String editPrice =price.replace("$", " ");
	 // we cant compare string with anthor string so we have to convert it to double ///// trim method to remove spaces 
	 double value =Double.parseDouble(editPrice.trim());
	 System.out.println(value);
	 NoOfElements.add(value); // to add elements in array list .  
}System.out.println(NoOfElements.size());
for(int i = 0 ; i < NoOfElements.size(); i ++) {
	boolean check_process = NoOfElements.get(0)< NoOfElements.get(NoOfElements.size()-1);
	 Assert.assertEquals(check_process, true);
}
}
@Test(priority=1)
public void check_process() {
driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
}
} 

