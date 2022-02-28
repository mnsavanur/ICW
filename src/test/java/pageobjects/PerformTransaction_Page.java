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


public class PerformTransaction_Page {

    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Base_Util baseUtil;
    private PerformTransactionMethods pageMethods;

    public PerformTransaction_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_Util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new PerformTransactionMethods();
    }

    public interface IPerformTransaction {
        List pt_transactionDate_text = Arrays.asList(By.id("CoTransactionDataHTML_DynamicStore_TransEffectiveDt_FLD"), "Perform Transaction Page", "Transaction Effective Date (Textbox)");
        List pt_transactionDate_text2 = Arrays.asList(By.xpath("//select/following-sibling::span/input"), "Perform Transaction Page", "Transaction Effective Date2 (Textbox)");
        List pt_transactionDesc_text = Arrays.asList(By.id("CoTransactionDataHTML_txtTransDesc"), "Perform Transaction Page", "Transaction Description");
        List pt_changeNarrative_text = Arrays.asList(By.id("CoTransactionDataHTML_txtChangeNarr"), "Perform Transaction Page", "Transaction Description Change Narrative");
        List pt_selectTransHistory_radioBtn = Arrays.asList(By.id("dgCoTransactionHistoryList"), "Perform Transaction Page", "Select Transaction History");
        List pt_transEffDateForAUDM_drpDwn = Arrays.asList(By.id("CoTransactionDataHTML_DynamicStore_TransEffectiveDt_LST_comboboxinput"), "Perform Transaction Page", "Transaction Eff Date (Drop Down)");
        List pt_transVirtualPolicy_btn = Arrays.asList(By.xpath("//span[text()='Virtual Policy']"), "Perform Transaction Page", "Virtual Policy");
        List pt_declineReasonCode_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoDeclineQuoteTransHTML_CoTransInfo_ReasonCd_LST_comboboxinput']"), "Perform Transaction Page", "Reason Code");
    }

    public class PerformTransactionMethods implements PerformTransaction_Page.IPerformTransaction {
        public void enterDateCANC(Map<String, List<String>> testDataAsMap) {
            try {
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersDate(pt_transactionDate_text, testDataAsMap.get("cancDate").get(0));
                baseUtil.clicksOnNext();
                browserUtil.waitUntilPleaseWaitDisappear();
                try {
                    while (browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed()) {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                        browserUtil.switchToWindowWithHandle(parent);
                    }
                } catch (Exception e) {

                }
                System.out.println("******************Check UI Blocker - START******************");
                browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                System.out.println("******************Check UI Blocker - End******************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enterPolicyInfoForAudit(Map<String, List<String>> testDataAsMap) {
            try {
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                String transEffDateStart = testDataAsMap.get("Trans Eff Date Start").get(0);
                String transEffDateEnd = testDataAsMap.get("Trans Eff Date End").get(0);
                String transEffDate = transEffDateStart + " - " + transEffDateEnd;
                System.out.println(transEffDate);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(pt_transEffDateForAUDM_drpDwn);
                browserUtil.selectsValueFromDropDown2(transEffDate, pt_transEffDateForAUDM_drpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(pt_selectTransHistory_radioBtn);
                browserUtil.clicksWebElement(pt_selectTransHistory_radioBtn);
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.clicksOnNext();
                browserUtil.waitUntilPleaseWaitDisappear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enterPolicyInfoForPCNM(Map<String, List<String>> testDataAsMap) {
            try {
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.entersTextWithTabIn(pt_transactionDate_text, testDataAsMap.get("Trans Eff Date").get(0));
                browserUtil.entersDate(pt_transactionDate_text, testDataAsMap.get("Trans Eff Date").get(0));
                baseUtil.clicksOnNext();
                browserUtil.waitUntilPleaseWaitDisappear();
                // Below alert is for OoS
                //browserUtil.acceptsAlert();
                try {
                    while (browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).isDisplayed()) {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).click();
                        browserUtil.switchToWindowWithHandle(parent);
                        browserUtil.insertsHardCodedDelayInMilliSeconds(3000);
                        browserUtil.waitUntilPleaseWaitDisappear();
                    }
                } catch (Exception e) {

                }
                // Below alert is for Revised Audit due to OoS
                //browserUtil.acceptsAlert();
                //browserUtil.switchToChildWindow();
                //browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).click();
                //browserUtil.switchToWindowWithHandle(parent);
                //browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                System.out.println("******************Check UI Blocker - START******************");
                browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                System.out.println("******************Check UI Blocker - End******************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enterDeclineInfo(Map<String, List<String>> testDataAsMap) throws InterruptedException {
            browserUtil.waitsUntilWebElementIsClickable(pt_declineReasonCode_DrpDwn);
            browserUtil.CMPDropDown(testDataAsMap.get("ReasonCode").get(0), pt_declineReasonCode_DrpDwn);
            baseUtil.clicksOnNext();
        }

        public void enterPolicyInfoForPCNM2(Map<String, List<String>> testDataAsMap) {
            try {

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(pt_transactionDate_text);
                browserUtil.entersTextWithTabIn(pt_transactionDate_text, testDataAsMap.get("Trans Eff Date").get(0));
                baseUtil.clicksOnNext();
                try {
                    if (browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).isDisplayed()) {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Yes']")).click();
                        browserUtil.switchToWindowWithHandle(parent);
                        browserUtil.insertsHardCodedDelayInMilliSeconds(3000);
                        browserUtil.waitUntilPleaseWaitDisappear();
                    }
                } catch (Exception e) {

                }
                browserUtil.waitUntilPleaseWaitDisappear();

                System.out.println("******************Check UI Blocker - START******************");
                browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                System.out.println("******************Check UI Blocker - End******************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enterPolicyInfoForPCNMProd(Map<String, String> testDataAsMap) {
            try {
                browserUtil.switchToDefaultContent();
                browserUtil.switchToFrame("InsDmain");
                browserUtil.entersTextWithTabIn(pt_transactionDate_text, testDataAsMap.get("Trans Eff Date"));
                baseUtil.clicksOnNext();
                // Below alert is for OoS
                browserUtil.acceptsAlert();
                browserUtil.insertsHardCodedDelayInMilliSeconds(3000);
                // Below alert is for Revised Audit due to OoS
                browserUtil.acceptsAlert();
                browserUtil.switchToDefaultContent();
                browserUtil.switchToFrame("InsDmain");
                System.out.println("******************Check UI Blocker - START******************");
                browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                System.out.println("******************Check UI Blocker - End******************");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void enterDateTransaction(Map<String, List<String>> testDataAsMap, String transactionType) {
            try {
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");

                if (transactionType.equalsIgnoreCase("AUSL")) {
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.selectsValueFromDropDown2(testDataAsMap.get("auslDate").get(0), pt_transactionDate_text2);
                } else if (transactionType.equalsIgnoreCase("RAUS")) {
                    browserUtil.selectsValueFromDropDown2(testDataAsMap.get("rausDate").get(0), pt_transactionDate_text2);
                } else if (transactionType.equalsIgnoreCase("AUDV")) {
                    browserUtil.selectsValueFromDropDown2(testDataAsMap.get("audvDate").get(0), pt_transactionDate_text2);
                }
                baseUtil.clicksOnNext();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public PerformTransaction_Page.PerformTransactionMethods theUser_() {
        return this.pageMethods;
    }

}