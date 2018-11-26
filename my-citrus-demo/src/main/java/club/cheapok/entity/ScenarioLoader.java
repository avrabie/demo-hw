package club.cheapok.entity;

import java.util.HashMap;
import java.util.Map;

public class ScenarioLoader {

    private static final Map<CurrentScenario, String> SCENARIO_MODIFIER = new HashMap<>();

    static {
        SCENARIO_MODIFIER.put(CurrentScenario.DEFAULT, "HelloHappy");
        SCENARIO_MODIFIER.put(CurrentScenario.FAULT1, "HelloSad");
    }

    private CurrentScenario currentScenario = CurrentScenario.FAULT1;

    public CurrentScenario getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(CurrentScenario currentScenario) {
        this.currentScenario = currentScenario;
    }

    public String getScenarioName() {
        return SCENARIO_MODIFIER.get(currentScenario);
    }

}
