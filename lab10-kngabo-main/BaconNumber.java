import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BaconNumber {
    
    private Graph graph;
    
    public BaconNumber(String filePath) throws FileNotFoundException{
        this.graph = new Graph();
        
        this.helper(filePath);
    }
    private void helper(String filePath){

        Set<String> names = new HashSet<String>();
        Set<String> titles = new HashSet<String>();
        Map<String, List<String>> actorsToMovies = new HashMap<>();
        Map<String, List<String>> moviesToActors = new HashMap<>();
        // List<String> tList = new ArrayList<String>();
        // List<String> nList = new ArrayList<String>();

        File file = new File(filePath);
        Scanner lineScanner = new Scanner(file);

        while(lineScanner.hasNextLine()){

            String line = lineScanner.nextLine();
            String[] split = line.split("\t");
            String name = split[0];
            String title = split[1];

            names.add(name);
            titles.add(title);  
            List<String> aList = actorsToMovies.get(name);
            List<String> tList = moviesToActors.get(title);
            aList.add(title);
            tList.add(name);

            if(!actorsToMovies.containsKey(name)){
                actorsToMovies.put(name, new ArrayList<>());
            }

            if(!moviesToActors.containsKey(title)){
                actorsToMovies.put(title, new ArrayList<>());
            }

            actorsToMovies.get(name).add(title);
            moviesToActors.get(title).add(name);
        }

        for (String actor : names) {
            Vertex vertex = new Vertex(actor);
            graph.addVertex(vertex);
        }

        for (String actor : names) {
            List<String> showList = actorsToMovies.get(actor);
            for (String show : showList) {
                List<String> actorNamesList = moviesToActors.get(show);
                for (String actorName : actorNamesList) {
                    graph.addEdge(actor, actorName, show);
                }
            }
        }


        }

    }
}
