import java.util.ArrayList;
import java.util.List;

public class Vertex {
    
    public String name;
    private List<String> edgeList;
    
    public Vertex(String name){
        this.name = name;
        this.edgeList = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public List<String> getList(){
        return this.edgeList;
    }
    public int size(){
        return this.edgeList.size();
    }
}