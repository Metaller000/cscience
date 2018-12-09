package ru.metaller.cscience.controllers.reader.abstractions;

import java.io.File;

public abstract class MyFileReaderAbstraction {
    private StringBuilder text = null;
    private File file = null;

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    private boolean checkForZero(String addres) {
        if (addres == null) return true;
        return false;
    }

    public boolean checkFile(String addres) {
        setText(new StringBuilder(""));
        setFile(new File(addres));
        if (checkForZero(addres)) return false;
        if (!file.isFile()) return false;
        return true;
    }
}
