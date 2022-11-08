package performance.com.assignment.rewards.points;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import lombok.extern.slf4j.Slf4j;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

@Slf4j
public class PointsSimulation extends Simulation {


    HttpProtocolBuilder httpProtocol = http.baseUrl(PerfTestConfig.BASE_URL)
            .header("Content-Type", "application/json")
            .check(status().is(200));


    ScenarioBuilder calcPointsBySingleMonth = scenario("PointsCalcBySingleMonth")
            .exec(http("PointsPerMonth")
                    .get("/rewards/1/points/2022-10-10")
                    .check(status().is(200))
                    .check(jsonPath("$.total").is("60").saveAs("total"))

            )
            .exec(session -> session);
    ScenarioBuilder calcPointsByRange = scenario("PointsCalcByRange")
            .exec(http("PointsPerMonth")
                    .get("/rewards/2/points?from=2022-11-06&to=2022-11-08")
                    .check(status().is(200))
                    .check(jsonPath("$.total").is("340").saveAs("totalForRange"))

            )
            .exec(session -> session);


    {


        setUp(
                calcPointsBySingleMonth.injectOpen(atOnceUsers(10))
                        .andThen(calcPointsByRange.injectOpen(atOnceUsers(10)))
        ).protocols(httpProtocol)
                .assertions(
                        // Assert that the max response time of all requests is less than 100 ms
                        global().responseTime().percentile3().lt(PerfTestConfig.P95_RESPONSE_TIME_MS),
                        // Assert that every request has no more than 5% of failing requests
                        forAll().failedRequests().percent().lte(5.0),
                        //target the number of successful requests
                        global().successfulRequests().percent().gte(95.0));

    }
}
