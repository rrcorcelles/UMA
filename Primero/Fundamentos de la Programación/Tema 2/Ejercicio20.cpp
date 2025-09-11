#include <iostream>
using namespace std;
int main(){
    int num, digPares;
        do {
        cout << "Introduzca un numero natural: ";
        cin >> num;
        } while (num < 0);
    digPares = 0;
        do {
        if ((num % 10) % 2 == 0) {
        digPares++;
        }
        num = num / 10;
        } while (num != 0);
    cout << "Ese numero tiene " << digPares << " digitos pares" << endl;
    return 0;
}