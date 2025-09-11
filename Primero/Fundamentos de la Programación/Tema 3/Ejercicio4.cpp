#include <iostream>
using namespace std;

int leer() { 
    int N; 
    do { 
        cout << "Introduzca el Numero (> 0): "; 
        cin >> N; 
    } while (N <= 0); 
    return N; 
} 

int digito(int N, int i) { 
    int resultado; 
    int resto, cont; 
    cont = 0; 
    while ((cont < i) && (N > 0)) { 
        cont++; 
        resto = N % 10; 
        N = N / 10; 
    } 
    if (cont < i) { 
        resultado = -1; 
    } else { 
        resultado = resto; 
    } 
    return resultado; 
} 

int contarDigitos(int N){ 
    int cont; 
    cont = 0; 
    while (N > 0) { 
        N = N / 10; 
        cont++; 
    } 
    return cont; 
} 

int main() { 
    int N, numDigitos; 
    int d1, d2; 
    N = leer(); 
    numDigitos = contarDigitos(N); 
    for (int cont = 1; cont <= numDigitos / 2; cont++) { 
        d1 = digito(N,cont); 
        d2 = digito(N,numDigitos-cont+1); 
        cout << d1 << " + " << d2 << " = " << d1+d2 << endl; 
    } 
    if (numDigitos % 2 != 0) { 
        cout << digito(N,numDigitos / 2 + 1) << endl;
    } 
    return 0; 
}