// Versión 1:
#include <iostream>
#include <string>
using namespace std;
bool estaContenida(char c, const string& s) {
    int i = 0;
    while ((i < int(s.size())) && (c != s[i])) {
        i++;
    }
    return i < int(s.size());
}
int main() {
    string primera, pal;
    cout << "Introduzca un texto terminado con la palabra FIN\n";
    cin >> primera;
    if (primera != "FIN") {
        cout << "Las palabras cuya inicial aparece en la primera palabra son:\n";
        cin >> pal;
        while (pal != "FIN") {
            if (estaContenida(pal[0],primera)) {
                cout << pal << " ";
            }
            cin >> pal;
        }
    }
}
// Versión 2:
#include <iostream>
#include <string>
#include <array>
using namespace std;
const int RANGO_MAY = 26;
typedef array<bool,RANGO_MAY> TIniciales;
void guardar(const string& s, TIniciales& iniciales) {
    for (int i = 0; i < int(s.size()); i++) {
        iniciales[s[i]-'A'] = true;
    }
}
int main() {
    string primera, pal;
    TIniciales iniciales = {{}};
    cout << "Introduzca un texto terminado con la palabra FIN\n";
    cin >> primera;
    if (primera != "FIN") {
        guardar(primera,iniciales);
        cout << "Las palabras cuya inicial aparece en la primera palabra son:\n";
        cin >> pal;
        while (pal != "FIN") {
            if (iniciales[pal[0]-'A']) {
                cout << pal << " ";
            }
            cin >> pal;
        }
    }
}