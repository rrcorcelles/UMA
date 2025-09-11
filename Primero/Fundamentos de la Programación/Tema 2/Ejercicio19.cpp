#include <iostream>
using namespace std;
int main(){
    char c;
    int comas = 0, caracteres = 0;
        cout << "Introduzca el texto terminado en un punto:\n";
        // cin >> c; asi no se cuentan los espacios en blanco
        cin.get(c);
        while (c != '.') {
        caracteres++;
        if (c == ',') {
        comas++;
        }
        // cin >> c; asi no se cuentan los espacios en blanco
        cin.get(c);
        }
        cout << "Caracteres: " << caracteres << endl;
        cout << "De ellos son comas: " << comas << endl;
    return 0;
}