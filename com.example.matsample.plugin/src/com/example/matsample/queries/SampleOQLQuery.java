/*
 * Copyright 2024 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.example.matsample.queries;

import org.eclipse.mat.query.IQuery;
import org.eclipse.mat.query.IResult;
import org.eclipse.mat.query.IResultTable;
import org.eclipse.mat.query.annotations.Argument;
import org.eclipse.mat.query.annotations.Category;
import org.eclipse.mat.query.annotations.Help;
import org.eclipse.mat.query.annotations.Name;
import org.eclipse.mat.snapshot.IOQLQuery;
import org.eclipse.mat.snapshot.ISnapshot;
import org.eclipse.mat.snapshot.SnapshotFactory;
import org.eclipse.mat.snapshot.query.ObjectListResult;
import org.eclipse.mat.util.IProgressListener;

@Name("Sample OQL Query")
@Category("Sample Extensions")
@Help("Execute sample OQL query\n\n")
public class SampleOQLQuery implements IQuery {
	@Argument
	public ISnapshot snapshot;

	@Override
	public IResult execute(IProgressListener listener) throws Exception {
		String oql = "SELECT dbb, dbb.capacity, snapshot.getObject(inbounds(dbb)[0]), snapshot.getObject(inbounds(dbb)[1]) FROM INSTANCEOF java.nio.DirectByteBuffer dbb WHERE ((dbb.viewedBuffer=null) AND (dbb.att=null) AND (inbounds(dbb).length>1))";
		IOQLQuery query = SnapshotFactory.createQuery(oql);
		Object result = query.execute(snapshot, listener);
		if (result instanceof int[]) {
			return new ObjectListResult.Outbound(snapshot, (int[])result);
		} else {
			return (IResultTable)result;
		}
	}
}
