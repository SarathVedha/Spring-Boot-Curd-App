pipeline {
    agent any
    tools{
        maven 'Maven'
    }

    stages {
        stage('Build Maven') {
            steps {
                echo "Running ${env.JOB_NAME} Build ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo 'Building Maven'
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHub', url: 'https://github.com/SarathVedha/Java-Spring-Curd-App.git']])
                bat 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Build Docker Image') {
            steps {
                echo "Running ${env.JOB_NAME} Build ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo 'Building Docker Image'
                bat 'docker build -t spring-app:%BUILD_NUMBER% .'
            }
        }
    }
}
