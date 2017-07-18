package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by mvoase on 17/07/2017.
 */
public class VideoSongAPI {

    private String SongURL = "http://turing.niallbunting.com:3003/api/video/";
    private String PlayListURL = "";
    private String response;
    private String songResponse;
    private String idString;
    private String idString1;
    private String idString2;
    private String idString3;
    private String idString4;
    private String randomSong;
    private HttpResponse httpResponse;

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

    public void convertString() throws Throwable {
        //Converts to JSONArray
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(response);
        JsonArray songs = element.getAsJsonArray();
        System.out.println(songs);

        //Retrieves ID from first song in the API
        JsonObject songsJson = (JsonObject) songs.get(0);
        JsonElement firstSong = songsJson.get("_id");
        idString = firstSong.toString();
        idString = idString.replace("\"", "");
        System.out.println("Song ID = " + idString);

        //Retrieves ID from second song in the API
        JsonObject songsJson1 = (JsonObject) songs.get(1);
        JsonElement secondSong = songsJson1.get("_id");
        idString1 = secondSong.toString();
        idString1 = idString1.replace("\"", "");
        System.out.println("Song ID = " + idString1);

        //Retrieves ID from third song in the API
        JsonObject songsJson3 = (JsonObject) songs.get(2);
        JsonElement thirdSong = songsJson3.get("_id");
        idString2 = thirdSong.toString();
        idString2 = idString2.replace("\"", "");
        System.out.println("Song ID = " + idString2);

        //Retrieves ID from fourth song in the API
        JsonObject songsJson4 = (JsonObject) songs.get(3);
        JsonElement fourthSong = songsJson4.get("_id");
        idString3 = fourthSong.toString();
        idString3 = idString3.replace("\"", "");
        System.out.println("Song ID = " + idString3);

        //Retrieves ID from fifth song in the API
        JsonObject songsJson5 = (JsonObject) songs.get(4);
        JsonElement fifthSong = songsJson5.get("_id");
        idString4 = fifthSong.toString();
        idString4 = idString4.replace("\"", "");
        System.out.println("Song ID = " + idString4);


    }

    private String getRandomSongID() throws Throwable {
        // Picks a random song to use from the api
        String[] randomSongArray = {idString, idString1, idString2, idString3, idString4};
        Random rnd = new Random();

        //Picks the random Song
        randomSong = randomSongArray[rnd.nextInt(randomSongArray.length)];

        return randomSong;
    }

    @Then("^I retrieve information about the first song$")
    public void FirstSongCall() throws Throwable {
        getRandomSongID();
        //Send in the request for the first song
        songResponse = Request.Get(SongURL + randomSong)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asString();
        System.out.println();
    }

    @Given("^I Post a new Song into the API$")
    public void PostVideo() throws Throwable {

    }


    /*@Then("^I upload a new video to the playlist$")
    public void PostVideo() throws Throwable {

    }*/

    /*@And("^I check the video is available in the Api$")
    public void CheckVideoUpload() throws Throwable {

    }*/


}
