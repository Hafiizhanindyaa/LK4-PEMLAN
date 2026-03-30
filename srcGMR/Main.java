package srcGMR;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RekeningValas rek = new RekeningValas("RV-00123", 500, "USD", "GMRUIDJA");

        System.out.println("=== Smart Banking Ecosystem - Bank GakMauRugi ===");
        System.out.println("Server ID    : " + ProtokolKeamanan.ID_SERVER);
        System.out.println("No. Rekening : " + rek.getNomorRekening());
        System.out.println("Kode SWIFT   : " + rek.getKodeSwift());
        System.out.println("Negara Tujuan: " + rek.getNegaraTujuan());

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Proses Transaksi");
            System.out.println("2. Verifikasi OTP");
            System.out.println("3. Konversi Mata Uang");
            System.out.println("4. Cetak Bukti Transaksi");
            System.out.println("5. Cek Status Transaksi");
            System.out.println("6. Cek Saldo");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jumlah transaksi: ");
                    double jumlah = sc.nextDouble();
                    rek.prosesTransaksi(jumlah);
                    break;

                case 2:
                    System.out.print("Masukkan kode OTP (6 digit): ");
                    String otp = sc.next();
                    rek.verifikasiOTP(otp);
                    System.out.println("Metode Pembayaran: " + rek.getMetodePembayaran());
                    break;

                case 3:
                    System.out.print("Masukkan nilai kurs (contoh: 15000 untuk USD->IDR): ");
                    double kurs = sc.nextDouble();
                    rek.konversiMataUang(kurs);
                    break;

                case 4:
                    rek.cetakBuktiTransaksi();
                    break;

                case 5:
                    System.out.println("Status Transaksi: " + rek.getStatusTransaksi());
                    break;

                case 6:
                    System.out.println("Saldo       : " + rek.getSaldo());
                    System.out.println("Kode SWIFT  : " + rek.getKodeSwift());
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan Bank GakMauRugi!");
                    running = false;
                    break;

                default:
                    System.out.println("Menu tidak tersedia, pilih angka 0-6.");
                    break;
            }
        }

        sc.close();
    }
}