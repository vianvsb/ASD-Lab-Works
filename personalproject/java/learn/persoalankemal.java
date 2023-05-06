package personalproject.java.learn; 

public class persoalankemal {
    public static boolean sameAbsVal(int i, int j){
        int absoluteValueOfI = 1;
        int absoluteValueOfJ = 1; 
        if(i > 0){
            absoluteValueOfI*=i;
        }else {
            absoluteValueOfI *= -(i);
        }

        if(j > 0){
            absoluteValueOfJ*=j;
        }else {
            absoluteValueOfJ *= -(j);
        }

        if(absoluteValueOfI == absoluteValueOfJ){
            return true; 
        } else {return false;}
    }

    public static void main(String[] args){
        System.out.println(sameAbsVal(5, 5)); 
    }
}
