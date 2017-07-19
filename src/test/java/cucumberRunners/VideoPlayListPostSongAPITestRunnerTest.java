package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 18/07/2017.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoPlayListPostSongAPITestRunnerTest-html-report",
                "json:target/VideoPlayListPostSongAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@PlaylistUpdate"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoPlayListPostSongAPITestRunnerTest {
}
