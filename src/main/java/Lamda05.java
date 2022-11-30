import java.util.Scanner;
import java.util.stream.IntStream;

public class Lamda05 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a = input.nextInt();
//    int b = input.nextInt();
//        System.out.println(a + "ya kadar olan sayilarin toplami" + sum(a));
//        System.out.println(a + "ya kadar olan sayilarin toplami" + sum1(a));
//        System.out.println(a + "ya kadar olan cift sayilarin toplami" + sumCift(a));
//        System.out.println(xKadarPozitifCiftSayi(a));
//        System.out.println(xKadarPozitifCiftSayi2(a));
//        System.out.println(xKadarTekPozitifTopla(a));
//        ikininKuvvetleri(a);
//        xKuvvetleri(a,b);
        System.out.println(faktoriyel(a));

    }
    //Task 1:Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.
    //Structured
    public static int sum (int a){
        int toplam = 0;
        for (int i = 0; i<=a;i++){
            toplam+=i;

        }
        return toplam;
    }
    public static int sum1 (int a){
        return IntStream.range(1,a+1).sum();
    }
    //Task 2: 1'den x'e kadar cift tamsayilari yoplayan bir program create edeiniz.
    public static int sumCift (int a){
        return IntStream.range(1,a+1).filter(Lambda01::ciftBul).sum();
    }
    //Task 3:Ilk x pozitif cift sayiyi toplayan program create ediniz.
    public static int xKadarPozitifCiftSayi (int a){
        return IntStream.
                rangeClosed(1,2*a).//son deger dahil range belli edilir
                filter(Lambda01::ciftBul).//Cift sayilari veren filtre
                sum();
    }
    public static int xKadarPozitifCiftSayi2 (int a) {
        return IntStream.//integeri bir stream hailen getirir.
                iterate(2,t->t+2).//sonsuz bir sequence, ardisik
                limit(a).//verilen sayi kadar gider sonra durur
                sum();//toplar
    }
    //Task 4: Ilk x pozitifi tek tamsayiyi toplayan programi yapiniz
    public static int xKadarTekPozitifTopla (int a){
        return IntStream.
                iterate(1,t->t+2).
                limit(a).
                sum();
    }
    //Task 5:2'nin ilk a kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininKuvvetleri (int a){
        IntStream.iterate(2,t->t*2).//Iteras
                limit(a).
                forEach(Lambda01::yazdir);
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void xKuvvetleri (int taban,int us){
        IntStream.iterate(taban,t->t*taban).//Iterasyon
                limit(us).
                forEach(Lambda01::yazdir);
    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int faktoriyel (int a){
        return IntStream.rangeClosed(1,a).reduce(1,(t,u)->t*u);
    }
}
