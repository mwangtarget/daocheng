// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: BookMaster.proto

package com.daocheng.master.book;

public interface CreateDeskRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CreateDeskRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * For example: "entities/desk".
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  java.lang.String getParent();
  /**
   * <pre>
   * For example: "entities/desk".
   * </pre>
   *
   * <code>string parent = 1;</code>
   */
  com.google.protobuf.ByteString
      getParentBytes();

  /**
   * <code>.Desk desk = 2;</code>
   */
  boolean hasDesk();
  /**
   * <code>.Desk desk = 2;</code>
   */
  com.daocheng.master.book.Desk getDesk();
  /**
   * <code>.Desk desk = 2;</code>
   */
  com.daocheng.master.book.DeskOrBuilder getDeskOrBuilder();
}
