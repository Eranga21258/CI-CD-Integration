pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "cicd_demo_app"
        DOCKER_TAG = "latest"
        CONTAINER_NAME = "cicd_demo_container"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Eranga21258/CI-CD-Integration'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %DOCKER_IMAGE%:%DOCKER_TAG% ."
            }
        }

        stage('Stop Old Container') {
            steps {
                bat "docker stop %CONTAINER_NAME% || exit 0"
                bat "docker rm %CONTAINER_NAME% || exit 0"
            }
        }

        stage('Run New Container') {
            steps {
                bat "docker run -d --name %CONTAINER_NAME% -p 8881:8881 %DOCKER_IMAGE%:%DOCKER_TAG%"
            }
        }
    }
}
