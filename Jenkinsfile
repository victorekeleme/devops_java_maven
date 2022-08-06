pipeline{
    agents any
    parameters {
        choice(name: 'VERSION', choices: ['1.0','1.1','1.2'], description: 'Choose the version you want')
    }

    stages{
        stage("init"){
            steps{
                echo "Initializing"
            }
        }

        stage("build"){
            steps{
                echo "Building the application"
            }
        }
        stage("test"){
            steps{
                echo "Testing the application"
            }
        }
        stage("deploy"){
            steps{
                echo "Deploying the application"
                echo "deploying version: ${params.VERSION}"
            }
        }
    }

}
 