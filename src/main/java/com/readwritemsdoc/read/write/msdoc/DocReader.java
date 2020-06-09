//https://www.docx4java.org/forums/docx-java-f6/reading-word-template-a-dot-file-t516.html

// https://stackoverflow.com/questions/22268898/replacing-a-text-in-apache-poi-xwpf
package com.readwritemsdoc.read.write.msdoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.poifs.filesystem.POIFSDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.readwritemsdoc.read.write.msdoc.EmployeeDetails;

public class DocReader {

    String outFilename = "/Users/richardyujra/Downloads/template_nuevo.dot";
    String inputFile = "/Users/richardyujra/Downloads/template.dot";

    public void readDocFile() {
        String filesname = inputFile;
        POIFSFileSystem fs = null;

        try {
            File file = new File(filesname);
            fs = new POIFSFileSystem(new FileInputStream(file));
            HWPFDocument doc = new HWPFDocument(fs);
            WordExtractor we = new WordExtractor(doc);
            String paragraphstr = we.getText();
            StringBuilder stringBuilder = new StringBuilder(paragraphstr.length());
            EmployeeDetails details = new EmployeeDetails();
            details.setEmployeeId("123456789");
            details.setEmployeeName("xxxxxx");
            details.setQualification("B.E");
            details.setEmployeeJoiningDate("04/01/2012");
            details.setEvaluationPeriod("2 years");
            details.setCurrentJobTitle("trainee");
            details.setDepartment("java");
            details.setSupervisor("yyyyy");
            details.setEvaluationDate("05/6/2012");

            /*
for (int i = 0; i < paragraphstr1.length; i++) { paragraphstr1[i]
= paragraphstr1[i] .replaceAll("<jwEmployeeId>",
details.getEmployeeId()) .replaceAll("<jwEmployeeName>",
details.getEmployeeName()) .replaceAll("<jwQualification>",
details.getQualification()) .replaceAll("<jwEOJDate>",
details.getEmployeeJoiningDate()) .replaceAll("<jwEvalPeriod>",
details.getEvaluationPeriod()) .replaceAll("<jwCurrJob>",
details.getCurrentJobTitle()) .replaceAll("<jwDept>",
details.getDepartment()) .replaceAll("<jwSupervisor>",
details.getSupervisor()) .replaceAll("<jwEvalDate>",
details.getEvaluationDate());
System.out.println(paragraphstr1[i]); }
             */
            if (filesname.endsWith(".doc") || filesname.endsWith(".dot")) {
                System.out.println("es Doc o dot");
                //System.out.println("paragraphstr:>" + paragraphstr);
                String message = paragraphstr.replaceAll("<jwEmployeeId>",
                        details.getEmployeeId());
                
                String message1 = message.replaceAll("<jwEmployeeName>",
                        details.getEmployeeName());
                
                String message2 = message1.replaceAll("<jwQualification>",
                        details.getQualification());
                String message3 = message2.replaceAll("<jwEOJDate>",
                        details.getEmployeeJoiningDate());
                String message4 = message3.replaceAll("<jwEvalPeriod>",
                        details.getEvaluationPeriod());
                String message5 = message4.replaceAll("<jwCurrJob>",
                        details.getCurrentJobTitle());
                String message6 = message5.replaceAll("<jwDept>",
                        details.getDepartment());
                String message7 = message6.replaceAll("<jwSupervisor>",
                        details.getSupervisor());
                String finalMessage = message7.replaceAll("<jwEvalDate>",
                        details.getEvaluationDate());
                finalMessage.trim();
                System.out.println("message 0:>>" + finalMessage);
                //stringBuilder.append(finalMessage);

                //System.out.println("message" + stringBuilder.toString());
                /*String path = file.getCanonicalPath();
System.out.println("abs path" + file.getAbsolutePath());

POIFSDocument event = new POIFSDocument("output.doc",
new FileInputStream(new File(
"c:/temp/output/output1.doc")));
event.getViewableIterator();
doc.getSavedByTable();*/

                Range range = doc.getRange();
//                range.getParagraph(0);
                CharacterRun run = range.insertBefore(finalMessage.toString());
//                run.setBold(true);
//                run.setItalic(true);
//                run.setCapitalized(true);

                OutputStream out = new FileOutputStream(new File(outFilename));

                doc.write(out);
                out.flush();
                out.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DocReader reader = new DocReader();
        reader.readDocFile();
    }
}
