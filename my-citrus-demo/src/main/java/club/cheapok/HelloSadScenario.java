package club.cheapok;

import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.simulator.scenario.AbstractSimulatorScenario;
import com.consol.citrus.simulator.scenario.Scenario;
import com.consol.citrus.simulator.scenario.ScenarioDesigner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scenario("HelloSad")
@RequestMapping(value = "/services/rest/helloSad", method = RequestMethod.GET)
public class HelloSadScenario extends AbstractSimulatorScenario {

    @Override
    public void run(ScenarioDesigner designer) {

        designer
            .http().receive().get();

        designer.send()
                .message(new HttpMessage("This is the sad scenario!")
                    .status(HttpStatus.OK));


    }
}
