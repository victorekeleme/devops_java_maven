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

        stage("commit version"){
           steps{
                script{
                    sshagent(credentials: ['git-ssh']) {
                        sh "git branch"
                        sh "git status"
                        
                        sh "git remote set-url origin git@github.com:victorekeleme/devops_java_maven.git"
                        sh "git add ."
                        sh 'git commit -m "ci: version bump"'
                        sh "git push origin HEAD:jenkins/class"
                        }
                }
            }
        }

    }
}