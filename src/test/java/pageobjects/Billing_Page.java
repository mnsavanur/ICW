package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by khukmata on 2/12/2018.
 */
public class Billing_Page
{

    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Billing_Page.IBillingMethods pageMethods;

    public Billing_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_Util)
    {

        this.browserUtil = browser_Util;
        this.baseUtil = base_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Billing_Page.IBillingMethods();
    }

    public interface IBilling
    {
        List bp_billingType_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoInstallmentsHTML_CoInstallment_BillingTypeCd_LST_comboboxinput']"), "Billing Page", "Billing Type");
        List bp_paymentPlan_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoInstallmentsHTML_CoInstallment_PayPlanCd_LST_comboboxinput']"), "Billing Page", "Payment Plan");
        List bp_deferralPercent_Txt = Arrays.asList(By.id("CoInstallmentsHTML_CoInstallment_PremDeferPct_FLD"), "Billing Page", "Deferral Percent");
        List bp_checkAudit_Txt = Arrays.asList(By.id("CoInstallmentsHTML_CoPolicy_AuditTestFreqCd_LST_comboboxinput"), "Billing Page", "Check Audit");
        List bp_recalculateDepositDisabled_Drpdwn = Arrays.asList(By.xpath("//select[@id='CoInstallmentsHTML_ActiveControl_CoInstallment_MiscInd' and @disabled='disabled']"), "Billing Page", "Recalculate deposit");
        List bp_recalculateDeposit_Drpdwn = Arrays.asList(By.xpath("//input[@id='CoInstallmentsHTML_CoInstallment_MiscInd_LST_comboboxinput']"), "Billing Page", "Recalculate deposit");

        List pes_Billing_Link = Arrays.asList(By.xpath("//button[normalize-space()='Billing']"), "Policy Explorer", "'Billing_Link'");
    }

    public class IBillingMethods implements Billing_Page.IBilling
    {
        public boolean flag = true;

        public void setsRecalculateDepositToNo()
        {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("BILLING");
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            if(!browserUtil.verifiesWebElementIsPresent(bp_recalculateDepositDisabled_Drpdwn))
            {
                browserUtil.selectsValueFromDropDown("No", bp_recalculateDeposit_Drpdwn);
            }
        }
        public void fillBillingPageDetails(Map<String, List<String>> map) throws InterruptedException
        {
            if(map.get("BillingPage_Flag").get(0).equalsIgnoreCase("Yes"))
            {
                String billingTypeData = map.get("billingTypeDrpDwn").get(0);
                String paymentPlanData = map.get("paymentPlanDrpDwn").get(0);
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("BILLING");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.CMPDropDown(billingTypeData, bp_billingType_DrpDwn);
                browserUtil.CMPDropDown(map.get("Recalculate_Deposit").get(0), bp_recalculateDeposit_Drpdwn);
                browserUtil.CMPDropDown(paymentPlanData, bp_paymentPlan_DrpDwn);
                browserUtil.sendsTabKeyOnWebElement(bp_paymentPlan_DrpDwn);
                browserUtil.entersTextWithTabIn(bp_deferralPercent_Txt, map.get("Deferral_Percent").get(0));
                browserUtil.CMPDropDown(map.get("Check_Audit").get(0), bp_checkAudit_Txt);
            }
        }

        //New method added by AP for GL LOB
        public void fillBillingPageDetailsPCNM(Map<String, List<String>> map) throws InterruptedException
        {
            if(map.get("BillingPage_Flag").get(0).equalsIgnoreCase("Yes"))
            {
                browserUtil.clicksWebElement(pes_Billing_Link);
                browserUtil.selectsValueFromDropDown2(map.get("Recalculate_Deposit").get(0), bp_recalculateDeposit_Drpdwn);

            }
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Billing_Page.IBillingMethods theUser_() {
        return this.pageMethods;
    }

}