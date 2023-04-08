#include <iostream>
using namespace std; 

int main(){
    int a; 
    cout << "a value: " << endl; 
    cin >> a; 

    int b; 
    cout << "b value: " << endl; 
    cin >> b; 

    int n; 
    cout << "n: " << endl; 
    cin >> n; 

    int Un= a + (n-1) * b; 
    cout << Un << endl; 

    int Sn= (n*(a + Un))/2; 
    


}