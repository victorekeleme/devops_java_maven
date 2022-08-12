@Library('jenkins-shared-library')

def gv

pipeline{
    agent none
    parameters {
        choice(name: 'VERSION', choices: ['1.0','1.1','2.0','2.1'], description: 'Choose the version you want')
    }
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
                    BRANCH_NAME == "main"
                }
            } 
            steps{
                script{
                    echo "Building application Jar"
                    buildJar()
                }
                
            }
        }
        stage("build image"){
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            } 
            steps {
                script{
                    echo "Building application Image"
                    buildImage()
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
