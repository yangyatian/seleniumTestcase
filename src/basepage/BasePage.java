package basepage;

//������,�����������ص�
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {
  public WebDriver driver;    
  //�����ȸ������
  
  public WebDriver setupChrome(String test_url){     
  System.setProperty("webdriver.chrome.driver", "C:/Documents and Settings/Timyang/AppData/Local/Google/Chrome/Application/chromedriver.exe");
  driver = new ChromeDriver();
  driver.get(test_url);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  return driver;
  }

  //������������(��Ҫ����geckodriver.exe,�ŵ�firfox�ĸ�Ŀ¼)
  public WebDriver setupFirfox(String test_url){
      System.setProperty("webdriver.gecko.driver","C:/Program Files/Mozilla Firefox/geckodriver.exe");
      driver = new FirefoxDriver();
      driver.get(test_url);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      return driver;
  }
  //����IE�����
  public WebDriver setupIE(String test_url){   
   System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
   DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
   dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
   driver = new InternetExplorerDriver(dc);
   driver.get(test_url);
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   return driver;
  }
 
  //�ر������
  public void teardownBrowser(){
      driver.close();    
  }    
}