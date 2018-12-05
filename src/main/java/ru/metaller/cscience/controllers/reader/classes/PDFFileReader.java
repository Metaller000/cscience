package ru.metaller.cscience.controllers.reader.classes;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metaller.cscience.controllers.reader.MyFileReader;

import java.io.File;
import java.io.IOException;

public class PDFFileReader implements MyFileReader {
    final Logger logger = LoggerFactory.getLogger(PDFFileReader.class);
    public String read(String inputFile) {
        StringBuilder text = new StringBuilder("");
        if (inputFile == null) return text.toString();

        File file = new File(inputFile);
        if (!file.isFile()) return text.toString();
            try {
                PDDocument document = PDDocument.load(file);
                document.getClass();
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    text.append(tStripper.getText(document));
                }
            } catch (IOException e) {
                logger.error("ошибка чтения файла: ",e);
            }
        return text.toString();
    }
}
