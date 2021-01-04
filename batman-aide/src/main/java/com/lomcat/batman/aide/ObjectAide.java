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

/**
 * TODO-Kweny ObjectAide
 *
 * @author Kweny
 * @since 0.0.1
 */
public class ObjectAide {

    public static boolean isNull(final CharSequence input) {
        return input == null;
    }

    public static boolean isNotNull(final CharSequence input) {
        return !isNull(input);
    }

    public static boolean isAllNull(final CharSequence... inputs) {
        if (ArrayAide.isEmpty(inputs)) {
            return true;
        }
        for (CharSequence input : inputs) {
            if (!isNull(input)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyNull(final CharSequence... inputs) {
        if (ArrayAide.isEmpty(inputs)) {
            return false;
        }
        for (CharSequence input : inputs) {
            if (isNull(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoneNull(final CharSequence... inputs) {
        return !isAnyNull(inputs);
    }
}
