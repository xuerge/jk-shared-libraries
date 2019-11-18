package com.xuerge.jk.stage
class SCM {
    def script

    SCM(script) {
        this.script = script
    }

    public void checkOutFrom() {
        git url: "https://github.com/xuerge/demo"
    }

    Map gitCheckout() {
        script.stage ("SCM") {
            def scmVars = script.checkout(
                    [$class                           : 'GitSCM',
                     branches                         : [[name: '*/master']],
                     doGenerateSubmoduleConfigurations: false,
                     extensions                       : [],
                     submoduleCfg                     : [],
                     userRemoteConfigs                : [[url: 'https://github.com/xuerge/demo']]]
            )
            return scmVars
        }

    }
}