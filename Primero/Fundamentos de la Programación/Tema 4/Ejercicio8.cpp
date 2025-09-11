#include <iostream>
#include <array>
using namespace std;
const int TAM = 32; // la casilla 0 del array no se utiliza
typedef array<int,TAM> TFrec;
void actualizar(TFrec& diasComunes) {
    int dia;
    cin >> dia;
    while (dia != 0) {
        if ((1 <= dia) && (dia <= TAM-1)) { // robusto
            diasComunes[dia]++;
        }
        cin >> dia;
    }
}
int main() {
    TFrec diasComunes = {{}};
    // todas las casillas del array serán 0
    int alumnos;
    bool hayDiasComunes = false;
    cout << "Numero de alumnos a introducir: ";
    cin >> alumnos;
    for (int i = 1; i <= alumnos; i++) {
        cout << "Introduzca los dias preferidos por el alumno " << i << " (introduzca un 0 para terminar):";
        actualizar(diasComunes);
    }
    cout << "Los dias comunes son: ";
    for (int i = 1; i < TAM; i++) {
        if (diasComunes[i] == alumnos) {
            cout << i << " ";
            hayDiasComunes = true;
        }
    }
    if (!hayDiasComunes) {
        cout << "No hay ningun dia comun\n";
    }
    return 0;
}