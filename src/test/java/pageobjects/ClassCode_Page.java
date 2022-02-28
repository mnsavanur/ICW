package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static pageobjects.States_Page.IStates.sp_addState_Btn;
import static pageobjects.States_Page.IStates.sp_state_DrpDwn;

/**
 * Created by Sapna Gour on 2/1/2018.
 */
public class ClassCode_Page {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private ClassCodeMethods pageMethods;
    private String parent;

    public ClassCode_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new ClassCodeMethods();
    }
    public ClassCode_Page(){}

    public interface IClassCode {
        String pageName = "Class Code";

        List gl_addLocation_button = Arrays.asList(By.xpath("//button[contains(.,'Add Location')]"), pageName, "Add Location");
        List gl_locationNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Location No:')]/..//following-sibling::div[1]//input"), pageName, "Location No");
        List gl_buildingNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Building No:')]/..//following-sibling::div[1]//input"), pageName, "Building No");
        List gl_streetAddress_textBox = Arrays.asList(By.xpath("//label[contains(.,'Street Address:')]/..//following-sibling::div[1]//input"), pageName, "Street Address");
        List gl_city_textBox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), pageName, "City");
        List gl_country_textBox = Arrays.asList(By.id("CoLocBldgAddSelectHTML_CoLocation_CountyNm_FLD"), pageName, "Country");
        List gl_zipCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), pageName, "Zip Code");
        List gl_saveAndClose_button = Arrays.asList(By.xpath("//button[contains(.,'Save and Close')]"), pageName, "Save and Close");
        List gl_classCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Class Code:')]/..//following-sibling::div[1]//input"), pageName, "Class Code");
        List gl_exposure_textBox = Arrays.asList(By.xpath("//label[contains(.,'Exposure:')]/..//following-sibling::div[1]//input"), pageName, "Exposure");
        List gl_addAnother_button = Arrays.asList(By.xpath("(//button[text()=' Add Another'])[1]"), pageName, "Add Another");
        List gl_selDedApply_dropdwon = Arrays.asList(By.xpath("//label[contains(.,'Ded Apply:')]/..//following-sibling::div[1]//input"), pageName, "Add Another");
        List gl_compositeGrp_dropdwon = Arrays.asList(By.xpath("//label[contains(.,'Composite Group:')]/..//following-sibling::div[1]//input"), pageName, "Composite Group");
        List gl_ClassCode_OptionalCoverages_tab = Arrays.asList(By.xpath("//li[contains(.,'Optional Coverages')]"), "GL ClassCode Page", "Opt Coverages");
        List gl_ClassCode_OptCoverages_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlLocCovgEdit_cboAddCoverage_comboboxinput']"), "GL ClassCode Page", "Opt Coverages ");
        List gl_ClassCode_addCoverage_Button = Arrays.asList(By.xpath("//button[contains(.,'Add Coverage')]"), "GL Class Code Page", "Opt Coverages Button");
        List gl_ClassCode_addInterest_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlLocationAddlInterestHTML_GlLocInput_AITypeCd_LST_comboboxinput']"), "GL ClassCode Page", "Add Interest");
        List gl_ClassCode_typrOfCharges_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlLocationAddlInterestHTML_GlLocInput_AIChargeTypeCd_LST_comboboxinput']"), "GL ClassCode Page", "Types Of Charges");
        List gl_chargesAmount_textBox = Arrays.asList(By.xpath("//label[contains(.,'Charge Amount:')]/..//following-sibling::div[1]//input"), pageName, "Exposure");
        List gl_click_ClassCode1 = Arrays.asList(By.xpath("//a[@id='dgLocationList_StLocBldg_0']"), "GL Class Code  Page", "Class Code");


        List qccp_state_DrpDwn = Arrays.asList(By.id("WkQuickClassCodesEdit_ddAddState_comboboxinput"), pageName, "Workers Comp State");
        List qccp_classCode_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_ClassCode"), pageName, "Class");
        List qccp_descId_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_DescID"), pageName, "Desc Id");
        List qccp_addClassCode_Btn = Arrays.asList(By.id("WkQuickClassCodesEdit_AddClassCd"), pageName, "Add Class Code");
        List qccp_rateOvrd_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_RateOvrdAmt"), pageName, "Rate Override");
        List qccp_minOvrd_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_MinOvrdAmt"), pageName, "Min Override");
        List qccp_fullTimeEmployee_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_WkClassCodeTab_WkClassCodeDetailHTML__ctl100_WkClassCodeDetailHTML_ActiveControl_WkClassCode_EmployeeCt"), pageName, "Full Time Employee");
        List qccp_partTimeEmployee_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_WkClassCodeTab_WkClassCodeDetailHTML__ctl100_WkClassCodeDetailHTML_ActiveControl_WkClassCode_PTEmployeeCt"), pageName, "Part Time Employee");
        List qccp_coverages_Btn = Arrays.asList(By.id("WkClassCodeDetailHTML_DynamicStore_ButtonClassCodeCoverages"), pageName, "Coverages");
        List qccp_addCoverage_Btn = Arrays.asList(By.id("ok"), pageName, "Add Coverages Button");
        List qccp_save_Btn = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), pageName, "Save Button");
        List qccp_WaiversTab_Label = Arrays.asList(By.xpath("//span[@title='Waivers']"), pageName, "WaiversTab_Label");
        List qccp_waiversAddNew_Btn = Arrays.asList(By.id("WkClassCodeWaiversEdit_dgWkClassCodeWaiverInfoList_Row_AddNew"), pageName, "Waivers add New Button");
        List qccp_waiverNo_Txt = Arrays.asList(By.id("WkClassCodeWaiversDetailHTML_WkClassCodeWaiverInfo_WaiverId_FLD"), pageName, "Waiver Number");
        List qccp_waiverExposure_Txt = Arrays.asList(By.id("WkClassCodeWaiversDetailHTML_WkClassCodeWaiverInfo_AnnualExpAmt_FLD"), pageName, "Waiver Exposure");
        List qccp_jobNo_Txt = Arrays.asList(By.id("WkClassCodeWaiversDetailHTML_WkClassCodeWaiverInfo_WaiverJobNo_FLD"), pageName, "Job Number");
        List qccp_jobDesc_Txt = Arrays.asList(By.id("WkClassCodeWaiversDetailHTML_WkClassCodeWaiverInfo_WaiverJobDescTx_FLD"), pageName, "Job Description");
        List qccp_exposure_Txt = Arrays.asList(By.id("WkQuickClassCodesEdit_ExposureAmt"), pageName, "Exposure");
        List qccp_ExposureForAudit_TextBox = Arrays.asList(By.xpath("//input[contains(@id,'_WkClassCode_PremBasisAmt')]"), pageName, "Waiver Exposure For Audit");
        List qccp_minPremOverrideForAudit_Txt = Arrays.asList(By.xpath("//input[contains(@id,'_WkClassCode_MinimumPremOvrdAmt')]"), pageName, "Rate Override For Audit");
        List qccp_rateOverrideForAudit_Txt = Arrays.asList(By.xpath("//input[contains(@id,'_WkClassCode_BaseOvrdRate')]"), pageName, "Minimum Premium Override For Audit");
        List qccp_fullTimeEmployeeForAudit_Txt = Arrays.asList(By.xpath("//input[contains(@id,'_WkClassCode_EmployeeCt')]"), pageName, "No of Full Time Employee For Audit");
        List qccp_partTimeEmployeeForAudit_Txt = Arrays.asList(By.xpath("//input[contains(@id,'_WkClassCode_PTEmployeeCt')]"), pageName, "No of Part Time Employee For Audit");
        // List qccp_ClassCodeCoverageAdd_Btn = Arrays.asList(By.xpath("//input[contains(@id,'_ButtonClassCodeCoverages')]"), pageName, "Add Class Code Coverage");
        List qccp_ClassCodeCoverageAdd_Btn = Arrays.asList(By.xpath("//input[contains(@id,'OK')]"), pageName, "Add Class Code Coverage");

        List qccp_WorkersCompClassCodes_Label = Arrays.asList(By.id("WkClassCodeSplitsEdit_lbl2"), pageName, "'WorkersCompClassCodes_Label'");
        List qccp_ValidationError_Label = Arrays.asList(By.xpath("//div[@id='statusdiv']//td[contains(normalize-space(), 'Validation Error')]"), pageName, "'ValidationError_Label'");
        List qccp_ClassCode_Table = Arrays.asList(By.xpath("//div[contains(@id, 'ClassCodesList')]/table[1]"), pageName, "'ClassCode_Table'");
    }


    public class ClassCodeMethods implements IClassCode {

        public void enterClassCodes(Map<String, List<String>> map) throws InterruptedException {
           // if (map.get("ClassCode_Page_Flag").get(0).equalsIgnoreCase("Yes"))
                if (true){
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("General Liability");
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CLASS CODE");
                browserUtil.waitUntilPleaseWaitDisappear();
                this.addLocations(map);
                int size = map.get("LocationClassCd").size();
                    for (int i = 0; i < size; i++) {
                        if (!map.get("LocationClassCd").get(i).equalsIgnoreCase("$$NA$$")) {
                            try{

                                browserUtil.driver.findElement(By.xpath("(//div//td//button[normalize-space()='Add Another'])["+i+"]")).click();
                            }
                            catch (Exception e)
                            {

                            }
                            Thread.sleep(4000);
                            browserUtil.CMPDropDown(map.get("Ded_Apply").get(i),gl_selDedApply_dropdwon);
                            Thread.sleep(4000);
                            //browserUtil.waitsUntilWebElementIsClickable(gl_classCode_textBox);
                            browserUtil.entersTextWithTabIn(gl_classCode_textBox, map.get("LocationClassCd").get(i));
                            browserUtil.waitUntilPleaseWaitDisappear();
                            browserUtil.entersTextWithTabIn(gl_exposure_textBox, map.get("Exposure").get(i));
                            browserUtil.waitUntilPleaseWaitDisappear();
                            Thread.sleep(3000);
                            browserUtil.CMPDropDown(map.get("Composite_Group").get(i),gl_compositeGrp_dropdwon);
                            baseUtil.clicksOnSave();
                        }
                        }


                }
        }


            public void addLocations(Map<String, List<String>> map)
        {
            parent = browserUtil.getWindowHandle();
            browserUtil.clicksWebElement(gl_addLocation_button);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.switchToChildWindow();
            browserUtil.entersTextWithTabIn(gl_locationNo_textBox, map.get("LocationNo").get(0));
            browserUtil.entersTextWithTabIn(gl_buildingNo_textBox, map.get("BuildingNo").get(0));
            browserUtil.entersTextWithTabIn(gl_streetAddress_textBox, map.get("StreetAddr").get(0));
            browserUtil.entersTextWithTabIn(gl_city_textBox, map.get("City").get(0));
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.entersTextWithTabIn(gl_country_textBox, map.get("Country").get(0));
            browserUtil.entersTextWithTabIn(gl_zipCode_textBox, map.get("ZipCode").get(0));
            browserUtil.clicksWebElement(gl_saveAndClose_button);
            browserUtil.switchToWindowWithHandle(parent);
        }

        public void addLocations2AndClassCode2(Map<String, List<String>> map) throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CLASS CODE");
            browserUtil.waitUntilPleaseWaitDisappear();
            parent = browserUtil.getWindowHandle();
            browserUtil.clicksWebElement(gl_addLocation_button);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.switchToChildWindow();
            browserUtil.entersTextWithTabIn(gl_locationNo_textBox, map.get("LocationNo2").get(0));
            browserUtil.entersTextWithTabIn(gl_buildingNo_textBox, map.get("BuildingNo2").get(0));
            browserUtil.entersTextWithTabIn(gl_streetAddress_textBox, map.get("StreetAddr2").get(0));
            browserUtil.entersTextWithTabIn(gl_city_textBox, map.get("City").get(0));
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.entersTextWithTabIn(gl_country_textBox, map.get("Country").get(0));
            browserUtil.entersTextWithTabIn(gl_zipCode_textBox, map.get("ZipCode").get(0));
            browserUtil.clicksWebElement(gl_saveAndClose_button);
            browserUtil.switchToWindowWithHandle(parent);

            int size = map.get("LocationClassCd2").size();
            for (int i = 0; i < size; i++) {
                if (!map.get("LocationClassCd2").get(i).equalsIgnoreCase("$$NA$$")) {
                    try{

                        browserUtil.driver.findElement(By.xpath("(//div//td//button[normalize-space()='Add Another'])["+i+"]")).click();
                    }
                    catch (Exception e)
                    {

                    }
                    browserUtil.CMPDropDown(map.get("Ded_Apply2").get(i),gl_selDedApply_dropdwon);
                    browserUtil.waitsUntilWebElementIsClickable(gl_classCode_textBox);
                    browserUtil.entersTextWithTabIn(gl_classCode_textBox, map.get("LocationClassCd2").get(i));
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_exposure_textBox, map.get("Exposure2").get(i));
                    browserUtil.waitUntilPleaseWaitDisappear();

                    if (map.get("GL_ClassCode_OptCovg_Flag").get(0).equalsIgnoreCase("Yes"))
                    {
                        browserUtil.clicksWebElement(gl_ClassCode_OptionalCoverages_tab);
                        //browserUtil.waitUntilPleaseWaitDisappear();
                        //browserUtil.clicksWebElement(gl_ClassCode_OptCoverages_DrpDwn);
                        //Thread.sleep(2000);
                        browserUtil.selectsValueFromDropDown2(map.get("GL_ClassCode_OptCoverages").get(0),gl_ClassCode_OptCoverages_DrpDwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_ClassCode_addCoverage_Button);
                       //browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.selectsValueFromDropDown2(map.get("GL_ClassCode_AddInterest").get(0),gl_ClassCode_addInterest_DrpDwn);
                        browserUtil.selectsValueFromDropDown2(map.get("GL_ClassCode_TypeOfCharges").get(0),gl_ClassCode_typrOfCharges_DrpDwn);
                        browserUtil.entersTextWithTabIn(gl_chargesAmount_textBox, map.get("ChargesOfAmount").get(i));
                        //browserUtil.waitUntilPleaseWaitDisappear();
                        //browserUtil.clicksWebElement(gl_StatesaddCoverage_Button);
                       // browserUtil.waitUntilPleaseWaitDisappear();
                    }

                    baseUtil.clicksOnSave();


                }
            }



        }

        public void increaseExposure(Map<String, List<String>> map) throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("General Liability");
            browserUtil.waitUntilPleaseWaitDisappear();
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CLASS CODE");
            browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.clicksWebElement(gl_click_ClassCode1);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_exposure_textBox, map.get("Exposure3").get(0));
                    browserUtil.waitUntilPleaseWaitDisappear();

                    baseUtil.clicksOnSave();
                }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public ClassCodeMethods theUser_() {
        return this.pageMethods;
    }

}