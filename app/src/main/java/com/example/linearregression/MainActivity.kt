package com.example.linearregression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.FileInputStream
import java.io.IOException
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @Throws(IOException::class)
    private fun loadModel(): MappedByteBuffer {

        val fileDescriptor = this.assets.openFd("linearRegressionModel.tflite")

        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)

        val fileChannel = inputStream.channel

        val start = fileDescriptor.startOffset

        val end = fileDescriptor.declaredLength

        return fileChannel.map(FileChannel.MapMode.READ_ONLY, start, end)

    }
}