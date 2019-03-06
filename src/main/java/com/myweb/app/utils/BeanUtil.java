package com.myweb.app.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

  private static Map<String, String> getMap(Object obj, Class<?> cls, String np) {
    Map<String, String> maps = new HashMap<>();
    if (null != cls.getSuperclass() && Object.class != cls.getSuperclass()) {
      Map<String, String> mapsSuper = getMap(obj, cls.getSuperclass(), np);
      if (null != mapsSuper && !mapsSuper.isEmpty())
        maps.putAll(mapsSuper);
    }
    try {
      Field[] fields = cls.getDeclaredFields();
      for (Field field : fields) {
        field.setAccessible(true);// 设置访问权限
        if (Modifier.isTransient(field.getModifiers())) {// 是否有transient修饰符，有的话忽略该属性
          continue;
        }
        String name = field.getName();// 属性名称
        if (name.equalsIgnoreCase("this$0") || name.equalsIgnoreCase("serialVersionUID")) {
          continue;// 内部类有this$0这个默认属性指向外部类，serialVersionUID不需要
        }
        String key = null == np ? name : np + '[' + name + ']';
        Class<?> type = field.getType();
        if (type.isPrimitive()) {// 基本类型
          Object value = field.get(obj);// 获取属性值，需要从源对象中获取
          maps.put(key, null == value ? "" : value.toString());
          continue;
        }
        Object value = field.get(obj);// 获取属性值，需要从源对象中获取
        if (null == value) {
          continue;
        }
        if (value.getClass().isArray()) {// 属性是数组类型
          int length = Array.getLength(value);
          for (int i = 0; i < length; i++) {
            Object objItem = Array.get(value, i);
            Map<String, String> mapItem = getMap(objItem, objItem.getClass(), key + '[' + i + ']');
            if (null != mapItem && !mapItem.isEmpty())
              maps.putAll(mapItem);
          }
          continue;
        }
        if (value instanceof List) {// 属性是List类型
          List<Object> p = (List) value;
          for (int i = 0; i < p.size(); i++) {
            Object objItem = p.get(i);
            Map<String, String> mapItem = getMap(objItem, objItem.getClass(), key + '[' + i + ']');
            if (null != mapItem && !mapItem.isEmpty())
              maps.putAll(mapItem);
          }
          continue;
        }
        if (value instanceof Map) {// 属性是Map类型
          Map<Object, Object> p = (Map) value;
          for (Map.Entry entry : p.entrySet()) {
            String tn = entry.getValue().getClass().getName();// 判断Map的Value对象类型，基础类型直接加入Maps
            if (tn.startsWith("java.lang.")) {
              if ("java.lang.Object".equals(tn)) {
                Map<String, String> mapField = getMap(entry.getValue(), entry.getValue().getClass(), key + '[' + entry.getKey() + ']');
                if (null != mapField && !mapField.isEmpty())
                  maps.putAll(mapField);
                continue;
              }
              maps.put(key + '[' + entry.getKey() + ']', null == entry.getValue() ? "" : entry.getValue().toString());
              continue;
            }
            Map<String, String> mapItem = getMap(entry.getValue(), entry.getValue().getClass(), key + '[' + entry.getKey() + ']');
            if (null != mapItem && !mapItem.isEmpty())
              maps.putAll(mapItem);
          }
          continue;
        }
        if (type.getName().startsWith("java.lang.")) {// 基本类型封装类，String
          if ("java.lang.Object".equals(type.getName())) {
            Map<String, String> mapField = getMap(value, value.getClass(), key);
            if (null != mapField && !mapField.isEmpty())
              maps.putAll(mapField);
            continue;
          }
          maps.put(key, null == value ? "" : value.toString());
          continue;
        }
        if (type.getName().equals("java.util.Date")) {// 日期时间类型
          // TODO 日期时间类型需要自定义格式
          maps.put(key, value.toString());
          continue;
        }
        Map<String, String> mapField = getMap(value, value.getClass(), key);// 属性是自定义类型
        if (null != mapField && !mapField.isEmpty())
          maps.putAll(mapField);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return maps;
  }

  public static Map<String, String> getParamsMap(Object obj) {
    if (null == obj) {
      return null;
    }
    Map<String, String> map = getMap(obj, obj.getClass(), null);
    return map;
  }


}
