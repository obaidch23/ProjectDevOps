pipeline {
    agent any
	
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling';
                git branch: 'facture-management',
                url:'https://github.com/obaidch23/ProjectDevOps.git'
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
       stage ('Maven Test Sonar') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=12345***'
            }

        }
         
       
        stage ('Maven Test JUnit') {
            steps {
                sh 'mvn test'
            }
        }
        		
		
        
        stage('Docker-Compose Up') {

			steps {
				sh 'docker-compose up'
			}
		}


		
		
    }
    
}