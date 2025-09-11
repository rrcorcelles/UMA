#include <iostream>
using namespace std; 
void leer(int& N, int& i) { 
    do { 
        cout << "Introduzca Numero y posicion: "; 
        cin >> N >> i; 
    } while ((N <= 0) || (i <= 0)); 
}

int potencia(int base, int exp) { 
    int res = 1; 
    for (int cont = 1; cont <= exp; cont++) { 
        res *= base; 
    } 
    return res; 
}

int digito(int N, int i) { 
    int divisor1, divisor2; 
    int resultado; 
    divisor1 = potencia(10,i); 
    divisor2 = divisor1 / 10; 
    /* se podria usar el operador ternario y sustituir el codigo que 
    viene a continuacion por: 
    return (divisor2 > N) ? -1 : ((N % divisor1) / divisor2); 
    en cuyo caso la variable resultado no haría falta 
    */
    if (divisor2 > N) { 
        resultado = -1; 
    } else { 
        resultado = ((N % divisor1) / divisor2); 
    } 
    return resultado; 
} 
void escribir(int N, int i, int dig) { 
    cout << "El digito que ocupa la posicion " << i << " del numero " << N << " es: " << dig << endl; 
} 

int main() { 
    int N,i; 
    leer(N,i); 
    escribir(N,i,digito(N,i)); 
    
    return 0; 
}