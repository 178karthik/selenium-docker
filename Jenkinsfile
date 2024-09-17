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
           bat "docker build -t=178karthik/selenium-dockerize ."
        }
         }
         stage('stage-3'){
            steps{
            bat "docker push 178karthik/selenium-dockerize"
        }

         }
    }

}