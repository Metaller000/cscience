package ru.metaller.cscience.controllers.reader.classes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metaller.cscience.controllers.reader.MyFileReader;
import ru.metaller.cscience.controllers.reader.abstractions.MyFileReaderAbstraction;


import java.io.IOException;

public class PDFFileReader extends MyFileReaderAbstraction implements MyFileReader {
    final Logger logger = LoggerFactory.getLogger(PDFFileReader.class);

    @Override
    public String read(String inputFile) {
        if (checkFile(inputFile)) {
            try {
                PDDocument document = PDDocument.load(getFile());
                if (!document.isEncrypted()) {
                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);
                    PDFTextStripper tStripper = new PDFTextStripper();
                    return getText().append(tStripper.getText(document)).toString();
                }
            } catch (IOException e) {
                logger.error("ошибка чтения файла: ", e);
            }
        }
        return getText().toString();
    }
}