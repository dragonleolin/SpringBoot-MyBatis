package com.example.demo;

import java.util.Set;

import javax.servlet.http.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
	public static void main(String[] args) throws InterruptedException {
		// 若瀏覽器安裝位置為預設則webDriver會自動搜尋path設定的位置，也可以使用System.setProperty 來指定路徑
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		// Selenium對不同瀏覽器提供了不同的webDriver
		WebDriver driver = new ChromeDriver(); // googleChrome
		// 到Google首頁
		// 取得pageTitle
//		driver.get("https://www.google.com.tw/");
//		String title = driver.getTitle();
//		System.out.print(title);
		// Firefox
		// WebDriver firefoxDriver = new FirefoxDriver();

		// MOMO自動登入
		// driver.get("https://m.momoshop.com.tw/mymomo/login.momo");
		// WebElement ac = driver.findElement(By.id("memId"));
		// WebElement pw = driver.findElement(By.id("passwd"));
		// WebElement login = driver.findElement(By.className("login"));
		// ac.sendKeys("0921254819");
		// pw.sendKeys("Home29894199");
		// login.click();
		// 到蝦皮頁面
//		driver.get("https://shopee.tw/buyer/login");
//		// 定位網頁元素 https://www.cnblogs.com/tester-ggf/p/12602211.html
//		WebElement ac = driver.findElement(By.name("loginKey"));
//		WebElement pw = driver.findElement(By.name("password"));
//		WebElement login = driver.findElement(By.className("wyhvVD"));
//		// 元素是否可見(true:是，false:否)
//		System.out.println("test=" + login.isDisplayed());
//		ac.sendKeys("wei.che0812@gmail.com");
//		pw.sendKeys("My0921254819");
//		if (login.isDisplayed()) {
//			// 命令這個執行緒停住1秒鐘
//			Thread.sleep(1000);
//			login.click();
//			Thread.sleep(20000);
//			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
//			System.out.println(timeStamp);
//			if(timeStamp.equals("2022/07/26 18:10:00"))
//			driver.get("https://shopee.tw/m/free-shipping");
//			// WebElement link = driver.findElement(By.xpath("//button[@class='KUpv14']"));
//			WebElement link = driver.findElement(By.cssSelector("div.sdSj2p>button.KUpv14"));
//			link.click();
//		}

		// 測試抓位置
		driver.get("https://shopee.tw/m/free-shipping");
		Thread.sleep(5 * 1000);
		WebElement link =driver.findElement(By.cssSelector("div.sdSj2p>button.KUpv14"));
		//WebElement link = driver.findElement(By.linkText("8/1 全站$0免運券"));
		link.click();
	}
}
