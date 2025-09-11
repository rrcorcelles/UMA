#include <iostream>
using namespace std;
const int MIN = 1;
const int MAX = 3;
int main(){
    int objetos,quitar,maximo;
    bool tocaUsuario;
    do {
        cout << "Introduzca numero de objetos (> 0): ";
        cin >> objetos;
    } while (objetos <= 0);
    if (objetos % (MAX+1) == 1) {
        cout << "Empiezas tu\n";
        tocaUsuario = true;
    } else {
        cout << "Empiezo yo\n";
        tocaUsuario = false;
    }
    while (objetos > 0) {
        if (tocaUsuario){
            do {
                if (objetos < MAX) {
                    maximo = objetos;
                } else {
                    maximo = MAX;
                }
                cout << "¿Cuantos deseas quitar (minimo " << MIN << ", maximo " << maximo << ")? ";
                cin >> quitar;
            } while ((quitar < MIN) || (quitar > maximo));
            objetos -= quitar;
            tocaUsuario = false;
        } else {
            quitar = (objetos - 1) % (MAX+1);
            objetos -= quitar;
            cout << "Quito " << quitar << ". Quedan " << objetos << endl;
            tocaUsuario = true;
        }
    }
    cout << "No quedan mas objetos. GANO YO\n";
    return 0;
}