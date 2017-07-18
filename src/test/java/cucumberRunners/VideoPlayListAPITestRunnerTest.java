package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 18/07/2017.
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoPlayListAPITestRunnerTest-html-report",
                "json:target/VideoPlayListAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@PlaylistGet"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoPlayListAPITestRunnerTest {
}
