package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FEIN_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private FEIN_Page.FEINMethods pageMethods;

    public FEIN_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new FEIN_Page.FEINMethods();
    }

    public interface IFEIN {
        //List fp_RowOneFEIN_Link = Arrays.asList(By.xpath("//a[contains(@id , 'RowSelectLink') and position()=1]"), "Entity Feins", "'RowOneFEIN_Link'");
        //List fp_feinNumber_text = Arrays.asList(By.id("WkEntityFEINsEdit_WkEntityFEINDetailHTML_ActiveControl_WkLegalEntity_FEINId"), "Fein Page", "FeinTxt");
        //String Append = "99-";
        List fp_RowOneFEIN_Link = Arrays.asList(By.xpath("//a[@title='FEIN-Tax Id']"), "Entity Feins", "'RowOneFEIN_Link'");
        List fp_feinNumber_text = Arrays.asList(By.id("WkEntityFEINDetailHTML_WkLegalEntity_FEINId_FLD"), "Fein Page", "FeinTxt");
        String Append = "99-";
    }

    public class FEINMethods implements FEIN_Page.IFEIN {

        public void updateFeinNamesTxt(Map<String, String> map, String feinNumber) throws InterruptedException {
            String feinNumberTxt = Append + feinNumber;

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("FEINS");
            browserUtil.waitUntilPleaseWaitDisappear();
            try {
                String parent = browserUtil.getWindowHandle();
                browserUtil.switchToChildWindow();
                browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).click();
                browserUtil.switchToWindowWithHandle(parent);
            } catch (Exception e) {

            }
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            //browserUtil.switchToFrame("IFEntity");
            browserUtil.clicksWebElement(fp_RowOneFEIN_Link);
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(fp_feinNumber_text);
            browserUtil.entersTextWithoutTabIn(fp_feinNumber_text, feinNumberTxt);
            //browserUtil.switchToDefaultContent();
            baseUtil.clicksOnSave();
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public FEIN_Page.FEINMethods theUser_() {
        return this.pageMethods;
    }

}