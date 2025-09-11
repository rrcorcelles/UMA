#include <iostream>
using namespace std; 
void escribirBlancos(int blancos) { 
    for (int cont = 1; cont <= blancos; cont++) { 
        cout << " ";
    } 
} 
void escribirAsteriscos(int asteriscos) { 
    for (int cont = 1; cont <= asteriscos; cont++) { 
        cout << "* "; 
    } 
} 
int leer() { 
    int n; 
    cout << "Introduzca numero de Lineas: "; 
    cin >> n; 
    return n; 
} 
int main() { 
    int n; 
    n = leer(); 
    for (int linea = 1; linea <= n; linea++) { 
        escribirBlancos(n-linea); 
        escribirAsteriscos(linea); 
        cout << endl; 
    } 
    return 0; 
}