# Summary 👋
This repo was mainly to meant to be a fun project to ramp up on some technologies I used extensively previously (mainly Kubernetes, Helm, Terraform). The muscle memory is coming back as I build this out haha.

Below is some components that make up this project.

**Note:** due to time a couldn't create exactly everthing I wanted, but will continue to build this out more extensively (have some ideas besides the infra diagram hosting). The first thing I'll likely add after is CI/CD, want to try using Jenkins and contrast that with Github actions (I've heard good things of both but mainly used Gitlab CI and Amazons internal CI/CD tools). There's a lot of commits as well because I'm using a bastion host to run kubectl and helm commands that pulls this repo.

# Components

## Java Spring
Though I have used Java in the past, recently to build some smoke tests for AWS RDS before launching in a new region. I haven't used Spring Boot at all so I used this repo spring-boot: https://github.com/spring-guides/gs-spring-boot to get started with my first web app. The web app essentially hosts the infra diagram behind a lax password mechanism.

You can find the code in `gs-spring-boot/initial/src/main/java/com/example/springboot`. For the sake of time I kept most of the names the same (i.e java.com.example.springboot). 

## Kubernetes
Running a super small k8s setup in EKS, just one node to keep costs extremely low for this. You can find the terraform code for that in the terraform dir. I haven't used terragrunt before so I tried that out, maybe not as useful for the size of this but at scale it makes sense.

## Helm
A super simple helm template is used to deploy the java spring app in k8s. That implementation is in the helm folder.

## Terraform
Contains the IaC to deploy the tiny EKS cluster that the java spring app runs in.


# Random Command List Used
```
# Created kube config
aws eks --region us-east-1 update-kubeconfig --name game-infra

# Run Spring app (/gs-spring-boot/initial)
./mvnw spring-boot:run

# mvn package (creates the jar file)

# build image
docker build -t guerrilla-web-app .

# Log in to the container registry
# Example: Amazon ECR
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 821777302053.dkr.ecr.us-east-1.amazonaws.com/mpierre

# Tag the image
docker tag guerrilla-web-app 821777302053.dkr.ecr.us-east-1.amazonaws.com/mpierre:guerrilla-web-app

# Push the image
docker push 821777302053.dkr.ecr.us-east-1.amazonaws.com/mpierre:guerrilla-web-app

# Helm install
helm install infra-web-app .

# Helm upgrade
helm upgrade infra-web-app .

# Get kube pod details 
k describe pods infra-web-app-6748c547b7-hqdpp

# get container logs in pod
k logs infra-web-app-6748c547b7-hqdpp infra-web-app

# delete pod 
k delete pod infra-web-app-6748c547b7-hqdpp

# local testing
docker run -itd -p 8080:8080 --name guerrilla-web-app guerrilla-web-app
```