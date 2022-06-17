package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AutomationExerciseStepDefinitions {
Faker faker=new Faker();
Actions actions=new Actions(Driver.getDriver());
int numberVariable;
WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    List<String> productName=new ArrayList<>() ;
    JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
AutomationExercisePage autExcPage = new AutomationExercisePage();

    @Given("Launch browser")
    public void launch_browser() {

    }
    @Then("Navigate to url {string}")
    public void navigate_to_url(String demandedUrl) {
       Driver.getDriver().get(ConfigReader.getProperty(demandedUrl));
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
Assert.assertTrue(autExcPage.homePageButton.isDisplayed());

    }
    @Then("Click on Contact Us button")
    public void click_on_button()  {

        autExcPage.contactUsButton.click();

    }
    @Then("Verify {string} is visible")
    public void verify_is_visible(String string) {
     Assert.assertTrue(autExcPage.getInTouchText.isDisplayed());}



    @When("Click Submit button")
    public void click_Submit_Button() {
        autExcPage.submitButton.click();

    }
    @When("Click OK button")
    public void click_ok_button() {
        Driver.getDriver().switchTo().alert().accept();

    }
    @When("Verify success message {string} is visible")
    public void verify_success_message_is_visible(String expendedText) {
    Assert.assertTrue(autExcPage.successText.isDisplayed());
        System.out.println(autExcPage.successText.getText());
    }
    @When("Click {string} button and verify that landed to home page successfully")
    public void click_button_and_verify_that_landed_to_home_page_successfully(String string) {
        autExcPage.homeButtonFromMessage.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Automation Exercise"));
       
    }

    @Then("Type email to mailBox")
    public void typeEmailToMailBox() {

        autExcPage.contactMailBox.sendKeys(faker.internet().emailAddress());
    }


    @Then("Enter a name to nameBox")
    public void enterANameToNameBox() {
        autExcPage.contactNameBox.sendKeys(faker.name().fullName());
    }

    @Then("Type a Subject to subjectBox")
    public void typeASubjectToSubjectBox() {
        autExcPage.subjectBox.sendKeys(faker.university().name());
    }

    @Then("Type a message to messageBox")
    public void typeAMessageToMessageBox() {
        String     message=faker.internet().domainName();
        autExcPage.messageBox.sendKeys(message);

    }

    @Then("Upload file")
    public void uploadFile() {

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim= "\\OneDrive\\Desktop\\text.txt";
        String yuklenecekDosya= farkliKisim+ortakKisim;
        System.out.println(yuklenecekDosya);
        js.executeScript("arguments[0].scrollIntoView();", autExcPage.uploadFileButton);
        autExcPage.uploadFileButton.sendKeys(yuklenecekDosya);


    }

    @And("Click on Products button")
    public void clickOnProductsButton() {
        autExcPage.productsButton.click();

    }

    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        System.out.println(autExcPage.allProductsPageText.getText());
        Assert.assertEquals("ALL PRODUCTS",autExcPage.allProductsPageText.getText());
    }


    @And("Enter product name in search input and click search button")
    public  void enterProductNameInSearchInputAndClickSearchButton() {

        List<WebElement> productsStr=Driver.getDriver().
                findElements(By.xpath("//*[@class='productinfo text-center']"));
        System.out.println(productsStr.size());
        for ( WebElement each:productsStr
             ) {
            productName.add(each.getText().substring(8,each.getText().indexOf("Add")));
        }
        
          numberVariable=faker.number().numberBetween(1,productsStr.size())-1;
        System.out.println(numberVariable);
        autExcPage.searchProductBox.
                sendKeys(productName.get(numberVariable).toString());
        autExcPage.submitSearchButton.click();
    }

    @And("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {

        String actualText=autExcPage.searchedProductResult.getText();
        actualText=actualText.substring(8,actualText.indexOf("Add"));
        String expectedText=productName.get(numberVariable).toString();
        Assert.assertEquals(expectedText,actualText);

        System.out.println("BU bolumun yazisi= "+numberVariable+"\n "+
                actualText+"\n "+
               expectedText);

    }

    @And("Verify SEARCHED PRODUCTS is visible")
    public void verifySEARCHEDPRODUCTSIsVisible() {
        Assert.assertTrue(autExcPage.searchedProductText.isDisplayed());
    }

    @And("Close the browser")
    public void closeTheBrowser() {
        Driver.closeDriver();
    }

    @And("Click on Test Cases button")
    public void clickOnTestCasesButton() {
        WebElement element=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()='Test Cases' and @class='btn btn-success' ]")));
        element.click();
        
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Assert.assertEquals("https://automationexercise.com/test_cases",Driver.getDriver().getCurrentUrl());
        System.out.println(Driver.getDriver().getTitle());
    }

    @Given("The products list is visible")
    public void the_products_list_is_visible() {
        Assert.assertTrue(autExcPage.productListTable.isEnabled());

    }

    @Given("Click on View Product of first product")
    public void click_on_view_product_of_first_product() {
     autExcPage.firstProduct.click();
    }

    @Given("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
     Assert.assertTrue(Driver.getDriver().getTitle().contains("Product Details"));
    }

    @Given("Verify that detail is visible: product name")
    public void verify_that_detail_is_visible_product_name() {
Assert.assertTrue(autExcPage.viewedProductName.isDisplayed());
        System.out.println(autExcPage.viewedProductName.getText());

    }
    @Given("Verify that detail is visible: category")
    public void verify_that_detail_is_visible_category() {
        Assert.assertTrue(autExcPage.viewedProductCategory.isDisplayed());
        System.out.println(autExcPage.viewedProductCategory.getText());
    }
    @Given("Verify that detail is visible: price")
    public void verify_that_detail_is_visible_price() {
 Assert.assertTrue(autExcPage.viewedProductPrice.isDisplayed());
        System.out.println(autExcPage.viewedProductPrice.getText());
    }
    @Given("Verify that detail is visible: availability")
    public void verify_that_detail_is_visible_availability() {
Assert.assertTrue(autExcPage.viewedProductAvailability.isDisplayed());
        System.out.println(autExcPage.viewedProductAvailability.getText());
    }
    @Given("Verify that detail is visible: condition")
    public void verify_that_detail_is_visible_condition() {
     Assert.assertTrue(autExcPage.viewedProductCondition.isDisplayed());
        System.out.println(autExcPage.viewedProductCondition.getText());
    }
    @Given("Verify that detail is visible: brand")
    public void verify_that_detail_is_visible_brand() {
        Assert.assertTrue(autExcPage.viewedProductBrand.isDisplayed());
        System.out.println(autExcPage.viewedProductBrand.getText());
    }

    @Given("Scroll down to footer")
    public void scroll_down_to_footer() {
        js.executeScript("arguments[0].scrollIntoView();", autExcPage.subscriptionMailBox);


    }
    @Given("Verify text {string}")
    public void verify_text(String expendedText) {
        Assert.assertEquals(expendedText,autExcPage.subscriptionText.getText());
    }
    @Given("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        autExcPage.subscriptionMailBox.sendKeys(faker.internet().emailAddress());
        autExcPage.subscriptionMailSubmit.click();

    }
    @Given("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        WebElement element=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@class='alert-success alert']")));
        Assert.assertTrue(element.isDisplayed());
        System.out.println(element.getText());

    }


    @And("Take the screenshot")
    public void takeTheScreenshot() throws IOException {
            ReusableMethods.getScreenshot("osman");


    }
}
