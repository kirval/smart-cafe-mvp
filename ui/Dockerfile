# ---- Базовый Node ----
FROM node:carbon AS base
# Создать директорию app
WORKDIR /app

# ---- Зависимости ----
FROM base AS dependencies
# Используется символ подстановки для копирования как package.json
COPY package.json ./
# Установить зависимости приложения, включая предназначенные для разработки ('devDependencies')
RUN npm install

# ---- Скопировать файлы/билд ----
FROM dependencies AS build
WORKDIR /app
COPY ./ ./
# Собрать статические файлы
RUN npm run build

# --- Выпуск, используя Alpine ----
FROM node:alpine AS release

COPY --from=build /app/build ./cafe

RUN npm -g install serve

EXPOSE 3000
CMD ["serve", "-s", "cafe", "-p", "3000"]
