#include <iostream>
using namespace std; 
void invertir() { 
    char c; 
    cin.get(c); 
    if (c != '.') { 
        invertir(); 
    } 
    cout << c; 
} 

int main() { 
    cout << "Introduzca un texto terminado en un punto: "; 
    invertir(); 
    return 0; 
}