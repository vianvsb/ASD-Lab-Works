#include <iostream>
using namespace std;

class AbstractEmployee {//CONTRACT 
    virtual void AskForPromotion()=0; //what is pure virtual function -> RULE. 
// virtual void is the mandatory rule you need to use if you use the 'contract' 

};

class Employee: AbstractEmployee { 
private: //ENCAPSULATION
    //attributes and behaviours 
     
    string Company; 
    int Age; 

protected: //making private things accessible for derived classes 
    string Name;
public: 
    void setName(string name){//setter 
        Name = name; 
    }
    string getName() {// getter
        return Name; 
    }
    void setCompany (string company) {
        Company = company; 
    }
    string getCompany(){
        return Company; 
    }
    void setAge (int age) {
        if (age>=18)
        Age = age;
    }
    int getAge(){
        return Age; 
    }

    void IntroduceYourself(){
        cout<<"name - " << Name << endl; 
        cout<< "company - " << Company << endl;
        cout << "age - " << Age << endl; 
    }
    Employee(string name, string company, int age){
        Name = name; 
        Company = company; 
        Age = age;
    } //constructor rules: 'class name' (parameter){assign parameter to properties}, shud be public 

    void AskForPromotion(){
        if (Age>=30)
            cout << Name << " got promoted! Congratz" << endl;
        else
            cout << Name << " sorry NO promotion for you!"<< endl; 
    }

    void Work(){
        cout << Name << " is handing the books, and cleaning the toilet." << endl; 

    }
};  

class Developer:public Employee { //Dev = child class to Emp
//Dev now has all the properties of Emp
public: 
    string FavProgrammingLang; 
    Developer(string name, string company, int age, string favprogramminglang)
        :Employee(name, company, age) {
            FavProgrammingLang = favprogramminglang; 
        }
    void FixBug(){ //Name can be accessed as Dev is a child class of Emp
        cout<< Name << " fixed bug using " << FavProgrammingLang << endl; 
    }

    void Work(){ 
        cout << Name << " is writing a " << FavProgrammingLang << " code" << endl; 

    }
};

class Engineer:public Employee {
    public: 
    string Major; 
    Engineer(string name, string company, int age, string major)
        :Employee(name, company, age) {
            Major = major;
        }
    void Manufacture(){
        cout<< Name << " is a  " << Major << endl; 
        }

    void Work(){ 
        cout << Name << " is in the " << Major << "ing industry" << endl; 

    }
};

//matchaberry  

//inheritance - base class (parent class)
    // child class - a class that inherits members from the base class
    // can use all attributes and attributes as base class but can have specific att/beh. 

int main(){
    Employee employee1 = Employee("Naruto", "Facebook", 25); 
    //employee1.IntroduceYourself();

    Employee employee2 = Employee("John Smith", "Amazon", 30); 
    //employee2.IntroduceYourself(); 

    //employee1.setAge(12);
    //cout<< employee1.getName() << " is " << employee1.getAge() << endl; 
    //employee1.AskForPromotion(); //ABSTRACTION!! 
    //employee2.AskForPromotion();

    Developer dev1= Developer("Chris", "Meta", 23, "C++");
    //dev1.FixBug();
    //dev1.AskForPromotion();

    Engineer eng1= Engineer("Sam", "Youtube", 33, "chemical engineer");
    eng1.AskForPromotion(); //kan di Emp udh public knp ttp gbs yak

    employee1.Work();
    eng1.Work();
    dev1.Work(); 
    //polymorphism -> same code, diff implementation 

    return 0; 
}