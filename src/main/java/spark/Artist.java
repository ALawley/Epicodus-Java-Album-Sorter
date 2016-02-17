import java.util.ArrayList;

public class Artist {
  private static ArrayList<Artist> artists = new ArrayList<Artist>();
  private String mName;

  public Artist(String name) {
    mName = name;
    artists.add(this);
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    return artists;
  }
}
