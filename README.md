### Assignment to calculate reward points for a user given transaction dates 

### Technical Details
    1. Java 8
    2. Execution Flow: 
        client request -->Controller
                            -->Service
                                -->Repository
                                    -->Persistence
    3. UnitTesting & Integration Testing
    4. Performance Testing <Gatling>

### Business logic  
    1. Calculating RewardPoints for a user in each transaction
    2. if transaction amount is over 100 then reward points should be * 2 
       and over 50 should be * 1
    3. example: transaction amount is 120 then points would be 20*2 + 50*1 = 90

##### To run the app:
- ``` ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```

##### To run the unit+integration test testing: execute 
- ` ./mvnw test `

##### Swagger UI:
- http://localhost:8080/swagger-ui/index.html

#### Test Data
<pre>
|user id  | transaction date |
 ------------  ----------------
| 1       | 2022-10-10       |
| 2       | 2022-11-06       |
| 3       | 2021-10-10       |
| 1       | 2022-10-11       |
| 2       | 2022-11-08       |
| 3       | 2021-10-09       |
</pre>

##### To run the performance (Gatling) testing: execute 
- `  ./mvnw  gatling:test -Dgatling.simulationClass=performance.com.assignment.rewards.points.PointsSimulation -Dmaven.test.skip=true `

##### To open Gatling nice UI results ( the result file complete path already shown after the simulation finish)
- ```target/gatling/pointssimulation-***```

#### curl calcPointsPerMonth
- ```curl --location --request GET 'http://localhost:8080/rewards/2/points/2022-11-08' ```

#### curl calcPointsMonthRange
- ```curl --location --request GET 'http://localhost:8080/rewards/2/points?from=2022-11-06&to=2022-11-08' ```

#### Swagger UI
![Swagger UI](screenshots/swagger.png?raw=true "Title")
#### Gatling Results
![Gatling Results1](screenshots/gat3.png?raw=true "Title")
![Gatling Results2](screenshots/gat1.png?raw=true "Title")
![Gatling Results3](screenshots/gat2.png?raw=true "Title")



