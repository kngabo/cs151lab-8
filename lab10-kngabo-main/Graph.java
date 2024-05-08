import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    
    private HashMap<String, List<Edge>> graph;
    private List<Vertex> vCollection;

    public Graph(){
        this.graph = new HashMap<String, List<Edge>>();
        this.vCollection = new ArrayList<>();
    }
    
    public void addVertex(Vertex vertex){   
        
        if(!graph.containsKey(vertex.getName())){
            this.graph.put(vertex.getName(), vertex.getList());
            this.vCollection.add(vertex);
        }       
    }

    public void addEdge(Vertex source, Vertex destination, String label){
        List<Edge> bucket = graph.get(source.getName());
        Edge edge = new Edge(source, destination, label);
        bucket.add(edge);      
    }

    public List<Vertex> getVertexList(){
        return this.vCollection;
    }
}
