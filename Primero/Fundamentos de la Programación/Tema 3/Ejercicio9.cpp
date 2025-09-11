#include <iostream>
using namespace std; 
void leer(int& P, int& Q) { 
    do { 
        cout << "Introduzca dos numeros positivos: "; 
        cin >> P >> Q; 
    } while ((P <= 0) || (Q <= 0)); 
} 

int mcd(int P, int Q) { 
    int res; 
    if (P == Q) { 
        res = P; 
    } else if (P > Q) { 
        res = mcd(P - Q,Q); 
    } else { 
        res = mcd(P, Q-P); 
    } 
    return res; 
} 

int main() { 
    int P,Q;
    leer(P,Q); 
    cout << "El MCD es: " << mcd(P,Q) << endl; 
    return 0; 
}