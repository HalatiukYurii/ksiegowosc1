package pl.sdacademy.models;

public interface FileHandler {
    public void saveToFile(Object objectToSave, String filename);
    public Object loadFromFile(String filename);
}