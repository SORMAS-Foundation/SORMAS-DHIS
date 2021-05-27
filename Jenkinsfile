pipeline {
    
    node('master') {
        def mvnHome = tool 'Maven'
        stages {
	        stage('Build') {
	            steps {
	                echo 'Building..'
	                dir('sormas_HL7v2') {
	                    sh "${mvnHome}/bin/mvn clean compile"
	                }
	
	            }
	        }
	        stage('Test') {
	            steps {
	                echo 'Testing..'
	            }
	        }
	        stage('Deploy') {
	            steps {
	                echo 'Deploying....'
	            }
	        }
   		}
    }

    
}