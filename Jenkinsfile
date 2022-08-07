def gv

pipeline{
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.0','1.1','1.2'], description: 'Choose the version you want')
    }

    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
                
            }
        }
        stage("test"){
            steps {
                script{
                    gv.testApp()
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
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }

}
 
