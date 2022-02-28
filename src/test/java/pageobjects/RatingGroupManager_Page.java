package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingGroupManager_Page {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private RatingGroupManager_Page.RatingGroupManagerPageMethods pageMethods;

    public RatingGroupManager_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new RatingGroupManager_Page.RatingGroupManagerPageMethods();
    }

    public interface IRatingGroupManager {
        List rgm_groupName_Text = Arrays.asList(By.id("WkRateGrpMgrDetailHTML_WkRatingGroup_RatingGrpTx_FLD"), "Rating Group Manager Page", "Group Name");
        List rgm_subGroupName_Text = Arrays.asList(By.id("WkRateGrpMgrDetailHTML_WkRatingGroup_SubRatingGrpTx_FLD"), "Rating Group Manager Page", "Sub Group Name");
        List addNewRatingGroup_Button = Arrays.asList(By.id("WkRateGrpMgrEdit_dgRateGrpMgrList_Row_AddNew"), "Rating Group Manager", "Add New Button");
        List ratingGroupSelectState_DrpDwn = Arrays.asList(By.id("WkRateGrpMgrEdit_ddStates_comboboxinput"), "Rating Group Manager Page", "Add Rating Group Dropdown");
    }

    public class RatingGroupManagerPageMethods implements RatingGroupManager_Page.IRatingGroupManager {
        public void addRatingGroupManagerInformation(Map<String, List<String>> map, int i) throws InterruptedException {
            if (map.get("RatingGroupManager_Flag").get(0).equalsIgnoreCase("Yes")) {
                int index = 0;

                browserUtil.selectsValueFromDropDown2(map.get("Rating_Group_State").get(i), ratingGroupSelectState_DrpDwn);
                browserUtil.clicksWebElement(addNewRatingGroup_Button);
                browserUtil.waitUntilPleaseWaitDisappear();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.entersTextWithTabIn(rgm_groupName_Text, map.get("Rating_Group_Name").get(i));
                browserUtil.entersTextWithTabIn(rgm_subGroupName_Text, map.get("Rating_Sub_Group_Name").get(i));

                List<WebElement> checkboxList = browserUtil.driver.findElements(By.xpath("//input[contains(@title,'Select') or contains(@title,'Select')]"));
                System.out.println(checkboxList.size());
                String indexNumber = map.get("Location_Rating_Group_Link").get(i).trim();
                index = Integer.parseInt(indexNumber);
                if (map.get("TestCase_ID").get(0).equalsIgnoreCase("1010") || map.get("TestCase_ID").get(0).equalsIgnoreCase("1009")) {
                    if (map.get("Rating_Group_State_Short").get(i).equalsIgnoreCase("NV")) {
                        checkboxList.get(0).click();
                        Thread.sleep(2000);
                        checkboxList.get(1).click();
                    } else {
                        checkboxList.get(index - 1).click();
                    }
                } else {
                    checkboxList.get(index - 1).click();
                }
                baseUtil.clicksOnSave();
                browserUtil.waitUntilPleaseWaitDisappear();
            }
        }

        public void updateRatingGroupManagerInformation(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("RatingGroupManager_Flag").get(0).equalsIgnoreCase("Yes")) {
                if (map.get("Transaction_Type").get(0).equalsIgnoreCase("NBIS") || map.get("Transaction_Type").get(0).equalsIgnoreCase("RCIS")) {
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING GROUP MANAGER");
                    browserUtil.waitUntilPleaseWaitDisappear();
                    for (int i = 0; i < map.get("Rating_Group_State").size(); i++) {
                        //browserUtil.switchToDefaultContent();
                        //browserUtil.switchToFrame("InsDmain");
                        //browserUtil.switchToFrame("IFRateGrpMgr");
                        if (map.get("Rating_Group_State").get(i).equalsIgnoreCase("$$NA$$")) {
                            break;
                        }
                        addRatingGroupManagerInformation(map, i);
                    }
                } else if (map.get("Transaction_Type").get(0).equalsIgnoreCase("PCNM")) {
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("WORKERS COMP");
                    browserUtil.waitUntilPleaseWaitDisappear();
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING GROUP MANAGER");
                    browserUtil.waitUntilPleaseWaitDisappear();
                    //browserUtil.switchToDefaultContent();
                    //browserUtil.switchToFrame("InsDmain");
                    //browserUtil.switchToFrame("IFRateGrpMgr");
                    for (int i = 0; i < map.get("Performing_Action_Rating_Group").size(); i++) {
                        String performingAction = map.get("Performing_Action_Rating_Group").get(i);
                        if (!performingAction.equalsIgnoreCase("$$NA$$")) {
                            switch (performingAction) {
                                case "ADD":
                                    browserUtil.switchToDefaultContent();
                                    //browserUtil.switchToFrame("InsDmain");
                                    //browserUtil.switchToFrame("IFRateGrpMgr");
                                    addRatingGroupManagerInformation(map, i);
                                    break;
                                case "DELETE":
                                    List rgm_DeleteRatingGroup_Img;
                                    rgm_DeleteRatingGroup_Img = Arrays.asList(By.xpath("//div[contains(@id, 'RateGrpMgrList')]//table//tr[(./td[normalize-space()='" + map.get("Rating_Group").get(i).trim() + "']) and (./td[normalize-space()='" + map.get("Rating_Group_State_Short").get(i).trim() + "'])]//i[@title='Delete Rating Group']"), "Rating Group Manager", "'DeleteRatingGroup_Img' (" + map.get("Rating_Group").get(i).trim() + ", " + map.get("Rating_Group_State_Short").get(i).trim() + ")");
                                    //browserUtil.switchToDefaultContent();
                                    //browserUtil.switchToFrame("InsDmain");
                                    //browserUtil.switchToFrame("IFRateGrpMgr");
                                    browserUtil.clicksWebElement(rgm_DeleteRatingGroup_Img);
                                    browserUtil.waitUntilPleaseWaitDisappear();
                                    /*
                                    By deleteRow = By.xpath("//td[text()='" + map.get("Rating_Group").get(i) + "']/following-sibling::td[text()='" + map.get("Rating_Group_State_Short").get(i) + "']/following-sibling::td/a/img[@title='Delete Rating Group']");
                                    WebElement deleteElement = browserUtil.findsWebElementWithLocatorWithinDefaultTimeout(deleteRow);
                                    deleteElement.click();
                                    */
                                    //browserUtil.acceptsAlert();
                                    String parent = browserUtil.getWindowHandle();
                                    browserUtil.switchToChildWindow();
                                    browserUtil.driver.findElement(By.xpath("//button[text()='Ok']")).click();
                                    browserUtil.switchToWindowWithHandle(parent);
                                    //browserUtil.switchToDefaultContent();
                                    //browserUtil.switchToFrame("InsDmain");
                                    System.out.println("******************Check UI Blocker - START******************");
                                    browserUtil.waitsForLoadingToCompleteWithinStandardTimeout();
                                    System.out.println("******************Check UI Blocker - End******************");
                                    //browserUtil.switchToFrame("IFRateGrpMgr");
                                    break;
                            }
                        }
                    }
                }
            }
        }

        //This method is write for scenario 3 only. As issue is fix for scenario 3, delete this method also.
        public void updateRatingGroupManagerInformationForScenario3(Map<String, List<String>> map) throws InterruptedException {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("RATING GROUP MANAGER");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.selectsValueFromDropDown2("California", ratingGroupSelectState_DrpDwn);
            browserUtil.clicksWebElement(addNewRatingGroup_Button);
            browserUtil.waitUntilPleaseWaitDisappear();

        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public RatingGroupManager_Page.RatingGroupManagerPageMethods theUser_() {
        return this.pageMethods;
    }

}