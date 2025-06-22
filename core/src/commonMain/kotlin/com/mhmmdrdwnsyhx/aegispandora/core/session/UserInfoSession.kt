package com.mhmmdrdwnsyhx.aegispandora.core.session

object UserInfoSession {
    var email: String? = null
    var username: String? = null
    var securityQuestion: String? = null
    private var securityAnswerHash: String? = null

    fun setRecoveryData(question: String, answer: String) {
        securityQuestion = question
        securityAnswerHash = com.mhmmdrdwnsyhx.aegispandora.core.security.HashUtil.hashPassword(answer)
    }

    fun verifyRecoveryAnswer(answer: String): Boolean {
        return com.mhmmdrdwnsyhx.aegispandora.core.security.HashUtil
            .verifyPassword(answer, securityAnswerHash ?: return false)
    }

    fun clear() {
        email = null
        username = null
        securityQuestion = null
        securityAnswerHash = null
    }
}