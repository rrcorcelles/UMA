#include <iostream>
using namespace std;
const double PI = 3.1416;
const double REL_GRAD_RAD = PI/180;
int main() {
    double grados,radianes;
        cout << "Introduzca el angulo (grados): ";
        cin >> grados;
        radianes = grados * REL_GRAD_RAD;
        cout << "El angulo en radianes es: " << radianes << endl;
    return 0;
}