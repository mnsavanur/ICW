package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by khukmata on 2/12/2018.
 */
public class MiscInformation_Page {

    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private MiscInformation_Page.IMiscInformationMethods pageMethods;

    public MiscInformation_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_Util) {

        this.browserUtil = browser_Util;
        this.baseUtil = base_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new MiscInformation_Page.IMiscInformationMethods();
    }

    public interface IMiscInformation {
        List mp_wkCommissionPercent_Text = Arrays.asList(By.id("CoMiscInfoIWHTML_CoCommission_WKCommPct_FLD"), "Misc Information Page", "WK Commission Percent");
        List mp_preliminaryAudit_DrpDwn = Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_AuditPreliminaryInd_LST_comboboxinput"), "Misc Information Page", "Preliminary Audit");
        List mp_lossRunFrequency_DrpDwn = Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_LossRunFreqCd_LST_comboboxinput"), "Misc Information Page", "Loss Run Frequency");
        List mp_payrollReports_DrpDwn = Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_AuditReportInd_LST_comboboxinput"), "Misc Information Page", "Payroll Reports");
        List mp_prePolicyPrefix_Txt = Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_PrevPolicyPrefix_FLD"), "Misc Information Page", "Pre Policy Prefix");
        List mp_sanNumber_Txt = Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_PrevPolicyNo_FLD"), "Misc Information Page", "SAN Number");
        List mp_prePolicySuffix_Txt = Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_PrevPolicySeqNo_FLD"), "Misc Information Page", "Pre policy Suffix");
        List mp_originalPolicyPrefix_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_OrigPolicyPrefix_FLD"),"Misc Information Page","");
        List mp_originalPolicyNumber_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_OrigPolicyNo_FLD"),"Misc Information Page","Original Policy Number");
        List mp_originalPolicySuffix_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_OrigPolicySeqNo_FLD"),"Misc Information Page","Original Policy Suffix");
        List mp_lossControlDateRequested_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_LossCtrlReqDt_FLD"),"Misc Information Page","Loss Control Date Requested");
        List mp_lossControlDateReceived_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_LossCtrlRecDt_FLD"),"Misc Information Page","Loss Control Date Received");
        List mp_planCode_DrpDwn=Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_PlanCd_LST_comboboxinput"),"Misc Information Page","Plan Code");
        List mp_reinsuranceIn_DrpDwn=Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_ReinsCd_LST_comboboxinput"),"Misc Information Page","Reinsurance In");
        List mp_SIR_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_SIRAmt_FLD"),"Misc Information Page","SIR");
        List mp_profitCenterCode_DrpDwn= Arrays.asList(By.id("CoMiscInfoIWHTML_CoICInfo_ProfitCtrCd_LST_comboboxinput"),"Misc Information Page","Profit Center Code");
        List mp_priorCarrierName_Txt=Arrays.asList(By.id("CoMiscInfoIWHTML_CoPolicy_PriorCarrierName_FLD"),"Misc Information Page","Prior Carrier Name");
    }

    public class IMiscInformationMethods implements MiscInformation_Page.IMiscInformation {
        public boolean flag = true;

        public void fillMiscInformation(Map<String, List<String>> map, String sanNumber)
        {
           if(map.get("MiscInfo_Flag").get(0).equalsIgnoreCase("Yes"))
           {
                String wkCommissionPercentTxt = map.get("wkCommisionPercentTxt").get(0);
                String preliminaryAuditDrpDwn = map.get("preliminaryAuditDrpDwn").get(0);
                String lossRunFrequency = map.get("lossRunFrequencyDrpDwn").get(0);
                String payrollReports = map.get("payrollReportsDrpDwn").get(0);

                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("MISC INFORMATION");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitsUntilWebElementIsClickable(mp_preliminaryAudit_DrpDwn);
                browserUtil.entersTextWithTabIn(mp_wkCommissionPercent_Text, wkCommissionPercentTxt);
                browserUtil.entersTextWithTabIn(mp_priorCarrierName_Txt, map.get("Prior_Carrier_Name").get(0));
                browserUtil.selectsValueFromDropDown2(preliminaryAuditDrpDwn, mp_preliminaryAudit_DrpDwn);
                browserUtil.selectsValueFromDropDown2(lossRunFrequency, mp_lossRunFrequency_DrpDwn);
                browserUtil.selectsValueFromDropDown2(payrollReports, mp_payrollReports_DrpDwn);
                browserUtil.entersTextWithTabIn(mp_originalPolicyPrefix_Txt, map.get("Original_Policy_Number_prefix").get(0));
                browserUtil.entersTextWithTabIn(mp_originalPolicyNumber_Txt, map.get("Original_Policy_Number").get(0));
                browserUtil.entersTextWithTabIn(mp_originalPolicySuffix_Txt, map.get("Original_Policy_Number_suffix").get(0));
                browserUtil.entersTextWithTabIn(mp_lossControlDateRequested_Txt, map.get("Loss_Control_Date_Requested").get(0));
                browserUtil.entersTextWithTabIn(mp_lossControlDateReceived_Txt, map.get("Loss_Control_Date_Received").get(0));
                browserUtil.selectsValueFromDropDown2(map.get("Profit_Center_Code").get(0),mp_profitCenterCode_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("Plan_Code").get(0),mp_planCode_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("Reinsurance_In").get(0),mp_reinsuranceIn_DrpDwn);
                browserUtil.entersTextWithTabIn(mp_SIR_Txt, map.get("SIR").get(0));
                if(map.get("transTypeDrpDwn").get(0).equalsIgnoreCase("Manual Renewal Issue") || (map.get("transTypeDrpDwn").get(0).equalsIgnoreCase("Manual Renewal Quote")))
                {
                    browserUtil.entersTextWithTabIn(mp_prePolicyPrefix_Txt, map.get("PrePolicyPrefixTxt").get(0));
                    browserUtil.entersTextWithTabIn(mp_sanNumber_Txt, sanNumber);
                    browserUtil.entersTextWithTabIn(mp_prePolicySuffix_Txt, map.get("PrePolicySufixTxt").get(0));
                }
           }
        }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public MiscInformation_Page.IMiscInformationMethods theUser_() {
        return this.pageMethods;
    }
}