import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    //Task 1: List elemanlarini alfabetik buyuk harf ve tekrarsiz print edeiniz.
    public static void alfBykTekrarsiz (List<String> menu){
        menu.stream().map(t-> t.toUpperCase()).sorted().distinct().forEach(t-> System.out.println(t + " "));
    }
    //Task 2: List elemanlarinin character sayisini ters sirali olarak tekrarsiz olarak print ediniz.
    public static void charSayiTersTekrarsiz (List<String> menu){
        menu.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir);
    }
    //Task 3: List elemanlarinin char sayisina gore kckten buyk gore print edeiniz.
    public static void charSayiKckBykYazdir (List<String> menu) {
        menu.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Lambda01::yazdir);
    }

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    //Task 4: List elemanlarinin hepsinin karakter sayisinin 7 ve 7"den az olma durumunu kontrol ediniz.
    public static void harfSayisi7DenAz (List<String> menu) {
        String s = menu.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harfden olusuyor" : "list elemanlari 7 harfden buyuk.";
        System.out.println(s);

    }


    //Task 5: List lemanlarinin hepsinin w ile baslamasini noneMatch ile kontrol ediniz.
    public static void wIleBaslayanControl (List<String> menu) {
        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? "W ile yemek ismi olmaz" : "W ile yemek ismi basladi");
    }
    //Task 6: List eleamnalarinin x ile biten en az bur elemani var mi kontrol ediniz
    public static void xIleBitenElKontrol(List<String> menu) {
        System.out.println(menu.stream().anyMatch(t -> t.endsWith("x")) ? "masallah" : "x ile yemek biter mi hic");
    }
    //Task 7: List Karakter sayisi en buyuk elemani yazdiriniz
    public static void charSayEnbykEl (List<String> menu){
       Stream<String> sonIsim = menu.stream().sorted(Comparator.comparing(t-> t.toString().length()).reversed()).limit(1);
        System.out.println(Arrays.toString(sonIsim.toArray()));//Stream akisini Arraya cevirdik yoksa reference adresi ciktisi aliyoruz.

    }
    //Task 8: List elemanlarini son harfine gore siralayip ilk eleman harci kalan elemanlari pront edinicz
    public static void ilkElemanHarcSiraliPrint (List<String> menu) {
        Stream<String> hasan = menu.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).skip(1);
        System.out.println(Arrays.toString(hasan.toArray()));
    }


    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "guvec", "kokerec", "kusleme", "kunefe","arabAsi", "waffle", "guvec"));

        charSayiTersTekrarsiz(menu);
        System.out.println();
        charSayiTersTekrarsiz(menu);
        System.out.println();
        charSayiKckBykYazdir(menu);
        System.out.println();
        harfSayisi7DenAz(menu);
        System.out.println();
        wIleBaslayanControl(menu);
        System.out.println();
        xIleBitenElKontrol(menu);
        System.out.println();
        charSayEnbykEl(menu);
        System.out.println();
        ilkElemanHarcSiraliPrint(menu);



    }

 }
