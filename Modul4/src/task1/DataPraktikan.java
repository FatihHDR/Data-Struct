package m4k1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {
    private Map<String, String> tabelData;

    public DataPraktikan() {
        this.tabelData = new HashMap<>();
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (!tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        }
        return false;
    }

    public void tampil() {
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void listNimPraktikan() {
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }

    public void listNamaAsisten() {
        for (String nama : tabelData.values()) {
            System.out.println(nama);
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            return true;
        }
        return false;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
        }
    }

    // Optional: search by namaAsisten
    public void searchNamaAsisten(String namaAsisten) {
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        DataPraktikan dataPraktikan = new DataPraktikan();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. List NIM Praktikan");
            System.out.println("4. List Nama Asisten");
            System.out.println("5. Total Email");
            System.out.println("6. Hapus Data");
            System.out.println("7. Edit Data");
            System.out.println("8. Search Nama Asisten");
            System.out.println("9. Keluar");

            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (menu) {
                case 1:
                    System.out.print("Masukkan NIM Praktikan: ");
                    String nimPraktikan = scanner.nextLine();
                    System.out.print("Masukkan Nama Asisten: ");
                    String namaAsisten = scanner.nextLine();
                    if (dataPraktikan.tambahData(nimPraktikan, namaAsisten)) {
                        System.out.println("Data berhasil ditambahkan!");
                    } else {
                        System.out.println("Data gagal ditambahkan!");
                    }
                    break;
                case 2:
                    dataPraktikan.tampil();
                    break;
                case 3:
                    dataPraktikan.listNimPraktikan();
                    break;
                case 4:
                    dataPraktikan.listNamaAsisten();
                    break;
                case 5:
                    System.out.println("Total Email: " + dataPraktikan.totalEmail());
                    break;
                case 6:
                    System.out.print("Masukkan NIM Praktikan: ");
                    nimPraktikan = scanner.nextLine();
                    System.out.print("Masukkan Nama Asisten: ");
                    namaAsisten = scanner.nextLine();
                    if (dataPraktikan.hapusData(nimPraktikan, namaAsisten)) {
                        System.out.println("Data berhasil dihapus!");
                    } else {
                        System.out.println("Data gagal dihapus!");
                    }
                    break;
                case 7:
                    System.out.print("Masukkan NIM Praktikan: ");
                    nimPraktikan = scanner.nextLine();
                    System.out.print("Masukkan Nama Asisten: ");
                    namaAsisten = scanner.nextLine();
                    dataPraktikan.editData(nimPraktikan, namaAsisten);
                    System.out.println("Data berhasil diedit!");
                    break;
                case 8:
                    System.out.print("Masukkan Nama Asisten: ");
                    namaAsisten = scanner.nextLine();
                    dataPraktikan.searchNamaAsisten(namaAsisten);
                    break;
                case 9:
                    System.out.println("Keluar dari program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }
}