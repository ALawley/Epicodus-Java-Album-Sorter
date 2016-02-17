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


}
