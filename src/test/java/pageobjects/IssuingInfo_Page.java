package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IssuingInfo_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private IssuingInfo_Page.IssuingInfoMethods pageMethods;

    public IssuingInfo_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new IssuingInfo_Page.IssuingInfoMethods();
    }

    public interface IIssuingInfo {
        List ip_policyNoPrefix_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoPolicy_PolicyPrefix_FLD"), "Issuing Info Page", "Policy Prefix");
        List ip_policyNoSuffix_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoPolicy_PolicySeqNo_FLD"), "Issuing Info Page", "Policy Prefix");
        List ip_policyNo_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoPolicy_PolicyNo_FLD"), "Issuing Info Page", "Policy Number");
        List ip_nameOfInsured_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_InsuredNm"), "Issuing Info Page", "Name of Insured");
        List ip_fein_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_FEINId_FLD"), "Issuing Info Page", "FEIN");
        List ip_workPhone_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_WorkPhoneNo_FLD"), "Issuing Info Page", "Work Phone");
        List ip_businessType_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoAdditionalInfoHTML_CoBusinessInfo_BusinessTypeCd_LST_comboboxinput']"), "Issuing Info Page", "Business Type");
        List ip_mailingAddress_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_AddrLine1Tx_FLD"), "Issuing Info Page", "Mailing Address");
        List ip_city_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_CityNm_FLD"), "Issuing Info Page", "City");
        List ip_state_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoAdditionalInfoHTML_CoInsuredInfo_StateCd_LST_comboboxinput']"), "Issuing Info Page", "State");
        List ip_zipCode_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_ZipCd_FLD"), "Issuing Info Page", "Zip Code");
        List ip_contactName_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_ContactNm_FLD"), "Issuing Info Page", "Contact Name");
        List ip_otherPhone_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_OtherPhoneNo_FLD"), "Issuing Info Page", "");
        List ip_emailAddress_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoInsuredInfo_EmailAddrTx"), "Issuing Info Page", "");
        List ip_otherDescription_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_DynamicStoreOtherDesc_OtherDesc_FLD"), "Issuing Info Page", "");
        List ip_businessDescription_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoBusinessInfo_BusDescTx_FLD"), "Issuing Info Page", "");
        List ip_yearStartedInBusiness_Text = Arrays.asList(By.id("CoAdditionalInfoHTML_CoBusinessInfo_BusinessStartedYr_FLD"), "Issuing Info Page", "");

        List ip_Save_Button = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), "Issuing Info Page", "'Save_Button'");
        List ip_ConvertToIssue_Button = Arrays.asList(By.xpath("//button[normalize-space()='Convert to Issue']"), "Issuing Info Page", "'ConvertToIssue_Button'");
        public static final String Append = "99-";
    }

    public class IssuingInfoMethods implements IssuingInfo_Page.IIssuingInfo {

        public void updateIssuingInfo(Map<String, String> map, String sanNumber) throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
            String nameOfInsuredTxt = map.get("nameOfInsuredTxt");
            String feinTxt = Append + sanNumber;
            String workPhone = map.get("workPhoneTxt");
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            String policyPrefixTxt = map.get("policyPrefixTxt");
            String policySuffixTxt = map.get("policySuffixTxt");
            browserUtil.entersTextWithTabIn(ip_policyNoPrefix_Text, policyPrefixTxt);
            browserUtil.entersTextWithTabIn(ip_policyNo_Text, sanNumber);
            browserUtil.entersTextWithTabIn(ip_policyNoSuffix_Text, policySuffixTxt);
            browserUtil.entersTextWithTabIn(ip_nameOfInsured_Text, nameOfInsuredTxt);
            browserUtil.entersTextWithTabIn(ip_fein_Text, feinTxt);
            browserUtil.waitsUntilWebElementIsClickable(ip_workPhone_Text);
            browserUtil.entersTextWithTabIn(ip_workPhone_Text, workPhone);
            //browserUtil.entersTextWithTabIn(ip_fein_Text, feinTxt);
        }

        public void fillIssuingInfoDetails(Map<String, List<String>> map, String sanNumber, String transType) throws InterruptedException {
            if (map.get("IssuingInfo_Flag").get(0).equalsIgnoreCase("Yes")) {
                String policyPrefixTxt = map.get("policyPrefixTxt").get(0);
                String policySuffixTxt = map.get("policySuffixTxt").get(0);
                String nameOfInsuredTxt = map.get("nameOfInsuredTxt").get(0);
                String workPhone = map.get("workPhoneTxt").get(0);
                String feinTxt = Append + sanNumber;
                String mailAddress = map.get("mailingAddressTxt").get(0);
                String city = map.get("cityTxt").get(0);
                String stateData = map.get("stateDrpDwn").get(0);
                String zipCode = map.get("zipCodeTxt").get(0);
                String contactNameTxt = map.get("Contact_Name").get(0);
                String otherPhoneTxt = map.get("Other_Phone").get(0);
                String emailAddressTxt = map.get("Email_Address").get(0);
                String otherDescriptionTxt = map.get("Other_Description").get(0);
                String businessDescriptionTxt = map.get("Business_Description").get(0);
                String yearStartedInBusinessTxt = map.get("Year_Started_in_Business").get(0);
                String businessTypeData = map.get("businessTypeDrpDwn").get(0);

                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitsUntilWebElementIsClickable(ip_policyNoPrefix_Text);
                browserUtil.entersTextWithTabIn(ip_policyNoPrefix_Text, policyPrefixTxt);
                browserUtil.entersTextWithTabIn(ip_policyNo_Text, sanNumber);
                browserUtil.entersTextWithTabIn(ip_policyNoSuffix_Text, policySuffixTxt);
                browserUtil.entersTextWithTabIn(ip_nameOfInsured_Text, nameOfInsuredTxt);
                browserUtil.entersTextWithTabIn(ip_mailingAddress_Text, mailAddress);
                browserUtil.entersTextWithTabIn(ip_city_Text, city);
                browserUtil.CMPDropDown(stateData, ip_state_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_zipCode_Text, zipCode);
                browserUtil.entersTextWithTabIn(ip_fein_Text, feinTxt);
                browserUtil.entersTextWithTabIn(ip_contactName_Text, contactNameTxt);
                browserUtil.entersTextWithTabIn(ip_workPhone_Text, workPhone);
                browserUtil.entersTextWithTabIn(ip_otherPhone_Text, otherPhoneTxt);
                browserUtil.entersTextWithTabIn(ip_emailAddress_Text, emailAddressTxt);
                browserUtil.clicksWebElement(ip_businessType_DrpDwn);
                browserUtil.CMPDropDown(businessTypeData, ip_businessType_DrpDwn);
                //browserUtil.sendsTabKeyOnWebElement(ip_businessType_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_otherDescription_Text, otherDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_businessDescription_Text, businessDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_yearStartedInBusiness_Text, yearStartedInBusinessTxt);
                browserUtil.clicksWebElement(ip_Save_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }




        public void CIRT_fillIssuingInfoDetails(Map<String, List<String>> map, String sanNumber, String transType) throws InterruptedException {
            if (map.get("IssuingInfo_Flag").get(0).equalsIgnoreCase("Yes")) {
                String policyPrefixTxt = map.get("policyPrefixTxt").get(0);
                String policySuffixTxt = map.get("policySuffixTxt").get(0);
                String nameOfInsuredTxt = map.get("nameOfInsuredTxt").get(0);
                String workPhone = map.get("workPhoneTxt").get(0);
                String feinTxt = Append + sanNumber;
                String mailAddress = map.get("mailingAddressTxt").get(0);
                String city = map.get("cityTxt").get(0);
                String stateData = map.get("stateDrpDwn").get(0);
                String zipCode = map.get("zipCodeTxt").get(0);
                String contactNameTxt = map.get("Contact_Name").get(0);
                String otherPhoneTxt = map.get("Other_Phone").get(0);
                String emailAddressTxt = map.get("Email_Address").get(0);
                String otherDescriptionTxt = map.get("Other_Description").get(0);
                String businessDescriptionTxt = map.get("Business_Description").get(0);
                String yearStartedInBusinessTxt = map.get("Year_Started_in_Business").get(0);
                String businessTypeData = map.get("businessTypeDrpDwn").get(0);

                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
               // browserUtil.waitsUntilWebElementIsClickable(ip_policyNoPrefix_Text);
               // browserUtil.entersTextWithTabIn(ip_policyNoPrefix_Text, policyPrefixTxt);
              //  browserUtil.entersTextWithTabIn(ip_policyNo_Text, sanNumber);
                //browserUtil.entersTextWithTabIn(ip_policyNoSuffix_Text, policySuffixTxt);
                browserUtil.entersTextWithTabIn(ip_nameOfInsured_Text, nameOfInsuredTxt);
                browserUtil.entersTextWithTabIn(ip_mailingAddress_Text, mailAddress);
                browserUtil.entersTextWithTabIn(ip_city_Text, city);
                browserUtil.CMPDropDown(stateData, ip_state_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_zipCode_Text, zipCode);
                browserUtil.entersTextWithTabIn(ip_contactName_Text, contactNameTxt);
                browserUtil.entersTextWithTabIn(ip_workPhone_Text, workPhone);
                browserUtil.entersTextWithTabIn(ip_otherPhone_Text, otherPhoneTxt);
                browserUtil.entersTextWithTabIn(ip_emailAddress_Text, emailAddressTxt);
                browserUtil.selectsValueFromDropDown2(businessTypeData, ip_businessType_DrpDwn);
                browserUtil.sendsTabKeyOnWebElement(ip_businessType_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_otherDescription_Text, otherDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_businessDescription_Text, businessDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_yearStartedInBusiness_Text, yearStartedInBusinessTxt);
                browserUtil.clicksWebElement(ip_Save_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void PCNM_fillIssuingInfoDetails(Map<String, List<String>> map, String sanNumber, String transType) throws InterruptedException {
            if (map.get("IssuingInfo_Flag").get(0).equalsIgnoreCase("Yes")) {
                String policyPrefixTxt = map.get("policyPrefixTxt").get(0);
                String policySuffixTxt = map.get("policySuffixTxt").get(0);
                String nameOfInsuredTxt = map.get("nameOfInsuredTxt").get(0);
                String workPhone = map.get("workPhoneTxt").get(0);
                String feinTxt = Append + sanNumber;
                String mailAddress = map.get("mailingAddressTxt").get(0);
                String city = map.get("cityTxt").get(0);
                String stateData = map.get("stateDrpDwn").get(0);
                String zipCode = map.get("zipCodeTxt").get(0);
                String contactNameTxt = map.get("Contact_Name").get(0);
                String otherPhoneTxt = map.get("Other_Phone").get(0);
                String emailAddressTxt = map.get("Email_Address").get(0);
                String otherDescriptionTxt = map.get("Other_Description").get(0);
                String businessDescriptionTxt = map.get("Business_Description").get(0);
                String yearStartedInBusinessTxt = map.get("Year_Started_in_Business").get(0);
                String businessTypeData = map.get("businessTypeDrpDwn").get(0);

                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUING INFO");
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(ip_nameOfInsured_Text, nameOfInsuredTxt);
                browserUtil.entersTextWithTabIn(ip_mailingAddress_Text, mailAddress);
                browserUtil.entersTextWithTabIn(ip_city_Text, city);
                browserUtil.CMPDropDown(stateData, ip_state_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_zipCode_Text, zipCode);
                browserUtil.entersTextWithTabIn(ip_contactName_Text, contactNameTxt);
                browserUtil.entersTextWithTabIn(ip_workPhone_Text, workPhone);
                browserUtil.entersTextWithTabIn(ip_otherPhone_Text, otherPhoneTxt);
                browserUtil.entersTextWithTabIn(ip_emailAddress_Text, emailAddressTxt);
                browserUtil.CMPDropDown(businessTypeData, ip_businessType_DrpDwn);
                browserUtil.sendsTabKeyOnWebElement(ip_businessType_DrpDwn);
                browserUtil.entersTextWithTabIn(ip_otherDescription_Text, otherDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_businessDescription_Text, businessDescriptionTxt);
                browserUtil.entersTextWithTabIn(ip_yearStartedInBusiness_Text, yearStartedInBusinessTxt);
                browserUtil.clicksWebElement(ip_Save_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void convertToIssueCAP() {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CONVERTS TO ISSUE");
            //browserUtil.clicksWebElement(ip_ConvertToIssue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void convertToIssue() {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CONVERTS TO ISSUE");
            //browserUtil.clicksWebElement(ip_ConvertToIssue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void CPconvertToIssue() {
            browserUtil.clicksWebElementUsingJavaScriptExecutor(ip_ConvertToIssue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public IssuingInfo_Page.IssuingInfoMethods theUser_() {
        return this.pageMethods;
    }

}
