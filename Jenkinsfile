pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	bat "docker build -t='jileb/selenium-docker' ."
                }
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId:'Docker', passwordVariable:'pass', usernameVariable:'user' )])
                bat "docker login --username=\$(user) --password=\$(pass)"
                bat "docker push jileb/selenium-docker:latest"
                }
            }
        }
    }
}
