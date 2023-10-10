pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build application'
            }
        }
        stage('Test') {
            steps {
                echo 'Test application'
            }
        }
        stage('Deploye') {
            steps {
                echo 'Deploye application'
            }
        }
    }
    
    post {
        always {
       emailext body: 'Hello', subject: 'Report', to: 'saurabh04kumar@gmail.com'
        }
    }
}
