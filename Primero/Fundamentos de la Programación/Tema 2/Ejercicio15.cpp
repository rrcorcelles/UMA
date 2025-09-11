#include <iostream>
using namespace std;
const int PRECIO_UNIDAD = 100;
const int PRECIO_DOS = 95;
const int PRECIO_TRES = 90;
const int PRECIO_CUATRO = 85;
int main(){
    int cantidad, importe;
    cout << "Introduzca la cantidad: ";
    cin >> cantidad;
        switch (cantidad) {
        case 1: importe = PRECIO_UNIDAD;
        break;
        case 2: importe = PRECIO_DOS * 2;
        break;
        case 3: importe = PRECIO_TRES * 3;
        break;
        default:importe = PRECIO_CUATRO * cantidad;
        break;
        }
    cout << "El importe es: " << importe << endl;
return 0;
}