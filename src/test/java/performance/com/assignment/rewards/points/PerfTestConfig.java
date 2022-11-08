package performance.com.assignment.rewards.points;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public final class PerfTestConfig {
    public static final String BASE_URL = SystemPropertiesUtil.getAsStringOrElse("baseUrl", "http://localhost:8080/");
     public static final int P95_RESPONSE_TIME_MS = SystemPropertiesUtil.getAsIntOrElse("p95ResponseTimeMs", 100000);


}
