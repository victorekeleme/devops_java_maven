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
            when {
                expression {
                    BRANCH_NAME == "jenkins-job"
                }
            } 
            steps{
                script{
                    buildJar()
                }
            }
        }
        stage("build image"){
            when {
                expression {
                    BRANCH_NAME == "jenkins-job"
                }
            } 
            steps {
                script{
                    buildImage 'vistein12/java-maven-app:1.4'
                }
            }
        }
        stage("deploy") {
            steps{
                script{ 
                    gv.deployApp()
                }
            }
        }
    }

}
 
