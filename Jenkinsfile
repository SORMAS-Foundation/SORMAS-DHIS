
    
	

pipeline {
    agent any
    environment {
        MVNHOME = tool 'Maven'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                dir('sormas_HL7v2') {
                    sh "${MVNHOME}/bin/mvn clean compile"
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

