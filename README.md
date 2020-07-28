### RUN POSTGRES DOCKER CONTAINER

```
docker run -d --restart unless-stopped -p 5432:5432 --name sc-mvp-postgres -e POSTGRES_DB=sc-mvp -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:12
```

### HOW TO RUN

#### dev version
1. Default (with tests): ```gradlew clean build bootRun -PactiveProfile=dev```
2. Skipping tests: ```gradlew clean build bootRun -PskipTest -PactiveProfile=dev```
2. Tests only: ```gradlew clean test -PactiveProfile=dev```

#### prod version

1. Default (with tests): ```gradlew clean build bootRun -PactiveProfile=prod```
2. Skipping tests: ```gradlew clean build bootRun -PskipTest -PactiveProfile=prod```
2. Tests only: ```gradlew clean test -PactiveProfile=prod```
