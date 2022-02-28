package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.*;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.util.*;

/**
 * Created by Sunraj Mane on 31/01/2022.
 */
public class CAPLocations_Page extends TestFramework_Initializer {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private CAPLocations_Page.CAPLocationsMethods pageMethods;
    private String parent;

    public CAPLocations_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new CAPLocations_Page.CAPLocationsMethods();
    }

    public interface ICAPLocations {
        String pageName = "CAP Locations";

        List lp_accountingDeptEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_AcctEmailAddrTx_FLD"), pageName, "Accounting Dept Email Address");
        List lp_claimsEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_ClaimEmailAddrTx_FLD"), pageName, "Claims Email Address");
        List lp_lossControlEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_LCEmailAddrTx_FLD"), pageName, "Loss Control Email Address");
        List lp_protectionClass_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocationDetailHTML_OpLocInput_ProtClassCd_LST_comboboxinput']"), pageName, "Protection Class");
        List lp_cspTerr_Textbox = Arrays.asList(By.id("OpLocationDetailHTML_OpLocInput_TerritoryCd_FLD"), pageName, "CSP Terr");
        List lp_construction_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocationDetailHTML_OpLocInput_ConstSymbolCd_LST_comboboxinput']"), pageName, "Construction");
        List lp_addCoverage_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocCovgsEdit_cboAddCoverage_comboboxinput']"), pageName, "Coverage DrpDwn");
        List lp_addCoverage_Button = Arrays.asList(By.id("OpLocCovgsEdit_dgLocCovgList_Row_AddNew"), pageName, "Add Coverage Button");
        List lp_BlanketGrpNo_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_BlktGrpNo_FLD"), pageName, "BlanketGrpNo");
        List lp_Coverage_Tab = Arrays.asList(By.xpath("//li[@title='Coverages']"), pageName, "Coverage Tab");
        List lp_Wind_Ded_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocationDetailHTML_OpLocInput_WindDedPct_LST_comboboxinput']"), pageName, "Wind % Ded");

        List gl_addLocation_button = Arrays.asList(By.xpath("//button[contains(.,'Add Location')]"), pageName, "Add Location");
        List gl_locationNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Location No:')]/..//following-sibling::div[1]//input"), pageName, "Location No");
        List gl_buildingNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Building No:')]/..//following-sibling::div[1]//input"), pageName, "Building No");
        List gl_streetAddress_textBox = Arrays.asList(By.xpath("//label[contains(.,'Street Address:')]/..//following-sibling::div[1]//input"), pageName, "Street Address");
        List gl_city_textBox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), pageName, "City");
        List gl_country_textBox = Arrays.asList(By.id("CoLocBldgAddSelectHTML_CoLocation_CountyNm_FLD"), pageName, "Country");
        List gl_zipCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), pageName, "Zip Code");
        List gl_saveAndClose_button = Arrays.asList(By.xpath("//button[contains(.,'Save and Close')]"), pageName, "Save and Close");

        List lp_FldCvgType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocFlodHTML_OpLocCovgInput_MiscTypeCd_LST_comboboxinput']"), pageName, "FldCvgType_DrpDwn");
        List lp_FldBldLimit_Textbox = Arrays.asList(By.id("OpLocFlodHTML_OpLocCovgInput_Limit2Amt_FLD"), pageName, "Flood Building Limit");
        //Building
        List lp_BldgBlanketGrpNo_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_BlktGrpNo_FLD"), "Location Coverages", "BlanketGrpNo");
        List lp_Limit_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_LimitAmt_FLD"), "Location Coverages", "Limit");
        List lp_Valuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_ValuationCd_LST_comboboxinput']"), "Location Coverages", "Valuation");
        List lp_DedFactor_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_DedOvrdFct_FLD"), "Location Coverages", "Ded Factor");
        List lp_IncreaseinRebuildingExpenses_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_IncRebuildPct_FLD"), "Location Coverages", "Increase in Rebuilding Expenses");
        List lp_MaximumAmountLimit_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_Limit2Amt_FLD"), "Location Coverages", "Maximum Amount Limit");
        List lp_RelatedExpensesLimit_Textbox = Arrays.asList(By.id("OpLocBldgHTML_OpLocCovgInput_Limit3Amt_FLD"), "Location Coverages", "Related Expenses Limit");
        List lp_BldgCovgType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_CovgTypeCd_LST_comboboxinput']"), "Location Coverages", "Bldg Covg Type");
        List lp_MiscInd_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_MiscTypeCd_LST_comboboxinput']"), "Location Coverages", "Misc Ind");
        List lp_DeductibleOvrd_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_DedOvrdAmt_LST_comboboxinput']"), "Location Coverages", "Deductible Ovrd");
        List lp_AgreedValue_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_AgreedValInd_LST_comboboxinput']"), "Location Coverages", "Agreed Value");
        List lp_CoinsuranceOvrd_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_CoinsCd_LST_comboboxinput']"), "Location Coverages", "Coinsurance Ovrd");
        List lp_LimitationsOnRoofSurfacing_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_Misc1Tx_LST_comboboxinput']"), "Location Coverages", "Limitations on Roof Surfacing");
        List lp_IncrCostOfLossPercent_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBldgHTML_OpLocCovgInput_GrUpIncCostLossPct_LST_comboboxinput']"), "Location Coverages", "Incr Cost of Loss Percent:");
        //Earthquake
        List lp_BuildingLimit_TextBox = Arrays.asList(By.id("OpLocErtqHTML_OpLocCovgInput_Limit2Amt_FLD"), "Location Coverages", "Building Limit");
        List lp_BPPLimit_TextBox = Arrays.asList(By.id("OpLocErtqHTML_OpLocCovgInput_Limit3Amt_FLD"), "Location Coverages", "BPP Limit");
        List lp_BusinessIncomeLimit_TextBox = Arrays.asList(By.id("OpLocErtqHTML_OpLocCovgInput_Limit4Amt_FLD"), "Location Coverages", "Business Income Limit");
        List lp_DeductiblePercent_TextBox = Arrays.asList(By.id("OpLocErtqHTML_OpLocCovgInput_EqDedPct_FLD"), "Location Coverages", "Deductible %");
        List lp_MasonryVeneer_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocErtqHTML_OpLocCovgInput_MasVenrInd_LST_comboboxinput']"), "Location Coverages", "Masonry Veneer");
        List lp_EQSLOnly_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocErtqHTML_OpLocCovgInput_EqslOnlyInd_LST_comboboxinput']"), "Location Coverages", "EQSL Only");
        List lp_AnnlAggrOption_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocErtqHTML_OpLocCovgInput_EqAnnAggInd_LST_comboboxinput']"), "Location Coverages", "Annl Aggr Option");
        //Business Income & Extra Expense
        List lp_BIBlanketGrpNo_Textbox = Arrays.asList(By.id("OpLocBincHTML_OpLocCovgInput_BlktGrpNo_FLD"), "Location Coverages", "BlanketGrpNo");
        List lp_BICoverageType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_CovgTypeCd_LST_comboboxinput']"), "Location Coverages", "Coverage Type");
        List lp_BIRiskType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_MiscTypeCd_LST_comboboxinput']"), "Location Coverages", "Risk Type");
        List lp_BIMonthlyLimit_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_MonthLmtCd_LST_comboboxinput']"), "Location Coverages", "Monthly Limit");
        List lp_BIExtendedNoDays_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_ExtNoDaysCt_LST_comboboxinput']"), "Location Coverages", "Extended No. Days");
        List lp_BIEducationInstitution_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_EducInstInd_LST_comboboxinput']"), "Location Coverages", "Education Institution");
        List lp_BIOrdinaryPayrollLimit_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_OrdPayLmtCt_LST_comboboxinput']"), "Location Coverages", "Ordinary Payroll Limit");
        List lp_BIAgreedValue_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_AgreedValInd_LST_comboboxinput']"), "Location Coverages", "Agreed Value");
        List lp_BIMaximumIndemnity_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_MaxIndemInd_LST_comboboxinput']"), "Location Coverages", "Maximum Indemnity");
        List lp_BIPowerHeatRefrigeration_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_PHRInd_LST_comboboxinput']"), "Location Coverages", "Power, Heat, Refrigeration");
        List lp_BICoinsurance_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_CoinsCd_LST_comboboxinput']"), "Location Coverages", "Coinsurance");
        List lp_BIGreenUpgradesExtPeriodofRestoration_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBincHTML_OpLocCovgInput_GrUpExtPeriodCt_LST_comboboxinput']"), "Location Coverages", "Green Upgrades Ext. Period of Restoration");
        List lp_BILimit_TextBox = Arrays.asList(By.id("OpLocBincHTML_OpLocCovgInput_LimitAmt_FLD"), "Location Coverages", "Limit");
        List lp_BIExtendedRecoverPeriod_TextBox = Arrays.asList(By.id("OpLocBincHTML_OpLocCovgInput_ExtRecPerCt_FLD"), "Location Coverages", "Extended Recover Period");
        //Business Personal Property
        List lp_BPPBlanketGrpNo_Textbox = Arrays.asList(By.id("OpLocBppHTML_OpLocCovgInput_BlktGrpNo_FLD"), pageName, "BlanketGrpNo");
        List lp_BPPLimit_Textbox = Arrays.asList(By.id("OpLocBppHTML_OpLocCovgInput_LimitAmt_FLD"), "Location Coverages", "Limit");
        List lp_BPPCovgType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_CovgTypeCd_LST_comboboxinput']"), "Location Coverages", "Bldg Covg Type");
        List lp_BPPDeductibleOvrd_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_DedOvrdAmt_LST_comboboxinput']"), "Location Coverages", "Deductible Ovrd");
        List lp_BPPDedFactor_Textbox = Arrays.asList(By.id("OpLocBppHTML_OpLocCovgInput_DedOvrdFct_FLD"), "Location Coverages", "Ded Factor");
        List lp_BPPValuation_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_ValuationCd_LST_comboboxinput']"), "Location Coverages", "Valuation");
        List lp_BPPAgreedValue_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_AgreedValInd_LST_comboboxinput']"), "Location Coverages", "Agreed Value");
        List lp_BPPCoinsuranceOvrd_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_CoinsCd_LST_comboboxinput']"), "Location Coverages", "Coinsurance Ovrd");
        List lp_BPPMaximumAmountLimit_Textbox = Arrays.asList(By.id("OpLocBppHTML_OpLocCovgInput_Limit2Amt_FLD"), "Location Coverages", "Maximum Amount Limit");
        List lp_BPPRelatedExpensesLimit_Textbox = Arrays.asList(By.id("OpLocBppHTML_OpLocCovgInput_Limit3Amt_FLD"), "Location Coverages", "Related Expenses Limit");
        List lp_BPPIncrCostOfLossPercent_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocBppHTML_OpLocCovgInput_GrUpIncCostLossPct_LST_comboboxinput']"), "Location Coverages", "Incr Cost of Loss Percent:");
        // Spoilage
        List lp_SpoilageLimit_Textbox = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_LimitAmt_FLD']"), "Location Coverages", "Spoilage Limit");
        List lp_SpoilageCovgType_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_CovgTypeCd_LST_comboboxinput']"), "Location Coverages", "Coverage Type");
        List lp_SpoilageMaintanence_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_MainAgrInd_LST_comboboxinput']"), "Location Coverages", "Maintenance Agreement");
        List lp_SpoilageSellPrice_DrpDwn = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_SellPriceInd_LST_comboboxinput']"), "Location Coverages", "Selling Price");
        List lp_SpoilageDesc_Textbox = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_MiscDesc_FLD']"), "Location Coverages", "Description");
        List lp_spoilageDeductOver_Textbox = Arrays.asList(By.xpath("//input[@id='OpLocSplgHtml_OpLocCovgInput_DedOvrdAmt_FLD']"), "Location Coverages", "Deductible Override");
        //PCNM
        List lp_AddCoverage_Image = Arrays.asList(By.xpath("//td/i[@title='Add Coverage']"), "Location Page", "AddCoverage");

    }

    public class CAPLocationsMethods implements CAPLocations_Page.ICAPLocations {

        public void addLocations(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CAPLocation_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CAP LOCATIONS");
                parent = browserUtil.getWindowHandle();
                browserUtil.clicksWebElement(gl_addLocation_button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                browserUtil.entersTextWithTabIn(gl_locationNo_textBox, map.get("LocationNoCAP").get(0));
                browserUtil.entersTextWithTabIn(gl_buildingNo_textBox, map.get("BuildingNoCAP").get(0));
                browserUtil.entersTextWithTabIn(gl_streetAddress_textBox, map.get("StreetAddr").get(0));
                browserUtil.entersTextWithTabIn(gl_city_textBox, map.get("City").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(gl_country_textBox, map.get("Country").get(0));
                browserUtil.entersTextWithTabIn(gl_zipCode_textBox, map.get("ZipCode").get(0));
                browserUtil.clicksWebElement(gl_saveAndClose_button);
                browserUtil.switchToWindowWithHandle(parent);
            }
        }

        public void addLocationInfo(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.CMPDropDown(map.get("protClass").get(0), lp_protectionClass_DrpDwn);
            browserUtil.entersTextWithTabIn(lp_cspTerr_Textbox, map.get("cspTerr").get(0));
            browserUtil.CMPDropDown(map.get("Construction").get(0), lp_construction_DrpDwn);
            browserUtil.CMPDropDown(map.get("WindDed").get(0), lp_Wind_Ded_DrpDwn);
        }

        public void addCoverage(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(lp_Coverage_Tab);
            browserUtil.waitUntilPleaseWaitDisappear();
            if (map.get("BuildingCvgFlag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.CMPDropDown(map.get("BldgCoverageDrp").get(0), lp_addCoverage_DrpDwn);
                browserUtil.clicksWebElement(lp_addCoverage_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(lp_BlanketGrpNo_Textbox, map.get("BlanketGrpNo").get(0));
                browserUtil.entersTextWithTabIn(lp_Limit_Textbox, map.get("BlanketLimit").get(0));
                baseUtil.clicksOnSave();
            }

            if (map.get("FloodCvgFlag").get(0).equalsIgnoreCase("Yes")) {
                browserUtil.CMPDropDown(map.get("FloodCoverageDrp").get(0), lp_addCoverage_DrpDwn);
                browserUtil.clicksWebElement(lp_addCoverage_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(lp_FldBldLimit_Textbox, map.get("FldBldgLimit").get(0));
                browserUtil.CMPDropDown(map.get("FldCvgType").get(0), lp_FldCvgType_DrpDwn);
                baseUtil.clicksOnSave();
            }
        }

        public void addLocationCovgs(Map<String, List<String>> map,String ScenarioName) {
            browserUtil.clicksWebElement(lp_Coverage_Tab);
            browserUtil.waitUntilPleaseWaitDisappear();
            Map<String, List<String>> testDataAsMap;
            String excelFileName;
            String excelFilePath;
            excelFileName = "CAP_Coverages";
            excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
            testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "LocationCoverages");
            int rowNo=0;
            for(int tcNo=0;tcNo<testDataAsMap.get("ScenarioName").size();tcNo++)
            {
                if(testDataAsMap.get("ScenarioName").get(tcNo).equalsIgnoreCase(ScenarioName))
                {
                    rowNo=tcNo;
                    break;
                }
            }
            for (int i = 0; i < map.get("LocationCovgs").size(); i++) {
                String action = map.get("LocationCovgs").get(i);
                switch (action) {
                    case "Building":
                        browserUtil.CMPDropDown("BLDG;OpLocBldgHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(lp_BldgBlanketGrpNo_Textbox, testDataAsMap.get("BlanketGrpNo").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_Limit_Textbox, testDataAsMap.get("BlanketLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BldgCovgType").get(rowNo), lp_BldgCovgType_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("Valuation").get(rowNo), lp_Valuation_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("MiscInd").get(rowNo), lp_MiscInd_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("DeductibleOvrd").get(rowNo), lp_DeductibleOvrd_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_DedFactor_Textbox, testDataAsMap.get("DedFactor").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("AgreedValue").get(rowNo), lp_AgreedValue_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("CoinsuranceOvrd").get(rowNo), lp_CoinsuranceOvrd_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_IncreaseinRebuildingExpenses_Textbox, testDataAsMap.get("IncreaseinRebuildingExpenses").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("LimitationsOnRoofSurfacing").get(rowNo), lp_LimitationsOnRoofSurfacing_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_MaximumAmountLimit_Textbox, testDataAsMap.get("MaximumAmountLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("lp_IncrCostOfLossPercent").get(rowNo), lp_IncrCostOfLossPercent_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_RelatedExpensesLimit_Textbox, testDataAsMap.get("RelatedExpensesLimit").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Flood":
                        browserUtil.CMPDropDown("FLOD;OpLocFlodHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(lp_FldBldLimit_Textbox, testDataAsMap.get("FldBldgLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("FldCvgType").get(rowNo), lp_FldCvgType_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Earthquake":
                        browserUtil.CMPDropDown("ERTQ;OpLocErtqHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(lp_BlanketGrpNo_Textbox, testDataAsMap.get("BlanketGrpNo").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_BuildingLimit_TextBox, testDataAsMap.get("BuildingLimit").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_BPPLimit_TextBox, testDataAsMap.get("BPPLimit").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_BusinessIncomeLimit_TextBox, testDataAsMap.get("BusinessIncomeLimit").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_DeductiblePercent_TextBox, testDataAsMap.get("DeductiblePercent").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("MasonryVeneer").get(rowNo), lp_MasonryVeneer_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("EQSLOnly").get(rowNo), lp_EQSLOnly_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("AnnlAggrOption").get(rowNo), lp_AnnlAggrOption_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Business Income & Extra Expense":
                        browserUtil.CMPDropDown("BINC;OpLocBincHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.entersTextWithTabIn(lp_BIBlanketGrpNo_Textbox, testDataAsMap.get("BIBlanketGrpNo").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_BILimit_TextBox, testDataAsMap.get("BILimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BICoverageType").get(rowNo), lp_BICoverageType_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIRiskType").get(rowNo), lp_BIRiskType_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIMonthlyLimit").get(rowNo), lp_BIMonthlyLimit_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIMaximumIndemnity").get(rowNo), lp_BIMaximumIndemnity_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIExtendedNoDays").get(rowNo), lp_BIExtendedNoDays_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIEducationInstitution").get(rowNo), lp_BIEducationInstitution_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_BIExtendedRecoverPeriod_TextBox, testDataAsMap.get("BIExtendedRecoverPeriod").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BIOrdinaryPayrollLimit").get(rowNo), lp_BIOrdinaryPayrollLimit_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIPowerHeatRefrigeration").get(rowNo), lp_BIPowerHeatRefrigeration_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIAgreedValue").get(rowNo), lp_BIAgreedValue_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BICoinsurance").get(rowNo), lp_BICoinsurance_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BIGreenUpgradesExtPeriodofRestoration").get(rowNo), lp_BIGreenUpgradesExtPeriodofRestoration_DrpDwn);
                        baseUtil.clicksOnSave();
                        break;
                    case "Business Personal Property":
                        browserUtil.CMPDropDown("BPP1;OpLocBppHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.entersTextWithTabIn(lp_BPPBlanketGrpNo_Textbox, testDataAsMap.get("BPPBlanketGrpNo").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_BPPLimit_Textbox, testDataAsMap.get("BPPBlanketLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPCovgType").get(rowNo), lp_BPPCovgType_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPDeductibleOvrd").get(rowNo), lp_BPPDeductibleOvrd_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_BPPDedFactor_Textbox, testDataAsMap.get("BPPDedFactor").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPValuation").get(rowNo), lp_BPPValuation_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPCoinsuranceOvrd").get(rowNo), lp_BPPCoinsuranceOvrd_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPAgreedValue").get(rowNo), lp_BPPAgreedValue_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_BPPMaximumAmountLimit_Textbox, testDataAsMap.get("BPPMaximumAmountLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("BPPIncrCostOfLossPercent").get(rowNo), lp_BPPIncrCostOfLossPercent_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_BPPRelatedExpensesLimit_Textbox, testDataAsMap.get("BPPRelatedExpensesLimit").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    case "Spoilage":
                        browserUtil.CMPDropDown("SPLG;OpLocSplgHTML", lp_addCoverage_DrpDwn);
                        browserUtil.clicksWebElement(lp_addCoverage_Button);
                        browserUtil.entersTextWithTabIn(lp_SpoilageLimit_Textbox, testDataAsMap.get("SpoilageLimit").get(rowNo));
                        browserUtil.CMPDropDown(testDataAsMap.get("CoverageType").get(rowNo), lp_SpoilageCovgType_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("MaintncAgreement").get(rowNo), lp_SpoilageMaintanence_DrpDwn);
                        browserUtil.CMPDropDown(testDataAsMap.get("SellingPrice").get(rowNo), lp_SpoilageSellPrice_DrpDwn);
                        browserUtil.entersTextWithTabIn(lp_SpoilageDesc_Textbox, testDataAsMap.get("SpoilageDesc").get(rowNo));
                        browserUtil.entersTextWithTabIn(lp_spoilageDeductOver_Textbox, testDataAsMap.get("DeductibleOver").get(rowNo));
                        baseUtil.clicksOnSave();
                        break;
                    default:
                        break;

                }
            }
        }

        public void PCNMLocationCovgs(Map<String, List<String>> map) {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CAP LOCATIONS");
            browserUtil.waitsUntilWebElementIsClickable(lp_AddCoverage_Image);
            browserUtil.clicksWebElement(lp_AddCoverage_Image);
            List lp_LocationCoverage_Link = Arrays.asList(By.xpath("//td/a[normalize-space()='" + map.get("LocationCovgs").get(0) + "']"), "Location Page", "Location Coverage Link");
            browserUtil.waitsUntilWebElementIsClickable(lp_LocationCoverage_Link);
            browserUtil.clicksWebElement(lp_LocationCoverage_Link);
            browserUtil.entersTextWithTabIn(lp_FldBldLimit_Textbox, map.get("FldBldgLimit").get(0));
            baseUtil.clicksOnSave();
        }
    }


    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public CAPLocations_Page.CAPLocationsMethods theUser_() {
        return this.pageMethods;
    }

}