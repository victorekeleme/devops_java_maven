def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Docker-Repo-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vistein12/java-maven-app:2.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push vistein12/java-maven-app:2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this