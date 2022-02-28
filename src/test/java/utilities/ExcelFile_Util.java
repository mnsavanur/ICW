package utilities;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.FileOutputStream;
import java.util.*;

public class ExcelFile_Util
{
    static File excelFile;
    static FileInputStream fileInputStream;
    static FileOutputStream fileOutputStream;
    static Workbook excelWorkbook;
    static Sheet excelSheet;
    static Row excelRow;
    static Cell excelCell;

    public ExcelFile_Util()
    {
    }

    // This method returns a single value for each DataProvider iteration (in this case a LinkedHashMap).
    // The test execution method linked to the DataProvider should have only one parameter: Map<String, Object> data
    // NOTE: 'data' is the variable name I chose, but any name may be used
    public Object[][] getExcelDataAsArrayWithSingleValue(String excelFilePath, String excelSheetName)
    {
        try 
        {
            excelWorkbook = new XSSFWorkbook(excelFilePath);
            excelSheet = excelWorkbook.getSheet(excelSheetName);
            Map<String, Object> testDataAsMap;

            excelRow = excelSheet.getRow(0);

            String[] headers = new String[excelRow.getLastCellNum()];

            Object[][] data = new Object[excelSheet.getLastRowNum()][1];

            // This for loop populates the header array
            for (int i = excelRow.getFirstCellNum(); i < excelRow.getLastCellNum(); i++)
            {
                excelCell = excelRow.getCell(i);
                headers[i] = excelCell.getStringCellValue();
                System.out.println("Header: " + headers[i]);
            }

            // This for loop will go through each excelRow of data in the excel excelSheet
            for (int j = excelSheet.getFirstRowNum() + 1; j <= excelSheet.getLastRowNum(); j++)
            {
                excelRow = excelSheet.getRow(j);
                testDataAsMap = new LinkedHashMap<String, Object>();

                // This for loop assigns a value to each header key
                for (int val = excelRow.getFirstCellNum(); val < excelRow.getLastCellNum(); val++)
                {
                    excelCell = excelRow.getCell(val);
                    // The switch statement allows for the possibility of users formatting the data in the excel excelFile
                    // as a String ("General" in Excel) or a float ("Number" in Excel)
                    switch (excelCell.getCellType())
                    {
                        case XSSFCell.CELL_TYPE_STRING:
                            testDataAsMap.put(headers[val], excelCell.getStringCellValue());
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            testDataAsMap.put(headers[val], excelCell.getNumericCellValue());
                            break;
                    }
                }
                System.out.println(testDataAsMap);
                data[j - 1][0] = testDataAsMap;
            }
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // This method returns multiple values for each DataProvider iteration (type may vary).
    // The test execution method linked to the DataProvider should have a number of parameters that is equal to the
    // number of columns in the excel file
    // Values passed by the DataProvider do not necessarily have to be used in the test case, but they must be listed
    // as parameters in the test execution method signature
    public Object[][] getExcelDataAsArrayWithMultipleValues(String excelFilePath, String excelSheetName)
    {
        try
        {
            XSSFWorkbook excelWorkbook = new XSSFWorkbook(excelFilePath);
            XSSFSheet excelSheet = excelWorkbook.getSheet(excelSheetName);
            XSSFRow excelRow;
            XSSFCell excelCell;

            excelRow = excelSheet.getRow(0);

            // The first parameter of the new Object determines how many cycles the data provider will run through
            // In this case, the number of cycles is determined by the number of rows in the excel excelSheet (excluding
            // the first excelRow with the headers)
            Object[][] data = new Object[excelSheet.getLastRowNum()][excelRow.getLastCellNum()];
            System.out.println("Last excelRow number: " + excelSheet.getLastRowNum());

            // This for loop will go through each excelRow of data in the excel excelSheet
            for (int j = excelSheet.getFirstRowNum() + 1; j <= excelSheet.getLastRowNum(); j++)
            {
                excelRow = excelSheet.getRow(j);
                // This for loop assigns a value for each element in Object[][]
                for (int val = excelRow.getFirstCellNum(); val < excelRow.getLastCellNum(); val++)
                {
                    excelCell = excelRow.getCell(val);

                    // The switch statement allows for the possibility of users formatting the data in the excel excelFile
                    // as a String ("General" in Excel) or a float ("Number" in Excel)
                    switch (excelCell.getCellType())
                    {

                        case XSSFCell.CELL_TYPE_STRING:
                            data[j - 1][val] = excelCell.getStringCellValue();
                            break;

                        case XSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println("Double: " + excelCell.getNumericCellValue());
                            int value1 = (int) excelCell.getNumericCellValue();
                            String finalValue = String.valueOf(value1);
                            data[j - 1][val] = finalValue;
                            System.out.println("*&*&*&*&*&*&*&*&*&*&");
                            System.out.println("Value: " + finalValue);
                            break;
                    }
                }
            }
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Object[][] getExcelDataAsMapWithSingleValue(String excelFilePath, String excelSheetName)
    {
        Map<Object, Object> excelDataAsMap;
        try
        {
            excelFile = new File(excelFilePath);
            fileInputStream = new FileInputStream(excelFile);

            excelWorkbook = new XSSFWorkbook(fileInputStream);
            excelSheet = excelWorkbook.getSheet(excelSheetName);
            int lastRowNum = excelSheet.getLastRowNum();
            int lastCellNum = excelSheet.getRow(0).getLastCellNum();
            Object[][] obj = new Object[lastRowNum][1];

            for (int i = 0; i < lastRowNum; i++)
            {
                excelDataAsMap = new HashMap<Object, Object>();
                for (int j = 0; j < lastCellNum; j++)
                {
                    excelDataAsMap.put(excelSheet.getRow(0).getCell(j).toString(), excelSheet.getRow(i + 1).getCell(j).toString());
                }
                obj[i][0] = excelDataAsMap;
            }
            excelWorkbook.close();
            fileInputStream.close();
            excelFile = null;
            return obj;
        }
        catch (IOException io)
        {
            io.printStackTrace();
            return null;
        }
    }

    public Map<String, List<String>> getExcelDataAsMapWithMultipleValues(String excelFilePath, String excelSheetName)
    {
        try
        {
            excelFile = new File(excelFilePath);
            fileInputStream = new FileInputStream(excelFile);
            excelWorkbook = new XSSFWorkbook(fileInputStream);
            excelSheet = excelWorkbook.getSheet(excelSheetName);
            int lastRowNum = excelSheet.getLastRowNum();
            int lastCellNum = excelSheet.getRow(0).getLastCellNum();
            Object[][] obj = new Object[lastCellNum][1];
            Map<String, List<String>> excelDataAsMap = new HashMap<String, List<String>>();

            for (int j = 0; j < lastCellNum; j++)
            {
                List rowIndexValue = new ArrayList();

                for (int i = 1; i <= lastRowNum; i++)
                {
                    if(!excelSheet.getRow(i).getCell(j).toString().equals(""))
                    {
                        rowIndexValue.add(excelSheet.getRow(i).getCell(j).toString());

                    }
                    excelDataAsMap.put(excelSheet.getRow(0).getCell(j).toString(), rowIndexValue);
                }
            }
            excelWorkbook.close();
            fileInputStream.close();
            excelFile = null;
            return excelDataAsMap;
        }
        catch (IOException io)
        {
            io.printStackTrace();
            return null;
        }
    }

    public static void writeHeaderList(String[] list, String policyPath, String Sheet)
    {
        try
        {
            excelFile = new File(policyPath);
            fileInputStream = new FileInputStream(excelFile);
            XSSFWorkbook excelWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet excelSheet = excelWorkbook.getSheet(Sheet);

            XSSFCellStyle style = excelWorkbook.createCellStyle();
            style.setBorderTop((short) 6); // double lines border
            style.setBorderBottom((short) 1); // single line border
            XSSFFont font = excelWorkbook.createFont();
            font.setFontHeightInPoints((short) 10);
            font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
            style.setFont(font);

            int colNum = 0;
            Row excelRow = excelSheet.createRow(0);

            for (int k = 0; k < list.length; k++)
            {
                excelRow = excelSheet.getRow(0);
                Cell excelCell = excelRow.createCell(colNum++);
                excelCell.setCellStyle(style);
                excelCell.setCellType(excelCell.CELL_TYPE_STRING);
                excelCell.setCellValue(list[k]);
                excelSheet.autoSizeColumn(k);
            }
            excelFile = null;
            excelFile = new File(policyPath);
            fileOutputStream = new FileOutputStream(excelFile);
            excelWorkbook.write(fileOutputStream);
            excelWorkbook.close();
            fileInputStream.close();
            fileOutputStream.close();
            excelFile = null;
            System.out.println("END OF WRITING DATA IN EXCEL");
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    public static void writeListExcel(String[] list, String policyPath, String Sheet)
    {
        try
        {
            excelFile = new File(policyPath);
            fileInputStream = new FileInputStream(excelFile);
            excelWorkbook = new XSSFWorkbook(fileInputStream);
            excelSheet = excelWorkbook.getSheet(Sheet);
            int colNum = 0;
            int lastRowNumber = excelSheet.getLastRowNum();
            System.out.println(lastRowNumber);
            Row excelRow = excelSheet.createRow(lastRowNumber + 1);

            for (int k = 0; k < list.length; k++)
            {
                excelRow = excelSheet.getRow(lastRowNumber + 1);
                Cell excelCell = excelRow.createCell(colNum++);
                excelCell.setCellType(excelCell.CELL_TYPE_STRING);
                excelCell.setCellValue(list[k]);
            }
            excelFile = null;
            excelFile = new File(policyPath);
            fileOutputStream = new FileOutputStream(excelFile);
            excelWorkbook.write(fileOutputStream);
            excelWorkbook.close();
            fileInputStream.close();
            fileOutputStream.close();
            excelFile = null;
            System.out.println("END OF WRITING DATA IN EXCEL");
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }

    public static void writeToSpecifiedColumnInExcel(String FilePath, String SheetName, String cellValue, String outputCol)
    {
        try
        {
            String result = "";
            int resultCol = -1;
            if(cellValue != null)
            {
                excelFile = new File(FilePath);
                fileInputStream = new FileInputStream(excelFile);
                excelWorkbook = WorkbookFactory.create(fileInputStream);
                System.out.println(SheetName);
                excelSheet = excelWorkbook.getSheet(SheetName);
                Row header = excelSheet.getRow(0);
                for (Cell excelCell : header)
                {
                    result = excelCell.getStringCellValue();
                    if(result.equals(outputCol))
                    {
                        resultCol = excelCell.getColumnIndex();
                    }
                }
                excelCell = excelSheet.getRow(excelSheet.getFirstRowNum() + 1).getCell(resultCol);
                excelCell.setCellValue(cellValue);
                excelFile = null;
                excelFile = new File(FilePath);
                fileOutputStream = new FileOutputStream (excelFile);
                excelWorkbook.write(fileOutputStream);
                excelWorkbook.close();
                fileInputStream.close();
                fileOutputStream.close();
                excelFile = null;
            }
        }
        catch (IOException | InvalidFormatException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToSpecifiedColumnInMatchingRow(String FilePath, String SheetName, String rowValue, int rowNumber, int columnNumber, String cellValue)
    {
        try
        {
            int rowCounter;
            if(cellValue != null)
            {
                excelFile = new File(FilePath);
                fileInputStream = new FileInputStream(excelFile);
                excelWorkbook = WorkbookFactory.create(fileInputStream);
                System.out.println(SheetName);
                excelSheet = excelWorkbook.getSheet(SheetName);
                for(rowCounter=0;rowCounter<excelSheet.getLastRowNum();rowCounter++)
                {
                    if(excelSheet.getRow(rowCounter).getCell(rowNumber).getStringCellValue().trim().contains(rowValue))
                    {
                        excelCell = excelSheet.getRow(rowCounter).getCell(columnNumber);
                        excelCell.setCellValue(cellValue);
                        break;
                    }
                }
                excelFile = new File(FilePath);
                fileOutputStream = new FileOutputStream (excelFile);
                excelWorkbook.write(fileOutputStream);
                excelWorkbook.close();
                fileInputStream.close();
                fileOutputStream.close();
                excelFile = null;
            }
        }
        catch (IOException | InvalidFormatException e)
        {
            e.printStackTrace();
        }
    }

    public static String readFromSpecifiedColumnInMatchingRow(String FilePath, String SheetName, String rowValue, int rowNumber, int columnNumber)
    {
        int rowCounter;
        String cellValue = "";

        try
        {
            excelFile = new File(FilePath);
            fileInputStream = new FileInputStream(excelFile);
            excelWorkbook = WorkbookFactory.create(fileInputStream);
            excelSheet = excelWorkbook.getSheet(SheetName);
            for(rowCounter=0;rowCounter<excelSheet.getLastRowNum();rowCounter++)
            {
                if(excelSheet.getRow(rowCounter).getCell(rowNumber).getStringCellValue().trim().contains(rowValue))
                {
                    excelCell = excelSheet.getRow(rowCounter).getCell(columnNumber);
                    cellValue = excelCell.getStringCellValue().trim();
                    break;
                }
            }
            excelWorkbook.close();
            fileInputStream.close();
            excelFile = null;
            return cellValue;
        }
        catch (IOException | InvalidFormatException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String getsSPPolicyOrQuoteNumber(String excelFilePath, String excelSheetName, String spNumber, String transactionName, String scenarioName)
    {
        int rowCounter;
        int columnCounter;
        int columnNumber = 0;
        String cellValue = "";

        try
        {
            excelFile = new File(excelFilePath);
            fileInputStream = new FileInputStream(excelFile);
            excelWorkbook = WorkbookFactory.create(fileInputStream);
            excelSheet = excelWorkbook.getSheet(excelSheetName);

            // For Scenario 2, handling exception because SAN / Policy Number for RCIS is stored in REIS column, while NBIS column contains Quote from Snap
            if(scenarioName.equalsIgnoreCase("Scenario 2"))
            {
                if(transactionName.equalsIgnoreCase("NBIS"))
                {
                    transactionName = "NBIS";
                }
                else
                {
                    transactionName = "REIS";
                }
            }
            else
            {
                if(!transactionName.equalsIgnoreCase("REIS"))
                {
                    transactionName = "NBIS";
                }
            }
            for(columnCounter=0;columnCounter<excelSheet.getRow(0).getLastCellNum();columnCounter++)
            {
                if(excelSheet.getRow(0).getCell(columnCounter).getStringCellValue().trim().equalsIgnoreCase(spNumber))
                {
                    if(excelSheet.getRow(1).getCell(columnCounter).getStringCellValue().trim().equalsIgnoreCase(transactionName))
                    {
                        columnNumber = columnCounter;
                    }
                    else
                    {
                        columnNumber = columnCounter + 1;
                    }
                    break;
                }
            }
            for(rowCounter=0;rowCounter<excelSheet.getLastRowNum();rowCounter++)
            {
                if(excelSheet.getRow(rowCounter).getCell(0).getStringCellValue().replace(" ", "").trim().contains(scenarioName.replace(" ", "").trim()))
                {
                    excelCell = excelSheet.getRow(rowCounter).getCell(columnNumber);
                    cellValue = excelCell.toString().trim();
                    if(cellValue.indexOf(".") > 0)
                    {
                        cellValue = cellValue.substring(0, cellValue.indexOf("."));
                    }
                    break;
                }
            }
            excelWorkbook.close();
            fileInputStream.close();
            excelFile = null;
            return cellValue;
        }
        catch (IOException | InvalidFormatException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}