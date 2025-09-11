#include <iostream>
#include <array>
#include <string>
#include <cmath>
using namespace std;
const int MAX_CARGOS = 100;
const int MAX_PARTIDOS = 100;
typedef array<array<double,MAX_CARGOS>,MAX_PARTIDOS> TMatriz;
struct TDivisores {
    TMatriz valores;
    int numCargos, numPartidos;
};
struct TDatos {
    string nombre;
    int cargos;
};
typedef array<TDatos,MAX_PARTIDOS> TResultados;
struct TResultado {
    TResultados partidos;
    int numPartidos;
};
void leerDatos(TDivisores& divisores, TResultado& resultado) {
    do {
        cout << "Introduzca el Numero de Cargos (>= 1 y <= " << MAX_CARGOS << "): ";
        cin >> divisores.numCargos;
    } while ((divisores.numCargos < 1) || (divisores.numCargos > MAX_CARGOS));
    do {
        cout << "Introduzca el Numero de Partidos (>= 1 y <= " << MAX_PARTIDOS << "): ";
        cin >> divisores.numPartidos;
    } while ((divisores.numPartidos < 1) || (divisores.numPartidos > MAX_PARTIDOS));
    resultado.numPartidos = divisores.numPartidos;
    cout << "Introduzca el Nombre y Numero de Votos por Partido:\n";
    for (int i = 0; i < resultado.numPartidos; i++) {
        cout << "Partido " << i+1 << ": ";
        cin >> resultado.partidos[i].nombre >> divisores.valores[i][0];
        resultado.partidos[i].cargos = 0;
    }
}
void calcularDivisores(TDivisores& divisores) {
    for (int fil = 0; fil < divisores.numPartidos; fil++) {
        for (int col = 1; col < divisores.numCargos; col++) {
            divisores.valores[fil][col] = divisores.valores[fil][0] / (col+1);
        }
    }
}
void calcularMayor(const TDivisores& divisores, int& fil, int& col) {
    fil = 0;
    col = 0;
    for (int f = 0; f < divisores.numPartidos; f++) {
        for (int c = 0; c < divisores.numCargos; c++) {
            if (divisores.valores[f][c] > divisores.valores[fil][col]) {
                fil = f;
                col = c;
            }
        }
    }
}
void calcularCargos(TDivisores& divisores, TResultado& resultado) {
    int filMayor,colMayor;
    for (int i = 0; i < divisores.numCargos; i++) {
        calcularMayor(divisores,filMayor,colMayor);
        resultado.partidos[filMayor].cargos++;
        divisores.valores[filMayor][colMayor] = 0;
    }
}
void escribirResultados(const TResultado& resultado) {
    cout << "Los Cargos Electos son:\n";
    for (int i = 0; i < resultado.numPartidos; i++) {
        if (resultado.partidos[i].cargos != 0) {
            cout << resultado.partidos[i].nombre << " " << resultado.partidos[i].cargos << endl;
        }
    }
}
int main() {
    TDivisores divisores;
    TResultado resultado;
    leerDatos(divisores,resultado);
    calcularDivisores(divisores);
    calcularCargos(divisores,resultado);
    escribirResultados(resultado);
    return 0;
}