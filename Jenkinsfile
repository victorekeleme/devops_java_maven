
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
                }
            }
        }
        stage("test"){
            steps{
                script{
                    echo "Testing"

                }
            }
        }
        stage("build jar"){
            steps{
                script{
                    echo "Building Jar"

                }
            }
        }
        stage("build image"){
            steps{
                script{
                    echo "Building Image"                    
                }
            }
        }
    }
}