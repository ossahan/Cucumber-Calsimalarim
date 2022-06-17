package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//*[@class='fa fa-home']")
        public WebElement homePageButton;

     @FindBy (xpath = "//*[@href=\"/contact_us\"]")
        public WebElement contactUsButton;

     @FindBy (xpath = "//*[text()='Get In Touch']")
        public WebElement getInTouchText;

     @FindBy (xpath = "//*[@type='text' and @placeholder=\"Name\"]")
        public WebElement contactNameBox;

     @FindBy(xpath = "//*[@id=\"contact-page\"]/div/div[2]/div[1]")
     public WebElement contactIframe;

     @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
    public WebElement contactMailBox;

     @FindBy(xpath = "//*[@placeholder='Subject']")
    public WebElement subjectBox;

     @FindBy(xpath = "//*[@name='upload_file']")
    public WebElement uploadFileButton;

 @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    public WebElement submitButton;

 @FindBy(xpath = "//*[@id=\"contact-page\"]/div/div[2]/div[1]/div/div[2]")
    public WebElement successText;

 @FindBy(xpath = "//*[@id=\"form-section\"]/a")
    public WebElement homeButtonFromMessage;

 @FindBy(xpath = "//*[@placeholder='Your Message Here']")
    public WebElement messageBox;

   @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    public WebElement productsButton;
   @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/h2")
    public WebElement allProductsPageText;

   @FindBy(xpath = "//*[@class='productinfo text-center']")
    public WebElement productsData;

   @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searchProductBox;

   @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement submitSearchButton;

   @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement searchedProductText;

   @FindBy(xpath = "//*[text()='Test Cases' and @class='btn btn-success' ]")
    public WebElement searchedProductResult;

   @FindBy(xpath = "//button[@type=\"button\" and class=\"btn btn-success\"]")
    public WebElement testCasesButton;

   @FindBy (xpath="//*[@class='features_items']")
    public WebElement productListTable;

   @FindBy (xpath = "(//*[text()='View Product'])[1]")
    public WebElement firstProduct;

   @FindBy (xpath = "//div[2]/div[2]/div/h2")
    public WebElement viewedProductName;

   @FindBy (xpath = "//div[2]/div/p[1]")
    public WebElement viewedProductCategory;

   @FindBy (xpath = "//div[2]/div/span/span")
    public WebElement viewedProductPrice;

   @FindBy (xpath = "//*[text()='Availability:']")
    public WebElement viewedProductAvailability;

   @FindBy (xpath = "//*[text()='Condition:']")
    public WebElement viewedProductCondition;

   @FindBy (xpath = "//*[text()='Brand:']")
    public WebElement viewedProductBrand;

   @FindBy (xpath = "//*[text()='Subscription']")
    public WebElement subscriptionText;

   @FindBy (xpath = "//*[@type='email']")
    public WebElement subscriptionMailBox;

   @FindBy (xpath = "//*[@type='submit']")
    public WebElement subscriptionMailSubmit;

   @FindBy (xpath = "//*[@class='alert-success alert']")
    public WebElement succeessflySubscripeText;

}

