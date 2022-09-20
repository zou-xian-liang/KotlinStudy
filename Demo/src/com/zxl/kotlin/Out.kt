package com.zxl.kotlin

sealed class Out {
    object t : Out() {

    }

    var ty = ""

    class One:Out()
    class Two:Out()
}