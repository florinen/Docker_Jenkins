node{
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'Specify your ip', name: 'IP', trim: true)])])
    stage("Remove Container") {
        try{
            sh "ssh root@IP docker rm -f Flaskex"
        }
    }
    
    stage("Run Container"){
        sh "ssh root@IP docker run -d --name Flaskex -p 4000:4000 florinen/fleskex"
    }
}