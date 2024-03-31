
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {

    static Scanner scan = new Scanner(System.in);

    public static void ogretmenMenu() throws InterruptedException {

        boolean exit = false;


        do {


            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= OGRETMEN MENU =================\n" +
                            "\n" +
                            "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Ogretmen Bulma\n" +
                            "\t   3- Branstan Ogretmen Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");


            String secim = scan.nextLine();

            switch (secim) {


                case "1":
                    ogretmenListesiYazdir();
                    break;

                case "2":
                    soyisimdenOgretmenBulma();
                    break;

                case "3":
                    branstanOgretmenBulma();
                    break;

                case "4":
                    ogretmenEkleme();
                    break;

                case "5":
                    tcNoIleOgretmenSil();
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


    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        System.out.print(silinecekOgretmen + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }


        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz Tc numarasi ile ogretmen bulunamadi");
        }

    }


    public static void ogretmenEkleme() {
        System.out.print("Öğretmenin TcNo'sunu giriniz :");
        String ogtTcno = scan.nextLine();

        System.out.print("Öğretmenin ismini giriniz : ");
        String ogtIsim = scan.nextLine();

        System.out.print("Öğretmenin soyadını giriniz :");
        String soyAd = scan.nextLine();

        System.out.print("Öğretmenin doğum yılını giriniz :");
        String ogrDogumyili = scan.nextLine();

        System.out.print("Öğretmenin branşını giriniz :");
        String ogtBrans = scan.nextLine();

        ogretmenlerMap.put(ogtTcno, ogtIsim+", " + soyAd+", " + ogrDogumyili+", " + ogtBrans);

    }


    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin Bransini Giriniz:");
        String istenenBrans = scan.nextLine();

        System.out.print(istenenBrans + " Ogretmenleri Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");


        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | \n");
            }
        }
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {

        System.out.println("Aradiginiz Öğretmen'nin Soyadını Giriniz = ");
        String istenenSoyad = scan.nextLine();

        System.out.print(istenenSoyad + " Öğretmenler Listeleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============SOYADI ILE ÖĞRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Branş");


        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenSoyad.equalsIgnoreCase(eachValuarr[1])) {
                System.out.println("\n" + eachKey + " : " + eachValue + " | ");
            }
        }

    }



    public static void ogretmenListesiYazdir() throws InterruptedException {

        System.out.println("***** ÖĞRETMEN LİSTESİ ***** ");

        for (Map.Entry<String, String> ogretmenlerListesi : ogretmenlerMap.entrySet())
            System.out.println(ogretmenlerListesi.getKey() + " " + ogretmenlerListesi.getValue());


    }
}



