#include <iostream>
using namespace std;

void IntroduceMe(string name, int age){
    cout << "my name is " << name << endl;
    cout << "age is " << age << endl;
}
int main(){
    int m = 2;
    int n = 5; 

    int sum = 0;
    for(int i = m; i < n; i++){
        sum += 1; 
    }
    cout << sum; 
}