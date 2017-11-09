package customerManagerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import basepage.HomePage;
import action.TAction;

public class CreateCustomerPage extends HomePage {

	public CreateCustomerPage(WebDriver driver, String url) {
		super(driver, url);
		driver.get(url);		
	}

	By customerName = By.name("customerName");
	By taxTypeSelect = By.xpath("//div/select[1]");
	By taxPayer = By.cssSelector("option[value=\"string:GENERAL_TAXPAYER\"]");
	By companyAdd = By.name("companyAddress");
	By companyTel = By.name("companyTelephone");
	By subButton = By.xpath("//button-group[@data='customer']/div/button");
		
	public WebElement getCustomerName(){
		return driver.findElement(customerName);
	}
	public WebElement getTaxType(){
		return driver.findElement(taxTypeSelect);
	}
	public WebElement gettaxPayer(){
		return driver.findElement(taxPayer);
	}
	public WebElement getcompanyAddress(){
		return driver.findElement(companyAdd);
	}
	public WebElement getcompanyTel(){
		return driver.findElement(companyTel);
	}
	public WebElement getSubButton(){
		return driver.findElement(subButton);
	}
	
	public void createFirstPage(String customerEditUrl, String customerN, String visibleText, String comAddress, String comTel) throws InterruptedException{		 
		 // 打开新建客户页
		 driver.get(customerEditUrl);
		 // 新建客户首页信息填写提交
		 getCustomerName().sendKeys(customerN);
		 new Select(getTaxType()).selectByVisibleText(visibleText);		 
		 gettaxPayer().click();
		 getcompanyAddress().sendKeys(comAddress);  
		 getcompanyTel().sendKeys(comTel);    		 
		 getSubButton().click();		 		
	}
	//第二页元素
	By contactAdd = By.name("contactAddress");
	By registeredCapital = By.name("registeredCapital");
	By moneyType = By.xpath("//div[9]/div/div/div/div/div/div/div/select");
	By str840 = By.cssSelector("option[value=\"string:840\"]");
	By businessRegistrationNo = By.name("businessRegistrationNo");
	By taxpayerIdentity = By.name("taxpayerIdentity");
	By organizationCode = By.name("organizationCode");
	By dateInput = By.xpath("//form/div/div[14]/div//div/div/div/input");
	By dateTd = By.xpath("//table[@class='table table-condensed']/tbody/tr[2]/td[1]");
	By businessEntity = By.name("businessEntity");
	By corporateIdentity = By.name("corporateIdentity");
	By mobileNum = By.name("companyMobile");
	By email = By.name("companyEmail");
	By actualController = By.name("actualController");
	By bussinessIndustry = By.name("bussinessIndustry");
	By industryOperatingPeriod = By.name("industryOperatingPeriod");
	By mainProduct = By.name("mainProduct");
	By sourceOfMaterial = By.name("sourceOfMaterial");
	By expordUsd = By.name("usd");
	By payment = By.xpath("//section/div/form/div/div[6]/div/div/div/div/div/div/div/select");
	By strTT = By.cssSelector("option[value=\"string:TT\"]");
	By countryNameCN = By.name("countryNameCN");
	By countrySelect1 = By.xpath("//tr[1]/td[1]/input[@name='checked']");
	By countrysubBtn = By.xpath("//div[@class='modal-footer']/button[text()='提交']");
	By portOfEntry = By.name("portOfEntry");
	By customerServiceExe = By.name("customerServiceExecutive");
	
	public WebElement getcontactAdd(){
		return driver.findElement(contactAdd);
	}
	public WebElement getregisteredCapital(){
		return driver.findElement(registeredCapital);
	}
	public WebElement getmoneyType(){
		return driver.findElement(moneyType);
	}
	public WebElement getstr840(){
		return driver.findElement(str840);
	}
	public WebElement getbusinessRegistrationNo(){
		return driver.findElement(businessRegistrationNo);
	}
	public WebElement gettaxpayerIdentity(){
		return driver.findElement(taxpayerIdentity);
	}
	public WebElement getorganizationCode(){
		return driver.findElement(organizationCode);
	}
	public WebElement getdateInput(){
		return driver.findElement(dateInput);
	}
	public WebElement getdateTd(){
		return driver.findElement(dateTd);
	}
	public WebElement getbusinessEntity(){
		return driver.findElement(businessEntity);
	}
	public WebElement getcorporateIdentity(){
		return driver.findElement(corporateIdentity);
	}
	public WebElement getmobileNum(){
		return driver.findElement(mobileNum);
	}
	public WebElement getemail(){
		return driver.findElement(email);
	}
	public WebElement getactualController(){
		return driver.findElement(actualController);
	}
	public WebElement getbussinessIndustry(){
		return driver.findElement(bussinessIndustry);
	}
	public WebElement getindustryOperatingPeriod(){
		return driver.findElement(industryOperatingPeriod);
	}
	public WebElement getmainProduct(){
		return driver.findElement(mainProduct);
	}
	public WebElement getsourceOfMaterial(){
		return driver.findElement(sourceOfMaterial);
	}
	public WebElement getexpordUsd(){
		return driver.findElement(expordUsd);
	}
	public WebElement getpayment(){
		return driver.findElement(payment);
	}
	public WebElement getstrTT(){
		return driver.findElement(strTT);
	}
	public WebElement getcountryNameCN(){
		return driver.findElement(countryNameCN);
	}
	public WebElement getcountrySelect1(){
		return driver.findElement(countrySelect1);
	}
	public WebElement getcountrysubBtn(){
		return driver.findElement(countrysubBtn);
	}
	public WebElement getportOfEntry(){
		return driver.findElement(portOfEntry);
	}	
	public WebElement getCustomerServiceExe(){
		return driver.findElement(customerServiceExe);
	}
	
	//第二页信息填写方法
	public void createSecondPage(String comAddress, String captialNum, String moneyText, String RegistrationNo, String Entity, String id, String comTel, String testEmail, String CustomerServiceExe, String industry, String Tnum, String testword, String Tnum2, String selectStype) throws InterruptedException{
		getcontactAdd().sendKeys(comAddress);
		getregisteredCapital().sendKeys(captialNum);		
	    new Select(getmoneyType()).selectByVisibleText(moneyText);
	    getstr840().click();
	    getbusinessRegistrationNo().sendKeys(RegistrationNo);
	    gettaxpayerIdentity().sendKeys(RegistrationNo);
	    getorganizationCode().sendKeys(RegistrationNo);
	    getdateInput().click();
	    getdateTd().click();	       
	    getbusinessEntity().sendKeys(Entity);
	    getcorporateIdentity().sendKeys(id);

	    getmobileNum().sendKeys(comTel);
	    getemail().sendKeys(testEmail);
	    getactualController().sendKeys(Entity);
	    getCustomerServiceExe().sendKeys(CustomerServiceExe);
	    getbussinessIndustry().sendKeys(industry);
	   
	    getindustryOperatingPeriod().sendKeys(Tnum);
	    getmainProduct().sendKeys("方便"+industry);
	    getsourceOfMaterial().sendKeys(testword);
	    getexpordUsd().sendKeys(Tnum2);
	    new Select(getpayment()).selectByVisibleText(selectStype);
	    getstrTT().click(); 
	    //出口国家新窗口操作 
	    getcountryNameCN().click();	    
	    Actions action =new Actions(driver);
	    Thread.sleep(2000);
	    action.click(getcountrySelect1()).perform();
	    action.click(getcountrysubBtn()).perform();	        
	    getportOfEntry().sendKeys("北京"); 	    	    
	}
		
	By messagelink = By.linkText("合作信息");
	By ChargingStandard = By.name("agencyFeeChargingStandard");
		
	public WebElement getmessagelink(){
		return driver.findElement(messagelink);
	}
	public WebElement getChargingStandard(){
		return driver.findElement(ChargingStandard);
	}
	//合作信息页
	
	public void Cooperative(String Num){
		getmessagelink().click();
		getChargingStandard().sendKeys(Num);
	}
	
	By contactInfo = By.linkText("联系人信息");
	By createContact = By.cssSelector("div.col-sm-12 > div > button.btn.btn-default");
	By contactName = By.name("name");
	By mobileNumber = By.name("mobile");
	By ContactEmail = By.name("email");
	By contactBtn = By.cssSelector("div.modal-footer > button.btn.btn-primary");
	
	public WebElement getcontactInfo(){
		return driver.findElement(contactInfo);
	}
	public WebElement getcreateContact(){
		return driver.findElement(createContact);
	}
	public WebElement getcontactName(){
		return driver.findElement(contactName);
	}
	public WebElement getmobileNumber(){
		return driver.findElement(mobileNumber);
	}
	public WebElement getContactEmail(){
		return driver.findElement(ContactEmail);
	}
	public WebElement getcontactBtn(){
		return driver.findElement(contactBtn);
	}
	//联系人信息页
	
	public void contactMessage(String testName, String testMNumber, String testEmail){
		getcontactInfo().click();
		getcreateContact().click();
		getcontactName().sendKeys(testName);
		getmobileNumber().sendKeys(testMNumber);
		getContactEmail().sendKeys(testEmail);
		getcontactBtn().click();			
	}
	//境外贸易商元素
	By overseasInfo = By.xpath("//div[@class='nav-tabs-custom']/ul/li[5]/a");
	By overseasName = By.xpath("//div/div/input[@name='name']");
	By createOverseasP = By.xpath("//*[@id='foreign-contacts']/div/div/div/div/div[1]/button");
	By area = By.xpath("//form/div/div[2]/div/div/div/div/div/div/div/select");
	By areaSelect = By.xpath("//html[@id='ng-app']/body/div[2]/div/div/div[2]/form/div/form/div/div[2]/div/div/div/div/div/div/div/select");
	By str37 = By.cssSelector("option[value=\"string:37\"]");
	By overseasBtn = By.cssSelector("div.modal-footer > button.btn.btn-primary");
	
	public WebElement getoverseasInfo(){
		return driver.findElement(overseasInfo);
	}
	public WebElement getcreateOverseasP(){
		return driver.findElement(createOverseasP);
	}
	public WebElement getoverseasName(){
		return driver.findElement(overseasName);
	}
	public WebElement getarea(){
		return driver.findElement(area);
	}
	public WebElement getareaSelect(){
		return driver.findElement(areaSelect);
	}
	public WebElement getstr37(){
		return driver.findElement(str37);
	}
	public WebElement getoverseasBtn(){
		return driver.findElement(overseasBtn);
	}
	//境外页填写信息		
	public void OverseasContact(String OSName, String selectArea) throws InterruptedException{
		getoverseasInfo().click();
		getcreateOverseasP().click();
		Thread.sleep(1000);
	    getoverseasName().sendKeys(OSName);
	    getarea().click();	    
	    new Select(getareaSelect()).selectByVisibleText(selectArea);
	    getstr37().click();
	    getoverseasBtn().click();
		
	}
	//证照信息页元素	
	By lincenseInf = By.linkText("证照信息");
	By uploadfile1 = By.cssSelector("input[type=\"file\"]");
	By uploadfile2 = By.xpath("(//input[@type='file'])[2]");
	By submit = By.xpath("//button-group/div/button[@ng-if='saveShow']");
	By saveDraft = By.xpath("//div/button-group/div/button[2]");
	
	public WebElement getlincenseInf(){
		return driver.findElement(lincenseInf);
	}
	public WebElement getuploadfile1(){
		return driver.findElement(uploadfile1);
	}
	public WebElement getuploadfile2(){
		return driver.findElement(uploadfile2);
	}
	public WebElement getsubmit(){
		return driver.findElement(submit);
	}
	public WebElement getSaveDraft(){
		return driver.findElement(saveDraft);
	}
	//证照信息页
	String jpgPath1 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg";
	String jpgPath2 = "C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg";
	public void licenseInfo(String jpgPath1, String jpgPath2) throws InterruptedException{
		getlincenseInf().click();
		//上传图片
		getuploadfile1().sendKeys(jpgPath1);
		getuploadfile2().sendKeys(jpgPath2);
		Thread.sleep(2000);  
		getsubmit().click();
		TAction tAction = new TAction(driver);
		System.out.println(tAction.closeAlertAndGetItsText());
		Thread.sleep(1000); 
		tAction.clickAlertSure();
	}
	//获取新客户名称
	By newCustomerName = By.xpath("//table[@id='simpletable']/tbody/tr[1]/td[2]");
	public String getNewCustomerName(){
		return driver.findElement(newCustomerName).getText();
	}
		
}
