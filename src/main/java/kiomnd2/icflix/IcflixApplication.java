package kiomnd2.icflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan

@SpringBootApplication
public class IcflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcflixApplication.class, args);
    }

}
