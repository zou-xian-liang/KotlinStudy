package com.zxl.kotlin

import java.io.File

class FileUtils {

    fun main(args: Array<String>) {
        val fileNames: MutableList<String> = mutableListOf()
        //在该目录下走一圈，得到文件目录树结构
        val fileTree: FileTreeWalk = File("E:\\Decompile\\apkTool_New\\mingyuan\\lib\\armeabi-v7a").walk()
        fileTree.maxDepth(1) //需遍历的目录层次为1，即无须检查子目录
            .filter { it.isFile } //只挑选文件，不处理文件夹
//        .filter { it.extension == "txt"  } //选择扩展名为txt的文本文件
            .filter { it.extension in listOf("txt","mp4") }//选择扩展名为txt或者mp4的文件
            .forEach { fileNames.add(it.name) }//循环 处理符合条件的文件
        fileNames.forEach(::println)
    }
}