import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<MataKuliah> daftarMataKuliah;
    private ArrayList<MataKuliah> mataKuliahDiambil;
    private Scanner scanner;

    public Main() {
        daftarMataKuliah = new ArrayList<>();
        mataKuliahDiambil = new ArrayList<>();
        scanner = new Scanner(System.in);
        inisialisasiMataKuliah();
    }

    private void inisialisasiMataKuliah() {
        // Contoh Mata Kuliah dengan SKS
        // Sekarang Anda bisa menambahkan SKS sebagai parameter ketiga
        daftarMataKuliah.add(new MataKuliah("PBO", "Pa Ardian", 3));
        daftarMataKuliah.add(new MataKuliah("Basis Data", "Pa Ade Chandra", 4));
        daftarMataKuliah.add(new MataKuliah("Aljabar Linear", "Pa Rizqi", 2));
        daftarMataKuliah.add(new MataKuliah("Proyek", "Pa Lukman", 3));
        daftarMataKuliah.add(new MataKuliah("PRPL", "Bu Rahil", 4));
        daftarMataKuliah.add(new MataKuliah("Matematika Diskrit", "Pa ST", 2));
        daftarMataKuliah.add(new MataKuliah("Komputer Grafik", "Pa Yudi", 3));
    }


    public void tampilkanDaftarMataKuliah() {
        System.out.println("==== DAFTAR MATA KULIAH TERSEDIA ====");
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            System.out.println((i + 1) + ". " + daftarMataKuliah.get(i).getNamaMataKuliah() + " - Dosen: " + daftarMataKuliah.get(i).getDosen() + " - SKS: " + daftarMataKuliah.get(i).getSks());
        }
    }

    public void mulaiPendaftaran() {
        int pilihan = 0;
        int totalSks = 0;

        do {
            tampilkanDaftarMataKuliah();
            System.out.println("0. Selesai Memilih Mata Kuliah");
            System.out.print("Pilih mata kuliah (masukkan nomor): ");

            try {
                pilihan = scanner.nextInt();
                if (pilihan > 0 && pilihan <= daftarMataKuliah.size()) {
                    MataKuliah mkTerpilih = daftarMataKuliah.get(pilihan - 1);
                    mataKuliahDiambil.add(mkTerpilih);
                    System.out.println(mkTerpilih.getNamaMataKuliah() + " berhasil ditambahkan.");
                } else if (pilihan != 0) {
                    System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid, masukkan angka.");
                scanner.next();
                pilihan = -1;
            }

        } while (pilihan != 0);

        System.out.println("\n==== Rincian Mata Kuliah yang Diambil ====");
        if (mataKuliahDiambil.isEmpty()) {
            System.out.println("Tidak ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mk : mataKuliahDiambil) {
                System.out.println("- " + mk.getNamaMataKuliah() + " (" + mk.getSks() + " SKS)");
                totalSks += mk.getSks();
            }
            System.out.println("\nTotal SKS yang Diambil: " + totalSks + " SKS");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Main sistemPendaftaran = new Main();
        sistemPendaftaran.mulaiPendaftaran();
    }
}


