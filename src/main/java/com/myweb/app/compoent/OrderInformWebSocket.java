package com.myweb.app.compoent;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ServerEndpoint
 *
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，但在springboot中连容器都是spring管理的。
 *
 * Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
 * @author ElegantWP
 */
//WebSocket客户端建立连接的地址
@ServerEndpoint("/order/{openid}")
@Component
public class OrderInformWebSocket {

  private Logger logger = LoggerFactory.getLogger(getClass());


  private Session session;


  private static CopyOnWriteArrayList<OrderInformWebSocket> orderInformWebSockets = new CopyOnWriteArrayList<>();


  /**
   * 建立连接的回调方法
   *
   * @param openid 用户名，WebSocket支持路径参数
   */
  @OnOpen
  public void onOpen(Session session,@PathParam("openid") String openid) {
    this.session = session;
    orderInformWebSockets.add(this);
    logger.info("[websocket消息] 有新的连接，总数{}" ,orderInformWebSockets.size());
  }

  /**
   * 收到消息的回调方法
   * @param message
   */
  @OnMessage
  public void onMessage(String message) {
    logger.info("[websocket消息] 收到消息{} ：" ,message);
  }


  /**
   * 错误的回调方法
   */
  @OnClose
  public void onClose() {
    orderInformWebSockets.remove(this);
    logger.info("[websocket消息] 连接断开，总数{}" ,orderInformWebSockets.size());
  }

  /**
   * 群发消息的回调方法
   * @param message
   */
  public void sendMessage(String message){
    for (OrderInformWebSocket orderInformWebSocket : orderInformWebSockets){
      logger.info("[websocket消息] 广播消息 {}", message);
      try {
        orderInformWebSocket.session.getBasicRemote().sendText(message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }




}