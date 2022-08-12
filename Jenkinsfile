@Library('jenkins-shared-library')

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
                    buildImage 'vistein12/java-maven-app:2.5'
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
