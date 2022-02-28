package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestAssist_Utility {

    public TestAssist_Utility() {
    }

    public void createDirectoryStructure(String folderPath) {
        File file;
        boolean dirCreated;

        file = new File(folderPath);
        dirCreated = file.mkdirs();

        if (dirCreated) {
            System.out.println("Directory created '" + folderPath + "'.");
        } else {
            System.out.println("Couldn't create directory '" + folderPath + "'.");
        }
    }

    public void movesPolicyOrQuoteDirectoryFromRepositoryToUserLocation(String sanNumberOrquoteNumber, String sourcePath, String destinationPath) {
        File destinationDirectory;
        File sourceDirectory;
        File[] allSourceFiles;
        String pdfFileSourcePath;
        File pdfFileSourceDirectory;
        boolean policyOrQuoteDirectoryFound;

        try {
            policyOrQuoteDirectoryFound = false;
            destinationDirectory = new File(destinationPath);
            sourceDirectory = new File(sourcePath);

            allSourceFiles = sourceDirectory.listFiles();

            System.out.println("Looping through all files at '" + sourcePath + "' looking for '" + sanNumberOrquoteNumber + "'.");
            for (File file : allSourceFiles) {
                if (file.isDirectory()) {
                    if (file.getName().contains(sanNumberOrquoteNumber)) {
                        policyOrQuoteDirectoryFound = true;
                        pdfFileSourcePath = file.getPath();
                        pdfFileSourceDirectory = new File(pdfFileSourcePath);
                        FileUtils.copyDirectoryToDirectory(pdfFileSourceDirectory, destinationDirectory);
                        break;
                    }
                }
            }
            if (policyOrQuoteDirectoryFound) {
                System.out.println("Moved Policy or Quote folder '" + sanNumberOrquoteNumber + "' from '" + sourcePath + "' to '" + destinationDirectory + "'.");
            } else {
                System.out.println("Policy or Quote folder '" + sanNumberOrquoteNumber + "' not found at '" + sourcePath + "'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createBeyondComparePDFComparisonBatchFileAndHTMLReport(String previousSPPolicyOrSANNumber, String currentSPPolicyOrSANNumber, String userSpecifiedPathForPolicies) {
        String beyondCompareDirectoryPath;
        String previousSPPolicyOrSANNumberPDFFileName;
        String currentSPPolicyOrSANNumberPDFFileName;
        String previousSPPDFFileNameWithPath;
        String currentSPPDFFileNameWithPath;
        String beyondCompareBatchFileName;
        String beyondCompareHTMLReportBatchFileName;
        String beyondCompareHTMLReportFileName;
        String beyondCompareSpecificationFileForReportFileNameWithPath;
        String tempFileName;
        File[] previousSPPolicyOrSANNumberPDFFiles;
        File[] currentSPPolicyOrSANNumberPDFFiles;
        File batchFile;
        FileWriter batchFileWriter;
        Process shellProcess;

        try {
            beyondCompareDirectoryPath = userSpecifiedPathForPolicies + "Beyond Compare Scripts\\";
            if (new File(userSpecifiedPathForPolicies + "wsa" + previousSPPolicyOrSANNumber + "\\").exists() && new File(userSpecifiedPathForPolicies + "wsa" + currentSPPolicyOrSANNumber + "\\").exists()) {
                previousSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsa" + previousSPPolicyOrSANNumber + "\\").listFiles();
                currentSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsa" + currentSPPolicyOrSANNumber + "\\").listFiles();
            } else {
                previousSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsd" + previousSPPolicyOrSANNumber + "\\").listFiles();
                currentSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsd" + currentSPPolicyOrSANNumber + "\\").listFiles();
            }
            // Loop through all files in previousSPPolicyOrSANNumberPDFFiles (Assuming both folders has same file count ignoring bureau copy)
            for (File previousSPPDFFile : previousSPPolicyOrSANNumberPDFFiles) {
                previousSPPolicyOrSANNumberPDFFileName = previousSPPDFFile.getName();
                previousSPPolicyOrSANNumberPDFFileName = previousSPPolicyOrSANNumberPDFFileName.replace(previousSPPolicyOrSANNumber, "XXXXXXXX");
                // Loop through all files in currentSPPolicyOrSANNumberFolderPath (Assuming both folders has same file count ignoring bureau copy)
                for (File currentSPPDFFile : currentSPPolicyOrSANNumberPDFFiles) {
                    beyondCompareBatchFileName = "";
                    beyondCompareHTMLReportBatchFileName = "";
                    beyondCompareHTMLReportFileName = "";
                    currentSPPolicyOrSANNumberPDFFileName = currentSPPDFFile.getName();
                    currentSPPolicyOrSANNumberPDFFileName = currentSPPolicyOrSANNumberPDFFileName.replace(currentSPPolicyOrSANNumber, "XXXXXXXX");
                    if (previousSPPolicyOrSANNumberPDFFileName.equalsIgnoreCase(currentSPPolicyOrSANNumberPDFFileName)) {
                        // Format previous SP PDF file name
                        tempFileName = previousSPPDFFile.getName();
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        beyondCompareBatchFileName = beyondCompareBatchFileName + tempFileName;
                        beyondCompareHTMLReportBatchFileName = beyondCompareHTMLReportBatchFileName + tempFileName;
                        beyondCompareHTMLReportFileName = beyondCompareHTMLReportFileName + tempFileName;
                        // Format current SP PDF file name
                        tempFileName = currentSPPDFFile.getName();
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        // Format bat file name
                        beyondCompareBatchFileName = beyondCompareBatchFileName + "__Vs__" + tempFileName;
                        beyondCompareBatchFileName = beyondCompareBatchFileName + ".bat";
                        beyondCompareHTMLReportBatchFileName = beyondCompareHTMLReportBatchFileName + "__Vs__" + tempFileName;
                        beyondCompareHTMLReportBatchFileName = beyondCompareHTMLReportBatchFileName + "_HTML_Report.bat";
                        beyondCompareHTMLReportFileName = beyondCompareHTMLReportFileName + "__Vs__" + tempFileName;
                        beyondCompareHTMLReportFileName = beyondCompareHTMLReportFileName + "_HTML_Report.html";
                        // Create previous SP PDF file name with path
                        previousSPPDFFileNameWithPath = userSpecifiedPathForPolicies;
                        previousSPPDFFileNameWithPath = previousSPPDFFileNameWithPath + "wsd" + previousSPPolicyOrSANNumber + "\\" + previousSPPDFFile.getName();
                        // Create current SP PDF file name with path
                        currentSPPDFFileNameWithPath = userSpecifiedPathForPolicies;
                        currentSPPDFFileNameWithPath = currentSPPDFFileNameWithPath + "wsd" + currentSPPolicyOrSANNumber + "\\" + currentSPPDFFile.getName();
                        // Create Beyond Compare batch file
                        batchFile = new File(beyondCompareDirectoryPath + beyondCompareBatchFileName);
                        batchFileWriter = new FileWriter(batchFile);
                        batchFileWriter.write("cd\\\r\n");
                        batchFileWriter.write("cd \"Program Files\"\r\n");
                        batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                        batchFileWriter.write("BCompare.exe \"" + previousSPPDFFileNameWithPath + "\" " + "\"" + currentSPPDFFileNameWithPath + "\"");
                        batchFileWriter.close();
                        batchFile = null;
                        System.out.println("Created Beyond Compare batch file '" + beyondCompareBatchFileName + "'.");
                        // Create Beyond Compare HTML report file
                        beyondCompareSpecificationFileForReportFileNameWithPath = System.getProperty("java.io.tmpdir") + "CompareSpecificationFileForReport.txt";
                        beyondCompareHTMLReportFileName = beyondCompareDirectoryPath + beyondCompareHTMLReportFileName;
                        batchFile = new File(beyondCompareDirectoryPath + beyondCompareHTMLReportBatchFileName);
                        batchFileWriter = new FileWriter(batchFile);
                        batchFileWriter.write("cd\\\r\n");
                        batchFileWriter.write("cd \"Program Files\"\r\n");
                        batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                        batchFileWriter.write("BCompare.exe \"@" + beyondCompareSpecificationFileForReportFileNameWithPath + "\" \"" + previousSPPDFFileNameWithPath + "\" \"" + currentSPPDFFileNameWithPath + "\" \"" + beyondCompareHTMLReportFileName + "\" /silent");
                        batchFileWriter.close();
                        batchFile = null;
                        shellProcess = Runtime.getRuntime().exec(beyondCompareDirectoryPath + beyondCompareHTMLReportBatchFileName);
                        shellProcess.waitFor();
                        Files.setAttribute(Paths.get(beyondCompareDirectoryPath + beyondCompareHTMLReportBatchFileName), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
                        System.out.println("Created Beyond Compare HTML report '" + beyondCompareHTMLReportFileName + "'.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createBeyondCompareSpecificationFileForReport() {
        String beyondCompareSpecificationFileForReportFileName;
        File batchFile;
        FileWriter batchFileWriter;
        try {
            // Create beyond compare specification file for report
            beyondCompareSpecificationFileForReportFileName = "CompareSpecificationFileForReport.txt";
            batchFile = new File(System.getProperty("java.io.tmpdir") + beyondCompareSpecificationFileForReportFileName);
            batchFileWriter = new FileWriter(batchFile);
            batchFileWriter.write("file-report layout:side-by-side options:display-mismatches output-to:\"%3\" output-options:html-color \"%1\" \"%2\"");
            batchFileWriter.close();
            batchFile = null;
            System.out.println("Create beyond compare specification file for report '" + System.getProperty("java.io.tmpdir") + beyondCompareSpecificationFileForReportFileName + "'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createPDFComparisonHTMLReport(String previousSPPolicyOrSANNumber, String currentSPPolicyOrSANNumber, String userSpecifiedPathForPolicies) {
        String pdfCompareDirectoryPath;
        String pdfCompareHTMLReportFileName;
        String previousSPPolicyOrSANNumberPDFFileName;
        String currentSPPolicyOrSANNumberPDFFileName;
        String previousSPPDFFileNameWithPath;
        String currentSPPDFFileNameWithPath;
        String tempFileName;
        File[] previousSPPolicyOrSANNumberPDFFiles;
        File[] currentSPPolicyOrSANNumberPDFFiles;
        File batchFile;
        FileWriter batchFileWriter;
        Process shellProcess;

        try {
            pdfCompareDirectoryPath = userSpecifiedPathForPolicies + "PDF Compare Reports\\";
            if (new File(userSpecifiedPathForPolicies + "wsa" + previousSPPolicyOrSANNumber + "\\").exists() && new File(userSpecifiedPathForPolicies + "wsa" + currentSPPolicyOrSANNumber + "\\").exists()) {
                previousSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsa" + previousSPPolicyOrSANNumber + "\\").listFiles();
                currentSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsa" + currentSPPolicyOrSANNumber + "\\").listFiles();
            } else {
                previousSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsd" + previousSPPolicyOrSANNumber + "\\").listFiles();
                currentSPPolicyOrSANNumberPDFFiles = new File(userSpecifiedPathForPolicies + "wsd" + currentSPPolicyOrSANNumber + "\\").listFiles();
            }
            // Loop through all files in previousSPPolicyOrSANNumberPDFFiles (Assuming both folders has same file count ignoring bureau copy)
            for (File previousSPPDFFile : previousSPPolicyOrSANNumberPDFFiles) {
                previousSPPolicyOrSANNumberPDFFileName = previousSPPDFFile.getName();
                String previousPdfFileEndingName[] = previousSPPolicyOrSANNumberPDFFileName.split("\\.");
                String prevPDF_End_Name = null;
                if (previousSPPolicyOrSANNumberPDFFileName.contains(".company")) {
                    prevPDF_End_Name = previousPdfFileEndingName[1] + previousPdfFileEndingName[2];
                }
                File previousPDFFile = new File(String.valueOf(previousSPPDFFile));
                // Loop through all files in currentSPPolicyOrSANNumberFolderPath (Assuming both folders has same file count ignoring bureau copy)
                for (File currentSPPDFFile : currentSPPolicyOrSANNumberPDFFiles) {
                    pdfCompareHTMLReportFileName = "";
                    currentSPPolicyOrSANNumberPDFFileName = currentSPPDFFile.getName();
                    String currentPdfFileEndingName[] = currentSPPolicyOrSANNumberPDFFileName.split("\\.");
                    String currentPDF_End_Name = null;
                    if (currentSPPolicyOrSANNumberPDFFileName.contains(".company")) {
                        currentPDF_End_Name = currentPdfFileEndingName[1] + currentPdfFileEndingName[2];
                    }
                    File currentPDFFile = new File(String.valueOf(currentSPPDFFile));
                    if (currentSPPolicyOrSANNumberPDFFileName.contains(".company")&&previousSPPolicyOrSANNumberPDFFileName.contains(".company")) {
                        if (prevPDF_End_Name.equalsIgnoreCase(currentPDF_End_Name)) {
                            HTML_OP rp = new HTML_OP();
                            PDDocument document1 = PDDocument.load(previousPDFFile);
                            PDDocument document2 = PDDocument.load(currentPDFFile);

                            //Instantiating Splitter class
                            Splitter splitter = new Splitter();

                            //splitting the pages of a PDF document
                            List<PDDocument> Pages1 = splitter.split(document1);
                            List<PDDocument> Pages2 = splitter.split(document2);

                            //Creating an iterator
                            Iterator<PDDocument> iterator1 = Pages1.listIterator();
                            Iterator<PDDocument> iterator2 = Pages2.listIterator();

                            System.out.println(Pages1.size() + "\n" + Pages2.size());
                            PDDocument pdA[] = new PDDocument[Pages1.size()];
                            PDDocument pdB[] = new PDDocument[Pages2.size()];
                            int j = 0;
                            while (iterator1.hasNext()) {
                                pdA[j] = iterator1.next();
                                j++;
                            }
                            int i = 0;
                            while (iterator2.hasNext()) {
                                pdB[i] = iterator2.next();
                                i++;
                            }
                            int pageNo1 = 0;
                            for (int p = 0; p <pdA.length; p++) {
                                if (new PDFTextStripper().getText(pdA[p]).contains("Rating Worksheets")) {
                                    pageNo1 = p;
                                    break;
                                }
                            }
                            int pageNo2 = 0;
                            for (int p = 0; p < pdB.length; p++) {
                                if (new PDFTextStripper().getText(pdB[p]).contains("Rating Worksheets")) {
                                    pageNo2 = p;
                                    break;
                                }
                            }
                            int difference = 0;
                            if (Pages1.size() > Pages2.size()) {
                                if (pageNo1 > pageNo2) {
                                    difference = pageNo1 - pageNo2;
                                }
                            } else {
                                difference = pageNo1 - pageNo2;
                            }
                            String opMsg = "<tr  style=\"background-color:#D86727\"><td><h3 style=\"text-align:center;\">PDF File1 = " + previousSPPolicyOrSANNumberPDFFileName + "</h3></td>" + "<td><h3 style=\"text-align:center;\"> PDF File2 =" + currentSPPolicyOrSANNumberPDFFileName + "</h3></td></tr>";
                            for (int k = pageNo2; k <Pages2.size(); k++) {
                                String pdfContent1[] = new PDFTextStripper().getText(pdA[k + difference]).trim().split("\r\n|\r|\n");
                                String pdfContent2[] = new PDFTextStripper().getText(pdB[k]).trim().split("\r\n|\r|\n");

                                List<String> pdfContent1_list = new LinkedList<String>(Arrays.asList(pdfContent1));
                                List<String> pdfContent2_List = new LinkedList<String>(Arrays.asList(pdfContent2));

                                //System.out.println(pdfContent1_list.size() + "\n" + pdfContent2_List.size());
                                if (true) {
                                    for (int l = 0; l < pdfContent1.length; l++) {
                                        try {
                                            if (!pdfContent1_list.get(l).equals(pdfContent2_List.get(l))) {
                                                //System.out.println(pdfContent1_list.get(l).trim() + "\n" + pdfContent2_List.get(l).trim());
                                                //report.writeToReport(pdfContent1_list.get(l).trim(),pdfContent2_List.get(l).trim());
                                                opMsg = opMsg + "<tr  style=\"background-color:#EFE812\"><td>" + pdfContent1_list.get(l).trim() + "</td>\n" + "<td>" + pdfContent2_List.get(l).trim() + "</td></tr>";

                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                    opMsg = opMsg + "<tr  style=\"background-color:#58D0D4\"><td>" + "      Page No : " + (k+1) + " " + "</td></tr>";
                                }
                            }
                            // Format previous SP PDF file name
                            tempFileName = previousSPPDFFile.getName();
                            tempFileName = tempFileName.replace(".pdf", "");
                            tempFileName = tempFileName.replace(".", "_");
                            pdfCompareHTMLReportFileName = pdfCompareHTMLReportFileName + tempFileName;

                            pdfCompareHTMLReportFileName = pdfCompareHTMLReportFileName + "__Vs__" + currentSPPDFFile.getName();
                            pdfCompareHTMLReportFileName = pdfCompareHTMLReportFileName + "_HTML_Report.html";

                            // Create PDF Compare HTML report file
                            pdfCompareHTMLReportFileName = pdfCompareDirectoryPath + pdfCompareHTMLReportFileName;
                            rp.writeToReport(opMsg, pdfCompareHTMLReportFileName);
                            rp.closeWriting();
                            document1.close();
                            document2.close();


                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    public void createBeyondCompareBatchFileForComparison(String BeyondCompareFilePath, String pdfFileNameFormat[], String currentTransactionNumber, String previousSPPolicyOrQuoteNumber, String currentSPPolicyOrQuoteNumber)
    {
        int pdfFileNameFormatCounter;
        String currentPDFFileTransactionNumber;
        String currentPDFFileNameFormat;
        String beyondCompareFileName;
        String tempFileName;
        String previousSPPDFFileNameWithPath;
        String currentSPPDFFileNameWithPath;
        File batchFile;
        FileWriter batchFileWriter;

        try
        {
            // Loop through the entire file list
            for(pdfFileNameFormatCounter=0;pdfFileNameFormatCounter<pdfFileNameFormat.length;pdfFileNameFormatCounter++)
            {
                beyondCompareFileName = "";
                currentPDFFileNameFormat = pdfFileNameFormat[pdfFileNameFormatCounter];
                if(currentPDFFileNameFormat.trim().contains(".quote."))
                {
                    // Format previous SP PDF file name
                    tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                    tempFileName = tempFileName.replace(".pdf", "");
                    tempFileName = tempFileName.replace(".", "_");
                    beyondCompareFileName = beyondCompareFileName + tempFileName;
                    // Format current SP PDF file name
                    tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                    tempFileName = tempFileName.replace(".pdf", "");
                    tempFileName = tempFileName.replace(".", "_");
                    // Format bat file name
                    beyondCompareFileName = beyondCompareFileName + "__Vs__" + tempFileName;
                    beyondCompareFileName = beyondCompareFileName + ".bat";
                    // Create previous SP PDF file name with path
                    previousSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                    previousSPPDFFileNameWithPath = previousSPPDFFileNameWithPath + previousSPPolicyOrQuoteNumber + "01" + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                    // Create current SP PDF file name with path
                    currentSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                    currentSPPDFFileNameWithPath = currentSPPDFFileNameWithPath + currentSPPolicyOrQuoteNumber+ "01" + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                    // Create batch file for each transaction (copy) batch file
                    batchFile = new File(BeyondCompareFilePath + beyondCompareFileName);
                    batchFileWriter = new FileWriter(batchFile);
                    batchFileWriter.write("cd\\\r\n");
                    batchFileWriter.write("cd \"Program Files\"\r\n");
                    batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                    batchFileWriter.write("BCompare.exe \"" + previousSPPDFFileNameWithPath + "\" " + "\"" + currentSPPDFFileNameWithPath + "\"");
                    batchFileWriter.close();
                    batchFile = null;
                }
                else
                {
                    currentPDFFileTransactionNumber = currentPDFFileNameFormat.replace("wsdXXXXXXXX.", "");
                    currentPDFFileTransactionNumber = currentPDFFileTransactionNumber.substring(0, currentPDFFileTransactionNumber.indexOf("."));
                    // Check if transaction number match
                    if(Integer.parseInt(currentPDFFileTransactionNumber) == Integer.parseInt(currentTransactionNumber))
                    {
                        // Format previous SP PDF file name
                        tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        beyondCompareFileName = beyondCompareFileName + tempFileName;
                        // Format current SP PDF file name
                        tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        // Format bat file name
                        beyondCompareFileName = beyondCompareFileName + "__Vs__" + tempFileName;
                        beyondCompareFileName = beyondCompareFileName + ".bat";
                        // Create previous SP PDF file name with path
                        previousSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                        previousSPPDFFileNameWithPath = previousSPPDFFileNameWithPath + "wsd" + previousSPPolicyOrQuoteNumber + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                        // Create current SP PDF file name with path
                        currentSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                        currentSPPDFFileNameWithPath = currentSPPDFFileNameWithPath + "wsd" + currentSPPolicyOrQuoteNumber + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                        // Create batch file for each transaction (copy) batch file
                        batchFile = new File(BeyondCompareFilePath + beyondCompareFileName);
                        batchFileWriter = new FileWriter(batchFile);
                        batchFileWriter.write("cd\\\r\n");
                        batchFileWriter.write("cd \"Program Files\"\r\n");
                        batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                        batchFileWriter.write("BCompare.exe \"" + previousSPPDFFileNameWithPath + "\" " + "\"" + currentSPPDFFileNameWithPath + "\"");
                        batchFileWriter.close();
                        batchFile = null;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void createBeyondCompareReportFileForComparison(String BeyondCompareFilePath, String pdfFileNameFormat[], String currentTransactionNumber, String previousSPPolicyOrQuoteNumber, String currentSPPolicyOrQuoteNumber)
    {
        int pdfFileNameFormatCounter;
        String currentPDFFileTransactionNumber;
        String currentPDFFileNameFormat;
        String beyondCompareFileNameWithPath;
        String tempFileName;
        String previousSPPDFFileNameWithPath;
        String currentSPPDFFileNameWithPath;
        String beyondCompareSpecificationFileForReportFileNameWithPath;
        String beyondCompareReportBatchFileNameWithPath;
        Process shellProcess;
        File batchFile;
        FileWriter batchFileWriter;

        try
        {
            // Loop through the entire file list
            for(pdfFileNameFormatCounter=0;pdfFileNameFormatCounter<pdfFileNameFormat.length;pdfFileNameFormatCounter++)
            {
                beyondCompareFileNameWithPath = BeyondCompareFilePath;
                currentPDFFileNameFormat = pdfFileNameFormat[pdfFileNameFormatCounter];
                if(currentPDFFileNameFormat.trim().contains(".quote."))
                {
                    // Format previous SP PDF file name
                    tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                    tempFileName = tempFileName.replace(".pdf", "");
                    tempFileName = tempFileName.replace(".", "_");
                    beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + tempFileName;
                    beyondCompareReportBatchFileNameWithPath = tempFileName;
                    // Format current SP PDF file name
                    tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                    tempFileName = tempFileName.replace(".pdf", "");
                    tempFileName = tempFileName.replace(".", "_");
                    // Format report file name
                    beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + "__Vs__" + tempFileName;
                    beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + "_HTML_Report.html";
                    beyondCompareReportBatchFileNameWithPath = beyondCompareReportBatchFileNameWithPath + "__Vs__" + tempFileName;
                    beyondCompareReportBatchFileNameWithPath = beyondCompareReportBatchFileNameWithPath + "_Report.bat";
                    // Create previous SP PDF file name with path
                    previousSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                    previousSPPDFFileNameWithPath = previousSPPDFFileNameWithPath + previousSPPolicyOrQuoteNumber + "01" + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                    // Create current SP PDF file name with path
                    currentSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                    currentSPPDFFileNameWithPath = currentSPPDFFileNameWithPath + currentSPPolicyOrQuoteNumber + "01" + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                    // Create batch file for report file
                    beyondCompareSpecificationFileForReportFileNameWithPath = System.getProperty("java.io.tmpdir") + "CompareSpecificationFileForReport.txt";
                    beyondCompareReportBatchFileNameWithPath = System.getProperty("java.io.tmpdir") + beyondCompareReportBatchFileNameWithPath;
                    batchFile = new File(beyondCompareReportBatchFileNameWithPath);
                    batchFileWriter = new FileWriter(batchFile);
                    batchFileWriter.write("cd\\\r\n");
                    batchFileWriter.write("cd \"Program Files\"\r\n");
                    batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                    batchFileWriter.write("BCompare.exe \"@" + beyondCompareSpecificationFileForReportFileNameWithPath + "\" \"" + previousSPPDFFileNameWithPath + "\" \"" + currentSPPDFFileNameWithPath + "\" \"" + beyondCompareFileNameWithPath + "\" /silent");
                    batchFileWriter.close();
                    batchFile = null;
                    shellProcess = Runtime.getRuntime().exec(beyondCompareReportBatchFileNameWithPath);
                    shellProcess.waitFor();
                }
                else
                {
                    currentPDFFileTransactionNumber = currentPDFFileNameFormat.replace("wsdXXXXXXXX.", "");
                    currentPDFFileTransactionNumber = currentPDFFileTransactionNumber.substring(0, currentPDFFileTransactionNumber.indexOf("."));
                    // Check if transaction number match
                    if(Integer.parseInt(currentPDFFileTransactionNumber) == Integer.parseInt(currentTransactionNumber))
                    {
                        // Format previous SP PDF file name
                        tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + tempFileName;
                        beyondCompareReportBatchFileNameWithPath = tempFileName;
                        // Format current SP PDF file name
                        tempFileName = currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                        tempFileName = tempFileName.replace(".pdf", "");
                        tempFileName = tempFileName.replace(".", "_");
                        // Format report file name
                        beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + "__Vs__" + tempFileName;
                        beyondCompareFileNameWithPath = beyondCompareFileNameWithPath + "_HTML_Report.html";
                        beyondCompareReportBatchFileNameWithPath = beyondCompareReportBatchFileNameWithPath + "__Vs__" + tempFileName;
                        beyondCompareReportBatchFileNameWithPath = beyondCompareReportBatchFileNameWithPath + "_Report.bat";
                        // Create previous SP PDF file name with path
                        previousSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                        previousSPPDFFileNameWithPath = previousSPPDFFileNameWithPath + "wsd" + previousSPPolicyOrQuoteNumber + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", previousSPPolicyOrQuoteNumber);
                        // Create current SP PDF file name with path
                        currentSPPDFFileNameWithPath = BeyondCompareFilePath.replace("Beyond Compare Scripts\\", "");
                        currentSPPDFFileNameWithPath = currentSPPDFFileNameWithPath + "wsd" + currentSPPolicyOrQuoteNumber + "\\" + currentPDFFileNameFormat.replace("XXXXXXXX", currentSPPolicyOrQuoteNumber);
                        // Create batch file for report file
                        beyondCompareSpecificationFileForReportFileNameWithPath = System.getProperty("java.io.tmpdir") + "CompareSpecificationFileForReport.txt";
                        beyondCompareReportBatchFileNameWithPath = System.getProperty("java.io.tmpdir") + beyondCompareReportBatchFileNameWithPath;
                        batchFile = new File(beyondCompareReportBatchFileNameWithPath);
                        batchFileWriter = new FileWriter(batchFile);
                        batchFileWriter.write("cd\\\r\n");
                        batchFileWriter.write("cd \"Program Files\"\r\n");
                        batchFileWriter.write("cd \"Beyond Compare 4\"\r\n");
                        batchFileWriter.write("BCompare.exe \"@" + beyondCompareSpecificationFileForReportFileNameWithPath + "\" \"" + previousSPPDFFileNameWithPath + "\" \"" + currentSPPDFFileNameWithPath + "\" \"" + beyondCompareFileNameWithPath + "\" /silent");
                        batchFileWriter.close();
                        batchFile = null;
                        shellProcess = Runtime.getRuntime().exec(beyondCompareReportBatchFileNameWithPath);
                        shellProcess.waitFor();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    */

}