import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPractice03 {

    public static void main(String[] args){

        Apartman daire1=new Apartman("dogu",3,4000);
        Apartman daire2=new Apartman("bati",2,2500);
        Apartman daire3=new Apartman("guney",1,3500);
        Apartman daire4=new Apartman("dogu",5,3000);

        List<Apartman> kiralikDaireler = new ArrayList<>(Arrays.asList(daire1,daire2,daire3,daire4));

        doguKrayaSirala(kiralikDaireler);
        System.out.println(ikidenCokKiraList(kiralikDaireler));
    }

    //dogu cephesindeki kiralik daireleri kiralarina gore siralayin
    public static void doguKrayaSirala(List<Apartman> list){
        list.stream().filter(t->t.getCephe().equalsIgnoreCase("dogu")).sorted(Comparator.comparing(t->t.getKira())).forEach(System.out::println);
    }
    //Kat sayisi 2den cok ilan dairelerin kiralarini listeleyen.
    public static List<Integer> ikidenCokKiraList (List<Apartman> list){

        return list.stream().filter(t->t.getKatSayisi()>2).map(t->t.getKira()).collect(Collectors.toList());

    }
}
