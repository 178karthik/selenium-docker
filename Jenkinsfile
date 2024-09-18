pipeline{

    agent any

    stages{
        stage('Build Jar'){
            steps{
                  bat "mvn clean package -DskipTests"
            }
        }
         stage('Build Image'){
            steps{
           bat "docker build -t=178karthik/selenium-dockerize:latest ."
        }
         }
         stage('Push Image'){
         environment{
         DOCKER_HUB = credentials('dockerhub-creds')
         }
            steps{
            bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
            bat "docker push 178karthik/selenium-dockerize:latest"
            bat "docker tag 178karthik/selenium-dockerize:latest 178karthik/selenium-dockerize:${env.BUILD_NUMBER}"
            bat "docker push 178karthik/selenium-dockerize:${env.BUILD_NUMBER}"
        }

         }
    }
         post{
         always{
             bat "docker logout"
         }
         }
    }

