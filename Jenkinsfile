pipeline {
    agent any

    stages {
        stage('SCM Checkout') {
            steps {
                retry(3) {
                    git branch: 'main', url: 'https://github.com/Eranga21258/CI-CD-Integration'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t kubeeranga118/cicd-integration:%BUILD_NUMBER% .'
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'CICD-Integration-Password', variable: 'CICD_PASSWORD')]) {
                    bat 'docker login -u kubeeranga118 -p "%CICD_PASSWORD%"'
                }
            }
        }

        stage('Push Image') {
            steps {
                bat 'docker push kubeeranga118/cicd-integration:%BUILD_NUMBER%'
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
}