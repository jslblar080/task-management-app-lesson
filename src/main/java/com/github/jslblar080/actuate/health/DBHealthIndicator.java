package com.github.jslblar080.actuate.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DBHealthIndicator implements HealthIndicator {

    private boolean isDBUp = false;

    @Override
    public Health health() {
        if (isDBUp) {
            return Health.up()
                    .build();
            // {"status":"UP","components":xxx
        } else {
            return Health.down()
                    .withDetail("Error Code`", 503) // Service Unavailable
                    .build();
            // node name is suffix of DBHealthIndicator, which is "DB"
            // {"status":"DOWN","components":{"DB":{"status":"DOWN","details":{"Error Code`":503}},xxx
        }
    }
}
