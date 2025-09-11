#include <iostream>
using namespace std;
const int VALOR = 12;
int main(){
    int numero,primera = 0,ultima = 0,posicion = 0;
    cout << "Introduzca la secuencia de numeros (0 para terminar): ";
    cin >> numero;
    while (numero != 0) {
        posicion++;
        if (numero == VALOR) {
            ultima = posicion;
            if (primera == 0) {
                primera = posicion;
            }
        }
        cin >> numero;
    }
    cout << "Primera Aparicion de " << VALOR << " es: " << primera << endl;
    cout << "Ultima Aparicion de " << VALOR << " es: " << ultima << endl;
    return 0;
}