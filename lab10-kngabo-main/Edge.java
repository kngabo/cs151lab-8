/**
 * Represents an edge in a graph. Each edge connects two vertices and has a label.
 */
public class Edge {
    
    private Vertex source;          // The source vertex of the edge.
    private Vertex destination;     // The destination vertex of the edge.
    private String label;           // The label of the edge.

    /**
     * Constructs an Edge with a source vertex, destination vertex, and a label.
     * @param source The source vertex of the edge.
     * @param destination The destination vertex of the edge.
     * @param label The label of the edge.
     */
    public Edge(Vertex source, Vertex destination, String  label){
        this.source = source;
        this.destination = destination;
        this.label = label;
    }
    
    /**
     * Returns a string representation of the edge.
     * This representation defaults to the label of the edge.
     * @return A string representing the edge.
     */
    @Override
    public String toString() {
        return this.label;
    }

    /**
     * Gets the source vertex of the edge.
     * @return The source vertex.
     */
    public Vertex getSource(){
        return this.source;
    }

    /**
     * Gets the destination vertex of the edge.
     * @return The destination vertex.
     */
    public Vertex getDestination(){
        return this.destination;
    }

    /**
     * Gets the label of the edge.
     * @return The label of the edge.
     */
    public String getLabel(){
        return this.label;
    }

    /**
     * Gets the edge based on its label. In this simplistic approach, it returns itself.
     * This method might be intended to support a more complex mechanism or is a placeholder.
     * @param label The label of the edge to be retrieved.
     * @return The edge itself as there is no mechanism to search by label.
     */
    public Edge getEdge(String label){
        return this;
    }

}
