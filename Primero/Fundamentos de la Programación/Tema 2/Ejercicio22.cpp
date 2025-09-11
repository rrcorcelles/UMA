#include <iostream>
using namespace std;
int main(){
    char c;
    bool encontrada = false;
    cout << "Introduzca el texto terminado en un punto:\n";
    cin.get(c);
    while ((c != '.') && !encontrada) {
        if (c == 'a') {
            cin.get(c);
            if (c == 'b') {
                cin.get(c);
                encontrada = c == 'c';
            }
        } else {
            cin.get(c);
        }
    }
    if (encontrada) {
        cout << "Cadena abc SI encontrada";
    } else {
        cout << "Cadena abc NO encontrada";
    }
    return 0;
}