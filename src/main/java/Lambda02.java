import java.util.*;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        tekBul(4);
        System.out.println();
        kupArtiBir(sayi);

        System.out.println();
        maxElBul(sayi);

        System.out.println();
        structuredMaxElBul(sayi);

        System.out.println();
        ciftKareEnBuyuk(sayi);

        System.out.println();
        toplam(sayi);

        System.out.println();
        carpim(sayi);

        System.out.println();
        minBul(sayi);

        System.out.println();
        bestenBuyukEnKucuk(sayi);

        System.out.println();
        ciftKareSiralama(sayi);
    }
    //Task 1: Functional Programming ile listin cift elemanlarinin karelerini
    //ayni sattirda aralarina bosluk birakarak print edeiniz

    public static void ciftKare (List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).//cift sayilari filtre ettik
                map(t-> t*t).//filtreden sonra baska bir akis olusturdu.
                forEach(Lambda01::yazdir);
    }

    //Task 2 : Functionaol Programming ile lsitin tek elemanlarinin kuplerinin bir fazlasini bosluk birakarak print et.

    public static void kupArtiBir (List<Integer> sayi){
        sayi.stream().filter(Lambda02::tekBul).map(t-> (t*t*t) +1).forEach(Lambda01::yazdir);
    }
    public static boolean tekBul (int a){
        return a%2 != 0;
    }
    //Task 3: Func prog ile listin cif elemanlarinin karekoklerinin ayni sirada yazdiriniz.
    public static void ciftKarekok (List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).//cift sayilari filtre ettik
                map(Math::sqrt).//filtreden sonra baska bir akis olusturdu.
                forEach(t-> System.out.println(t + " "));

    }
    //Task 4 : Listin en buyuk elemanini yazdiriniz.
    public static void maxElBul (List<Integer> sayi){
      Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max);
        System.out.println(maxSayi);

    }
    //Structure yapi ile cozelim
    public static void structuredMaxElBul (List<Integer> sayi){
        int max = Integer.MIN_VALUE;



        for (int i=0; i<sayi.size(); i++){
            if (sayi.get(i)>max){
                max = sayi.get(i);
            }
        }
        System.out.println("max = " + max);

    }
    //Task 5: Listin cif elemanlarinin karelerinin en buyugunu print et.
    public static void ciftKareEnBuyuk (List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));
    }
    //Task 6: Listteki tum elemanlarin toplamini yazdiriniz. Lambda Expression
    public static void toplam (List<Integer> sayi) {
        System.out.println(sayi.stream().reduce(0, (a, b) -> a + b));
    }
    //Tsk 7: Listteki cift elemalarinin toplamini yazdiriniz.
    public static void carpim (List<Integer> sayi) {
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact));
    }
    //Task 8: Listteki elemanlarin en kucugunu print ediniz.
    public static void minBul (List<Integer> sayi){
        System.out.println(sayi.stream().reduce(Math::min));

    }
    public static int minBula (int a,int b){
        return a<b ? a : b;
    }
    //Task 9: Listteki 5'ten buyuk en kucuk tek sayiyi print edin.
    public static void bestenBuyukEnKucuk (List<Integer> sayi) {
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 != 0).reduce(Math::min));
    }
    //Task 10:Listin cift elemanlarinin karelerini kucukten buyuge print et.
    public static void ciftKareSiralama (List<Integer> sayi) {
        sayi.stream().filter(t-> t%2==0).map(t->t*t).sorted().forEach(Lambda01::yazdir);

    }
}
