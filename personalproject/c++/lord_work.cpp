#include <iostream>
using namespace std; 

int main(){
    int ngentot;

    cout << "Gas ngentot?" << endl;
    cin >> ngentot;

    if(ngentot == 1){
        cout << "Gas, booking dulu!" << endl;
    } else {
        cout << "Yah, cupu lu!" << endl;
    }

    return 0;
}