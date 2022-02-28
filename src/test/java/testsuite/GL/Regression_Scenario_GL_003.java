package testsuite.GL;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import pageobjects.*;
import utilities.ExcelFile_Util;
import utilities.TestFramework_Initializer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Regression_Scenario_GL_003
        extends TestFramework_Initializer
        implements CMPLogin_Page.ILogin, CMPHome_Page.IHome, CommonInfo_Page.ICommonInfo, Names_Page.INames, Rating_Page.IRating, Issue_Page.IIssue_Page, IssuingInfo_Page.IIssuingInfo, PolicyForms_Page.IPolicyForms, FEIN_Page.IFEIN
{
    boolean generateBeyondCompareScriptAndReport = false;
    String excelFileName;
    String excelFilePath;
    String sanNumber;
    String initialTransactionName;
    Map<String, List<String>> testDataAsMap;

    @Test(enabled = true, priority = 0)
    public void Regression_Scenario_Transaction_003_NBQU() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        initialTransactionName = "NBQU";
        excelFileName = "GL_Regression_03";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "NBQU");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().createNewPolicy(testDataAsMap);
            whileViewing().theCommonInfoPage().theUser_().enterCommonPolicyDetails(testDataAsMap);
            sanNumber = whileViewing().theCommonInfoPage().theUser_().fetchSan();
            whileViewing().theUnderwriterPage().theUser_().enterUnderwriterDetails(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterGeneralLiabilityPolicyDetail(testDataAsMap);
            whileViewing().theClassCodePage().theUser_().enterClassCodes(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuingInfo().theUser_().fillIssuingInfoDetails(testDataAsMap, sanNumber, "NBQU");
            whileViewing().theBillingPage().theUser_().fillBillingPageDetails(testDataAsMap);
            whileViewing().theMiscInformationPage().theUser_().fillMiscInformation(testDataAsMap, sanNumber);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuingInfo().theUser_().convertToIssue();
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }

    @Test(enabled = true, priority = 1 , dependsOnMethods = "Regression_Scenario_Transaction_003_NBQU")
    public void Regression_Scenario_Transaction_003_REWR() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "GL_Regression_03";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "REWR");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performCancellation(testDataAsMap, sanNumber);
            whileViewing().thePerformTransactionPage().theUser_().enterDateCANC(testDataAsMap);
            whileViewing().theTransactionInformationPage().theUser_().enterCancellationDetails(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().reWrCheckTransactionStatus(sanNumber);
            sanNumber = whileViewing().theCMPHomePage().theUser_().fetchSan();
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }
    @Test(enabled = true, priority = 2 , dependsOnMethods = "Regression_Scenario_Transaction_003_REWR")
    public void Regression_Scenario_Transaction_003_MODIREWR() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "GL_Regression_03";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "MODIREWR");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performREISSUE(testDataAsMap,sanNumber);
            whileViewing().theCommonInfoPage().theUser_().changeCommonPolicyDetailsReWrite(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterGeneralLiabilityPolicyDetail(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().GLEmployeCoverg(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().addAdditionalInterest(testDataAsMap);
            whileViewing().theClassCodePage().theUser_().enterClassCodes(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuingInfo().theUser_().fillIssuingInfoDetails(testDataAsMap, sanNumber, "MODIREWR");
            whileViewing().theBillingPage().theUser_().fillBillingPageDetails(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().Commissions(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().formValidation(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
        }
    }
/*
    @Test(enabled = true, priority = 1 , dependsOnMethods = "Regression_Scenario_004_A_Transaction_01_NBQU")
    public void Regression_Scenario_004_A_Transaction_01_NBIS() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "NBIS");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().createNewPolicy(testDataAsMap);
            whileViewing().theCommonInfoPage().theUser_().enterCommonPolicyDetails(testDataAsMap);
            sanNumber = whileViewing().theCommonInfoPage().theUser_().fetchSan();
            whileViewing().theUnderwriterPage().theUser_().enterUnderwriterDetails(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterGeneralLiabilityPolicyDetail(testDataAsMap);
            whileViewing().theClassCodePage().theUser_().enterClassCodes(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuingInfo().theUser_().fillIssuingInfoDetails(testDataAsMap, sanNumber, "NBIS");
            whileViewing().theBillingPage().theUser_().fillBillingPageDetails(testDataAsMap);
            whileViewing().theMiscInformationPage().theUser_().fillMiscInformation(testDataAsMap, sanNumber);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }


    @Test(enabled = true, priority = 1 , dependsOnMethods = "Regression_Scenario_004_A_Transaction_01_NBIS")
    public void Regression_Scenario_004_A_Transaction_02_CANC() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "CANC");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performCancellation(testDataAsMap, sanNumber);
            whileViewing().thePerformTransactionPage().theUser_().enterDateCANC(testDataAsMap);
            whileViewing().theTransactionInformationPage().theUser_().enterCancellationDetails(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }

    @Test(enabled = true, priority = 2 , dependsOnMethods = "Regression_Scenario_004_A_Transaction_02_CANC")
    public void Regression_Scenario_004_A_Transaction_03_AUDF1() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "AUDF1");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performActionsOnPolicy(testDataAsMap, "AUDF", sanNumber);
            whileViewing().theTransactionInformationPage().theUser_().enterAuditTransactionDetails(testDataAsMap);
            sanNumber = whileViewing().theCommonInfoPage().theUser_().fetchSan();
            whileViewing().theStatePage().theUser_().selectSplitDateAndStateForAudit(testDataAsMap);
            whileViewing().theQuickClassCodePage().theUser_().selectWorkersCompQuickClassCodeForAudit(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }

    @Test(enabled = true,  priority = 3, dependsOnMethods = "Regression_Scenario_004_A_Transaction_03_AUDF1" )
    public void Regression_Scenario_004_A_Transaction_04_PCNM() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "PCNM");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performActionsOnPolicy(testDataAsMap, "PCNM", sanNumber);
            whileViewing().thePerformTransactionPage().theUser_().enterPolicyInfoForPCNM(testDataAsMap);
            whileViewing().theTransactionInformationPage().theUser_().enterChangeEndorsementDetails(testDataAsMap);
            whileViewing().theCommonInfoPage().theUser_().enterCommonPolicyDetails(testDataAsMap);
            sanNumber = whileViewing().theCommonInfoPage().theUser_().fetchSan();
            whileViewing().theUnderwriterPage().theUser_().enterUnderwriterDetails(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterGeneralLiabilityPolicyDetail(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterRetroAndDeductibleInformationDetails(testDataAsMap);
            whileViewing().theGeneralLiabilityPage().theUser_().enterExperienceModsDetails(testDataAsMap);
            whileViewing().theStatePage().theUser_().selectWorkersCompState(testDataAsMap);
            whileViewing().theQuickClassCodePage().theUser_().selectWorkersCompQuickClassCode(testDataAsMap);
            whileViewing().theQuickClassCodePage().theUser_().enterDetailsInClassCodeTab(testDataAsMap);
            whileViewing().theQuickClassCodePage().theUser_().performOperationOnWaivers(testDataAsMap);
            whileViewing().theLocationsPage().theUser_().performOperationLocations(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().theIssuingInfo().theUser_().fillIssuingInfoDetails(testDataAsMap, sanNumber, "PCNM");
            whileViewing().theBillingPage().theUser_().fillBillingPageDetails(testDataAsMap);
            whileViewing().theMiscInformationPage().theUser_().fillMiscInformation(testDataAsMap, sanNumber);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }

    @Test(enabled = true, priority = 4 , dependsOnMethods = "Regression_Scenario_004_A_Transaction_04_PCNM" )
    public void Regression_Scenario_004_A_Transaction_05_AUDV() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "AUDV");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performTransaction(testDataAsMap, "Void Audit", sanNumber);
           // whileViewing().thePerformTransactionPage().theUser_().enterDateTransaction(testDataAsMap, "AUDV");
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
    }

    @Test(enabled = true, priority = 5 , dependsOnMethods = "Regression_Scenario_004_A_Transaction_05_AUDV")
    public void Regression_Scenario_004_A_Transaction_06_AUDF2() throws IOException, InvalidFormatException, ParserConfigurationException, SAXException, InterruptedException
    {
        excelFileName = "Regression_Scenario_004_A_Test_Datafile";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        testDataAsMap = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, "AUDF2");

        if(!testDataAsMap.get("sanNumber").get(0).equalsIgnoreCase("$$NA$$"))
        {
            sanNumber = testDataAsMap.get("sanNumber").get(0);
        }
        if(testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("$$NA$$") || testDataAsMap.get("Transaction_Status").get(0).equalsIgnoreCase("Fail"))
        {
            whileViewing().theCMPLoginPage().theUser_().logsIntoPolicyDecisions(utils.configReader().getURL(), testDataAsMap.get("userNameTxt").get(0), testDataAsMap.get("passwordTxt").get(0));
            whileViewing().theCMPHomePage().theUser_().performActionsOnPolicy(testDataAsMap, "AUDF", sanNumber);
            whileViewing().theTransactionInformationPage().theUser_().enterAuditTransactionDetails(testDataAsMap);
            sanNumber = whileViewing().theCommonInfoPage().theUser_().fetchSan();
            whileViewing().theStatePage().theUser_().selectSplitDateAndStateForAudit(testDataAsMap);
            whileViewing().theQuickClassCodePage().theUser_().selectWorkersCompQuickClassCodeForAudit(testDataAsMap);
            whileViewing().theRatingPage().theUser_().ratePolicyWithoutVerification(testDataAsMap);
            whileViewing().thePolicyFormsPage().theUser_().fillsInPolicyForms2(testDataAsMap);
            whileViewing().theIssuePage().theUser_().issuePolicy();
            whileViewing().theCMPHomePage().theUser_().checkTransactionStatus(sanNumber);
            whileViewing().theCMPLoginPage().theUser_().logOut();
        }
        generateBeyondCompareScriptAndReport = true;
    }
*/

    @AfterMethod()
    public void afterMethod(ITestResult testResult) throws ParserConfigurationException, InvalidFormatException, SAXException, IOException
    {
        boolean transactionStatus;
        String transactionStatusToBeReported;
        String transactionNameAlsoTheTestDataSheetName;
        String scenarioName;
        String previousSPNumber;
        String currentSPNumber;
        String previousSPPolicyOrSANNumber = "";
        String currentSPPolicyOrSANNumber = "";
        String serverRepositoryPathForPolicies;
        String userSpecifiedPathForPolicies;
        String beyondCompareDirectoryPath, pdfCompareDirectoryPath;

        transactionStatus = testResult.isSuccess();
        transactionNameAlsoTheTestDataSheetName = testResult.getMethod().getMethodName().trim();
        transactionNameAlsoTheTestDataSheetName = transactionNameAlsoTheTestDataSheetName.substring(transactionNameAlsoTheTestDataSheetName.indexOf("Transaction")).trim();
        transactionNameAlsoTheTestDataSheetName = transactionNameAlsoTheTestDataSheetName.substring(transactionNameAlsoTheTestDataSheetName.indexOf("_")+1).trim();
        transactionNameAlsoTheTestDataSheetName = transactionNameAlsoTheTestDataSheetName.substring(transactionNameAlsoTheTestDataSheetName.indexOf("_")+1).trim();
        scenarioName = testResult.getMethod().getMethodName().trim();
        scenarioName = scenarioName.replace("Regression_","");
        scenarioName = scenarioName.replace("_00"," ");
        scenarioName = scenarioName.replace("_0"," ");
        scenarioName = scenarioName.replace("_"," ");
        scenarioName = scenarioName.substring(0, scenarioName.indexOf("Transaction")).trim();
        if(scenarioName.charAt(scenarioName.length()-1) == 'A' || scenarioName.charAt(scenarioName.length()-1) == 'B')
        {
            scenarioName = scenarioName.substring(0, scenarioName.length()-2).trim() + scenarioName.charAt(scenarioName.length()-1);
        }
        previousSPNumber = utils.configReader().getConfigInfoForKey("previous_SP");
        currentSPNumber = utils.configReader().getConfigInfoForKey("current_SP");
        serverRepositoryPathForPolicies = utils.configReader().getConfigInfoForKey("serverRepositoryPathForPolicies");
        userSpecifiedPathForPolicies = "\\\\sancfs001\\QA-LT\\Deliverables\\WC Policy Decision\\" + currentSPNumber + "\\" + currentSPNumber + " Deliveries\\Regression Testing\\" + scenarioName + "\\";
        beyondCompareDirectoryPath = userSpecifiedPathForPolicies + "Beyond Compare Scripts\\";
        pdfCompareDirectoryPath = userSpecifiedPathForPolicies + "PDF Compare Reports\\";

        if(transactionStatus)
        {
            // Update transaction Status
            transactionStatusToBeReported = "Pass";
            // Beyond compare script and report to be generated after last automation transaction only
            if(generateBeyondCompareScriptAndReport)
            {
                // Get previous SP policy / SAN number if not retrieved already
                if(previousSPPolicyOrSANNumber.equalsIgnoreCase(""))
                {
                    excelFileName = utils.configReader().getConfigInfoForKey("regression_status_report_file_Name");
                    excelFilePath = userSpecifiedPathForPolicies.replace(scenarioName + "\\", "");
                    previousSPPolicyOrSANNumber = utils.excelFileUtil().getsSPPolicyOrQuoteNumber(excelFilePath + excelFileName, "Sheet1", previousSPNumber, transactionNameAlsoTheTestDataSheetName, scenarioName);
                }
                // Get current SP policy / SAN number if not retrieved already
                if(currentSPPolicyOrSANNumber.equalsIgnoreCase(""))
                {
                    currentSPPolicyOrSANNumber = sanNumber.substring(0, 7);
                }
                // Update policy / SAN number to 8 digits based on transaction name (Remaining transactions will use existing policy / SAN number)
                if(initialTransactionName.equalsIgnoreCase("NBIS"))
                {
                    previousSPPolicyOrSANNumber = previousSPPolicyOrSANNumber.substring(0, 7) + "0";
                    currentSPPolicyOrSANNumber = currentSPPolicyOrSANNumber.substring(0, 7) + "0";
                }
                else if(initialTransactionName.equalsIgnoreCase("RCIS"))
                {
                    previousSPPolicyOrSANNumber = previousSPPolicyOrSANNumber.substring(0, 7) + "1";
                    currentSPPolicyOrSANNumber = currentSPPolicyOrSANNumber.substring(0, 7) + "1";
                }
                else if(initialTransactionName.equalsIgnoreCase("REIS"))
                {
                    previousSPPolicyOrSANNumber = previousSPPolicyOrSANNumber.substring(0, 7) + "1";
                    currentSPPolicyOrSANNumber = currentSPPolicyOrSANNumber.substring(0, 7) + "1";
                }
                // Create Beyond Compare folder
                utils.testAssistUtility().createDirectoryStructure(pdfCompareDirectoryPath);
                // Create beyond compare specification file for HTML report
                utils.testAssistUtility().createBeyondCompareSpecificationFileForReport();
                // Move entire previous Policy / SAN PDF folder to user specified location (Ideally, it is already in place because of copying from previous SP)
                utils.testAssistUtility().movesPolicyOrQuoteDirectoryFromRepositoryToUserLocation(previousSPPolicyOrSANNumber, serverRepositoryPathForPolicies, userSpecifiedPathForPolicies);
                // Move entire current policy PDF folder to user specified location
                utils.testAssistUtility().movesPolicyOrQuoteDirectoryFromRepositoryToUserLocation(currentSPPolicyOrSANNumber, serverRepositoryPathForPolicies, userSpecifiedPathForPolicies);
                // Create beyond compare batch file for comparison
                //utils.testAssistUtility().createBeyondComparePDFComparisonBatchFileAndHTMLReport(previousSPPolicyOrSANNumber, currentSPPolicyOrSANNumber, userSpecifiedPathForPolicies);
                //utils.testAssistUtility().createPDFComparisonHTMLReport(previousSPPolicyOrSANNumber, currentSPPolicyOrSANNumber, userSpecifiedPathForPolicies);
            }
        }
        else
        {
            // Update transaction Status
            transactionStatusToBeReported = "Fail";
        }
        // Write SAN and Transaction Status In Test Data File
        excelFileName = "GL_Regression_03";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);
        ExcelFile_Util.writeToSpecifiedColumnInExcel(excelFilePath, transactionNameAlsoTheTestDataSheetName, transactionStatusToBeReported, "Transaction_Status");
        ExcelFile_Util.writeToSpecifiedColumnInExcel(excelFilePath, transactionNameAlsoTheTestDataSheetName, sanNumber, "sanNumber");
    }

}