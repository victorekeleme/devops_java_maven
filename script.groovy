def TestApp(){
    echo "Testing the application"
    sh "mvn test"
}

// def buildAppJar() {
//     echo "Building the application jar"
//     sh "mvn package"
// }
// def buildAppImage() {
//     echo "Building the application docker image"
//     withCredentials([usernamePassword(credentialsId: 'Docker-Repo-Credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
//         sh "docker build -t vistein12/java-maven-app:${VERSION} ."
//         sh "echo $PASS | docker login -u $USER --password-stdin"
//         sh "docker push vistein12/java-maven-app:${VERSION}"
//     }
// }
def deployApp() {
    echo "Deploying the application"
    
}

return this