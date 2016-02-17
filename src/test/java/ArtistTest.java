import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void artist_InstantiatesCorrectly_true() {
    Artist myArtist = new Artist("Agalloch");
    assertEquals(true, myArtist instanceof Artist);
  }
  @Test
  public void artist_instantiatesWithArtistName_true() {
    Artist myArtist = new Artist("Agalloch");
    assertEquals("Agalloch", myArtist.getName());
  }
  @Test
  public void allArtists_returnsAllInstancesOfArtist_true() {
    Artist firstArtist = new Artist("Agalloch");
    Artist secondArtist = new Artist("Stepdad");
    assertTrue(Artist.all().contains(firstArtist));
    assertTrue(Artist.all().contains(secondArtist));
  }
  @Test
  public void getID_artistsInstantiateWithID_true() {
    Artist myArtist = new Artist("Agalloch");
    assertEquals(Artist.all().size(), myArtist.getId());
  }
  @Test
  public void find_returnsArtistWithSameID_secondArtist() {
    Artist firstArtist = new Artist("Agalloch");
    Artist secondArtist = new Artist("Stepdad");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

}
