#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX_REPETICIONES = 100;
const int MAX_PAL_DIST = 100;
typedef array<int,MAX_REPETICIONES> TPosiciones;
struct TPalabra {
    string palabra;
    TPosiciones posiciones;
    int nposic;
};
typedef array<TPalabra,MAX_PAL_DIST> TColeccion;
struct TDatos {
    TColeccion palabras;
    int npal;
};
int buscar(const TDatos& datos, const string& pal) {
    int i = 0;
    while ((i < datos.npal) && (datos.palabras[i].palabra != pal)) {
        i++;
    }
    return i;
}
void almacenar(TDatos& datos, const string& pal, int pos) {
    int ind = buscar(datos,pal);
    if (ind >= datos.npal) { // primera aparicion
        datos.palabras[datos.npal].palabra = pal;
        datos.palabras[datos.npal].posiciones[0] = pos;
        datos.palabras[datos.npal].nposic = 1;
        datos.npal++;
    } else { // se repite la palabra
        datos.palabras[ind].posiciones[datos.palabras[ind].nposic] = pos;
        datos.palabras[ind].nposic++;
    }
}
void escribir(const TDatos& datos) {
    for (int i = 0; i < datos.npal; i++) {
        cout << datos.palabras[i].palabra << ": ";
        for (int j=0; j < datos.palabras[i].nposic; j++) {
            cout << datos.palabras[i].posiciones[j] << " ";
        }
        cout << endl;
    }
}
int main() {
    TDatos datos = {{}}; // todas las casillas del array serán 0
    string pal;
    int pos = 0;
    cout << "Introduzca un texto terminado con la palabra FIN\n";
    cin >> pal;
    while (pal != "FIN") {
        almacenar(datos,pal,pos);
        pos++;
        cin >> pal;
    }
    cout << "El listado de palabras y sus posiciones es:\n";
    escribir(datos);
    return 0;
}