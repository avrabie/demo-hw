package club.cheapok;

import club.cheapok.entity.ScenarioFactory;
import club.cheapok.entity.ScenarioLoader;
import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("Hello")
@RequestMapping(value = "/services/rest/hello", method = RequestMethod.GET)
public class HelloScenarioRouting extends AbstractSimulatorScenario {


    private final ScenarioFactory scenarioFactory;

    private final ScenarioLoader scenarioLoader;

    //    @Autowired
    //    HelloHappyScenario happyScenario;
    //    @Autowired
    //    HelloSadScenario sadScenario;

    public HelloScenarioRouting(ScenarioFactory scenarioFactory, ScenarioLoader scenarioLoader) {
        this.scenarioFactory = scenarioFactory;
        this.scenarioLoader = scenarioLoader;
    }


    @Override
    public void run(ScenarioDesigner designer) {

        final String scenarioName = scenarioLoader.getScenarioName();
        scenarioFactory.getScenario(scenarioName).run(designer);

//        final CurrentScenario currentScenario = scenarioLoader.getCurrentScenario();
//        //bean nme
//
//        if (currentScenario == CurrentScenario.DEFAULT) {
//            happyScenario.run(designer);
//        } else if (currentScenario == CurrentScenario.FAULT1) {
//            sadScenario.run(designer);
//        }

    }
}
