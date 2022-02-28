package utilities;

import org.openqa.selenium.WebDriver;
import pageobjects.*;

public class PageObject_Initializer
{
    private AgCapitalAssetProgram_Page agcapPage;
    private GeneralLiability_Page generalLiabPage;
    private CapitalAsset_Page capPage;
    private CAPLocations_Page capLocationPage;
    private WebDriver driver;
    private LogAndReport_Util logReportUtil;
    private Screenshot_Util screenShotUtil;
    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private CMPLogin_Page loginPage;
    private CMPHome_Page homePage;
    private CommonInfo_Page commonPage;
    private FEIN_Page feinPage;
    private Names_Page namesPage;
    private Rating_Page ratingPage;
    private Issue_Page issuePage;
    private IssuingInfo_Page issuingInfoPage;
    private PolicyForms_Page policyFormsPage;
    private Underwriter_Page underwriterPage;
    private States_Page statesPage;
    private ClassCode_Page ClassCodePage;
    private Locations_Page locationsPage;
    private Billing_Page billingPage;
    private MiscInformation_Page miscInformationPage;
    private TransactionInfo_Page transactionInfoPage;
    private RatingGroupManager_Page ratingGroupManagerPage;
    private PerformTransaction_Page performTransactionPage;
    private ChangeNarratives_Page changeNarrativesPage;
    private ViewChangeNarratives_Page viewChangeNarrativesPage;
    private AdditionalInterests_Page AdditionalInterestsPage;
    private Property_Page propertyPage;
    private CertificateOnly_Page certificateOnlyPage;


    public PageObject_Initializer(Utility_Initializer utilityInitializer)
    {
        this.driver = utilityInitializer.browserUtil().getDriver();
        this.logReportUtil = utilityInitializer.logReportUtil();
        this.screenShotUtil = utilityInitializer.screenShotUtil();
        this.browserUtil = utilityInitializer.browserUtil();
        this.baseUtil = utilityInitializer.baseUtil();
        this.loginPage = new CMPLogin_Page(logReportUtil, screenShotUtil, browserUtil);
        this.homePage = new CMPHome_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.commonPage = new CommonInfo_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.feinPage = new FEIN_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.namesPage = new Names_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.ratingPage = new Rating_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.issuePage = new Issue_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.issuingInfoPage = new IssuingInfo_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.policyFormsPage = new PolicyForms_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.underwriterPage = new Underwriter_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.statesPage = new States_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.ClassCodePage = new ClassCode_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.locationsPage = new Locations_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.billingPage = new Billing_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.miscInformationPage = new MiscInformation_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.transactionInfoPage = new TransactionInfo_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.ratingGroupManagerPage = new RatingGroupManager_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.performTransactionPage = new PerformTransaction_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.changeNarrativesPage = new ChangeNarratives_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.viewChangeNarrativesPage = new ViewChangeNarratives_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.generalLiabPage = new GeneralLiability_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.capPage = new CapitalAsset_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.capLocationPage = new CAPLocations_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.AdditionalInterestsPage = new AdditionalInterests_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.propertyPage = new Property_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);
        this.certificateOnlyPage = new CertificateOnly_Page(logReportUtil, screenShotUtil, browserUtil, baseUtil);

    }

    public CommonInfo_Page theCommonInfoPage() {
        return this.commonPage;
    }

    public CMPLogin_Page theCMPLoginPage() {
        return this.loginPage;
    }

    public CMPHome_Page theCMPHomePage() {
        return this.homePage;
    }

    public FEIN_Page theFEINPage() {
        return this.feinPage;
    }

    public Names_Page theNamesPage() {
        return this.namesPage;
    }

    public Rating_Page theRatingPage() {
        return this.ratingPage;
    }

    public IssuingInfo_Page theIssuingInfo() {
        return this.issuingInfoPage;
    }

    public Issue_Page theIssuePage() {
        return this.issuePage;
    }

    public PolicyForms_Page thePolicyFormsPage() {
        return this.policyFormsPage;

    }
    public AdditionalInterests_Page theAdditionalInterests() {
        return this.AdditionalInterestsPage;
    }

    public Property_Page thePropertyPage() { return this.propertyPage; }

    public Underwriter_Page theUnderwriterPage() {
        return this.underwriterPage;
    }

    public GeneralLiability_Page theGeneralLiabilityPage() {
        return this.generalLiabPage;
    }

    public AgCapitalAssetProgram_Page theAgCapPage(){ return this.agcapPage; }

    public CapitalAsset_Page theCapitalAssetPage(){return this.capPage;}

    public CAPLocations_Page theCAPLocationPage(){return this.capLocationPage;}

    public States_Page theStatePage() {
        return this.statesPage;
    }

    public ClassCode_Page theClassCodePage() {
        return this.ClassCodePage;
    }

    public Locations_Page theLocationsPage() {
        return this.locationsPage;
    }

    public Billing_Page theBillingPage() {
        return this.billingPage;
    }

    public MiscInformation_Page theMiscInformationPage() {
        return this.miscInformationPage;
    }

    public TransactionInfo_Page theTransactionInformationPage() {
        return this.transactionInfoPage;
    }

    public RatingGroupManager_Page theRatingGroupManagerPage() {
        return this.ratingGroupManagerPage;
    }

    public PerformTransaction_Page thePerformTransactionPage() {
        return this.performTransactionPage;
    }

    public ChangeNarratives_Page theChangeNarrativesPage() {
        return this.changeNarrativesPage;
    }

    public ViewChangeNarratives_Page theViewChangeNarrativesPage() {
        return this.viewChangeNarrativesPage;
    }

    public CertificateOnly_Page theCertificateOnly() {
        return this.certificateOnlyPage;
    }
}