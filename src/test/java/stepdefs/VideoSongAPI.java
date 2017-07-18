package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.impl.client.BasicResponseHandler;

import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by mvoase on 17/07/2017.
 */
public class VideoSongAPI {

    private String SongURL = "http://turing.niallbunting.com:3003/api/video/";
    private String response;
    private String playlistResponse;
    private String playlistResponse1;
    private String idString;
    private String idString1;
    private String idString2;
    private String idString3;
    private String idString4;
    private String playTitle;
    private String playListID;
    private String randomSong;
    private String playListURL = "http://turing.niallbunting.com:3003/api/playlist/";
    private HttpResponse httpResponse;

    @Given("^I retrieve all the songs available$")
    public void GetSongs() throws Throwable {
        // Send in get request to retrieve all the songs in the API
        httpResponse = Request.Get(SongURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        response = handler.handleResponse(httpResponse);
        convertString();
    }

    private void convertString() throws Throwable {
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

    @Then("^I retrieve information about a song$")
    public void SongGetCall() throws Throwable {
        getRandomSongID();
        //Send in the request for the first song
        // Send in get request to retrieve all the songs in the API
        httpResponse = Request.Get(SongURL + randomSong)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        String songResponse = handler.handleResponse(httpResponse);
        System.out.println(songResponse);
    }

    @Given("^I Post a new Song into the API$")
    public void PostVideo() throws Throwable {

    }

    @Given("^I retrieve my playlist$")
    public void GetPlaylist() throws Throwable {
        // Send in get request to retrieve all playlists within the api
        httpResponse = Request.Get(playListURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        playlistResponse = handler.handleResponse(httpResponse);
        getPlayListID();
        getPlaylistTitle();
        System.out.println("Playlist has been parsed" + playlistResponse);
    }

    private void getPlaylistTitle() {
        //Converts to JSONArray
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(playlistResponse);
        JsonArray playlists = element.getAsJsonArray();
        System.out.println(playlists);

        //Retrieves ID from first song in the API
        JsonObject playlistJson = (JsonObject) playlists.get(0);
        JsonElement playlist = playlistJson.get("title");
        playTitle = playlist.toString();
        playTitle = playTitle.replace("\"", "");
        System.out.println("Playlist Title = " + playTitle);
    }

    private void getPlayListID() {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(playlistResponse);
        JsonArray playlists = element.getAsJsonArray();
        System.out.println(playlists);

        //Retrieves ID from first song in the API
        JsonObject playlistJson = (JsonObject) playlists.get(0);
        JsonElement playlist = playlistJson.get("_id");
        playListID = playlist.toString();
        playListID = playListID.replace("\"", "");
        System.out.println("Playlist Title = " + playListID);
    }

    @Then("^I check the response code for the api$")
    public void CheckAPIResponse() throws Throwable {
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(200));
    }

    @And("^I retrieve information about a specific playlist$")
    public void PlayListGetCallByID() throws Throwable {
        // Get a playlist by a specific ID
        httpResponse = Request.Get(playListURL + playListID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler<String> handler = new BasicResponseHandler();
        playlistResponse1 = handler.handleResponse(httpResponse);
        System.out.println("Playlist has been parsed" + playlistResponse1);
    }


    /*@Then("^I upload a new video to the playlist$")
    public void PostVideo() throws Throwable {

    }*/

    @And("^I check the video is available in the Api$")
    public void CheckVideoUpload() throws Throwable {

    }


}
