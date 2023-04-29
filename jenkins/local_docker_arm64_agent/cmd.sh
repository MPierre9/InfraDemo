docker build -t jenkins-agent-arm .

docker run -d --name jenkins-agent-arm --restart=always -p 127.0.0.1:2376:2375 --network jenkins -v /var/run/docker.sock:/var/run/docker.sock jenkins-agent-arm
docker inspect jenkins-agent-arm | grep IPAddress
