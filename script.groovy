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

    // sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"
    withCredentials([aws(accessKeyVariable:'AWS_ACCESS_KEY_ID',credentialsId:'aws-credentials',secretKeyVariable:'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin 524360703326.dkr.ecr.us-east-2.amazonaws.com"   
        sh "docker build -t $IMAGE_NAME ."
        sh "docker tag $IMAGE_NAME 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"
        sh "docker push 524360703326.dkr.ecr.us-east-2.amazonaws.com/$IMAGE_NAME"
    }

}

def pushNexus(String IMAGE_NAME){
    sh "echo Pushin to Nexus"
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh "docker build -t $IMAGE_NAME"
    sh "echo $PASS | docker login -u $USER --password-stdin 159.203.37.16:8083"
    sh "docker push 159.203.37.16:8083/$IMAGE_NAME"
    }
    

}

return this