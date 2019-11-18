package com.xuerge.jk

class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    def checkout(args) {
        steps.checkout(
                [$class                           : 'GitSCM',
                 branches                         : [[name: '*/master']],
                 doGenerateSubmoduleConfigurations: false,
                 extensions                       : [],
                 submoduleCfg                     : [],
                 userRemoteConfigs                : [[url: 'https://github.com/xuerge/demo']]]
        )
    }
}
