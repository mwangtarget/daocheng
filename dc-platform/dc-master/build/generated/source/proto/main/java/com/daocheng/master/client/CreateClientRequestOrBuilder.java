// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientMaster.proto

package com.daocheng.master.client;

public interface CreateClientRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CreateClientRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string parent = 1;</code>
   */
  java.lang.String getParent();
  /**
   * <code>string parent = 1;</code>
   */
  com.google.protobuf.ByteString
      getParentBytes();

  /**
   * <pre>
   * The Book resource to be created. Client must not set the `Book.name` field.
   * </pre>
   *
   * <code>.Client client = 2;</code>
   */
  boolean hasClient();
  /**
   * <pre>
   * The Book resource to be created. Client must not set the `Book.name` field.
   * </pre>
   *
   * <code>.Client client = 2;</code>
   */
  com.daocheng.master.client.Client getClient();
  /**
   * <pre>
   * The Book resource to be created. Client must not set the `Book.name` field.
   * </pre>
   *
   * <code>.Client client = 2;</code>
   */
  com.daocheng.master.client.ClientOrBuilder getClientOrBuilder();
}
