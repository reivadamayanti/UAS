package MateriUas;
import java.util.Scanner;

public class KafeOrderSoal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array Data menu makanan dan harganya
        String[] menu = {"Nasi Goreng", 
                         "Mie Goreng", 
                         "Roti Bakar", 
                         "Kentang Goreng", 
                         "Teh Tarik", 
                         "Cappucino", 
                         "Chocolate Ice"};
        int[] harga = {20000, 15000, 12000, 10000, 8000, 20000, 25000};

        
        int[] jumlahPesanan = new int[menu.length];  // Array untuk menyimpan jumlah pesanan setiap menu
        int pilihan;

        System.out.println("=== Selamat Datang di Kafe ===");
        

        do { // bisa menjalankan perulangan berulangkali - kali sampai kita memilih untuk berhenti
            // Menu Utama
            System.out.println("\nPilih Menu Utama berikut:");
            System.out.println("1. Tambah Pesanan"); 
            System.out.println("2. Lihat Daftar Pesanan");
            System.out.println("3. Hitung Total Biaya");
            System.out.println("4. Selesai");


            System.out.print("Masukkan pilihan Anda: ");
            pilihan = input.nextInt();


            switch (pilihan) {
                case 1:
                // Lihat Daftar Menu
                System.out.println("\n=== DAFTAR MENU ===");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println((i + 1) + ". " + menu[i] + " - Rp" + harga[i]);
                    }
                    System.out.print("Masukkan nomor menu yang ingin dipesan: ");
                    int nomorMenu = input.nextInt();
                    if (nomorMenu < 1 || nomorMenu > menu.length) {
                        System.out.println("Menu tidak valid!");
                    } else {
                        System.out.print("Masukkan jumlah pesanan: ");
                        int jumlah = input.nextInt();
                        System.out.println(" ");
                        jumlahPesanan[nomorMenu - 1] += jumlah;
                        System.out.println(jumlah + " " + menu[nomorMenu - 1] + " berhasil ditambahkan ke pesanan.");
                    }
                    break;
                case 2:
                    // Lihat Daftar Pesanan
                    System.out.println("\n=== Daftar Pesanan ===");
                    boolean Pesanan = false;
                    for (int i = 0; i < menu.length; i++) {
                        if (jumlahPesanan[i] > 0) {
                            System.out.println(menu[i] + " x " + jumlahPesanan[i]);
                            Pesanan = true;
                        }
                    }
                    if (!Pesanan) {
                        System.out.println("Belum ada pesanan.");
                    }
                    break;

                case 3:
                    // Hitung Total Biaya
                    int totalBiaya = 0;
                    System.out.println("\n=== Total Biaya ===");
                    for (int i = 0; i < menu.length; i++) {
                        if (jumlahPesanan[i] > 0) {
                            int biaya = jumlahPesanan[i] * harga[i];
                            System.out.println(menu[i] + " x " + jumlahPesanan[i] + " = Rp" + biaya);
                            totalBiaya += biaya;
                        }
                    }
                    System.out.println("Total Biaya: Rp" + totalBiaya);

                    break;

                case 4:
                    // Keluar dari pemograman
                    System.out.println("\nTerima kasih! Selamat tinggal.");
                    System.out.println(" ");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while(pilihan != 4);

        input.close();
    }
}