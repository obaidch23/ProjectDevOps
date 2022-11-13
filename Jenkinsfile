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
        		
		stage('NEXUS'){
            steps{
                echo "nexus"
                sh ' mvn deploy -DskipTests=true'
                sh 'mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file 
                -DgroupId=com.esprit.examen -DartifactId=tpAchatProject 
                -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar 
                -DrepositoryId=deploymentRepo 
                -Durl=http://192.168.1.20:8081/repository/maven-releases/ 
                -Dfile=target/tpAchatProject-1.0.jar"
            }
        }

		
		
    }
    
}