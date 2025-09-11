#include <iostream>
using namespace std;
int main(){
    int N,mayor,menor,suma,numero;
    cout << "Introduzca la secuencia de numeros: ";
    cin >> N;
    suma = N;
    mayor = N;
    menor = N;
    for (int cont = 2; cont <= N; cont++) {
        cin >> numero;
        suma += numero;
        if (numero > mayor) {
            mayor = numero;
        } else if (numero < menor) {
            menor = numero;
        }
    }
    cout << "El mayor es: " << mayor << endl;
    cout << "El menor es: " << menor << endl;
    cout << "La media es: " << double(suma) / N << endl;
    return 0;
}
