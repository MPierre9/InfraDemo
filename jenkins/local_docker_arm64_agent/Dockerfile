FROM arm64v8/alpine:latest

RUN apk add --no-cache socat

ENTRYPOINT ["socat", "TCP-LISTEN:2375,fork,reuseaddr", "UNIX-CONNECT:/var/run/docker.sock"]
