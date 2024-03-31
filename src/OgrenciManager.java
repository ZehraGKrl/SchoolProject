

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgrenciManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogrenciMenu() throws InterruptedException {

        boolean exit = false;


        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================== OGRENCI MENU =================\n" +
                            "\t   1- Ogrenci Listesi Yazdir\n" +
                            "\t   2- Soyisimden Ogrenci Bulma\n" +
                            "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

            String secim = scan.nextLine();

            switch (secim) {


                case "1":
                    ogrenciListeYazdir();
                    break;

                case "2":
                    soyisimdenOgrenciBulma();
                    break;

                case "3":
                    sinifVeSubeIleOgrenciBulma();
                    break;

                case "4":
                    ogrenciEkle();
                    break;

                case "5":
                    tcNoIleOgrenciSilme();
                    break;

                case "a":
                    Helper.anaMenu();
                    break;

                case "q":
                    Helper.projeDurdur();
                    return;

                default:
                    System.out.println("Lutfen gecerli tercih yapiniz:");
                    break;
            }


        } while (!exit);


    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String silinecekValue = ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        System.out.print(silinecekOgrenci + "Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }

    }


    private static void ogrenciEkle() {

        System.out.print("Öğrencinin TcNo'sunu giriniz :");
        String ogrTcno = scan.nextLine();

        System.out.print("Öğrencinin ismini giriniz : ");
        String ogrIsim = scan.nextLine();

        System.out.print("Öğrencinin soyadını giriniz :");
        String ogrsoyAd = scan.nextLine();

        System.out.print("Öğrencinin doğum yılını giriniz :");
        String ogrDogumyili = scan.nextLine();

        System.out.print("Öğrencinin okul numarasını giriniz :");
        String ogrOkulNo = scan.nextLine();

        System.out.print("Öğrencinin sınıfını giriniz :");
        String ogrSinifi = scan.nextLine();

        System.out.print("Öğrencinin şubesini giriniz :");
        String ogrSube = scan.nextLine();


        ogrenciMap.put(ogrTcno, ogrIsim + ", " + ogrsoyAd + ", " + ogrDogumyili + ", " + ogrOkulNo + ", " + ogrSinifi + ", " + ogrSube);


    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {

        System.out.print("Öğrenci sınıfını giriniz : ");
        String sinif = scan.nextLine();

        System.out.print("Öğrenci şubesini giriniz :");
        String sube = scan.nextLine();

        System.out.print(sinif + " " + sube + " Öğrenciler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet1 = ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYADI ILE ÖĞRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Okul No, Sınıf, Şube");

        for (Map.Entry<String, String> each1 : ogrenciEntrySet1) {
            String eachkey1 = each1.getKey();
            String eachValue1 = each1.getValue();

            String[] eachValuar = eachValue1.split(", ");
            if (sinif.equalsIgnoreCase(eachValuar[4]) && sube.equalsIgnoreCase(eachValuar[5])){
                System.out.println("\n" + eachkey1 + " : " + eachValue1 + " | "); }
        }

    }

    private static void soyisimdenOgrenciBulma() throws InterruptedException {

        System.out.println("Aradiginiz Öğrencinin Soyadını Giriniz = ");
        String istenenSoyad = scan.nextLine();

        System.out.print(istenenSoyad + " Öğrenciler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogrenciEntrySet = ogrenciMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYADI ILE ÖĞRENCİ ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Okul No, Sınıf, Şube");


        for (Map.Entry<String, String> each : ogrenciEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenSoyad.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println("\n" + eachKey + " : " + eachValue + " | ");
            }
        }
    }


    private static void ogrenciListeYazdir() throws InterruptedException {

        System.out.println("***** ÖĞRENCİLER LİSTESİ *****");

        for (Map.Entry<String, String> ogrenciler : ogrenciMap.entrySet())
            System.out.println(ogrenciler.getKey() + " " + ogrenciler.getValue());


    }
}
