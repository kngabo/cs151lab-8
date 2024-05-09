import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    
    private HashMap<String, List<String>> graph;
    private List<Vertex> vCollection;

    public Graph(){
        this.graph = new HashMap<String, List<String>>();
        this.vCollection = new ArrayList<>();
    }
    
    public void addVertex(Vertex vertex){   
        
        if(!graph.containsKey(vertex.getName())){
            this.graph.put(vertex.getName(), vertex.getList());
            this.vCollection.add(vertex);
        }       
    }

    public void addEdge(Vertex source, Vertex destination, String label){
        List<String> bucket = graph.get(source.getName());
        Edge edge = new Edge(source, destination, label);
        bucket.add(edge.getLabel());      
    }

    public List<Vertex> getVertexList(){
        return this.vCollection;
    }
}
