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

//Additional
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import java.net.HttpURLConnection
import java.net.URL

WebUI.click(findTestObject('Object Repository/BrokenImages/a_Broken Images'), FailureHandling.STOP_ON_FAILURE)

TestObject imgAll = findTestObject('Object Repository/BrokenImages/img')
int counter = 0

//get the images
List<WebElement> images = WebUiCommonHelper.findWebElements(findTestObject(imgAll), 30)
println(images.size().toString())

//check all the images and try to find the broken images
for (WebElement img : images) {
	String imgUrl = img.getAttribute('src')
	try {
		URL url = new URL(imgUrl)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection()
		connection.setRequestMethod('GET')
		connection.connect()
		int responseCode = connection.getResponseCode()
		if (responseCode != 200) {
			KeywordUtil.markFailed('Broken image: ' + imgUrl + ' with response code: ' + responseCode)
		} else {
			KeywordUtil.logInfo('Normal image: ' + imgUrl)
		}
	} catch (Exception e) { //unexpected error while or when try to check the image
		KeywordUtil.markFailed('Error checking image: ' + imgUrl + ' - ' + e.getMessage())
	}
}
