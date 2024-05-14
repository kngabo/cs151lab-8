import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex in a graph. Each vertex has a name and maintains a list of edges and edge labels connected to it.
 */
public class Vertex {
    
    public String name;                         // The name of the vertex.
    private List<String> edgeLabelList;         // A list of edge labels associated with this vertex.
    private List<Edge> edgeList;                // A list of Edge objects connected to this vertex.
    
    /**
     * Constructs a Vertex with the specified name.
     * @param name The name of the vertex.
     */
    public Vertex(String name){
        this.name = name;
        this.edgeLabelList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    /**
     * Generates a hash code for this vertex based on its name.
     * @return A hash code value for the vertex.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * Compares this vertex with another object for equality.
     * The result is true if and only if the argument is not null, is a Vertex object, and has the same name as this vertex.
     * @param obj The object to compare this vertex against.
     * @return true if the given object represents a Vertex equivalent to this vertex, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /**
     * Returns a string representation of the vertex, including its name, edge labels, and edges.
     * @return A string representation of the vertex.
     */
    @Override
    public String toString() {
        return "Vertex [name=" + name + ", edgeLabelList=" + edgeLabelList + ", edgeList=" + edgeList + "]";
    }

    /**
     * Gets the name of the vertex.
     * @return The name of the vertex.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the list of edge labels associated with this vertex.
     * @return A list of edge labels.
     */
    public List<String> getList(){
        return this.edgeLabelList;
    }

    /**
     * Returns the number of edge labels associated with this vertex.
     * @return The number of edge labels.
     */
    public int size(){
        return this.edgeLabelList.size();
    }

    /**
     * Gets the list of edges connected to this vertex.
     * @return A list of edges.
     */
    public List<Edge> getEdgeList(){
        return this.edgeList;
    }
}
