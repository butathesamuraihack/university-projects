#include <iostream>
#include <string>
#include "cuentas.h"

using namespace std;


void Transferir(Cuenta *M, Cuenta *N, double monto);
void MostrarCuenta(Cuenta T);
void MostrarTasa(Ahorro T);
void MostrarMinimo(Corriente T);

Ahorro A(1010, 1000.0), B(2020);
Corriente C(3030, 3000.0, 100.0), D(4040, 4000.0);

int main() {
  A.putTasa(0.10);
  B.putSaldo(2000);
  B.putTasa(0.12);

  cout<<"Cuenta de ahorro A:\n"<<endl;
  MostrarCuenta(A);
  MostrarTasa(A);
  cout<<"Cuenta de ahorro B:\n"<<endl;
  MostrarCuenta(B);
  MostrarTasa(B);

  cout<<"\n\nSe transfieren Bs. 250 de A a B:\n"<<endl;
  Transferir(&A, &B, 250);
  MostrarCuenta(A);
  MostrarCuenta(B);

  D.putMinimo(50.0);
  cout<<"Cuenta corriente C:\n"<<endl;
  MostrarCuenta(C);
  MostrarMinimo(C);
  cout<<"Cuenta corriente D:\n"<<endl;
  MostrarCuenta(D);
  MostrarMinimo(D);

  cout<<"\n\nSe tranfiere Bs. 500 de D a A:\n"<<endl;
  Transferir(&D, &A, 500);
  MostrarCuenta(D);
  cout<<"\n\n"<<endl;
  MostrarCuenta(A);
  return 0;
}

// Función polimórfica Transferir
void Transferir(Cuenta *M, Cuenta *N, double monto) {
  (*M).retirar(monto);
  (*N).depositar(monto);
}

void MostrarCuenta(Cuenta T) {
	cout<<"Numero......: "<< T.getNumero()<<endl;
	cout<<"Saldo.......: "<< T.getSaldo()<<endl;
}

void MostrarTasa(Ahorro T) {
	cout<<"Tasa .......: "<<T.getTasa()<<endl;
}

void MostrarMinimo(Corriente T) {
	cout<<"Saldo Minimo.....: "<<T.getMinimo()<<endl;
}
