package org.mobileAutomation.AppiumAutomation;

import org.mobileAutomation.pageObjects.android.CartPage;
import org.mobileAutomation.pageObjects.android.FormPage;
import org.mobileAutomation.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_4 extends AppiumServerSetting {
	
	@Test
	public void SwitchingHybrid() throws InterruptedException
	{
		formPage.setNameField("Natasha Abbasi");
		formPage.setGender("female");
		formPage.setCountrySelection("Egypt");
		ProductCatalogue productCatalogue = formPage.shopButton();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		double totalSum= cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
	

}
