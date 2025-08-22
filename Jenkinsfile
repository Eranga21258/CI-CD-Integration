pipeline {
    agent any

    tools {
        maven 'maven_3_8_6'
    }

    stages {
        stage('SCM Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Eranga21258/CI-CD-Integration'
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    bat "docker build -t kubeeranga118/devops-integration ."
                }
            }
        }

        stage('Push Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'DOCKER_HUB_PWD')]) {
                        // Login to Docker Hub
                        bat "docker login -u kubeeranga118 -p %DOCKER_HUB_PWD%"

                        // Push the image directly
                        bat "docker push kubeeranga118/devops-integration"
                    }
                }
            }
        }
    }
}
