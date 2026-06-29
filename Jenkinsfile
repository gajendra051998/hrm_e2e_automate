pipeline {
    agent any

    tools {
        jdk 'MyJava'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/gajendra051998/hrm_e2e_automate.git'
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
            junit '**/surefire-reports/*.xml'

            publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/cucumber-reports',
                        reportFiles: 'cucumber.html',
                        reportName: 'Cucumber Report'
                    ])
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}