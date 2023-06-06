FROM node:alpine as builder

COPY package.json package-lock.json ./

RUN npm i --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 \
 reactstrap@8.10.0 axios && mkdir /app && mv ./node_modules ./app

WORKDIR /app

COPY . .

RUN npm run build

FROM nginx:alpine
COPY docker/nginx.conf /etc/nginx/nginx.conf
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/build /usr/share/nginx/html

EXPOSE 3000 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]