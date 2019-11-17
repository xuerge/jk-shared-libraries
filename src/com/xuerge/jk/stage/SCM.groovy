package com.xuerge.jk.stage

def checkOutFrom() {
    git url: "https://github.com/xuerge/demo"
}



Map gitCheckout() {
    def scmVars = script.checkout(
            [$class: 'GitSCM',
             branches: [[name: '*/master']],
             doGenerateSubmoduleConfigurations: false,
             extensions: [],
             submoduleCfg: [],
             userRemoteConfigs: [[url: 'https://github.com/xuerge/demo']]]
    )
    return scmVars
}
return this
