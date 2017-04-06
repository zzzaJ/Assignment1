import java.io.File;
import java.util.Scanner;

/** 
*Provides methods to load data from file into Binary Search Tree and Traverse it in order
*@author Dino Bossi
*/
public class PrintIt {
    
    /** 
     *Singular method to load telephone directory data into a Binary Search Tree
     *and print an in order traversal to the screen 
     */    
    public static void print(){
        
        BinarySearchTree bst = new BinarySearchTree(); //Initialising Binary Search Tree
        
        try{
            
            Scanner scanf = new Scanner(new File("testdata"));
            
            while (scanf.hasNextLine()){ //looping through each line of testdata
                
                String line = scanf.nextLine();
                               
                bst.addNode(line.substring(line.lastIndexOf("|")+1), line);//adding a node to the tree, with the key being the name obtained by substring and full entry being the entire line
                
            }
            
            
        }
        catch (Exception ex) {
            
            System.out.println("error: " + ex.toString()); //prints out the exception, if encountered
            
        }
        
        bst.inOrderTraverseTree(bst.root); //in order traversal method called, starting from the root node in tree
            
    }
    
    public static void main (String [] args){
        
        print();
        
    }
    
    
}
