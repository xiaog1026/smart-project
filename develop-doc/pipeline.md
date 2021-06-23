```groovy
pipeline {
    agent any
    parameters { 
        booleanParam(name: 'testFlg', defaultValue: true, description: '') 
    }

    stages {
        stage('compile') {
            steps {
                echo 'compile start'
            }
        }
        stage('test') {
            parallel {
                stage('test-1') {
                    when {
                        expression { params.testFlg }
                    }
                    steps {
                        echo 'compile start1'
                    }
                }
                stage('test-2') {
                    when {
                        expression { !params.testFlg }
                    }
                    steps {
                        echo 'compile start2'
                    }
                }
            }
        }
        stage('release') {
            steps {
                echo 'release start'
            }
        }
    }
}
```
