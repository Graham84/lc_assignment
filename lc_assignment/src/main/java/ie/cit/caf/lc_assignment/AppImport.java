package ie.cit.caf.lc_assignment;

import java.nio.file.Path;
import java.util.List;

import ie.cit.caf.lc_assignment.utility.FileFinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.databind.ObjectMapper;



/*@Import(DefaultConfig.class)*/
public class AppImport implements CommandLineRunner {
/**
 * Main import algorithm implemented here. We process chObjects first so that
 * we can then link them to the participants process thereafter.
 * 
 * @param args[0]	Neo4j database directory to create
 * @param args[1]	Directory of artist json files
 * @param args[2]	Directory of artwork json files
 */
@Override
public void run(String... args) throws Exception {
	
	/*setupDb(args[0]);*/

	String chObjectDirectory = args[0];
	/*String participantsDirectory = args[2];*/
	
	/*createIndexes();*/

	// process artists
	List<Path> files = FileFinder.getFileList(chObjectDirectory, "*.json");
	for (Path f : files) {
		ChObject chObject = new ObjectMapper().readValue(f.toFile(), ChObject.class);
	/*	Long chObjectNode = addChObjectNode(chObject);
        connectChObjectToParticipants(chObjectNode, chObject.getParticipants());
        connectChObjectToImages(chObjectNode, chObject.getImages());*/
	}

	// process objects
	files = FileFinder.getFileList(chObjectDirectory, "*.json");		
	for (Path f : files) {
		ChObject chObject = new ObjectMapper().readValue(f.toFile(), ChObject.class);
		try {
			System.out.println("\n" + chObject.toString());
			/*Long artworkNode = addChObjectNode(chObject);			
		
			connectArtworkToArtists(artworkNode, artwork.getContributors());*/
			
			/*if (artwork.getCatalogueGroup() != null && artwork.getCatalogueGroup().getId() != null) {
				connectArtworkToCatalogueGroup(artworkNode, artwork.getCatalogueGroup());
			}
			
	        connectArtworkToMovements(artworkNode, artwork.getMovements());
	        	        
	        // connect subjects with the artwork
	        if (artwork.getSubjects() != null && artwork.getSubjects().getChildren() != null) {
	        	connectArtworkToSubjects(artworkNode, artwork.getSubjects().getChildren());
	        }
	        
	        // connect classification to the artwork
	        if (artwork.getClassification() != null) {
	        	connectArtworkToClassification(artworkNode, artwork.getClassification());
	        }
	        
	        // connect mediums to the artwork
	        if (artwork.getMedium() != null) {
	        	connectArtworkToMediums(artworkNode, artwork.getMedium());
	        }*/
	        
        } catch (Exception e) {
			System.out.println("Problem with artwork: " /*+*/ /*chObject.getAcno()*/);
		}
	}
	
   /* inserter.shutdown();*/
}

/**
 * Entry point into application. Delegates to Spring boot command line runner.
 * 
 * @param args
 */
public static void main(String[] args) {
    SpringApplication.run(AppImport.class, args);
}
}
