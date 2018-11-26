package club.cheapok.entity;

import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;

public interface ScenarioFactory {

    AbstractSimulatorScenario getScenario(String beanName);

}
