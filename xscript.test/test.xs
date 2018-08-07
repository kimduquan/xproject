import -class org.openqa.selenium.edge.EdgeDriver
import -class java.lang.System
setProperty -class System -key webdriver.edge.driver -value D:\\installed\\MSWebdriver\\MicrosoftWebDriver.exe
new -class EdgeDriver -return #driver
get -this #driver -url http://www.google.com
findElementById -this #driver -using lst-ib -return #input
assert -not -null #input
//sendKeys -this #input -keysToSend abc
findElementByName -this #driver -using btnK -return #button
assert -not -null #button
click -this #button
try
    findElementByPartialLinkText -this #driver -using ABC.com -return $abc
catch -return #ex
    printStackTrace -this #ex
final
close -this #driver