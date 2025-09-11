#include <iostream>
#include <array>
using namespace std;
const int MAX = 10;
typedef array<int, MAX> TArray;
// el array a contiene al menos dos elementos distintos
int mayorMinimo (const TArray& a) {
    int i = 0;
    int res;
    while ((i < MAX-1) && (a[i] == a[i+1])) {
        i++;
    }
    if (i >= MAX-1) { // robusto, aunque según el enunciado no es necesario
        throw "el array no tiene al menos dos numeros distintos";
    } else if (a[i] > a[i+1]) {
        res = a[i];
    } else {
        res = a[i+1];
    }
    return res;
}
void leer (TArray& a) {
    cout << "Introduzca " << MAX << " numeros enteros: ";
    for (int i=0; i < MAX; i++) {
        cin >> a[i];
    }
}
int main() {
    TArray a;
    leer(a);
    cout << "Un elemento Mayor que el Minimo es: " << mayorMinimo(a) << endl;
    return 0;
}