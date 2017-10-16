package action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

public class TAction {
	private WebDriver driver = null;
	private JavascriptExecutor jse = null;
	private WebElement element;
	private boolean flag = true;
	private String value = "";
	private boolean acceptNextAlert = true;
	
	public TAction(WebDriver driver) {
		this.driver = driver;
	}
	public TAction(WebDriver driver, String url) {
		this.driver = driver;
		this.driver.get(url);
	}

	// �����URL����
	public void goTo(String url) {
		this.driver.get(url);
	}

	// ������˳�
	public void quit() {
		this.driver.quit();
	}

	// �����ǰ��
	public void forward() {
		this.driver.navigate().forward();
	}

	// ���������
	public void back() {
		this.driver.navigate().back();
	}

	// �����ˢ��
	public void refresh() {
		this.driver.navigate().refresh();
	}

	// ��������
	public void maximize() {
		this.driver.manage().window().maximize();
	}

	// js����ȷ��
	public void clickAlertSure() {
		Alert alert = this.driver.switchTo().alert();
		alert.accept();
	}

	// js����ȡ��
	public void clickAlertDismiss() {
		Alert alert = this.driver.switchTo().alert();
		alert.dismiss();
	}

	// ��ȡJS��������
	public String getAlertMessage() {
		Alert alert = this.driver.switchTo().alert();
		return alert.getText();
	}

	// ����alert����ȡ����
	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	// ��ȡcookie
	public String getCookie(String name) {
		Cookie cookie = this.driver.manage().getCookieNamed(name);
		if (cookie == null) {
			return "null";
		}
		return cookie.getValue();
	}

	// ��ȡ����cookie
	public Map<String, String> getCookies() {
		Map<String, String> newCookies = new HashMap<String, String>();
		Set<Cookie> cookies = this.driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			newCookies.put(cookie.getName(), cookie.getValue());
		}
		return newCookies;
	}

	// ��ȡ��Ļ
	public void getScreen(String filepath) {
		WebDriver augmentedDriver = new Augmenter().augment(this.driver);
		TakesScreenshot ts = (TakesScreenshot) augmentedDriver;
		File screenShotFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��ȡtitle
	public String getTitle() {
		return this.driver.getTitle();
	}

	// ��ȡurl
	public String getUrl() {
		return this.driver.getCurrentUrl();
	}

	// ����ҳ�浽ָ��λ��
	public void scroll(String x, String y) {
		if (x.equals("left")) {
			x = "0";
		} else if (x.equals("right")) {
			x = "document.body.scrollWidth";
		} else if (x.equals("middle")) {
			x = "document.body.scrollWidth/2";
		}
		if (y.equals("top")) {
			y = "0";
		} else if (y.equals("buttom")) {
			y = "document.body.scrollHeight";
		} else if (y.equals("middle")) {
			y = "document.body.scrollHeight/2";
		}
		this.exeScript(String.format("scroll(%s,%s);", x, y));
	}

	public void exeScript(String parameter) {
		JavascriptExecutor js = getJSE();
		js.executeScript(parameter);
	}

	private JavascriptExecutor getJSE() {
		if (this.jse == null) {
			this.jse = (JavascriptExecutor) this.driver;
		}
		return jse;
	}

	/**
	 * ����Ԫ��
	 * 
	 * @param by
	 *            ����һ������
	 * @param byValue
	 *            ����һ������ֵ
	 * @return ����һ��WebElement����
	 */
	public WebElement findElement(String by, String byValue) {
		try {
			switch (by) {
			case "id":
				element = this.driver.findElement(By.id(byValue));
				break;
			case "name":
				element = this.driver.findElement(By.name(byValue));
				break;
			case "class":
				element = this.driver.findElement(By.className(byValue));
				break;
			case "tag":
				element = this.driver.findElement(By.tagName(byValue));
			case "link":
				element = this.driver.findElement(By.linkText(byValue));
				break;
			case "partiallinktext":
				element = this.driver.findElement(By.partialLinkText(byValue));
			case "css":
				element = this.driver.findElement(By.cssSelector(byValue));
				break;
			case "xpath":
				element = this.driver.findElement(By.xpath(byValue));
				break;
			default:
				throw new RuntimeException("����Ķ�λ����δ�ڳ����ж��壬����Ϊ��" + byValue);
			}
		} catch (Exception e) {
			System.out.println("û���ҵ�Ԫ�أ�" + byValue);
		}
		return element;
	}

	/**
	 * ����Ԫ�ز����
	 * 
	 * @param by
	 *            ����һ������
	 * @param byValue
	 *            ����һ������ֵ
	 */
	public void findElementClick(String by, String byValue) {
		try {
			findElement(by, byValue).click();
		} catch (Exception e) {
			System.out.println("û���ҵ���Ԫ�ػ��߸�Ԫ�ز��ܱ����");
		}
	}

	/**
	 * ����Ԫ�ز����
	 * 
	 * @param by
	 *            ����һ������
	 * @param byValue
	 *            ����һ������ֵ
	 */
	public void findElementClear(String by, String byValue) {
		try {
			findElement(by, byValue).clear();
		} catch (Exception e) {
			System.out.println("û���ҵ���Ԫ�ػ��߸�Ԫ��û������ֵ");
		}
	}

	/**
	 * ����Ԫ�ز�����ֵ
	 * 
	 * @param by
	 *            ����һ������
	 * @param byValue
	 *            ����һ������ֵ
	 * @param key
	 *            ��дҪ�����ֵ
	 */
	public void findElementSendKeys(String by, String byValue, String key) {
		try {
			findElement(by, byValue).sendKeys(key);
		} catch (Exception e) {
			System.out.println("û���ҵ���Ԫ�ػ��߸�Ԫ���޷�����");
		}
	}

	/**
	 * ִ��js����
	 * 
	 * @param js
	 */
	public boolean excuteJS(String js) {
		if (flag) {
			try {
				((JavascriptExecutor) driver).executeScript(js);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����id��λԪ�ز���������
	 * 
	 * @param id
	 * @param value
	 */
	public boolean inputById(String id, String value) {
		if (flag) {
			try {
				this.driver.findElement(By.id(id)).sendKeys(value);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز���������
	 * 
	 * @param xpath
	 * @param value
	 */
	public boolean inputByXpath(String xpath, String value) {
		if (flag) {
			try {
				this.driver.findElement(By.xpath(xpath)).sendKeys(value);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز���������
	 * 
	 * @param css
	 * @param value
	 */
	public boolean inputByCss(String css, String value) {
		if (flag) {
			try {
				this.driver.findElement(By.cssSelector(css)).sendKeys(value);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز����
	 * 
	 * @param xpath
	 */
	public boolean clickByXpath(String xpath) {
		if (flag) {
			try {
				this.driver.findElement(By.xpath(xpath)).click();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز����
	 * 
	 * @param css
	 */
	public boolean clickByCss(String css) {
		if (flag) {
			try {
				this.driver.findElement(By.cssSelector(css)).click();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ػ�ȡֵ
	 * 
	 * @param xpath
	 * @return
	 */
	public String getValueByXpath(String xpath) {
		if (flag) {
			value = this.driver.findElement(By.xpath(xpath)).getText();
			System.out.println();
			return value;
		} else {
			System.out.println("flag is false, function is not excuted");
			return null;
		}
	}

	/**
	 * ����id��λԪ�ػ�ȡֵ
	 * 
	 * @param id
	 * @return
	 */
	public String getValueById(String id) {
		if (flag) {
			value = this.driver.findElement(By.id(id)).getText();
			System.out.println(value);
			return value;
		} else {
			System.out.println("flag is false, function is not excuted");
			return null;
		}
	}

	/**
	 * ����css��λԪ�ػ�ȡֵ
	 * 
	 * @param css
	 * @return
	 */
	public String getValueByCss(String css) {
		if (flag) {
			value = this.driver.findElement(By.cssSelector(css)).getText();
			System.out.println(value);
			return value;
		} else {
			System.out.println("flag is false, function is not excuted");
			return null;
		}
	}

	/**
	 * ����id��λԪ�ز����ֵ
	 * 
	 * @param id
	 */
	public boolean clearInputValueById(String id) {
		if (flag) {
			try {
				this.driver.findElement(By.id(id)).clear();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز����ֵ
	 * 
	 * @param xpath
	 */
	public boolean clearInputValueByXpath(String xpath) {
		if (flag) {
			try {
				this.driver.findElement(By.xpath(xpath)).clear();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز����ֵ
	 * 
	 * @param css
	 */
	public boolean clearInputValueByCss(String css) {
		if (flag) {
			try {
				this.driver.findElement(By.cssSelector(css)).clear();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * �л���frame��
	 * 
	 * @param frameName
	 */
	public boolean switchToFrame(String frameName) {
		if (flag) {
			try {
				this.driver.switchTo().frame(frameName);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				return false;
			}
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����id��λԪ�ز���ȡԪ�ص���ʾ״̬
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean getDisplayStatById(String id) {
		if (flag) {
			return this.driver.findElement(By.id(id)).isDisplayed();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز���ȡԪ�ص���ʾ״̬
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean getDisplayStatByXpath(String xpath) {
		if (flag) {
			return this.driver.findElement(By.xpath(xpath)).isDisplayed();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز���ȡԪ�ص���ʾ״̬
	 * 
	 * @param css
	 * @return
	 */
	public boolean getDisplayStatByCss(String css) {
		if (flag) {
			return this.driver.findElement(By.cssSelector(css)).isDisplayed();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����id��λԪ�ز���ȡԪ�صĿ�д״̬
	 * 
	 * @param id
	 * @return
	 */
	public boolean getEnableStatById(String id) {
		if (flag) {
			return this.driver.findElement(By.id(id)).isEnabled();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز���ȡԪ�صĿ�д״̬
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean getEnableStatByXpath(String xpath) {
		if (flag) {
			return this.driver.findElement(By.xpath(xpath)).isEnabled();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز���ȡԪ�صĿ�д״̬
	 * 
	 * @param css
	 * @return
	 */
	public boolean getEnableStatByCss(String css) {
		if (flag) {
			return this.driver.findElement(By.cssSelector(css)).isEnabled();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}

	}

	/**
	 * ����id��λԪ�ز���ȡԪ�ص�ѡ��״̬
	 * 
	 * @param id
	 * @return
	 */
	public boolean getSelectStatById(String id) {
		if (flag) {
			return this.driver.findElement(By.id(id)).isSelected();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����xpath��λԪ�ز���ȡԪ�ص�ѡ��״̬
	 * 
	 * @param xpath
	 * @return
	 */
	public boolean getSelectStatByXpath(String xpath) {
		if (flag) {
			return this.driver.findElement(By.xpath(xpath)).isSelected();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ����css��λԪ�ز���ȡԪ�ص�ѡ��״̬
	 * 
	 * @param css
	 * @return
	 */
	public boolean getSelectStatByCss(String css) {
		if (flag) {
			return this.driver.findElement(By.cssSelector(css)).isSelected();
		} else {
			System.out.println("flag is false, function is not excuted");
			return false;
		}
	}

	/**
	 * ��ȡ��ǰ��������ҳ��Ԫ�ص�����ֵ(name,value,id,src�ȵ�)
	 * 
	 * @param attribute
	 * @return
	 */
	public String getFocusAttributeValue(String attribute) {
		try {
			Thread.sleep(333);
		} catch (Exception e) {
			e.printStackTrace();
		}
		value = this.driver.switchTo().activeElement().getAttribute(attribute);
		System.out.println("The focus Element's " + attribute
				+ "attribute value is&gt;&gt;" + value);
		return value;
	}

	/**
	 * ���ö�λҳ��Ԫ�صĳ�ʱʱ��
	 * 
	 * @param second
	 * @return
	 */
	public boolean setTimeOut(int second) {
		try {
			this.driver.manage().timeouts()
					.implicitlyWait(second, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * ��Ϣ�������λ����
	 * 
	 * @param i
	 * @return
	 */
	public boolean sleep(long i) {
		try {
			Thread.sleep(i);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// JS
	public void executeJS(String jsString) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsString);
	}

	// ����xpath��λ��������
	public WebElement webEdit(String xpath) {

		try {
			WebElement webEdit = driver.findElement(By.xpath(xpath));
			webEdit.clear();
			return webEdit;
		} catch (NoSuchElementException e) {
			System.out.println("����򲻴��ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ���������");
			return null;
		}

	}

	// ����xpath��λ��ť
	public WebElement webButton(String xpath) {

		try {
			WebElement webButton = driver.findElement(By.xpath(xpath));
			return webButton;
		} catch (NoSuchElementException e) {
			System.out.println("��ť�����ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ������ť��");
			return null;
		}

	}

	// ����xpath��λ����
	public WebElement link(String xpath) {

		try {
			WebElement link = driver.findElement(By.xpath(xpath));
			return link;
		} catch (NoSuchElementException e) {
			System.out.println("���Ӱ�ť�����ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ�������ӣ�");
			return null;
		}

	}

	// ��ͣ
	public void hover(String xpath) {

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			System.out.println("��ͣ���󲻴��ڣ�");
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ������ͣ����");
		}

	}

	// ��ѡ��ť
	public List<WebElement> webRadioGroup(String xpath) {

		try {
			List<WebElement> radios = driver.findElements(By.xpath(xpath)); // ��λ���е�ѡ��ť
			return radios;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("��ѡ��ť�����ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ������ѡ��ť��");
			return null;
		}
	}

	// ��ѡ��ť
	public List<WebElement> WebCheckBox(String xpath) {

		try {
			List<WebElement> checkboxs = driver.findElements(By.xpath(xpath)); // ��λ���ж�ѡ��ť
			return checkboxs;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("��ѡ��ť�����ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ������ѡ��ť��");
			return null;
		}
	}

	// ������
	public Select webList(String xpath) {

		try {
			WebElement selectElement = driver.findElement(By.xpath(xpath)); // �ȶ�λ������
			Select select = new Select(selectElement);
			return select;
		} catch (NoSuchElementException e) {
			System.out.println("�����򲻴��ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ����������");
			return null;
		}
	}

	// �ϴ��ļ�(input)
	public WebElement upLoadFile(String xpath) {

		try {
			WebElement file = driver.findElement(By.xpath(xpath));
			return file;
		} catch (NoSuchElementException e) {
			System.out.println("�ϴ��ļ��ؼ������ڣ�");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPathƥ�����ϴ��ļ��ؼ���");
			return null;
		}
	}

}
