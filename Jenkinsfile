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
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }

}
 