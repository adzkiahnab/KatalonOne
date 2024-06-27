import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//additional
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.webui.common.WebUiCommonHelper

/**
 * 
 * This test case about how to find the best locator for element which has no helpful locator 
 *  
 */
WebUI.maximizeWindow()
WebUI.verifyElementPresent(findTestObject('Object Repository/ChallengingDOM/a_Challenging DOM'), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/ChallengingDOM/a_Challenging DOM'), FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://the-internet.herokuapp.com/challenging_dom', FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()
//detect the elements in button
btn1 = findTestObject('Object Repository/ChallengingDOM/button1')
btn2 = findTestObject('Object Repository/ChallengingDOM/button2')
btn3 = findTestObject('Object Repository/ChallengingDOM/button3')
WebElement elementBtn1 = WebUiCommonHelper.findWebElement(btn1, 10)
WebElement elementBtn2 = WebUiCommonHelper.findWebElement(btn2, 10)
WebElement elementBtn3 = WebUiCommonHelper.findWebElement(btn3, 10)
WebUI.executeJavaScript("arguments[0].setAttribute('style','outline: thick double green')", Arrays.asList(elementBtn1))
WebUI.executeJavaScript("arguments[0].setAttribute('style','outline: thick double green')", Arrays.asList(elementBtn2))
WebUI.executeJavaScript("arguments[0].setAttribute('style','outline: thick double green')", Arrays.asList(elementBtn3))

/**
 * ensure the content in canvas will be changed
 * when button clicked
 * Per 27/06-2024: could not find the solution yet
 */
canvas = findTestObject('Object Repository/ChallengingDOM/canvas_delete_canvas')
WebElement elementCanvas = WebUiCommonHelper.findWebElement(canvas,10)
WebUI.executeJavaScript("arguments[0].setAttribute('style','border: 3px dotted red')", Arrays.asList(elementCanvas))
//WebUI.click(btn1, FailureHandling.STOP_ON_FAILURE)
//canvas = WebUI.takeElementScreenshot("canvas_screenshoot", findTestObject('Object Repository/ChallengingDOM/canvas_delete_canvas'))
//probably using tesseract lib to read the text on canvas?

//detect the elements in table
rowTotal = 10
for (int rowTable=1;rowTable<=rowTotal;rowTable++) {
	editXPath = "//div[@id='content']/div/div/div/div[2]/table/tbody/tr["+rowTable+"]/td[7]/a[1]" 
	delXPath = "//div[@id='content']/div/div/div/div[2]/table/tbody/tr["+rowTable+"]/td[7]/a[2]"
	for(int colTable = 1;colTable<=6;colTable++) {
		tabXPath = "//div[@id='content']/div/div/div/div[2]/table/tbody/tr["+rowTable+"]/td["+colTable+"]"
		WebElement tableDetail = driver.findElement(By.xpath(tabXPath))
		WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: green; border: 3px dashed yellow;');", Arrays.asList(tableDetail))
 	}
WebElement elementEditBtn = driver.findElement(By.xpath(editXPath))
WebElement elementDelBtn = driver.findElement(By.xpath(delXPath))
WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid yellow;');", Arrays.asList(elementEditBtn))
WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid yellow;');", Arrays.asList(elementDelBtn))
}