#include <iostream>
#include <array>
using namespace std;
const int RANGO_MAY = 26; // las 26 letras mayusculas
typedef array<int, RANGO_MAY> TFrec; // array de frecuencias de letras
const int MAX = 20;
typedef array<char, MAX> Componentes;
struct Vector {
    Componentes datos;
    int tam;
};
void calcular (TFrec& frec, const Vector& v) {
    for (int i=0; i < v.tam; i++) {
        if (('A' <= v.datos[i]) && (v.datos[i] <= 'Z')) { // robusto
            frec[v.datos[i]-'A']++;
        }
    }
}
void encontrarModa (const TFrec& frec, bool& hayModa, char& m) {
    int mayor;
    mayor = frec[0]; // frecuencia de la 'A'
    hayModa = true;
    m = 'A';
    for (int i=1; i < RANGO_MAY; i++) {
        if (frec[i] == mayor) {
            hayModa = false;
        } else if (frec[i] > mayor) {
            mayor = frec[i];
            m = char(i + 'A');
            hayModa = true;
        }
    }
}
void moda (const Vector& v, bool& hayModa, char& m) {
    TFrec frec = {{}}; // todas las casillas del array serán 0
    calcular (frec, v);
    encontrarModa (frec, hayModa,m);
}
void leer (Vector& v) {
    char c;
    cout << "Introduzca una secuencia de letras mayusculas" << " (salto de linea para terminar y como maximo " << MAX << " letras):\n";
    v.tam = 0;
    cin.get(c);
    while (c != '\n') {
        if (v.tam < MAX) {
            v.datos[v.tam] = c;
            v.tam++;
        }
        cin.get(c);
    }
}
int main() {
    Vector v;
    bool hayModa;
    char m;
    leer(v);
    moda (v, hayModa, m);
    if (hayModa) {
        cout << "La moda es: " << m << endl;
    } else {
        cout << "NO hay moda\n";
    }
    return 0;
}