package ugaz.renato.ticketmania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTicketmaniaApplication {

    public static void main(String[] args) {
        SpringApplication.from(Application::main).with(TestTicketmaniaApplication.class).run(args);
    }

}
