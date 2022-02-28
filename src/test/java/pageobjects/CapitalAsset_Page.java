package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunraj on 31/01/2022.
 */
public class CapitalAsset_Page extends TestFramework_Initializer {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private Synchronization_Util synchronizationUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private CapitalAsset_Page.CapitalAssetMethods pageMethods;
    private String parent;


    public CapitalAsset_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new CapitalAsset_Page.CapitalAssetMethods();
    }

    public interface ICapitalAsset {
        List cap_searchCLM_button = Arrays.asList(By.id("OpPolicyHTML_cmdClassHelp"), "Capital Asset Page", "search CLM");
        List cap_grpNoSearchBy_DrpDwn = Arrays.asList(By.xpath("//label[normalize-space()='Search by:']/../following-sibling::div[1]//span/input"), "Capital Asset Page", "grpNoSearchBy_DrpDwn");
        List cap_grpNoSearchCriteria_Textbox = Arrays.asList(By.xpath("//label[normalize-space()='Search Criteria:']/../following-sibling::div[1]//span/input"), "Capital Asset Page", "grpNoSearchCriteria");
        List cap_grpNoSearch_Button = Arrays.asList(By.id("OpPolClassLookupHTML_cmdSearch"), "Capital Asset Page", "Group Number Search button");
        List cap_grpNoSelect_radioButton = Arrays.asList(By.id("dgCLMFile_Select_row0"), "Capital Asset Page", "Group Number Select radio button");
        List cap_grpNoSelect_Button = Arrays.asList(By.id("OpPolClassLookupHTML_cmdSelect"), "Capital Asset Page", "Group Number Select button");
        List cap_deductible_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_DedAmt_LST_comboboxinput']"), "Capital Asset Page", "Deductible Dropdown");
        List cap_Valuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_ValuationCd_LST_comboboxinput']"), "Capital Asset Page", "Valuation Dropdown");
        List cap_AutoIncrease_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_AutoIncPct_LST_comboboxinput']"), "Capital Asset Page", "Auto Increase Dropdown");
        List cap_Coinsurancee_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_CoinsCd_LST_comboboxinput']"), "Capital Asset Page", "Coinsurance Dropdown");
        List cap_BlanketInfo_Tab = Arrays.asList(By.xpath("//span[@title='Blanket Info']//parent::li"), "Capital Asset Page", "Blanket Info Tab");
        List cap_AddBlanketGroup_Button = Arrays.asList(By.id("OpPolBlanketsEdit_dgPolBlankets_Row_AddNew"), "Capital Asset Page", "Add Blanket Group Button");
        List cap_BlanketType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_BlktTypeCd_LST_comboboxinput']"), "Capital Asset Page", "Blanket Type Dropdown");
        List cap_Limit_Textbox = Arrays.asList(By.id("OpPolBlanketHTML_OpPolBlktInput_BlktLmt_FLD"), "Capital Asset Page", "Limit Textbox");
        List cap_BlanketValuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_ValuationCd_LST_comboboxinput']"), "Capital Asset Page", "Blanket Valuation Dropdown");
        List cap_BldgValue_Textbox = Arrays.asList(By.id("OpPolBlanketHTML_OpPolBlktCovgInput_ValLmt_FLD"), "Capital Asset Page", "Bldg Value Textbox");
        List cap_OptCovgs_Tab = Arrays.asList(By.xpath("//span[@title='Opt Covgs']//parent::li"), "Capital Asset Page", "Opt Covgs Tab");
        List cap_BPPvalue_Textbox = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktCovgInput_BPP1_ValLmt_FLD']"), "Capital Asset Page", " BPP Value Textbox");
      //  List cap_BPPBlanketValuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_ValuationCd_LST_comboboxinput']"), "Capital Asset Page", " BPP Blanket Valuation Dropdown");

        List cap_OptCovgs_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgsEdit_cboAddCoverage_comboboxinput']"), "Optional Cvg Page", "Opt Covgs Dropdown");
        List cap_AddCoverage_Button = Arrays.asList(By.id("OpPolCovgsEdit_dgPolCovgList_Row_AddNew"), "Optional Cvg Page", "Add Coverage");
        //Equipment Break Down Coverage
        List cap_limit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Limit Textbox");
        List cap_ammoniaLimit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc1Tx_FLD"), "Optional Cvg Page", "Ammonia Limit");
        List cap_HazSubstanceLimit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc2Tx_FLD"), "Optional Cvg Page", "Haz Substance Limit");
        List cap_DollarDeductible_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc3Tx_FLD"), "Optional Cvg Page", "Dollar Deductible");
        List cap_TimeDeductible_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc4Tx_FLD"), "Optional Cvg Page", "Time Deductible");
        //Off Covered Location Interruption of Business
        List cap_CoverageType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_MiscTypeCd_LST_comboboxinput']"), "Optional Cvg Page", "Coverage Type Dropdown");
        List cap_BlanketLimit_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Blanket Limit");
        List cap_BusinessInterruptionExposure_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_Covg2Lmt_FLD"), "Optional Cvg Page", "Business Interruption Exposure");
        List cap_TotalLimitforScheduledProperty_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_Covg1Lmt_FLD"), "Optional Cvg Page", "Total Limit for Scheduled Property");
        List cap_Collision_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_InclInd_LST_comboboxinput']"), "Optional Cvg Page", "Collision Dropdown");
        List cap_WindExcl_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_ExclInd_LST_comboboxinput']"), "Optional Cvg Page", "Wind Excl");
        List cap_ExtBusinessIncomeNoOfDays_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_ExtNoDaysCt_LST_comboboxinput']"), "Optional Cvg Page", "ExtBusinessIncomeNoOfDays");
        List cap_WaitingPeriod_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_TimePeriodCt_LST_comboboxinput']"), "Optional Cvg Page", " Waiting Period");
        List cap_DescOfBusiness_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_MiscDesc_FLD"), "Optional Cvg Page", "Desc Of Business");
        //Limited Fungi or Bacteria
        List cap_FungiRevisedNoOfDays_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgLfunHTML_OpPolCovgInput_TimePeriodCt_LST_comboboxinput']"), "Optional Cvg Page", " FungiRevisedNoOfDays");
        List cap_FungiLimit_Textbox = Arrays.asList(By.id("OpPolCovgLfunHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "FungiLimit");
        //Dependent Properties
        List cap_SoleSource_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_CovgTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "Sole Source");
        List cap_LimitedorBroad_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_MiscTypeCd_LST_comboboxinput']"), "Optional Cvg Page", "Limited or Broad");
        List cap_SecondaryLocations_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_ChargeTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "Sole Source");
        //Cyber Incident Excl with Ensuing COL Exceptions
        List cap_LossorDamageToCoveredProperty_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Loss or Damage To Covered Property");
        List cap_BusinessIncomeandExtraExpense_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_Covg1Lmt_FLD"), "Optional Cvg Page", "Business Income and Extra Expense");
        List cap_AggregateLimit_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_Covg2Lmt_FLD"), "Optional Cvg Page", "Aggregate Limit");
        //Federal Terrorism
        List cap_SystemCalc_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgTrsmHTML_OpPolCovgInput_ChargeTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "System Calc Dropdown");
        List cap_NBCExclusion_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgTrsmHTML_OpPolCovgInput_NBCExclInd_LST_comboboxinput']"), "Optional Cvg Page", "NBC Exclusion Dropdown");
    }

    public class CapitalAssetMethods implements CapitalAsset_Page.ICapitalAsset {

        public void enterCapitalAssetPolicyDetail(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CAP_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("Capital Asset");
                browserUtil.waitUntilPleaseWaitDisappear();
                parent = browserUtil.getWindowHandle();
                browserUtil.clicksWebElement(cap_searchCLM_button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                browserUtil.CMPDropDown(map.get("groupNoSearchBy").get(0), cap_grpNoSearchBy_DrpDwn);
                browserUtil.entersTextWithTabIn(cap_grpNoSearchCriteria_Textbox, map.get("grpNoValue").get(0));
                browserUtil.clicksWebElement(cap_grpNoSearch_Button);
                Thread.sleep(3000);
                browserUtil.clicksWebElement(cap_grpNoSelect_radioButton);
                browserUtil.clicksWebElement(cap_grpNoSelect_Button);
                browserUtil.switchToWindowWithHandle(parent);

                browserUtil.CMPDropDown(map.get("CAP_Deductible").get(0), cap_deductible_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_Valuation").get(0), cap_Valuation_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_Coinsurance").get(0), cap_Coinsurancee_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_AutoIncrease").get(0), cap_AutoIncrease_DrpDwn);

                if (map.get("CAP_BlanketInfo_Flag").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(cap_BlanketInfo_Tab);
                    browserUtil.clicksWebElement(cap_AddBlanketGroup_Button);
                    browserUtil.CMPDropDown(map.get("BlanketTypeDrpDwn").get(0), cap_BlanketType_DrpDwn);
                    browserUtil.entersTextWithTabIn(cap_Limit_Textbox, map.get("BlanketLimit").get(0));
                    browserUtil.CMPDropDown(map.get("BlanketValDrpDwn").get(0), cap_BlanketValuation_DrpDwn);
                    browserUtil.entersTextWithTabIn(cap_BldgValue_Textbox, map.get("BlanketBldgValue").get(0));
                    //browserUtil.entersTextWithTabIn(cap_BPPvalue_Textbox, map.get("BlanketBPPValue").get(0));

                }
            }
        }

        public void addOptionalCovgs(Map<String, List<String>> map, String ScenarioName) {
            browserUtil.clicksWebElement(cap_OptCovgs_Tab);
            Map<String, List<String>> testDataAsMap;
            String excelFileName;
            String excelFilePath;
            excelFileName = "CAP_Coverages";
            excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
            testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "Optional");
            int rowNo = 0;
            for (int tcNo = 0; tcNo < testDataAsMap.get("ScenarioName").size(); tcNo++) {
                if (testDataAsMap.get("ScenarioName").get(tcNo).equalsIgnoreCase(ScenarioName)) {
                    rowNo = tcNo;
                    //break;
                }
            }
            for (int i = 0; i < map.get("OptionalCovgs").size(); i++) {
                String action = map.get("OptionalCovgs").get(i);
                switch (action) {
                    case "Equipment Breakdown Coverage":
                        browserUtil.CMPDropDown("EQBC;OpPolCovgEQBCHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);
                        browserUtil.entersTextWithTabIn(cap_limit_EquipmentBreakdown_Textbox, testDataAsMap.get("LimitEqupBrkDwn").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_ammoniaLimit_EquipmentBreakdown_Textbox, testDataAsMap.get("Ammonia_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_HazSubstanceLimit_EquipmentBreakdown_Textbox, testDataAsMap.get("Has_Substance_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_DollarDeductible_EquipmentBreakdown_Textbox, testDataAsMap.get("Dollar_Deductible").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_TimeDeductible_EquipmentBreakdown_Textbox, testDataAsMap.get("Time_Deductible").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Off Covered Location Interruption of Business":
                        browserUtil.CMPDropDown("OLVM;OpPolCovgOLVMHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("Coverage_Type").get(rowNo), cap_CoverageType_DrpDwn);
                        browserUtil.entersTextWithTabIn(cap_BlanketLimit_Textbox, testDataAsMap.get("Blanket_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_BusinessInterruptionExposure_Textbox, testDataAsMap.get("BusinessInterruptExposure").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_TotalLimitforScheduledProperty_Textbox, testDataAsMap.get("TotalLimitforScheduledProperty").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("Collison").get(rowNo), cap_Collision_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("WindExcl").get(rowNo), cap_WindExcl_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("ExtBusinessIncomeNoOfDays").get(rowNo), cap_ExtBusinessIncomeNoOfDays_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("WaitingPeriod").get(rowNo), cap_WaitingPeriod_DrpDwn);
                        browserUtil.entersTextWithTabIn(cap_DescOfBusiness_Textbox, testDataAsMap.get("DescOfBusiness").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Limited Fungi or Bacteria":
                       /* browserUtil.CMPDropDown("LFUN;OpPolCovgLfunHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);*/
                        //below line of code is temporary....change the logic once issue will solve.
                        browserUtil.driver.findElement(By.xpath("//td/a[normalize-space()='Limited Fungi or Bacteria']")).click();
                        browserUtil.entersTextWithTabIn(cap_FungiLimit_Textbox, testDataAsMap.get("FungiLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("FungiRevisedNoOfDays").get(rowNo), cap_FungiRevisedNoOfDays_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Dependent Properties":
                        browserUtil.CMPDropDown("BIDP;OpPolCovgBidpHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("SoleSource").get(rowNo), cap_SoleSource_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("LimitedorBroad").get(rowNo), cap_LimitedorBroad_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("SecondaryLocations").get(rowNo), cap_SecondaryLocations_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Federal Terrorism":
                        browserUtil.CMPDropDown("TRSM;OpPolCovgTrsmHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("SystemCalc").get(rowNo), cap_SystemCalc_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("NBCExclusion").get(rowNo), cap_NBCExclusion_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Cyber Incident Excl with Ensuing COL Exceptions":
                        browserUtil.CMPDropDown("CYEX;OpPolCovgCYEXHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);
                        browserUtil.entersTextWithTabIn(cap_LossorDamageToCoveredProperty_Textbox, testDataAsMap.get("LossorDamageToCoveredProperty").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_BusinessIncomeandExtraExpense_Textbox, testDataAsMap.get("BusinessIncomeandExtraExpense").get(rowNo));
                        browserUtil.entersTextWithTabIn(cap_AggregateLimit_Textbox, testDataAsMap.get("AggregateLimit").get(rowNo));
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

    public CapitalAsset_Page.CapitalAssetMethods theUser_() {
        return this.pageMethods;
    }

}