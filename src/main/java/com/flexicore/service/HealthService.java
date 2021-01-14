package com.flexicore.service;

import com.flexicore.interfaces.FlexiCoreService;
import com.flexicore.response.HealthStatusResponse;
import org.springframework.boot.actuate.health.HealthComponent;

public interface HealthService extends FlexiCoreService {

	HealthComponent getHealth();
	HealthStatusResponse healthCheck();
}
