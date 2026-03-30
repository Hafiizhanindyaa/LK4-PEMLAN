package srcGMR;

public final class ProtokolKeamanan {

    public static final String ID_SERVER = "GMR-SECURE-001";

    public static boolean validasiTransaksi(double jumlah) {
        if (jumlah > 0) {
            return true;
        } else {
            return false;
        }
    }
}