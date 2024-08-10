package m2k1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Angsa");
        animals.add("Bebek");
        animals.add("Cicak");
        animals.add("Domba");
        animals.add("Elang");
        animals.add("Gajah");

        animals.add("Badak");
        animals.add("Bebek");

        int bebekCount = 0;
        for (String animal : animals) {
            if (animal.equals("Bebek")) {
                bebekCount++;
            }
        }
        System.out.println("Number of 'Bebek' elements: " + bebekCount);

        int bebekIndex = animals.indexOf("Bebek");
        System.out.println("Index of first 'Bebek' element: " + bebekIndex);

        System.out.println("Element at index 0: " + animals.get(0));
        System.out.println("Element at index 2: " + animals.get(2));

        /**
         * animals.remove(0);
         */

        /**
         * animals.set(0, "Ular");
         * animals.add(2, "Itik");
         */

        /**
         * animals.subList(1, 5).clear();
         */

        System.out.println("First element: " + animals.get(0));
        System.out.println("Last element: " + animals.get(animals.size() - 1));

        System.out.println("Number of elements: " + animals.size());

        int badakIndex = animals.indexOf("Badak");
        System.out.println("Index of 'Badak' element: " + badakIndex);
    }
}

/*
Ukuran dinamis: ArrayList dapat bertambah atau berkurang ukurannya saat elemen ditambahkan atau dihapus.
Akses berbasis indeks: Kita dapat mengakses elemen menggunakan indeksnya, yang merupakan nilai integer berbasis nol.
Penyisipan dan penghapusan: Anda dapat menyisipkan atau menghapus elemen di posisi mana pun di ArrayList.
Pencarian dan pengambilan: Anda dapat mencari elemen menggunakan nilai atau indeksnya, dan mengambil elemen menggunakan indeksnya.
 */