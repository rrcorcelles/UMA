#include <iostream>
using namespace std;
int main(){
    int num1, num2;
    cout << "Introduzca los dos numeros enteros: ";
    cin >> num1 >> num2;
    if (num2 != 0 && num1 % num2 == 0) {
    cout << num2 << " es divisor de " << num1 << endl;
    } else if (num1 != 0 && num2 % num1 == 0) {
    cout << num1 << " es divisor de " << num2 << endl;
    } else {
    cout << "No son divisibles" << endl;
    }
return 0;
}