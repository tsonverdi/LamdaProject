import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/



    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        //Task Structed programming kullanarak list elemanlarini ayni satirda aralarin bosluk olacak sekilde print ediniz.

        printingElStructured(sayi);

        //TASK 2 : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

        System.out.println();

        printingElFunctional(sayi);

        System.out.println();

        printingElFunctional1(sayi);

        System.out.println();

        printingElFunctional2(sayi);

        //TASK : functional programming ile list elemanlarinin cift olanlarinin cift olanlarini ayni satirda print et.

        System.out.println();

        printCiftElFunctional(sayi);

        //TASK : Structured programming ile list elemanlarinin cift olanlarinin cift olanlarini ayni satirda print et.

        System.out.println();

        printingElStructured(sayi);

        System.out.println();

        printCiftOtuzDorttenKucElFunctional(sayi);

        System.out.println();

        printCiftVeyaOtuzDorttenBuyElFunctional(sayi);

        System.out.println();

        printCiftElFunctional7(sayi);
    }
    public static void printingElStructured (List a){
        for (Object w: a
        ) {
            System.out.print(w + " ");

        }
    }
    public static void printingElFunctional(List<Integer> sayi){
        sayi.
                stream().
                forEach((t) -> System.out.print(t + " "));//Lambda expression
    }
    public static void printingElFunctional1(List<Integer> sayi){
        sayi.
                stream().
                forEach(System.out::print);//Lambda expression
    }
    //Kendimiz bir method olusturalim
    public static void yazdir (int a){
        System.out.print(a + " ");
    }
    public static void yazdir (String a){
        System.out.print(a + " ");
    }
    public static void printingElFunctional2(List<Integer> sayi){
        sayi.
                stream().
                forEach(Lambda01::yazdir);//Lambda expression
    }

    public static void printCiftElFunctional (List<Integer> sayi){
        sayi.stream().filter(t -> t%2 == 0).forEach(Lambda01::yazdir);
    }

    //Yuarkıda taskı fılter kısmını method reference ıle yapalım.
    public static boolean ciftBul (int a){
            return a % 2 ==0;
    }
    public static void printCiftElFunctional7 (List<Integer> sayi){

        sayi.stream().filter(Lambda01::ciftBul).forEach(Lambda01::yazdir);
    }


    //TASK : Structured programming ile list elemanlarinin cift olanlarinin cift olanlarini ayni satirda print et.

    public static void printCiftElStructural (List<Integer> sayi){
        for (Integer w : sayi
             ) {
            if (w%2==0){
                System.out.print(w + " ");
            }else{
                continue;
            }

        }
    }
    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtuzDorttenKucElFunctional (List<Integer> sayi){
        sayi.stream().filter(t -> t%2 == 0 && t<34).forEach(Lambda01::yazdir);
    }

    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftVeyaOtuzDorttenBuyElFunctional (List<Integer> sayi){
        sayi.stream().sorted().filter(t -> t%2 == 0 || t>34).forEach(Lambda01::yazdir);
    }

}
