#include <iostream> 
using namespace std; 

// math ops
int main() {
    int x = 10; 
    int y = x + 10;  // y = x++ or ++x 
    int z = y * 3;
    std::cout << z; 
    return 0;  
}
// math ops exc. 
int main() {
    double x = 10;
    int y = 5;
    double z = (x + 10)/ (3*y);
    std::cout<< z; 
    return 0; 
}

int main() {
    int x = 10; 
    int y = 20; 
    cout << "x = " << x << endl 
         << "y = " << y; 
    return 0;  
}

// variable switch 
int main() {
    int a = 1;
    int b = 2;
    int temp = a;  // temp == a = 1 -> temp = 1
    a = b; // a becomes b == 2 -> a = 2
    b = temp; // b becomes temp = 1 
    cout << a; // print a -> a = 2 / print b -> b = 1 
    return 0;
}