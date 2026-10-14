# Weather backend

The service is a Spring Boot 4 / Java 17 application packaged with the
repository's Dockerfile. Its endpoint is `GET /weather/{city}` and returns the
current OpenWeather response in metric units.

## Deploy on Railway

1. Create a Railway project and add a **MySQL** database.
2. Add a service from the `Navyasri-maker/weather_BackEnd` GitHub repository.
   Railway detects the Dockerfile at the repository root.
3. In the backend service's Variables, reference the MySQL service's
   connection variables. Replace `MySQL` below with the database service's
   exact Railway name:

   ```text
   SPRING_DATASOURCE_URL=jdbc:mysql://${{MySQL.MYSQLHOST}}:${{MySQL.MYSQLPORT}}/${{MySQL.MYSQLDATABASE}}?sslMode=DISABLED
   SPRING_DATASOURCE_USERNAME=${{MySQL.MYSQLUSER}}
   SPRING_DATASOURCE_PASSWORD=${{MySQL.MYSQLPASSWORD}}
   WEATHER_API_KEY=<your OpenWeather API key>
   WEATHER_CORS_ORIGIN=*
   ```

4. Generate a public domain for the backend service. Copy it for the frontend
   setup below. Once the frontend has a public Vercel URL, replace `*` in
   `WEATHER_CORS_ORIGIN` with that origin, for example
   `https://your-app.vercel.app`, and redeploy the backend.

Keep API and database credentials in Railway Variables only; never commit them.

## Existing Aiven setup

The existing `AIVEN_HOST`, `AIVEN_PORT`, `AIVEN_DATABASE`, `AIVEN_USER`,
`AIVEN_PASSWORD`, and `AIVEN_SSL_MODE` configuration remains supported.
