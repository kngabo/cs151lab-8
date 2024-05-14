import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BaconNumber {
    
    private Graph graph;
    
    public BaconNumber(){
        this.graph = new Graph();
    }
    private void helper(String fileName) {

        Set<String> names = new HashSet<String>();
        Set<String> titles = new HashSet<String>();
        Map<String, List<String>> actorsToMovies = new HashMap<>();
        Map<String, List<String>> moviesToActors = new HashMap<>();

        
        try {
            File file = new File(fileName);
            

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
                }
                actorsToMovies.get(name).add(title);


                if(!moviesToActors.containsKey(title)){
                    moviesToActors.put(title, new ArrayList<>());
                }
                moviesToActors.get(title).add(name);

            }

            lineScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }   

        
        for (String actor : names) {
            Vertex vertex = new Vertex(actor);
            graph.addVertex(vertex);
            // System.out.println(actor);
        }

        for (String actor : names) {
            List<String> showList = actorsToMovies.get(actor);
            for (String show : showList) {
                List<String> actorNamesList = moviesToActors.get(show);
                for (String coActor : actorNamesList) {
                    Vertex actorVertex = graph.getVertex(actor);
                    Vertex coActorVertex = graph.getVertex(coActor);
                    // System.out.println(coActorVertex.name);
                    if(!actor.equals(coActor)){
                        graph.addEdge(actorVertex, coActorVertex, show);
                    }
                }
            }
        }
        System.out.println(names.size());
        System.out.println(graph.getEdgeSize());
        // for (Vertex neighbour : graph.getNeighbours(graph.getVertex("Denzel Washington"))) {
        //     System.out.println(neighbour.name);
        // }
    }
    public void buildPath(Vertex removedVertex, Edge edge){
        graph.getPath().put(removedVertex, edge);
    }


    public List<String> findPath(Vertex center, Vertex goal){

        Queue<Vertex> frontierQueue = new LinkedList<Vertex>();
        Set<Vertex> frontierSet = new HashSet<Vertex>();
        Set<Vertex> exploredSet = new HashSet<Vertex>();
        frontierQueue.add(center);
        frontierSet.add(center);

        while(!frontierQueue.isEmpty()){
            Vertex removedVertex = frontierQueue.poll();
            frontierSet.remove(removedVertex);
            exploredSet.add(removedVertex);

            for (Vertex neighbour : this.graph.getNeighbours(removedVertex)) {
                Edge edge = graph.getEdge(removedVertex, neighbour);
                if(neighbour.equals(goal)){
                    buildPath(removedVertex, edge);
                }else if(!exploredSet.contains(neighbour) && !frontierSet.contains(neighbour)){
                    frontierQueue.add(neighbour);
                    frontierSet.add(neighbour);
                    buildPath(removedVertex, edge);
                }
            }
        }
        // System.exit(0);

        List<String> labelPath = new LinkedList<>();
        Vertex current = center;

        while(!current.equals(goal)){
            labelPath.add(current.name);
            Edge nextEdge = graph.getPath().get(current);
            labelPath.add(nextEdge.getLabel());
            current = nextEdge.getDestination();
        }
        labelPath.add(goal.name);
        return labelPath;

    }

    public static void main(String[] args) {
            BaconNumber bacon = new BaconNumber();


            String fileName = args[0];
            String goalName = args[1];
            String centerName = "Kevin Bacon";

            if(args.length == 3){
                centerName = args[2];
            }

            bacon.helper(fileName);

            Vertex center = bacon.graph.getVertex("Christina Ricci");
            Vertex goal = bacon.graph.getVertex("Kevin Bacon");

            // System.out.println(center + "      " + goal);
            
            List<String> path = bacon.findPath(center, goal);


            for (String string : path) {
                System.out.print(string);
                if(!string.equals(centerName)){
                    System.out.print( " -> ");
                }
            }
            System.out.println();

    }
}
