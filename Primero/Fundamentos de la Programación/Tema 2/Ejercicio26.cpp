#include <iostream>
using namespace std;
int main(){
    int intento = 29, suma;
    bool encontrado = false;
    while (!encontrado) {
        suma = 1;
        for (int cont = 2; cont <= intento/2; cont++) {
            if (intento % cont == 0) {
                suma += cont;
            }
        }
        if (suma == intento) {
            encontrado = true;
        } else {
            intento++;
        }
    }
    cout << "El numero perfecto mayor que 28 es: " << intento << endl;
    return 0;
}