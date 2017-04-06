
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class TestSearchIt {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before public void setUp(){
        
       System.setOut(new PrintStream(outContent));
        
    }
    
    @Test public void testSearchIt(){ //Test to determine if SearchIt works correctly 
                                      //NB this is only one test but contains tests which will pick out errors in .search()
        SearchIt.search();
        assertEquals("gaddress|gtelephone|gname\n"
                   + "Not found\n"
                   + "aaddress|atelephone|aname\n"
                   + "caddress|ctelephone|cname\n" , outContent.toString());
    }
    
}