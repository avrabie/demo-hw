package club.cheapok;

import club.cheapok.entity.CurrentScenario;
import club.cheapok.entity.ScenarioLoader;
import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("HelloTest")
@RequestMapping(value = "/services/rest/helloTest", method = RequestMethod.GET)
public class HelloScenario extends AbstractSimulatorScenario {


    @Autowired
    ScenarioLoader scenarioLoader;

    @Override
    public void run(ScenarioDesigner designer) {

        designer
            .http().receive().get();
        if (scenarioLoader.getCurrentScenario().equals(CurrentScenario.DEFAULT)) {

            designer.send()
                    .message(new HttpMessage("Welcome to the default (first) scenario!")
                        .status(HttpStatus.OK));
        } else if (scenarioLoader.getCurrentScenario().equals(CurrentScenario.FAULT1)) {
            designer.send()
                    .message(new HttpMessage("This is a completely different scenario!")
                        .status(HttpStatus.OK));
        }





            /*.send()
            .payload("<HelloResponse xmlns=\"http://citrusframework.org/schemas/hello\">" +
                "Hi there!" +
                "</HelloResponse>");*/
    }
}
