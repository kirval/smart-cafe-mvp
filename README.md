### RUN POSTGRES DOCKER CONTAINER

```
docker run -d --restart unless-stopped -p 5432:5432 --name sc-mvp-postgres -e POSTGRES_DB=sc-mvp -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres postgres:12
```

### HOW TO RUN:

#### Dev profile:
1. Default (with tests): ```gradlew clean build bootRun -Pprofile=dev```
2. Skipping tests: ```gradlew clean build bootRun -PskipTest -Pprofile=dev```
2. Tests only: ```gradlew clean test -Pprofile=dev```

#### Prod profile:
1. Default (with tests): ```gradlew clean build bootRun -Pprofile=prod```
2. Skipping tests: ```gradlew clean build bootRun -PskipTest -Pprofile=prod```
2. Tests only: ```gradlew clean test -Pprofile=prod```
