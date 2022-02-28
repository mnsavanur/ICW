package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shreyas on 02/02/2022.
 */
public class AdditionalInterests_Page {

    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private AdditionalInterests_Page.IAddInterestMethods pageMethods;

    public AdditionalInterests_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_Util) {

        this.browserUtil = browser_Util;
        this.baseUtil = base_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new AdditionalInterests_Page.IAddInterestMethods();
    }

    public interface IAddInterest {
        List cp_AddInterest_link=Arrays.asList(By.xpath("//button[normalize-space()='Additional Interests']"),"Add Interest Page","Add Interest");
        List cp_AddInterest_Drpdwn=Arrays.asList(By.xpath("//input[@id='CoAdditionalInterestsEdit_ddTypeCd_comboboxinput']"),"Add Interest Page","Add Interest");
        List cp_Addname_btn=Arrays.asList(By.xpath("//button[normalize-space()='Add Name']"),"Add Interest Page","Add Name");
        List cp_AddInterestName_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Additional Interest Name:')]/..//following-sibling::div[1]//textarea"), "Add Interest Page", "Additional Interest Name");
        List cp_Address_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Address:')]/..//following-sibling::div[1]//input"), "Add Interest Page", "Address");
        List cp_City_Textbox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), "Add Interest Page", "City");
        List cp_State_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'State:')]/..//following-sibling::div[1]//input"), "Add Interest Page", "State");
        List cp_Zipcode_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), "Add Interest Page", "Zipcode");

    }

    public class IAddInterestMethods implements AdditionalInterests_Page.IAddInterest {
        public void CPAddInterest(Map<String, List<String>> map)
        {
            if(map.get("CP_AddInterest_Page").get(0).equalsIgnoreCase("Yes"))
            {
                browserUtil.clicksWebElement(cp_AddInterest_link);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("CP_AddInterest").get(0),cp_AddInterest_Drpdwn);
                browserUtil.clicksWebElement(cp_Addname_btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(cp_AddInterestName_Textbox,map.get("CP_AddInterestName").get(0));
                browserUtil.entersTextWithTabIn(cp_Address_Textbox,map.get("CP_Address").get(0));
                browserUtil.entersTextWithTabIn(cp_City_Textbox,map.get("CP_City").get(0));
                browserUtil.CMPDropDown(map.get("CP_State").get(0),cp_State_Drpdwn);
                browserUtil.entersTextWithTabIn(cp_Zipcode_Textbox,map.get("CP_Zipcode").get(0));
                baseUtil.clicksOnSave();
                browserUtil.waitUntilPleaseWaitDisappear();

            }
        }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public AdditionalInterests_Page.IAddInterestMethods theUser_() {
        return this.pageMethods;
    }
}