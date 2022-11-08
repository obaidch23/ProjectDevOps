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
}