package com.yjf.esupplier.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MySocketServer {

	private static final int PORT = 9999;
	private List<Socket> mList = new ArrayList<Socket>();
	private ServerSocket server = null;
	private ExecutorService mExecutorService = null;//線程池 

	public MySocketServer(){
		try {
			System.out.println("已经启动---server");
			server = new ServerSocket(PORT);
			mExecutorService = Executors.newCachedThreadPool();//創建一個線程pool
			Socket client = null;
			while(true){
				client = server.accept();
				mList.add(client);
				mExecutorService.execute(new ChatService(client));//執行里面的線程
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MySocketServer();
	}
	
	class ChatService implements Runnable{

		private Socket socket;
		private BufferedReader in = null;
		private String msg="";
		public ChatService(Socket socket){
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			try {
				while(true){
					String content = "";
					if((content = in.readLine()) != null){
						if(content.equals("exit")){
							//如果收到信息為"exit",則向客戶端返回ok,然后關掉socket,
							msg = "用戶IP:"+socket.getInetAddress() + " 退出后在線用戶數量：";
							this.sendmsg("ok");
							mList.remove(socket);
							in.close();socket.close();
							System.out.println(msg+ mList.size());
							break;
						}
						else{
							//打印客戶提交過來的其它信息
							msg = "客戶端IP:"+socket.getInetAddress() +" 在線用戶數量："+mList.size()+" " + content+"-"+socket.hashCode();
							System.out.println(msg);
							this.sendmsg(msg);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("server 數據讀取異常");
				e.printStackTrace();
			}
			
		}
		
		
		public void sendmsg(String message){
			int num = mList.size();
			for(int i=0;i<num;i++){
				Socket mSocket = mList.get(i);
				PrintWriter pout = null;
				try {
					pout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream())),true);
					pout.println(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
