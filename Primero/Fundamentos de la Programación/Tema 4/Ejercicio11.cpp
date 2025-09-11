#include <iostream>
#include <array>
using namespace std;
const int N = 5;
typedef array<int,N> TVector;
//Otra opcion es usar abs de <cmath>
int valorAbsoluto(int v) {
    int res;
    if (v < 0) {
        res = -v;
    } else {
        res = v;
    }
    return res;
}
//Otra opcion es hacerlo con dos funciones, una para cada sumatorio
int sumaPesos(const TVector &v, int inicio, int fin, int centro) {
    int suma = 0;
    for(int i = inicio; i <= fin; i++) {
        suma = suma + valorAbsoluto(centro-i) * v[i];
    }
    return suma;
}
void centroVector(const TVector &v, bool &existe, int &centro) {
    existe = false;
    centro = 1;
    while (centro <= N-2 && !existe) {
        if (sumaPesos(v,0,centro-1,centro) == sumaPesos(v,centro+1,N-1,centro)) {
            existe = true;
        } else {
            centro++;
        }
    }
}
void leer(TVector& v) {
    cout << "Introduzca " << N << " numeros naturales: " << endl;
    for (int i = 0; i < N; i++){
        cin >> v[i];
    }
}
int main() {
    TVector v;
    bool existe;
    int centro;
    leer(v);
    centroVector(v,existe,centro);
    if (existe){
        cout << "El centro de este vector es el indice " << centro << endl;
    } else{
        cout << "Este vector no tiene centro " << endl;
    }
    return 0;
}