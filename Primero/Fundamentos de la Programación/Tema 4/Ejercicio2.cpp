#include <iostream>
#include <array>
using namespace std;
const int MAX = 10;
typedef array<int, MAX> TArray;
bool esta(int num, const TArray& a) {
    int cont = 0;
    while ((cont < MAX) && (a[cont] != num)) {
        cont++;
    }
    return cont < MAX;
}
void leerDatos (int& num, TArray& a) {
    cout << "Introduzca " << MAX << " numeros enteros: ";
    for (int i=0; i < MAX; i++) {
        cin >> a[i];
    }
    cout << "Introduzca el numero a buscar: ";
    cin >> num;
}
int main() {
    TArray a;
    int num;
    leerDatos (num,a);
    if (esta(num,a)) {
        cout << "El numero " << num << " SI esta en la coleccion" << endl;
    } else {
        cout << "El numero " << num << " NO esta en la coleccion" << endl;
    }
    return 0;
}