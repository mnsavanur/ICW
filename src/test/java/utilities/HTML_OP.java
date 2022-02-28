package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTML_OP {
    BufferedWriter bw;

    public static void main(String[] args) {

    }

    public void writeToReport(String finalString,String html_Report_Path) {
        String html_msg = "<html>" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border:1px solid black;\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n" +
                "<h1 style=\"text-align:center;\">Rating Worksheet</h1>" +
                "<h2 style=\"text-align:center;\">PDF Comparison...</h2>" +
                "<table style=\"width:100%\">\n" +
                finalString+
                "</table>\n" +
                "</body>\n" +
                "</html>\n";
        File file = new File(html_Report_Path);
        try {
            bw = new BufferedWriter(new FileWriter(file));
            //bw.write(html_msg);
            bw.append(html_msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void closeWriting() {
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
