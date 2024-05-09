import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BaconNumber {
    
    private Graph graph;
    
    public BaconNumber(String filePath) throws FileNotFoundException{
        this.graph = graph;
        
        this.helper(filePath);
    }
    private void helper(String filePath){

        Set<String> names = new HashSet<String>();
        Set<String> titles = new HashSet<String>();
        Map<String, List<String>> actorsToMovies = new HashMap<>();
        Map<List<String>, String> moviesToActors = new HashMap<>();
        List<String> tList = new ArrayList<String>();

        File file = new File(filePath);

        Scanner lineScanner = new Scanner(file);

        while(lineScanner.hasNextLine()){

            String line = lineScanner.nextLine();
            String[] split = line.split("\t");
            String name = split[0];
            String title = split[1];

            names.add(name);
            titles.add(title);
            tList.add(title);
            actorsToMovies.put(name, tList);
            moviesToActors.put(tList, name);

        }

        for (String actor : names) {
            Vertex vertex = new Vertex(actor);
            graph.addVertex(vertex);
        }

        for (Vertex vertex : graph.getVertexList()) {
            
        }


        }

    }
}
