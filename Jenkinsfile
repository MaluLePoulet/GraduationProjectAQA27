pipeline {
    agent any

    tools {
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'feature/Jenkins', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/MaluLePoulet/GraduationProjectAQA27.git'
            }
        }
        stage('Test') {
            steps {
                sh "mvn clean test"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}