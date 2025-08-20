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
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Stop Old Container') {
            steps {
                script {
                    sh "docker stop ${CONTAINER_NAME} || true"
                    sh "docker rm ${CONTAINER_NAME} || true"
                }
            }
        }

        stage('Run New Container') {
            steps {
                sh "docker run -d --name ${CONTAINER_NAME} -p 8881:8080 ${DOCKER_IMAGE}:${DOCKER_TAG}"
            }
        }
    }
}
