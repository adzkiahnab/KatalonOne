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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//1. direct to the main page
WebUI.openBrowser(GlobalVariable.urlMain)

//2. check if the button is clickable
WebUI.verifyElementClickable(findTestObject('Page_The Internet/a_AB Testing'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_The Internet/a_AB Testing'), FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('https://the-internet.herokuapp.com/abtest')

//4. verify the content
String expectedTitle = ['A/B Test Controlx', 'A/B Test Variation 1x']
String actualTitle = WebUI.getText(findTestObject('Object Repository/Page_The Internet/h3_AB Test Control'))
if (expectedTitle.contains(actualTitle)) println('up')
	else println('down')

String expectedPar = 'Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).'
String actualPar = WebUI.getText(findTestObject('Object Repository/Page_The Internet/p_Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text andor functionality works best towards a desired outcome (e.g. a u'))
WebUI.verifyEqual(actualPar, expectedPar, FailureHandling.CONTINUE_ON_FAILURE)

//5. Verify Footer
String expectedFooter = 'Powered by Elemental Selenium'
String actualFooter = WebUI.getText(findTestObject('Object Repository/Page_The Internet/div_Powered by Elemental Selenium'))
WebUI.verifyEqual(actualFooter, expectedFooter, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_The Internet/a_Elemental Selenium'), FailureHandling.STOP_ON_FAILURE)
WebUI.switchToWindowUrl('https://elementalselenium.com/')

WebUI.closeBrowser()
