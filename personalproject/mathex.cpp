#include <iostream>
using namespace std;

void varis(); 

int main() { 
    varis(); 
    return 0; 

}

void varis(){ 
    double sales = 95000;
    const double stateTaxRate = .04;
    const double countyTaxRate= .02;
    double state_tax = stateTaxRate * sales; 
    double county_tax = countyTaxRate * sales; 
    double total_tax = state_tax + county_tax;
    double final_sales = sales - (total_tax);
    cout << "total tax   = $" << total_tax << endl 
         << "final sales = $" << final_sales;
    
}
