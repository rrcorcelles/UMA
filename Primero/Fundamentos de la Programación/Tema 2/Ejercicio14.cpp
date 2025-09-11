#include <iostream>
using namespace std;
const int DIV1 = 3;
const int DIV2 = 4;
const int DIV3 = 5;
int main(){
    int num;
    cout << "Introduzca un numero natural: ";
    cin >> num;
    if ((num % DIV1 == 0) || (num % DIV2 == 0) || (num % DIV3 == 0)) {
    cout << "SI es divisible" << endl;
    } else {
    cout << "No es divisible" << endl;
    }
return 0;
}