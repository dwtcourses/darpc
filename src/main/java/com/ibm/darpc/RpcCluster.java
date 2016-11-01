/*
 * DaRPC: Data Center Remote Procedure Call
 *
 * Author: Patrick Stuedi <stu@zurich.ibm.com>
 *
 * Copyright (C) 2016, IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ibm.darpc;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.disni.rdma.verbs.*;
import com.ibm.disni.rdma.*;

public class RpcCluster<R extends RpcMessage, T extends RpcMessage> extends RdmaCqProcessor<RpcEndpoint<R,T>>{
	private static final Logger logger = LoggerFactory.getLogger("com.ibm.darpc");
	
	public RpcCluster(IbvContext context, int cqSize, int wrSize, long affinity, int clusterId,
			int timeout, boolean polling) throws IOException {
		super(context, cqSize, wrSize, affinity, clusterId, timeout, polling);
	}
	
	@Override
	public void dispatchCqEvent(RpcEndpoint<R,T> endpoint, IbvWC wc) throws IOException {
		endpoint.dispatchCqEvent(wc);
	}	
}
