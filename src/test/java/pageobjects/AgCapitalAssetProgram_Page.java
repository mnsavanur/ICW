package pageobjects;

import org.openqa.selenium.By;
import utilities.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Sunraj on 31/01/2022.
 */
public class AgCapitalAssetProgram_Page extends TestFramework_Initializer {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private Synchronization_Util synchronizationUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private AgCapitalAssetProgram_Page.AgCAPMethods pageMethods;
    private String parent;

    public AgCapitalAssetProgram_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new AgCapitalAssetProgram_Page.AgCAPMethods();
    }
    //ICapitalAsset - changed to IAgCap
    public interface IAgCap {
        List agcap_searchCLM_button = Arrays.asList(By.id("OpPolicyHTML_cmdClassHelp"), "Agriculture Capital Asset Program Page", "search CLM");
        List agcap_grpNoSearchBy_DrpDwn = Arrays.asList(By.xpath("//label[normalize-space()='Search by:']/../following-sibling::div[1]//span/input"), "Agriculture Capital Asset Program Page", "grpNoSearchBy_DrpDwn");
        List agcap_grpNoSearchCriteria_Textbox = Arrays.asList(By.xpath("//label[normalize-space()='Search Criteria:']/../following-sibling::div[1]//span/input"), "Agriculture Capital Asset Program Page", "grpNoSearchCriteria");
        List agcap_grpNoSearch_Button = Arrays.asList(By.id("OpPolClassLookupHTML_cmdSearch"), "Agriculture Capital Asset Program Page", "Group Number Search button");
        List agcap_grpNoSelect_radioButton = Arrays.asList(By.id("dgCLMFile_Select_row0"), "Agriculture Capital Asset Program Page", "Group Number Select radio button");
        List agcap_grpNoSelect_Button = Arrays.asList(By.id("OpPolClassLookupHTML_cmdSelect"), "Agriculture Capital Asset Program Page", "Group Number Select button");
        List agcap_deductible_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_DedAmt_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Deductible Dropdown");
        List agcap_Valuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_ValuationCd_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Valuation Dropdown");
        List agcap_AutoIncrease_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_AutoIncPct_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Auto Increase Dropdown");
        List agcap_Coinsurancee_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolicyHTML_OpPolInput_CoinsCd_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Coinsurance Dropdown");
        List agcap_BlanketInfo_Tab = Arrays.asList(By.xpath("//span[@title='Blanket Info']//parent::li"), "Agriculture Capital Asset Program Page", "Blanket Info Tab");
        List agcap_AddBlanketGroup_Button = Arrays.asList(By.id("OpPolBlanketsEdit_dgPolBlankets_Row_AddNew"), "Agriculture Capital Asset Program Page", "Add Blanket Group Button");
        List agcap_BlanketType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_BlktTypeCd_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Blanket Type Dropdown");
        List agcap_Limit_Textbox = Arrays.asList(By.id("OpPolBlanketHTML_OpPolBlktInput_BlktLmt_FLD"), "Agriculture Capital Asset Program Page", "Limit Textbox");
        List agcap_BlanketValuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_ValuationCd_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", "Blanket Valuation Dropdown");
        List agcap_BldgValue_Textbox = Arrays.asList(By.id("OpPolBlanketHTML_OpPolBlktCovgInput_ValLmt_FLD"), "Agriculture Capital Asset Program Page", "Bldg Value Textbox");
        List agcap_OptCovgs_Tab = Arrays.asList(By.xpath("//span[@title='Opt Covgs']//parent::li"), "Agriculture Capital Asset Program Page", "Opt Covgs Tab");
        List agcap_BPPvalue_Textbox = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktCovgInput_BPP1_ValLmt_FLD']"), "Agriculture Capital Asset Program Page", " BPP Value Textbox");
      //  List cap_BPPBlanketValuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolBlanketHTML_OpPolBlktInput_ValuationCd_LST_comboboxinput']"), "Agriculture Capital Asset Program Page", " BPP Blanket Valuation Dropdown");

        List agcap_OptCovgs_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgsEdit_cboAddCoverage_comboboxinput']"), "Optional Cvg Page", "Opt Covgs Dropdown");
        List agcap_AddCoverage_Button = Arrays.asList(By.id("OpPolCovgsEdit_dgPolCovgList_Row_AddNew"), "Optional Cvg Page", "Add Coverage");
        //Equipment Break Down Coverage
        List agcap_limit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Limit Textbox");
        List agcap_ammoniaLimit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc1Tx_FLD"), "Optional Cvg Page", "Ammonia Limit");
        List agcap_HazSubstanceLimit_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc2Tx_FLD"), "Optional Cvg Page", "Haz Substance Limit");
        List agcap_DollarDeductible_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc3Tx_FLD"), "Optional Cvg Page", "Dollar Deductible");
        List agcap_TimeDeductible_EquipmentBreakdown_Textbox = Arrays.asList(By.id("OpPolCovgEQBCHTML_OpPolCovgInput_Misc4Tx_FLD"), "Optional Cvg Page", "Time Deductible");
        //Off Covered Location Interruption of Business
        List agcap_CoverageType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_MiscTypeCd_LST_comboboxinput']"), "Optional Cvg Page", "Coverage Type Dropdown");
        List agcap_BlanketLimit_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Blanket Limit");
        List agcap_BusinessInterruptionExposure_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_Covg2Lmt_FLD"), "Optional Cvg Page", "Business Interruption Exposure");
        List agcap_TotalLimitforScheduledProperty_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_Covg1Lmt_FLD"), "Optional Cvg Page", "Total Limit for Scheduled Property");
        List agcap_Collision_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_InclInd_LST_comboboxinput']"), "Optional Cvg Page", "Collision Dropdown");
        List agcap_WindExcl_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_ExclInd_LST_comboboxinput']"), "Optional Cvg Page", "Wind Excl");
        List agcap_ExtBusinessIncomeNoOfDays_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_ExtNoDaysCt_LST_comboboxinput']"), "Optional Cvg Page", "ExtBusinessIncomeNoOfDays");
        List agcap_WaitingPeriod_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgOLVMHTML_OpPolCovgInput_TimePeriodCt_LST_comboboxinput']"), "Optional Cvg Page", " Waiting Period");
        List agcap_DescOfBusiness_Textbox = Arrays.asList(By.id("OpPolCovgOLVMHTML_OpPolCovgInput_MiscDesc_FLD"), "Optional Cvg Page", "Desc Of Business");
        //Limited Fungi or Bacteria
        List agcap_FungiRevisedNoOfDays_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgLfunHTML_OpPolCovgInput_TimePeriodCt_LST_comboboxinput']"), "Optional Cvg Page", " FungiRevisedNoOfDays");
        List agcap_FungiLimit_Textbox = Arrays.asList(By.id("OpPolCovgLfunHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "FungiLimit");
        //Dependent Properties
        List agcap_SoleSource_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_CovgTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "Sole Source");
        List agcap_LimitedorBroad_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_MiscTypeCd_LST_comboboxinput']"), "Optional Cvg Page", "Limited or Broad");
        List agcap_SecondaryLocations_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgBidpHTML_OpPolCovgInput_ChargeTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "Sole Source");
        //Cyber Incident Excl with Ensuing COL Exceptions
        List agcap_LossorDamageToCoveredProperty_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_LimitAmt_FLD"), "Optional Cvg Page", "Loss or Damage To Covered Property");
        List agcap_BusinessIncomeandExtraExpense_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_Covg1Lmt_FLD"), "Optional Cvg Page", "Business Income and Extra Expense");
        List agcap_AggregateLimit_Textbox = Arrays.asList(By.id("OpPolCovgCYEXHTML_OpPolCovgInput_Covg2Lmt_FLD"), "Optional Cvg Page", "Aggregate Limit");
        //Federal Terrorism
        List agcap_SystemCalc_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgTrsmHTML_OpPolCovgInput_ChargeTypeInd_LST_comboboxinput']"), "Optional Cvg Page", "System Calc Dropdown");
        List agcap_NBCExclusion_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpPolCovgTrsmHTML_OpPolCovgInput_NBCExclInd_LST_comboboxinput']"), "Optional Cvg Page", "NBC Exclusion Dropdown");
    }
//CapitalAssetProgramMethods renamed to AgCAPMethods
    public class AgCAPMethods implements AgCapitalAssetProgram_Page.IAgCap {
//enterCapitalAssetPolicyDetail rename to enterAgCAPPolicyDetail
        public void enterAgCAPPolicyDetail(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CAP_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("Agricultural Capital Asset Program");
                browserUtil.waitUntilPleaseWaitDisappear();
                parent = browserUtil.getWindowHandle();
                browserUtil.clicksWebElement(agcap_searchCLM_button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                browserUtil.CMPDropDown(map.get("groupNoSearchBy").get(0), agcap_grpNoSearchBy_DrpDwn);
                browserUtil.entersTextWithTabIn(agcap_grpNoSearchCriteria_Textbox, map.get("grpNoValue").get(0));
                browserUtil.clicksWebElement(agcap_grpNoSearch_Button);
                Thread.sleep(3000);
                browserUtil.clicksWebElement(agcap_grpNoSelect_radioButton);
                browserUtil.clicksWebElement(agcap_grpNoSelect_Button);
                browserUtil.switchToWindowWithHandle(parent);

                browserUtil.CMPDropDown(map.get("CAP_Deductible").get(0), agcap_deductible_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_Valuation").get(0), agcap_Valuation_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_Coinsurance").get(0), agcap_Coinsurancee_DrpDwn);
                browserUtil.CMPDropDown(map.get("CAP_AutoIncrease").get(0), agcap_AutoIncrease_DrpDwn);

                if (map.get("CAP_BlanketInfo_Flag").get(0).equalsIgnoreCase("Yes")) {
                    browserUtil.clicksWebElement(agcap_BlanketInfo_Tab);
                    browserUtil.clicksWebElement(agcap_AddBlanketGroup_Button);
                    browserUtil.CMPDropDown(map.get("BlanketTypeDrpDwn").get(0), agcap_BlanketType_DrpDwn);
                    browserUtil.entersTextWithTabIn(agcap_Limit_Textbox, map.get("BlanketLimit").get(0));
                    browserUtil.CMPDropDown(map.get("BlanketValDrpDwn").get(0), agcap_BlanketValuation_DrpDwn);
                    browserUtil.entersTextWithTabIn(agcap_BldgValue_Textbox, map.get("BlanketBldgValue").get(0));
                    //browserUtil.entersTextWithTabIn(cap_BPPvalue_Textbox, map.get("BlanketBPPValue").get(0));

                }
            }
        }

        public void addOptionalCovgs(Map<String, List<String>> map, String ScenarioName) {
            browserUtil.clicksWebElement(agcap_OptCovgs_Tab);
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
                        browserUtil.CMPDropDown("EQBC;OpPolCovgEQBCHTML", agcap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(agcap_AddCoverage_Button);
                        browserUtil.entersTextWithTabIn(agcap_limit_EquipmentBreakdown_Textbox, testDataAsMap.get("LimitEqupBrkDwn").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_ammoniaLimit_EquipmentBreakdown_Textbox, testDataAsMap.get("Ammonia_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_HazSubstanceLimit_EquipmentBreakdown_Textbox, testDataAsMap.get("Has_Substance_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_DollarDeductible_EquipmentBreakdown_Textbox, testDataAsMap.get("Dollar_Deductible").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_TimeDeductible_EquipmentBreakdown_Textbox, testDataAsMap.get("Time_Deductible").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Off Covered Location Interruption of Business":
                        browserUtil.CMPDropDown("OLVM;OpPolCovgOLVMHTML", agcap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(agcap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("Coverage_Type").get(rowNo), agcap_CoverageType_DrpDwn);
                        browserUtil.entersTextWithTabIn(agcap_BlanketLimit_Textbox, testDataAsMap.get("Blanket_Limit").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_BusinessInterruptionExposure_Textbox, testDataAsMap.get("BusinessInterruptExposure").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_TotalLimitforScheduledProperty_Textbox, testDataAsMap.get("TotalLimitforScheduledProperty").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("Collison").get(rowNo), agcap_Collision_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("WindExcl").get(rowNo), agcap_WindExcl_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("ExtBusinessIncomeNoOfDays").get(rowNo), agcap_ExtBusinessIncomeNoOfDays_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("WaitingPeriod").get(rowNo), agcap_WaitingPeriod_DrpDwn);
                        browserUtil.entersTextWithTabIn(agcap_DescOfBusiness_Textbox, testDataAsMap.get("DescOfBusiness").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Limited Fungi or Bacteria":
                       /* browserUtil.CMPDropDown("LFUN;OpPolCovgLfunHTML", cap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(cap_AddCoverage_Button);*/
                        //below line of code is temporary....change the logic once issue will solve.
                        browserUtil.driver.findElement(By.xpath("//td/a[normalize-space()='Limited Fungi or Bacteria']")).click();
                        browserUtil.entersTextWithTabIn(agcap_FungiLimit_Textbox, testDataAsMap.get("FungiLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("FungiRevisedNoOfDays").get(rowNo), agcap_FungiRevisedNoOfDays_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Dependent Properties":
                        browserUtil.CMPDropDown("BIDP;OpPolCovgBidpHTML", agcap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(agcap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("SoleSource").get(rowNo), agcap_SoleSource_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("LimitedorBroad").get(rowNo), agcap_LimitedorBroad_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("SecondaryLocations").get(rowNo), agcap_SecondaryLocations_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Federal Terrorism":
                        browserUtil.CMPDropDown("TRSM;OpPolCovgTrsmHTML", agcap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(agcap_AddCoverage_Button);
                        browserUtil.CMPDropDown(testDataAsMap.get("SystemCalc").get(rowNo), agcap_SystemCalc_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("NBCExclusion").get(rowNo), agcap_NBCExclusion_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Cyber Incident Excl with Ensuing COL Exceptions":
                        browserUtil.CMPDropDown("CYEX;OpPolCovgCYEXHTML", agcap_OptCovgs_DrpDwn);
                        browserUtil.clicksWebElement(agcap_AddCoverage_Button);
                        browserUtil.entersTextWithTabIn(agcap_LossorDamageToCoveredProperty_Textbox, testDataAsMap.get("LossorDamageToCoveredProperty").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_BusinessIncomeandExtraExpense_Textbox, testDataAsMap.get("BusinessIncomeandExtraExpense").get(rowNo));
                        browserUtil.entersTextWithTabIn(agcap_AggregateLimit_Textbox, testDataAsMap.get("AggregateLimit").get(rowNo));
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

    public AgCapitalAssetProgram_Page.AgCAPMethods theUser_() {
        return this.pageMethods;
    }

}