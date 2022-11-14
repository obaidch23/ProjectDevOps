pipeline {
    agent any
	environment { 
          registry = "kharroubi/spring-app" 
          registryCredential = 'dockerHub' 
          dockerImage = 'spring-app' 
 }
	
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
        		
		
        
      
		
		stage('Login') {

			steps {

				sh 'docker login -u kharroubi -p 123456***'
			}
        }
        
        stage('Build docker') {

			steps {
				sh 'docker build -t kharroubi/spring-app .'
			}
		}
		
		stage('Push docker') {

			steps {
				sh 'docker push kharroubi/spring-app'
			}
		}


		
		
    }
    
}