import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.STOP_ON_FAILURE
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

WebUI.verifyElementPresent(findTestObject('Object Repository/BasicAuth/a_Basic Auth'), 11)
WebUI.click(findTestObject('Object Repository/BasicAuth/a_Basic Auth'))
currentUrl = WebUI.getUrl()
WebUI.authenticate(currentUrl, 'admin', 'admin', 4, FailureHandling.STOP_ON_FAILURE)

String actHeader = 'Basic Auth'
String expHeader = WebUI.getText(findTestObject('Object Repository/BasicAuth/h3_Basic Auth'))
WebUI.verifyMatch(actHeader, expHeader, false, FailureHandling.CONTINUE_ON_FAILURE)

String actContent = 'Congratulations! You must have the proper credentials.'
String expContent = WebUI.getText(findTestObject('Object Repository/BasicAuth/p_Basic Auth'))
WebUI.verifyMatch(actHeader, expHeader, false, FailureHandling.CONTINUE_ON_FAILURE)

