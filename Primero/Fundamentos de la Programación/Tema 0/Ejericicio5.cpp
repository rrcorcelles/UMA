#include <iostream>
using namespace std;
int main() {
    char c1,c2,c3;
    int numero;
        cout << "Introduzca 3 caracteres digitos: ";
        cin >> c1 >> c2 >> c3;
        /*
        numero = (int(c1)-int('0')) * 100
        + (int(c2)-int('0')) * 10
        + (int(c3)-int('0'));
        */
        numero = (c1-'0') * 100 + (c2-'0') * 10 + (c3-'0');
        cout << "El numero introducido es: " << numero << endl;
    return 0;
}