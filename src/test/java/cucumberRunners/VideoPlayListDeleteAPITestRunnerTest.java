package cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mvoase on 17/07/2017.
 */

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber/VideoPlayListDeleteAPITestRunnerTest-html-report",
                "json:target/VideoPlayListDeleteAPITestRunnerTest.json"
        },
        monochrome = true,
        tags = {"@PlaylistDelete"},
        features = "src/test/resources/features",
        glue = { "stepdefs"})
@RunWith(Cucumber.class)
public class VideoPlayListDeleteAPITestRunnerTest {

}
