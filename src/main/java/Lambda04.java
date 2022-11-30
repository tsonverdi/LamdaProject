import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {
        University u01 = new University("bogazici","matematik",571,93);
        University u02 = new University("istanbul tk","matematik",600,81);
        University u03 = new University("istanbul","hukuk",1400,71);
        University u04 = new University("marmara","bilg muh",1080,77);
        University u05 = new University("odtu","gemi muh",333,74);

        List<University> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println("nort orlarinin 74den buyuk odlgunu kontrol eden method: ");
        System.out.println(yetmisDorttenBuyuk(unv));
        System.out.println("universtilerde herhangi birinde matematik olup olmadigini kontrol eden: ");
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(sayilaraGoreSiralama(unv));
        System.out.println();
        System.out.println(matematikSayisi(unv));
        System.out.println();
        System.out.println(ogrenciFazlaEnBykNot(unv));
        System.out.println();
        System.out.println(ogrenciAzEnKckNot(unv));
    }

    //Task 1: nort orlarinin 74den buyuk odlgunu kontrol eden method yap
    public static boolean yetmisDorttenBuyuk (List<University> unv) {
        boolean check =  unv.stream().allMatch(t-> t.getNotOrt()>74);
        return check;
    }
    //Task 2: universtilerde herhangi birinde matematik olup olmadigini kontrol eden
    public static boolean matBolumVarMi (List<University> unv) {
        return unv.stream().anyMatch(t->t.getBolum().toLowerCase().contains("matematik"));
    }

    //Task 3: unvirestileri org b k sirala
    public static List<University> sayilaraGoreSiralama (List<University> unv) {
        return unv.stream().sorted(Comparator.comparing(University::getOgrenciSayisi).reversed()).collect(Collectors.toList());

    }//Task 4:matematik sayyisini veren kod.
    public static int matematikSayisi (List<University> unv) {
        return (int) unv.stream().filter(t->t.getBolum().toLowerCase().contains("mat")).count();
    }
    //Task 5: Ogrenci sayilari 550den fazla olan universitelerin en buyuk notOrtunu bulunuz.
    public static OptionalInt ogrenciFazlaEnBykNot (List<University> unv){

        return unv.
                stream().
                filter(t->t.getOgrenciSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrenciAzEnKckNot (List<University> unv){
        return unv.stream().filter(t->t.getOgrenciSayisi()<1050).mapToInt(t->t.getNotOrt()).min();
    }
}
