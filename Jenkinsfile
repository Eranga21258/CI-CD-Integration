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
                    bat "docker build -t kubeeranga118/devops-integration ."
                }
            }
        }

        stage('Push Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'DOCKER_HUB_PWD')]) {
                        bat "docker login -u kubeeranga118 -p %DOCKER_HUB_PWD%"
                        bat "docker push kubeeranga118/devops-integration"
                    }
                }
            }
        }

        stage('Deploy Container') {
            steps {
                script {
                    // Stop old container if running
                    bat "docker stop devops-container || exit 0"
                    bat "docker rm devops-container || exit 0"

                    // Run new container
                    bat "docker run -d -p 8881:8881 --name devops-container kubeeranga118/devops-integration"
                }
            }
        }
    }
}
