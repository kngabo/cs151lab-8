public class Edge {
    
    private Vertex source;
    private Vertex destination;
    private String label;

    public Edge(Vertex source, Vertex destination, String label){
        this.source = source;
        this.destination = destination;
        this.label = label;
    }
    
    public Vertex getSource(){
        return this.source;
    }

    public Vertex getDestination(){
        return this.destination;
    }

    public String getLabel(){
        return this.label;
    }
}
