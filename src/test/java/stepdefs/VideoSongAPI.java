package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.IOException;
import java.util.Random;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by mvoase on 17/07/2017.
 */
public class VideoSongAPI {

    private String SongURL = "http://turing.niallbunting.com:3003/api/video/";
    private String response;
    private String playlistResponse;
    private String playlistResponse1;
    private String newPLResponse;
    private String newPlayListID;
    private String songResponse;
    private String addSongResponse;
    private String deletePLResponse;
    private String idString;
    private String idString1;
    private String idString2;
    private String idString3;
    private String idString4;
    private String playTitle;
    private String playListID;
    private String newSongID;
    private String deleteResponse;
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
        ResponseHandler < String > handler = new BasicResponseHandler();
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
        String[] randomSongArray = {
                idString,
                idString1,
                idString2,
                idString3,
                idString4
        };
        Random rnd = new Random();

        //Picks the random Song
        randomSong = randomSongArray[rnd.nextInt(randomSongArray.length)];

        return randomSong;
    }

    @Then("^I retrieve information about a song$")
    public void SongGetCall() throws Throwable {
        getRandomSongID();
        //Send in the request for the first song
        httpResponse = Request.Get(SongURL + randomSong)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        String songResponse = handler.handleResponse(httpResponse);
        System.out.println(songResponse);
    }

    @Given("^I Post a new Song into the API$")
    public void PostVideo() throws IOException {
        //Send in a new song into the API
        String json = "{\n" +
                "\t\"artist\": \"Ed Sheeran\",\n" +
                "\t\"song\": \"Galway Girl\",\n" +
                "\t\"publishDate\": \"2017-10-02\"\n" +
                "}";
        httpResponse = Request.Post(SongURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        songResponse = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(songResponse).getAsJsonObject().get("_id");
        newSongID = element.toString();
        newSongID = newSongID.replace("\"", "");
        System.out.println("Song ID = " + newSongID + "was imported into the DB");
    }

    @Given("^I retrieve my playlist$")
    public void GetPlaylist() throws Throwable {
        // Send in get request to retrieve all playlists within the api
        httpResponse = Request.Get(playListURL)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
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
        System.out.println("Playlist ID = " + playListID);
    }

    @Then("^I check the response code for the api$")
    public void CheckAPIResponse() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        System.out.println(status);
        assertThat(status, equalTo(200));
    }

    @And("^I retrieve information about a specific playlist$")
    public void PlayListGetCallByID() throws Throwable {
        // Get a playlist by a specific ID
        httpResponse = Request.Get(playListURL + playListID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        playlistResponse1 = handler.handleResponse(httpResponse);
        System.out.println("Playlist has been parsed" + playlistResponse1);
    }

    @Given("^I create a new playlist$")
    public void CreatePlayList() throws Throwable {
        String json = "{\n" +
                "\t\"desc\": \"New Playlist\",\n" +
                "\t\"title\": \"NewPlayList\"\n" +
                "}";
        httpResponse = Request.Post(playListURL)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        newPLResponse = handler.handleResponse(httpResponse);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(newPLResponse).getAsJsonObject().get("_id");
        newPlayListID = element.toString();
        newPlayListID = newPlayListID.replace("\"", "");
        System.out.println("Playlist ID = " + newPlayListID);
    }


    @And("^I check the response code for the api for post$")
    public void Check201Status() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        assertThat(status, equalTo(201));
        System.out.println("Response code = " + status);
    }

    @And("^I check the for the api for delete$")
    public void Check204Status() throws Throwable {
        int status = httpResponse.getStatusLine().getStatusCode();
        assertThat(status, equalTo(204));
        System.out.println("Response Code = " + status);
    }

    @Given("^I delete the video$")
    public void DeleteVideo() throws Throwable {
        //Delete the song you have just uploaded from the API
        httpResponse = Request.Delete(SongURL + newSongID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        deleteResponse = handler.handleResponse(httpResponse);
        System.out.println(deleteResponse);
        assertNull("Response =" + null);
    }

    @Given("^I add a song to a playlist$")
    public void AddSongtoPL() throws Throwable {
        //Add a song from the video api to playlist
        String json = "{ \"videos\": [ {\"" + idString + "\": \"add\"}, {\"" + idString2 + "\": \"add\"} ] }";
        httpResponse = Request.Patch(playListURL + playListID)
                .addHeader("content-type", "application/json")
                .addHeader("Accept", "application/json")
                .bodyString(json, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        addSongResponse = handler.handleResponse(httpResponse);
        System.out.println(addSongResponse);

    }

    @And("^I delete the playlist$")
    public void DeletePlayList() throws Throwable {
       //Delete the playlist based on the id
        httpResponse = Request.Delete(playListURL + newPlayListID)
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute()
                .returnResponse();
        ResponseHandler < String > handler = new BasicResponseHandler();
        deletePLResponse = handler.handleResponse(httpResponse);
        System.out.println(deletePLResponse);
    }
}