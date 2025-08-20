// pipeline {
//     agent any
//
//     environment {
//         DOCKER_IMAGE = "cicd_demo_app"
//         DOCKER_TAG = "latest"
//         CONTAINER_NAME = "cicd_demo_container"
//     }
//
//     stages {
//         stage('Checkout Code') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/Eranga21258/CI-CD-Integration'
//             }
//         }
//
//         stage('Build with Maven') {
//             steps {
//                 bat 'mvn clean package -DskipTests'
//             }
//         }
//
//         stage('Build Docker Image') {
//             steps {
//                 bat "docker build -t %DOCKER_IMAGE%:%DOCKER_TAG% ."
//             }
//         }
//
//         stage('Stop Old Container') {
//             steps {
//                 bat "docker stop %CONTAINER_NAME% || exit 0"
//                 bat "docker rm %CONTAINER_NAME% || exit 0"
//             }
//         }
//
//         stage('Run New Container') {
//             steps {
//                 bat "docker run -d --name %CONTAINER_NAME% -p 8881:8881 %DOCKER_IMAGE%:%DOCKER_TAG%"
//             }
//         }
//     }
// }
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
                bat 'docker build -t Eranga Tennakoon/cicd-integration:%BUILD_NUMBER% .'
            }
        }
        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'CICD-Integration-Password', variable: 'CICD Integration')]) {
                    script {
                        bat "docker login -u Eranga Tennakoon -p %CICD Integration#%"
                    }
                }
            }
        }
        stage('Push Image') {
            steps {
                bat 'docker push Eranga Tennakoon/cicd-integration:%BUILD_NUMBER%'
            }
        }
    }
    post {
        always {
            bat 'docker logout'
        }
    }
}