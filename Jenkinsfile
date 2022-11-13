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
<<<<<<< HEAD
<<<<<<< HEAD
    
    stage ('Maven Test Sonar') {
=======
       stage ('Maven Test Sonar') {
>>>>>>> c92db873f10f9a0688954cca5360dbc59557923e
=======
       stage ('Maven Test Sonar') {
>>>>>>> c92db873f10f9a0688954cca5360dbc59557923e
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=12345***'
            }

        }
         
       
        stage ('Maven Test JUnit') {
            steps {
                sh "mvn test"
            }
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======
    }
    
>>>>>>> c92db873f10f9a0688954cca5360dbc59557923e
=======
    }
    
>>>>>>> c92db873f10f9a0688954cca5360dbc59557923e
}
