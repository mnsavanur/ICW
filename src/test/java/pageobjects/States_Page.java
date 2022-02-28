package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Sapna Gour on 2/1/2018.
 */
public class States_Page {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private StatesMethods pageMethods;

    public States_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new StatesMethods();
    }

    public interface IStates {

        List sp_retroEarnedPremium_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_WkStateRetroInput_RetroEarnedPremAmt"), "States Page", "Retro Earned Premium");
        List sp_prevBilledPremium_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_WkStateRetroInput_PrevBilledPremAmt"), "States Page", "Prev Billed Premium");
        List sp_retroAdjustment_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_WkStateRetroInput_RetroAdjustmentAmt"), "States Page", "Retro Adjustment:");
        List sp_caAdminRevolvingFundAccess_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1266CaAdminRevolvingFundAssess_S1266CaAdminRevolvingFundAssess"), "States Page", "CA ADMIN REVOLVING FUND ASSESS");
        List sp_caFraudAssessment_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1267CaFraudAssessment_S1267CaFraudAssessment"), "States Page", "CA FRAUD ASSESSMENT");
        List sp_cigaSurcharge_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1265CigaSurcharge_S1265CigaSurcharge"), "States Page", "CIGA SURCHARGE");
        List sp_caUninsEmplBenefitsAssess_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1268CaUninsEmplBenefitsAssess_S1268CaUninsEmplBenefitsAssess"), "States Page", "CA UNINS EMPL BENEFITS ASSESS");
        List sp_caSubsInjBenefitsAssess_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1269CaSubsInjBenefitsAssess_S1269CaSubsInjBenefitsAssess"), "States Page", "CA SUBS INJ BENEFITS ASSESS");
        List sp_caOccSafetyHealthFund_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1355CaOccSafetyHealthFund_S1355CaOccSafetyHealthFund"), "States Page", "CA OCC SAFETY & HEALTH FUND");
        List sp_caLecfAssessment_Txt = Arrays.asList(By.id("WkStatesEdit_WkRetroTabIW_WkStateRetroAdjustmentIWHTML__ctl100_WkStateRetroAdjustmentIWHTML_ActiveControl_DynamicStoreS1381CaLecfAssessment_S1381CaLecfAssessment"), "States Page", "CA LECF ASSESSMENT");
        List sp_state_DrpDwn = Arrays.asList(By.id("WkStatesEdit_ddAddState_comboboxinput"), "Workers Comp States Page", "State");
        List sp_addState_Btn = Arrays.asList(By.id("WkStatesEdit_dgStateList_Row_AddNew"), "Workers Comp States Page", "Add State");
        List sp_StateInfoTab_Label = Arrays.asList(By.xpath("//span[@title='1. State Info']"), "Workers Comp States Page", "StateInfoTab_Label");
        List sp_stateInfoUIAN_Txt = Arrays.asList(By.xpath("//span[@id='WkStateHTML_WkStateDetail_UainCd']/input"), "Workers Comp States Page", "State Info UIAN");
        List sp_stateInfoRateMode_DrpDwn = Arrays.asList(By.id("WkStateHTML_WkStateDetail_RateModeCd_LST_comboboxinput"), "Workers Comp States Page", "State Info Rate Mode");
        List sp_tierCode_Txt = Arrays.asList(By.id("WkStateHTML_WkStateDetail_TierLevelCd_LST_comboboxinput"), "Workers Comp States Page", "State Info Tier Code");
        List sp_tinCode_Txt = Arrays.asList(By.id("WkStatesEdit_WkStateTab_WkStateHTML__ctl100_WkStateHTML_ActiveControl_WkStateDetail_UainCd"), "Workers Comp States Page", "State Info TIN Code");
        List sp_stateMPNCredit_Txt = Arrays.asList(By.id("WkStateHTML_WkStateDetail_MPNFct_FLD"), "Workers Comp States Page", "State MPN Credit");
        List sp_stateType_DrpDwn = Arrays.asList(By.id("WkStateHTML_WkStateDetail_MPNTypeCd_LST_comboboxinput"), "Workers Comp States Page", "State Type");
        List sp_stateProviderName_DrpDwn = Arrays.asList(By.id("WkStateHTML_WkStateDetail_MPNProviderCd_LST_comboboxinput"), "Workers Comp States Page", "State Provider Name");
        List sp_stateOtherDesc_Txt = Arrays.asList(By.id("WkStateHTML_WkStateDetail_OtherDesc_FLD"), "Workers Comp States Page", "State Other Description");
        List sp_save_Btn = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), "Workers Comp States Page", "Save Button");
        List sp_RatingPlansCoveragesTab_Label = Arrays.asList(By.xpath("//span[@title='Rating Plans/Coverages']"), "Workers Comp States Page", "RatingPlansCoveragesTab_Label");
        List sp_foreignTerrorism_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Terrorism:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Foreign Terrorism");
        List sp_blanketWaiverFlatCharge_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Blanket Waiver (Flat Charge):')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Blanket Waiver Flat Charge");
        List sp_blanketWaiver_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Blanket Waiver:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Blanket Waiver");
        List sp_blanketWaiver_DrpDwn = Arrays.asList(By.xpath("//div//label[normalize-space()='Blanket Waiver:']/parent::div//following-sibling::div//span/input"), "Workers Comp States Page", "Blanket Waiver (Drp Dwn)");
        List sp_voluntaryCompensation_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Voluntary Compensation:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Voluntary Compensation");
        List sp_USLHFlat_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'USL&H:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "USLH Flag");
        List sp_largeDeductible1_Txt = Arrays.asList(By.xpath("//label[text()='Large Deductible:']//parent::div//following-sibling::div/input"), "Workers Comp States Page", "Large Deductible1");
        List sp_largeDeductible2_DrpDwn = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'LARGE DEDUCTIBLE')]/following-sibling::td[5]//span/select"), "Workers Comp States Page", "Large Deductible2");
        List sp_smallDeductible1_DrpDwn = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Small Deductible:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Large Deductible2");
        List sp_smallDeductible2_DrpDwn = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'SMALL DEDUCTIBLE')]/following-sibling::td[5]//span/select"), "Workers Comp States Page", "Large Deductible2");
        List sp_smallDeductible3_DrpDwn = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'SMALL DEDUCTIBLE')]/following-sibling::td[7]//span/select"), "Workers Comp States Page", "Large Deductible2");
        List sp_safetyProgram_DrpDwn = Arrays.asList(By.xpath("//div/label[contains(normalize-space(), 'Safety Program:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Safety Program");
        List sp_drugFreeProgram_DrpDwn = Arrays.asList(By.xpath("//div/label[contains(normalize-space(), 'Drug Free Program:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Drug Free Program");
        List sp_contractorRatingPlan_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(), 'Contractors Rating Plan:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Contractors Rating Plan");  List sp_tierRatingSurcharges1_DrpDwn = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'TIER RATING SURCHARGE')]/following-sibling::td[3]//span/select"), "Workers Comp States Page", "Tier Rating Surcharges1");
        List sp_tierRatingSurcharges2_Txt = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'TIER RATING SURCHARGE')]/following-sibling::td[5]//input[1]"), "Workers Comp States Page", "Tier Rating Surcharges2");
        List sp_facultativeReinsurance_Txt = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Facultative Reinsurance:')]//parent::div//following-sibling::div//input"), "Workers Comp States Page", "Facultative ReInsurance");
        List sp_rateModifications_Txt = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'RATE MODIFICATION')]/following-sibling::td[3]//input[1]"), "Workers Comp States Page", "Rate Modification");
        List sp_catastrophe_Txt = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'CATASTROPHE')]/following-sibling::td[3]//input[1]"), "Workers Comp States Page", "Catastrophe");
        List sp_meritRating_DrpDwn = Arrays.asList(By.xpath("//div/label[contains(normalize-space(), 'Merit Rating Plan:')]//parent::div//following-sibling::div/span//input"), "Workers Comp States Page", "Merit rating");
        List sp_OverridesTab_Label = Arrays.asList(By.xpath("//span[@title='Overrides']"), "Workers Comp States Page", "OverridesTab_Label");
        List sp_admiraltyUpperLimit_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_AdmirPolLimitOvrdAmt_FLD"), "Workers Comp States Page", "Admiralty Upper Limit");
        List sp_admiraltyLowerLimit_DrpDwn = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_AdmirAccLimitOvrdAmt_LST_comboboxinput"), "Workers Comp States Page", "Admiralty Lower Limit");
        List sp_FELAUpperLimit_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_FelaPolLimitOvrdAmt_FLD"), "Workers Comp States Page", "FELA Upper Limit");
        List sp_FELALowerLimit_DrpDwn = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_FelaAccLimitOvrdAmt_LST_comboboxinput"), "Workers Comp States Page", "FELA Lower Limit");
        List sp_anniversaryRateDateState_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkState_AnnivOvrdRateDt_FLD"), "Workers Comp States Page", "Anniversary Rate Date State");
        List sp_premDiscPercent_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_StPremDisctOvrdFctPct_FLD"), "Workers Comp States Page", "Premium Discount Percent");
        List sp_expMod_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ExpModFactorPct_FLD"), "Workers Comp States Page", "Exp Mod");
        List sp_modeType_DrpDwn = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ExpModCd_LST_comboboxinput"), "Workers Comp States Page", "Mod Type");
        List sp_riskId_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_RiskIdNo_FLD"), "Workers Comp States Page", "Risk Id");
        List sp_modDate_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ModDt_FLD"), "Workers Comp States Page", "Mod Date");
        List sp_USLHMinPremOvrd_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_USLHMinPremOvrdAmt_FLD"), "Workers Comp States Page", "USLH Min Prem Ovrd");
        //List sp_stateInfoReasonCodeAdded_DrpDwn = Arrays.asList(By.id("g_CB_WkStateDetail_WkStateAddCd_t"), "Workers Comp States Page", "State Info reason Code added");
        List sp_stateInfoReasonCodeAdded_DrpDwn = Arrays.asList(By.id("WkStateHTML_WkStateDetail_WkStateAddCd_LST_comboboxinput"), "Workers Comp States Page", "State Info reason Code added");
        List sp_selectState_Link = Arrays.asList(By.xpath("g_CB_WkStateDetail_WkStateAddCd_t"), "Workers Comp States Page", "Select Added State");
        List sp_auditNonComplianceCharge_DrpDwn = Arrays.asList(By.xpath("//td[contains(normalize-space(), 'AUDIT NONCOMPLIANCE CHARGE')]/following-sibling::td[3]//span/select"), "Workers Comp States Page", "Audit Non Compliance charge");
        List sp_auditAnniversaryRateDate_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkState_AnnivOvrdRateDt_FLD"), "State Audit Transaction Page", "Audit Anniversary Rate date");
        List sp_auditPremDiscPercent_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_StPremDisctOvrdFctPct_FLD"), "State Audit Transaction Page", "Premium Discount");
        List sp_auditExpMod_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ExpModFactorPct_FLD"), "State Audit Transaction Page", "Exp Mod");
        List sp_auditModType_DrpDwn = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ExpModCd_LST_comboboxinput"), "State Audit Transaction Page", "Mod Type");
        List sp_auditRiskId_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_RiskIdNo_FLD"), "State Audit Transaction Page", "Risk Id");
        List sp_auditModDate_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkModInfo_ModDt_FLD"), "State Audit Transaction Page", "Mod Date");
        List sp_stateMPNCreditForAUDM_Txt = Arrays.asList(By.id("WkStateSplitsEdit_WkStateTab_WkStateHTML__ctl100_WkStateHTML_ActiveControl_WkStateDetail_MPNFct"), "State Audit Transaction Page", "Audit Credit");
        List sp_stateTypeForAUDM_DrpDwn = Arrays.asList(By.id("WkStateSplitsEdit_WkStateTab_WkStateHTML__ctl100_WkStateHTML_ActiveControl_WkStateDetail_MPNTypeCd"), "State Audit Transaction Page", "State Type");
        List sp_stateProviderNameForAUDM_DrpDwn = Arrays.asList(By.id("WkStateSplitsEdit_WkStateTab_WkStateHTML__ctl100_WkStateHTML_ActiveControl_WkStateDetail_MPNProviderCd"), "State Audit Transaction Page", "Provider name");
        List sp_stateOtherDescForAUDM_Txt = Arrays.asList(By.id("WkStateSplitsEdit_WkStateTab_WkStateHTML__ctl100_WkStateHTML_ActiveControl_WkStateDetail_OtherDesc"), "State Audit Transaction Page", "Other description");
        List sp_USLHMinPremiumOverride_Txt = Arrays.asList(By.id("WkStOverridesHTML_WkStateDetail_USLHMinPremOvrdAmt_FLD"), "State Audit Transaction Page", "USLH Minimum Premium Override");
        List sp_State_Table = Arrays.asList(By.xpath("//div[contains(@id, 'StateList')]/table[1]"), "Workers Comp States", "State_Table");
        List gl_States_DrpDwn = Arrays.asList(By.xpath("//a[@id='dgStateList_StateNm_0']"), "GL States  Page", "States");
        List gl_StatesOptCoverages_tab = Arrays.asList(By.xpath("//li[contains(.,'Optional Coverages')]"), "GL States Page", "Opt Coverages");
        List gl_StatesOptCoverages_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlStateCovgEdit_cboAddCoverage_comboboxinput']"), "GL States Page", "Opt Coverages ");
        List gl_StatesaddCoverage_Button = Arrays.asList(By.xpath("//button[contains(.,'Add Coverage')]"), "GL States Page", "Opt Coverages Button");
        List gl_StatesaggregateLimit_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlStLiquorLiabHTML_GlStCovgInput_LqrAggLimit_LST_comboboxinput']"), "GL States Page", "Opt Coverages Dropdwon");

    }

    public class StatesMethods implements IStates {
        public void selectWorkersCompState(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("States_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("WORKERS COMP");
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("STATES");
                browserUtil.waitUntilPleaseWaitDisappear();
                if (map.get("Transaction_Type").get(0).equalsIgnoreCase("NBIS") || map.get("Transaction_Type").get(0).equalsIgnoreCase("RCIS")) {
                    int size = map.get("Select_State").size();
                    for (int i = 0; i < size; i++) {
                        if (!map.get("Select_State").get(i).equalsIgnoreCase("$$NA$$")) {
                            //browserUtil.switchToDefaultContent();
                            //browserUtil.switchToFrame("InsDmain");
                            //browserUtil.switchToFrame("IFPolicyState");
                            //browserUtil.waitsUntilWebElementIsClickable(sp_addState_Btn);
                            browserUtil.waitsForPageToBeLoaded();
                            browserUtil.waitsUntilWebElementIsClickable(sp_state_DrpDwn);
                            //Thread.sleep(3000);
                            browserUtil.selectsValueFromDropDown2(map.get("Select_State").get(i), sp_state_DrpDwn);
                            browserUtil.waitUntilPleaseWaitDisappear();
                            browserUtil.clicksWebElement(sp_addState_Btn);
                            browserUtil.waitUntilPleaseWaitDisappear();
                            enterStateInfoDetail(map, i);
                            enterRatingsPlanCoveragesDetail(map, i);
                            enterOverridesDetail(map, i);
                            browserUtil.clicksWebElement(sp_save_Btn);
                            browserUtil.waitUntilPleaseWaitDisappear();
                            //browserUtil.switchToDefaultContent();
                            //browserUtil.switchToFrame("InsDmain");
                            //browserUtil.switchToFrame("IFPolicyState");
                            // browserUtil.highlightsWebElement((By)sp_State_Table.get(0));
                        }
                    }
                } else if (map.get("Transaction_Type").get(0).equalsIgnoreCase("PCNM") || map.get("Transaction_Type").get(0).equalsIgnoreCase("REIS")) {
                    for (int j = 0; j < map.get("Performing_Action_State").size(); j++) {
                        String State_Action = map.get("Performing_Action_State").get(j);
                        System.out.println(State_Action);
                        if (!State_Action.equalsIgnoreCase("$$NA$$")) {
                            //browserUtil.switchToDefaultContent();
                            //browserUtil.switchToFrame("InsDmain");
                            // browserUtil.switchToFrame("IFPolicyState");
                            //browserUtil.switchToFrame("IFPolicyState");
                            switch (State_Action) {
                                case "ADD":
                                    browserUtil.waitsUntilWebElementIsVisible(sp_addState_Btn);
                                    browserUtil.selectsValueFromDropDown2(map.get("Select_State").get(j), sp_state_DrpDwn);
                                    browserUtil.clicksWebElement(sp_addState_Btn);
                                    browserUtil.waitUntilPleaseWaitDisappear();
                                    // browserUtil.highlightsWebElement((By)sp_State_Table.get(0));
                                    enterStateInfoDetail(map, j);
                                    enterRatingsPlanCoveragesDetail(map, j);
                                    enterOverridesDetail(map, j);
                                    //browserUtil.switchToDefaultContent();
                                    //browserUtil.switchToFrame("InsDmain");
                                    //browserUtil.switchToFrame("IFPolicyState");
                                    // browserUtil.highlightsWebElement((By)sp_State_Table.get(0));
                                    break;
                                case "EDIT":
                                    List sp_State_Link;
                                    sp_State_Link = Arrays.asList(By.xpath("//table//tr//a[normalize-space()='" + map.get("Select_State").get(j).trim() + "']"), "Workers Comp States Page", "'State_Link' (" + map.get("Select_State").get(j).trim() + ")");
                                    // browserUtil.highlightsWebElement((By)sp_State_Table.get(0));
                                    browserUtil.clicksWebElement(sp_State_Link);
                                    browserUtil.waitUntilPleaseWaitDisappear();
                                    /*
                                    By stateLink = By.xpath("//u[contains(text(),'" + map.get("Select_State").get(j) + "')]/parent::a[contains(@id,'RowSelectLink')]");
                                    WebElement element = browserUtil.findsWebElementWithLocatorWithinDefaultTimeout(stateLink);
                                    element.click();
                                    */
                                    enterStateInfoDetail(map, j);
                                    enterRatingsPlanCoveragesDetail(map, j);
                                    enterOverridesDetail(map, j);
                                    break;
                                case "DELETE":
                                    List sp_DeleteState_Link;
                                    sp_DeleteState_Link = Arrays.asList(By.xpath("//table//tr[(.//a[normalize-space()='" + map.get("Select_State").get(j).trim() + "'])]//i[@title='Delete this item']"), "Workers Comp States Page", "'DeleteState_Link' (" + map.get("Select_State").get(j).trim() + ")");
                                    // browserUtil.highlightsWebElement((By)sp_State_Table.get(0));
                                    browserUtil.clicksWebElement(sp_DeleteState_Link);
                                    /*
                                    By deleteRow = By.xpath("//td[contains(text(),'" + map.get("Select_State").get(j) + "')]/following-sibling::td/a[contains(@id,'RowDeleteLink')]/img");
                                    browserUtil.waitsUntilWebElementIsClickable(Arrays.asList(deleteRow, "State Page", "Delete Button"));
                                    WebElement deleteElement = browserUtil.findsWebElementWithLocatorWithinDefaultTimeout(deleteRow);
                                    deleteElement.click();
                                    */
                                    //browserUtil.acceptsAlert();
                                    String parent = browserUtil.getWindowHandle();
                                    browserUtil.switchToChildWindow();
                                    browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                                    browserUtil.switchToWindowWithHandle(parent);
                                    //browserUtil.switchToDefaultContent();
                                    //browserUtil.switchToFrame("InsDmain");
                                    System.out.println("******************Check UI Blocker - START******************");
                                    browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                                    System.out.println("******************Check UI Blocker - End******************");
                                    break;
                            }
                        }
                    }
                }
            }
                /*else {
                    browserUtil.switchToDefaultContent();
                    browserUtil.switchToFrame("InsDmain");
                    browserUtil.switchToFrame("IFPolicyState");
                    String text = map.get("Select_State2").get(0);
                    browserUtil.driver.findElement(By.xpath("//tbody[@class='ig_Item igg_Item Grid_Row_Minor_Standard']//tr//td[normalize-space()= '" + text + "']/preceding-sibling::td/a")).click();
                }*/
        }


        public void enterStateInfoDetail(Map<String, List<String>> map, int i) throws InterruptedException {
            // Thread.sleep(2000);
            if (map.get("StateInfo_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                //browserUtil.clicksWebElement(sp_stateInfoRateMode_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.selectsValueFromDropDown2(map.get("StatesInfo_Rate_Mode").get(i), sp_stateInfoRateMode_DrpDwn);
                if (!map.get("StatesInfo_Rate_Mode").get(i).equalsIgnoreCase("$$NA$$"))
                    browserUtil.sendsTabKeyOnWebElement(sp_stateInfoRateMode_DrpDwn);
                browserUtil.entersTextWithTabIn(sp_stateInfoUIAN_Txt, map.get("StatesInfo_UIAN").get(i));
                browserUtil.sendsTabKeyOnWebElement(sp_stateInfoUIAN_Txt);
                if (!map.get("StatesInfo_Tier_Code").get(i).equalsIgnoreCase("$$NA$$"))
                    browserUtil.clicksWebElement(sp_tierCode_Txt);
                browserUtil.selectsValueFromDropDown2(map.get("StatesInfo_Tier_Code").get(i), sp_tierCode_Txt);
                //browserUtil.sendsTabKeyOnWebElement(sp_tierCode_Txt);
                browserUtil.clicksWebElement(sp_stateInfoReasonCodeAdded_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("StatesInfoReasonStateAdded").get(i), sp_stateInfoReasonCodeAdded_DrpDwn);
                //Do changes after discussion with functional team
                //browserUtil.entersTextWithTabIn(sp_tinCode_Txt, map.get("StatesInfo_TIN_Code").get(i));
                browserUtil.entersTextWithTabIn(sp_stateMPNCredit_Txt, map.get("StatesInfo_MPN_Credit").get(i));
                browserUtil.selectsValueFromDropDown2(map.get("StatesInfo_Type").get(i), sp_stateType_DrpDwn);
                if (!map.get("StatesInfo_Type").get(i).equalsIgnoreCase("$$NA$$"))
                    browserUtil.sendsTabKeyOnWebElement(sp_stateType_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("StatesInfo_Provider_Name").get(i), sp_stateProviderName_DrpDwn);
                if (!map.get("StatesInfo_Provider_Name").get(i).equalsIgnoreCase("$$NA$$"))
                    browserUtil.sendsTabKeyOnWebElement(sp_stateProviderName_DrpDwn);
                browserUtil.entersTextWithTabIn(sp_stateOtherDesc_Txt, map.get("StatesInfo_Other_Description").get(i));
                browserUtil.clicksWebElement(sp_save_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.waitsUntilWebElementIsVisible(sp_RatingPlansCoveragesTab_Label);
                //WebDriverWait waitForWebDriver = new WebDriverWait(browserUtil.driver, 240);
                //waitForWebDriver.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Rating Plans/Coverages']")));

            }
        }

        public void enterAuditStateInfoDetails(Map<String, List<String>> map, int i) throws InterruptedException {
            if (map.get("AUDM_StateInfo_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.entersTextWithTabIn(sp_stateMPNCreditForAUDM_Txt, map.get("AUDM_StatesInfo_MPN_Credit").get(i));
                if (!map.get("AUDM_StatesInfo_Type").get(i).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_stateTypeForAUDM_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("AUDM_StatesInfo_Type").get(i), sp_stateTypeForAUDM_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_stateTypeForAUDM_DrpDwn);
                }
                if (!map.get("AUDM_StatesInfo_Provider_Name").get(i).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_stateProviderNameForAUDM_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("AUDM_StatesInfo_Provider_Name").get(i), sp_stateProviderNameForAUDM_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_stateProviderNameForAUDM_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(sp_stateOtherDescForAUDM_Txt, map.get("AUDM_StatesInfo_Other_Description").get(i));
                browserUtil.clicksWebElement(sp_save_Btn);
                browserUtil.waitsUntilWebElementIsVisible(sp_RatingPlansCoveragesTab_Label);
            }
        }

        public void enterRatingsPlanCoveragesDetail(Map<String, List<String>> map, int j) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            if (map.get("RatingPlanCoverages_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElementUsingJavaScriptExecutor(sp_RatingPlansCoveragesTab_Label);
                browserUtil.waitUntilPleaseWaitDisappear();
                if (!map.get("MERIT_RATING").get(j).equalsIgnoreCase("$$NA$$")) {
                    if (!map.get("MERIT_RATING").get(j).equalsIgnoreCase("RESET")) {
                        browserUtil.clicksWebElement(sp_meritRating_DrpDwn);
                        browserUtil.selectsValueFromDropDown2(map.get("MERIT_RATING").get(j), sp_meritRating_DrpDwn);
                        browserUtil.sendsTabKeyOnWebElement(sp_meritRating_DrpDwn);
                    } else {
                        //browserUtil.clicksWebElement(sp_meritRating_DrpDwn);
                        //browserUtil.driver.findElement(By.xpath("//div/label[contains(normalize-space(), 'Merit Rating Plan:')]//parent::div//following-sibling::div/span//input")).sendKeys(Keys.chord(Keys.ARROW_UP));
                        //browserUtil.selectsValueFromDropDown("", sp_meritRating_DrpDwn);
                        //Thread.sleep(3000);
                        browserUtil.driver.findElement(By.xpath("//div/label[contains(normalize-space(), 'Merit Rating Plan:')]//parent::div//following-sibling::div/span//input")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.TAB));
                        Thread.sleep(3000);
                        browserUtil.sendsTabKeyOnWebElement(sp_meritRating_DrpDwn);

                    }
                }
                if (!map.get("Rate_Modification").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_rateModifications_Txt, map.get("Rate_Modification").get(j));

                if (!map.get("CATASTROPHE_").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_catastrophe_Txt, map.get("CATASTROPHE_").get(j));

                if (!map.get("SAFETY_PROGRAMS").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_safetyProgram_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("SAFETY_PROGRAMS").get(j), sp_safetyProgram_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_safetyProgram_DrpDwn);
                }
                if (!map.get("SAFETY_PROGRAMS").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_drugFreeProgram_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("DRUG_FREE_PROGRAM").get(j), sp_drugFreeProgram_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_drugFreeProgram_DrpDwn);
                }

                if (!map.get("SMALL_DEDUCTIBLE1").get(j).equalsIgnoreCase("$$NA$$")) {
                    //browserUtil.waitsUntilWebElementIsClickable(sp_smallDeductible1_DrpDwn);
                    browserUtil.clicksWebElement(sp_smallDeductible1_DrpDwn);
                    //browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.waitsUntilWebElementIsClickable(sp_smallDeductible1_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("SMALL_DEDUCTIBLE1").get(j), sp_smallDeductible1_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_smallDeductible1_DrpDwn);
                }
                if (!map.get("SMALL_DEDUCTIBLE2").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_smallDeductible2_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.selectsValueFromDropDown2(map.get("SMALL_DEDUCTIBLE2").get(j), sp_smallDeductible2_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_smallDeductible2_DrpDwn);

                }
                if (!map.get("SMALL_DEDUCTIBLE3").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_smallDeductible3_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("SMALL_DEDUCTIBLE3").get(j), sp_smallDeductible3_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_smallDeductible1_DrpDwn);
                }
                if (!map.get("TIER_RATING_SURCHARGE1").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_tierRatingSurcharges1_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("TIER_RATING_SURCHARGE1").get(j), sp_tierRatingSurcharges1_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_tierRatingSurcharges1_DrpDwn);
                }
                if (!map.get("TIER_RATING_SURCHARGE2").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_tierRatingSurcharges2_Txt, map.get("TIER_RATING_SURCHARGE2").get(j));
                if (!map.get("Foreign_Terrorism").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_foreignTerrorism_Txt, map.get("Foreign_Terrorism").get(j));
                if (!map.get("CONTRACTORS_RAITING_PLAN").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_contractorRatingPlan_Txt, map.get("CONTRACTORS_RAITING_PLAN").get(j));
                if (!map.get("VOLUNTARY_COMPENSATION").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_voluntaryCompensation_Txt, map.get("VOLUNTARY_COMPENSATION").get(j));
                if (!map.get("USL_H_FLAT").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_USLHFlat_Txt, map.get("USL_H_FLAT").get(j));
                if (!map.get("LARGE_DEDUCTIBLE1").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_largeDeductible1_Txt, map.get("LARGE_DEDUCTIBLE1").get(j));
                if (!map.get("LARGE_DEDUCTIBLE2").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_largeDeductible2_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("LARGE_DEDUCTIBLE2").get(j), sp_largeDeductible2_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_largeDeductible2_DrpDwn);
                }
                if (!map.get("BLANKET_WAIVER_FLAT_CHARGE").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_blanketWaiverFlatCharge_Txt, map.get("BLANKET_WAIVER_FLAT_CHARGE").get(j));
                if (!map.get("BLANKET_WAIVER").get(j).equalsIgnoreCase("$$NA$$")) {
                    if (!map.get("BLANKET_WAIVER").get(j).equalsIgnoreCase("Yes") && !map.get("BLANKET_WAIVER").get(j).equalsIgnoreCase("No"))
                        browserUtil.entersTextWithTabIn(sp_blanketWaiver_Txt, map.get("BLANKET_WAIVER").get(j).trim());
                    else
                        browserUtil.selectsValueFromDropDown2(map.get("BLANKET_WAIVER").get(j).trim(), sp_blanketWaiver_DrpDwn);
                }
                if (!map.get("FACULTATIVE_REINSURANCE").get(j).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_facultativeReinsurance_Txt, map.get("FACULTATIVE_REINSURANCE").get(j));
                if (!map.get("TIER_RATING_SURCHARGE1").get(j).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_tierRatingSurcharges1_DrpDwn);
                    browserUtil.selectsValueFromDropDown(map.get("TIER_RATING_SURCHARGE1").get(j), sp_tierRatingSurcharges1_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_tierRatingSurcharges1_DrpDwn);
                }
                browserUtil.clicksWebElement(sp_save_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void enterOverridesDetail(Map<String, List<String>> map, int k) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            if (map.get("Overrides_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElementUsingJavaScriptExecutor(sp_OverridesTab_Label);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(sp_admiraltyUpperLimit_Txt, map.get("Admiralty_Upper_Limit").get(k));
                if (!map.get("Admiralty_Lower_Limit").get(k).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_admiraltyLowerLimit_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("Admiralty_Lower_Limit").get(k), sp_admiraltyLowerLimit_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_admiraltyLowerLimit_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(sp_FELAUpperLimit_Txt, map.get("FELA_Upper_Limit").get(k));
                if (!map.get("FELA_Lower_Limit").get(k).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_FELALowerLimit_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("FELA_Lower_Limit").get(k), sp_FELALowerLimit_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_FELALowerLimit_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(sp_anniversaryRateDateState_Txt, map.get("Anniversary_Rate_Date_State").get(k));
                browserUtil.entersTextWithTabIn(sp_premDiscPercent_Txt, map.get("Prem_Disc_Percent").get(k));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(sp_expMod_Txt, map.get("Exp._Mod").get(k));
                if (!map.get("Mod_Type").get(k).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_modeType_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("Mod_Type").get(k), sp_modeType_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_modeType_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(sp_riskId_Txt, map.get("Risk_ID").get(k));
                browserUtil.entersTextWithTabIn(sp_modDate_Txt, map.get("Mod_Date").get(k));
                browserUtil.entersTextWithTabIn(sp_USLHMinPremOvrd_Txt, map.get("USLH_Min_Prem_Ovrd").get(k));
                browserUtil.clicksWebElement(sp_save_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void enterAuditOverridesDetails(Map<String, List<String>> map, int i) throws InterruptedException {
            if (map.get("AUDM_Overrides_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElement(sp_OverridesTab_Label);
                browserUtil.entersTextWithTabIn(sp_auditAnniversaryRateDate_Txt, map.get("Audit_Anniversary_Rate_Date").get(i));
                browserUtil.entersTextWithTabIn(sp_auditPremDiscPercent_Txt, map.get("Audit_Prem_Disc_Percent").get(i));
                browserUtil.entersTextWithTabIn(sp_auditExpMod_Txt, map.get("Audit_Experience_Mode_Exp_Mod").get(i));
                if (!map.get("Audit_Experience_Mode_Mod_Type").get(i).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.clicksWebElement(sp_auditModType_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("Audit_Experience_Mode_Mod_Type").get(i), sp_auditModType_DrpDwn);
                    browserUtil.sendsTabKeyOnWebElement(sp_auditModType_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(sp_auditRiskId_Txt, map.get("Audit_Experience_Mode_Risk_ID").get(i));
                browserUtil.entersTextWithTabIn(sp_auditModDate_Txt, map.get("Audit_Experience_Mode_Mod_Date").get(i));
                if (!map.get("USLH Min Prem Ovrd").get(i).equalsIgnoreCase("$$NA$$"))
                    browserUtil.entersTextWithTabIn(sp_USLHMinPremiumOverride_Txt, map.get("USLH Min Prem Ovrd").get(i));
                browserUtil.clicksWebElement(sp_save_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.clicksOnNext();
                browserUtil.waitUntilPleaseWaitDisappear();
            }

        }

        public void selectSplitDateAndStateForAudit(Map<String, List<String>> map) throws InterruptedException {
            for (int j = 0; j < map.get("SelectStateForAuditTransaction").size(); j++) {
                if (map.get("SelectStateForAuditTransaction").get(j).equalsIgnoreCase("$$NA$$")) {
                    break;
                }
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("STATES");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                //browserUtil.switchToFrame("WkStateSplitsEdit_IFStateSplits");
                if (!map.get("SelectStateForAuditTransaction").get(j).equalsIgnoreCase("$$NA$$")) {
                    String expandState = map.get("SelectStateForAuditTransaction").get(j);
                    String stateInitial = map.get("State_Initials").get(j);
                    String getSplitDates = map.get("Split Date Start").get(j) + " - " + map.get("Split Date End").get(j);
                    System.out.println("Split Date (For Audit) -> " + getSplitDates);
                    List sp_StateExpand_Img = Arrays.asList(By.xpath("//tbody//td[normalize-space()='" + expandState + "']/preceding-sibling::td[1]/i[contains(@title, 'Expand child rows')]"), "State Audit Transaction Page", "'StateExpand_Img' (" + expandState + ")");
                    browserUtil.clicksWebElement(sp_StateExpand_Img);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    String parent = browserUtil.getWindowHandle();
                    //Below xpath is old one , it is change as per script 4A.
                    //List sp_SplitDate_Link = Arrays.asList(By.xpath("//u[contains(normalize-space(), '" + getSplitDates + "')]/parent::a[contains(@id,'RowSelectLink_" + stateInitial + "')]"), "State Audit Transaction Page", "'SplitDate_Link' (" + getSplitDates + ", " + stateInitial + ")");
                    List sp_SplitDate_Link = Arrays.asList(By.xpath("//td[text()='" + expandState + "']/parent::tr/following-sibling::tr[1]/td/table/tbody/tr/td/a"), "State Audit Transaction Page", "'SplitDate_Link' (" + getSplitDates + ", " + stateInitial + ")");
                    browserUtil.waitsUntilWebElementIsClickable(sp_SplitDate_Link);
                    browserUtil.clicksWebElement(sp_SplitDate_Link);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    enterAuditStateInfoDetails(map, j);
                    enterRatingsPlanCoveragesDetail(map, j);
                    enterAuditOverridesDetails(map, j);
                }
            }
        }

        public void enterStatesDetails(Map<String, List<String>> map) throws InterruptedException {

            if(map.get("States_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("General Liability");
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("STATES");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                //WebDriverWait waitForWebDriver = new WebDriverWait(browserUtil.driver, 240);
                //waitForWebDriver.until(ExpectedConditions.elementToBeClickable(By.id("CoUnderwriterHTML_CoUnderwriter_UndwrNm_comboboxinput")));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.clicksWebElement(gl_States_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
               // browserUtil.waitsUntilWebElementIsClickable(gl_States_DrpDwn);

                if (map.get("GL_States_OptCovg_Flag").get(0).equalsIgnoreCase("Yes"))
                {
                    browserUtil.clicksWebElement(gl_StatesOptCoverages_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    //browserUtil.clicksWebElement(gl_StatesOptCoverages_DrpDwn);
                    //browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("GL_States_OptCoverages").get(0),gl_StatesOptCoverages_DrpDwn);
                    //browserUtil.selectsValueFromDropDown2(map.get("GL_States_OptCoverages").get(0),gl_StatesOptCoverages_DrpDwn);
                    browserUtil.clicksWebElement(gl_StatesaddCoverage_Button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.clicksWebElement(gl_StatesaggregateLimit_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.selectsValueFromDropDown2(map.get("GL_States_Aggregate_Limit").get(0),gl_StatesaggregateLimit_DrpDwn);
                    //browserUtil.clicksWebElement(gl_StatesaddCoverage_Button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                }
                //browserUtil.sendsTabKeyOnWebElement(gl_States_DrpDwn);
            }
        }
    }


    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public StatesMethods theUser_() {
        return this.pageMethods;
    }
}