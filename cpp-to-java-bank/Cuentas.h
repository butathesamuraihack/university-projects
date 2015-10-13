class Cuenta {
private:
  int Numero;
  double Saldo;
public:
  Cuenta(int N, double S) { Numero = N; Saldo = S; }
  Cuenta(int N) { Numero = N; Saldo = 0.0; }
  Cuenta() { Numero = 0; Saldo = 0.0; }
  int getNumero() { return Numero; }
  double getSaldo() { return Saldo; }
  void putNumero(int num) { Numero = num; }
  void putSaldo(double sal) { Saldo = sal; }
  virtual void depositar(double monto) { }
  virtual void retirar(double monto) { }
};

class Ahorro : public Cuenta {
private:
  float Tasa;
public:
  Ahorro(int N, double S, float T);
  Ahorro(int N, double S);
  Ahorro(int N);
  Ahorro();
  float getTasa() { return Tasa; }
  void putTasa(float tas) { Tasa = tas; }
  void depositar(double monto);
  void retirar(double monto);
};

Ahorro :: Ahorro(int N, double S, float T) {
  putNumero(N);
  putSaldo(S);
  Tasa = T;
}

Ahorro :: Ahorro(int N, double S) {
  putNumero(N);
  putSaldo(S);
  Tasa = 0.0;
}

Ahorro :: Ahorro(int N) {
  putNumero(N);
  putSaldo(0.0);
  Tasa = 0.0;
}

Ahorro :: Ahorro() {
  putNumero(0);
  putSaldo(0.0);
  Tasa = 0.0;
}

void Ahorro :: depositar(double monto) {
  putSaldo(getSaldo() + monto);
  if (getSaldo() > 1000) putSaldo(getSaldo() * (1 + Tasa));
}

void Ahorro :: retirar(double monto) {
  if (getSaldo() >= monto) putSaldo(getSaldo() - monto);
}

class Corriente : public Cuenta {
private:
  float Minimo;
public:
  Corriente(int N, double S, float M);
  Corriente(int N, double S);
  Corriente(int N);
  Corriente();
  float getMinimo() { return Minimo; }
  void putMinimo(float min) { Minimo = min; }
  void depositar(double monto);
  void retirar(double monto);
};

void Corriente :: depositar(double monto) {
  putSaldo(getSaldo() + monto);
}

void Corriente :: retirar(double monto) {
  if (getSaldo() >= monto) putSaldo(getSaldo() - monto);
  if (getSaldo() < Minimo) putSaldo(getSaldo() - 10);
}

Corriente :: Corriente(int N, double S, float M) {
  putNumero(N);
  putSaldo(S);
  Minimo = M;
}

Corriente :: Corriente(int N, double S) {
  putNumero(N);
  putSaldo(S);
  Minimo = 0.0;
}

Corriente :: Corriente(int N) {
  putNumero(N);
  putSaldo(0.0);
  Minimo = 0.0;
}

Corriente :: Corriente() {
  putNumero(0);
  putSaldo(0.0);
  Minimo = 0.0;
}


