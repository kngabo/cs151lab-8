public class Edge {
    
    private Vertex vertex1;
    private Vertex vertex2;
    private String label;

    public Edge(Vertex vertex1, Vertex vertex2, String label){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.label = label;
    }
    
    public Vertex getSource(){
        return this.vertex1;
    }

    public Vertex getDestination(){
        return this.vertex2;
    }

    public String getLabel(){
        return this.label;
    }
}
