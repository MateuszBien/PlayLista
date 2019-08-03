import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Song implements Playable {
    private String name;
    private String author;

    public  void play (){
        System.out.println("Muzyka "+ author+", " +name);
    }

}
