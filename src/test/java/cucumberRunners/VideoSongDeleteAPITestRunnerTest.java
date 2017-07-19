package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 17/07/2017.
 */

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoSongDeleteAPITestRunnerTest-html-report",
                "json:target/VideoSongDeleteAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@VideoDelete"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoSongDeleteAPITestRunnerTest {

}
