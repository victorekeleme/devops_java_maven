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
<<<<<<< HEAD
                    echo "Building App jar"
                    //gv.buildAppJar()
=======
                    buildjar()
>>>>>>> 382ef27 (jenkinsfile and script updated)
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
<<<<<<< HEAD
                    echo "Building app image"
                    //gv.buildAppImage()
=======
                    buildimage()
>>>>>>> 382ef27 (jenkinsfile and script updated)
                }
            }
        }
        stage("deploy"){
            steps{
                script{ 
<<<<<<< HEAD
                    //gv.deployApp()
                    echo "Deploying to ${ENV}"
=======
                    gv.deployApp()
>>>>>>> 382ef27 (jenkinsfile and script updated)
                }
            }
        }
    }

}
 
