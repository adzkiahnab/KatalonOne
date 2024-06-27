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

import com.kms.katalon.core.util.KeywordUtil

TestObject addBtn = findTestObject('Object Repository/AddRemove/button_Add Element')
TestObject newBtn = findTestObject('Object Repository/AddRemove/button_Delete')

WebUI.verifyElementInViewport(findTestObject('Object Repository/AddRemove/a_AddRemove Elements'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AddRemove/a_AddRemove Elements'), FailureHandling.STOP_ON_FAILURE)

//verify the header text
WebUI.navigateToUrl('https://the-internet.herokuapp.com/add_remove_elements/')
String addremoveHeader = WebUI.getText(findTestObject('Object Repository/AddRemove/h3_AddRemove Elements'))
WebUI.verifyMatch('Add/Remove Elements', addremoveHeader, false, FailureHandling.CONTINUE_ON_FAILURE)

//click the add button to generate new Button
WebUI.verifyElementVisible(addBtn, FailureHandling.STOP_ON_FAILURE)
GlobalVariable.amtClick = 3
WebUI.click(addBtn, FailureHandling.STOP_ON_FAILURE)
WebUI.click(addBtn, FailureHandling.STOP_ON_FAILURE)
WebUI.click(addBtn, FailureHandling.STOP_ON_FAILURE)
 
//verify amount of button(s) that generated equals with the User input (by click)
GlobalVariable.amtBtn = CustomKeywords.'functionToCall.HerokuApp.addElements'(newBtn)
WebUI.verifyEqual(GlobalVariable.amtClick, GlobalVariable.amtBtn, FailureHandling.STOP_ON_FAILURE)
