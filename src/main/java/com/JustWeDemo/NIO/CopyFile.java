package com.JustWeDemo.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * 练习NIO
 */
public class CopyFile {

    /**
     * 通过NIO方式复制文件
     *
     * @param src
     * @param resultSrc
     * @throws IOException
     */
    public void copyFileByNIO(String src, String resultSrc) throws IOException {
        // 1.声明源文件和目标文件
        FileInputStream fileInputStream = new FileInputStream(new File(src));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(resultSrc));
        // 2.获得传输通道channel
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        // 3.获得容器buffer
        // Buffer的容量，位置，上限（Buffer Capacity, Position and Limit）
        ByteBuffer buffer = ByteBuffer.allocate(1024);// 1024字节
        while (true) {
            // 判断是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            // 重设一下buffer的position=0，limit=position
            // flip()方法可以吧Buffer从写模式切换到读模式。
            // 调用flip方法会把position归零，并设置limit为之前的position的值。
            // 也就是说，现在position代表的是读取位置，limit标示的是已写入的数据位置。
            buffer.flip();
            // 开始写
            outChannel.write(buffer);
            // 写完要重置buffer，重设position=0,limit=capacity
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }

}
