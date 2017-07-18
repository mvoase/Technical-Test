package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 17/07/2017.
 */

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoSongAPITestRunnerTest-html-report",
                "json:target/VideoSongAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@VideoGET"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoSongAPITestRunnerTest {

}
