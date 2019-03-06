package com.myweb.app.compoent;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
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
 */
@ServerEndpoint("/{openid}") //WebSocket客户端建立连接的地址
@Component
public class OrderInform{

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 存活的session集合（使用线程安全的map保存）
   */
  private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

  /**
   * 建立连接的回调方法
   *
   * @param session  与客户端的WebSocket连接会话
   * @param openid 用户名，WebSocket支持路径参数
   */
  @OnOpen
  public void onOpen(Session session, @PathParam("openid") String openid) {
    logger.info(openid+"建立连接成功，关注订单信息");
  }

  /**
   * 收到客户端消息的回调方法
   *
   * @param message 客户端传过来的消息
   * @param session 对应的session
   */
  @OnMessage
  public void onMessage(String message, Session session, @PathParam("openid") String openid) {
    sendMessageToAll(openid + " : " + message);
  }


  /**
   * 发生错误的回调方法
   *
   * @param session
   * @param error
   */
  @OnError
  public void onError(Session session, Throwable error) {
    logger.info("建立连接发生错误");
    error.printStackTrace();
  }


  /**
   * 关闭连接的回调方法
   */
  @OnClose
  public void onClose(Session session, @PathParam("openid") String openid) {
    livingSessions.remove(session.getId());
    sendMessageToAll(openid + "即将开始订单 ");
  }


  /**
   * 单独发送消息
   *
   * @param session
   * @param message
   */
  private void sendMessage(Session session, String message) {
    try {
      session.getBasicRemote().sendText(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 群发消息
   *
   * @param message
   */
  private void sendMessageToAll(String message) {
    livingSessions.forEach((sessionId, session) -> {
      sendMessage(session, message);
    });
  }

}