package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PolicyForms_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private PolicyFormsMethods pageMethods;

    public PolicyForms_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new PolicyFormsMethods();
    }

    public interface IPolicyForms {
        List pf_Yes_Link = Arrays.asList(By.xpath("//a[contains(@id,'FillinIndLink')]"), "Policy_Forms", "'Yes_Link'");
        List pf_FillIn_RadioButton = Arrays.asList(By.id("CoFormProcMainHTML_rbFillin"), "Policy_Forms", "FillIn_RadioButton");
        List pf_AddForm_Button = Arrays.asList(By.id("CoFormProcMainHTML_cmdAddForm"), "Policy_Forms", "'AddForm_Button'");
        List pf_SearchForm_TextBox = Arrays.asList(By.id("CoFormProcMainHTML_txtFind"), "Policy_Forms", "'SearchForm_TextBox'");
        List pf_SearchForm_Button = Arrays.asList(By.id("CoFormProcMainHTML_cmdFind"), "Policy_Forms", "'SearchForm_Button'");
        List pf_Value_DropDown = Arrays.asList(By.xpath("//input[@id='CoFormProcMainHTML_ddViewSelect_comboboxinput']"), "Policy_Forms", "'Value_DropDown'");
        List pf_lineOfBusiness_drpDown = Arrays.asList(By.xpath("//input[@id='CoFormProcMainHTML_ddLobs_comboboxinput']"), "Policy_Forms", "Line of Business");
        List pf_GeneralLiablity_textbox = Arrays.asList(By.xpath("//label[contains(.,'General Liability:')]/..//following-sibling::div[1]//input"), "Genaeral Laibility", "Commissions");
        List pf_allCommissions_textbox = Arrays.asList(By.xpath("//label[contains(.,'All:')]/..//following-sibling::div[1]//input"), "All", "Commissions");
        List pf_commission_tab = Arrays.asList(By.xpath("//button[normalize-space()='Commissions']"), "All", "Commissions");
        List pf_cutOfDate = Arrays.asList(By.xpath("//label[contains(.,'Cut-Off Date:')]/..//following-sibling::div[1]//input"), "Policy_Forms", "Cut Of Date");
    }

    public class PolicyFormsMethods implements IPolicyForms {
        public void searchesAndAddsForm(Map<String, String> map) throws InterruptedException {
            List pf_SearchedFormUnchecked_CheckBox;
            List pf_FormChecked_CheckBox;

            pf_SearchedFormUnchecked_CheckBox = Arrays.asList(By.xpath("//table[@role='grid']/tbody/tr[./td[normalize-space()='" + map.get("Add_Form_Name") + "']]//img[@title='Unchecked']"), "Policy_Forms", "'SearchedFormUnchecked_CheckBox' (" + map.get("Add_Form_Name") + ")");

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.clicksWebElement(pf_AddForm_Button);
            browserUtil.entersTextWithTabIn(pf_SearchForm_TextBox, map.get("Add_Form_Name"));
            browserUtil.clicksWebElement(pf_SearchForm_Button);
            browserUtil.clicksWebElement(pf_SearchedFormUnchecked_CheckBox);
            baseUtil.clicksOnNext();

            pf_FormChecked_CheckBox = Arrays.asList(By.xpath("//table[@role='grid']/tbody/tr[./td[normalize-space()='" + map.get("Add_Form_Name") + "']]//img[@title='Checked']"), "Policy_Forms", "'FormChecked_CheckBox' (" + map.get("Add_Form_Name") + ")");

            if (browserUtil.verifiesWebElementIsPresent(pf_FormChecked_CheckBox)) {
                browserUtil.writesToLogAndReport("Pass", "Form '" + map.get("Add_Form_Name") + "' added successfully.");
            } else {
                browserUtil.writesToLogAndReport("Fail", "Form '" + map.get("Add_Form_Name") + "' not added.");
            }
        }

        public void fillsInPolicyForms2(Map<String, List<String>> testDataAsMap) throws InterruptedException {
            List additionalFillInLink;
            List pf_Yes_Link;
            int yesLinkCounter;

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(testDataAsMap.get("Line_of_Business").get(0), pf_lineOfBusiness_drpDown);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown("Fillin", pf_Value_DropDown);
            browserUtil.waitUntilPleaseWaitDisappear();
            additionalFillInLink = browserUtil.driver.findElements(By.xpath("//a[contains(@id,'FillinIndLink') and (normalize-space()='Yes' or normalize-space()='YES' or normalize-space()='yes')]"));

            System.out.println("No of links (Policy Forms) -> " + additionalFillInLink.size());

            for (yesLinkCounter = 0; yesLinkCounter < additionalFillInLink.size(); yesLinkCounter++) {
                try {
                    pf_Yes_Link = Arrays.asList(By.xpath("//a[contains(@id,'FillinIndLink') and (normalize-space()='Yes' or normalize-space()='YES' or normalize-space()='yes')]"), "Policy_Forms", "'Yes_Link' (" + yesLinkCounter + ")");
                    browserUtil.waitsUntilWebElementIsClickable(pf_Yes_Link);
                    browserUtil.clicksWebElement(pf_Yes_Link);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    try {
                        if (browserUtil.verifiesWebElementIsPresent(pf_cutOfDate)) {
                            if (testDataAsMap.get("Cut_Off_Date").get(0).equalsIgnoreCase("Yes")) {
                                browserUtil.entersTextWithTabIn(pf_cutOfDate, testDataAsMap.get("CutOff_Date1").get(0));
                                // browserUtil.entersDate(pf_cutOfDate, testDataAsMap.get("CutOff_Date1").get(0));
                            }
                        }
                    } catch (Exception e) {
                    }
                    baseUtil.clicksOnNext();
                    try {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Cancel']")).click();
                        browserUtil.clicksWebElement(pf_Yes_Link);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        baseUtil.clicksOnNext();
                        browserUtil.switchToWindowWithHandle(parent);

                    } catch (Exception e) {

                    }
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.sendsDownArrowKey();
                    browserUtil.sendsDownArrowKey();
                    browserUtil.sendsDownArrowKey();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void formValidation(Map<String, List<String>> testDataAsMap) {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.CMPDropDown(testDataAsMap.get("Line_of_Business").get(0), pf_lineOfBusiness_drpDown);
            //browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.CMPDropDown("All", pf_Value_DropDown);

            for (int i = 0; i < testDataAsMap.get("CovgForms").size(); i++) {
                if (!testDataAsMap.get("Line_of_Business").get(i).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.CMPDropDown(testDataAsMap.get("Line_of_Business").get(i), pf_lineOfBusiness_drpDown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    try {
                        browserUtil.CMPDropDown("All", pf_Value_DropDown);
                    } catch (Exception e) {

                    }
                }

                if (!testDataAsMap.get("CovgForms").get(i).equalsIgnoreCase("$$NA$$")) {

                    List pf_FormPresent = Arrays.asList(By.xpath("//td/a[normalize-space()='" + testDataAsMap.get("CovgForms").get(i).trim() + "']"), "Policy_Forms", "'FormPresent' (" + testDataAsMap.get("CovgForms").get(i) + ")");

                    /*if(pf_FormPresent.contains("CG 25 03"))
                    {
                        //browserUtil.scrollsWebElementIntoView(pf_FormPresent);
                        browserUtil.scrollToBottom();
                    }*/
                    if (browserUtil.verifiesWebElementIsPresent(pf_FormPresent)) {
                        browserUtil.writesToLogAndReport("Pass", "Form '" + testDataAsMap.get("CovgForms").get(i) + "' is present.");
                    } else {
                        browserUtil.writesToLogAndReport("Fail", "Form '" + testDataAsMap.get("CovgForms").get(i) + "' is not present.");
                    }


                }
            }

        }

        public void fillsInPolicyForms() {
            List additionalFillInLink;
            List pf_Yes_Link;
            int yesLinkCounter;

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            //browserUtil.selectsRadioButton(pf_FillIn_RadioButton);
            //browserUtil.CMPDropDown(testDataAsMap.get("ValueDrpDwn").get(0),pf_Value_DropDown);
            additionalFillInLink = browserUtil.driver.findElements(By.xpath("//a[contains(@id,'FillinIndLink') and (normalize-space()='Yes' or normalize-space()='YES' or normalize-space()='yes')]"));

            System.out.println("No of links (Policy Forms) -> " + additionalFillInLink.size());

            for (yesLinkCounter = 0; yesLinkCounter < additionalFillInLink.size(); yesLinkCounter++) {
                try {
                    pf_Yes_Link = Arrays.asList(By.xpath("//a[contains(@id,'FillinIndLink') and (normalize-space()='Yes' or normalize-space()='YES' or normalize-space()='yes')]"), "Policy_Forms", "'Yes_Link' (" + yesLinkCounter + ")");
                    browserUtil.clicksWebElement(pf_Yes_Link);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    baseUtil.clicksOnNext();
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.sendsDownArrowKey();
                    browserUtil.sendsDownArrowKey();
                    browserUtil.sendsDownArrowKey();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //New method added by AP for GL LOB
        public void Commissions(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("Commissions").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElement(pf_commission_tab);
                browserUtil.GLntersTextWithTabIn(pf_allCommissions_textbox, map.get("AllCommission").get(0));
                ;
                browserUtil.GLntersTextWithTabIn(pf_GeneralLiablity_textbox, map.get("Commission_General_Liability").get(0));
                ;
            }
        }

        public void UnCheck(Map<String, List<String>> testDataAsMap) {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
            browserUtil.waitUntilPleaseWaitDisappear();
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            browserUtil.waitUntilPleaseWaitDisappear();

            for (int i = 0; i < testDataAsMap.get("CovgForms").size(); i++) {
                if (!testDataAsMap.get("Line_of_Business").get(i).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.CMPDropDown(testDataAsMap.get("Line_of_Business").get(i), pf_lineOfBusiness_drpDown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    try {
                        browserUtil.CMPDropDown("All", pf_Value_DropDown);
                    } catch (Exception e) {

                    }
                }

                if (!testDataAsMap.get("CovgForms").get(i).equalsIgnoreCase("$$NA$$")) {

                    List pf_FormPresent = Arrays.asList(By.xpath("//td/a[normalize-space()='" + testDataAsMap.get("CovgForms").get(i).trim() + "']"), "Policy_Forms", "'FormPresent' (" + testDataAsMap.get("CovgForms").get(i) + ")");
                    List pf_UnCheck_click = Arrays.asList(By.xpath("//tbody//tr//td[contains(normalize-space(),'" + testDataAsMap.get("CovgForms").get(i).trim() + "')]/preceding-sibling::td"), "Policy_Forms", "'FormPresent' (" + testDataAsMap.get("CovgForms").get(i) + ")");

                    if (browserUtil.verifiesWebElementIsPresent(pf_FormPresent)) {
                        browserUtil.clicksWebElement(pf_UnCheck_click);
                        browserUtil.writesToLogAndReport("Pass", "Form '" + testDataAsMap.get("CovgForms").get(i) + "' is present & Remove.");
                    } else {
                        browserUtil.writesToLogAndReport("Fail", "Form '" + testDataAsMap.get("CovgForms").get(i) + "' is not present.");
                    }


                }
            }

        }

        public void UnCheck1() throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
            browserUtil.waitUntilPleaseWaitDisappear();
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("POLICY FORMS");
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.CMPDropDown(map.get("GL_PolicyType").get(0), gl_policyType_DrpDwn);
            //browserUtil.waitUntilPleaseWaitDisappear();

        }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public PolicyFormsMethods theUser_() {
        return this.pageMethods;
    }

}