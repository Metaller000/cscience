package ru.metaller.cscience.controllers.reader.classes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import ru.metaller.cscience.controllers.reader.Reader;

import java.io.File;
import java.io.IOException;

public class PDFReader implements Reader {
    public String read(String file) {
        StringBuilder text = new StringBuilder();
        try (PDDocument document = PDDocument.load(new File(file))) {
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                text.append(tStripper.getText(document));
            }else{
                text.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
