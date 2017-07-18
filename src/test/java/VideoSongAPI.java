import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.http.client.fluent.Request;

/**
 * Created by mvoase on 17/07/2017.
 */
public class VideoSongAPI {

    @Given("^I upload a new video to the api$")
    public void PostVideo() throws Throwable {
        Request.Post("http://turing.niallbunting.com:3003/api/video")
                .addHeader("Content-Tyoe", "application/json");
    }

    /*@Then("^I upload a new video to the playlist$")
    public void PostVideo() throws Throwable {

    }*/

    /*@And("^I check the video is available in the Api$")
    public void CheckVideoUpload() throws Throwable {

    }*/
}
