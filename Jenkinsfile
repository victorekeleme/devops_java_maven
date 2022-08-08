def gv

pipeline{
    agent any
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
                    //gv.buildAppJar()
                }
                
            }
        }
        stage("build image"){
            steps {
                script{
                    echo "Building application Image"
                    //gv.buildAppImage()
                }
            }
        }
        stage("deploy"){
            input{
                message "Select the environment to deploy to"
                ok "Done"
                parameters {
                    choice(name: 'ENV', choices: ['dev','staging','prod'], description:'')
                }
            }
            
            steps{
                script{
                    //gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }

}
