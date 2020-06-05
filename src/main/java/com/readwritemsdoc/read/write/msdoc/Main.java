/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readwritemsdoc.read.write.msdoc;

/**
 *
 * @author richardyujra
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
//import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Main {

    public static void main(String[] args) throws Exception {
        String inPath = "/Users/richardyujra/Downloads/example.doc";
        String outPath = "/Users/richardyujra/Downloads/example_out.doc";
        Map<String, String> mapaPalabras = new HashMap<String, String>();
        mapaPalabras.put("Lorem ", "Richard");
        File file = null;
        WordExtractor extractor = null;

        try (FileInputStream in = new FileInputStream(new File(inPath));
                FileOutputStream out = new FileOutputStream(outPath, false)) {
            HWPFDocument hdt = new HWPFDocument(in);
            Range range = hdt.getRange();

            for (Map.Entry<String, String> entry : mapaPalabras.entrySet()) {

                range.replaceText(entry.getKey(), entry.getValue());
            }
            System.out.println("Xxxxxxxx" + range.text());
            hdt.write(out);

//            file = new File("/Users/richardyujra/Downloads/example.doc");
//            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//            HWPFDocument document = new HWPFDocument(fis);
//            Range range = document.getRange();
//            for (Map.Entry<String, String> entry : mapaPalabras.entrySet()) {
//                range.replaceText(entry.getKey(), entry.getValue());
//            }
//            extractor = new WordExtractor(document);
//            String[] fileData = extractor.getParagraphText();
//            for (int i = 0; i < fileData.length; i++) {
//                if (fileData[i] != null) {
//                    System.out.println(fileData[i]);
//                }
//            }
//                document.write("/Users/richardyujra/Downloads/example_result.doc");
        } catch (Exception exep) {
            exep.printStackTrace();
        }
    }
}
