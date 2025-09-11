#include <iostream>
#include <array>
using namespace std;
const int RANGO_MAY = 26; // las 26 letras mayúsculas
typedef array<int, RANGO_MAY> TFrec;
void inicializar (TFrec& frec) {
    for (int i=0; i < RANGO_MAY; i++) {
        frec[i] = 0;
    }
}
void calcular (TFrec& frec) {
    char c;
    cout << "Introduzca una secuencia de letras mayusculas (punto para terminar): ";
    cin.get(c);
    while (c != '.') {
        if (('A' <= c) && (c <= 'Z')) { // robusto
            frec [c - 'A']++;
        }
        cin.get(c);
    }
}
void imprimir (const TFrec& frec) {
    cout << "La frecuencia de cada letra es:" << endl;
    for (int i=0; i < RANGO_MAY; i++) {
        if (frec[i] != 0){
            cout << char(i + 'A') << ": " << frec[i] << endl;
        }
    }
}
int main() {
    TFrec frec = {{}}; // todas las casillas del array serán 0
    // TFrec frec;
    // inicializar(frec);
    calcular (frec);
    imprimir (frec);
    return 0;
}