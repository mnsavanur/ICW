package utilities;

import org.testng.IAnnotationTransformer;
import org.testng.SkipException;
import org.testng.annotations.ITestAnnotation;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

import static utilities.TestFramework_Initializer.utils;

public class DisableTest_Util implements IAnnotationTransformer
{

    Map<String, List<String>> map2;

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        // If we have chose not to run this test then disable it.
        if(disableMe(testMethod)) {
            annotation.setEnabled(false);
        }
    }

    // logic YOU control
    private boolean disableMe(Method testName)
    {
        System.out.println(testName);
        return false;
    }

   // @BeforeMethod
    public void before(Method methodName) throws IOException
    {
        String excelFilePath;
        String excelFileName = "Scenario1_TestData";
        excelFilePath = utils.configReader().getExcelFilePath(excelFileName);

        map2 = utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, methodName.getName());
        System.out.println(utils.excelFileUtil().getExcelDataAsMapWithMultipleValues(excelFilePath, methodName.getName()));
        System.out.println(map2.get("Transaction_Status"));
        if(map2.get("Transaction_Status").get(0).equalsIgnoreCase("Pass"))
        {
            throw new SkipException("Skipping tests because resource was not available.");
        }
    }

}