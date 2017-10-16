package basepage;

//������,���������
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

	// �����ȸ������
	public WebDriver setupChrome(String test_url) {
		System.setProperty("webdriver.chrome.driver", chromeDF);
		driver = new ChromeDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// ������������(��Ҫ����geckodriver.exe,�ŵ����������ĸ�Ŀ¼)
	public WebDriver setupFirfox(String test_url) {
		System.setProperty("webdriver.gecko.driver", firefoxDF);
		driver = new FirefoxDriver();
		driver.get(test_url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	// ����IE�����
	public WebDriver setupIE(String test_url) {
		System.setProperty("webdriver.ie.driver", ieDF);
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		// �رձ���ģʽ
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

	// �ر������
	public void teardownBrowser() {
		driver.close();
	}
}