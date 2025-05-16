pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-21-alpine'
        }
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Ariyaan321/spring-rest-api.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        // stage('Deploy to EC2') {
        //     steps {
        //         sh '''
        //         scp -i your-key.pem target/*.jar ec2-user@your-ec2-ip:/home/ec2-user/
        //         ssh -i your-key.pem ec2-user@your-ec2-ip 'nohup java -jar /home/ec2-user/*.jar > output.log 2>&1 &'
        //         '''
        //     }
        // }
    }
}
