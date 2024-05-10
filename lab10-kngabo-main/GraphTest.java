import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class GraphTest {
    @Test
    void testAddEdge() {
        Graph graph = new Graph();
        Vertex kelig = new Vertex("Kelig");
        Vertex tharcisse = new Vertex("Tharcisse");
        Vertex samke = new Vertex("Samke");
        Vertex rwanda = new Vertex("Rwanda");
        Vertex burundi = new Vertex("Burundi");
        Vertex SA = new Vertex("South-Africa");

        graph.addVertex(kelig);
        graph.addVertex(tharcisse);
        graph.addVertex(samke);
        graph.addVertex(rwanda);
        graph.addVertex(burundi);
        graph.addVertex(SA);


        graph.addEdge(kelig, rwanda, "citizen");
        graph.addEdge(rwanda, burundi, "neighbour");
        graph.addEdge(kelig, tharcisse, "roommate");

        int expected = 2;
        assertEquals(expected, kelig.size());
    }
    
    @Test
    void testAddVertex(){
        Graph graph = new Graph();
        Vertex kelig = new Vertex("Kelig");
        Vertex tharcisse = new Vertex("Tharcisse");
        Vertex samke = new Vertex("Samke");
        Vertex rwanda = new Vertex("Rwanda");
        Vertex burundi = new Vertex("Burundi");
        Vertex SA = new Vertex("South-Africa");

        graph.addVertex(kelig);
        graph.addVertex(kelig); // Test Duplilcates
        graph.addVertex(tharcisse);
        graph.addVertex(samke);
        graph.addVertex(rwanda);
        graph.addVertex(burundi);
        graph.addVertex(SA);

        int expected = 6;
        assertEquals(expected, graph.getVertexList().size());
        assertTrue(graph.containsVertex(kelig));
    }
}
