package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Rating_Page {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Rating_Page.RatingMethods pageMethods;

    public Rating_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Rating_Page.RatingMethods();
    }

    public interface IRating
    {
        String pageName = "Rating_Options";

        List rp_rating_button = Arrays.asList(By.id("CoRatingOptionsHTML_cmdStartRating"), pageName, "rating_button");
        List rp_writtenPremium_text = Arrays.asList(By.xpath("//tr/td[4]"), pageName,"Written Premium");
        List rp_billedPremium_text = Arrays.asList(By.xpath("//tr/td[5]"), pageName,"Billed Premium");
        List rp_ratingGroupInfo_CheckBox = Arrays.asList(By.xpath("(//label[text()='Rating Group Info']/preceding::input[@type='checkbox'])[3]"),"","ratingGroupInfo_CheckBox");
        List rp_policyAndStateInfo_CheckBox = Arrays.asList(By.xpath("(//label[text()='Policy And State Info']/preceding::input[@type='checkbox'])[4]"), pageName,"policyAndStateInfo_CheckBox");
        List rp_classCodeInfo_CheckBox = Arrays.asList(By.xpath("(//label[text()='Class Code Info']/preceding::input[@type='checkbox'])[5]"), pageName,"classCodeInfo_CheckBox");
        List rp_resequenceLocVeh_CheckBox = Arrays.asList(By.xpath("//label[text()='Resequence Locs/Vehs']/preceding::input[@type='checkbox']"), pageName,"resequenceLocVeh_CheckBox");
        List rp_reRateAllLobs_CheckBox = Arrays.asList(By.xpath("//label[text()='Re-rate All Lobs']/preceding::input[@type='checkbox'][1]"), pageName,"reRateAllLobs_CheckBox");
        List cp_termPremium_text = Arrays.asList(By.xpath("(//td[@title='Term Premium'])[1]"), pageName,"Term Premium");
        List cp_Status_text = Arrays.asList(By.xpath("(//td[@title='Status'])[1]"), pageName,"Status");
        List pes_Common_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Common']"), "Policy Explorer", "'Common_Link'");

    }

    public class RatingMethods implements Rating_Page.IRating
    {
        public String[] ratePolicy(Map<String,String> map)
        {
            String termPremium;
            String writtenPremium;
            String billedPremium;
            String termPremiumCompare;
            String writtenPremiumCompare;
            String billedPremiumCompare;
            String[] list;

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING OPTIONS");
            browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.clicksWebElement(rp_rating_button);
            browserUtil.waitUntilPleaseWaitDisappear();

            termPremium = browserUtil.getsTextOfWebElement(cp_termPremium_text);
            writtenPremium = browserUtil.getsTextOfWebElement(rp_writtenPremium_text);
            billedPremium = browserUtil.getsTextOfWebElement(rp_billedPremium_text);

            termPremiumCompare = browserUtil.returnsExactMatchForVisibleText(map.get("verifyTermPremium"),cp_termPremium_text)+"with previous SP";
            writtenPremiumCompare = browserUtil.returnsExactMatchForVisibleText(map.get("verifyWrittenPremium"),rp_writtenPremium_text)+"with previous SP";
            billedPremiumCompare = browserUtil.returnsExactMatchForVisibleText(map.get("verifyBilledPremium"),rp_billedPremium_text)+"with previous SP";

            list = new String[]
                    {
                            map.get("verifyTermPremium"),
                            map.get("verifyWrittenPremium"),
                            map.get("verifyBilledPremium"),
                            termPremium,
                            writtenPremium,
                            billedPremium,
                            termPremiumCompare,
                            writtenPremiumCompare,
                            billedPremiumCompare
                    };
            browserUtil.switchToDefaultContent();

            return list;
        }


        public void rateValidation() throws Exception
        {
             final String Append="$";

            String ActualtermPremium = browserUtil.getsTextOfWebElement(cp_termPremium_text);
            System.out.println(ActualtermPremium);
            String ActualStatus = browserUtil.getsTextOfWebElement(cp_Status_text);
            System.out.println(ActualStatus);

            browserUtil.clicksWebElement(pes_Common_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            String ExpectedtermPremium = browserUtil.getsTextOfWebElement(cp_termPremium_text);
            System.out.println(ExpectedtermPremium);
            String ExpectedStatus = browserUtil.getsTextOfWebElement(cp_Status_text);
            System.out.println(ExpectedStatus);

            String ExpectedtermPremiumnew= Append + ExpectedtermPremium;

            if(ActualtermPremium.equalsIgnoreCase(ExpectedtermPremiumnew))
            {
                browserUtil.writesToLogAndReport("Pass", "Premium is Correct.");

            }
            else
            {
                browserUtil.writesToLogAndReport("Fail", "Premium is incorrect.");

            }

            if(ActualStatus.equalsIgnoreCase(ExpectedStatus))
            {
                browserUtil.writesToLogAndReport("Pass", " Status is Rated.");
            }
            else
            {
                browserUtil.writesToLogAndReport("Fail", "Status is Not Rated .");

            }

        }

        public void ratePolicyWithoutVerification(Map<String, List<String>> map) throws InterruptedException
        {
            if(map.get("RatingPage_Flag").get(0).equalsIgnoreCase("Yes"))
            {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING OPTIONS");
                browserUtil.waitUntilPleaseWaitDisappear();

                if(map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("Check"))
                {
                    browserUtil.setsCheckBoxTo(true, rp_resequenceLocVeh_CheckBox);
                }
                else if(map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("No") || map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("Uncheck"))
                {
                    browserUtil.setsCheckBoxTo(false, rp_resequenceLocVeh_CheckBox);
                }
                if(map.get("Rerate_All_Lobs_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Rerate_All_Lobs_Flag").get(0).equalsIgnoreCase("Check"))
                {
                    browserUtil.setsCheckBoxTo(true, rp_reRateAllLobs_CheckBox);
                }
                else if(map.get("Rerate_All_Lobs_Flag").get(0).equalsIgnoreCase("No") || map.get("Rerate_All_Lobs_Flag").get(0).equalsIgnoreCase("Uncheck"))
                {
                    browserUtil.setsCheckBoxTo(false, rp_reRateAllLobs_CheckBox);
                }
                if(map.get("Rating_Group_Info_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Rating_Group_Info_Flag").get(0).equalsIgnoreCase("Check"))
                {
                    browserUtil.setsCheckBoxTo(true, rp_ratingGroupInfo_CheckBox);
                }
                else if(map.get("Rating_Group_Info_Flag").get(0).equalsIgnoreCase("No") || map.get("Rating_Group_Info_Flag").get(0).equalsIgnoreCase("Uncheck"))
                {
                    browserUtil.setsCheckBoxTo(false, rp_ratingGroupInfo_CheckBox);
                }
                if(map.get("Policy_and_State_Info_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Policy_and_State_Info_Flag").get(0).equalsIgnoreCase("Check"))
                {
                    browserUtil.setsCheckBoxTo(true, rp_policyAndStateInfo_CheckBox);
                }
                else if(map.get("Policy_and_State_Info_Flag").get(0).equalsIgnoreCase("No") || map.get("Policy_and_State_Info_Flag").get(0).equalsIgnoreCase("Uncheck"))
                {
                    browserUtil.setsCheckBoxTo(false, rp_policyAndStateInfo_CheckBox);
                }
                if(map.get("Class_Code_Info_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Class_Code_Info_Flag").get(0).equalsIgnoreCase("Check"))
                {
                    browserUtil.setsCheckBoxTo(true, rp_classCodeInfo_CheckBox);
                }
                else if(map.get("Class_Code_Info_Flag").get(0).equalsIgnoreCase("No") || map.get("Class_Code_Info_Flag").get(0).equalsIgnoreCase("Uncheck"))
                {
                    browserUtil.setsCheckBoxTo(false, rp_classCodeInfo_CheckBox);
                }
                browserUtil.clicksWebElement(rp_rating_button);
                //browserUtil.switchToDefaultContent();
                //Thread.sleep(60000);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
            /*else{
                browserUtil.clicksWebElement(rp_rating_button);
                Thread.sleep(60000);
            }*/
            //This is temporary change in code,it will confirm after functional team.

        }

        public void ratePolicyWithoutAnyChangeInOptions() throws InterruptedException
        {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING OPTIONS");
                browserUtil.switchToFrame("InsDmain");
                browserUtil.clicksWebElement(rp_rating_button);
                browserUtil.switchToDefaultContent();
                Thread.sleep(4000);
        }

}

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Rating_Page.RatingMethods theUser_() {
        return this.pageMethods;
    }

}