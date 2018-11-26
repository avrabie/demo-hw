package club.cheapok;

import club.cheapok.entity.CurrentScenario;
import club.cheapok.entity.ScenarioLoader;
import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("Configuration")
@RequestMapping(value = "/services/rest/configure", method = RequestMethod.GET)
public class ConfigurationScenario extends AbstractSimulatorScenario {

    private final ScenarioLoader scenarioLoader;

    public ConfigurationScenario(ScenarioLoader scenarioLoader) {
        this.scenarioLoader = scenarioLoader;
    }

    @Override
    public void run(ScenarioDesigner designer) {
        designer.http().receive().get();

        if (scenarioLoader.getCurrentScenario().equals(CurrentScenario.DEFAULT)) {
            designer.send().message(new HttpMessage("Setting Scenario to Fault1").status(HttpStatus.OK));
            scenarioLoader.setCurrentScenario(CurrentScenario.FAULT1);

        } else {
            designer.send().message(new HttpMessage("Setting Scenario to Default").status(HttpStatus.OK));
            scenarioLoader.setCurrentScenario(CurrentScenario.DEFAULT);
        }
    }
}
