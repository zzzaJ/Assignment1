import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestBinarySearchTree {

    BinarySearchTree bst1;
    BinarySearchTree bst2;
    BinarySearchTree bst3;
    BinarySearchTree bst4;
    
    @Before public void setUp(){
        
       bst1 = new BinarySearchTree();
       bst2 = new BinarySearchTree();
       bst3 = new BinarySearchTree();
       bst4 = new BinarySearchTree();
        
    }
    
    @Test public void testAddNodes(){ //Test to determine if an added node is actually added by searching for it 
        
        bst1.addNode("aTestName", "aTestEntry");
        bst1.addNode("bTestName", "bTestEntry");
        bst1.addNode("cTestName", "cTestEntry");
        assertEquals("cTestEntry", bst1.findNode("cTestName"));
        
    }
    
    @Test public void testSearchNodesNotFound(){ //Test to determine if non-existing node is not found when searched for
        
        bst2.addNode("aTestName", "aTestEntry");
        bst2.addNode("bTestName", "bTestEntry");
        bst2.addNode("cTestName", "cTestEntry");
        assertNotEquals("dTestEntry", bst1.findNode("dTestName"));
        
    }
    
    @Test public void testSearchNodesFound(){ //Test to determine if existing node can be found when searched for
        
        bst1.addNode("aTestName", "aTestEntry");
        bst1.addNode("bTestName", "bTestEntry");
        bst1.addNode("cTestName", "cTestEntry");
        assertEquals("bTestEntry", bst1.findNode("bTestName"));
        
    }
    
    
    

    
}
