node {
    
	
	
	
	def mvnHome = tool 'Maven'
	
	pipeline {
	    agent any
	    
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