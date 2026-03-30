package srcGMR;

public class RekeningValas extends Rekening implements TransferGlobal {

    private String mataUang;
    private String negaraTujuan;
    private String statusTransaksi;
    private String kodeSwift;
    private String metodePembayaran;

    public RekeningValas(String nomorRekening, double saldo, String mataUang, String kodeSwift) {
        super(nomorRekening, saldo);         
        this.mataUang     = mataUang;
        this.kodeSwift    = kodeSwift;
        this.negaraTujuan = "Indonesia";     
        this.statusTransaksi = "IDLE";
        this.metodePembayaran = "SWIFT Transfer";
    }

    @Override
    public void prosesTransaksi(double jumlah) {
        if (ProtokolKeamanan.validasiTransaksi(jumlah)) {
            tarikSaldo(jumlah);   
            statusTransaksi = "BERHASIL";
            System.out.println("[" + ProtokolKeamanan.ID_SERVER + "] Transaksi " 
                + jumlah + " " + mataUang + " berhasil diproses.");
        } else {
            statusTransaksi = "GAGAL";
            System.out.println("Transaksi gagal: jumlah tidak valid.");
        }
    }

    @Override
    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    @Override
    public void cetakBuktiTransaksi() {
        System.out.println("====== BUKTI TRANSAKSI ======");
        System.out.println("Server       : " + ProtokolKeamanan.ID_SERVER);
        System.out.println("No. Rekening : " + nomorRekening);   
        System.out.println("Saldo        : " + saldo + " " + mataUang);
        System.out.println("Status       : " + statusTransaksi);
        System.out.println("SWIFT        : " + kodeSwift);
        System.out.println("Negara Tujuan: " + negaraTujuan);
        System.out.println("=============================");
    }

    @Override
    public void verifikasiOTP(String kodeOTP) {
        if (kodeOTP != null && kodeOTP.length() == 6) {
            statusTransaksi = "OTP_VALID";
            System.out.println("OTP " + kodeOTP + " terverifikasi untuk rekening " + nomorRekening);
        } else {
            statusTransaksi = "OTP_GAGAL";
            System.out.println("OTP tidak valid! Harus 6 digit.");
        }
    }

    @Override
    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    @Override
    public void konversiMataUang(double kurs) {
        double saldoTerkonversi = saldo * kurs;
        System.out.println("Konversi: " + saldo + " " + mataUang 
            + " x " + kurs + " = " + saldoTerkonversi + " IDR");
    }

    @Override
    public String getNegaraTujuan() {
        return negaraTujuan;
    }

    @Override
    public String getKodeSwift() {
        return kodeSwift;
    }
}