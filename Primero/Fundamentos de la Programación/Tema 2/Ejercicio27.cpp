#include <iostream>
using namespace std;
int main(){
    int inf,sup,propuesta;
    char res;
    do {
        cout << "Introduzca rango de enteros y piensa un numero en ese rango: ";
        cin >> inf >> sup;
    } while (inf > sup);
    do {
        propuesta = (inf + sup) / 2;
        cout << "¿Es el numero " << propuesta << "? (=, >, <)";
        cin >> res;
        if (res == '>') {
            inf = propuesta + 1;
        } else if (res == '<'){
            sup = propuesta - 1;
        }
    } while (res != '=' && inf <= sup);
    if (inf > sup) {
        cout << "Me has mentido\n";
    } else {
        cout << "ACERTADO\n";
    }
    return 0;
}