package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class Base_Util {
    public WebDriver driver;
    private Browser_Util browserUtil;
    private LogAndReport_Util logAndReport;
    private Screenshot_Util screenShot;

    List cp_TransactionInfo_link = Arrays.asList(By.xpath("//button[normalize-space()='Transaction Info']"), "Transaction Info", "Transaction Info");
    List pes_CommonExpand_Img = Arrays.asList(By.xpath("//button[normalize-space()='Common']/preceding-sibling::span[normalize-space()='+']"), "Policy Explorer", "'Common_Link'");
    List pes_Common_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Common']"), "Policy Explorer", "'Common_Link'");
    List pes_Names_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Names']"), "Policy Explorer", "'Names_Link'");
    List pes_FEINs_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='FEINs']"), "Policy Explorer", "'FEINs_Link'");
    List pes_IssuingInfoExpand_Img = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Issuing Info']/preceding-sibling::span[normalize-space()='+']"), "Policy Explorer", "'IssuingInfoExpand_Img'");
    List pes_IssuingInfo_Link = Arrays.asList(By.xpath("//button[normalize-space()='Issuing Info']"), "Policy Explorer", "'IssuingInfo_Link'");
    List pes_PolicyForms_Link = Arrays.asList(By.xpath("//button[normalize-space()='Policy Forms']"), "Policy Explorer", "'PolicyForms_Link'");
    List pes_ConvertToIssue_Link = Arrays.asList(By.xpath("//button[normalize-space()='Convert to Issue']"), "Policy Explorer", "'ConvertToIssue_Link'");
    List pes_RatingOptions_Link = Arrays.asList(By.xpath("//button[normalize-space()='Rating Options']"), "Policy Explorer", "'RatingOptions_Link'");
    List pes_ChangeNarratives_Link = Arrays.asList(By.xpath("//a[@title='Change Narratives' or @title='Change Narratives*']"), "Policy Explorer", "'ChangeNarratives_Link'");
    List pes_Underwriter_Link = Arrays.asList(By.xpath("//button[normalize-space()='Underwriter/Operator']"), "Policy Explorer", "'Underwriter_Link'");
    List pes_GLExpand_Img = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='General Liability']/preceding-sibling::span[normalize-space()='+']"), "Policy Explorer", "'GLExpand_Img'");
    List pes_CAPExpand_Img = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Capital Assets']/preceding-sibling::span[normalize-space()='+']"), "Policy Explorer", "'CAPExpand_Img'");
    List pes_RatingExpand_Img = Arrays.asList(By.xpath("//li[@role='treeitem']/div/button[text()='Rating Options']/preceding-sibling::span[normalize-space()='+']"), "Policy Explorer", "'GLExpand_Img'");
    List pes_GeneralLiability_Link = Arrays.asList(By.xpath("//button[normalize-space()='General Liability']"), "Policy Explorer", "'GeneralLiability_Link'");
    List pes_CapitalAssets_Link = Arrays.asList(By.xpath("//button[normalize-space()='Capital Assets']"), "Policy Explorer", "'CapitalAssets_Link'");
    List pes_WorkersCompState_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/ul/li/div/button[text()='States']"), "Policy Explorer", "'WorkersCompState_Link'");
    List pes_QuickClassCode_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/ul/li/div/button[text()='Quick Class Codes']"), "Policy Explorer", "'QuickClassCode_Link'");
    List pes_ClassCode_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/ul/li/div/button[text()='Class Codes']"), "Policy Explorer", "'ClassCode_Link'");
    List pes_LocationsExpand_Img = Arrays.asList(By.xpath("//a[@title='Locations' or @title='Locations*']/preceding-sibling::img[contains(@title, 'Collapsed']"), "Policy Explorer", "'LocationsExpand_Img'");
    List pes_Locations_Link = Arrays.asList(By.xpath("//a[@title='Locations'or @title='Locations*']"), "Policy Explorer", "'Locations_Link'");
    List pes_CAPLocations_Link = Arrays.asList(By.xpath("//button[normalize-space()='Locations']"), "Policy Explorer", "'CAPLocations_Link'");
    List pes_Issue_Link = Arrays.asList(By.xpath("//button[normalize-space()='Issue']"), "Policy Explorer", "'Issue_Link'");
    List pes_Billing_Link = Arrays.asList(By.xpath("//button[normalize-space()='Billing']"), "Policy Explorer", "'Billing_Link'");
    List pes_MiscInformation_Link = Arrays.asList(By.xpath("//a[@title='Misc Information' or contains(normalize-space(), 'Misc Information')]"), "Policy Explorer", "'MiscInformation_Link'");
    List pes_RatingGroupManager_Link = Arrays.asList(By.xpath("//li[@role='treeitem']/ul/li/div/button[text()='Rating Group Manager']"), "Policy Explorer", "'RatingGroupManager_Link'");
    List lp_SaveLink_Img = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), "Locations Page", "SaveLink_Img ");
    List pd_NextLink_Img = Arrays.asList(By.xpath("//div[contains(@class, 'span12')]//button[@title='Next']"), "Policy Decisions", "pes_NextLink_Img");

    public Base_Util(WebDriver webDriver, Screenshot_Util screenShot, LogAndReport_Util logAndReport, Browser_Util browser_Util) {
        this.browserUtil = browser_Util;
        this.driver = webDriver;
        this.logAndReport = logAndReport;
        this.screenShot = screenShot;
    }

    public void navigatesToSpecifiedLinkOnPolicyExplorer(String nameOfTheLinkOnPolicyExplorer) {
        String reportInfo;
        try {
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("screennav");
            switch (nameOfTheLinkOnPolicyExplorer) {
                case "COMMON":
                    do {
                        browserUtil.clicksWebElement(pes_Common_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Common_Link, "class", "NodeSelected"));
                    break;
                case "UNDERWRITER/OPERATOR":
                    if (browserUtil.verifiesWebElementIsPresent(pes_CommonExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_CommonExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_CommonExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_Underwriter_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Underwriter_Link, "class", "NodeSelected"));
                    break;

                case "Transaction Info":
                    if (browserUtil.verifiesWebElementIsPresent(pes_CommonExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_CommonExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_CommonExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(cp_TransactionInfo_link);
                        try {
                            browserUtil.clicksWebElement(cp_TransactionInfo_link);
                        } catch (Exception e) {
                        }
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(cp_TransactionInfo_link, "class", "NodeSelected"));
                    break;

                case "Capital Asset":
                    do {
                        browserUtil.clicksWebElement(pes_CapitalAssets_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_CapitalAssets_Link, "class", "NodeSelected"));
                    break;

                case "General Liability":
                    do {
                        browserUtil.clicksWebElement(pes_GeneralLiability_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_GeneralLiability_Link, "class", "NodeSelected"));
                    break;
                case "STATES":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_WorkersCompState_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_WorkersCompState_Link, "class", "NodeSelected"));
                    break;
                case "CLASS CODE":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_ClassCode_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_ClassCode_Link, "class", "NodeSelected"));
                    break;
                /*case "CLASS CODES":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_ClassCode_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_ClassCode_Link, "class", "NodeSelected"));
                    break;*/
                case "NAMES":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_Names_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Names_Link, "class", "NodeSelected"));
                    break;
                case "FEINS":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_FEINs_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_FEINs_Link, "class", "NodeSelected"));
                    break;
                case "RATING OPTIONS":
                    if (browserUtil.verifiesWebElementIsPresent(pes_RatingExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_RatingExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_RatingExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_RatingOptions_Link);
                        try
                        {
                            browserUtil.clicksWebElement(pes_RatingOptions_Link);
                        }catch(Exception e){}
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_RatingOptions_Link, "class", "NodeSelected"));
                    break;

                case "CAP LOCATIONS":
                    if (browserUtil.verifiesWebElementIsPresent(pes_CAPExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_CAPExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_CAPExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_CAPLocations_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_CAPLocations_Link, "class", "NodeSelected"));
                    break;

                case "LOCATIONS":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_Locations_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Locations_Link, "class", "NodeSelected"));
                    break;
                case "RATING GROUP MANAGER":
                    if (browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_GLExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_GLExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_RatingGroupManager_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_RatingGroupManager_Link, "class", "NodeSelected"));
                    break;
                case "ISSUING INFO":
                    do {
                        browserUtil.clicksWebElement(pes_IssuingInfo_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_IssuingInfo_Link, "class", "NodeSelected"));
                    break;
                case "BILLING":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_Billing_Link);
                        try
                        {
                            browserUtil.clicksWebElement(pes_Billing_Link);
                        }catch(Exception e){}
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Billing_Link, "class", "NodeSelected"));
                    break;
                case "MISC INFORMATION":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (!browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_MiscInformation_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_MiscInformation_Link, "class", "NodeSelected"));
                    break;
                case "POLICY FORMS":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_PolicyForms_Link);
                    } while (!browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_PolicyForms_Link, "tabindex", "0"));
                    break;
                case "ISSUE":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_Issue_Link);
                    } while (!browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_Issue_Link, "tabindex", "0"));
                    break;
                case "CONVERTS TO ISSUE":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_ConvertToIssue_Link);
                    } while (browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_ConvertToIssue_Link, "tabindex", "0"));
                    break;
                case "CHANGE NARRATIVES":
                    if (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img)) {
                        do {
                            browserUtil.clicksWebElement(pes_IssuingInfoExpand_Img);
                        } while (browserUtil.verifiesWebElementIsPresent(pes_IssuingInfoExpand_Img));
                    }
                    do {
                        browserUtil.clicksWebElement(pes_ChangeNarratives_Link);
                    } while (!browserUtil.verifiesSpecifiedAttributeOfWebElementContainsValue(pes_ChangeNarratives_Link, "class", "NodeSelected"));
                    break;
                default:
                    browserUtil.switchToDefaultContent();
                    break;
            }
            reportInfo = "Navigated to '" + nameOfTheLinkOnPolicyExplorer + "' on 'Policy Explorer'";
            System.out.println(reportInfo);
            browserUtil.writesToLogAndReport("Pass", reportInfo);
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().accept();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            browserUtil.switchToDefaultContent();
            browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
        }
    }

    public void navigatesToCommonLinkOnPolicyExplorer() {
        try {
            navigatesToSpecifiedLinkOnPolicyExplorer("COMMON");
            if (browserUtil.verifiesAlertIsPresent() == true) {
                driver.switchTo().alert().accept();
            }
            navigatesToSpecifiedLinkOnPolicyExplorer("COMMON");
            if (browserUtil.verifiesAlertIsPresent() == true) {
                driver.switchTo().alert().accept();
            }
            navigatesToSpecifiedLinkOnPolicyExplorer("COMMON");
            if (browserUtil.verifiesAlertIsPresent() == true) {
                driver.switchTo().alert().accept();
            }
            browserUtil.switchToDefaultContent();
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().accept();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clicksOnSave() {
        browserUtil.clicksWebElement(lp_SaveLink_Img);
    }

    public void clicksOnNext() throws InterruptedException {
        //browserUtil.switchToDefaultContent();
        //browserUtil.switchToFrame("InsDmain");
        browserUtil.clicksWebElement(pd_NextLink_Img);
    }

}