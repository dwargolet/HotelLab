package hotellab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Daniel
 */
public class HotelDBAccessFactory {
    
    
    public static String getUrl(){
        String s = null;
        Character seperator = File.separatorChar;
        
        File file = new File("src" + seperator + "cfg" + seperator + "config.properties");
        Properties p = new Properties();
        FileInputStream in;
        
        try{
            in = new FileInputStream(file);
            p.load(in);
            in.close();
            s = p.getProperty("url");
            
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        return s;       
    }
    
    public static String getDriver(){
        String s = null;
        Character seperator = File.separatorChar;
        
        File file = new File("src" + seperator + "cfg" + seperator + "config.properties");
        Properties p = new Properties();
        FileInputStream in;
        
        try{
            in = new FileInputStream(file);
            p.load(in);
            in.close();
            s = p.getProperty("driver");
            
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        return s;       
    }
    
}
