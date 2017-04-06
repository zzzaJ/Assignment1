
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
 
    public static void main(String[] arg){
        Result result = JUnitCore.runClasses(TestBinarySearchTree.class);
        
        for (Failure failure : result.getFailures()){
            
            System.out.println(failure.toString()); // prints all failed tests, if any      
        }
        
        System.out.println(result.wasSuccessful()); // returns true if all tests were passed
              
    }
    
}
