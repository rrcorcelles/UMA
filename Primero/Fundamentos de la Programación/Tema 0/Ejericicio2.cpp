#include <iostream>
using namespace std;
const int MIN_HORA = 60;
int main() {
    int horas1, minutos1, horas2, minutos2, minutosDiferencia;
        cout << "Introduzca primer instante (horas minutos): ";
        cin >> horas1 >> minutos1;
        cout << "Introduzca segundo instante (horas minutos): ";
        cin >> horas2 >> minutos2;
        minutosDiferencia = (horas2 * MIN_HORA + minutos2) - (horas1 * MIN_HORA + minutos1);
        cout << "La diferencia es: " << minutosDiferencia / MIN_HORA << " horas y " << minutosDiferencia % MIN_HORA << " minutos" << endl;
    return 0;
}