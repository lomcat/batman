/*
 * Copyright 2018-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lomcat.batman.aide;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Kweny
 * @since 0.0.1
 */
public class StringAideTest {

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(StringAide.isEmpty(null));
        Assertions.assertTrue(StringAide.isEmpty(""));
        Assertions.assertFalse(StringAide.isEmpty(" "));
        Assertions.assertFalse(StringAide.isEmpty("bob"));
        Assertions.assertFalse(StringAide.isEmpty("  bob  "));
    }

    @Test
    public void testIsNotEmpty() {
        Assertions.assertFalse(StringAide.isNotEmpty(null));
        Assertions.assertFalse(StringAide.isNotEmpty(""));
        Assertions.assertTrue(StringAide.isNotEmpty(" "));
        Assertions.assertTrue(StringAide.isNotEmpty("bob"));
        Assertions.assertTrue(StringAide.isNotEmpty("  bob  "));
    }

    @Test
    public void testIsAllEmpty() {
        Assertions.assertTrue(StringAide.isAllEmpty((String) null));
        Assertions.assertTrue(StringAide.isAllEmpty((String[]) null));
        Assertions.assertTrue(StringAide.isAllEmpty(null, ""));
        Assertions.assertTrue(StringAide.isAllEmpty("", ""));
        Assertions.assertTrue(StringAide.isAllEmpty(new String[] {}));
        Assertions.assertFalse(StringAide.isAllEmpty(null, "foo"));
        Assertions.assertFalse(StringAide.isAllEmpty("", "bar"));
        Assertions.assertFalse(StringAide.isAllEmpty("bob", ""));
        Assertions.assertFalse(StringAide.isAllEmpty("  bob  ", null));
        Assertions.assertFalse(StringAide.isAllEmpty(" ", "bar"));
        Assertions.assertFalse(StringAide.isAllEmpty("foo", "bar"));
    }

    @Test
    public void testIsAnyEmpty() {
        Assertions.assertTrue(StringAide.isAnyEmpty((String) null));
        Assertions.assertFalse(StringAide.isAnyEmpty((String[]) null));
        Assertions.assertTrue(StringAide.isAnyEmpty(null, "foo"));
        Assertions.assertTrue(StringAide.isAnyEmpty("", "bar"));
        Assertions.assertTrue(StringAide.isAnyEmpty("bob", ""));
        Assertions.assertTrue(StringAide.isAnyEmpty("  bob  ", null));
        Assertions.assertFalse(StringAide.isAnyEmpty(" ", "bar"));
        Assertions.assertFalse(StringAide.isAnyEmpty("foo", "bar"));
        Assertions.assertFalse(StringAide.isAnyEmpty(new String[]{}));
        Assertions.assertTrue(StringAide.isAnyEmpty(new String[]{""}));
    }

    @Test
    public void testIsNoneEmpty() {
        Assertions.assertFalse(StringAide.isNoneEmpty((String) null));
        Assertions.assertTrue(StringAide.isNoneEmpty((String[]) null));
        Assertions.assertFalse(StringAide.isNoneEmpty(null, "foo"));
        Assertions.assertFalse(StringAide.isNoneEmpty("", "bar"));
        Assertions.assertFalse(StringAide.isNoneEmpty("bob", ""));
        Assertions.assertFalse(StringAide.isNoneEmpty("  bob  ", null));
        Assertions.assertTrue(StringAide.isNoneEmpty(new String[] {}));
        Assertions.assertFalse(StringAide.isNoneEmpty(new String[]{""}));
        Assertions.assertTrue(StringAide.isNoneEmpty(" ", "bar"));
        Assertions.assertTrue(StringAide.isNoneEmpty("foo", "bar"));
    }

    @Test
    public void testIsBlank() {
        Assertions.assertTrue(StringAide.isBlank(null));
        Assertions.assertTrue(StringAide.isBlank(""));
        Assertions.assertTrue(StringAide.isBlank(" "));
        Assertions.assertFalse(StringAide.isBlank("bob"));
        Assertions.assertFalse(StringAide.isBlank("  bob  "));
    }

    @Test
    public void testIsNotBlank() {
        Assertions.assertFalse(StringAide.isNotBlank(null));
        Assertions.assertFalse(StringAide.isNotBlank(""));
        Assertions.assertFalse(StringAide.isNotBlank(" "));
        Assertions.assertTrue(StringAide.isNotBlank("bob"));
        Assertions.assertTrue(StringAide.isNotBlank("  bob  "));
    }

}
