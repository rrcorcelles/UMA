#include <iostream>
using namespace std;
const double PI = 3.1416;
const double REL_GRAD_RAD = PI/180;
const int MIN_GRAD = 60;
const int SEG_GRAD = 60*MIN_GRAD;

int main() {
    int grados, minutos, segundos;
    double gradosTotales, radianes;
        cout << "Introduzca el angulo (grados minutos segundos): ";
        cin >> grados >> minutos >> segundos;
        gradosTotales = grados + (double(minutos) / MIN_GRAD) + (double(segundos) / SEG_GRAD);
        radianes = gradosTotales * REL_GRAD_RAD;
        cout << "El angulo en radianes es: " << radianes << endl;
    return 0;
}