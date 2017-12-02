
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String [ ] args) throws IOException{
        /*List<String> words = new LinkedList<>();
        words.add("czerwona");
        words.add("200");
        words.add("zlotych");
        words.add("koszulka");
        
        PobieranieZInternetu xxx = new PobieranieZInternetu();
        List<String> result = xxx.getItemsList(words);
        for (String i : result){
            System.out.println(i);
        }*/
        PobieranieZInternetu xxx = new PobieranieZInternetu();
        List<String> xyz = xxx.getSynonimsList("Doll");
        for (String i : xyz){
            System.out.println(i);
        }
    }
}
