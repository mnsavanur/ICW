package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunraj on 28/01/2022.
 */
public class GeneralLiability_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private Synchronization_Util synchronizationUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private GeneralLiability_Page.GeneralLiabMethods pageMethods;

    public GeneralLiability_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new GeneralLiability_Page.GeneralLiabMethods();
    }

    public interface IGeneralLiab {
        List gl_policyType_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Policy Type:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Policy Type");
        List gl_retroDate_textBox = Arrays.asList(By.xpath("//label[contains(.,'Retro Date:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Retro Date");
        List gl_claimsYear_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Claims Year:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Claims Year");
        List gl_generalAggr_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'General Aggr:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "General Aggr");
        List gl_productsComplOps_textBox = Arrays.asList(By.xpath("//label[contains(.,'Products Compl Ops:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Products Compl Ops");
        List gl_eachOccurrence_textBox = Arrays.asList(By.xpath("//label[contains(.,'Each Occurrence:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Each Occurrence");
        List gl_personalAdvInjury_textBox = Arrays.asList(By.xpath("//label[contains(.,'Personal/Adv Injury:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Personal/Adv Injury");
        List gl_damagetoPremisesRented_textBox = Arrays.asList(By.xpath("//label[contains(.,'Damage to Premises Rented:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Damage to Premises Rented");
        List gl_medicalExpense_textBox = Arrays.asList(By.xpath("//label[contains(.,'Medical Expense:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Medical Expense");
        List gl_exemptCommlRisk_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Exempt Comml Risk:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Exempt Comml Risk");
        List gl_OptCoverages_tab = Arrays.asList(By.xpath("//li[contains(.,'Opt Coverages')]"), "Genral Liability Page", "Opt Coverages");
        List gl_OptCoverages_DrpDwn = Arrays.asList(By.xpath("//input[@id='GlPolCovgEdit_cboAddCoverage_comboboxinput']"), "Genral Liability Page", "Opt Coverages Dropdwon");
        List gl_addCoverage_Button = Arrays.asList(By.xpath("//button[contains(.,'Add Coverage')]"), "Genral Liability Page", "Add Coverage");
        List gl_premium_textBox = Arrays.asList(By.xpath("//label[contains(.,'Premium:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Premium");
        List gl_classCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Class Code:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Class Code");
        List gl_deductibles_tab = Arrays.asList(By.xpath("//li[contains(.,'Deductibles')]"), "Genral Liability Page", "Deductibles");
        List gl_subline_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Subline:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Subline");
        List gl_option_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Option:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Option");
        List gl_amount_DrpDwn = Arrays.asList(By.xpath("//label[contains(.,'Amount:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Amount");
        List gl_type_DrpDwn = Arrays.asList(By.xpath("//label[text()='Type:']/..//following-sibling::div[1]//input"), "Genral Liability Page", "Type");
        List gl_ProductsDedFct_textbox = Arrays.asList(By.xpath("//label[contains(.,'Products Ded Fct')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Products Ded Fct");
        List gl_composite_tab = Arrays.asList(By.xpath("//li//span[text()='Composite']"), "Genral Liability Page", "Composite");
        List gl_compositeType1_dropdown = Arrays.asList(By.xpath("//label[contains(.,'Composite Type:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Composite Type");
        List gl_allClassInclude_dropdown = Arrays.asList(By.xpath("//label[contains(.,'All Classes Included:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "All Classes Included");
        List gl_compositetype_dropdown = Arrays.asList(By.xpath("(//label[normalize-space()='Type:'])[1]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Composite Type");
        List gl_class_dropdown = Arrays.asList(By.xpath("(//label[normalize-space()='Class:'])[1]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Class");
        List gl_premBasis_dropdown = Arrays.asList(By.xpath("(//label[normalize-space()='Prem Basis:'])[1]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Prem Basis");
        List gl_ratingBasis_dropdown = Arrays.asList(By.xpath("(//label[normalize-space()='Rating Basis:'])[1]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Rating Basis");
        List gl_productWithdrawal_tab = Arrays.asList(By.xpath("//li//span[text()='Product Withdrawal']"), "Genral Liability Page", "Product Withdrawal");
        List gl_productWithdrawal_drpdown = Arrays.asList(By.xpath("//label[contains(.,'Product Withdrawal:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Product Withdrawal Dropdown");
        List gl_minimumPremium_textbox = Arrays.asList(By.xpath("//label[contains(.,'Minimum Premium:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Minimum Premium");
        List gl_aggregateLimit_textbox = Arrays.asList(By.xpath("//label[contains(.,'Aggregate Limit:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Aggregate Limit");
        List gl_deductibleAmount_textbox = Arrays.asList(By.xpath("//label[contains(.,'Deductible Amount:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Deductible Amount");
        List gl_exclusions_tab = Arrays.asList(By.xpath("(//li//span[text()='Exclusions'])[1]"), "Genral Liability Page", "Exclusions");
        List gl_contractual_checkbox = Arrays.asList(By.xpath("//label[text()='Contractual']//preceding-sibling::input"), "Genral Liability Page", "Contractual");
        List gl_adfFactor_textbox = Arrays.asList(By.xpath("//label[contains(.,'Adj Factor:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Adj Factor");
        List gl_additionalInterest_tab = Arrays.asList(By.xpath("//li//span[text()='Additional Interests']"), "Genral Liability Page", "Additional Interest");
        List gl_addInterest_drpdown = Arrays.asList(By.xpath("//input[@id='GlPolAddlIntCovgEdit_additionalinterestcoverageaddpolicyfiltered_comboboxinput']"), "Genral Liability Page", "Additional Interest DropDown");
        List gl_addInterest_button = Arrays.asList(By.xpath("//button[contains(.,'Add Addl Interest Type')]"), "Genral Liability Page", "Additional Interest Button");
        List gl_sublinType_drpdown = Arrays.asList(By.xpath("//label[contains(.,'Subline Type:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Subline Type Dropdown");
        List gl_SelectAddName_btn = Arrays.asList(By.xpath("//button//span[text()='Select / Add Name']"), "Genral Liability Page", "Select Add Name button");
        List gl_AddName_btn = Arrays.asList(By.xpath("//button//span[text()='Add Name']"), "Genral Liability Page", "Add Name button");
        List gl_AdditionalInter_address_textarea = Arrays.asList(By.id("CoAdditionalInterestDetailHTML_CoName_NameTx"), "Genral Liability Page", "Additional Interest textarea");
        List gl_AdditionalInter_address_textbox = Arrays.asList(By.xpath("//label[contains(.,'Address:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Additional Interest Adrress");
        List gl_AdditionalInter_city_textbox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Additional Interest City");
        List gl_AdditionalInter_state_drpdown = Arrays.asList(By.xpath("//label[contains(.,'State:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "State Dropdown");
        List gl_AdditionalInter_Zipcode_textbox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Additional Interest Zip Code");
        List gl_saveAndClose_button2 = Arrays.asList(By.xpath("(//button[contains(.,'Save and Close')])[2]"), "Genral Liability Page", "Save and Close");
        List gl_aggregate_Limit_textbox_Emp = Arrays.asList(By.xpath("//label[contains(.,'Aggregate Limit:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Aggregate Limit");
        List gl_Other_Limit_textbox = Arrays.asList(By.xpath("//label[contains(.,'Other Limit:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Each Employee Limit:");
        List gl_Exposure_textbox = Arrays.asList(By.xpath("//label[contains(.,'Exposure:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Exposure");
        List gl_Territory_textbox = Arrays.asList(By.xpath("//label[contains(.,'Territory:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Territory");
        List gl_PremOpsDedFct_textbox = Arrays.asList(By.xpath("//label[contains(.,'Prem/Ops Ded Fct:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Products Ded Fct");
        List gl_DesignetedPremises_textbox = Arrays.asList(By.xpath("//label[contains(.,'Designated Premises:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Designated Premises");
        List gl_AdditionalInter_yourproducts_textbox = Arrays.asList(By.xpath("//label[contains(.,'Your Products:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Additional Interest Your Product");
        List gl_ParticipationFactor_textbox = Arrays.asList(By.xpath("//label[contains(.,'Participation % Factor:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Participation % Factor");
        List gl_ILFOverride_textbox = Arrays.asList(By.xpath("//label[contains(.,'ILF Override:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "ILF Override");
        List gl_CoveredOperations_textbox = Arrays.asList(By.xpath("//label[contains(.,'Covered Operations:')]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Covered Operations");
        List gl_compositetype2_dropdown = Arrays.asList(By.xpath("(//label[contains(.,'Type:')])[3]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Composite Type 2");
        List gl_class2_dropdown = Arrays.asList(By.xpath("(//label[contains(.,'Class:')])[2]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Class 2");
        List gl_premBasis2_dropdown = Arrays.asList(By.xpath("(//label[contains(.,'Prem Basis:')])[2]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Prem Basis 2");
        List gl_ratingBasis2_dropdown = Arrays.asList(By.xpath("(//label[contains(.,'Rating Basis:')])[2]/..//following-sibling::div[1]//input"), "Genral Liability Page", "Rating Basis 2");
        List sp_save_Btn = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), "Genral Liability Page", "Save Button");


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

        // GL CP Coverage Locators
        List glcp_Exclusion_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Exclusion Type:')]/..//following-sibling::div[1]//input"), "General Liability Page", "Exclusion Type");
        List glcp_Fungi_Bacteria_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Fungi/Bacteria Type:')]/..//following-sibling::div[1]//input"), "General Liability Page", "Fungi Bacteria_Type");
        List glcp_Fungi_Bacteria_Limit_txtbox = Arrays.asList(By.xpath("//label[contains(.,'Fungi/Bacteria Limit:')]/..//following-sibling::div[1]//input"), "General Liability Page", "Fungi Bacteria Limit:");

        List gl_startButton= Arrays.asList(By.xpath("//span[text()='Start']"), "General Liability Page", "Start Button");
        List gl_OkButton= Arrays.asList(By.xpath("//span[text()='Ok']"), "General Liability Page", "Ok Button");

    }

    public class GeneralLiabMethods implements GeneralLiability_Page.IGeneralLiab {

        public void enterGeneralLiabilityPolicyDetail(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("GL_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("General Liability");
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("GL_PolicyType").get(0), gl_policyType_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.GLntersTextWithTabIn(gl_personalAdvInjury_textBox, map.get("Personal_AdvInjury").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.GLntersTextWithTabIn(gl_medicalExpense_textBox, map.get("Medical_Expense").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.GLntersTextWithTabIn(gl_eachOccurrence_textBox, map.get("Each_Occurrence").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.CMPDropDown(map.get("GL_GeneralAggr").get(0), gl_generalAggr_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.GLntersTextWithTabIn(gl_productsComplOps_textBox, map.get("Products_ComplOps").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();


                browserUtil.GLntersTextWithTabIn(gl_damagetoPremisesRented_textBox, map.get("Damage_to_Premises_Rented").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();


                if (map.get("Deductibles").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(gl_deductibles_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Subline").get(0), gl_subline_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Option").get(0), gl_option_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Type").get(0), gl_type_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_ProductsDedFct_textbox, map.get("Products_Ded_Fct").get(0));
                    browserUtil.entersTextWithTabIn(gl_PremOpsDedFct_textbox, map.get("PremOps_Ded_Fct").get(0));
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Amount").get(0), gl_amount_DrpDwn);
                    browserUtil.waitUntilPleaseWaitDisappear();

                }
                if (map.get("Exclusions").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(gl_exclusions_tab);
                    if (map.get("Contractual").get(0).equalsIgnoreCase("Yes") || map.get("Contractual").get(0).equalsIgnoreCase("Check")) {
                        browserUtil.setsCheckBoxTo(true, gl_contractual_checkbox);
                    }
                    browserUtil.entersTextWithTabIn(gl_adfFactor_textbox, map.get("Adj_Factor").get(0));


                }
                if (map.get("Composite").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(gl_composite_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Composite_Type1").get(0), gl_compositeType1_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("All_Classes_Included").get(0), gl_allClassInclude_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Composite_Type").get(0), gl_compositetype_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Class").get(0), gl_class_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Prem_Basis").get(0), gl_premBasis_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Rating_Basis").get(0), gl_ratingBasis_dropdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    baseUtil.clicksOnSave();
                    try {
                        if (browserUtil.verifiesWebElementIsPresent(gl_startButton)) {
                            browserUtil.clicksWebElement(gl_startButton);
                            Thread.sleep(2000);
                            browserUtil.clicksWebElement(gl_OkButton);
                        }
                    } catch (Exception e) {
                    }

                }
                if (map.get("AdditionalInterest").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(gl_additionalInterest_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.clicksWebElement(gl_addInterest_button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                    browserUtil.waitUntilPleaseWaitDisappear();

                    if (map.get("Select_Add_Name").get(0).equalsIgnoreCase("Yes")) {

                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        Thread.sleep(3000);
                        //browserUtil.waitsUntilWebElementIsClickable(gl_AdditionalInter_city_textbox);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                    }
                }
                if (map.get("Product_Withdrawal").get(0).equalsIgnoreCase("Yes")) {

                    browserUtil.clicksWebElement(gl_productWithdrawal_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("Product_Withdrawal_dropdown").get(0), gl_productWithdrawal_drpdown);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_minimumPremium_textbox, map.get("Minimum_Premium").get(0));
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_aggregateLimit_textbox, map.get("Aggregate_Limit").get(0));
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_deductibleAmount_textbox, map.get("Deductible_Amount").get(0));
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_ParticipationFactor_textbox, map.get("Participation_Factor").get(0));
                    browserUtil.entersTextWithTabIn(gl_ILFOverride_textbox, map.get("ILV_Override").get(0));

                }

                if (map.get("GL_OptCovg_Flag").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(gl_OptCoverages_tab);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.CMPDropDown(map.get("GL_OptCoverages").get(0), gl_OptCoverages_DrpDwn);
                    browserUtil.clicksWebElement(gl_addCoverage_Button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.entersTextWithTabIn(gl_premium_textBox, map.get("Premium").get(0));
                    browserUtil.entersTextWithTabIn(gl_classCode_textBox, map.get("GL_ClassCode").get(0));

                }
            }
        }

        public void addAdditionalInterest(Map<String, List<String>> map) {
            browserUtil.clicksWebElement(gl_additionalInterest_tab);
            browserUtil.waitUntilPleaseWaitDisappear();
            for (int i = 0; i < map.get("Additional_Interest").size(); i++) {
                String action = map.get("Additional_Interest").get(i);
                switch (action) {
                    case "Additional Insured Concessionaires Trading":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                        break;
                    case "Mortgagee, Assignee, Or Receiver":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.entersTextWithTabIn(gl_DesignetedPremises_textbox, map.get("Designated_Premises").get(0));
                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                        break;
                    case "Managers Or Lessors Of Premises":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.entersTextWithTabIn(gl_DesignetedPremises_textbox, map.get("Designated_Premises").get(0));
                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                        break;
                    case "AI - Vendors":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_yourproducts_textbox, map.get("AdditInterset_YourProducts").get(0));
                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                        break;
                    case "Owners-Lessees Or Contractors":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.clicksWebElement(gl_SelectAddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(gl_AddName_btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textarea, map.get("Additional_Interest_Name").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_address_textbox, map.get("AdditInterset_Address").get(0));
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_city_textbox, map.get("AdditInterset_City").get(0));
                        browserUtil.CMPDropDown(map.get("AdditInterset_State").get(0), gl_AdditionalInter_state_drpdown);
                        browserUtil.entersTextWithTabIn(gl_AdditionalInter_Zipcode_textbox, map.get("AdditInterset_ZipCode").get(0));
                        browserUtil.clicksWebElement(gl_saveAndClose_button2);
                        browserUtil.scrollToBottom();
                        browserUtil.entersTextWithTabIn(gl_CoveredOperations_textbox, map.get("Covered_Operations").get(0));
                        break;
                    case "Engineers-Architects Or Surveyors":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        break;
                        case "AI - Charitable Institutions":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(0), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(0), gl_sublinType_drpdown);
                        browserUtil.clicksWebElement(sp_save_Btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                       break;
                    case "AI - Executors, Administrators, Trustees Or Beneficiaries":
                        browserUtil.CMPDropDown(map.get("AddIntersest_Drp").get(1), gl_addInterest_drpdown);
                        browserUtil.clicksWebElement(gl_addInterest_button);
                        browserUtil.CMPDropDown(map.get("Subline_type").get(1), gl_sublinType_drpdown);
                        break;
                    default:
                        break;

                }
            }

        }

        public void GLEmployeCoverg(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(gl_OptCoverages_tab);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("GL_OptCoverages").get(0), gl_OptCoverages_DrpDwn);
            browserUtil.clicksWebElement(gl_addCoverage_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.entersTextWithTabIn(gl_premium_textBox, map.get("Premium").get(0));
            Thread.sleep(2000);
            browserUtil.entersTextWithTabIn(gl_aggregate_Limit_textbox_Emp, map.get("Aggregate_Limit1").get(0));
            Thread.sleep(2000);
            browserUtil.entersTextWithTabIn(gl_Other_Limit_textbox, map.get("Other_Limit").get(0));
            browserUtil.entersTextWithTabIn(gl_Exposure_textbox, map.get("Exposure_Coveg").get(0));
            browserUtil.entersTextWithTabIn(gl_Territory_textbox, map.get("Territory").get(0));

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

        public void GLCompositeType2(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(gl_composite_tab);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("Composite_Type2").get(0), gl_compositetype2_dropdown);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("Class2").get(0), gl_class2_dropdown);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("Prem_Basis2").get(0), gl_premBasis2_dropdown);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("Rating_Basis2").get(0), gl_ratingBasis2_dropdown);
            browserUtil.waitUntilPleaseWaitDisappear();

        }

        //Method for CP_GL Optional coverage
        public void CPGL_OptCoverage(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(gl_OptCoverages_tab);
            browserUtil.waitUntilPleaseWaitDisappear();

            for (int i = 0; i < map.get("GLCP_OptCoverages").size(); i++) {
                String action = map.get("GLCP_OptCoverages").get(i);
                switch (action) {

                    case "Data Breach Coverage":
                        browserUtil.CMPDropDown("DTBR;GlPolDataBreachHTML", gl_OptCoverages_DrpDwn);
                        browserUtil.clicksWebElement(gl_addCoverage_Button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("Exclusion_Type").get(0), glcp_Exclusion_Type_Drpdwn);
                        baseUtil.clicksOnSave();
                        break;

                    case "Fungi or Bacteria Exclusion":
                        browserUtil.CMPDropDown("FUNG;GlPolFungiHTML", gl_OptCoverages_DrpDwn);
                        browserUtil.clicksWebElement(gl_addCoverage_Button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("Fungi_Bacteria_Type").get(0),  glcp_Fungi_Bacteria_Type_Drpdwn);
                        browserUtil.entersTextWithTabIn(glcp_Fungi_Bacteria_Limit_txtbox,map.get("Fungi_Bacteria_Limit").get(0));
                        baseUtil.clicksOnSave();
                        break;

                    default:
                        break;
                }

            }


        }
    }


    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public GeneralLiability_Page.GeneralLiabMethods theUser_() {
        return this.pageMethods;
    }

}