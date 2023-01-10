pipeline{

    agent any
    tools {
        maven 'maven-3.8.6'
    }

    stages{
        
        stage('test'){
            steps{
                script{
                    sh 'mvn test'
                }
            }
        }

        stage('build'){
            steps{
                script{
                    sh 'mvn clean package'
                }
            }
        }

    }
}
