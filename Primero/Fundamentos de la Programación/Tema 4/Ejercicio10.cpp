#include <iostream>
#include <array>
using namespace std;
const int MAX = 10;
typedef array<int,MAX> TArray;
struct TLista {
    TArray elementos;
    int numElem;
};
void leerDatos(TLista& lista, int& repeticiones) {
    int num;
    int cantidad;
    do {
        cout << "Cuantos numeros desea introducir (maximo " << MAX << "): ";
        cin >> cantidad;
    } while (cantidad <= 0 || cantidad > MAX);
    cout << "Introduzca " << cantidad << " numeros: ";
    lista.numElem = 0;
    for (int cont = 1; cont <= cantidad; cont++) {
        cin >> num;
        lista.elementos[lista.numElem] = num;
        lista.numElem++;
    }
    cout << "Introduzca el numero de repeticiones para realizar la criba: ";
    cin >> repeticiones;
}
void escribir(const TLista& lista) {
    cout << "La lista cribada es: ";
    for (int i = 0; i < lista.numElem; i++) {
        cout << lista.elementos[i] << " ";
    }
}
// Version 2: Menos facil de ver, pero mas eficiente
typedef array<bool,MAX> TContados;
// calcula las repeticiones a partir de la posicion pos y marca contados
void repeticiones(int pos, const TLista& lista, TContados& contados, int& rep) {
    rep = 1;
    contados[pos] = true;
    for (int i = pos + 1; i < lista.numElem; i++) {
        if (lista.elementos[pos] == lista.elementos[i]) {
            contados[i] = true;
            rep++;
        }
    }
}
void criba(int x, const TLista& lista1, TLista& lista2) {
    TContados contados = {{}};
    // todas las casillas del array serán false
    int rep;
    lista2.numElem = 0;
    for (int i = 0; i < lista1.numElem; i++) {
        if (!contados[i]) {
            repeticiones(i,lista1,contados,rep);
            if (rep == x) {
                lista2.elementos[lista2.numElem] = lista1.elementos[i];
                lista2.numElem++;
            }
        }
    }
}
int main() {
    TLista lista1, lista2;
    int repeticiones;
    leerDatos(lista1,repeticiones);
    criba(repeticiones,lista1,lista2);
    escribir(lista2);
    return 0;
}