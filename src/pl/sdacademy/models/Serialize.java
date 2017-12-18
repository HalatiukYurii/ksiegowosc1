package pl.sdacademy.models;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.*;

public class Serialize {
    public static void serialize(Object objectToSave, String filename){

        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSave);
            oos.close();
            fos.close();
        }catch (IOException e){
            System.err.println(filename + " doesn't exists or write protection error.");
        }
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException{
        Object obj = null;

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
            fis.close();

        return obj;
    }
}
