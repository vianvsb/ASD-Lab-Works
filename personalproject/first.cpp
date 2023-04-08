#include <iostream> 
using namespace std; 

int main() {
    cout << "What's your name? " << endl; 
    string name; 
    getline (cin, name); 
    cout << "hey there " << name << endl; 
    return 0; 
    
}