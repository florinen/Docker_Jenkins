node{
     properties([parameters([string(defaultValue: '157.230.49.76', description: 'Give ip to build', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'what version would like to deploy', name: 'Ver', trim: true)])])
    stage("Remove Container") {
        try{
            sh "ssh root@${IP} docker rm -f Flaskex"

        }
        catch(exec){
            sh "echo container deleted"

        
        }
    }
    
    stage("Run Container"){
        sh "ssh root@${IP} docker run -d --name Flaskex -p ${PORT}:4000 florinen/flaskex_centos7:${VER}"
    }
}