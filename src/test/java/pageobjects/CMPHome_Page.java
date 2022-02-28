package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CMPHome_Page {
    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private IHomeMethods pageMethods;

    public CMPHome_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_Util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new IHomeMethods();
    }

    public interface IHome {
        List hp_searchCriteria_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput']"), "Home Page", "'SearchCriteria_DropDown'");
        List hp_searchDescription_text = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchDescription_FLD"), "Home Page", "'SearchDescription_TextBox'");
        List hp_policyAction2_DrpDwn = Arrays.asList(By.xpath("//select[@id='CoPolicySelectPg_PolicyGrid_ddTransactionList']"), "Home Page", "'PolicyAction_DropDown'");
        List hp_OnOffMsgClose = Arrays.asList(By.xpath("//div[@id='messageheader']//i[2]"), "Home Page", "'On/Off Message'");


        List hp_policyAction_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoPolicySelectPg_PolicyGrid_ddTransactionList_comboboxinput']"), "Home Page", "'PolicyAction_DropDown'");
        List hp_Search_Img = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_ButtonSelectPolicy"), "Home Page", "'Search_Img'");
        List hp_GoImg_Lnk = Arrays.asList(By.id("CoPolicySelectPg_PolicyGrid_cmdGoTransaction"), "Home Page", "'GoImg_Lnk'");
        List hp_transactionStatus_Text = Arrays.asList(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"), "Home Page", "Transaction Status");
        List hp_refreshStatus_Button = Arrays.asList(By.id("CoPolicySelectPg_PolicyGrid_cmdRefreshPolStatus"), "Home Page", "Refresh Status Button");
        List hp_transactionType_DrpDwn = Arrays.asList(By.xpath("//input[@id='CoPolicyCreateSelectHTML_DynamicStore_TransTypeCd_comboboxinput']"), "Home Page", "Transaction Type");
        List hp_policyEffectiveDate_Text = Arrays.asList(By.xpath("//label[text()='Policy Effective Date:']/../following-sibling::div//input"), "Home Page", "Policy Effective Date");
        List hp_createPolicy_Button = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_ButtonCreatePolicy"), "Home Page", "Create Policy Button");
        List hp_policyType_Button = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolicyTypeLob"), "Home Page", "Policy Type");
        List hp_auditSolicitation_Message = Arrays.asList(By.xpath("//label[text()='Your Solicitation Request Was Submitted Successfully.']"), "Home Page", "Audit Solicitation Completion Message");
        List hp_receivedAuditSolicitation_Message = Arrays.asList(By.xpath("//label[text()='Your transaction request is complete.']"), "Home Page", "Audit Solicitation Completion Message");
        List hp_TransactionStopOn_Message = Arrays.asList(By.xpath("//td[normalize-space()='Transaction Stop in effect - Other']"), "Home Page", "Transaction Stop On Message");
        List hp_TransactionStopOff_Message = Arrays.asList(By.xpath("//td[normalize-space()='Your transaction request is complete.']"), "Home Page", "Transaction Stop Off Message");
        List hp_policyType_DropDown = Arrays.asList(By.xpath("//input[@id='CoPolicyCreateSelectHTML_DynamicStore_PolicyTypeLob_comboboxinput']"), "Home Page", "Policy Type DropDown");
        List hp_demo = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_TransTypeCd"), "Home Page", "'Transc_Type'");
        List hp_policyType_DrpDwn = Arrays.asList(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolicyTypeLob"), "Home Page", "Policy Type");
        // List hp_policyAction_DrpDwn = Arrays.asList(By.id("//input[@id='CoPolicySelectPg_PolicyGrid_ddTransactionList_comboboxinput']"), "Home Page", "'PolicyAction_DropDown'");
        List hp_policyunlock_SAN_DrpDwn = Arrays.asList(By.xpath("//option[@value=\"SystemAssignId\"]//parent::select"), "Home Page", "Policy Type");
        List hp_policyunlock_SAN_textbox = Arrays.asList(By.xpath("//input[@id='UtPolicyUnlock_dgPolicyList_Paged_searchValue']"), "Home Page", "Policy Type");
        List hp_sanNumber_text = Arrays.asList(By.xpath("//td[@title='System Assign No. ']"), "Home Page", "SAN Number");
        List pt_transVirtualPolicy_btn = Arrays.asList(By.xpath("//span[text()='Virtual Policy']"), "Home Page", "Virtual Policy");

        List hp_Utility_link = Arrays.asList(By.xpath("//a[text()='Utilities']"), "Home Page", "Utility");


        public String sanNumber = "";
    }

    public class IHomeMethods implements IHome {
        public boolean flag = true;

        public String fetchSan() {
            String sanNumber = browserUtil.getsSANOrQuoteNumberFromWeb(hp_sanNumber_text);
            browserUtil.writesToLogAndReport("Done", "fetchSan: Retrieved '" + sanNumber + "' from UI.");
            return sanNumber;
        }

        public void convertQuoteToIssue(Map<String, String> testDataAsMap) {
            String QuoteNum = testDataAsMap.get("quoteNumber");
            String policyAction = testDataAsMap.get("policyAction");
            try {
                System.out.println(QuoteNum + policyAction);
                browserUtil.switchToFrame("InsDmain");
                browserUtil.selectsValueFromDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, QuoteNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                browserUtil.selectsValueFromDropDown("ISSUE", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String createNewQuoteFromExisting(Map<String, List<String>> testDataAsMap) {
            String QuoteNum = testDataAsMap.get("quoteNumber").get(0);
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {
                System.out.println(QuoteNum + policyAction);
                browserUtil.switchToFrame("InsDmain");
                browserUtil.selectsValueFromDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, QuoteNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                browserUtil.selectsValueFromDropDown("COPYNEW", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return QuoteNum;
        }

        public String createNewQuoteFromExistingRateMode(Map<String, String> testDataAsMap) {
            String QuoteNum = testDataAsMap.get("quoteNumber");
            String policyAction = testDataAsMap.get("policyAction");
            try {
                System.out.println(QuoteNum + policyAction);
                //browserUtil.switchToFrame("InsDmain");
                //browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                for (int i = 0; i < 4; i++) {
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Quote Number");
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
                browserUtil.waitUntilPleaseWaitDisappear();

                browserUtil.entersTextWithTabIn(hp_searchDescription_text, QuoteNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();

                //browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                browserUtil.CMPDropDown("Create New Quote from Existing Quote", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
                browserUtil.waitUntilPleaseWaitDisappear();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return QuoteNum;
        }

        public String editRateMode(Map<String, String> testDataAsMap) {
            String sanNum = testDataAsMap.get("sanNumber");
            String policyAction = testDataAsMap.get("policyAction");
            try {
                System.out.println(sanNum + policyAction);
                browserUtil.switchToFrame("InsDmain");
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNumber);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                deletesAnyTransactionInProgress();
                browserUtil.selectsValueFromDropDown("EDIT", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public String performRenewal(Map<String, String> testDataAsMap) {
            String sanNum = testDataAsMap.get("sanNumber");
            String policyAction = testDataAsMap.get("policyAction");
            try {
                browserUtil.switchToFrame("InsDmain");
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNumber);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                deletesAnyTransactionInProgress();
                browserUtil.selectsValueFromDropDown("REIS", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public void performReWrite(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.waitsUntilWebElementIsClickable(hp_policyAction_DrpDwn);
            browserUtil.CMPDropDown("EDIT", hp_policyAction_DrpDwn);
            browserUtil.clicksWebElement(hp_GoImg_Lnk);
        }

        public String performCancellation(Map<String, List<String>> testDataAsMap, String sanNumber) {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNumber);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();

                unlockpolicy(testDataAsMap); // This Method is for Unlock the policy
                deletesAnyTransactionInProgress(); // This Method is for delete transaction

                browserUtil.waitsUntilWebElementIsClickable(hp_policyAction_DrpDwn);
                browserUtil.CMPDropDown("CANC", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);

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
            } catch (UnhandledAlertException e) {
                browserUtil.getDriver().switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public String performReinstatement(Map<String, List<String>> testDataAsMap, String sanNumber) {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                //  browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                // deletesAnyTransactionInProgress();
                browserUtil.CMPDropDown("Reinstatement", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public String performChangeEndorsement(Map<String, String> testDataAsMap) {
            String sanNum = testDataAsMap.get("sanNumber");
            String policyAction = testDataAsMap.get("policyAction");
            try {
                browserUtil.switchToFrame("InsDmain");
                browserUtil.selectsValueFromDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                deletesAnyTransactionInProgress();
                browserUtil.selectsValueFromDropDown("PCNM", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        //Your transaction request was submitted successfully.

        public String performREISSUE(Map<String, List<String>> testDataAsMap, String sanNum) {
            try {
                browserUtil.CMPDropDown(testDataAsMap.get("policyAction").get(0), hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                unlockpolicy(testDataAsMap);
                try {
                    browserUtil.CMPDropDown(testDataAsMap.get("policyAction").get(0), hp_searchCriteria_DrpDwn);
                    browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                    browserUtil.clicksWebElement(hp_Search_Img);
                } catch (Exception e) {
                }
                browserUtil.CMPDropDown("EDIT", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public String performTransactionON(Map<String, List<String>> testDataAsMap, String sanNum) {
            try {
                browserUtil.CMPDropDown(testDataAsMap.get("policyAction").get(0), hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                unlockpolicy(testDataAsMap);
                try {
                    browserUtil.CMPDropDown(testDataAsMap.get("policyAction").get(0), hp_searchCriteria_DrpDwn);
                    browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                    browserUtil.clicksWebElement(hp_Search_Img);
                } catch (Exception e) {
                }
                browserUtil.clicksWebElement(hp_OnOffMsgClose);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown("MANU", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);

            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public String performTransaction(Map<String, List<String>> testDataAsMap, String transactionType, String sanNumber) {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
                //deletesAnyTransactionInProgress();
                browserUtil.CMPDropDown(transactionType, hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

        public void checkTransactionStatus(String sanNum) throws InterruptedException {
            int checkCounter;
            int loopCount = 35;
            WebElement transactionStatusLabel;
            // String policyAction = testDataAsMap.get("policyAction").get(0);
            try {

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                browserUtil.CMPDropDown("32", hp_searchCriteria_DrpDwn);
               /*for (int i = 0; i < 4; i++) {
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Sys.");
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
               */
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                transactionStatusLabel = browserUtil.driver.findElement(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"));
                for (checkCounter = 0; checkCounter < loopCount; checkCounter++) {
                    browserUtil.scrollsWebElementIntoView(transactionStatusLabel);
                    if (transactionStatusLabel.getText().equals("Available")) {
                        //System.out.println(transactionStatusLabel.getText());
                        //browserUtil.writesToLogAndReport("Pass", "checkTransactionStatus: Status available for SAN '" + sanNum + "'");
                        break;
                    }
                    browserUtil.clicksWebElement(hp_refreshStatus_Button);
                }
                if (transactionStatusLabel.getText().equals("Available")) {
                    System.out.println(transactionStatusLabel.getText());
                    browserUtil.writesToLogAndReport("Pass", "checkTransactionStatus: Status available for SAN '" + sanNum + "'");
                } else {
                    System.out.println(transactionStatusLabel.getText());
                    browserUtil.writesToLogAndReport("Fail", "checkTransactionStatus:" + transactionStatusLabel.getText() + " for SAN '" + sanNum + "'");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void checkNBQUTransactionStatus(String sanNum) throws InterruptedException {
            try {
                browserUtil.driver.findElement(By.xpath("//li/a[normalize-space()='Home']")).click();
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                browserUtil.CMPDropDown("32", hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void reWrCheckTransactionStatus(String sanNum) throws InterruptedException {
            int checkCounter;
            int loopCount = 35;
            WebElement transactionStatusLabel;
            // String policyAction = testDataAsMap.get("policyAction").get(0);
            try {

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                browserUtil.CMPDropDown("524288", hp_searchCriteria_DrpDwn);
               /*for (int i = 0; i < 4; i++) {
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Sys.");
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
               */
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();

                for (checkCounter = 0; checkCounter < loopCount; checkCounter++) {
                    transactionStatusLabel = browserUtil.driver.findElement(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"));
                    browserUtil.scrollsWebElementIntoView(transactionStatusLabel);
                    if (transactionStatusLabel.getText().equals("Available")) {
                        System.out.println(transactionStatusLabel.getText());
                        browserUtil.writesToLogAndReport("Pass", "checkTransactionStatus: Status available for SAN '" + sanNum + "'");
                        break;
                    }
                    browserUtil.clicksWebElement(hp_refreshStatus_Button);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void unlockpolicy(Map<String, List<String>> testDataAsMap) throws InterruptedException {
            WebElement transactionStatusLabel;
            transactionStatusLabel = browserUtil.driver.findElement(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"));
            browserUtil.scrollsWebElementIntoView(transactionStatusLabel);

            try {
                if (transactionStatusLabel.getText().equals("Locked - External")) {

                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Home']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Tools']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.waitsUntilWebElementIsClickable(hp_Utility_link);
                    browserUtil.driver.findElement(By.xpath("//a[text()='Utilities']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                   // browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
                   // browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Policy Unlock']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();


                    browserUtil.getDriver().findElement(By.id("UtPolicyUnlock_dgPolicyList_Paged_searchField")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

                    browserUtil.waitsUntilWebElementIsClickable(hp_policyunlock_SAN_textbox);
                    browserUtil.entersTextWithTabIn(hp_policyunlock_SAN_textbox, testDataAsMap.get("sanNumber").get(0));

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Find']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//table//tr//following-sibling::td[normalize-space()='" + testDataAsMap.get("sanNumber").get(0) + "']//parent::tr//td//child::input")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//button[normalize-space()='Unlock']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    browserUtil.driver.findElement(By.xpath("//a/span[text()='Home']")).click();
                    browserUtil.waitUntilPleaseWaitDisappear();

                    for (int i = 0; i < 4; i++) {
                        browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                    }
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Sys.");
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
                    browserUtil.entersTextWithTabIn(hp_searchDescription_text, testDataAsMap.get("sanNumber").get(0));
                    browserUtil.clicksWebElement(hp_Search_Img);
                    browserUtil.waitUntilPleaseWaitDisappear();
                }
            } catch (Exception e) {
            }
        }


        public void checkTransactionStatusRateMode(Map<String, String> testDataAsMap, String sanNum) throws InterruptedException {
            try {
                String policyAction = testDataAsMap.get("policyAction");
                //browserUtil.selectsValueFromDropDown("32", hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                for (int i = 0; i < 4; i++) {
                    browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys("Sys.");
                browserUtil.getDriver().findElement(By.id("CoPolicyCreateSelectHTML_DynamicStore_PolSearchCriteria_LST_comboboxinput")).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsForPageToBeLoaded();
                By id = browserUtil.getsLocatorFromWebElementDefinition(hp_transactionStatus_Text);
                for (int i = 0; i < 35; i++) {
                    WebElement transactionStatusLabel = browserUtil.driver.findElement(By.id("CoPolicySelectPg_PolicyGrid_lblProcessingStatus"));
                    browserUtil.scrollsWebElementIntoView(transactionStatusLabel);
                    if (transactionStatusLabel.getText().equals("Available")) {
                        System.out.println(transactionStatusLabel.getText());
                        break;
                    }
                    browserUtil.clicksWebElement(hp_refreshStatus_Button);
                    browserUtil.waitUntilPleaseWaitDisappear();
                }
            } catch (Exception e) {
            }
        }

        public void checkTransactionMessage(Map<String, List<String>> testDataAsMap) {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("pagestatus");
            switch (testDataAsMap.get("transactionType").get(0)) {
                case "AUSL":
                    browserUtil.verifiesExactMatchForVisibleText(testDataAsMap.get("auslMessage").get(0), hp_auditSolicitation_Message);
                    break;
                case "RAUS":
                    browserUtil.verifiesExactMatchForVisibleText(testDataAsMap.get("rausMessage").get(0), hp_receivedAuditSolicitation_Message);
                    break;
                case "MANU":
                    if (testDataAsMap.get("manuMessage").get(0).contains("Stop"))
                        browserUtil.verifiesExactMatchForVisibleText(testDataAsMap.get("manuMessage").get(0), hp_TransactionStopOn_Message);
                    else
                        browserUtil.verifiesExactMatchForVisibleText(testDataAsMap.get("manuMessage").get(0), hp_TransactionStopOff_Message);
                    break;
            }
        }

        public void viewTransaction(Map<String, List<String>> testDataAsMap, String TransType) throws InterruptedException {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                //browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                unlockpolicy(testDataAsMap);
                deletesAnyTransactionInProgress();
                browserUtil.CMPDropDown("VNEW", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.driver.findElement(By.xpath("//td[normalize-space()='" + TransType + "']//parent::tr//child::td[1]//input")).click();
            baseUtil.clicksOnNext();
            baseUtil.clicksOnNext();
            baseUtil.clicksOnNext();
            baseUtil.clicksOnNext();
            baseUtil.clicksOnNext();
            baseUtil.clicksOnNext();
            Thread.sleep(3000);
        }

        public void PerformCertifiedCopyofPolicy(Map<String, List<String>> testDataAsMap, String sanNumber) {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                //browserUtil.switchToFrame("CoPolicyCreateSelectHTML_IFPolicies");
                unlockpolicy(testDataAsMap);
                deletesAnyTransactionInProgress();
                browserUtil.CMPDropDown("CRTC", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            PerformVirtualPolicyDetails();
        }

        public void PerformVirtualPolicyDetails() {
            browserUtil.clicksWebElement(pt_transVirtualPolicy_btn);
           // browserUtil.driver.findElement(By.xpath("//i[@class='icon-remove icon-large error-panel-close-btn']")).click();
           // browserUtil.driver.findElement(By.xpath("//span[text()='Virtual Policy']")).click();
            // browserUtil.driver.findElement(By.xpath("//i[@class='icon-remove']")).click();
            try {
                String parent = browserUtil.getWindowHandle();
                browserUtil.switchToChildWindow();
                browserUtil.driver.findElement(By.xpath("//button[text()='Cancel']")).click();

                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToWindowWithHandle(parent);

            } catch (Exception e) {

            }
            browserUtil.waitUntilPleaseWaitDisappear();

        }


        public void createNewPolicy(Map<String, List<String>> testDataAsMap) {
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(hp_transactionType_DrpDwn);
            browserUtil.CMPDropDown(testDataAsMap.get("transTypeDrpDwn").get(0), hp_transactionType_DrpDwn);

            browserUtil.waitsUntilWebElementIsClickable(hp_policyType_DropDown);
            browserUtil.CMPDropDown(testDataAsMap.get("Policy_Type").get(0), hp_policyType_DropDown);

            // browserUtil.entersTextWithTabIn(hp_policyEffectiveDate_Text, testDataAsMap.get("Policy_Effective_Day").get(0));
            browserUtil.entersDate(hp_policyEffectiveDate_Text, testDataAsMap.get("Policy_Effective_Day").get(0));
            //browserUtil.clicksWebElement(hp_createPolicy_Button);
            browserUtil.clicksWebElementUsingJavaScriptExecutor(hp_createPolicy_Button);
            browserUtil.waitUntilPleaseWaitDisappear();

        }

        public void deletesAnyTransactionInProgress() {
            if (browserUtil.getsIndexOfCompleteOrPartialMatchingVisibleTextFromDropDown(hp_policyAction2_DrpDwn, "DELETE") > 0) {

                browserUtil.CMPDropDown("DELETE", hp_policyAction_DrpDwn);
                browserUtil.clicksWebElement(hp_GoImg_Lnk);

                try {
                    while (browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed()) {
                        String parent = browserUtil.getWindowHandle();
                        browserUtil.switchToChildWindow();
                        browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                        browserUtil.switchToWindowWithHandle(parent);
                    }
                } catch (Exception e) {
                }

                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public String performActionsOnPolicy(Map<String, List<String>> testDataAsMap, String action, String sanNumber) {
            String sanNum = sanNumber;
            String policyAction = testDataAsMap.get("policyAction").get(0);
            try {

                browserUtil.CMPDropDown(policyAction, hp_searchCriteria_DrpDwn);
                browserUtil.entersTextWithTabIn(hp_searchDescription_text, sanNum);
                browserUtil.clicksWebElement(hp_Search_Img);
                browserUtil.waitUntilPleaseWaitDisappear();

                //browserUtil.clicksWebElement(hp_transactionStatus_Text);

                unlockpolicy(testDataAsMap);

                deletesAnyTransactionInProgress();

                switch (action) {

                    case "VNEW":
                        browserUtil.CMPDropDown("VNEW", hp_policyAction_DrpDwn);
                        break;
                    case "CANC":
                        browserUtil.CMPDropDown("CANC", hp_policyAction_DrpDwn);
                        break;
                    case "CARS":
                        browserUtil.CMPDropDown("CARS", hp_policyAction_DrpDwn);
                        break;
                    case "PCNM":
                        browserUtil.CMPDropDown("PCNM", hp_policyAction_DrpDwn);
                        break;
                    case "AUDM":
                        browserUtil.CMPDropDown("AUDM", hp_policyAction_DrpDwn);
                        break;
                    case "AUDN":
                        browserUtil.CMPDropDown("AUDN", hp_policyAction_DrpDwn);
                        break;
                    case "AUDF":
                        browserUtil.CMPDropDown("AUDF", hp_policyAction_DrpDwn);
                        break;
                    case "AUDR":
                        browserUtil.CMPDropDown("AUDR", hp_policyAction_DrpDwn);
                        break;
                    case "PCNT":
                        browserUtil.CMPDropDown("PCNT", hp_policyAction_DrpDwn);
                        break;
                    case "NPAD":
                        browserUtil.CMPDropDown("NPAD", hp_policyAction_DrpDwn);
                        break;
                    case "REIS":
                        browserUtil.CMPDropDown("REIS", hp_policyAction_DrpDwn);
                        break;
                    case "AUDV":
                        browserUtil.CMPDropDown("AUDV", hp_policyAction_DrpDwn);
                        break;
                    case "DNRE":
                        browserUtil.CMPDropDown("DNRE", hp_policyAction_DrpDwn);
                        break;
                    case "RDNR":
                        browserUtil.CMPDropDown("RDNR", hp_policyAction_DrpDwn);
                        break;
                    case "MANU":
                        browserUtil.CMPDropDown("MANU", hp_policyAction_DrpDwn);
                        break;
                    case "RETR":
                        browserUtil.CMPDropDown("RETR", hp_policyAction_DrpDwn);
                        break;
                    case "DEPT":
                        browserUtil.CMPDropDown("DEPT", hp_policyAction_DrpDwn);
                        break;
                    case "DEPR":
                        browserUtil.CMPDropDown("DEPR", hp_policyAction_DrpDwn);
                        break;
                    case "NARR":
                        browserUtil.CMPDropDown("NARR", hp_policyAction_DrpDwn);
                        break;
                    case "REISSUE":
                        browserUtil.CMPDropDown("EDIT", hp_policyAction_DrpDwn);
                        break;
                    case "ERRC":
                        browserUtil.CMPDropDown("ERRC", hp_policyAction_DrpDwn);
                        break;
                    case "CIRT":
                        browserUtil.CMPDropDown("CIRT", hp_policyAction_DrpDwn);
                        break;
                    case "CRTC":
                        browserUtil.CMPDropDown("CRTC", hp_policyAction_DrpDwn);
                        break;
                    case "DECLINE":
                        browserUtil.CMPDropDown("DECLINE", hp_policyAction_DrpDwn);
                        break;
                }
                try {
                    browserUtil.clicksWebElement(hp_GoImg_Lnk);
                    browserUtil.waitUntilPleaseWaitDisappear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (UnhandledAlertException e) {
                browserUtil.driver.switchTo().alert().accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sanNum;
        }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public IHomeMethods theUser_() {
        return this.pageMethods;
    }

}