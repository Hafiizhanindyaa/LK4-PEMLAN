package srcGMR;

public class Rekening {
    protected String nomorRekening;
    protected double saldo;

    public Rekening(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
    }

    public void tarikSaldo(double jumlah) {
        saldo -= jumlah;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }
}