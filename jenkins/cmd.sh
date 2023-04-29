docker pull jenkins/jenkins:2.332.1

docker volume create jenkins-data

docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home jenkins/jenkins:2.332.1

docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword

d13475e34c1c4ceabe683b80297ef37a


docker network create jenkins
docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home --network jenkins jenkins-mpierre 



docker run -d --name docker-jenk --restart=always -p 127.0.0.1:2376:2375 --network jenkins -v /var/run/docker.sock:/var/run/docker.sock alpine/socat tcp-listen:2375,fork,reuseaddr unix-connect:/var/run/docker.sock

docker inspect docker-jenk | grep IPAddress


172.18.0.3