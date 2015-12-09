/*
 *  Copyright 2003-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.collections15.buffer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.collections15.ArrayStack;
import org.apache.commons.collections15.Buffer;
import org.apache.commons.collections15.collection.TestTransformedCollection;

/**
 * Extension of {@link TestBuffer} for exercising the {@link TransformedBuffer}
 * implementation.
 *
 * @author Matt Hall, John Watkinson, Stephen Colebourne
 * @version $Revision: 1.1 $ $Date: 2005/10/11 17:05:44 $
 * @since Commons Collections 3.0
 */
public class TestTransformedBuffer extends TestCase {

    public TestTransformedBuffer(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(TestTransformedBuffer.class);
    }

    public static void main(String args[]) {
        String[] testCaseName = {TestTransformedBuffer.class.getName()};
        junit.textui.TestRunner.main(testCaseName);
    }

    public void testTransformedBuffer() {
        Buffer buffer = TransformedBuffer.decorate(new ArrayStack(), TestTransformedCollection.STRING_TO_INTEGER_TRANSFORMER);
        assertEquals(0, buffer.size());
        Object[] els = new Object[]{"1", "3", "5", "7", "2", "4", "6"};
        for (int i = 0; i < els.length; i++) {
            buffer.add(els[i]);
            assertEquals(i + 1, buffer.size());
            assertEquals(true, buffer.contains(new Integer((String) els[i])));
            assertEquals(false, buffer.contains(els[i]));
        }

        assertEquals(false, buffer.remove(els[0]));
        assertEquals(true, buffer.remove(new Integer((String) els[0])));

    }
}
