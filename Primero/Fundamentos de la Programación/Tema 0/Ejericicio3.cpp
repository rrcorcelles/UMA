#include <iostream>
using namespace std;
const int COMPLEMENTO_QUINQUENIOS = 60;
const int COMPLEMENTO_ANYOS = 6;
const double IMPUESTO = 0.2; // 20%
const double SEGURO_MEDICO = 0.05; // 5%

int main() {
    double sueldoBase;
    int antiguedad;
    double salarioBruto, salarioNeto;
        cout << "Introduzca Sueldo Base y Antiguedad: ";
        cin >> sueldoBase >> antiguedad;
        salarioBruto = sueldoBase + COMPLEMENTO_QUINQUENIOS * (antiguedad / 5) + COMPLEMENTO_ANYOS * (antiguedad % 5);
        salarioNeto = salarioBruto - (IMPUESTO + SEGURO_MEDICO) * salarioBruto;
        cout << "El salario neto es: " << salarioNeto << endl;
    return 0;
}