package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 18/07/2017.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoPlayListPostAPITestRunnerTest-html-report",
                "json:target/VideoPlayListPostAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@PlaylistPost"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoPlayListPostAPITestRunnerTest {
}
