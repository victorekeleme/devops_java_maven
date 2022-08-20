def gv

pipeline{
    agent any
    tools {
        maven "Maven"
        jdk "my-jdk"
    }
    stages{
        stage("init"){
            steps{
                script{
                    echo "Initializing"
                    gv = load "script.groovy"
                }
            }
        }
        stage("test"){
            steps{
                script{
                    gv.TestApp()

                }
            }
        }
        stage("build jar"){
            steps{
                script{
                    gv.buildJar()

                }
            }
        }
        // stage("build image"){
        //     steps{
        //         script{
        //             gv.buildImage "java-maven-app:2.0"                 
        //         }
        //     }
        // }

        // stage("push to AWS"){
        //     steps{
        //         script{
        //             gv.pushAWS "java-maven-app:2.0"                 
        //         }
        //     }
        // }

        // stage("push to Nexus"){
        //     steps{
        //         script{
        //             gv.pushNexus "java-maven-app:2.0"                 
        //         }
        //     }
        // }
    }
}