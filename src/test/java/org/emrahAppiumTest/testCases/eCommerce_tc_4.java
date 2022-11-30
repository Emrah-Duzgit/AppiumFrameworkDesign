package org.emrahAppiumTest.testCases;

import org.emrahAppiumTest.pageObjects.anrdoid.CartPage;
import org.emrahAppiumTest.pageObjects.anrdoid.ProductCatalogue;
import org.emrahAppiumTest.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class eCommerce_tc_4 extends AndroidBaseTest {

     @BeforeMethod
     public void preSetup(){
         formPage.setActivity();
     }


    @Test(dataProvider = "getData")
    public void FillForm(HashMap<String,String> input) throws InterruptedException {


        formPage.setNameField(input.get("name"));
        formPage.setGender(input.get("gender"));
        formPage.setCountrySelection(input.get("country"));
        ProductCatalogue productCatalogue = formPage.submitForm();
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();



        double totalSum = cartPage.getProductsSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum, displayFormattedSum);
        cartPage.acceptTermsConditions();
        cartPage.submitOrder();
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData("\\Users\\emrah\\IdeaProjects\\AppiumFrameworkDesign\\src\\test\\java\\org\\emrahAppiumTest\\testData\\eCommarce.json");
      //return new Object[][] {{"emrah xxx", "male", "Argentina"}, {"ayse xyz", "female", "Brazil"}};
        return new Object[][] {{data.get(0)}, {data.get(1)}};

    }




























}
