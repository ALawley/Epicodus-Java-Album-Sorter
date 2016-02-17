import java.util.ArrayList;

public class Album {
  private static ArrayList<Album> albums = new ArrayList<Album>();
  private String mTitle;

  public Album(String title) {
    mTitle = title;
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Album> all() {
    return albums;
  }
}
