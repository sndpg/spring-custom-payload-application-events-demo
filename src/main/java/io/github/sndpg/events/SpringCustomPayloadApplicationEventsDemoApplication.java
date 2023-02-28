package io.github.sndpg.events;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringCustomPayloadApplicationEventsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCustomPayloadApplicationEventsDemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(ApplicationContext applicationContext) {
        return args -> applicationContext.publishEvent(
                new MyCustomPayloadApplicationEvent<>(this, new MyPayload(1L))
        );
    }

    @EventListener(MyCustomPayloadApplicationEvent.class)
    public void onMyCustomPayloadApplicationEvent(MyCustomPayloadApplicationEvent<MyPayload> myCustomPayloadApplicationEvent) {
        System.out.println("event with id " + myCustomPayloadApplicationEvent.getPayload().getId() +
                " received with matching MyCustomPayloadApplicationEvent");
    }

    @EventListener(MyCustomPayloadApplicationEvent.class)
    public void onMyCustomPayloadApplicationEvent(PayloadApplicationEvent<MyPayload> myCustomPayloadApplicationEvent) {
        System.out.println("event with id " + myCustomPayloadApplicationEvent.getPayload().getId() +
                " received with matching PayloadApplicationEvent");
    }

}
