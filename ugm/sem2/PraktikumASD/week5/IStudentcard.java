package PraktikumASD.week5;

public class IStudentcard extends Studentcard{
    String nationality; 
    
    public void printInfo(){
        super.printInfo();
        System.out.println(this.nationality);
    }
}
