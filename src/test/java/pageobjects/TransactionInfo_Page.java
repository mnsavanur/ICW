package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by khukmata on 2/19/2018.
 */
public class TransactionInfo_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private TransactionInfoMethods pageMethods;

    public TransactionInfo_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new TransactionInfoMethods();
    }

    public interface ITransactionInfo {

        List cp_TransactionInfo_link = Arrays.asList(By.xpath("//button[normalize-space()='Transaction Info']"), "Transaction Info", "Transaction Info");
        List cp_PolicyType_drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Policy Type:')]/..//following-sibling::div[1]//input"), "Transaction Info Page", "Policy Type");

        List ti_payrollExposureInflationFactor_link = Arrays.asList(By.xpath("//div/label[contains(normalize-space(),'Payroll Exposure Inflation Factor')]//parent::div//following-sibling::div//input"), "Renewal Info Page", "Payroll Exposure Inflation Factor");
        List ti_cancellationReason_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCancellationTransHTML_CoTransInfo_ReasonCd_LST_comboboxinput']"), "Cancellation Info Page", "Cancellation Reason");
        List ti_cancelMethod_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCancellationTransHTML_CoTransInfo_CancelMethod_LST_comboboxinput']"), "Cancellation Info Page", "Cancel Method");
        List ti_retirement_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCancellationTransHTML_CoTransInfo_RetirementInd_LST_comboboxinput']"), "Cancellation Info Page", "Retirement");
        List ti_transDesc_Txt = Arrays.asList(By.id("CoEndorsementTransHTML_CoTransInfo_TransDesc"), "Change Endorsement Info Page", "Transaction Description");
        List ti_waveUntilAudit_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoEndorsementTransHTML_CoTransInfo_EndtPremWaiveInd_LST_comboboxinput']"), "Change Endorsement Info Page", "Wave Until Audit");
        List ti_waveUntilAuditDisabled_DrpDwn = Arrays.asList(By.xpath("//select[@id='CoEndorsementTransHTML_ActiveControl_CoTransInfo_EndtPremWaiveInd' and @Disabled='Disabled']"), "Change Endorsement Info Page", "Wave Until Audit (Disabled)");
        List ti_endorsementCalculation_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoEndorsementTransHTML_CoTransInfo_TransCalcCd_LST_comboboxinput']"), "Change Endorsement Info Page", "Endorsement Calculation");
        List ti_endorsementPayment_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoEndorsementTransHTML_CoTransInfo_EndtPremPymtCd_LST_comboboxinput']"), "Change Endorsement Info Page", "Endorsement Payment");
        List ti_auditorComments_Txt = Arrays.asList(By.id("WkAuditTransHTML_CoTransInfo_TransDesc"), "Audit Transaction Info Page", "Auditor Comment");
        List ti_auditType_DrpDwn = Arrays.asList(By.id("WkAuditTransHTML_WkAuditTrans_AuditTypeCd_LST_comboboxinput"), "Audit Transaction Info Page", "Audit Type");
        List ti_exposureIncrease_Txt = Arrays.asList(By.id("WkAuditTransHTML_WkAuditTrans_IncreasedExposurePct_FLD"), "Audit Transaction Info Page", "% Exposure Increase");
        List ti_combinedPolicyPremium_Txt = Arrays.asList(By.id("WkAuditTransHTML_WkPremDisc_CombPolicyPremAmt_FLD"), "Audit Transaction Info Page", "Combined Policy Premium");
        List ti_NJPremium_Txt = Arrays.asList(By.id("WkAuditTransHTML_WkPremDisc_NjCombPolicyPremAmt_FLD"), "Audit Transaction Info Page", "NJ Premium");
        List ti_splitDate_Txt = Arrays.asList(By.id("WkInsertStateSplitHTML_DynamicStore_EndStartDate"), "Audit Transaction Info Page", "Split date");
        List ti_addSplitDate_Btn = Arrays.asList(By.id("WkInsertStateSplitHTML_cmdOK"), "Audit Transaction Info Page", "Add Split Date");
        List ti_reinstatementReason_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoReinstatementTransHTML_CoTransInfo_ReasonCd_LST_comboboxinput']"), "Reinstatement Info Page", "Reinstatement Reason");
        List ti_dnreReason_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoDoNotRenewTransHTML_CoTransInfo_ReasonCd_LST_comboboxinput']"), "Establish Non Renewal Reason", "Establish Non Renewal Reason");
        List ti_cancOtherDesc_Txt = Arrays.asList(By.id("CoCancellationTransHTML_ActiveControl_CoTransInfo_OtherReasonDesc"), "Cancellation Info Page", "Other Description");
        List ti_rewrittenInd_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoCancellationTransHTML_CoTransInfo_RewrittenInd_LST_comboboxinput']"), "Cancellation Info Page", "Rewritten Indicator");
        List ti_waiveUntilAudit_DrpDwn = Arrays.asList(By.id("CoCancellationTransHTML_CoTransInfo_EndtPremWaiveInd_LST_comboboxinput"), "Cancellation Info Page", "Waive Until Aduit");
        List ti_reinstatementOtherDesc_Txt = Arrays.asList(By.id("CoReinstatementTransHTML_ActiveControl_CoTransInfo_OtherReasonDesc"), "Reinstatement Information Page", "Other Description");
        List ti_reinstatementDate_Txt = Arrays.asList(By.id("CoReinstatementTransHTML_ActiveControl_CoTransInfo_LapseDt"), "Reinstatement Information Page", "Other Description");
        List ti_notepadText_Txt = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_MemoTx"), "Notepad Page", "Text field");
        List ti_notepadDate_Txt = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_MemoNoteDt_FLD"), "Notepad Page", "Date");
        List ti_notepadAuthor_Txt = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_MemoAuthorNm_FLD"), "Notepad Page", "Author");
        List ti_noteType_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_NoteTypeCd_LST_comboboxinput"), "Notepad Page", "Note Type");
        List ti_notepadLOB_DrpDwn = Arrays.asList(By.id("g_CB_CoNotepad_LobApplicableInd_t"), "Notepad Page", "Line of Business");
        List ti_notepadAudit_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_AuditFuncInd_LST_comboboxinput"), "Notepad Page", "Audit");
        List ti_notepadCredit_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_CreditFuncInd_LST_comboboxinput"), "Notepad Page", "Credit");
        List ti_notepadSales_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_SalesFuncInd_LST_comboboxinput"), "Notepad Page", "Sales");
        List ti_notepadClaim_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_ClaimFuncInd_LST_comboboxinput"), "Notepad Page", "Claim");
        List ti_notepadLoss_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_LossFuncInd_LST_comboboxinput"), "Notepad Page", "Loss");
        List ti_notepadUnderwriter_DrpDwn = Arrays.asList(By.id("CoNotepadDetailHTML_CoNotepad_UndwrFuncInd_LST_comboboxinput"), "Notepad Page", "Underwriter");
        List ti_notepadAdd_Btn = Arrays.asList(By.id("CoNotepadEdit_dgNotePad_Row_AddNew"), "Notepad Page", "Add Button");
        List ti_retrDescription_Txt = Arrays.asList(By.id("CoTranRETRIWHTML_ActiveControl_CoTransInfo_TransDesc"), "Transaction Info Page", "Transaction Description");
        List ti_MANUReasonCode_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoTransStopOnOffHTML_CoPolicy_StopReasonCd_LST_comboboxinput']"), "Transaction Information Page", "Reason Code");
        List ti_MANUOtherDescription_Txt = Arrays.asList(By.xpath("//input[@id='CoTransStopOnOffHTML_CoTransInfo_TransDesc_FLD']"), "Transaction Information Page", "Other Description");
        List ti_DepositTransferComments_Txt = Arrays.asList(By.id("CoDepositTransferTransHTML_ActiveControl_CoTransInfo_TransDesc"), "Transaction Information Page", "Comments (Deposit Transfer)");
        List ti_DepositTransferAmount_Txt = Arrays.asList(By.id("CoDepositTransferTransHTML_ActiveControl_CoInstallment_InputDepositPremAmt"), "Transaction Information Page", "Amount (Deposit Transfer)");
        List ti_compositeRating_drpdown = Arrays.asList(By.xpath("//input[@id='CoEndorsementTransHTML_CoTransInfo_RecalcCmpstRateCd_LST_comboboxinput']"), "Change Endorsement Info Page", "Composite Rating");
    }

    public class TransactionInfoMethods implements ITransactionInfo {
        public void updateInflationFactor(Map<String, List<String>> map) throws InterruptedException {
            String inflationFactorTxt = map.get("payrollExposureInflationFactorTxt").get(0);
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(ti_payrollExposureInflationFactor_link, inflationFactorTxt);
        }

        public void enterCancellationDetails(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(ti_cancellationReason_DrpDwn);
            browserUtil.CMPDropDown(map.get("cancReason").get(0), ti_cancellationReason_DrpDwn);
            browserUtil.CMPDropDown(map.get("cancMethod").get(0), ti_cancelMethod_DrpDwn);
            baseUtil.clicksOnSave();
            //browserUtil.waitsUntilWebElementIsClickable(ti_retirement_DrpDwn);
            browserUtil.CMPDropDown(map.get("cancRetirement").get(0), ti_retirement_DrpDwn);
            browserUtil.entersTextWithTabIn(ti_cancOtherDesc_Txt, map.get("cancOtherDesc").get(0));
            browserUtil.CMPDropDown(map.get("cancMethod").get(0), ti_cancelMethod_DrpDwn);
            browserUtil.CMPDropDown(map.get("rewrittenInd").get(0), ti_rewrittenInd_DrpDwn);
            browserUtil.CMPDropDown(map.get("waiveUntilAudit").get(0), ti_waiveUntilAudit_DrpDwn);
            browserUtil.CMPDropDown(map.get("cancRetirement").get(0), ti_retirement_DrpDwn);
            baseUtil.clicksOnSave();
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void setsWaiveUntilAuditToYes() throws InterruptedException {
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(ti_transDesc_Txt, "Adding Form PN049908");
            if (!browserUtil.verifiesWebElementIsPresent(ti_waveUntilAuditDisabled_DrpDwn)) {
                browserUtil.selectsValueFromDropDown("Yes", ti_waveUntilAudit_DrpDwn);
            }
            baseUtil.clicksOnSave();
            baseUtil.clicksOnNext();

        }

        public void enterChangeEndorsementDetails(Map<String, List<String>> map) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.waitsUntilWebElementIsClickable(ti_transDesc_Txt);
            browserUtil.entersTextWithTabIn(ti_transDesc_Txt, map.get("Endorsement Transaction Description").get(0));
            browserUtil.CMPDropDown(map.get("Endorsement Waive Until Audit").get(0), ti_waveUntilAudit_DrpDwn);
            browserUtil.CMPDropDown(map.get("Endorsement Calculation").get(0), ti_endorsementCalculation_DrpDwn);
            browserUtil.CMPDropDown(map.get("Endorsement Payment").get(0), ti_endorsementPayment_DrpDwn);
            browserUtil.CMPDropDown(map.get("Composite Rating").get(0),ti_compositeRating_drpdown);
            baseUtil.clicksOnSave();
            browserUtil.waitUntilPleaseWaitDisappear();
            baseUtil.clicksOnNext();
            browserUtil.waitUntilPleaseWaitDisappear();

        }

        public void enterChangeEndorsementDetailsGL(Map<String, List<String>> map) throws InterruptedException
        {
            browserUtil.CMPDropDown(map.get("Composite_Rating").get(0),ti_compositeRating_drpdown );
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(ti_transDesc_Txt);
            browserUtil.entersTextWithTabIn(ti_transDesc_Txt, map.get("Endorsement Transaction Description").get(0));
        }

        public void enterAuditTransactionDetails(Map<String, List<String>> map) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(ti_auditorComments_Txt);
            browserUtil.entersTextWithTabIn(ti_auditorComments_Txt, map.get("Auditor Comments").get(0));
            browserUtil.CMPDropDown(map.get("Audit Type").get(0), ti_auditType_DrpDwn);
            browserUtil.entersTextWithTabIn(ti_exposureIncrease_Txt, map.get("Exposure Increase").get(0));
            browserUtil.entersTextWithTabIn(ti_combinedPolicyPremium_Txt, map.get("Combined Policy Premium").get(0));
            browserUtil.entersTextWithTabIn(ti_NJPremium_Txt, map.get("NJ Premium").get(0));
            baseUtil.clicksOnSave();
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void enterRetroAdjustment(Map<String, List<String>> map) {
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(ti_retrDescription_Txt, map.get("transactionDescription").get(0));
            baseUtil.clicksOnSave();
        }

        public void enterReinstatementDetails(Map<String, List<String>> map) throws InterruptedException {
            System.out.print(map.get("reinstatementReason"));
            browserUtil.entersTextWithTabIn(ti_reinstatementOtherDesc_Txt, map.get("reinstatementDate").get(0));
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("reinstatementReason").get(0), ti_reinstatementReason_DrpDwn);
            browserUtil.entersTextWithTabIn(ti_reinstatementDate_Txt, map.get("reinstatementOtherDesc").get(0));
            baseUtil.clicksOnSave();
        }

        public void enterTransactionStopOnOffInformationDetails(Map<String, List<String>> map) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.CMPDropDown(map.get("manuReason").get(0), ti_MANUReasonCode_DrpDwn);
            browserUtil.entersTextWithTabIn(ti_MANUOtherDescription_Txt, map.get("manuOtherDescription").get(0));
            baseUtil.clicksOnSave();
        }

        public void enterDNREDetails(Map<String, List<String>> map) throws InterruptedException {
            // browserUtil.switchToDefaultContent();
            // browserUtil.switchToFrame("InsDmain");
            System.out.print(map.get("establishNonRenewalReason"));
            browserUtil.CMPDropDown(map.get("establishNonRenewalReason").get(0), ti_dnreReason_DrpDwn);
            baseUtil.clicksOnSave();
        }

        public void enterNotepadDetails(Map<String, List<String>> map) throws InterruptedException {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            //browserUtil.driver.switchTo().frame(0);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(ti_notepadAdd_Btn);
            browserUtil.clicksWebElement(ti_notepadAdd_Btn);
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(ti_notepadText_Txt, map.get("npadText").get(0));
            browserUtil.entersTextWithTabIn(ti_notepadDate_Txt, map.get("npadDate").get(0));
            browserUtil.entersTextWithTabIn(ti_notepadAuthor_Txt, map.get("author").get(0));
            browserUtil.CMPDropDown(map.get("noteType").get(0), ti_noteType_DrpDwn);
            //browserUtil.selectsValueFromDropDown(map.get("notepadLOB"),ti_notepadLOB_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadAudit").get(0), ti_notepadAudit_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadCredit").get(0), ti_notepadCredit_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadSales").get(0), ti_notepadSales_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadClaim").get(0), ti_notepadClaim_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadLoss").get(0), ti_notepadLoss_DrpDwn);
            browserUtil.CMPDropDown(map.get("notepadUnderwiter").get(0), ti_notepadUnderwriter_DrpDwn);
            baseUtil.clicksOnSave();
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void enterDepositTransferInformation(Map<String, List<String>> map) {
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(ti_DepositTransferComments_Txt, map.get("comments").get(0));
            browserUtil.entersTextWithTabIn(ti_DepositTransferAmount_Txt, map.get("depositAmount").get(0));
            baseUtil.clicksOnSave();
        }

        public void enterPolicyType(Map<String, List<String>> map) throws InterruptedException {
                browserUtil.clicksWebElement(cp_TransactionInfo_link);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown("CPP", cp_PolicyType_drpdwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.clicksOnNext();
        }

        public void enterPolicyTypeMonoline(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(cp_TransactionInfo_link);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown("IMN", cp_PolicyType_drpdwn);
            browserUtil.waitUntilPleaseWaitDisappear();
            baseUtil.clicksOnNext();
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public TransactionInfoMethods theUser_() {
        return this.pageMethods;
    }

}