package ec.edu.espe.objectandclasses.utils;

public class FileManager {
    public boolean createFile(String fileName){
        try{    
            //code that rush our application
            System.out.println("creating file -> " + fileName);
            return true;
        }
        catch(Exception ex){
            //code to handle the runtime error
            //file does not exist, permisions, open the file, C:users
            return false;
        }
    }
    
    public boolean writeString(String data, String fileName){
        try{
            System.out.println("writing " + data + "in file: " + fileName);
            //code to write a string a file
            return true;
        }
        catch(Exception ex){
            System.out.println("writing " + data + "in file " + fileName + "FAILED :-(");
            //code to handle this error
            return false;
        }
    }
    
    public String read(String fileName){
        String data;
        data = new String("");
        try{
            System.out.println("reading data from " + fileName);
            //code to read data from the file 
            data = "1,Lucy,Whit,2,false";
            return data;
        }
        catch(Exception ex){
            System.out.println("Failing to read from " + fileName);
            //code to handle this error
            return data;
        }
    }
}
