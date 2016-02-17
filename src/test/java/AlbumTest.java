import org.junit.*;
import static org.junit.Assert.*;

public class AlbumTest {

  @Rule
  public ClearRule clearRule = new ClearRule();
  
  @Test
  public void album_InstantiatesCorrectly_true() {
    Album myAlbum = new Album("The Mantle");
    assertEquals(true, myAlbum instanceof Album);
  }
  @Test
  public void album_instantiatesWithTitle_true() {
    Album myAlbum = new Album("The Mantle");
    assertEquals("The Mantle", myAlbum.getTitle());
  }
  @Test
  public void allAlbums_returnsAllInstancesOfAlbum_true() {
    Album firstAlbum = new Album("The Mantle");
    Album secondAlbum = new Album("Pale Folklore");
    assertTrue(Album.all().contains(firstAlbum));
    assertTrue(Album.all().contains(secondAlbum));
  }
  @Test
  public void getID_albumsInstantiateWithID_true() {
    Album myAlbum = new Album("The Grey");
    assertEquals(Album.all().size(), myAlbum.getId());
  }
  @Test
  public void find_returnsAlbumWithSameID_secondAlbum() {
    Album firstAlbum = new Album("The Grey");
    Album secondAlbum = new Album("Pale Folklore");
    assertEquals(Album.find(secondAlbum.getId()), secondAlbum);
  }
  @Test
  public void find_returnsNullWhenNoAlbumFound_null() {
    assertTrue(Album.find(999) == null);
  }
  @Test
  public void clear_emptiesAllAlbumsFromArrayList() {
    Album myAlbum = new Album("The Grey");
    Album.clear();
    assertEquals(Album.all().size(), 0);
  }
}
