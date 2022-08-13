def gv

pipeline{
    agent any

    tools {
        maven 'Maven-3.8.6'
    }

    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Version increment"){
            steps{
                script{
                    sh "mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit"
                    
                    def matchVersion = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matchVersion[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage("test"){
            steps{
                script {
                    gv.TestApp()
                }
            }
        }

        stage("build jar"){
            steps{
                script{
                    echo "Building application Jar"
                    buildJar()
                }
            }
        }
        stage("build image"){
            steps {
                script{
                    echo "Building application Image"
                    buildImage "vistein12/java-maven-app:$IMAGE_NAME"
                }
            }
        }
        stage("deploy"){            
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }

}
