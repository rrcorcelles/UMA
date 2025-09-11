#include <iostream>
#include <array>
using namespace std;
const int MAX = 50;
typedef array<int, MAX> TArray;
struct TResultado {
    TArray digitos; // sucesivos restos
    int nDig; // numero de digitos (restos)
};
void convertir (int numero, int base, TResultado& resultado) {
    resultado.nDig = 0;
    do {
        resultado.digitos [resultado.nDig] = numero % base;
        resultado.nDig++;
        numero = numero / base;
    } while (numero != 0);
}
void leerDatos (int& numero, int& base) {
    do {
        cout << "Introduzca un numero natural en base 10: ";
        cin >> numero;
    } while (numero < 0);
    do {
        cout << "Introduzca la base a la que convertirlo (2<=base<=9): ";
        cin >> base;
    } while ((base < 2) || (base > 9));
}
void escribirDatos (int numero, int base, const TResultado& res) {
    cout << "El numero " << numero << " en base " << base << " es: ";
    for (int i = res.nDig - 1; i >= 0; i--){
        cout << res.digitos[i];
    }
    cout << endl;
}
int main() {
    int numero, base;
    TResultado resultado;
    leerDatos (numero, base);
    convertir(numero, base, resultado);
    escribirDatos (numero, base, resultado);
    return 0;
}