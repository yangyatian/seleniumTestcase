package basepage;

//公共类,浏览器兼容
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {
	public WebDriver driver;
	String chromeDF = "C:/Documents and Settings/Timyang/AppData/Local/Google/Chrome/Application/chromedriver.exe";
	String firefoxDF = "C:/Program Files/Mozilla Firefox/geckodriver.exe";
	String ieDF = "C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe";

	// 启动谷歌浏览器
	public WebDriver setupChrome(String test_url) {
		System.setProperty("webdriver.chrome.driver", chromeDF);
		driver = new ChromeDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// 启动火狐浏览器(需要最新geckodriver.exe,放到火狐浏览器的根目录)
	public WebDriver setupFirfox(String test_url) {
		System.setProperty("webdriver.gecko.driver", firefoxDF);
		driver = new FirefoxDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// 启动IE浏览器
	public WebDriver setupIE(String test_url) {
		System.setProperty("webdriver.ie.driver", ieDF);
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		// 关闭保护模式
		dc.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		dc.setCapability("ignoreProtectedModeSettings", true);
		driver = new InternetExplorerDriver(dc);
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// 关闭浏览器
	public void teardownBrowser() {
		driver.close();
	}
}