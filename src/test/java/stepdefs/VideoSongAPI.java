package stepdefs;

import cucumber.api.java.en.Given;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by mvoase on 17/07/2017.
 */
public class VideoSongAPI {

    private String SongURL = "http://turing.niallbunting.com:3003/api/video/";
    private String PlayListURL = "";
    private String response;

    @Given("^I retrieve all the songs available$")
    public void GetSongs() throws Throwable {
      // Send in get request to retrieve all the songs in the API
        response = Request.Get(SongURL)
            .connectTimeout(1000)
            .socketTimeout(1000)
            .execute().returnContent().asString();
        System.out.println(response);
        convertString();

    }


    private void convertString() throws Throwable {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonArray songs = element.getAsJsonArray();
        System.out.println(songs);

        JsonObject songsJson = (JsonObject) songs.get(0);
        JsonElement firstSong = songsJson.get("_id");
        firstSong.toString();

    }

    /*@Then("^I upload a new video to the playlist$")
    public void PostVideo() throws Throwable {

    }*/

    /*@And("^I check the video is available in the Api$")
    public void CheckVideoUpload() throws Throwable {

    }*/


}
