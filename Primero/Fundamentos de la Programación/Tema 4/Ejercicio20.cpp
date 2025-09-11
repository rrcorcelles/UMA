#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX = 20;
struct TFecha {
    int dia, mes, anyo;
};
struct TProducto {
    int codigo;
    string nombre;
    double precio;
    TFecha caducidad;
};
typedef array<TProducto,MAX> TArray;
struct TFarmacia {
    TArray productos;
    int nProd;
};
void inicializarFarmacia(TFarmacia& f) {
    f.nProd = 0;
}
void leerProducto(TProducto& p) {
    cout << "Datos del producto\n";
    cout << "Codigo: ";
    cin >> p.codigo;
    cout << "Nombre: ";
    cin >> p.nombre;
    cout << "Precio: ";
    cin >> p.precio;
    cout << "Fecha de caducidad: ";
    cin >> p.caducidad.dia >> p.caducidad.mes >> p.caducidad.anyo;
}
void escribirProducto(const TProducto& p) {
    cout << "Datos del producto\n";
    cout << "Codigo: " << p.codigo << endl;
    cout << "Nombre: " << p.nombre << endl;
    cout << "Precio: " << p.precio << endl;
    cout << "Fecha de caducidad: ";
    cout << p.caducidad.dia << "/";
    cout << p.caducidad.mes << "/";
    cout << p.caducidad.anyo << endl;
}
void insertarProducto(TFarmacia& f, const TProducto& p) {
    if (f.nProd < MAX) {
        f.productos[f.nProd] = p;
        f.nProd++;
    }
}
void buscarProductoCodigo(const TFarmacia& f, int codigo, bool& encontrado, TProducto& p) {
    int i = 0;
    while ((i < f.nProd) && (f.productos[i].codigo != codigo)) {
        i++;
    }
    encontrado = i < f.nProd;
    if (encontrado) {
        p = f.productos[i];
    }
}
void buscarProductoNombre(const TFarmacia& f, string nombre, bool& encontrado, TProducto& p) {
    int i = 0;
    while ((i < f.nProd) && (f.productos[i].nombre != nombre)) {
        i++;
    }
    encontrado = i < f.nProd;
    if (encontrado) {
        p = f.productos[i];
    }
}
void borrarProducto(TFarmacia& f, int codigo) {
    int i = 0;
    while ((i < f.nProd) && (f.productos[i].codigo != codigo)) {
        i++;
    }
    if (i < f.nProd) { // encontrado
        f.productos[i] = f.productos[f.nProd-1];
        f.nProd--;
    }
}
void listarFarmacia(const TFarmacia& f) {
    cout << "La farmacia almacena los siguientes productos:\n";
    for (int i = 0; i < f.nProd; i++) {
        escribirProducto(f.productos[i]);
        cout << endl << endl;
    }
}
int main() {
    // ....
    return 0;
}