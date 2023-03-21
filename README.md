# Summary 👋
This repo was mainly to meant to be a fun project to ramp up on some technologies I used extensively previously (mainly Kubernetes, Helm, Terraform). The muscle memory is coming back as I build this out haha.

Below is some components that make up this project.

**Note:** due to time a couldn't create exactly everthing I wanted, but will continue to build this out more extensively (have some ideas besides the infra diagram hosting). The first thing I'll likely add after is CI/CD, want to try using Jenkins and contrast that with Github actions (I've heard good things of both but mainly used Gitlab CI and Amazons internal CI/CD tools).

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
