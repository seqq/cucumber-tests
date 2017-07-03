package steps

import java.util.concurrent.TimeUnit
import java.net.URL
import java.lang.Object

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.scalatest.Matchers

class ExampleSteps extends ScalaDsl with EN {
  //private val log = LoggerFactory.getLogger(classOf[ExampleSteps])

  val capability = DesiredCapabilities.chrome()
  val driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), capability)

  val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(6, TimeUnit.SECONDS)
    .pollingEvery(1, TimeUnit.SECONDS)

  /*
  Before { scenario =>
    log.info("Before...")
  }
  After { scenario =>
    log.info("...After")
  }
  */

  Given("""^I have navigated to google$""") { () =>
    driver.navigate().to("###TOKEN_FULL_SITE_ADDRESS###")
  }
  Then("""^the page title should be "(.*?)"$""") { (title: String) =>
    fluentWait.until(ExpectedConditions.titleIs(title))
  }
}