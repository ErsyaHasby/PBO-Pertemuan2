package com.tugas;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Makanan> daftarMakanan;
    private ArrayList<Minuman> daftarMinuman;
    private ArrayList<Object> pesanan;
    private Scanner scanner;

    public Menu() {
        daftarMakanan = new ArrayList<>();
        daftarMinuman = new ArrayList<>();
        pesanan = new ArrayList<>();
        scanner = new Scanner(System.in);
        inisialisasiMenu();
    }

    private void inisialisasiMenu() {
        // Daftar Makanan
        daftarMakanan.add(new Makanan("Bakso", 25000));
        daftarMakanan.add(new Makanan("Mie Ayam", 20000));
        daftarMakanan.add(new Makanan("Sate Padang", 35000));
        daftarMakanan.add(new Makanan("Nasi Goreng", 22000));
        daftarMakanan.add(new Makanan("Soto Ayam", 28000));
        daftarMakanan.add(new Makanan("Gado-Gado", 18000));
        daftarMakanan.add(new Makanan("Rendang", 45000));

        // Daftar Minuman
        daftarMinuman.add(new Minuman("Jus Mangga", 12000));
        daftarMinuman.add(new Minuman("Es Teh Manis", 5000));
        daftarMinuman.add(new Minuman("Kopi Hitam", 8000));
        daftarMinuman.add(new Minuman("Air Mineral", 3000));
        daftarMinuman.add(new Minuman("Es Jeruk", 10000));
    }

    public void tampilkanMenu() {
        System.out.println("==== DAFTAR MAKANAN ====");
        for (int i = 0; i < daftarMakanan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMakanan.get(i).getNama() + " - Rp" + daftarMakanan.get(i).getHarga());
        }

        System.out.println("\n==== DAFTAR MINUMAN ====");
        for (int i = 0; i < daftarMinuman.size(); i++) {
            System.out.println((daftarMakanan.size() + i + 1) + ". " + daftarMinuman.get(i).getNama() + " - Rp" + daftarMinuman.get(i).getHarga());
        }
    }

    public void mulaiPemesanan() {
        int pilihan = 0;
        int totalHarga = 0;

        do {
            tampilkanMenu();
            System.out.println("0. Selesai Memesan");
            System.out.print("Pilih menu (masukkan nomor): ");

            try {
                pilihan = scanner.nextInt();
                if (pilihan > 0 && pilihan <= daftarMakanan.size()) {
                    Makanan makananTerpilih = daftarMakanan.get(pilihan - 1);
                    pesanan.add(makananTerpilih);
                    System.out.println(makananTerpilih.getNama() + " berhasil ditambahkan.");
                } else if (pilihan > daftarMakanan.size() && pilihan <= (daftarMakanan.size() + daftarMinuman.size())) {
                    Minuman minumanTerpilih = daftarMinuman.get(pilihan - 1 - daftarMakanan.size());
                    pesanan.add(minumanTerpilih);
                    System.out.println(minumanTerpilih.getNama() + " berhasil ditambahkan.");
                } else if (pilihan != 0) {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid, masukkan angka.");
                scanner.next();
                pilihan = -1;
            }

        } while (pilihan != 0);

        System.out.println("\n==== Rincian Pesanan ====");
        if (pesanan.isEmpty()) {
            System.out.println("Tidak ada item yang dipesan.");
        } else {
            for (Object item : pesanan) {
                if (item instanceof Makanan) {
                    Makanan makanan = (Makanan) item;
                    System.out.println("- " + makanan.getNama() + " (Rp" + makanan.getHarga() + ")");
                    totalHarga += makanan.getHarga();
                } else if (item instanceof Minuman) {
                    Minuman minuman = (Minuman) item;
                    System.out.println("- " + minuman.getNama() + " (Rp" + minuman.getHarga() + ")");
                    totalHarga += minuman.getHarga();
                }
            }
            System.out.println("\nTotal Harga yang Harus Dibayar: Rp" + totalHarga);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Menu menuAplikasi = new Menu();
        menuAplikasi.mulaiPemesanan();
    }
}



