package com.tronze.study;

import android.os.AsyncTask;
import android.os.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Tronze on 2017-06-02.
 */

public class NetworkConnection extends AsyncTask {

    private  Socket socket;
    private  InputStream is;
    private  OutputStream os;
    private  DataInputStream dis;
    private  DataOutputStream dos;

    String user_name;
    String user_img;
    ChatAdpater chatAdapter;

    private String tempUser;
    private String msgg;
    private String user_type;

    private UserInfo tempUserInfo;

    android.os.Handler mHandler = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0) {
                //Message Appear
                chatAdapter.inputItem(tempUserInfo);
                chatAdapter.refreshList();
            }
        }
    };

    public NetworkConnection(String user_name, String user_img, ChatAdpater chatAdapter) {
        this.user_name = user_name;
        this.user_img = user_img;
        this.chatAdapter = chatAdapter;
    }

    public void ConnectToNetwork(String user_name) {
        try {
            socket = new Socket("54.202.215.97", 8000);
            if (socket != null) {
                Connection(user_name);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Connection(final String user_name) {
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendMessage(user_name);
        sendMessage(user_img);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        user_type = dis.readUTF();
                        tempUser = dis.readUTF();
                        msgg = dis.readUTF();
                        user_img = dis.readUTF();
                        tempUserInfo = new UserInfo(Integer.parseInt(user_type), tempUser, msgg,  user_img);
                        mHandler.sendEmptyMessage(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            dis.close();
                            dos.close();
                            is.close();
                            os.close();
                            socket.close();
                            msgg = "Disconnected";
                            user_type = "3";
                            mHandler.sendEmptyMessage(0);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });

        th.start();

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        ConnectToNetwork(user_name);
        return null;
    }
}
