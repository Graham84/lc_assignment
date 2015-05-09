package ie.cit.caf.lc_assignment;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * Hello world!
 *
 */
public class Application {
	
    public static void main(String[] args) {
        
    	String chObjectFile = args[0];
        System.out.printf("Processing Object file %s...\n", chObjectFile);
        
       try {
			ChObject chObject = new ObjectMapper().readValue(new File(chObjectFile), ChObject.class);
			System.out.println("\n" + chObject.toString());
	
			
		} catch (JsonParseException e) {
			System.out.println("Error parsing the file.");
		} catch (JsonMappingException e) {
			System.out.println("Error mapping to Java object.");
		} catch (IOException e) {
			System.out.println("Unknown I/O error.");
		}
    }
}
