import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
//BEGIN ALBUM PAGES
    get("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("albums", Album.all());
      model.put("artists", Artist.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("albums/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/album-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/albums", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("title");
      Album newAlbum = new Album(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      int activeAlbum = Integer.parseInt(request.params(":id"));
      Album album = Album.find(activeAlbum);
      request.session().attribute("activeAlbum", activeAlbum);
      model.put("artists", Artist.all());
      model.put("album", album);
      model.put("template", "templates/album.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//BEGIN ARTIST PAGES
    get("/artists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("artists", Artist.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("artists/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/artist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/artists", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("title");
      Artist newArtist = new Artist(description);
      model.put("albums", Album.all());
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("albums", Album.all());
      model.put("artist", artist);
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("albums/artist-assign", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String artist = request.queryParams("artist");
      int activeAlbum = request.session().attribute("activeAlbum");
      Album.find(activeAlbum).addArtist(artist);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
