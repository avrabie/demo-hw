package club.cheapok;


import club.cheapok.entity.ScenarioFactory;
import club.cheapok.entity.ScenarioLoader;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Iaka {

    public static void main(String[] args) {

        final ConfigurableApplicationContext context = SpringApplication.run(Iaka.class, args);
    }


    @Bean
    public ScenarioLoader settingScenario() {
        return new ScenarioLoader();
    }

    @Bean
    public ServiceLocatorFactoryBean serviceLocatorBean() {
        final ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
        bean.setServiceLocatorInterface(ScenarioFactory.class);
        return bean;
    }


}
