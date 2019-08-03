import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getter i  settery
@AllArgsConstructor // dodaje konstruktor movie
public class Movie implements Playable {

    private String title;

    public void play() {
        System.out.println("File "+ title);
    }
}
