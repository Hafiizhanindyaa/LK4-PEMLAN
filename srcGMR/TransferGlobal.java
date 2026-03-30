package srcGMR;

public interface TransferGlobal extends TransaksiDigital, LayananInternasional {
    
    public void lakukanTransferGlobal(String rekeningTujuan, double jumlah, String mataUang);
    
    public String getKonfirmasiTransfer();
    
}
