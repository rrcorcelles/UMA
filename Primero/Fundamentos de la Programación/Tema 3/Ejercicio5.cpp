#include <iostream>
#include <cmath>
using namespace std; 

bool esPrimo(int num) { 
    bool res = false; 
    int divisor, tope; 
    if (num >= 2) { 
        tope = sqrt(num); 
        divisor = 2; 
        while ((divisor <= tope) && (num % divisor != 0)) {
            divisor++; 
        } 
        res = divisor > tope; 
    } 
    return res; 
} 

void mostrarYActualizar(int p, int& n) { 
    while (n % p == 0) { 
        cout << p << " "; 
        n /= p; 
    } 
} 

void sigPrimo(int& p) { 
    p++; 
    while (!esPrimo(p)) { 
        p++; 
    } 
} 

void factoresPrimos(int n) { 
    int p; 
    cout << "Los divisores primos de " << n << " son: "; 
    p = 2; // paso 1 
    while (n >= p) { // paso 4 
        mostrarYActualizar(p,n); // paso 2 
        sigPrimo(p); // paso 3 
    } 
} 

int leer() { 
    int n; 
    do { 
        cout << "Introduzca un numero natural (n>1): "; 
        cin >> n; 
    } while (n <= 1); 
    return n; 
} 

int main() { 
    int n; 
    n = leer(); 
    factoresPrimos(n); 
    return 0; 
}