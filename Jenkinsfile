pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling';
                git branch: 'main',
                url:'https://github.com/obaidch23/ProjectDevOps.git'
            }
        }
    }
    
    stage ('Maven Clean') {
            steps {

                sh 'mvn clean'
            }
        }
        stage ('Maven Compile') {
            steps {

                sh 'mvn compile'
            }
        }
          stage ('Maven Build') {
            steps {

                sh 'mvn clean install'
            }
        }
}
