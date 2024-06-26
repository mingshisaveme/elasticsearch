/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */
package org.elasticsearch.xpack.esql.core.execution.search;

import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * An interface for something that needs to extract field(s) from a result.
 */
public interface FieldExtraction {

    /**
     * Add whatever is necessary to the {@link SearchSourceBuilder}
     * in order to fetch the field. This can include tracking the score,
     * {@code _source} fields, doc values fields, and script fields.
     */
    void collectFields(QlSourceBuilder sourceBuilder);

    /**
     * Is this aggregation supported in an "aggregation only" query
     * ({@code true}) or should it force a scroll query ({@code false})?
     */
    boolean supportedByAggsOnlyQuery();
}
