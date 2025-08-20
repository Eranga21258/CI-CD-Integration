pipeline {
    agent any

    environment {
        IMAGE_NAME = "kubeeranga118/cicd-integration"
        CONTAINER_NAME = "cicd-container"
    }

    stages {
        stage('SCM Checkout') {
            steps {
                cleanWs()
                retry(3) {
                    git branch: 'main', url: 'https://github.com/Eranga21258/CI-CD-Integration'
                }
            }
        }

        stage('Build Jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE_NAME%:%BUILD_NUMBER% ."
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
                bat "docker push %IMAGE_NAME%:%BUILD_NUMBER%"
            }
        }

        stage('Stop & Remove Old Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || echo Container not running'
                bat 'docker rm %CONTAINER_NAME% || echo Container not found'
            }
        }

        stage('Run New Container') {
            steps {
                bat "docker run -d -p 8881:8881 --name %CONTAINER_NAME% %IMAGE_NAME%:%BUILD_NUMBER%"
            }
        }
    }

    post {
        always {
            bat 'docker logout'
        }
    }
}
