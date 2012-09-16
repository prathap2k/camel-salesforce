/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.camel.component.salesforce.api;

import org.fusesource.camel.component.salesforce.api.dto.bulk.*;

import java.io.InputStream;
import java.util.List;

/**
 * Client interface for Salesforce Bulk API
 */
public interface BulkApiClient {

    /**
     * Creates a Bulk Job
     * @param jobInfo A {@link JobInfo} with required fields
     * @return a complete job description {@link JobInfo}
     * @throws RestException on error
     */
    JobInfo createJob(JobInfo jobInfo) throws RestException;

    JobInfo getJob(String jobId) throws RestException;

    JobInfo closeJob(String jobId) throws RestException;

    JobInfo abortJob(String jobId) throws RestException;

    BatchInfo createBatch(InputStream batchStream, String jobId, ContentType contentTypeEnum) throws RestException;

    BatchInfo getBatch(String jobId, String batchId) throws RestException;

    List<BatchInfo> getAllBatches(String jobId) throws RestException;

    InputStream getRequest(String jobId, String batchId) throws RestException;

    InputStream getResults(String jobId, String batchId) throws RestException;

    BatchInfo createBatchQuery(String jobId, String soqlQuery, ContentType jobContentType) throws RestException;

    List<String> getQueryResultIds(String jobId, String batchId) throws RestException;

    InputStream getQueryResult(String jobId, String batchId, String resultId) throws RestException;

}