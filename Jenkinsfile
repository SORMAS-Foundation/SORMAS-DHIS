
    
	

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
                    sh """
                    sudo buildah bud --pull-always --no-cache -t sorams-dhis2 DockerController/
                    sudo buildah login -u $DOCKERHUB_CREDS_USR -p $DOCKERHUB_CREDS_PSW docker.io
                    #sudo buildah push -f v2s2 sorams-dhis2p hzibraunschweig/sorams-dhis2:latest
                    """
                }
            }

        }

    }
}

