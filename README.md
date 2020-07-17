### RUN POSTGRES DOCKER CONTAINER

```
docker run -d --restart unless-stopped -p 5432:5432 --name sc-postgres -e POSTGRES_DB=smart-cafe -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password postgres:12
```

### RUN REDIS DOCKER CONTAINER

```
docker run -d --restart unless-stopped -p 6379:6379 --name sc-redis-session-cache redis:6
```

### ВАЖНО!
1. При локальном запуске, везде (ajax запросы, адресная строка браузера и тд) 
вместо `localhost` использовать `127.0.0.1`. 
Это нужно для того, чтобы браузер правильно выставлял куки и работал CORS.

