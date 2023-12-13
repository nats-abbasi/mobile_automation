package org.mobileAutomation.AppiumAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


import io.appium.java_client.service.local.AppiumServiceBuilder;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;
//
import java.io.File;
//
import java.time.Duration;

import org.mobileAutomation.pageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.remote.AutomationName;
 //import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumServerSetting {
	
	  public static AppiumDriverLocalService service;
	  public AndroidDriver driver;
	  public FormPage formPage;

	@BeforeClass  
	public void ConfigureAppium() throws MalformedURLException{
		
//		AppiumServiceBuilder builder = new AppiumServiceBuilder();
//      builder.withIPAddress("127.0.0.1").usingPort(4723).usingAnyFreePort()
//              .withArgument(BASEPATH, "/wd/hub")
//              .withArgument(SESSION_OVERRIDE)
//              .withArgument(LOG_LEVEL, "info")
//              .withArgument(USE_DRIVERS, "uiautomator2")
//              .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//              .withArgument(ALLOW_INSECURE, "chromedriver_autodownload");
//     service = AppiumDriverLocalService.buildService(builder);
//     service.start();
		//========================================///
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Test Emulator");
		//options.setApp("//home//nabbasi//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp("//home//nabbasi//eclipse-workspace//AppiumAutomation//src//test//java//resources//General-Store.apk");
		options.setChromedriverExecutable("//home//nabbasi//Downloads//chromedriver_linux64//chromedriver");
//		options.setCapability("browserName", "Chrome");
//		options.setPlatformName("ANDROID");
//		options.setPlatformVersion("13.0");
     
//     UiAutomator2Options uiAutomator2Options;
//     uiAutomator2Options = new UiAutomator2Options()
//             .setAvd("Test Emulator")
//             .setAvdLaunchTimeout(Duration.ofSeconds(300))
//             .setAvdReadyTimeout(Duration.ofSeconds(100))
//             .setDeviceName("Test Emulator")
//             .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
//             .setApp("//home//nabbasi//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk")
////             .setAppPackage("com.wdiodemoapp")
////             .setAppActivity("com.wdiodemoapp.MainActivity")
//             .setNoReset(false);
     ///========================================================
//     DesiredCapabilities capabilities = new DesiredCapabilities ();
//     capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//     capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, "Test Emulator");
//     capabilities.setCapability (MobileCapabilityType.APP, "//home//nabbasi//eclipse-workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
//     capabilities.setCapability ("noReset", false);
//     capabilities.setCapability (MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
     
     //============================================================================

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public void scrollAction(String option) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ option +"\"));"));
	}
	
	public void swipeAction(WebElement option , String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) option).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void DragAndDropAction(WebElement source) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 560
			));
	}
	
	public double getFormattedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		//service.stop();
	}

}
