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
package com.example.matsample;

import org.eclipse.mat.snapshot.extension.IClassSpecificNameResolver;
import org.eclipse.mat.snapshot.extension.Subject;
import org.eclipse.mat.snapshot.model.IObject;

@Subject("com.example.SomeClass")
public class SampleResolver implements IClassSpecificNameResolver {
    @Override
    public String resolve(IObject object) {
        try {
            IObject someField = (IObject) object.resolveValue("someField");
            return someField == null ? null : someField.getClassSpecificName();
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
}
