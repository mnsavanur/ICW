package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Sapna Gour on 2/1/2018.
 */
public class Underwriter_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Underwriter_Page.UnderwriterMethods pageMethods;

    public Underwriter_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Underwriter_Page.UnderwriterMethods();
    }

    public interface IUnderwriter {
        List up_underwriter_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoUnderwriterHTML_CoUnderwriter_UndwrNm_comboboxinput']"), "Underwriter Page", "Underwriter");


    }

    public class UnderwriterMethods implements Underwriter_Page.IUnderwriter {

        public void enterUnderwriterDetails(Map<String, List<String>> map) throws InterruptedException {

            if(map.get("UnderWriter_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("UNDERWRITER/OPERATOR");
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                //WebDriverWait waitForWebDriver = new WebDriverWait(browserUtil.driver, 240);
                //waitForWebDriver.until(ExpectedConditions.elementToBeClickable(By.id("CoUnderwriterHTML_CoUnderwriter_UndwrNm_comboboxinput")));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(up_underwriter_DrpDwn);
                browserUtil.CMPDropDown(map.get("Underwriter").get(0), up_underwriter_DrpDwn);
                browserUtil.sendsTabKeyOnWebElement(up_underwriter_DrpDwn);
                //browserUtil.waitsUntilWebElementIsVisible(up_underwriter_DrpDwn);
            }
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Underwriter_Page.UnderwriterMethods theUser_() {
        return this.pageMethods;
    }
}
