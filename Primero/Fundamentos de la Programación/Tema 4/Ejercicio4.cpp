#include <iostream>
#include <array>
using namespace std;
const int MAX = 7;
typedef array<int, MAX> TArray;
void intercambiar (int x, int& y) {
    int temp;
    temp = x;
    x = y;
    y = temp;
}

void invertir (TArray& a) {
    for (int i=0; i <= MAX/2-1; i++) {
        intercambiar (a[i],a [MAX-1-i]);
    }
}

void leer (TArray& a) {
    cout << "Introduzca " << MAX << " numeros enteros: ";
    for (int i=0; i < MAX; i++) {
        cin >> a[i];
    }
}

void escribir (const TArray& a) {
    cout << "Esos numeros en orden inverso son: ";
    // con un for-each
    for (int x: a) {
        cout << x << " ";
    }
}

int main() {
    TArray a;
    leer(a);
    invertir(a);
    escribir(a);
    return 0;
}