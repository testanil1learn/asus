pipeline {
    agent any

    tools {
        jdk 'Java SE Development kit 21'
        maven 'Maven-3.9.6'
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Select browser')
        choice(name: 'ENV', choices: ['qa', 'stage'], description: 'Select environment')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/testanil1learn/asus.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat """
                    mvn clean test ^
                    -Dbrowser=${params.BROWSER} ^
                    -Denv=${params.ENV}
                """
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**', fingerprint: true
            junit 'target/surefire-reports/*.xml'
            echo 'Pipeline execution completed'
        }

        failure {
            echo 'Tests failed ❌ – please check reports'
        }

        success {
            echo 'Build and tests successful ✅'
        }
    }
}
