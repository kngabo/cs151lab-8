import java.util.*;

/**
 * Represents a graph with vertices and edges.
 * The graph structure is maintained using a combination of HashMap and HashSet to store vertices and edges.
 */
public class Graph {
    
    private HashMap<String, List<String>> graph;  // Holds the adjacency list representation of the graph.
    private Set<Vertex> vCollection;              // Collection of all vertices in the graph.
    private Set<Vertex> neighbours;               // Stores neighbours for a specific vertex.
    private int nEdges;                           // Count of edges in the graph.
    private Map<Vertex, Edge> path;               // Stores paths in the graph.

    /**
     * Constructs an empty graph.
     */
    public Graph(){
        this.graph = new HashMap<>();
        this.vCollection = new HashSet<>();
        this.nEdges = 0;
        this.neighbours = new HashSet<>();
        this.path = new HashMap<>();
    }
    
    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to be added.
     */
    public void addVertex(Vertex vertex){   
        if (vertex != null && !graph.containsKey(vertex.getName())) {
            this.graph.put(vertex.getName(), vertex.getList());
            this.vCollection.add(vertex);
        }  
    }

    /**
     * Adds an edge between two vertices in the graph.
     * @param source The source vertex of the edge.
     * @param destination The destination vertex of the edge.
     * @param label The label of the edge.
     */
    public void addEdge(Vertex source, Vertex destination, String label){
        if (source != null && destination != null && label != null) {
            List<String> sourceList = graph.get(source.getName());
            List<String> destinationList = graph.get(destination.getName());

            if (sourceList != null && destinationList != null && !sourceList.contains(label)) {
                sourceList.add(label);
                destinationList.add(label);

                Edge newEdge = new Edge(source, destination, label);
                source.getEdgeList().add(newEdge);
                destination.getEdgeList().add(newEdge);

                this.nEdges++;
            }
        }
    }

    /**
     * Returns the collection of all vertices in the graph.
     * @return Set of all vertices.
     */
    public Set<Vertex> getVertexList(){
        return this.vCollection;
    }

    /**
     * Retrieves a vertex from the graph by its name.
     * @param name The name of the vertex.
     * @return The vertex with the specified name or null if not found.
     */
    public Vertex getVertex(String name){
        for (Vertex vertex : this.vCollection) {
            if(vertex.getName().equals(name)){
                return vertex;
            }
        }
        return null;
    }

    /**
     * Checks if a vertex is present in the graph.
     * @param vertex The vertex to check.
     * @return True if the vertex is present, false otherwise.
     */
    public boolean containsVertex(Vertex vertex){
        return vertex != null && vCollection.contains(vertex);
    }

    /**
     * Returns the number of edges in the graph.
     * @return The number of edges.
     */
    public int getEdgeSize(){
        return this.nEdges;
    }

    /**
     * Retrieves an edge between two specified vertices.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @return The edge if it exists, null otherwise.
     */
    public Edge getEdge(Vertex source, Vertex destination){
        for (Edge edge : source.getEdgeList()) {
            if(edge.getSource().equals(source) && edge.getDestination().equals(destination)){
                return edge;
            }
        }
        return null;
    }

    /**
     * Retrieves the set of neighbouring vertices for a specified vertex.
     * @param vertex The vertex whose neighbours are to be retrieved.
     * @return A set of neighbouring vertices.
     */
    public Set<Vertex> getNeighbours(Vertex vertex){
        this.neighbours.clear();
        for (Vertex eachVertex : this.vCollection) {
            for (Edge edge : eachVertex.getEdgeList()) {
                if(edge.getDestination().equals(vertex)){
                    neighbours.add(edge.getSource());
                }
            }
        }
        return neighbours;
    }

    /**
     * Returns the path mapping in the graph.
     * @return A map representing the paths between vertices.
     */
    public Map<Vertex, Edge> getPath(){
        return this.path;
    }
}
