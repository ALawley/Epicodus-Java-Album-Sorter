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
}
