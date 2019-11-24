package com.xuerge.jk.stage

class Compile {
    def script

    Compile(script) {
        this.script = script
    }

    run(){
        script.sh 'mvn clean install'
    }
}
