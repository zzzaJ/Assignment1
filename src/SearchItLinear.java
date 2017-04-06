import java.io.File;
import java.util.Scanner;

/** 
 * Provides methods allowing for linear searching of array for specified data from query file.
 * @author Dino Bossi
*/
public class SearchItLinear {
   
    /**
     *method to load all elements from the testdata file into an unsorted string array
     *each line in the file is placed into an element in the array
     * 
     *@return Returns a string array with data from the testdata file
     */
    public static String[] loadData(){ 
        
        String[] arr = new String[10000]; //initializing array to hold data from testdata file
        int count = 0; //initializing counter to record line number and appropriate array entry
        
        try{
            
            Scanner scanf = new Scanner(new File("testdata"));
            
            while (scanf.hasNextLine()){ //looping through lines in testdata adding each one to array arr
                
                String line = scanf.nextLine();
                arr[count] = line;
                count++;
                                
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString());
            
        }
        
        return arr;
            
    }
    /** 
     *method to load in queries from a query file and search for them in an unsorted string array
     *The method does not return anything, but rather prints the full entry for each name found.
     */
    public static void search(){
    
        String[] arr = loadData(); // calling above method to obtain testdata entries in an array
        
        try{
            
            Scanner scanf = new Scanner(new File("queries.txt"));
            
            while (scanf.hasNextLine()){ // searching for each name present in queries that is also in the testdata unsorted array
                
                String line = scanf.nextLine();
                                
                for(int i = 0; i < arr.length; i++){
                    
                    if(line.equals(arr[i].substring(arr[i].lastIndexOf("|")+1))){ //using substring to obtain just the name from each array entry and comparing to the queries
                        
                        System.out.println(arr[i]);
                        
                    }
                    
                }     
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); // print the exception if one occurs
            
        }
    
}
    
    public static void main (String[]args){ //main method to run the search
        
        search();
           
    }
    
}
