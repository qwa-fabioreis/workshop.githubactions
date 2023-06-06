FROM node:alpine as builder

COPY package.json package-lock.json ./

RUN npm i --save && mkdir /app && mv ./node_modules ./app

WORKDIR /app

COPY . .

RUN npm run build

FROM nginx:alpine
COPY docker/nginx.conf /etc/nginx/nginx.conf
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/build /usr/share/nginx/html

EXPOSE 3000

ENTRYPOINT ["nginx", "-g", "daemon off;"]