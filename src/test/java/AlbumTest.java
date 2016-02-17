import org.junit.*;
import static org.junit.Assert.*;

public class AlbumTest {

  @Test
  public void album_InstantiatesCorrectly_true() {
    Album myAlbum = new Album("The Mantle");
    assertEquals(true, myAlbum instanceof Album);
  }
  public void album_instantiatesWithTitle_true() {
    Album myAlbum = new Album("The Mantle");
    assertEquals("The Mantle", myAlbum.getTitle());
  }
  public void allAlbums_returnsAllInstancesOfAlbum_true() {
    Album firstAlbum = new Album("The Mantle");
    Album secondAlbum = new Album("Pale Folklore");
    assertTrue(Album.all().contains(firstAlbum));
    assertTrue(Album.all().contains(secondAlbum));
  }
}
