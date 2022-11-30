import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice02 {

    //S1: List elemanlarini ilk harf buyuk gerisi kucuk listeleyelim.
    public static List<String> ilkHarfBykGerisiKck (List<String> list) {
    return     list.
            stream().
            map(t->
                    t.substring(0,1).toUpperCase() + //Ilk harf buyuk yazdirmak.
                    t.substring(1).toLowerCase()).//Geri kalanini kucuk yazdirmak.
            collect(Collectors.toList());//Tekrar bi liste dondurdurk.
    }
    //S2: ilk harfi e veya c olanlari listele
    public static List<String> eVeyaCOlanlarList (List<String> list) {
      return  list.stream().
              filter(t->t.toLowerCase().startsWith("e") || t.startsWith("c")).//Hepsini kucuge cevirip icindekileri kontrol ettik
              collect(Collectors.toList());
    }
    //S3: tum stringleri basina ve sonuna yildiz ekleyerek yazdirilam
    public static void basinaSonunaYildiz (List<String> list) {
       list.stream().
               map(t->"*"+ t + "*").
               forEach(Lambda01::yazdir);
    }
    //S4:icinde e harfi olanlardan bir list olusturunuz
    public static List<String> eHarfiOlanlar (List<String> list){
       return list.
               stream().
               filter(t->t.contains("e")).
               collect(Collectors.toList());
    }
    //S5:Tum "l" silelim
    public static void lSilme (List<String> list){
        list.stream().
                map(t->t.replaceAll("l","")).//Replace ile l yerine bosluk yazdik.
                forEach(Lambda01::yazdir);
    }
    //S6: List elemanlarinin 2. harfe gore siralayin ilk 5 elemani char sayiyisi en buyuk print
    public static void printul (List<String> list) {
        list.stream().
                sorted(Comparator.comparing(t->t.charAt(1))).//Ikinci harfe gore sort ettik
                limit(5).//Ilk 5 elemani aldik
                sorted(Comparator.comparing(String::length).//Tekrar uzunluklarina gore siraladik en buyuk istedigi icin tersten
                        reversed()).
                findFirst();//Ilk elemani aldi akistaki
    }











    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");


    }

}
