package com.flexicore.interfaces;

import org.springframework.boot.actuate.health.HealthIndicator;

public interface HealthCheckPlugin extends ServicePlugin, HealthIndicator {
}
