package pl.sdacademy.models;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.*;

public class Serialize {
    public static void serialize(Object objectToSave, String filename){
        try(FileOutputStream fos = new FileOutputStream(filename)){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSave);
        }catch (IOException e){
            System.err.println(filename + " doesn't exists or write protection error.");
        }
    }

    public static Object deserialize(String filename){
        Object obj = null;
        try(FileInputStream fis = new FileInputStream(filename)){
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        }catch (IOException e ){
            System.err.println(filename + " doesn't exists or write protection error.");
        }catch ( ClassNotFoundException e){
            System.err.println("Serialization error!");
        }
        return obj;
    }
}
