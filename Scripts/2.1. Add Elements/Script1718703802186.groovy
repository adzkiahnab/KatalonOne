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

TestObject addBox = findTestObject('Object Repository/AddRemove/button_Add Element')
TestObject newBox = findTestObject('Object Repository/AddRemove/button_Delete')

WebUI.verifyElementInViewport(findTestObject('Object Repository/AddRemove/a_AddRemove Elements'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/AddRemove/a_AddRemove Elements'), FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://the-internet.herokuapp.com/add_remove_elements/')

String addremoveHeader = WebUI.getText(findTestObject('Object Repository/AddRemove/h3_AddRemove Elements'))

WebUI.verifyMatch('Add/Remove Elements', addremoveHeader, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(addBox, FailureHandling.STOP_ON_FAILURE)
WebUI.click(addBox, FailureHandling.STOP_ON_FAILURE)
WebUI.click(addBox, FailureHandling.STOP_ON_FAILURE)
WebUI.click(addBox, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.amtBox = CustomKeywords.'functionToCall.addRemove.addElements'(newBox)

