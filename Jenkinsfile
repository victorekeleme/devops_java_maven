def gv

pipeline{
    agent any
    tools {
        maven "Maven"
    }
    stages{
        stage("init"){
            steps{
                script{
                    echo "Initializing"
                    gv = load "script.groovy"
                }
            }
        }
        stage("test"){
            steps{
                script{
                    gv.TestApp()

                }
            }
        }
        stage("build jar"){
            steps{
                script{
                    gv.buildJar()

                }
            }
        }
        stage("build image"){
            steps{
                script{
                    gv.buildImage "vistein12/java-maven-app:1.0"                 
                }
            }
        }

        stage("push to AWS"){
            steps{
                script{
                    gv.pushAWS "vistein12/java-maven-app:1.0"                 
                }
            }
        }
    }
}