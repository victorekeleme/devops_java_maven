def gv

pipeline{

    agent any
    tools {
        maven 'maven-3.8.6'
    }

    stages{
        stage('init'){
            steps{
                script{
                    echo 'initializing'
                    gv = load "script.groovy"
                }
            }
        }

        stage('version increment'){
            steps{
                script{
                    gv.versionIncrement()
                }
            }
        }

        stage('test'){
            steps{
                script{
                    gv.testJar()
                }
            }
        }

        stage('build'){
            steps{
                script{
                    gv.buildJar()
                }
            }
        }

    }
}
