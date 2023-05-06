package personalproject.java; 

public class tes1 {
    public static void main(String[] args){
        int[] num_list = {1, 2, 3, 4, 5, 22, 4};
        int key = 27; 
        boolean found = false;

        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] == key){
                found = true;
                break;
            }
            else {System.out.println("not found");}
        }
    }
    
}
