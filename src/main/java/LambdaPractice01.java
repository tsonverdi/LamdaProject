import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice01 {


        public static void main(String[] args) {

            List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

            hepsiniYazdir(list);
            System.out.println();
            negatifYazdir(list);
            System.out.println();
            pozitifYazdir(list);
            System.out.println();
            pozVeCift(list);
            System.out.println();
            pozVeyaCiftYaz(list);
            System.out.println();
            siralama(list);
            System.out.println();
            System.out.println(pozKup5List(list));
            System.out.println();
            System.out.println(pozKareSon5DegilList(list));
            System.out.println();
            System.out.println(toplam(list));
            System.out.println(elToplamReference(list));

        }

        // S1:listi aralarinda bosluk birakarak yazdiriniz

        public static void hepsiniYazdir(List<Integer> l) {

            l.stream().forEach(t->System.out.print(t+" "));
        }
        //S2: Listi Sadece negatif olanlari yazdir.

        public static void negatifYazdir (List<Integer> l){
            l.stream().filter(t-> t<0).forEach(System.out::print);

        }

        //S3: Pozitif olanlardan yeni bir liste olustur.
        public static void pozitifYazdir (List<Integer> l){
            l.stream().filter(t-> t>0).forEach(t-> System.out.print(t + " "));
        }

        public static void pozVeCift (List<Integer> l) {
            l.stream().filter(t-> t>0 && t%2==0).forEach(t-> System.out.print(t + " "));
        }
        public static void pozVeyaCiftYaz (List<Integer> l){
            l.stream().filter(t-> t%2==0 || t>0).forEach(t-> System.out.print(t + " "));
        }

        public static void kareYazdir (List<Integer> l) {
            l.stream().map(t-> t*t).forEach(t-> System.out.println(t + " "));
        }
        //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım

        public static void ciftKup (List<Integer>l){
            l.stream().filter(Lambda01::ciftBul).map(t->t*t*t).forEach(t-> System.out.println(t + " "));
        }
        //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım

        public static void tekrarsizPrint (List<Integer>l){
            l.stream().map(t->t*t).distinct().forEach(t-> System.out.println(t + " "));
        }
        //S9: listin elemanlarini kucukten buyuge siralayalim.

        public static void siralama (List<Integer>l) {
            l.stream().sorted().forEach(t-> System.out.print(t + " "));
        }
        //S10: listin elemanlarini buyukten kucuge siralayalim.
        public static void TersSiralama (List<Integer>l) {
            l.stream().sorted().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t + " "));
        }
        // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
        public static List<Integer> pozKup5List (List<Integer>l){
            return l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10 ==5).collect(Collectors.toList());

        }
        //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
        public static List<Integer> pozKareSon5DegilList (List<Integer>l) {
            List<Integer> list = l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10 !=5).collect(Collectors.toList());
            return list;
         }
        // S13 :list elemanlarini toplamini bulalim
        public static int toplam (List<Integer>l) {
            int i = l.stream().reduce(0,(a,b)->a+b);
            return i;
        }
        public static int elToplamReference (List<Integer>l){
            int i = l.stream().reduce(0,Math::addExact);
            return i;
        }
}

