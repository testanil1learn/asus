pipeline {
    agent any

    tools {
        jdk 'Java SE Development kit 21'
        maven 'Maven-3.9.6'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/users/testanil1learn/project1/your-repo.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.html', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
