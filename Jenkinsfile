
    
	

pipeline {
    agent any
    environment {
        MVNHOME = tool 'Maven'
        DOCKERHUB_CREDS = credentials('dockerhub')
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
                dir('sormas_HL7v2') {
                    sh "${MVNHOME}/bin/mvn clean compile test"
                }
                
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging....'
                dir('sormas_HL7v2') {
                    sh "${MVNHOME}/bin/mvn clean compile package"
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                dir('sormas_HL7v2') {
                    sh "cp target/sormas_HL7v2-1.0.0.war DockerController/sormas_HL7v2.war"
                    sh "sudo buildah bud --pull-always --no-cache -t sormas-dhis2 DockerController/"
                    sh "sudo buildah login -u '${DOCKERHUB_CREDS_USR}' -p '${DOCKERHUB_CREDS_PSW}' docker.io"
                    sh "sudo buildah push -f v2s2 sormas-dhis2 hzibraunschweig/sormas-dhis2:latest"
                    
                }
            }

        }

    }
}

