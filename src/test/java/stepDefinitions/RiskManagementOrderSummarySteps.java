package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.*;
import pageFactory.RiskManagementOrderSummaryPage_PF;
import util.UtilFunctions;
import java.util.Locale;

public class RiskManagementOrderSummarySteps {


    static String orderStatus;
    InitiateTransactionsSteps initiateTransactionsSteps = new InitiateTransactionsSteps();
    WebDriver driver = initiateTransactionsSteps.getDriver();
    UtilFunctions util = new UtilFunctions(driver);
    String orderId = initiateTransactionsSteps.getOrderId();
    //String orderStatusTemp = initiateTransactionsSteps.getOrderStatus();
    String orderContactInformation = initiateTransactionsSteps.getContactInformation();
    String orderPaymentMethod = initiateTransactionsSteps.getPaymentMethod();
    String orderShippingMethod = initiateTransactionsSteps.getShippingMethod();
    String orderShippingAddress = initiateTransactionsSteps.getShippingAddress();
    String orderBillingAddress = initiateTransactionsSteps.getBillingAddress();
    String orderTotalPayment = initiateTransactionsSteps.getTotalPayment();


    RiskManagementOrderSummaryPage_PF smosPF = new RiskManagementOrderSummaryPage_PF(driver);


    @And("check order status")
    public void check_order_status() {

        String currentOrderStatus = smosPF.getOrderStatus();
        orderStatus = currentOrderStatus;
        System.out.println("get_order_status:  "+orderStatus);

    }

    @And("check attributes positive negative")
    public void check_attributes_positive_negative() {
        String positiveCount = smosPF.getPositiveAttributesCount();

        positiveCount = positiveCount.trim().substring(1,positiveCount.length());
        System.out.println("positiveCount:  "+positiveCount);


        String negativeCount = smosPF.getNegativeAttributesCount();
        negativeCount = negativeCount.trim().substring(1,negativeCount.length());
        System.out.println("negativeCount:  "+negativeCount);

    }

    @And("check billing and shipping details")
    public void check_billing_and_shipping_details() {

        System.out.println("OrderId:  "+orderId);
        // System.out.println("orderContactInformation:  "+orderContactInformation);
        //System.out.println("strPaymentMethod:  "+orderPaymentMethod);
        //System.out.println("orderShippingMethod:  "+orderShippingMethod);
        System.out.println("orderShippingAddress:  "+orderShippingAddress);
        //System.out.println("orderBillingAddress:  "+orderBillingAddress);
        // System.out.println("orderTotalPayment:  "+orderTotalPayment);
        System.out.println("---------------");
        //System.out.println("getShoppingCartPurchaser:  "+smosPF.getShoppingCartPurchaser());
        System.out.println("getShippingAddress:  "+smosPF.getShippingAddress());
         //System.out.println("getBillingAddress:  "+smosPF.getBillingAddress());
         //System.out.println("getCartAmount:  "+smosPF.getCartAmount().trim().replaceAll("\\s+",""));

         //System.out.println("getMapAttributes:  "+smosPF.getMapAttributes());
         Assert.assertEquals(orderContactInformation.toLowerCase(Locale.ROOT), smosPF.getPurchaserEmail().toLowerCase(Locale.ROOT).trim());

    }

    @And("check shopping cart")
    public void check_shopping_cart() {
        String orderPurchaser = orderShippingAddress.toLowerCase(Locale.ROOT);
        String strShoppingCartPurchaser = orderShippingAddress.toLowerCase(Locale.ROOT);

        if(orderPurchaser.contains(strShoppingCartPurchaser)){
            System.out.println("Purchaser name match");
        }else{
            Assert.fail("Purchaser Name Not Match");
        }


        String summaryAmount = smosPF.getCartAmount().trim().replaceAll("\\s+","");
        Assert.assertEquals(orderTotalPayment, summaryAmount);
    }

    @And("check payment device and auth")
    public void check_payment_device_and_auth() {

        String orderCard  = orderPaymentMethod;
        String lastFourDigits = "";
        if (orderCard.length() > 4)
        {
            lastFourDigits = orderCard.substring(orderCard.length() - 4);
        }
        else
        {
            lastFourDigits = orderCard;
        }
        String summaryCard  = smosPF.getCardNumber();

        String lastFourDigitsSummaryCard = "";
        if (orderCard.length() > 4)
        {
            lastFourDigitsSummaryCard = summaryCard.substring(summaryCard.length() - 4);
        }
        else
        {
            lastFourDigitsSummaryCard = orderCard;
        }
        System.out.println("lastFourDigits:  "+lastFourDigits);
        System.out.println("lastFourDigitsSummaryCard:  "+lastFourDigitsSummaryCard);

        Assert.assertEquals(lastFourDigits, lastFourDigitsSummaryCard);

    }

    @And("check map information")
    public void check_map_information() throws InterruptedException {
          System.out.println(".......check_map_information........");
          smosPF.clickMapZoomIn();
          Thread.sleep(1000);
          //smosPF.clickMapZoomOut();
          Thread.sleep(4000);
          smosPF.clickMapBillingAddPinter();
          Thread.sleep(3000);
          String addressDistanceAttributes = smosPF.getMapBillingAddAttributes();
          String btsd =  util.getBillingToShippingDistanceKM(addressDistanceAttributes);
          //String btip =  util.getBillingToIPDistanceKM(addressDistanceAttributes);

        if(btsd.equalsIgnoreCase("0.00")){
            System.out.println("Billing Address and Shipping Address are same");
        }else{
            //Assert.fail("Billing Address and Shipping Address are not same");
        }

        smosPF.clickToggleFullScreenView();


    }

    public static String getOrderStatus() { return orderStatus;  }



}
