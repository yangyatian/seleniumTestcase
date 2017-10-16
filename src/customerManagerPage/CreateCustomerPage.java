package customerManagerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import basepage.HomePage;

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
	String customerN = "customer" + System.currentTimeMillis();
	String visibleText = "一般纳税人";
	String comAddress = "日落大道test0010";
	String comTel = "13411112222";
	String CustomerServiceExe = "测试客户专员";
	
	public void createFirstPage(String customer, String visible, String address, String tel) throws InterruptedException{		 
		 // 定位到新建客户页
		 createCustomer();
		 // 新建客户首页信息填写提交
		 getCustomerName().sendKeys(customerN);
		 new Select(getTaxType()).selectByVisibleText(visibleText);		 
		 gettaxPayer().click();
		 getcompanyAddress().sendKeys(comAddress);  
		 getcompanyTel().sendKeys(comTel);    		 
		 getSubButton().click();		 		
	}
	//第二页
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
	
	String captialNum = "1000";
	String moneyText = "USD";
	String RegistrationNo = "11011011";
	String Entity = "test0101";
	String id = "110203198504034315";
	String testEmail = "yy@yy.c";
	String industry = "食品";
	
	public void createSecondPage() throws InterruptedException{
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
	    getindustryOperatingPeriod().sendKeys("20");
	    getmainProduct().sendKeys("方便"+industry);
	    getsourceOfMaterial().sendKeys("测试");
	    getexpordUsd().sendKeys("100000");
	    new Select(getpayment()).selectByVisibleText("T/T");
	    getstrTT().click(); 
	    //出口国家新窗口操作 
	    getcountryNameCN().click();	    
	    Actions action =new Actions(driver);
	    Thread.sleep(2000);
	    action.click(getcountrySelect1()).perform();
	    action.click(getcountrysubBtn()).perform();	        
	    getportOfEntry().sendKeys("北京"); 
	    	    
	}
	//合作信息页	
	By messagelink = By.linkText("合作信息");
	By ChargingStandard = By.name("agencyFeeChargingStandard");
		
	public WebElement getmessagelink(){
		return driver.findElement(messagelink);
	}
	public WebElement getChargingStandard(){
		return driver.findElement(ChargingStandard);
	}
	
	public void Cooperative(){
		getmessagelink().click();
		getChargingStandard().sendKeys("1");
	}
	//联系人信息页
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
	
	public void contactMessage(){
		getcontactInfo().click();
		getcreateContact().click();
		getcontactName().sendKeys("testname");
		getmobileNumber().sendKeys("13422221111");
		getContactEmail().sendKeys("tt@tt.c");
		getcontactBtn().click();			
	}
	//境外贸易商信息页面
	By overseasInfo = By.xpath("//div[@class='nav-tabs-custom']/ul/li[5]/a");
	By overseasName = By.xpath("//form/div/form/div/div[1]/div/div/div/div/div/input");
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
			
	public void OverseasContact(){
		getoverseasInfo().click();
		getcreateOverseasP().click();
	    getoverseasName().sendKeys("tom");
	    getarea().click();	    
	    new Select(getareaSelect()).selectByVisibleText("中国香港");
	    getstr37().click();
	    getoverseasBtn().click();
		
	}
	//证照信息页	
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
	
	public void licenseInfo() throws InterruptedException{
		getlincenseInf().click();
		//上传图片
		getuploadfile1().sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
		getuploadfile2().sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
		Thread.sleep(2000);  
		getsubmit().click();
	}
		
}
