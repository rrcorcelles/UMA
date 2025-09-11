#include <iostream>
using namespace std;
int main() {
    int n, num;
    do {
    cout << "Introduzca el numero entero a buscar (distinto de 0): ";
    cin >> n;
    } while (n == 0);
    cout << "Introduzca una secuencia de numeros enteros terminada en 0: ";
    cin >> num;
    while ((num != 0) && (num != n)) {
    cin >> num;
    }
    if (num == n) {
    cout << "El numero " << n << " SI aparece en la secuencia" << endl;
    } else {
    cout << "El numero " << n << " NO aparece en la secuencia" << endl;
    }
}