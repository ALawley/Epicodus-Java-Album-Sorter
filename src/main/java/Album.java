import java.util.ArrayList;

public class Album {
  private static ArrayList<Album> albums = new ArrayList<Album>();
  private String mTitle;
  private int mId;

  public Album(String title) {
    mTitle = title;
    albums.add(this);
    mId = albums.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList<Album> all() {
    return albums;
  }

  public int getId() {
    return mId;
  }
}
