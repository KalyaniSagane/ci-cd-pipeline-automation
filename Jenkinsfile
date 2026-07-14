pipeline {
    agent any

    environment {
        IMAGE_NAME = "kalyani/ci-cd-pipeline-automation"
        IMAGE_TAG  = "${BUILD_NUMBER}"
        TOMCAT_URL = "http://localhost:8081"
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Building application using Maven...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker image to registry...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push ${IMAGE_NAME}:${IMAGE_TAG}'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying application container...'
                sh 'docker run -d -p 8081:8080 --name demo-app-${BUILD_NUMBER} ${IMAGE_NAME}:${IMAGE_TAG}'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! Application deployed.'
        }
        failure {
            echo 'Pipeline failed. Check logs above for details.'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}
