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

	// 浏览器URL导航
	public void goTo(String url) {
		this.driver.get(url);
	}

	// 浏览器退出
	public void quit() {
		this.driver.quit();
	}

	// 浏览器前进
	public void forward() {
		this.driver.navigate().forward();
	}

	// 浏览器后退
	public void back() {
		this.driver.navigate().back();
	}

	// 浏览器刷新
	public void refresh() {
		this.driver.navigate().refresh();
	}

	// 最大化浏览器
	public void maximize() {
		this.driver.manage().window().maximize();
	}

	// js弹框确认
	public void clickAlertSure() {
		Alert alert = this.driver.switchTo().alert();
		alert.accept();
	}

	// js弹框取消
	public void clickAlertDismiss() {
		Alert alert = this.driver.switchTo().alert();
		alert.dismiss();
	}

	// 获取JS弹框内容
	public String getAlertMessage() {
		Alert alert = this.driver.switchTo().alert();
		return alert.getText();
	}

	// 操作alert并获取内容
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

	// 获取cookie
	public String getCookie(String name) {
		Cookie cookie = this.driver.manage().getCookieNamed(name);
		if (cookie == null) {
			return "null";
		}
		return cookie.getValue();
	}

	// 获取所有cookie
	public Map<String, String> getCookies() {
		Map<String, String> newCookies = new HashMap<String, String>();
		Set<Cookie> cookies = this.driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			newCookies.put(cookie.getName(), cookie.getValue());
		}
		return newCookies;
	}

	// 截取屏幕
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

	// 获取title
	public String getTitle() {
		return this.driver.getTitle();
	}

	// 获取url
	public String getUrl() {
		return this.driver.getCurrentUrl();
	}

	// 滚动页面到指定位置
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
	 * 查找元素
	 * 
	 * @param by
	 *            传入一个类型
	 * @param byValue
	 *            传入一个类型值
	 * @return 返回一个WebElement对象
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
				throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
			}
		} catch (Exception e) {
			System.out.println("没有找到元素：" + byValue);
		}
		return element;
	}

	/**
	 * 查找元素并点击
	 * 
	 * @param by
	 *            传入一个类型
	 * @param byValue
	 *            传入一个类型值
	 */
	public void findElementClick(String by, String byValue) {
		try {
			findElement(by, byValue).click();
		} catch (Exception e) {
			System.out.println("没有找到该元素或者该元素不能被点击");
		}
	}

	/**
	 * 查找元素并清除
	 * 
	 * @param by
	 *            传入一个类型
	 * @param byValue
	 *            传入一个类型值
	 */
	public void findElementClear(String by, String byValue) {
		try {
			findElement(by, byValue).clear();
		} catch (Exception e) {
			System.out.println("没有找到该元素或者该元素没有输入值");
		}
	}

	/**
	 * 查找元素并输入值
	 * 
	 * @param by
	 *            传入一个类型
	 * @param byValue
	 *            传入一个类型值
	 * @param key
	 *            填写要输入的值
	 */
	public void findElementSendKeys(String by, String byValue, String key) {
		try {
			findElement(by, byValue).sendKeys(key);
		} catch (Exception e) {
			System.out.println("没有找到该元素或者该元素无法输入");
		}
	}

	/**
	 * 执行js方法
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
	 * 根据id定位元素并输入内容
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
	 * 根据xpath定位元素并输入内容
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
	 * 根据css定位元素并输入内容
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
	 * 根据xpath定位元素并点击
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
	 * 根据css定位元素并点击
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
	 * 根据xpath定位元素获取值
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
	 * 根据id定位元素获取值
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
	 * 根据css定位元素获取值
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
	 * 根据id定位元素并清空值
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
	 * 根据xpath定位元素并清空值
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
	 * 根据css定位元素并清空值
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
	 * 切换到frame框
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
	 * 根据id定位元素并获取元素的显示状态
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
	 * 根据xpath定位元素并获取元素的显示状态
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
	 * 根据css定位元素并获取元素的显示状态
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
	 * 根据id定位元素并获取元素的可写状态
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
	 * 根据xpath定位元素并获取元素的可写状态
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
	 * 根据css定位元素并获取元素的可写状态
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
	 * 根据id定位元素并获取元素的选中状态
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
	 * 根据xpath定位元素并获取元素的选中状态
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
	 * 根据css定位元素并获取元素的选中状态
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
	 * 获取当前焦点所在页面元素的属性值(name,value,id,src等等)
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
	 * 设置定位页面元素的超时时间
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
	 * 休息间隔，单位毫秒
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

	// 根据xpath定位输入框并清空
	public WebElement webEdit(String xpath) {

		try {
			WebElement webEdit = driver.findElement(By.xpath(xpath));
			webEdit.clear();
			return webEdit;
		} catch (NoSuchElementException e) {
			System.out.println("输入框不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个输入框！");
			return null;
		}

	}

	// 根据xpath定位按钮
	public WebElement webButton(String xpath) {

		try {
			WebElement webButton = driver.findElement(By.xpath(xpath));
			return webButton;
		} catch (NoSuchElementException e) {
			System.out.println("按钮不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个按钮！");
			return null;
		}

	}

	// 根据xpath定位链接
	public WebElement link(String xpath) {

		try {
			WebElement link = driver.findElement(By.xpath(xpath));
			return link;
		} catch (NoSuchElementException e) {
			System.out.println("链接按钮不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个链接！");
			return null;
		}

	}

	// 悬停
	public void hover(String xpath) {

		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			System.out.println("悬停对象不存在！");
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个悬停对象！");
		}

	}

	// 单选按钮
	public List<WebElement> webRadioGroup(String xpath) {

		try {
			List<WebElement> radios = driver.findElements(By.xpath(xpath)); // 定位所有单选按钮
			return radios;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("单选按钮不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个单选按钮！");
			return null;
		}
	}

	// 多选按钮
	public List<WebElement> WebCheckBox(String xpath) {

		try {
			List<WebElement> checkboxs = driver.findElements(By.xpath(xpath)); // 定位所有多选按钮
			return checkboxs;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("多选按钮不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个多选按钮！");
			return null;
		}
	}

	// 下拉框
	public Select webList(String xpath) {

		try {
			WebElement selectElement = driver.findElement(By.xpath(xpath)); // 先定位下拉框
			Select select = new Select(selectElement);
			return select;
		} catch (NoSuchElementException e) {
			System.out.println("下拉框不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个下拉框！");
			return null;
		}
	}

	// 上传文件(input)
	public WebElement upLoadFile(String xpath) {

		try {
			WebElement file = driver.findElement(By.xpath(xpath));
			return file;
		} catch (NoSuchElementException e) {
			System.out.println("上传文件控件不存在！");
			return null;
		} catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个上传文件控件！");
			return null;
		}
	}

}
