import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }


  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("CD Organizer!");
  }

  @Test
  public void albumIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new album"));
    fill("#title").with("The Mantle");
    submit(".btn");
    assertThat(pageSource()).contains("Your entry has been saved.");
  }

  @Test
  public void albumIsDisplayedTest() {
    goTo("http://localhost:4567/albums/new");
    fill("#title").with("The Mantle");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    assertThat(pageSource()).contains("The Mantle");
  }

  @Test
  public void artistIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new artist"));
    fill("#title").with("The Mantle");
    submit(".btn");
    assertThat(pageSource()).contains("Your entry has been saved.");
  }

  @Test
  public void artistIsDisplayedTest() {
    goTo("http://localhost:4567/albums/new");
    fill("#title").with("Agalloch");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    assertThat(pageSource()).contains("Agalloch");
  }

  @Test
  public void multipleAlbumsAreDisplayedTest() {
    goTo("http://localhost:4567/albums/new");
    fill("#title").with("The Mantle");
    submit(".btn");
    goTo("http://localhost:4567/albums/new");
    fill("#title").with("The Grey");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    assertThat(pageSource()).contains("The Mantle");
    assertThat(pageSource()).contains("The Grey");
  }

  @Test
  public void multipleArtistsAreDisplayedTest() {
    goTo("http://localhost:4567/artists/new");
    fill("#title").with("Agalloch");
    submit(".btn");
    goTo("http://localhost:4567/artists/new");
    fill("#title").with("Stepdad");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    assertThat(pageSource()).contains("Agalloch");
    assertThat(pageSource()).contains("Stepdad");
  }

  @Test
  public void artistShowPageDisplaysName() {
    goTo("http://localhost:4567/artists/new");
    fill("#title").with("Agalloch");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    click("a", withText("Agalloch"));
    assertThat(pageSource()).contains("Agalloch");
  }

  @Test
  public void albumShowPageDisplaysTitle() {
    goTo("http://localhost:4567/albums/new");
    fill("#title").with("The Mantle");
    submit(".btn");
    click("a", withText("View all artists and albums"));
    click("a", withText("The Mantle"));
    assertThat(pageSource()).contains("The Mantle");
  }

  @Test
  public void albumNotFoundMessageShown() {
    goTo("http://localhost:4567/albums/999");
    assertThat(pageSource()).contains("Album not found");
  }

  @Test
  public void artistNotFoundMessageShown() {
    goTo("http://localhost:4567/artists/999");
    assertThat(pageSource()).contains("Artist not found");
  }
}
