#include <iostream>
#include <array>
using namespace std;
const int FILAS = 100;
const int COLUMNAS = 100;
typedef array<array<int,COLUMNAS>,FILAS> TSuperficie;
typedef array<array<char,COLUMNAS>,FILAS> TLava;
struct TCoordenada {
    int fil, col;
};
bool valida(int fil, int col) {
    return fil >= 0 && fil < FILAS && col >= 0 && col < COLUMNAS;
}
void inicializar(TLava& lava) {
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            lava[i][j] = ' ';
        }
    }
}
void flujoDeLavaRec(const TSuperficie& sup, int fil, int col, TLava& lava) {
    lava[fil][col] = 'o';
    if (valida(fil-1,col) && (sup[fil-1][col] < sup[fil][col])) {
        flujoDeLavaRec(sup,fil-1,col,lava);
    }
    if (valida(fil,col-1) && (sup[fil][col-1] < sup[fil][col])) {
        flujoDeLavaRec(sup,fil,col-1,lava);
    }
    if (valida(fil,col+1) && (sup[fil][col+1] < sup[fil][col])) {
        flujoDeLavaRec(sup,fil,col+1,lava);
    }
    if (valida(fil+1,col) && (sup[fil+1][col] < sup[fil][col])) {
        flujoDeLavaRec(sup,fil+1,col,lava);
    }
}
void flujoDeLava(const TSuperficie& sup, int fil, int col, TLava& lava) {
    inicializar(lava);
    flujoDeLavaRec(sup,fil,col,lava);
}
int main() {
    TSuperficie sup;
    TLava lava;
    int fil,col;
    cout << "Introduzca superficie (matriz de naturales " << FILAS << "x" << COLUMNAS << ")\n";
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            cin >> sup[i][j];
        }
    }
    cout << "Introduzca punto de crater (fila y columna):";
    cin >> fil >> col;
    flujoDeLava(sup,fil,col,lava);
    cout << "El recorrido de la lava es:\n";
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            cout << lava[i][j];
        }
        cout << endl;
    }
    return 0;
}