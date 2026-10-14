# Weather backend deployment

The Render Blueprint in the repository root builds this directory as a Docker
web service. In Render, create a new Blueprint from the repository and provide
these environment variables for the service:

- `AIVEN_HOST`, `AIVEN_PORT`, `AIVEN_DATABASE`, `AIVEN_USER`, and
  `AIVEN_PASSWORD` from the Aiven service's connection information.
- `WEATHER_API_KEY` from OpenWeather.

The service connects to MySQL over TLS (`AIVEN_SSL_MODE=REQUIRED`). Keep
credentials in Render environment variables; do not add them to this file or
commit them. The weather endpoint is `GET /weather/{city}` and returns
OpenWeather's JSON response.
