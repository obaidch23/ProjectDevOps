pipeline {
    agent any
	environment { 
	          registry = "samehslama/spring-app" 
	          registryCredential = 'dockerHub' 
	          dockerImage = 'spring-app' 
	 }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling';
                git branch: 'CategoriePrpduit_management',
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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }

        }
         
       
        stage ('Maven Test JUnit') {
            steps {
                sh "mvn test"
            }
        }
        stage('Docker Build') {

			steps {
				sh 'docker login -u samehslama -p @SlamaSameh@'
				sh 'docker build -t samehslama/spring-app .'
			}
		}
		stage('Docker Push') {

			steps {
				sh 'docker login -u samehslama -p @SlamaSameh@'
				sh 'docker push samehslama/spring-app'
			}
		}
    }
    
    
    
    
    
    

}