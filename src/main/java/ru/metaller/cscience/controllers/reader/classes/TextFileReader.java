package ru.metaller.cscience.controllers.reader.classes;

import ru.metaller.cscience.controllers.reader.MyFileReader;
import ru.metaller.cscience.controllers.reader.abstractions.MyFileReaderAbstraction;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TextFileReader extends MyFileReaderAbstraction implements MyFileReader {
    @Override
    public String read(String file) {
        if (checkFile(file)) {
            try (FileReader reader = new FileReader(getFile())) {
                int cBufferSize = 1000;
                int c;
                char[] cBuffer = new char[cBufferSize];
                while ((c = reader.read(cBuffer)) != -1) {
                    if (c < cBuffer.length){
                        cBuffer = Arrays.copyOf(cBuffer, c);
                    }
                }
                return getText().append(cBuffer).toString();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return getText().toString();
    }
}
