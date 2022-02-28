package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Base_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CommonInfo_Page {

    //private final String homepageTitle = "Login";
    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private CommonInfoMethods pageMethods;

    public CommonInfo_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new CommonInfoMethods();
    }

    public interface ICommonInfo {
        List cp_insuredShortName_text = Arrays.asList(By.xpath("//label[contains(.,\"Insured's Short Name:\")]/..//following-sibling::div[1]//input"), "Common Page", "Insured's Short Name");
        List cp_accountNumber_text = Arrays.asList(By.id("CoCommonInfoHTML_CoPolicy_AccountNo_FLD"), "Common Page", "Account Number");
        List cp_effectiveDate_text = Arrays.asList(By.xpath("//label[normalize-space()=\"Effective Date:\"]/..//following-sibling::div[1]//input"), "Common Page", "Effective Date");
        List cp_rateEffectiveDate_text = Arrays.asList(By.xpath("//label[normalize-space()=\"Rate Effective Date:\"]/..//following-sibling::div[1]//input"), "Common Page", "Rate Effective Date");
        List cp_insuranceCompany_DrpDwn = Arrays.asList(By.xpath("//label[normalize-space()=\"Insurance Company:\"]/..//following-sibling::div[1]//input"), "Common Page", "Insurance Company:");
        List cp_predominantState_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCommonInfoHTML_CoPolicy_PredState_LST_comboboxinput']"), "Common Page", "Predominant State");
        List cp_auditPeriod_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCommonInfoHTML_CoPolicy_AuditFrequencyInd_LST_comboboxinput']"), "Common Page", "Audit Period");
        List cp_shortTerm_DrpDwn = Arrays.asList(By.id("CoCommonInfoHTML_CoPolicy_ShortTermCd_LST_comboboxinput"), "Common Page", "Short Term");
        List cp_packageProgram_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCommonInfoHTML_CoPolicy_PkgProgCd_LST_comboboxinput']"), "Common Page", "Package Program");
        List cp_issuingOfficeCode_DrpDwn = Arrays.asList(By.xpath("//div/label[normalize-space()='Issuing Office Code:']//parent::div//following-sibling::div[1]//span//input"), "Common Page", "Issuing Office Code");
        List cp_producer_text = Arrays.asList(By.id("CoCommonInfoHTML_CoProducer_ProducerId_FLD"), "Common Page", "Producer");
        List cp_sanNumber_text = Arrays.asList(By.id("CoPolicySummary_CoPolicy_SystemAssignId"), "Common Page", "SAN Number");
        List cp_quoteNumber_text = Arrays.asList(By.id("CoPolicySummary_txtQuoteNo"), "Common Page", "Quote Number-Policy Summary");
        List cp_policyTerm_text = Arrays.asList(By.id("CoCommonInfoHTML_DynamicStore2_DynPolicyTerm_FLD"), "Common Page", "Policy Term");
        List cp_sicCode_text = Arrays.asList(By.id("CoCommonInfoHTML_CoBusinessInfo_SICCd"), "Common Page", "SIC Code");
        List cp_naicsCode_text = Arrays.asList(By.id("CoCommonInfoHTML_CoBusinessInfo_NAICCd"), "Common Page", "NAICS Code");
        List cp_expirationDate_text = Arrays.asList(By.id("CoCommonInfoHTML_DynamicStore2_DynExpirationDate_FLD"), "Common Page", "Expiration Date");
        List cp_addLOB_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCommonInfoHTML_cboAddLob_comboboxinput']"), "Common Page", "ADD LOB DrpDwn");
        List cp_addLOB_Button = Arrays.asList(By.id("CoCommonInfoHTML_imgAddLob"), "Common Page", "ADD LOB Button");
        List pes_Common_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Common']"), "Policy Explorer", "'Common_Link'");


        /* List bp_clickCommon_Link = Arrays.asList(By.xpath("//a[contains(text(),'Common')]"), "Policy Explorer", "Common Link");
         //List cp_quoteNumber_text = Arrays.asList(By.xpath("//td[.//span[contains(text(),'Quote No')]]/following-sibling::td/span"), "Common Page", "Quote Number-Policy Summary");
         //List cp_sanNumber_text = Arrays.asList(By.xpath("//td[.//span[contains(text(),'SAN')]]/following-sibling::td/span"), "Common Page", "SAN Number");
         List cp_producer_DrpDwn = Arrays.asList(By.xpath("//div/label[normalize-space()='Producer:']//parent::div//following-sibling::div[1]//span//input"), "Common Page", "Producer");
         List cp_detailOutput_DrpDwn = Arrays.asList(By.id("CoPrintHTML_DynamicStore2_DetailOutput_LST_comboboxinput"), "Quote Print Information", "Detail Output");
         List cp_Printing_DrpDwn = Arrays.asList(By.id("CoPrintHTML_DynamicStore2_WaitOption_LST_comboboxinput"), "Quote Print Information", "Printing");
         List cp_startPrinting_Img = Arrays.asList(By.xpath("//button[@title='Submit for Printing']"), "Quote Print Information", "'startPrinting_Img'");
         List cp_marketType_DrpDwn = Arrays.asList(By.id("CoWkCommonInfoHTML_CoWkCommonInfoDynamicEdits_MarketTypeCd_LST_comboboxinput"), "Common Page", "Market Type");
         List cp_stateOfAssign_DrpDwn = Arrays.asList(By.id("CoWkCommonInfoHTML_CoWkCommonInfoDynamicEdits_StateOfAssignCd_FLD"), "Common Page", "State of Assign");
         List cp_firstAuditEndDate_text = Arrays.asList(By.id("CoWkCommonInfoHTML_CoPolicy_AuditFrequencyInd_LST_comboboxinput"), "Common Page", "First audit End Date");
         List cp_depositAmmount_text = Arrays.asList(By.id("CoWkCommonInfoHTML_DynamicStore3_AuditDepValue_FLD"), "Common Page", "Deposit Ammount");
 */
        public String sanNumber = "";
        public String quoteNumber = "";
    }

    public class CommonInfoMethods implements ICommonInfo {

        public String fetchSan() {
            String sanNumber = browserUtil.getsSANOrQuoteNumberFromWeb(cp_sanNumber_text);
            browserUtil.writesToLogAndReport("Done", "fetchSan: Retrieved '" + sanNumber + "' from UI.");
            return sanNumber;
        }

        public String fetchQuote() {
            String quoteNumber = browserUtil.getsSANOrQuoteNumberFromWeb(cp_quoteNumber_text);
            System.out.println(quoteNumber);
            return quoteNumber;
        }

        /*public void updateCOInfoRateMode(Map<String, String> map) throws Exception {
            String insuredName = map.get("insuredName");
            String effectiveDate = map.get("effDateTxt");

            baseUtil.navigatesToCommonLinkOnPolicyExplorer();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.waitUntilPleaseWaitDisappear();
            try {
                String parent = browserUtil.getWindowHandle();
                browserUtil.switchToChildWindow();
                browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).click();
                browserUtil.switchToWindowWithHandle(parent);
            } catch (Exception e) {

            }
            browserUtil.waitsUntilWebElementIsClickable(cp_insuredName_text);
            browserUtil.entersTextWithTabIn(cp_insuredName_text, insuredName);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(cp_effectiveDate_text);
            browserUtil.entersTextWithTabInRateMode(cp_effectiveDate_text, effectiveDate);
            browserUtil.waitUntilPleaseWaitDisappear();
            if (map.containsKey("Producer")) {
                //browserUtil.selectsValueFromDropDown(map.get("Producer"), cp_producer_DrpDwn);
                if (!map.get("Producer").equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_producer_DrpDwn);
                }
                browserUtil.selectsValueFromDropDown2(map.get("Producer"), cp_producer_DrpDwn);

            }
        }

        public void printQuote(Map<String, String> map) throws InterruptedException {
            if (map.get("PrintDetails_Flag").equalsIgnoreCase("Yes")) {
                baseUtil.clicksOnNext();
                browserUtil.selectsValueFromDropDown2(map.get("Detail_Output"), cp_detailOutput_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("Printing"), cp_Printing_DrpDwn);
                browserUtil.clicksWebElement(cp_startPrinting_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }*/

        public void changeCommonPolicyDetailsReWrite(Map<String, List<String>> map) throws InterruptedException
        {
            browserUtil.clicksWebElement(pes_Common_Link);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.GLntersTextWithTabIn(cp_producer_text, map.get("Producer").get(0));

        }
        public void enterCommonPolicyDetails(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("Common_Page_Flag").get(0).equalsIgnoreCase("Yes")) {
                if (map.get("Transaction_Type").get(0).equalsIgnoreCase("REIS")) {
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("COMMON");
                }
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(cp_insuredShortName_text);
                browserUtil.entersTextWithTabIn(cp_insuredShortName_text, map.get("Insureds_Name").get(0));
                browserUtil.entersTextWithTabIn(cp_accountNumber_text, map.get("Account_Number").get(0));
                browserUtil.entersTextWithTabIn(cp_effectiveDate_text, map.get("Common_Effective_Date").get(0));
                browserUtil.entersDate(cp_expirationDate_text, map.get("Expiration_Date").get(0));
                //browserUtil.entersTextWithTabIn(cp_expirationDate_text, map.get("Expiration_Date").get(0));

                if (!map.get("Expiration_Date").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_expirationDate_text);
                }
                browserUtil.entersTextWithTabIn(cp_rateEffectiveDate_text, map.get("Rate_Effective_Date").get(0));
                browserUtil.entersTextWithTabIn(cp_policyTerm_text, map.get("Policy_term").get(0));
                browserUtil.selectsValueFromDropDown2(map.get("Short_Term_Reason").get(0), cp_shortTerm_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("PackageProgram").get(0),cp_packageProgram_DrpDwn);
                if (!map.get("PackageProgram").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_packageProgram_DrpDwn);
                }
                browserUtil.selectsValueFromDropDown2(map.get("Audit_Period").get(0), cp_auditPeriod_DrpDwn);
                if (!map.get("Audit_Period").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_auditPeriod_DrpDwn);
                }
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("Issuing_Office_Code").get(0), cp_issuingOfficeCode_DrpDwn);
                if (!map.get("Issuing_Office_Code").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_issuingOfficeCode_DrpDwn);
                }
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("Insurance_Company").get(0), cp_insuranceCompany_DrpDwn);
                //browserUtil.entersTextWithTabIn(cp_insuranceCompany_DrpDwn,map.get("Insurance_Company").get(0));
                if (!map.get("Insurance_Company").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_insuranceCompany_DrpDwn);
                }
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(map.get("Predominant_State").get(0), cp_predominantState_DrpDwn);
                if (!map.get("Predominant_State").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_predominantState_DrpDwn);
                }
                browserUtil.entersTextWithTabIn(cp_producer_text, map.get("Producer").get(0));
                if (!map.get("Producer").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_producer_text);
                }
                browserUtil.entersTextWithTabIn(cp_sicCode_text, map.get("SIC_Code").get(0));
                if (!map.get("Producer").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_sicCode_text);
                }
                browserUtil.entersTextWithTabIn(cp_naicsCode_text, map.get("NAICS_Code").get(0));
                if (!map.get("Producer").get(0).equalsIgnoreCase("$$NA$$")) {
                    browserUtil.sendsTabKeyOnWebElement(cp_naicsCode_text);
                }

            }
        }

        public void enterAddLOB(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.CMPDropDown(map.get("Audit_Period_Pkg").get(0), cp_auditPeriod_DrpDwn);
            browserUtil.CMPDropDown(map.get("PackageProgramPkg").get(0), cp_packageProgram_DrpDwn);
            browserUtil.CMPDropDown(map.get("addLOB").get(0), cp_addLOB_DrpDwn);
            browserUtil.waitsUntilWebElementIsClickable(cp_addLOB_Button);
            browserUtil.clicksWebElement(cp_addLOB_Button);
            baseUtil.clicksOnSave();
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void changeCommonPolicyDetailsREISSUE(Map<String, List<String>> map) throws InterruptedException
        {
            browserUtil.clicksWebElement(pes_Common_Link);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.driver.findElement(By.xpath("//td/a[normalize-space()='"+map.get("deletePolicy").get(0)+"']//parent::td//following-sibling::td/i")).click();
            try {
                while (browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed()) {
                    String parent = browserUtil.getWindowHandle();
                    browserUtil.switchToChildWindow();
                    browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.switchToWindowWithHandle(parent);
                }
            } catch (Exception e) {
            }

        }

        public void checkStatus() throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("COMMON");
        }



    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public CommonInfoMethods theUser_() {
        return this.pageMethods;
    }

}