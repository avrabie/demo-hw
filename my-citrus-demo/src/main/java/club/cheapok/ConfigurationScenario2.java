package club.cheapok;

import club.cheapok.entity.CurrentScenario;
import club.cheapok.entity.ScenarioLoader;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigurationScenario2 {

    private final ScenarioLoader scenarioLoader;

    public ConfigurationScenario2(ScenarioLoader scenarioLoader) {
        this.scenarioLoader = scenarioLoader;
    }

    @GetMapping("/configure2/{currentScenario}")
    @ResponseBody
    public String iaka(@PathVariable("currentScenario") final String currentScenario) {
        CurrentScenario currentScenario1;
        try {
            currentScenario1 = CurrentScenario.valueOf(currentScenario);
        } catch (IllegalArgumentException e) {
            return "No such current Scenario, choose:" + Arrays.toString(CurrentScenario.values());
        }

        scenarioLoader.setCurrentScenario(currentScenario1);
        return String.format("Changing behaviour to: %s", currentScenario);
    }


}
