package ru.metaller.cscience.controllers.reader.classes;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metaller.cscience.controllers.reader.MyFileReader;

public class PDFFileReaderTest {
    final Logger logger = LoggerFactory.getLogger(PDFFileReaderTest.class);

    MyFileReader pdfReader = new PDFFileReader();

    @Test
    void NullTeast() {
        logger.info(pdfReader.read(null).equals("")?"пройден":"не пройден");
    }

    @Test
    void readTeastEmptyString() {
        logger.info(pdfReader.read("").equals("")?"пройден":"не пройден");
    }

    @Test
    void readTeastWrongDir() {
        logger.info(pdfReader.read("/opt/file/dountexist.pdf").equals("")?"пройден":"не пройден");
    }

    @Test
    void readTeastWrongFile() {
        logger.info(pdfReader.read("/home/metaller/develop/java/cscience/src/main/java/ru/metaller/cscience/controllers/reader/classes/PDFFileReader.java").equals("")?"пройден":"не пройден");
    }
}