/*
 * Copyright 2018-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lomcat.batman.aide.string;

/**
 * @author Kweny
 * @since 0.0.1
 */
public class InternalString_01_Bedrock {

    protected static final int STRING_BUILDER_SIZE = 256;

    /**
     * 一个空格字符
     */
    public static final String SPACE = " ";

    /**
     * 一个空字符串 {@code ""}
     */
    public static final String EMPTY = "";

    /**
     * 一个换行符 {@code "\n"}
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF: Escape Sequences for Character and String Literals</a>
     */
    public static final String LF = "\n";

    /**
     * 一个回车符 {@code "\r"}
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.6">JLF: Escape Sequences for Character and String Literals</a>
     */
    public static final String CR = "\r";

    /**
     * <p>获取一个字符序列 {@link CharSequence} 的长度，如果字符序列为 {@code null} 则返回 {@code 0}。</p>
     *
     * @param input 要检查的字符序列，可以为 {@code null}
     * @return 指定字符序列的长度，如果字符序列为 {@code null} 则返回 {@code 0}
     */
    public static int length(final CharSequence input) {
        return input == null ? 0 : input.length();
    }

}