package SWag_test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Smart_Buy {
public WebDriver driver;
public int entry = 4;
SoftAssert softassert = new SoftAssert ();
@BeforeTest 
public void login() {
	WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
	driver.get("https://smartbuy-me.com/smartbuystore/");
	// this awit do best performance than threadsleep , its waiting specific time and call elements you need 
	driver.manage().window().maximize();
	driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
}
@Test()
public void add_to_cart() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	for(int i =0; i<entry;i++) {
driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[3]/div[1]/div/div/form[1]/div[1]/button")).click();
driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
}}
@Test()
public void check_number() {
String text =driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div/span[3]")).getText();
System.out.println(text);
//edit  this text by removing any signs or spaces so it will be ready as single item.
String[] edit =text.split("JOD");
String update = edit[0].trim();
System.out.println(update);
// now convert it to double so u can do operation with it 
Double converted = Double.parseDouble(update);
//System.out.println(converted*entry);
}
@Test()
public void check_number2() {
String text = driver.findElement(By.xpath("//*[@id=\"newtab-المميز\"]/div/div[1]/div/div/div/div[3]/div/div[3]/div[1]/div/div/form[1]/div[1]")).getText();
System.out.println(text);
String[] edit =text.split("JOD");
String update = edit[0].trim();
update.replace(",", ".");
System.out.println(update);
Double converted = Double.parseDouble(update);
//System.out.println(converted*entry);
}
@Test()
//Assert will check them if only one is false will skip the rest so (softassert) will solve this problem by checking all test cases
//and will show which one passed and which one is failed only if only determine it with (AssertAll) and this is the best in performance.
public void check_general() {
	String title =driver.getTitle();
	softassert.assertEquals(title, "no");
}
}
