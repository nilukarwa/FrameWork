package Maven;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class ActionTest {
	//RemoteWebDriver driver;
	WebDriver driver;
	
	@Test(enabled=false)
	public void demoTest(){
		
		driver.get("http://demowebshop.tricentis.com/");
		Actions act = new Actions(driver);
		driver.findElement(By.linkText("Log in")).click();
		WebElement email = driver.findElement(By.id("Email"));
		act.moveToElement(email).keyDown(email,Keys.SHIFT).sendKeys("myname").build().perform();
	}
	@Test(enabled=false)
	public void demoRobot()throws AWTException{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_WINDOWS);
		rbt.keyRelease(KeyEvent.VK_WINDOWS);
	}
	@Test(enabled=false)
	public void demoFileupload() throws AWTException, InterruptedException {
		driver.get("https://www.timesjobs.com/candidate/register.html");
		driver.findElement(By.id("resumeFile_basic")).click();
		Robot rbt = new Robot();
		setClipboardata("C:\\Users\\PDC2B-Training.pdc2b\\Desktop\\New Text Document.txt");
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}
	@Test(enabled=false)
	public void takescreenshotDemo() throws IOException {
		driver.get("http://demowebshop.tricentis.com/");
		TakesScreenshot sht = (TakesScreenshot) driver;
		File fl = sht.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fl, new File("C:\\Users\\PDC2B-Training.pdc2b\\eclipse-Nilesh\\Screenshot\\myscreenshot.jpg"));
	}
	@Test(enabled=false)
	public void javascriptDemo() throws InterruptedException {
		driver.get("http://demowebshop.tricentis.com");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0,800)");
		Thread.sleep(1000);
		jse.executeScript("alert('Hi')");
	}
	@Test(enabled=false)
	public void cookieDemo() {
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().deleteAllCookies();
		Cookie ck = new Cookie("User","Tricentis");
		driver.manage().addCookie(ck);
		Set <Cookie> cookieDetails = driver.manage().getCookies();
		for(Cookie c:cookieDetails) {
			System.out.println(c.getExpiry());
			System.out.println(c.getName());
			System.out.println(c.getDomain());
		}
	}
	@Test(enabled=false)
	public void seleniumGrid(){
		driver.get("https://www.google.com");
	}
	@Test
	public void dataExcel() throws IOException {
		driver.get("http://demowebshop.tricentis.com");
		FileInputStream fis = new FileInputStream("C:\\Users\\PDC2B-Training.pdc2b\\eclipse-Nilesh\\Selenium Setup\\TestData.xlsx");
		XSSFWorkbook xls = new XSSFWorkbook(fis);
		XSSFSheet sh = xls.getSheet("TestData");
		int rowcnt = sh.getLastRowNum();
		for(int i=1; i<rowcnt+1;i++) {
			String usname = sh.getRow(i).getCell(0).getStringCellValue();
			String passwd = sh.getRow(i).getCell(1).getStringCellValue();
			doLogin(usname,passwd);
			try {
				driver.findElement(By.linkText("Log out")).click();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://10.243.204.58:5656/wd/hub"),dc);
		driver.manage().window().maximize();*/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PDC2B-Training.pdc2b\\Downloads\\Selenium Drivers\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	public void setClipboardata(String s) {
		StringSelection ss = new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
	}
	public void doLogin(String uname,String pwd) {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(uname);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
	}
}