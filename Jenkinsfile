node {
    stage('Git Clone') {
        git poll: true, url: 'https://github.com/solzanirsouza/georreferencia'
    }
    stage('Test') {
        sh 'mvn clean install'
    }
}
