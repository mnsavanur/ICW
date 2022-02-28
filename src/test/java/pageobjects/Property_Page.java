package pageobjects;

import org.openqa.selenium.By;
import utilities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by shreyas on 31/01/2022.
 */
public class Property_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private Synchronization_Util synchronizationUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private  Property_Page.PropertyMethod pageMethods;

    public Property_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new  Property_Page.PropertyMethod();
    }

    public interface IProperty  {

        List gl_policyType_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Policy Type:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Policy Type");
        List gl_retroDate_textBox = Arrays.asList(By.xpath("//label[contains(.,'Retro Date:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Retro Date");
        List gl_claimsYear_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Claims Year:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Claims Year");
        List gl_generalAggr_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'General Aggr:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "General Aggr");
        List gl_productsComplOps_textBox = Arrays.asList(By.xpath("//label[contains(.,'Products Compl Ops:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Products Compl Ops");
        List gl_eachOccurrence_textBox = Arrays.asList(By.xpath("//label[contains(.,'Each Occurrence:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Each Occurrence");
        List gl_personalAdvInjury_textBox = Arrays.asList(By.xpath("//label[contains(.,'Personal/Adv Injury:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Personal/Adv Injury");
        List gl_damagetoPremisesRented_textBox = Arrays.asList(By.xpath("//label[contains(.,'Damage to Premises Rented:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Damage to Premises Rented");
        List gl_medicalExpense_textBox= Arrays.asList(By.xpath("//label[contains(.,'Medical Expense:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Medical Expense");
        List gl_exemptCommlRisk_DrpDwn= Arrays.asList(By.xpath("//label[contains(.,'Exempt Comml Risk:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Exempt Comml Risk");
        List gl_OptCoverages_tab = Arrays.asList(By.xpath("//li[contains(.,'Opt Coverages')]"), "Genral Liability Page", "Opt Coverages");
        List gl_OptCoverages_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlPolCovgEdit_cboAddCoverage_comboboxinput']"), "Genral Liability Page", "Opt Coverages Dropdwon");
        List gl_addCoverage_Button = Arrays.asList(By.xpath("//button[contains(.,'Add Coverage')]"), "Genral Liability Page", "Add Coverage");
        List gl_premium_textBox = Arrays.asList(By.xpath("//label[contains(.,'Premium:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Premium");
        List gl_classCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Class Code:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Class Code");
        List wc_rateMode_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkPolicy_RateModeCd_LST_comboboxinput"), "Workers Comp Page", "Policy Type");
        List wc_anniversaryRateDate_Txt = Arrays.asList(By.id("WkPolicyTab_TabCtrl_Tab1_WkPolicyHTML_ActiveControl_WkPolicy_AnnivRateDt"), "Workers Comp Page", "Anniversary Rate Date");
        List wc_execOfficer_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkPolicy_ExecOffInd_LST_comboboxinput"), "Workers Comp Page", "Exec. Officer");
        List wc_empLease_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkPolicy_EmpLeasingCd_LST_comboboxinput"), "Workers Comp Page", "Employee Lease");
        List wc_table_Txt = Arrays.asList(By.id("WkPolicyHTML_WkPolicy_PlanDesc_FLD"), "Workers Comp Page", "Table");
        List wc_empLiability_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_DynamicStore_PolEmpLiabLimits_comboboxinput"), "Workers Comp Page", "Employee Liability");
        List wc_FELAEachAcc_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkFELA_FelaAccLimitAmt_LST_comboboxinput"), "Workers Comp Page", "FELA Each Accident");
        List wc_FELAEachPrgType_DrpDwn = Arrays.asList(By.id("WkPolicyTab_TabCtrl_Tab1_WkPolicyHTML_ActiveControl_WkFELA_FelaProgramTypeCd"), "Workers Comp Page", "FELA Each Program Type");
        List wc_admiraltyEachAcc_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkAdmiralty_AdmiraltyAccLimitAmt_LST_comboboxinput"), "Workers Comp Page", "Admiralty Each Accident");
        List wc_admiraltyEachPrgType_DrpDwn = Arrays.asList(By.id("WkPolicyHTML_WkAdmiralty_AdmiraltyProgramTypeCd_LST_comboboxinput"), "Workers Comp Page", "Admiralty Each Program Type");
        List wc_foreignVoluntary_Txt = Arrays.asList(By.id("WkPolicyHTML_WkForeignVol_ForeignVolPremAmt_FLD"), "Workers Comp Page", "Foreign Voluntary");
        List wc_percentOverride_Txt = Arrays.asList(By.id("WkPolicyHTML_WkPremDisc_PremDiscountOvrdFactorPct_FLD"), "Workers Comp Page", "Percent Override");
        List wc_NJPrem_Txt = Arrays.asList(By.id("WkPolicyHTML_WkPremDisc_NjCombPolicyPremAmt_FLD"), "Workers Comp Page", "NJ Premium");
        List wc_combPolicyPrem_Txt = Arrays.asList(By.id("WkPolicyHTML_WkPremDisc_CombPolicyPremAmt_FLD"), "Workers Comp Page", "Comb Policy Premium");
        List wc_RetroDeductibleInformationTab_Label = Arrays.asList(By.xpath("//span[@title='Retro & Deductible Information']"), "Workers Comp Page", "RetroDeductibleInformationTab_Label");
        List wc_diDeductiblePct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_LargeDedFct_FLD"), "Workers Comp Page", "Di Deductible Pct");
        List wc_deductibleType_DrpDwn = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_DeductibleCd_FLD"), "Workers Comp Page", "Deductible Type");
        List wc_diOccurrenceAmt_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_OccurLmtAmt_FLD"), "Workers Comp Page", "Per Occurrence Amount");
        List wc_diAggregateAmt_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_AggregateLmtAmt_FLD"), "Workers Comp Page", "Aggregate Amount");
        List wc_diCoInsurance_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_CoinsuranceAmt_FLD"), "Workers Comp Page", "Co Insurance");
        List wc_diGuaranteeCost_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_GuaranteedCostPremAmt_FLD"), "Workers Comp Page", "Guaranteed Cost Prem");
        List wc_basicPremFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_BasicPremFct_FLD"), "Workers Comp Page", "Basic Prem Fct");
        List wc_maxPremFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_MaxRetroPremPct_FLD"), "Workers Comp Page", "Max Prem Fct");
        List wc_minPremFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_MinRetroPremFct_FLD"), "Workers Comp Page", "Min Prem Fct");
        List wc_retentionFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetentionFct_FLD"), "Workers Comp Page", "Retention Fct");
        List wc_taxMultiplier_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_TaxMultiplierFct_FLD"), "Workers Comp Page", "Tax Multiplier");
        List wc_perClaimLossLimit_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_LossLmtAmt_FLD"), "Workers Comp Page", "Per Claim Loss Limit");
        List wc_lossLimitFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_LossLmtFct_FLD"), "Workers Comp Page", "Loss Limit Fct");
        List wc_excessLossFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_ExcessLmtFct_FLD"), "Workers Comp Page", "Excess Lost Fct");
        List wc_firstRetroDevFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetroDev1Fct_FLD"), "Workers Comp Page", "First Retro Development Fct");
        List wc_secondRetroDevFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetroDev2Fct_FLD"), "Workers Comp Page", "Second Retro Development Fct");
        List wc_thirdRetroDevFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetroDev3Fct_FLD"), "Workers Comp Page", "Third Retro Development Fct");
        List wc_forthRetroDevFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetroDev4Fct_FLD"), "Workers Comp Page", "Forth Retro Development Fct");
        List wc_fifthRetroDevFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_RetroDev5Fct_FLD"), "Workers Comp Page", "Fifth Retro Development Fct");
        List wc_ALAEIncluded_DrpDwn = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyLargeDedInput_ALAEInd_LST_comboboxinput"), "Workers Comp Page", "ALAE Included");
        List wc_lossConversionFct_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_LossConvFct_FLD"), "Workers Comp Page", "Loss Conversion Fct");
        List wc_securityType_DrpDwn = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_SecurityTypeCd_LST_comboboxinput"), "Workers Comp Page", "Security Type");
        List wc_otherDesc_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_SecurityDescTx_FLD"), "Workers Comp Page", "Other Description");
        List wc_securityAmt_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_SecurityAmt_FLD"), "Workers Comp Page", "Security Amount");
        List wc_securityExpDate_Txt = Arrays.asList(By.id("WkPolicyRetroInfoHTML_WkPolicyRetroInput_SecurityExpDt_FLD"), "Workers Comp Page", "Security expiry date");
        List wc_PolicyInfoTab_Label = Arrays.asList(By.xpath("//span[@title='Policy Info']"), "Workers Comp Page", "PolicyInfoTab_Label");
        List wc_ExperienceModsTab_Label = Arrays.asList(By.xpath("//span[@title='Experience Mods']"), "Workers Comp Page", "ExperienceModsTab_Label");
        List wc_save_Btn = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), "Workers Comp Page", "save_Btn");
        List wc_State_ComboBox = Arrays.asList(By.id("WkPolModEdit_ddAddMod_comboboxinput"), "Workers Comp Page", "'State_ComboBox'");
        List wc_AddExpMod_Img = Arrays.asList(By.xpath("//span[@class='btnText' and text()='Add Exp. Mod']"), "Workers Comp Page", "'AddExpMod_Img'");
        List wc_expMod_Txt = Arrays.asList(By.xpath("//input[contains(@id,'ExpModFactorPct')]"), "Workers Comp Page", "Exp Mod");
        List wc_modTypeForCountryWide_DrpDwn = Arrays.asList(By.id("WkCwModInfoHTML_WkCwModInfo_ExpModCd_LST_comboboxinput"), "Workers Comp Page", "Mod Type");
        List wc_modType_DrpDwn = Arrays.asList(By.id("WkStateModInfoHTML_WkModInfo_ExpModCd_LST_comboboxinput"), "Workers Comp Page", "Mod Type");
        List wc_modDate_Txt = Arrays.asList(By.xpath("//input[contains(@id,'WkStateModInfoHTML_WkModInfo_ModDt_FLD')]"), "Workers Comp Page", "Mod date");
        List wc_riskId_Txt = Arrays.asList(By.xpath("//input[contains(@id,'RiskIdNo')]"), "Workers Comp Page", "Risk Id");

        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Property Policy Info
        List pes_Property_Link = Arrays.asList(By.xpath("//button[normalize-space()='Property']"), "Policy Explorer", "'Property_Link'");
        List cp_DeductibleType_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Deductible Type:')]/..//following-sibling::div[1]//input"), "Property Page", "Deductible Type");
        List cp_Bldg_Ded_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Bldg Ded:')]/..//following-sibling::div[1]//input"), "Property Page", "Bldg Ded");
        List cp_Bldg_Coinsurance_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Bldg Coinsurance:')]/..//following-sibling::div[1]//input"), "Property Page", "Bldg Coinsurance");
        List cp_BPP_Coinsurance_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'BPP Coinsurance:')]/..//following-sibling::div[1]//input"), "Property Page", "BPP Coinsurance");

        //Blanket Info
        List cp_BlanketInfo_tab = Arrays.asList(By.xpath("//li[contains(.,'Blanket Info.')]"), "Property Page", "Blanket Info  Coverages");
        List cp_GroupType_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Group Type:')]/..//following-sibling::div[1]//input"), "Property Page", "Group Type");
        List cp_limit_textBox = Arrays.asList(By.xpath("//label[contains(.,'Limit:')]/..//following-sibling::div[1]//input"), "Property Page", "Limit");
        List cp_CoinsOvrd_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Coins Ovrd:')]/..//following-sibling::div[1]//input"), "Property Page", "Coins Ovrd");

        //Propert Policy Level Coverage-OptionalCoverage
        List cp_OptCovgs_tab = Arrays.asList(By.xpath("//li[contains(.,'Opt Covgs')]"), "Property Page", "Opt Covgs  Coverages");
        List cp_OptCovgs_Drpdwn=Arrays.asList(By.xpath("//input[@id='PfPolCovgEdit_cboAddCoverage_comboboxinput']"),"Property Page", "Opt Covgs Coverages");
        List cp_OptCovgs_Add_Coverage_button=Arrays.asList(By.xpath("//button[@id='PfPolCovgEdit_dgPolCovgList_Row_AddNew']"),"Property Page","Add Coverage");
        List Cp_OptCovgs_ClassCode_textBox=Arrays.asList(By.xpath("//label[contains(.,'Class Code:')]/..//following-sibling::div[1]//input"),"Property Page ","Class Code");
        List Cp_OptCovgs_CoverageCode_Drpdwn=Arrays.asList(By.xpath("//label[contains(.,'Coverage Code:')]/..//following-sibling::div[1]//input"),"Property Page ","Coverage Code");
        List Cp_OptCovgs_Limit_textBox=Arrays.asList(By.xpath("//input[@id='PfManPremHTML_PfPolCovgInput_Limit1_FLD']"),"Property Page ","Limit");
        List Cp_OptCovgs_Premium_textBox=Arrays.asList(By.xpath("//label[contains(.,'Premium:')]/..//following-sibling::div[1]//input"),"Property Page ","Premium");
        List Cp_OptCovgs_Misc_1_textBox=Arrays.asList(By.xpath("//label[contains(.,'Misc 1:')]/..//following-sibling::div[1]//input"),"Property Page ","Misc 1");
        List Cp_OptCovgs_Misc_2_textBox=Arrays.asList(By.xpath("//label[contains(.,'Misc 2:')]/..//following-sibling::div[1]//input"),"Property Page ","Misc 2");
        List Cp_OptCovgs_Misc_3_textBox=Arrays.asList(By.xpath("//label[contains(.,'Misc 3:')]/..//following-sibling::div[1]//input"),"Property Page ","Misc 3");
        List Cp_OptCovgs_Misc_4_textBox=Arrays.asList(By.xpath("//label[contains(.,'Misc 4:')]/..//following-sibling::div[1]//input"),"Property Page ","Misc 4");

        List cp_EndtRecal_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Endt Recalc:')]/..//following-sibling::div[1]//input"), "Property Page", "Endt Recal");

    }

    public class PropertyMethod implements  Property_Page.IProperty {

        public void enterPropertyPolicyInfo(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CP_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElement(pes_Property_Link);
                //baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("Property");
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("CP_Deductible_Type").get(0),cp_DeductibleType_DrpDwn);
                browserUtil.CMPDropDown(map.get("CP_Bldg_Ded").get(0),cp_Bldg_Ded_DrpDwn);
                browserUtil.CMPDropDown(map.get("CP_Bldg_Coinsurance").get(0),cp_Bldg_Coinsurance_DrpDwn);
                browserUtil.CMPDropDown(map.get("CP_BPP_Coinsurance").get(0),cp_BPP_Coinsurance_DrpDwn);

                if (map.get("CP_BlanketInfo_Flag").get(0).equalsIgnoreCase("Yes"))
                {
                    browserUtil.clicksWebElement(cp_BlanketInfo_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    //browserUtil.CMPDropDown(map.get("Endt_Recal").get(0),cp_EndtRecal_Drpdwn);
                    browserUtil.CMPDropDown(map.get("CP_Group_Type").get(0),cp_GroupType_Drpdwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(cp_limit_textBox, map.get("CP_Limit").get(0));
                    browserUtil.CMPDropDown(map.get("CP_Coins_Ovrd").get(0),cp_CoinsOvrd_Drpdwn);
                    //baseUtil.clicksOnNext();
                }
            }
        }
        public void addOptionalcoverages(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CP_Opt_Covgs_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.clicksWebElement(cp_OptCovgs_tab);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("CP_OptCovgs").get(0), cp_OptCovgs_Drpdwn);
                browserUtil.clicksWebElement(cp_OptCovgs_Add_Coverage_button);
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_ClassCode_textBox, map.get("CP_Class_Code").get(0));
                browserUtil.CMPDropDown(map.get("CP_CoverageCode").get(0), Cp_OptCovgs_CoverageCode_Drpdwn);
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Limit_textBox, map.get("CP_Limit_textBox").get(0));
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Premium_textBox, map.get("CP_Premium_textBox").get(0));
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Misc_1_textBox, map.get("CP_Misc_1_textBox").get(0));
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Misc_2_textBox, map.get("CP_Misc_2_textBox").get(0));
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Misc_3_textBox, map.get("CP_Misc_3_textBox").get(0));
                browserUtil.entersTextWithTabIn(Cp_OptCovgs_Misc_4_textBox, map.get("CP_Misc_4_textBox").get(0));
                baseUtil.clicksOnNext();
            }
        }



        public void enterGeneralLiabilityPolicyDetail(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("GL_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("General Liability");
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.selectsValueFromDropDown2(map.get("GL_PolicyType").get(0),gl_policyType_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.selectsValueFromDropDown2(map.get("GL_GeneralAggr").get(0),gl_generalAggr_DrpDwn);
                if (map.get("GL_OptCovg_Flag").get(0).equalsIgnoreCase("Yes"))
                {
                    browserUtil.clicksWebElement(gl_OptCoverages_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.selectsValueFromDropDown2(map.get("GL_OptCoverages").get(0),gl_OptCoverages_DrpDwn);
                    browserUtil.clicksWebElement(gl_addCoverage_Button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_premium_textBox, map.get("Premium").get(0));
                    browserUtil.entersTextWithTabIn(gl_classCode_textBox, map.get("GL_ClassCode").get(0));
                }
            }
        }

        public void enterRetroAndDeductibleInformationDetails(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("Retro_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.waitsUntilWebElementIsVisible(wc_RetroDeductibleInformationTab_Label);
                browserUtil.clicksWebElementUsingJavaScriptExecutor(wc_RetroDeductibleInformationTab_Label);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsVisible(wc_diDeductiblePct_Txt);
                browserUtil.entersTextWithTabIn(wc_diDeductiblePct_Txt, map.get("DIDeductible_Pct").get(0));
                browserUtil.selectsValueFromDropDown2(map.get("DIDeductible_Type").get(0), wc_deductibleType_DrpDwn);
                if (!map.get("DIDeductible_Type").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(wc_deductibleType_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(wc_diOccurrenceAmt_Txt, map.get("DIPer_Occurrence_Amt").get(0));
                browserUtil.entersTextWithTabIn(wc_diAggregateAmt_Txt, map.get("DIAggregate_Amt").get(0));
                browserUtil.entersTextWithTabIn(wc_diCoInsurance_Txt, map.get("DICoinsurance").get(0));
                browserUtil.entersTextWithTabIn(wc_diGuaranteeCost_Txt, map.get("DIGuaranteed_Cost_Prem").get(0));
                browserUtil.entersTextWithTabIn(wc_basicPremFct_Txt, map.get("RDIBasic_Premium_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_maxPremFct_Txt, map.get("RDIMax_Premium_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_minPremFct_Txt, map.get("RDIMin_Premium_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_retentionFct_Txt, map.get("RDIRetention_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_taxMultiplier_Txt, map.get("RDITax_Multiplier").get(0));
                browserUtil.entersTextWithTabIn(wc_perClaimLossLimit_Txt, map.get("RDIPer_Claim_Loss_Limit").get(0));
                browserUtil.entersTextWithTabIn(wc_lossLimitFct_Txt, map.get("RDILoss_Limit_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_excessLossFct_Txt, map.get("RDIExcess_Loss_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_firstRetroDevFct_Txt, map.get("RDI1st_Retro_Development_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_secondRetroDevFct_Txt, map.get("RDI2nd_Retro_Development_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_thirdRetroDevFct_Txt, map.get("RDI3rd_Retro_Development_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_forthRetroDevFct_Txt, map.get("RDI4th_Retro_Development_Fct").get(0));
                browserUtil.entersTextWithTabIn(wc_fifthRetroDevFct_Txt, map.get("RDI5th_Retro_Development_Fct").get(0));
                if (!map.get("RDI5th_Retro_Development_Fct").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(wc_fifthRetroDevFct_Txt);
                }
                //browserUtil.selectsValueFromDropDown2(map.get("RDIALAE_Included").get(0), wc_ALAEIncluded_DrpDwn);
                if (!map.get("RDIALAE_Included").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.waitsUntilWebElementIsVisible(wc_ALAEIncluded_DrpDwn);
                    browserUtil.selectsValueFromDropDown2(map.get("RDIALAE_Included").get(0), wc_ALAEIncluded_DrpDwn);

                }
                browserUtil.sendsTabKeyOnWebElement(wc_ALAEIncluded_DrpDwn);
                browserUtil.entersTextWithTabIn(wc_lossConversionFct_Txt, map.get("RDILoss_Conversion_Fct").get(0));
                if (!map.get("RDILoss_Conversion_Fct").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(wc_lossConversionFct_Txt);
                }
                browserUtil.selectsValueFromDropDown2(map.get("RDISecurity_Type").get(0), wc_securityType_DrpDwn);
                if (!map.get("RDISecurity_Type").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(wc_securityType_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(wc_otherDesc_Txt, map.get("RDIOther_Description").get(0));
                browserUtil.entersTextWithTabIn(wc_securityAmt_Txt, map.get("RDISecurity_Amt").get(0));
                browserUtil.entersTextWithTabIn(wc_securityExpDate_Txt, map.get("RDISecurity_Exp_Date").get(0));
                browserUtil.clicksWebElement(wc_save_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void enterExperienceModsDetails(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("ExperienceMode_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("WORKERS COMP");
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitUntilPleaseWaitDisappear();
                if (!browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(wc_ExperienceModsTab_Label, "class", "Sel")) {
                    browserUtil.clicksWebElementUsingJavaScriptExecutor(wc_ExperienceModsTab_Label);
                    browserUtil.waitUntilPleaseWaitDisappear();
                }
                if (map.get("Transaction_Type").get(0).equalsIgnoreCase("NBIS") || map.get("Transaction_Type").get(0).equalsIgnoreCase("RCIS")) {
                    for (int i = 0; i < map.get("Location_Exp_Mod").size(); i++) {
                        if (map.get("Location_Exp_Mod").get(i).equalsIgnoreCase("$$NA$$")) {
                            break;
                        }
                        addExpModDetails(map, "ADD", i);
                    }
                } else if (map.get("Transaction_Type").get(0).equalsIgnoreCase("PCNM")) {
                    for (int i = 0; i < map.get("Performing_Action_Experience_Mod").size(); i++) {
                        String action = map.get("Performing_Action_Experience_Mod").get(i);
                        switch (action) {
                            case "ADD":
                                addExpModDetails(map, "ADD", i);
                                break;
                            case "EDIT":
                                addExpModDetails(map, "EDIT", i);
                                break;
                            case "DELETE":
                                List em_Delete_Link;
                                //em_Delete_Link = Arrays.asList(By.xpath("//div[contains(@id, 'PolModList')]//table//tr[(./td/a[normalize-space()='" + map.get("Location_Exp_Mod").get(i).trim() + "'])]//img[@title='Delete Experience Mod']"), "Experience Mod Information", "'Delete_Link' (" + map.get("Location_Exp_Mod").get(i).trim() + ")");
                                em_Delete_Link = Arrays.asList(By.xpath("//table//tr[(./td/a[normalize-space()='" + map.get("Location_Exp_Mod").get(i).trim() + "'])]//i"), "Experience Mod Information", "'Delete_Link' (" + map.get("Location_Exp_Mod").get(i).trim() + ")");

                                // browserUtil.switchToDefaultContent();
                                // browserUtil.switchToFrame("InsDmain");
                                //  browserUtil.switchToFrame("IFModInfo");
                                browserUtil.clicksWebElement(em_Delete_Link);
                                browserUtil.waitUntilPleaseWaitDisappear();
                                //browserUtil.acceptsAlert();

                                browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed();
                                String parent = browserUtil.getWindowHandle();
                                browserUtil.switchToChildWindow();
                                browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                                browserUtil.switchToWindowWithHandle(parent);


                                // browserUtil.switchToDefaultContent();
                                // browserUtil.switchToFrame("InsDmain");
                                System.out.println("******************Check UI Blocker - START******************");
                                browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                                System.out.println("******************Check UI Blocker - End******************");
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        }

        public void addExpModDetails(Map<String, List<String>> map, String action, int i) throws InterruptedException {
            List em_State_Label, em_State_Link;
            //em_State_Link = Arrays.asList(By.xpath("//div[@class='span12 left']/h4[@id='WkStateModInfoHTML_lblWkModInfoHdr']"), "Experience Mod Information", "'State_Link' (" + map.get("Location_Exp_Mod").get(i).trim() + ")");
            em_State_Label = Arrays.asList(By.xpath("//div[@class='span12 left']/h4"), "Experience Mod Information", "'State_Label' (" + map.get("Location_Exp_Mod").get(i).trim() + ")");
            em_State_Link = Arrays.asList(By.xpath("//tbody/tr/td/a[normalize-space()='" + map.get("Location_Exp_Mod").get(i) + "']"), "Experience Mod Information", "'State_Link' (" + map.get("Location_Exp_Mod").get(i).trim() + ")");
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            //browserUtil.switchToFrame("IFModInfo");
            browserUtil.waitsUntilWebElementIsVisible(wc_State_ComboBox);
            if (action.equalsIgnoreCase("ADD")) {
                browserUtil.waitsUntilWebElementIsClickable(wc_State_ComboBox);
                browserUtil.selectsValueFromDropDown2(map.get("Location_Exp_Mod").get(i), wc_State_ComboBox);
                browserUtil.clicksWebElementUsingJavaScriptExecutor(wc_AddExpMod_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
            } else if (action.equalsIgnoreCase("EDIT")) {
                browserUtil.clicksWebElement(em_State_Link);
            }
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.waitsForPageToBeLoaded();
            //WebDriverWait waitForWebDriver = new WebDriverWait(browserUtil.driver, 240);
            //waitForWebDriver.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'ExpModFactorPct')]")));
            browserUtil.waitsUntilWebElementIsClickable(wc_expMod_Txt);
            browserUtil.entersTextWithTabIn(wc_expMod_Txt, map.get("Experience_Mode_Exp_Mod").get(i));
            browserUtil.waitUntilPleaseWaitDisappear();
            if (!map.get("Experience_Mode_Exp_Mod").get(i).equalsIgnoreCase("$$NA$$")) {
                browserUtil.sendsTabKeyOnWebElement(wc_expMod_Txt);
            }
            if (map.get("Location_Exp_Mod").get(i).equalsIgnoreCase("Countrywide")) {
                browserUtil.waitsUntilWebElementIsClickable(wc_modTypeForCountryWide_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("Experience_Mode_Mod_Type").get(i), wc_modTypeForCountryWide_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
            } else {

                browserUtil.selectsValueFromDropDown2(map.get("Experience_Mode_Mod_Type").get(i), wc_modType_DrpDwn);
            }
            browserUtil.entersTextWithTabIn(wc_riskId_Txt, map.get("Experience_Mode_Risk_ID").get(i));
            browserUtil.entersTextWithTabIn(wc_modDate_Txt, map.get("Experience_Mode_Mod_Date").get(i));

            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.clicksWebElement(wc_save_Btn);
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.switchToFrame("IFModInfo");
            if (browserUtil.verifiesWebElementIsPresent(em_State_Label)) {
                browserUtil.writesToLogAndReport("Done", "addExpModDetails: Experience Mod for state '" + map.get("Location_Exp_Mod").get(i).trim() + "' added.");
            } else {
                browserUtil.writesToLogAndReport("Fail", "addExpModDetails: Experience Mod for state '" + map.get("Location_Exp_Mod").get(i).trim() + "' not added.");
            }
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public  Property_Page.PropertyMethod theUser_() {return this.pageMethods;}

}