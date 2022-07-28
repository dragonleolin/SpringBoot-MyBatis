package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ShopeeDto;

@RestController
@RequestMapping(path = "/reptile")
public class SeleniumController {
	WebDriver driver; // googleChrome

	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public String callShopee(@RequestBody ShopeeDto shopeeDto) throws InterruptedException {
		String message = "沒有回應";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		// Selenium對不同瀏覽器提供了不同的webDriver
		driver = new ChromeDriver();
		// 到蝦皮頁面
		driver.get("https://shopee.tw/buyer/login");
		// 定位網頁元素 https://www.cnblogs.com/tester-ggf/p/12602211.html
		WebElement ac = driver.findElement(By.name("loginKey"));
		WebElement pw = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.className("wyhvVD"));
		// 元素是否可見(true:是，false:否)
		System.out.println("test=" + login.isDisplayed());
		ac.sendKeys(shopeeDto.getAccount());
		pw.sendKeys(shopeeDto.getPassword());
		if (login.isDisplayed()) {
			// 命令這個執行緒停住1秒鐘
//			Thread.sleep(2 * 1000);
//			login.click();
//			Thread.sleep(20 * 1000); // 20秒去進行登入驗證
			for(int i = 0; i <= 30; i++) {
				Thread.sleep(1 * 1000);
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
				System.out.println(timeStamp);				
				if (timeStamp.equals(shopeeDto.getTime())) {
					System.out.println("點擊成功");
					driver.get("https://shopee.tw/m/8-8#fsv");
					Thread.sleep(5 * 1000); // 留給抓取畫面時間
					WebElement link = driver.findElement(By.cssSelector("div.sdSj2p>button.KUpv14"));
					// WebElement link = driver.findElement(By.linkText("8/1 全站$0免運券"));
					link.click();
					message = "時間到";
					break;
				} else {
					System.out.println(i +"次點擊失敗");
					i+=1;
				}
			}
		}

		return message;
	}

	@Scheduled(fixedDelay = 10000) // fixedDelay = 60000 表示當前方法執行完畢 60000ms(1分鐘)後，Spring scheduling會再次呼叫該方法
	public String catchElement(WebDriver driver) throws InterruptedException {
		String message = "";
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		if (timeStamp.equals("2022/07/26 18:10:00")) {
			driver.get("https://shopee.tw/m/8-8#fsv");
			Thread.sleep(5 * 1000); // 留給抓取畫面時間
			WebElement link = driver.findElement(By.cssSelector("div.sdSj2p>button.KUpv14"));
			// WebElement link = driver.findElement(By.linkText("8/1 全站$0免運券"));
			link.click();
			return message = "時間到";
		} else {
			return message = "時間還沒到";
		}
	}

}
