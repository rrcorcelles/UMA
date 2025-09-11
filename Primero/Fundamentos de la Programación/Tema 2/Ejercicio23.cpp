#include <iostream>
using namespace std;
int main(){
    int n,ant2,ant1,res;
    do {
        cout << "Introduzca n (> 0): ";
        cin >> n;
    } while (n <= 0);
    if (n <= 2) {
        res = n - 1;
    } else {
        ant2 = 0;
        ant1 = 1;
        for (int cont = 3; cont <= n; cont++) {
            res = ant2 + ant1;
            ant2 = ant1;
            ant1 = res;
        }
    }
    cout << "El " << n << "-esimo numero de Fibonacci es: " << res << endl;
    return 0;
}