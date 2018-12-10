package ru.metaller.cscience.controllers.reader.classes;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.metaller.cscience.controllers.reader.MyFileReader;

public class TextFileReaderTest {
    private final Logger logger = LoggerFactory.getLogger(TextFileReaderTest.class);

    MyFileReader pdfReader = new TextFileReader();

    @Test
    void NullTest() {
        logger.info("тест на ноль...");
        logger.info(pdfReader.read(null).equals("")?"пройден":"не пройден");
    }

    @Test
    void readTestEmptyString() {
        logger.info("тест на пустую строку...");
        logger.info(pdfReader.read("").equals("")?"пройден":"не пройден");
    }

    @Test
    void readTestWrongDir() {
        logger.info("тест на неправильный адресс...");
        logger.info(pdfReader.read("/opt/file/dountexist.pdf").equals("")?"пройден":"не пройден");
    }

    @Test
    void readTestWrongFile() {
        logger.info("тест на чтение некоректного файла...");
        logger.info(pdfReader.read("/home/metaller/develop/java/cscience/src/main/java/ru/metaller/cscience/controllers/reader/classes/PDFFileReader.java").equals("")?"пройден":"не пройден");
    }

    @Test
    void readTestRightFile() {
        logger.info("тест на чтение некоректного файла...");
        logger.info(pdfReader.read("/home/metaller/develop/java/cscience/src/main/java/ru/metaller/cscience/controllers/reader/classes/PDFFileReader.java").equals("")?"пройден":"не пройден");
    }
}
