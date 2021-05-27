
   


node {
    
    environment {
        
        DOCKERHUB_CREDS = credentials('dockerhub')
    }

    def pom = readMavenPom file: 'sormas_HL7v2/pom.xml'
    def mvn = tool 'Maven'
        
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
            
            sh """cp target/sormas_HL7v2-${pom.version}.war DockerController/sormas_HL7v2.war
            sudo buildah bud --pull-always --no-cache -t sormas-dhis2 DockerController/
            sudo buildah login -u '${DOCKERHUB_CREDS_USR}' -p '${DOCKERHUB_CREDS_PSW}' docker.io
            sudo buildah push -f v2s2 sormas-dhis2 hzibraunschweig/sormas-dhis2:latest
            sudo buildah push -f v2s2 sormas-dhis2 hzibraunschweig/sormas-dhis2:${pom.version}
            """
        }

    }

   
}

