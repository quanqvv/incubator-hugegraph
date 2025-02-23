/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph.backend.store;

import com.alipay.remoting.rpc.RpcServer;
import com.baidu.hugegraph.HugeGraph;
import com.baidu.hugegraph.config.HugeConfig;
import com.baidu.hugegraph.event.EventHub;
import com.baidu.hugegraph.event.EventListener;

public interface BackendStoreProvider {

    // Backend store type
    String type();

    // Backend store version
    String version();

    // Graph name (that's database name)
    String graph();

    BackendStore loadSystemStore(HugeConfig config, String name);

    BackendStore loadSchemaStore(HugeConfig config, String name);

    BackendStore loadGraphStore(HugeConfig config, String name);

    void open(String name);

    void waitReady(RpcServer rpcServer);

    void close();

    void init();

    void clear();

    void truncate();

    void initSystemInfo(HugeGraph graph);

    void createSnapshot();

    void resumeSnapshot();

    void listen(EventListener listener);

    void unlisten(EventListener listener);

    EventHub storeEventHub();

    void onCloneConfig(HugeConfig config, String newGraph);

    void onDeleteConfig(HugeConfig config);
}
