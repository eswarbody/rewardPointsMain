### Assignment to calcuate reward points for a user 


##### To run the app:
- ``` ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev```

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

##### To run the unit+integration test testing: execute 
- ` ./mvnw test `

##### Swagger UI:
- http://localhost:8080/swagger-ui/index.html

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



