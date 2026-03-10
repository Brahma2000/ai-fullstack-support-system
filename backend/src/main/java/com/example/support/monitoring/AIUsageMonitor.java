package com.example.support.monitoring;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AIUsageMonitor {
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private static final int LIMIT = 50;

    public void incrementUsage() {
        requestCount.incrementAndGet();
    }

    public int getUsage() {
        return requestCount.get();
    }

    public boolean isLimitExceeded() {
        return requestCount.get() > LIMIT;
    }
}