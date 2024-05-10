import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BaconNumber {
    
    private Graph graph;
    
    public BaconNumber(){
        this.graph = new Graph();
    }
    private void helper() {

        Set<String> names = new HashSet<String>();
        Set<String> titles = new HashSet<String>();
        Map<String, List<String>> actorsToMovies = new HashMap<>();
        Map<String, List<String>> moviesToActors = new HashMap<>();
        // List<String> tList = new ArrayList<String>();
        // List<String> nList = new ArrayList<String>();

        
        try {
            File file = new File("imdb_small.txt");

            Scanner lineScanner = new Scanner(file);

            while(lineScanner.hasNextLine()){

                String line = lineScanner.nextLine();
                String[] split = line.split("\t");
                String name = split[0];
                String title = split[1];

                names.add(name);
                titles.add(title);  

                

                if(!actorsToMovies.containsKey(name)){
                    actorsToMovies.put(name, new ArrayList<>());
                }else{
                    actorsToMovies.get(name).add(title);
                }

                if(!moviesToActors.containsKey(title)){
                    moviesToActors.put(title, new ArrayList<>());
                }else{
                    moviesToActors.get(title).add(name);
                }

            }

            lineScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }   


        for (String actor : names) {
            Vertex vertex = new Vertex(actor);
            graph.addVertex(vertex);
        }

        for (String actor : names) {
            List<String> showList = actorsToMovies.get(actor);
            for (String show : showList) {
                List<String> actorNamesList = moviesToActors.get(show);
                for (String coActor : actorNamesList) {
                    Vertex actorVertex = graph.getVertex(actor);
                    Vertex coActorVertex = graph.getVertex(coActor);
                    graph.addEdge(actorVertex, coActorVertex, show);
                }
            }
        }
        System.out.println(actorsToMovies.size());
        System.out.println(moviesToActors.size());
    }

    public List<String> findPath(Vertex center, Vertex goal){

        Queue<Vertex> frontierQueue = new LinkedList<Vertex>();
        Set<Vertex> exploredSet = new HashSet<Vertex>();
        frontierQueue.add(center);

        while(frontierQueue.isEmpty() == false){
            Vertex removedVertex = frontierQueue.remove();
            exploredSet.add(removedVertex);
            
            for (Vertex neighbour : removedVertex.getList()) {
                
            }

        }

    }

    public static void main(String[] args) {
            BaconNumber bacon = new BaconNumber();
            bacon.helper();

    }
}
