pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build applicationS'
            }
        }
        stage('Test') {
            steps {
                echo 'Test application periodically after every commit'
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
