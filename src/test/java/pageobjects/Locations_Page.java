package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.util.*;

/**
 * Created by Sapna Gour on 2/1/2018.
 */
public class Locations_Page {

    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Locations_Page.LocationsMethods pageMethods;
    private String parent;

    public Locations_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Locations_Page.LocationsMethods();
    }

    public interface ILocations {
        String pageName = "CP Locations";

        List lp_addLocation_Btn = Arrays.asList(By.id("WkEntityLocationsEdit_dgEntLocationList_Row_AddNew"), pageName, "Add Location image");
        List lp_locationNameInfoAddNew_Btn = Arrays.asList(By.id("WkEntityLocationDetailHTML_imgAddNewName"), pageName, "Add New Location Name Info");
        List lp_locationNameInfo_Txt = Arrays.asList(By.xpath("//span[@class='flex']/textarea[@id='WkEntityNameDetailHTML_WkLegalEntityName_LegalEntityNm']"), pageName, "Location Name Info");
        List lp_locationNameInfoAdd_Btn = Arrays.asList(By.id("saveAndClose"), pageName, "Location Name Info - Add Button");
        List lp_locationAddressInfoAddNew_Btn = Arrays.asList(By.id("WkEntityLocationDetailHTML_imgAddNewAddress"), pageName, "Add New Location Address Info");
        List lp_locationAddressInfoAdd_Btn = Arrays.asList(By.id("saveAndClose"), pageName, "Location Address Info - Add Button");
        List lp_locationAddressState_DrpDwn = Arrays.asList(By.id("WkEntityAddressDetailHTML_WkAddress_StateCd_LST_comboboxinput"), pageName, "Location Address State");
        List lp_locationAddressInfo_Txt = Arrays.asList(By.id("WkEntityAddressDetailHTML_WkAddress_AddrLine1Tx_FLD"), pageName, "Location Address Info");
        List lp_locationAddressCity_Txt = Arrays.asList(By.id("WkEntityAddressDetailHTML_WkAddress_CityNm_FLD"), pageName, "Location Address City");
        List lp_locationAddressZip_Txt = Arrays.asList(By.id("WkEntityAddressDetailHTML_WkAddress_ZipCd_FLD"), pageName, "Location Address Zip");
        List lp_locationFEINInfoAddNew_Btn = Arrays.asList(By.id("WkEntityLocationDetailHTML_imgAddNewFEIN"), pageName, "Add New FEIN Info");
        List lp_locationFEINInfoAdd_Btn = Arrays.asList(By.id("saveAndClose"), pageName, "FEIN - Add Button");
        List lp_locationFEIN_Txt = Arrays.asList(By.id("WkEntityFEINDetailHTML_WkLegalEntity_FEINId_FLD"), pageName, "FEIN Number");
        List lp_locationFEINSICCode_Txt = Arrays.asList(By.id("WkEntityFEINDetailHTML_WkLegalEntity_SicCd_FLD"), pageName, "FEIN SIC Code");
        List lp_locationFEINNAICCode_Txt = Arrays.asList(By.id("WkEntityFEINDetailHTML_WkLegalEntity_NAICCd_FLD"), pageName, "FEIN NAIC Code");
        List lp_locationNoEmployees_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_EmployeeCt_FLD"), pageName, "Location No Employees");
        List lp_locationOkToEmail_DrpDwn = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_EmailInd_LST_comboboxinput"), pageName, "Location OK to Email");
        List lp_locationSave_Btn = Arrays.asList(By.xpath("//div[@class='span12']/button[@title='Save']"), pageName, "Save Button");
        List lp_contactName_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_ContactNm_FLD"), pageName, "Contact Name");
        List lp_phone_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_PhoneNo_FLD"), pageName, "Phone");
        List lp_UIAN_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_UainCd_FLD"), pageName, "UIAN");
        List lp_lossControlInd_DrpDwn = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_OvrdLossControlInd_LST_comboboxinput"), pageName, "Loss Control Indicator");
        List lp_Workplace_DrpDwn = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_WorkplaceInd_LST_comboboxinput"), pageName, "Workplace");
        List lp_locationFacilityDesc_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_FacilityDescTx_FLD"), pageName, "Facility Description");
        List lp_locationFacilityCode_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_FacilityCd_FLD"), pageName, "Facility Code");
        List lp_locationDeptCode_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_DeptCd_FLD"), pageName, "Dept Code");
        List lp_auditEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_AuditEmailAddrTx_FLD"), pageName, "Audit Email Address");
        List lp_accountingDeptEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_AcctEmailAddrTx_FLD"), pageName, "Accounting Dept Email Address");
        List lp_claimsEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_ClaimEmailAddrTx_FLD"), pageName, "Claims Email Address");
        List lp_lossControlEmailAddress_Txt = Arrays.asList(By.id("WkEntityLocationDetailHTML_WkLocation_LCEmailAddrTx_FLD"), pageName, "Loss Control Email Address");

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Location
        List cp_addLocation_button = Arrays.asList(By.xpath("//button[contains(.,'Add Location')]"), pageName, "Add Location");
        List cp_locationNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Location No:')]/..//following-sibling::div[1]//input"), pageName, "Location No");
        List cp_buildingNo_textBox = Arrays.asList(By.xpath("//label[contains(.,'Building No:')]/..//following-sibling::div[1]//input"), pageName, "Building No");
        List cp_streetAddress_textBox = Arrays.asList(By.xpath("//label[contains(.,'Street Address:')]/..//following-sibling::div[1]//input"), pageName, "Street Address");
        List cp_city_textBox = Arrays.asList(By.xpath("//label[contains(.,'City:')]/..//following-sibling::div[1]//input"), pageName, "City");
        List cp_country_textBox = Arrays.asList(By.id("CoLocBldgAddSelectHTML_CoLocation_CountyNm_FLD"), pageName, "Country");
        List cp_zipCode_textBox = Arrays.asList(By.xpath("//label[contains(.,'Zip Code:')]/..//following-sibling::div[1]//input"), pageName, "Zip Code");
        List cp_saveAndClose_button = Arrays.asList(By.xpath("//button[contains(.,'Save and Close')]"), pageName, "Save and Close");

        //Location Info
        List cp_BG_1_Terr_textBox = Arrays.asList(By.xpath("//label[contains(.,'BG 1 Terr:')]/..//following-sibling::div[1]//input"), pageName, "BG 1 Terr");
        List cp_BG_2_Terr_textBox = Arrays.asList(By.xpath("//label[contains(.,'BG 2 Terr/Zone:')]/..//following-sibling::div[1]//input"), pageName, "BG 2 Terr");
        List cp_Protection_Class_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Protection Class:')]/..//following-sibling::div[1]//input"), pageName, "Protection Class");
        List cp_CSP_Terr_textBox = Arrays.asList(By.xpath("//label[contains(.,'CSP Terr:')]/..//following-sibling::div[1]//input"), pageName, "CSP Terr");
        List cp_Const_Year_textBox = Arrays.asList(By.xpath("//label[contains(.,'Const Year:')]/..//following-sibling::div[1]//input"), pageName, "Const Year");
        List cp_Construction_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Construction:')]/..//following-sibling::div[1]//input"), pageName, "Construction");
        List cp_Rate_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Rate Type:')]/..//following-sibling::div[1]//input"), pageName, "Rate Type");
        List cp_Sprinkler_Drpdwn = Arrays.asList(By.xpath("//input[@id='PfLocationDetailHTML_PfLocInput_SpklrProtTypeCd_LST_comboboxinput']"), pageName, "Sprinkler");
        List cp_BG_2_Construction_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'BG 2 Construction:')]/..//following-sibling::div[1]//input"), pageName, " BG 2 Construction");
        List cp_BG_2_Sym_textbox = Arrays.asList(By.xpath("//label[contains(.,'BG 2 Sym:')]/..//following-sibling::div[1]//input"), pageName, "BG 2 Sym");

        //Coverages
        List cp_Coverages_Link = Arrays.asList(By.xpath("//li[@title='Coverages']"), pageName, "Coverages");
        List cp_Location_Info_Link = Arrays.asList(By.xpath("//li[@title='Location Info']"), pageName, "Location Info");
        List cp_Location_Coverages_Drpdwn = Arrays.asList(By.xpath("//input[@id='PfLocCovgsEdit_cboAddCoverage_comboboxinput']"), pageName, "Location_Coverages");
        List cp_Add_Coverage_button = Arrays.asList(By.xpath("//button[contains(.,'Add Coverage')]"), pageName, "Add Coverages");


        //Coverages Fields
        List cp_Coverage_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Coverage Type')]/..//following-sibling::div[1]//input"), pageName, "Coverage Type");
        List cp_Limit_textdwn = Arrays.asList(By.xpath("//label[contains(.,'Limit:')]/..//following-sibling::div[1]//input"), pageName, "Limit");
        List cp_Valuation_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Valuation:')]/..//following-sibling::div[1]//input"), pageName, "Valuation");
        List cp_Blanket_ID_textdwn = Arrays.asList(By.xpath("//label[contains(.,'Blanket ID:')]/..//following-sibling::div[1]//input"), pageName, "Blanket ID");
        List cp_Class_Code_textdwn = Arrays.asList(By.xpath("//label[contains(.,'Class Code:')]/..//following-sibling::div[1]//input"), pageName, "Class Code");
        List cp_Cause_Of_Loss_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Cause Of Loss:')]/..//following-sibling::div[1]//input"), pageName, "Cause Of Loss");
        List cp_BG1_Rate_textdwn = Arrays.asList(By.xpath("//label[contains(.,'BG1 Rate:')]/..//following-sibling::div[1]//input"), pageName, "BG1 Rate");
        List cp_VMM_Excl_checkbox = Arrays.asList(By.xpath("//label[normalize-space()='VMM Excl:']/..//following-sibling::div[1]/input"), pageName, "VMM Excl");
        List cp_Spkl_Excl_checkbox = Arrays.asList(By.xpath("//label[normalize-space()='Spkl Excl:']/..//following-sibling::div[1]/input"), pageName, "Spkl Excl");
        List cp_Covg_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Covg Type:')]/..//following-sibling::div[1]//input"), pageName, "Coverage Type");
        List cp_BPP_RG_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'BPP RG:')]/..//following-sibling::div[1]//input"), pageName, "BPP RG");
        List cp_Risk_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Risk Type:')]/..//following-sibling::div[1]//input"), pageName, "Risk Type");
        List cp_Indemnity_Type_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Indemnity Type:')]/..//following-sibling::div[1]//input"), pageName, "Indemnity Type");
        List cp_Spoilage_Class_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Spoilage Class:')]/..//following-sibling::div[1]//input"), pageName, "Spoilage Class");
        List cp_Ded_Amt_Ovrd_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Ded Amt Ovrd:')]/..//following-sibling::div[1]//input"), pageName, "Ded Amt Ovrd");

        //Overrides
        List cp_Overrides_Link = Arrays.asList(By.xpath("//li[@title='Overrides']"), pageName, "Overrides");
        List cp_All_Other_COL_Ovrd_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'All Other COL Ovrd:')]/..//following-sibling::div[1]//input"), pageName, "All Other COL Ovrd");
        List cp_Wind_Hail_Ovrd_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Wind / Hail Ovrd:')]/..//following-sibling::div[1]//input"), pageName, "Wind / Hail Ovrd");
        List cp_Theft_Ovrd_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Theft Ovrd:')]/..//following-sibling::div[1]//input"), pageName, "Theft Ovrd");
        List cp_Deductible_Option_Drpdwn = Arrays.asList(By.xpath("//label[contains(.,'Deductible Option:')]/..//following-sibling::div[1]//input"), pageName, "Deductible Option");

    }

    public class LocationsMethods implements Locations_Page.ILocations {
        public void addLocations(Map<String, List<String>> map, int i, String action) throws InterruptedException {
            if (map.get("Location_Flag").get(0).equalsIgnoreCase("Yes")) {
                if (action.equalsIgnoreCase("ADD")) {
                    //browserUtil.switchToDefaultContent();
                    //browserUtil.switchToFrame("InsDmain");
                    //browserUtil.switchToFrame("WkEntityLocationsEdit_IFEntity");
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.clicksWebElement(lp_addLocation_Btn);
                    browserUtil.waitUntilPleaseWaitDisappear();
                    browserUtil.waitsForPageToBeLoaded();
                    if (browserUtil.driver.findElement(By.xpath("//button[@class='btn btn-medium']/span[text()='Reload']")).isDisplayed()) {
                        browserUtil.driver.findElement(By.xpath("//button[@class='btn btn-medium']/span[text()='Reload']")).click();
                        browserUtil.waitsUntilWebElementIsClickable(lp_addLocation_Btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.clicksWebElement(lp_addLocation_Btn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                    }

                }
                parent = browserUtil.getWindowHandle();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitsForPageToBeLoaded();
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(lp_locationNameInfoAddNew_Btn);
                browserUtil.clicksWebElement(lp_locationNameInfoAddNew_Btn);
                try {
                    browserUtil.clicksWebElement(lp_locationNameInfoAddNew_Btn);
                } catch (Exception e) {

                }
                //Thread.sleep(10000);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.waitsUntilWebElementIsClickable(lp_locationNameInfo_Txt);
                browserUtil.entersTextWithTabIn(lp_locationNameInfo_Txt, map.get("Location_Name_Info").get(i));
                browserUtil.clicksWebElement(lp_locationNameInfoAdd_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToWindowWithHandle(parent);
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitsUntilWebElementIsClickable(lp_locationAddressInfoAddNew_Btn);
                browserUtil.clicksWebElement(lp_locationAddressInfoAddNew_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                try {
                    //if (i==1)
                    //Thread.sleep(5000);
                    browserUtil.clicksWebElement(lp_locationAddressInfoAddNew_Btn);
                } catch (Exception e) {

                }
                //  browserUtil.switchToChildWindow();

                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.waitsUntilWebElementIsClickable(lp_locationAddressState_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("Location_Address_State").get(i), lp_locationAddressState_DrpDwn);
                browserUtil.entersTextWithTabIn(lp_locationAddressInfo_Txt, map.get("Location_Address_Info").get(i));
                browserUtil.entersTextWithTabIn(lp_locationAddressCity_Txt, map.get("Location_Address_City").get(i));
                browserUtil.entersTextWithTabIn(lp_locationAddressZip_Txt, map.get("Location_Address_ZIP").get(i));
                browserUtil.clicksWebElement(lp_locationAddressInfoAdd_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToWindowWithHandle(parent);
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.clicksWebElement(lp_locationFEINInfoAddNew_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                //browserUtil.switchToDefaultContent();
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.entersTextWithTabIn(lp_locationFEIN_Txt, map.get("Location_FEIN_Number").get(i));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(lp_locationFEINSICCode_Txt, map.get("Location_FEIN_SIC").get(i));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(lp_locationFEINNAICCode_Txt, map.get("Location_NAIC_Code").get(i));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.clicksWebElement(lp_locationFEINInfoAdd_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToWindowWithHandle(parent);
                //browserUtil.switchToFrame("InsDmain");
                browserUtil.entersTextWithTabIn(lp_contactName_Txt, map.get("Location_Contact_Name").get(i));
                browserUtil.entersTextWithTabIn(lp_phone_Txt, map.get("Location_Phone").get(i));
                browserUtil.entersTextWithTabIn(lp_locationFacilityCode_Txt, map.get("Location_Facility_Code").get(i));
                browserUtil.entersTextWithTabIn(lp_locationFacilityDesc_Txt, map.get("Location_Facility_Description").get(i));
                browserUtil.entersTextWithTabIn(lp_locationDeptCode_Txt, map.get("Location_Dept_Code").get(i));
                browserUtil.entersTextWithTabIn(lp_auditEmailAddress_Txt, map.get("Location_Audit_Email_Address").get(i));
                browserUtil.entersTextWithTabIn(lp_accountingDeptEmailAddress_Txt, map.get("Location_Accounting_Department_Email_Address").get(i));
                browserUtil.entersTextWithTabIn(lp_claimsEmailAddress_Txt, map.get("Location_Claims_Email_Address").get(i));
                browserUtil.entersTextWithTabIn(lp_lossControlEmailAddress_Txt, map.get("Location_Loss_Control_Email_Address").get(i));
                browserUtil.selectsValueFromDropDown2(map.get("Location_Loss_Control_Ind_Ovrd").get(i), lp_lossControlInd_DrpDwn);
                //browserUtil.waitsUntilWebElementIsClickable(lp_locationNoEmployees_Txt);
                //Thread.sleep(5000);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(lp_locationNoEmployees_Txt, map.get("Location_No_Employees").get(i));
                browserUtil.selectsValueFromDropDown2(map.get("Location_Workplace").get(i), lp_Workplace_DrpDwn);
                browserUtil.selectsValueFromDropDown2(map.get("LocationOkToEmail").get(i), lp_locationOkToEmail_DrpDwn);
                browserUtil.entersTextWithTabIn(lp_UIAN_Txt, map.get("Location_UIAN").get(i));
                // Thread.sleep(3000);
                browserUtil.clicksWebElement(lp_locationSave_Btn);
                browserUtil.waitUntilPleaseWaitDisappear();
                //Thread.sleep(10000);
            }
        }

        public void performOperationLocations(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("Transaction_Type").get(0).equalsIgnoreCase("NBIS") || map.get("Transaction_Type").get(0).equalsIgnoreCase("RCIS")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("WORKERS COMP");
                browserUtil.waitUntilPleaseWaitDisappear();
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("LOCATIONS");
                browserUtil.waitUntilPleaseWaitDisappear();
                for (int i = 0; i < map.get("Location_Name_Info").size(); i++) {
                    if (map.get("Location_Name_Info").get(i).equalsIgnoreCase("$$NA$$")) {
                        break;
                    }
                    addLocations(map, i, "ADD");
                }
            } else if (map.get("Transaction_Type").get(0).equalsIgnoreCase("PCNM")) {
                if (map.get("Location_Flag").get(0).equalsIgnoreCase("Yes")) {
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("WORKERS COMP");
                    baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("LOCATIONS");
                }
                for (int j = 0; j < map.get("Performing_Action_Locations").size(); j++) {
                    String Location_Action = map.get("Performing_Action_Locations").get(j);
                    System.out.println(Location_Action);
                    if (!Location_Action.equalsIgnoreCase("$$NA$$")) {
                        switch (Location_Action) {
                            case "ADD":
                                addLocations(map, j, "ADD");
                                break;
                            case "EDIT":
                                List lp_LocationNumber_Link;
                                lp_LocationNumber_Link = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr//a[normalize-space()='" + map.get("Location_Number").get(j).trim() + "']"), pageName, "LocationNumber_Link (" + map.get("Location_Number").get(j).trim() + ")");
                                // lp_LocationNumber_Link = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr[(./td[contains(normalize-space(), '" + map.get("Location_Name_Info").get(j).trim() + "')]) and (./td[contains(normalize-space(), '" + map.get("Location_State_Table").get(j).trim() + "')])]//a[1]"), pageName, "LocationNumber_Link (" + map.get("Location_Name_Info").get(j).trim() + ", " + map.get("Location_State_Table").get(j).trim() + ")");
                                System.out.println("Location Link XPath -> " + lp_LocationNumber_Link.get(0).toString());
                                //browserUtil.switchToDefaultContent();
                                //browserUtil.switchToFrame("InsDmain");
                                // browserUtil.switchToFrame("WkEntityLocationsEdit_IFEntity");
                                //browserUtil.switchToFrame("WkEntityLocationsEdit_IFEntity");
                                browserUtil.clicksWebElement(lp_LocationNumber_Link);
                                addLocations(map, j, "EDIT");
                                break;
                            case "DELETE":
                                List lp_DeleteLocation_Image;
                                lp_DeleteLocation_Image = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr//a[normalize-space()='" + map.get("Location_Number").get(j).trim() + "']/../..//i[@title='Delete this Location']"), pageName, "lp_DeleteLocation_Image (" + map.get("Location_Number").get(j).trim() + ")");
                                // lp_DeleteLocation_Image = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr[(./td[contains(normalize-space(), '" + map.get("Location_Name_Info").get(j).trim() + "')]) and (./td[contains(normalize-space(), '" + map.get("Location_State_Table").get(j).trim() + "')])]//img[@title='Delete Location']"), pageName, "DeleteLocation_Image (" + map.get("Location_Name_Info").get(j).trim() + ", " + map.get("Location_State_Table").get(j).trim() + ")");
                                System.out.println("Delete Locatio XPath -> " + lp_DeleteLocation_Image.get(0).toString());
                                /*
                                String locationNumber;
                                String locationIndexAsString;
                                int locationIndex;
                                locationNumber = map.get("Location_Number").get(j);
                                locationIndex = Integer.parseInt(locationNumber)-1;
                                locationIndexAsString = Integer.toString(locationIndex);
                                */
                                //browserUtil.switchToDefaultContent();
                                //browserUtil.switchToFrame("InsDmain");
                                //browserUtil.switchToFrame("WkEntityLocationsEdit_IFEntity");
                                browserUtil.clicksWebElement(lp_DeleteLocation_Image);
                                browserUtil.waitUntilPleaseWaitDisappear();
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
                                break;
                        }
                    }
                }
            }
        }

        public void CPaddLocations(Map<String, List<String>> map) throws InterruptedException {
            if (map.get("CP_Location_Flag").get(0).equalsIgnoreCase("Yes")) {
                baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("LOCATIONS");
                parent = browserUtil.getWindowHandle();
                Thread.sleep(3000);
                browserUtil.clicksWebElement(cp_addLocation_button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToChildWindow();
                browserUtil.entersTextWithTabIn(cp_locationNo_textBox, map.get("LocationNoCP").get(0));
                browserUtil.entersTextWithTabIn(cp_buildingNo_textBox, map.get("BuildingNoCP").get(0));
                browserUtil.entersTextWithTabIn(cp_streetAddress_textBox, map.get("StreetAddr").get(0));
                browserUtil.entersTextWithTabIn(cp_city_textBox, map.get("City").get(0));
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.entersTextWithTabIn(cp_country_textBox, map.get("Country").get(0));
                browserUtil.entersTextWithTabIn(cp_zipCode_textBox, map.get("ZipCode").get(0));
                browserUtil.clicksWebElement(cp_saveAndClose_button);
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.switchToWindowWithHandle(parent);
            }
        }

        public void CPLocationInfo(Map<String, List<String>> map) throws InterruptedException {

            browserUtil.entersTextWithTabIn(cp_BG_1_Terr_textBox, map.get("CP_BG_1_Terr").get(0));
            browserUtil.entersTextWithTabIn(cp_BG_2_Terr_textBox, map.get("CP_BG_2_Terr_Zone").get(0));
            browserUtil.CMPDropDown(map.get("CP_Protection_Class").get(0), cp_Protection_Class_Drpdwn);
            browserUtil.entersTextWithTabIn(cp_CSP_Terr_textBox, map.get("CP_CSP_Terr").get(0));

            browserUtil.waitsUntilWebElementIsClickable(cp_Const_Year_textBox);
            browserUtil.GLntersTextWithTabIn(cp_Const_Year_textBox, map.get("CP_Const_Year").get(0));

            browserUtil.CMPDropDown(map.get("CP_Construction").get(0), cp_Construction_Drpdwn);
            browserUtil.CMPDropDown(map.get("CP_Rate_Type").get(0), cp_Rate_Type_Drpdwn);
            /*Thread.sleep(3000);
            browserUtil.clicksWebElement(cp_Sprinkler_Drpdwn);*/
            browserUtil.CMPDropDown(map.get("CP_Sprinkler").get(0), cp_Sprinkler_Drpdwn);
            /*Thread.sleep(3000);
            browserUtil.clicksWebElement(cp_BG_2_Construction_Drpdwn);*/
            browserUtil.CMPDropDown(map.get("CP_BG_2_Construction").get(0), cp_BG_2_Construction_Drpdwn);
            browserUtil.entersTextWithTabIn(cp_BG_2_Sym_textbox, map.get("CP_BG_2_Sym_Type").get(0));
            baseUtil.clicksOnSave();
        }

        public void CPOverrides(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(cp_Overrides_Link);
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.CMPDropDown(map.get("CP_All_Other_COL_Ovrd").get(0), cp_All_Other_COL_Ovrd_Drpdwn);
            browserUtil.CMPDropDown(map.get("CP_Wind_Hail_Ovrd").get(0), cp_Wind_Hail_Ovrd_Drpdwn);
            browserUtil.CMPDropDown(map.get("CP_heft_Ovrd_Ovrd").get(0), cp_Theft_Ovrd_Drpdwn);
            browserUtil.CMPDropDown(map.get("CP_Deductible_Option").get(0), cp_Deductible_Option_Drpdwn);
            baseUtil.clicksOnSave();
        }

        public void CPCoverages(Map<String, List<String>> map) throws InterruptedException {
            browserUtil.clicksWebElement(cp_Coverages_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            for (int i = 0; i < map.get("LocationCovgs").size(); i++) {
                String action = map.get("LocationCovgs").get(i);
                switch (action) {

                    case "Building":
                        browserUtil.CMPDropDown("BLDG;PfLocBldgTab", cp_Location_Coverages_Drpdwn);
                        browserUtil.clicksWebElement(cp_Add_Coverage_button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BLD_Coverage_Type").get(0), cp_Coverage_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BLD_Limit").get(0));
                        browserUtil.entersTextWithTabIn(cp_Blanket_ID_textdwn, map.get("CP_BLD_Blanket_ID").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BLD_Valuation_Type").get(0), cp_Valuation_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BLD_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BLD_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BLD_BG1_Rate").get(0));

                        if (map.get("VMM_Excl").get(0).equalsIgnoreCase("Yes") || map.get("VMM_Excl").get(0).equalsIgnoreCase("Check")) {
                            browserUtil.setsCheckBoxTo(true, cp_VMM_Excl_checkbox);
                        } else if (map.get("VMM_Excl").get(0).equalsIgnoreCase("No") || map.get("VMM_Excl").get(0).equalsIgnoreCase("Uncheck")) {
                            browserUtil.setsCheckBoxTo(false, cp_VMM_Excl_checkbox);
                        }
                        if (map.get("Spkl Excl").get(0).equalsIgnoreCase("Yes") || map.get("Spkl Excl").get(0).equalsIgnoreCase("Check")) {
                            browserUtil.setsCheckBoxTo(true, cp_Spkl_Excl_checkbox);
                        } else if (map.get("Spkl Excl").get(0).equalsIgnoreCase("No") || map.get("Spkl Excl").get(0).equalsIgnoreCase("Uncheck")) {
                            browserUtil.setsCheckBoxTo(false, cp_Spkl_Excl_checkbox);
                        }
                        baseUtil.clicksOnSave();
                        break;

                    case "Business Personal Property":
                        browserUtil.CMPDropDown("BPP1;PfLocBppTab", cp_Location_Coverages_Drpdwn);
                        browserUtil.clicksWebElement(cp_Add_Coverage_button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_Covg_Type").get(0), cp_Covg_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BPP_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BPP_Valuation_Type").get(0), cp_Valuation_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BPP_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_RG").get(0), cp_BPP_RG_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BPP_BG1_Rate").get(0));
                        baseUtil.clicksOnSave();
                        break;

                    case "Business Income":
                        browserUtil.CMPDropDown("BINC;PfLocBincTab", cp_Location_Coverages_Drpdwn);
                        browserUtil.clicksWebElement(cp_Add_Coverage_button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                       /* Thread.sleep(3000);
                        browserUtil.clicksWebElement(cp_Coverage_Type_Drpdwn);*/
                        browserUtil.CMPDropDown(map.get("CP_BINC_Covg_Type").get(0), cp_Coverage_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BINC_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BINC_Risk_Type").get(0), cp_Risk_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BINC_Indemnity_Type").get(0), cp_Indemnity_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BINC_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BINC_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BINC_BG1_Rate").get(0));
                        baseUtil.clicksOnSave();
                        break;

                    case "Spoilage":
                        browserUtil.CMPDropDown("SPLG;PfLocSplgHTML", cp_Location_Coverages_Drpdwn);
                        browserUtil.clicksWebElement(cp_Add_Coverage_button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_SPLG_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Spoilage_Class").get(0), cp_Spoilage_Class_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Coverage_Type").get(0), cp_Coverage_Type_Drpdwn);
                        Thread.sleep(2000);
                        browserUtil.clicksWebElement(cp_Ded_Amt_Ovrd_Drpdwn);
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Ded_Amt_Ovrd").get(0), cp_Ded_Amt_Ovrd_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        baseUtil.clicksOnSave();
                        break;

                    default:
                        break;
                }
            }
        }

        //Method for Edit coverage
        public void CPCoverages2(Map<String, List<String>> map) throws InterruptedException {
            for (int i = 0; i < map.get("LocationCovgs").size(); i++) {
                String action = map.get("LocationCovgs").get(i);
                switch (action) {

                    case "Building":
                        //browserUtil.CMPDropDown("BLDG;PfLocBldgTab", cp_Location_Coverages_Drpdwn);
                       // browserUtil.clicksWebElement(cp_Add_Coverage_button);
                       // browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BLD_Coverage_Type").get(0), cp_Coverage_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BLD_Limit").get(0));
                        browserUtil.entersTextWithTabIn(cp_Blanket_ID_textdwn, map.get("CP_BLD_Blanket_ID").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BLD_Valuation_Type").get(0), cp_Valuation_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BLD_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BLD_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BLD_BG1_Rate").get(0));

                        if (map.get("VMM_Excl").get(0).equalsIgnoreCase("Yes") || map.get("VMM_Excl").get(0).equalsIgnoreCase("Check")) {
                            browserUtil.setsCheckBoxTo(true, cp_VMM_Excl_checkbox);
                        } else if (map.get("VMM_Excl").get(0).equalsIgnoreCase("No") || map.get("VMM_Excl").get(0).equalsIgnoreCase("Uncheck")) {
                            browserUtil.setsCheckBoxTo(false, cp_VMM_Excl_checkbox);
                        }
                        if (map.get("Spkl Excl").get(0).equalsIgnoreCase("Yes") || map.get("Spkl Excl").get(0).equalsIgnoreCase("Check")) {
                            browserUtil.setsCheckBoxTo(true, cp_Spkl_Excl_checkbox);
                        } else if (map.get("Spkl Excl").get(0).equalsIgnoreCase("No") || map.get("Spkl Excl").get(0).equalsIgnoreCase("Uncheck")) {
                            browserUtil.setsCheckBoxTo(false, cp_Spkl_Excl_checkbox);
                        }
                        baseUtil.clicksOnSave();
                        break;

                    case "Business Personal Property":
                       // browserUtil.CMPDropDown("BPP1;PfLocBppTab", cp_Location_Coverages_Drpdwn);
                       // browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_Covg_Type").get(0), cp_Covg_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BPP_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BPP_Valuation_Type").get(0), cp_Valuation_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BPP_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_RG").get(0), cp_BPP_RG_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BPP_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BPP_BG1_Rate").get(0));
                        baseUtil.clicksOnSave();
                        break;

                    case "Business Income":
                        //browserUtil.CMPDropDown("BINC;PfLocBincTab", cp_Location_Coverages_Drpdwn);
                        //browserUtil.clicksWebElement(cp_Add_Coverage_button);
                        browserUtil.waitUntilPleaseWaitDisappear();
                       /* Thread.sleep(3000);
                        browserUtil.clicksWebElement(cp_Coverage_Type_Drpdwn);*/
                        browserUtil.CMPDropDown(map.get("CP_BINC_Covg_Type").get(0), cp_Coverage_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_BINC_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_BINC_Risk_Type").get(0), cp_Risk_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BINC_Indemnity_Type").get(0), cp_Indemnity_Type_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Class_Code_textdwn, map.get("CP_BINC_Class_Code").get(0));
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_BINC_Cause_Of_Loss").get(0), cp_Cause_Of_Loss_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_BG1_Rate_textdwn, map.get("CP_BLD_BG1_Rate").get(0));
                        baseUtil.clicksOnSave();
                        break;

                    case "Spoilage":
                        //browserUtil.CMPDropDown("SPLG;PfLocSplgHTML", cp_Location_Coverages_Drpdwn);
                       // browserUtil.clicksWebElement(cp_Add_Coverage_button);
                       // browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.entersTextWithTabIn(cp_Limit_textdwn, map.get("CP_SPLG_Limit").get(0));
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Spoilage_Class").get(0), cp_Spoilage_Class_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Coverage_Type").get(0), cp_Coverage_Type_Drpdwn);
                        Thread.sleep(2000);
                        browserUtil.clicksWebElement(cp_Ded_Amt_Ovrd_Drpdwn);
                        browserUtil.CMPDropDown(map.get("CP_SPLG_Ded_Amt_Ovrd").get(0), cp_Ded_Amt_Ovrd_Drpdwn);
                        browserUtil.waitUntilPleaseWaitDisappear();
                        baseUtil.clicksOnSave();
                        break;

                    default:
                        break;
                }
            }
        }

        // Method for Edit Location Info page and Add Coverarages
        public void CPCoveragesModified(Map<String, List<String>> map) throws InterruptedException {
            List Location_Coverage_Link = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr//td/a[normalize-space()='" + map.get("Location_Number").get(0) + "']/parent::td//following-sibling::td[3]/i"), pageName, "Location Coverage Link");

            browserUtil.waitsUntilWebElementIsClickable(Location_Coverage_Link);
            browserUtil.clicksWebElement(Location_Coverage_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            browserUtil.clicksWebElement(cp_Location_Info_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            this.CPLocationInfo(map);
            this.CPCoverages(map);

        }

        // Method For Edit Coverages
        public void CPCoveragesModifiedPCNM(Map<String, List<String>> map) throws InterruptedException {

            List Location_Coverage_Link = Arrays.asList(By.xpath("//div[contains(@id, 'LocationList')]//table//tr//td/a[normalize-space()='" + map.get("Location_Number").get(0) + "']/parent::td//following-sibling::td[3]/i"), pageName, "Location Coverage Link");
            browserUtil.waitsUntilWebElementIsClickable(Location_Coverage_Link);
            browserUtil.clicksWebElement(Location_Coverage_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            List CoverageName_Link = Arrays.asList(By.xpath("//a[normalize-space()='" + map.get("LocationCovgs").get(0) + "']"), pageName, "Coverage Link");
            browserUtil.clicksWebElement(CoverageName_Link);
            browserUtil.waitUntilPleaseWaitDisappear();

            this.CPCoverages2(map);

        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Locations_Page.LocationsMethods theUser_() {
        return this.pageMethods;
    }

}
