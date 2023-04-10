
import java.util.Locale;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Integer a=null;


     //   Optional<Integer> maybeInteger= Optional.of(a);

        //Integer c=1+a;
        b(Optional.ofNullable(a));
        String name=null;
      //  printName(name);
        printName("asd");
      /*  Optional<String> gender=Optional.of("Male");*/

    }
    public static void b(Optional<Integer> param){
        param.ifPresent(System.out::println);
    }

    public static void printName(String name){

        Optional<String> nameOptional=Optional.ofNullable(name);
        System.out.println(nameOptional
                .map(String::toUpperCase)//Optional<String>
                .orElse(""));


        //iç içe Optional
        System.out.println("** Ic Ice Optional **");
        Optional<Optional<String>> nameOpt=Optional.of(nameOptional);
        System.out.println(nameOpt
                .map(s -> s.map(String::toUpperCase))//Optional<String>
                .orElse(Optional.of("")).orElse(""));


        //flatMap
        System.out.println("** flatMap **");
        Optional<Optional<String>> flatOpt=Optional.of(nameOptional);
        System.out.println(nameOpt
                .flatMap(n->n.map(String::toUpperCase)).orElse(""));


        //filter
        System.out.println("** filter **");
       Optional<String> nameOptional2=Optional.ofNullable(name);
        if (name != null) {
            if (name.length()>3){
                System.out.println(name);
            }
        }
        //T ile başlayıp karakter sayısı 3 den büyük olanları filtrele
        System.out.println(
                nameOptional2
                        .filter(n->n.length()>3 && n.startsWith("T"))
                        .orElse(""));

        //isPresent, isEmpty,ifPresent
        System.out.println("** isPresent, isEmpty,ifPresent **");

        Optional<String> nameOptional3=Optional.ofNullable(null);
        if (nameOptional3.isPresent()){//Not-Null
            System.out.println(nameOptional3.get());
        }
        else {
            System.out.println("Isim girilmeli");
        }
        if (nameOptional3.isEmpty()){//Null
            System.out.println("Isim girilmedi");
        }
        else {
            System.out.println(nameOptional3.get());
        }

        nameOptional3.ifPresent(x->c(x));

        //Java 9+
        nameOptional3.ifPresentOrElse(Main::c,() -> System.out.println("Empty"));

    }

    public static void c(String a){
        System.out.println(a);

    }


}
