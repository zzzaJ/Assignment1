
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class TestPrintIt {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before public void setUp(){
        
       System.setOut(new PrintStream(outContent));
        
    }
    
    @After public void cleanUp(){
        
        System.setOut(null);
        
    }
    
    @Test public void testSearchIt(){ //Test to determine if PrintIt works correctly 
                                      //NB this is only one test but contains tests which will pick out errors in .print()
        PrintIt.print(); 
        assertEquals("aaddress|atelephone|aname\n"
                   + "baddress|btelephone|bname\n"
                   + "caddress|ctelephone|cname\n"
                   + "daddress|dtelephone|dname\n"
                   + "eaddress|etelephone|ename\n"
                   + "faddress|ftelephone|fname\n"
                   + "gaddress|gtelephone|gname\n"
                   + "haddress|htelephone|hname\n" , outContent.toString());
    }
    
}
