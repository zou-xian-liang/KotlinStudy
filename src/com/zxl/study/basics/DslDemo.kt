package com.zxl.study.basics

import java.io.File

/**
 * DSL：领域特定语言，一种API编程范式，暴露接收者的函数和特性，以便于使用你定义的lambda表达式来读取和配置他们
 */

val file = File("").apply {
    setReadable(true)
}

