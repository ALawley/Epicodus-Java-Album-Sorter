import java.util.ArrayList;

public class Artist {
  private static ArrayList<Artist> artists = new ArrayList<Artist>();
  private String mName;
  private int mId;

  public Artist(String name) {
    mName = name;
    artists.add(this);
    mId = artists.size();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Artist> all() {
    return artists;
  }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
    try {
      return artists.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    artists.clear();
  }
}
