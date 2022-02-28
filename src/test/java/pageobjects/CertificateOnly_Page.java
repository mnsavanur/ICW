package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import utilities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by  on 15/02/2022.
 */
public class CertificateOnly_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private Synchronization_Util synchronizationUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private CertificateOnlyMethods pageMethods;
    private String parent;

    public CertificateOnly_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new CertificateOnlyMethods();
    }

    public interface ICapitalAsset {
        List hp_searchCriteria_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput']"), "Home Page", "'SearchCriteria_DropDown'");
        List hp_searchDescription_text = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchDescription_FLD"), "Home Page", "'SearchDescription_TextBox'");
        List hp_policyAction2_DrpDwn = Arrays.asList(By.xpath("//select[@id='CoPolicySelectPg_PolicyGrid_ddTransactionList']"), "Home Page", "'PolicyAction_DropDown'");
        List hp_policyAction_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoPolicySelectPg_PolicyGrid_ddTransactionList_comboboxinput']"), "Home Page", "'PolicyAction_DropDown'");
        List hp_Search_Img = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_ButtonSelectPolicy"), "Home Page", "'Search_Img'");
        List hp_GoImg_Lnk = Arrays.asList(By.id("CoPolicySelectPg_PolicyGrid_cmdGoTransaction"), "Home Page", "'GoImg_Lnk'");
        List hp_policyunlock_SAN_DrpDwn = Arrays.asList(By.xpath("//option[@value='SystemAssignId']//parent::select"), "Home Page", "Policy Type");
        List hp_policyunlock_SAN_textbox = Arrays.asList(By.xpath("//input[@id='UtPolicyUnlock_dgPolicyList_Paged_searchValue']"), "Home Page", "Policy Type");
        List hp_sanNumber_text = Arrays.asList(By.xpath("//td[@title='System Assign No. ']"), "Home Page", "SAN Number");
        List pt_transVirtualPolicy_btn = Arrays.asList(By.xpath("//span[text()='Virtual Policy']"), "Home Page", "Virtual Policy");

        List AddCertificate_Btn = Arrays.asList(By.xpath("(//span[@class='btnText'])[1]"), "CertificateOnly Page", "Add Certificate Tab");
        List Certificates_Tab = Arrays.asList(By.xpath("//span[@title='Certificates']//parent::li"), "CertificateOnly Page", "Certificates Tab");
        List CertHolder_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Cert Holder:')]/..//following-sibling::div[1]//textarea"), "CertificateOnly Page", "Cert Holder");
        List Address_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Address:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Address Textbox");
        List City_Textbox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "City Textbox");
        List State_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'State:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "State Textbox");
        List Zipcode_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Zip Code Textbox");
        List DescOperation_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Desc of Operation:')]/..//following-sibling::div[1]//textarea"), "CertificateOnly Page", "Desc of Operation Textbox");
        List CancelDays_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Cancel Days:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Cancel Days Textbox");
        List Copies_Textbox = Arrays.asList(By.xpath("//label[contains(.,'# of Copies:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "# of Copies Textbox");
        List Certificate_Other_Tab = Arrays.asList(By.xpath("//span[@title='Other']"), "CertificateOnly Page", "Other Tab");
        List Other_One_Type_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Other (1) Type:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Other 1 Type Textbox");
        List Policy_Eff_Textbox = Arrays.asList(By.xpath("//input[@id='CoCertPolicy01HTML_CoCertPolicyInput_PolicyEff1Dt_FLD']"), "CertificateOnly Page", "Policy Eff Textbox");
        List Policy_Exp_Textbox = Arrays.asList(By.xpath("//input[@id='CoCertPolicy01HTML_CoCertPolicyInput_PolicyExp1Dt_FLD']"), "CertificateOnly Page", "Policy Exp Textbox");
        List Insurance_Co_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCertPolicy01HTML_CoCertPolicyInput_Insurer1Id_LST_comboboxinput']"), "CertificateOnly Page", "Insurance Co Dropdown");
        List Select_All_to_Print_Btn = Arrays.asList(By.xpath("//button[@id='CoCertPrintHTML_cmdAllPrint']"), "CertificateOnly Page", "Select All To Print Btn");
        List Print_Btn = Arrays.asList(By.xpath("//button[@id='CoCertPrintHTML_cmdPrintCertificates']"), "CertificateOnly Page", "Print Button");
        List Start_Print_Btn = Arrays.asList(By.xpath("//button[@id='CoPrintHTML_cmdPrint']"), "CertificateOnly Page", "Start Print Button");
        List Save_Btn = Arrays.asList(By.xpath("//i[@class='toolbar-save toolbarbutton-icon']"), "CertificateOnly Page", "Save Button");
        //GL Locators
        List GL_Tab = Arrays.asList(By.xpath("//span[@title='General Liab']//parent::li"), "CertificateOnly Page", "GL Tab");

        List General_Aggregate_Textbox = Arrays.asList(By.xpath("//label[contains(.,'General Aggregate:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "General Aggregate Textbox");
        List Product_Compl_Ops_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Product Compl Ops:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Product Compl Ops Textbox");
        List Personal_Adv_Injury_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Personal/Adv Injury:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Personal/Adv Injury Textbox");
        List Each_Occurrence_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Each Occurrence:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Each Occurrence Textbox");
        List Fire_Damage_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Fire Damage:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Fire Damage Textbox");
        List Medical_Expense_Textbox = Arrays.asList(By.xpath("//label[contains(.,'Medical Expense:')]/..//following-sibling::div[1]//input"), "CertificateOnly Page", "Medical Expense Textbox");
        List GL_Policy_Eff_Textbox = Arrays.asList(By.xpath("//input[@id='CoCertPolicyGLHTML_CoCertPolicyInput_PolicyEff1Dt_FLD']"), "CertificateOnly Page", "GL Policy Eff Textbox");
        List GL_Policy_Exp_Textbox = Arrays.asList(By.xpath("//input[@id='CoCertPolicyGLHTML_CoCertPolicyInput_PolicyExp1Dt_FLD']"), "CertificateOnly Page", "GL Policy Exp Textbox");
        List GL_Insurance_Co_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCertPolicyGLHTML_CoCertPolicyInput_Insurer1Id_LST_comboboxinput']"), "CertificateOnly Page", "GL Insurance Co Dropdown");
        List GL_Comprehensive_Checkbox = Arrays.asList(By.xpath("//input[@id='CoCertPolicyGLHTML_CoCertPolicyInput_Insurer1Id_LST_comboboxinput']"), "CertificateOnly Page","Comprehensive Checkbox");
        List GL_Occurrence_Checkbox = Arrays.asList(By.xpath("//label[normalize-space()='Occurrence']/preceding::input[1]"), "CertificateOnly Page", "Occurrence Checkbox");
        List GL_Claims_Made_Checkbox = Arrays.asList(By.xpath("//label[normalize-space()='Claims Made']/preceding::input[1]"), "CertificateOnly Page", "Claims Made Checkbox");
        List GL_Other1_Checkbox = Arrays.asList(By.xpath("//label[normalize-space()='Other(1)']/preceding::input[1]"), "CertificateOnly Page", "Other(1) Checkbox");
        List GL_Other2_Checkbox = Arrays.asList(By.xpath("//label[normalize-space()='Other(2)']/preceding::input[1]"), "CertificateOnly Page", "Other(2) Checkbox");
      //  List hp_policyunlock_SAN_textbox = Arrays.asList(By.xpath("//input[@id='UtPolicyUnlock_dgPolicyList_Paged_searchValue']"), "Home Page", "Policy Type");
        //List hp_sanNumber_text = Arrays.asList(By.xpath("//td[@title='System Assign No. ']"), "Home Page", "SAN Number");

        String pageName = "Policy_Type";

        List Certificate_Sub_GL_Tab = Arrays.asList(By.xpath("//span[@title='General Liab']"), "CertificateOnly Page", "SubGl Tab");
        List cp_ClaimsMade_CheckBox = Arrays.asList(By.xpath("(//label[text()='Claims Made']/preceding::input[@type='checkbox'])[3]"), pageName,"Claims Made_CheckBox");
    }

    public class CertificateOnlyMethods implements ICapitalAsset {


        public void enterCertificateOnlyDetail(Map<String, List<String>> map, String sanNumber) throws InterruptedException {
            String sanNum = sanNumber;
            String policyAction = map.get("policyAction").get(0);
            try {
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);

//                unlockpolicy(map);
//                deletesAnyTransactionInProgress();

                browserUtil.CMPDropDown("CIRT", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }

                if (map.get("Certificates_Flag").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(Certificates_Tab);
                    browserUtil.clicksWebElement(AddCertificate_Btn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(CertHolder_Textbox, map.get("CertHolder").get(0));
                    browserUtil.entersTextWithTabIn(Address_Textbox, map.get("Addr").get(0));
                    browserUtil.entersTextWithTabIn(City_Textbox, map.get("City").get(0));
                    browserUtil.CMPDropDown(map.get("State").get(0),State_DrpDwn);
                    browserUtil.entersTextWithTabIn(Zipcode_Textbox, map.get("ZipCode").get(0));
                    browserUtil.entersTextWithTabIn(DescOperation_Textbox, map.get("Desc_Op").get(0));
                    browserUtil.entersTextWithTabIn(CancelDays_Textbox, map.get("CancelDays").get(0));
                    browserUtil.entersTextWithTabIn(Copies_Textbox, map.get("Copies").get(0));

//                    if (map.get("GL_Flag").get(0).equalsIgnoreCase("Yes")) {
//                        browserUtil.clicksWebElement(GL_Tab);
//
//                        if(map.get("GL_Occur_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("Check"))
//                        {
//                            browserUtil.setsCheckBoxTo(true, GL_Occurrence_Checkbox);
//                        }
                        /*else if(map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("No") || map.get("Resequence_LocsVehs_Flag").get(0).equalsIgnoreCase("Uncheck"))
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
                        }*/

                       /* browserUtil.entersTextWithTabIn(General_Aggregate_Textbox, map.get("General_Aggr").get(0));
                        browserUtil.entersTextWithTabIn(Product_Compl_Ops_Textbox, map.get("Prod_Coml_Ops").get(0));
                        browserUtil.entersTextWithTabIn(Personal_Adv_Injury_Textbox, map.get("Personal_Adv_Inj").get(0));
                        browserUtil.entersTextWithTabIn(Each_Occurrence_Textbox, map.get("Each_Occ").get(0));
                        browserUtil.entersTextWithTabIn(Fire_Damage_Textbox, map.get("Fire_Dmg").get(0));
                        browserUtil.entersTextWithTabIn(Medical_Expense_Textbox, map.get("Medical_Expe").get(0));*/
                       /* browserUtil.entersDate(GL_Policy_Eff_Textbox,map.get("GL_Eff_Date").get(0));
                        browserUtil.entersDate(GL_Policy_Exp_Textbox,map.get("GL_Exp_Date").get(0));
                        browserUtil.CMPDropDown(map.get("GL_Ins_Comp").get(0), GL_Insurance_Co_DrpDwn);*/

                    }

                 if (map.get("Sub_GL_Flag").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(Certificate_Sub_GL_Tab);

                     if(map.get("Claims_Made_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Claims_Made_Flag").get(0).equalsIgnoreCase("Check"))
                     {
                         browserUtil.setsCheckBoxTo(true, cp_ClaimsMade_CheckBox);
                     }
                     else if(map.get("Claims_Made_Flag").get(0).equalsIgnoreCase("No") || map.get("Claims_Made_Flag").get(0).equalsIgnoreCase("Uncheck"))
                     {
                         browserUtil.setsCheckBoxTo(false, cp_ClaimsMade_CheckBox);
                     }
                }

                    if (map.get("CAP_Other_Flag").get(0).equalsIgnoreCase("Yes")) {
                        browserUtil.clicksWebElement(Certificate_Other_Tab);
                        browserUtil.entersTextWithTabIn(Other_One_Type_Textbox, map.get("Other_1_Type").get(0));
                        browserUtil.entersDate(Policy_Eff_Textbox,map.get("Eff_Date").get(0));
                        browserUtil.entersDate(Policy_Exp_Textbox,map.get("Exp_Date").get(0));
                        browserUtil.CMPDropDown(map.get("Ins_Comp").get(0), Insurance_Co_DrpDwn);
                    }

                    baseUtil.clicksOnNext();
                    browserUtil.clicksWebElement(Select_All_to_Print_Btn);
                    baseUtil.clicksOnSave();
                    baseUtil.clicksOnNext();
                }
            }

      /*  public void unlockpolicy(Map<String, List<String>> testDataAsMap) throws InterruptedException {
            WebElement transactionStatusLabel;
            transactionStatusLabel = browserUtil.driver.findElement(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"));
            browserUtil.scrollsWebElementIntoView(transactionStatusLabel);

            try {
                if (transactionStatusLabel.getText().equals("Locked - External")) {

                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Home']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Tools']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//a[text()='Utilities']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Policy Unlock']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();


                    browserUtil.getDriver().findElement(By.id("UtPolicyUnlock_dgPolicyList_Paged_searchField")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

                    browserUtil.entersTextWithTabIn(hp_policyunlock_SAN_DrpDwn, testDataAsMap.get("sanNumber").get(0));

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Find']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//table//tr//following-sibling::td[normalize-space()='" + testDataAsMap.get("sanNumber").get(0) + "']//parent::tr//td//child::input")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Unlock']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Home']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    for (int i = 0; i < 4; i++) {
                        browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                    }
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Sys.");
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
                    browserUtil.entersTextWithTabIn(hp_searchDescription_text, testDataAsMap.get("sanNumber").get(0));
                    browserUtil.clicksWebElement(hp_Search_Img);
                    browserUtil.waitUntilPleaseWaitDisappear();
                }
            } catch (Exception e) {
            }
        }




        public void deletesAnyTransactionInProgress() {
            if (browserUtil.getsIndexOfCompleteOrPartialMatchingVisibleTextFromDropDown(hp_policyAction2_DrpDwn, "DELETE") > 0) {

                browserUtil.CMPDropDown("DELETE", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);

                try {
                    while (browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed()) {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                        browserUtil.switchToWindowWithHandle(parent);
                    }
                } catch (Exception e) {
                }

                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }




        }*/





    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public CertificateOnlyMethods theUser_() {
        return this.pageMethods;
    }

}