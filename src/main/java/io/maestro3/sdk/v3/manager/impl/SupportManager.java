/*
 * Copyright 2024 Softline Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.manager.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.ISupportManager;
import io.maestro3.sdk.v3.model.support.SdkSupportCase;
import io.maestro3.sdk.v3.model.support.SdkSupportCategory;
import io.maestro3.sdk.v3.request.support.AddSupportCaseCommentRequest;
import io.maestro3.sdk.v3.request.support.CreateSupportCaseRequest;
import io.maestro3.sdk.v3.request.support.DescribeSupportCasesRequest;
import io.maestro3.sdk.v3.request.support.DescribeSupportCategoriesRequest;
import io.maestro3.sdk.v3.request.support.ResolveSupportCaseRequest;

import java.util.List;

public class SupportManager extends AbstractManager implements ISupportManager {
    private static final TypeReference<SdkSupportCase> CREATE_SUPPORT_CASE_RESULT = new TypeReference<SdkSupportCase>() {
    };
    private static final TypeReference<List<SdkSupportCase>> SUPPORT_CASES_RESULT = new TypeReference<List<SdkSupportCase>>() {
    };
    private static final TypeReference<List<SdkSupportCategory>> SUPPORT_CATEGORIES_RESULT = new TypeReference<>() {
    };

    public SupportManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<SdkSupportCase> createSupportCase(IPrincipal principal, CreateSupportCaseRequest request) {
        return execute(principal, request, CREATE_SUPPORT_CASE_RESULT);
    }

    @Override
    public M3Result<List<SdkSupportCase>> describeSupportCases(IPrincipal principal, DescribeSupportCasesRequest request) {
        return execute(principal, request, SUPPORT_CASES_RESULT);
    }

    @Override
    public M3Result<List<SdkSupportCategory>> describeSupportCategories(IPrincipal principal, DescribeSupportCategoriesRequest request) {
        return execute(principal, request, SUPPORT_CATEGORIES_RESULT);
    }

    @Override
    public M3Result<Void> addSupportCaseComment(IPrincipal principal, AddSupportCaseCommentRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> resolveSupportCase(IPrincipal principal, ResolveSupportCaseRequest request) {
        return execute(principal, request, VOID_RESULT);
    }
}
