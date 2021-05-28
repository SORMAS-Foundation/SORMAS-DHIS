node {
    def pom = readMavenPom file: 'sormas_HL7v2/pom.xml'
    def mvn = tool 'Maven'
        
    stage('checkout') {
        git branch: 'SORGEN-87', url: 'https://github.com/hzi-braunschweig/SORMAS-DHIS.git'
    }
    
        
    stage('Build') {
        echo 'Building..'
        dir('sormas_HL7v2') {
            sh "${mvn}/bin/mvn clean compile"
        }
    }
    stage('Test') {
        echo 'Testing..'
        dir('sormas_HL7v2') {
            sh "${mvn}/bin/mvn clean compile test"
        }
    }
    stage('Package') {
        echo 'Packaging....'
        dir('sormas_HL7v2') {
            sh "${mvn}/bin/mvn clean compile package"
        }
    }
    stage('Deploy') {
        echo 'Deploying....'
        
        dir('sormas_HL7v2') {
            withCredentials([ usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKERUSER', passwordVariable: 'DOCKERPASS' )]) {
            	sh """cp target/sormas_HL7v2-${pom.version}.war DockerController/sormas_HL7v2.war
	            sudo buildah bud --pull-always --no-cache -t sormas-dhis2 DockerController/
	            sudo buildah login -u '${DOCKERUSER}' -p '${DOCKERPASS}' docker.io
	            sudo buildah push -f v2s2 sormas-dhis2 hzibraunschweig/sormas-dhis2:latest
	            sudo buildah push -f v2s2 sormas-dhis2 hzibraunschweig/sormas-dhis2:${pom.version}
	            """                                                                                                                 
            }
        }
    }
}
