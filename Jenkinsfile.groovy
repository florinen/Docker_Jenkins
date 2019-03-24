node{
    properties([parameters([string(defaultValue: '157.230.49.76', description: 'Docker Host', name: 'IP', trim: false), string(defaultValue: 'latest', description: 'What version to run', name: 'VER', trim: false), string(defaultValue: '4000', description: 'chose the port', name: 'PORT', trim: false)])])
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