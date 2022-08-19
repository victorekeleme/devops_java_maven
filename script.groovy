def TestApp(){
    echo "Testing Application"
    sh "mvn test"
}

def buildJar(){
    echo "Building Jar"
    sh "mvn package"
}

def buildImage(String IMAGE_NAME){
    echo "Building Docker Image"
    sh "docker build -t $IMAGE_NAME ."

    withCredentials([usernamePassword(credentialsId:'docker-credentials', passwordVariable:'PASS', usernameVariable:'USER')]){
        sh "echo $PASS | docker login -u $USER --password-stdin"
    }
    sh "docker push $IMAGE_NAME"

}

def pushAWS(String IMAGE_NAME){
    echo "Pushing Docker Image to AWS"
    withAWS(credentials:'aws-credentials', region: us-east-1){
        sh "aws configure"
        sh "aws ecr get-login-password --region us-east-2 | docker login --username USER --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"
    }
    sh "docker tag $IMAGE_NAME 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"
    sh "docker push 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"


}

// def pushAWS(String IMAGE_NAME){
//     echo "Pushing to AWS ECR"


// }

return this

