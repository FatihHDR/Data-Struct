package m4k2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {

    private Map<String, String> tabelData;
    private Map<String, String> tabelSesiLogin;

    public void tambahSesiLogin(String email, String password) {
        tabelSesiLogin.put(email, password);
    }

    public DataPraktikan() {
        this.tabelData = new HashMap<>();
        this.tabelSesiLogin = new HashMap<>();
    }

    public boolean login(String email, String password) {
        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            if (email.endsWith("@umm.ac.id")) {
                return true;
            }
        }
        return false;
    }
    public void logout() {
        System.out.println("Keluar dari program");
        System.exit(0);
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

        dataPraktikan.tambahSesiLogin("fatih@umm.ac.id", "password123");
        dataPraktikan.tambahSesiLogin("john@umm.ac.id", "password456");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Keluar");

            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Masukkan Password: ");
                    String password = scanner.nextLine();
                    if (dataPraktikan.login(email, password)) {
                        System.out.println("Login berhasil!");
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
                            System.out.println("9. Logout");

                            System.out.print("Pilih menu: ");
                            int submenu = scanner.nextInt();
                            scanner.nextLine();

                            switch (submenu) {
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
                                    dataPraktikan.logout();
                                    break;
                                default:
                                    System.out.println("Menu tidak tersedia");
                            }
                        }
                    } else {
                        System.out.println("Gagal Login");
                    }
                    break;
                case 2:
                    System.out.println("Keluar dari program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }
}