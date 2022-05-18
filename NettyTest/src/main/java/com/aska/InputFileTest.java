package com.aska;

import io.netty.buffer.ByteBuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Aska
 * @description Function Description
 * @create 2022/3/29 16:33
 */
public class InputFileTest {

    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("test.txt").getChannel()) {
            // 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从channel读 写入buffer
            channel.read(buffer);
            // buffer模式切换
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                System.out.println((char) b);
            }
        } catch (IOException exception) {
        }
    }
}
